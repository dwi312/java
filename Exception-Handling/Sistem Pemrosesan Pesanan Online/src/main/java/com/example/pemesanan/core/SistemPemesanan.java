package com.example.pemesanan.core;

import java.util.Random;

import com.example.pemesanan.exception.DatabaseConnectionException;
import com.example.pemesanan.exception.InvalidEmailAddressException;
import com.example.pemesanan.exception.KoneksiGatewayPembayaranGagalException;
import com.example.pemesanan.exception.MailServerUnavailableException;
import com.example.pemesanan.exception.PembayaranDitolakException;
import com.example.pemesanan.exception.ProdukTidakDitemukanException;
import com.example.pemesanan.exception.StokTidakCukupException;

public class SistemPemesanan {
    public boolean validasiStok(String produkId, int jumlah) throws ProdukTidakDitemukanException, StokTidakCukupException {
        System.out.println("Memvalidasi stok untuk produk " + produkId + "...");
        int stok = Inventaris.getStok(produkId);

        if(stok == 0) {
            if (!produkId.equals("P001") && !produkId.equals("P002") && !produkId.equals("P003")) {
                 throw new ProdukTidakDitemukanException("Produk dengan ID " + produkId + " tidak ditemukan.");
            }
        }

        if (stok < jumlah) {
            throw new StokTidakCukupException("Stok tidak cukup untuk produk " + produkId + ". Tersedia: " + stok + ", Diminta: " + jumlah);
        }
        System.out.println("Stok produk " + produkId + " cukup.");
        return true;
    }

    public boolean validasiPembayaran(String infoPembayaran) throws KoneksiGatewayPembayaranGagalException, PembayaranDitolakException {
        System.out.println("Memvalidasi pembayaran...");
        Random rand = new Random();

        if (infoPembayaran.equals("FAIL_KONEKSI")) {
            throw new KoneksiGatewayPembayaranGagalException("Gagal terhubung ke gateway pembayaran.");
        }
        if (infoPembayaran.equals("DITOLAK")) {
            throw new PembayaranDitolakException("Pembayaran Anda ditolak oleh bank/gateway.");
        }
        if (rand.nextInt(100) < 5) { // 5% kemungkinan koneksi gagal secara acak
            throw new KoneksiGatewayPembayaranGagalException("Koneksi ke gateway pembayaran putus secara acak.");
        }

        System.out.println("Pembayaran berhasil divalidasi.");
        return true;
    }

    public void catatTransaksi(String orderId, String produkId, int jumlah) throws DatabaseConnectionException {
        System.out.println("Mencatat transaksi pesanan " + orderId + " ke database...");
        Random rand = new Random();

        if (orderId.equals("DB_ERROR")) {
            throw new DatabaseConnectionException("Gagal terhubung ke database pesanan.");
        }

        if (rand.nextInt(100) < 3) { // 3% kemungkinan terjadi masalah integritas/locking
            // Ini bisa berupa OptimisticLockingException atau SQLIntegrityConstraintViolationException
            // Untuk studi kasus ini kita simulasikan dengan RuntimeException
            throw new RuntimeException("Terjadi masalah integritas data atau optimistic locking saat mencatat transaksi.");
        }

        System.out.println("Transaksi pesanan " + orderId + " berhasil dicatat.");
    }

    public void kirimNotifikasi(String emailPelanggan, String orderId) throws MailServerUnavailableException, InvalidEmailAddressException {
        System.out.println("Mengirim notifikasi pesanan " + orderId + " ke " + emailPelanggan + "...");
        Random rand = new Random();

        if (emailPelanggan.contains("invalid")) {
            throw new InvalidEmailAddressException("Alamat email tidak valid: " + emailPelanggan);
        }
        if (rand.nextInt(100) < 10) { // 10% kemungkinan mail server tidak tersedia
            throw new MailServerUnavailableException("Server email tidak dapat dijangkau.");
        }
        System.out.println("Notifikasi pesanan " + orderId + " berhasil dikirim.");
    }

    public void prosesPesanan(String orderId, String produkId, int jumlah, String infoPembayaran, String emailPelanggan) {
        System.out.println("\n--- Memulai Pemrosesan Pesanan: " + orderId + " ---");

        // 1. Validasi Stok
        try {
            validasiStok(produkId, jumlah);
        } catch (ProdukTidakDitemukanException e) {
            System.err.println("PENTING: " + e.getMessage());
            System.err.println("Proses pesanan " + orderId + " dihentikan: Produk tidak valid.");
            return; // Hentikan proses
        } catch (StokTidakCukupException e) {
            System.err.println("PENTING: " + e.getMessage());
            System.err.println("Proses pesanan " + orderId + " dihentikan: Stok tidak mencukupi.");
            return; // Hentikan proses
        }

        // 2. Validasi Pembayaran
        try {
            validasiPembayaran(infoPembayaran);
        } catch (KoneksiGatewayPembayaranGagalException e) {
            System.err.println("PENTING: " + e.getMessage());
            System.err.println("Proses pesanan " + orderId + " dihentikan: Gagal melakukan pembayaran. Silakan coba lagi nanti.");
            return; // Hentikan proses
        } catch (PembayaranDitolakException e) {
            System.err.println("PENTING: " + e.getMessage());
            System.err.println("Proses pesanan " + orderId + " dihentikan: Pembayaran ditolak. Mohon periksa detail Anda.");
            return; // Hentikan proses
        } finally {
            // Ini akan selalu dieksekusi setelah validasi pembayaran, misalnya untuk menutup koneksi gateway
            System.out.println("DEBUG: Selesai dengan operasi pembayaran (blok finally).");
        }

        // 3. Pengurangan Stok dan Pencatatan Transaksi (dalam satu blok try-finally untuk rollback)
        try {
            Inventaris.kurangiStok(produkId, jumlah); // Ini bisa melempar ProdukTidakDitemukanException atau StokTidakCukupException juga
            catatTransaksi(orderId, produkId, jumlah);
            System.out.println("Pesanan " + orderId + " berhasil diproses sepenuhnya.");

        } catch (StokTidakCukupException | ProdukTidakDitemukanException e) { // Ini seharusnya sudah ditangani di awal, tapi untuk jaga-jaga
            System.err.println("ERROR KRITIS: Terjadi masalah stok setelah validasi awal! " + e.getMessage());
            // Log this: Ini mengindikasikan bug dalam logika
        } catch (DatabaseConnectionException e) {
            System.err.println("ERROR KRITIS: " + e.getMessage());
            System.err.println("Proses pesanan " + orderId + " gagal dicatat. Mengembalikan stok...");
            // Log ke sistem monitoring
            // *Mekanisme Rollback/Kompensasi stok seharusnya ada di sini*
            try {
                Inventaris.kurangiStok(produkId, -jumlah); // Mengembalikan stok (simulasi)
                System.out.println("Stok produk " + produkId + " berhasil dikembalikan.");
            } catch (Exception ex) {
                System.err.println("GAGAL MENGEMBALIKAN STOK! Perlu intervensi manual untuk produk " + produkId + ". " + ex.getMessage());
            }
            return;
        } catch (RuntimeException e) { // Menangkap Unchecked Exception seperti OptimisticLockingException / SQL Integrity
            System.err.println("ERROR KRITIS: Terjadi kesalahan internal saat mencatat transaksi. " + e.getMessage());
            System.err.println("Proses pesanan " + orderId + " gagal dicatat. Mengembalikan stok...");
            // Log ke sistem monitoring
            // *Mekanisme Rollback/Kompensasi stok seharusnya ada di sini*
             try {
                Inventaris.kurangiStok(produkId, -jumlah); // Mengembalikan stok (simulasi)
                System.out.println("Stok produk " + produkId + " berhasil dikembalikan.");
            } catch (Exception ex) {
                System.err.println("GAGAL MENGEMBALIKAN STOK! Perlu intervensi manual untuk produk " + produkId + ". " + ex.getMessage());
            }
            return;
        }

        // 4. Pengiriman Notifikasi (Opsional, tidak menghentikan pesanan jika gagal)
        try {
            kirimNotifikasi(emailPelanggan, orderId);
        } catch (MailServerUnavailableException e) {
            System.err.println("PERINGATAN: " + e.getMessage());
            System.err.println("Notifikasi pesanan " + orderId + " tidak dapat dikirim saat ini. Akan dicoba ulang nanti.");
            // Log error, tambahkan ke queue untuk retry
        } catch (InvalidEmailAddressException e) {
            System.err.println("PERINGATAN: " + e.getMessage());
            System.err.println("Notifikasi pesanan " + orderId + " tidak dapat dikirim karena alamat email tidak valid.");
            // Log error, tidak perlu retry
        } finally {
            System.out.println("DEBUG: Selesai dengan operasi notifikasi (blok finally).");
        }

        System.out.println("--- Pemrosesan Pesanan: " + orderId + " SELESAI ---");
    }

}
