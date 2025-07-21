package com.example.pemesanan;

import com.example.pemesanan.core.SistemPemesanan;

public class Main {
    public static void main(String[] args) {
        SistemPemesanan sistem = new SistemPemesanan();

        // Skenario Sukses
        sistem.prosesPesanan("ORD001", "P001", 1, "KARTU_OK", "pelanggan1@example.com");

        // Skenario: Stok Tidak Cukup
        sistem.prosesPesanan("ORD002", "P002", 10, "KARTU_OK", "pelanggan2@example.com");

        // Skenario: Produk Tidak Ditemukan
        sistem.prosesPesanan("ORD003", "P004", 1, "KARTU_OK", "pelanggan3@example.com");

        // Skenario: Pembayaran Ditolak
        sistem.prosesPesanan("ORD004", "P001", 1, "DITOLAK", "pelanggan4@example.com");

        // Skenario: Koneksi Gateway Pembayaran Gagal
        sistem.prosesPesanan("ORD005", "P001", 1, "FAIL_KONEKSI", "pelanggan5@example.com");

        // Skenario: Database Error saat Mencatat Transaksi (dengan rollback stok simulasi)
        sistem.prosesPesanan("ORD006", "P003", 2, "KARTU_OK", "pelanggan6@example.com"); // Stok P003: 20 -> 18
        sistem.prosesPesanan("DB_ERROR", "P003", 2, "KARTU_OK", "pelanggan7@example.com"); // Akan gagal catat, stok dikembalikan 18 -> 20

        // Skenario: Notifikasi Gagal (tetapi pesanan tetap berhasil)
        sistem.prosesPesanan("ORD007", "P001", 1, "KARTU_OK", "invalid_email@example.com");
    }
}
