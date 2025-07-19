package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import model.Anggota;
import model.Buku;
import model.Transaksi;
import util.PerpusUtil;

public class TransaksiService {
    private Transaksi[] daftarTransaksi = new Transaksi[50];

    private BukuService bukuService;
    private AnggotaService anggotaService;

    public TransaksiService(BukuService bukuService, AnggotaService anggotaService) {
        this.bukuService = bukuService;
        this.anggotaService = anggotaService;
    }

    public boolean cekArr() {
        for (int i = 0; i < daftarTransaksi.length; i++) {
            if (daftarTransaksi[i] != null) {
                return true;
            }
        }
        return false;
    }

    public Transaksi cariTransaksi(String data) {
        for (int i = 0; i < daftarTransaksi.length; i++) {
            if (daftarTransaksi[i] != null && (daftarTransaksi[i].getIdTransaksi().equalsIgnoreCase(data) ||
                    daftarTransaksi[i].getIdAnggota().equalsIgnoreCase(data) ||
                    daftarTransaksi[i].getKodeBuku().equalsIgnoreCase(data))) {
                return daftarTransaksi[i];
            }
        }
        return null;
    }

    private String generateIdTransaksi() {
        int count = 0;
        for (int i = 0; i < daftarTransaksi.length; i++) {
            if (daftarTransaksi[i] != null) {
                count++;
            }
        }
        return "TR" + String.format("%03d", count + 1);
    }

    public void pinjamBuku(Scanner input) {
        int slot = PerpusUtil.cariIndex(daftarTransaksi);

        if (bukuService.cekArr() == false) {
            System.out.println("Daftar buku kosong.");
            return;
        }

        if (anggotaService.cekArr() == false) {
            System.out.println("Belum ada Anggota terdaftar.");
            return;
        }

        System.out.print("Masukkan ID Anggota Peminjam: ");
        String idAnggota = PerpusUtil.inputStr(input);
        Anggota anggota = anggotaService.cariAnggota(idAnggota);

        if (anggota == null) {
            System.out.println("ID Anggota: " + idAnggota + " belum terdaftar.");
            return;
        }

        int jumlahPinjam = 0;
        for (int i = 0; i < daftarTransaksi.length; i++) {
            if (daftarTransaksi[i] != null &&
                    daftarTransaksi[i].getIdAnggota().equals(idAnggota) &&
                    daftarTransaksi[i].getTanggalKembali() == null) {
                jumlahPinjam++;
            }
        }

        if (jumlahPinjam >= 2) {
            System.out.println("Batas peminjam hanya 2 buku.");
            return;
        }

        bukuService.bukuTersedia();
        String kodeBuku = bukuService.pilihBuku(input);

        if (kodeBuku.isEmpty()) {
            System.out.println("Tidak ada buku yang dipinjam.");
            return;
        }

        LocalDate tanggalPinjam = LocalDate.now();
        LocalDate tanggalKembali = null;
        String idTransaksi = generateIdTransaksi();

        System.out.println("Buku berhasil dipinjam.");
        System.out.println("Tanggal: " + tanggalPinjam);

        daftarTransaksi[slot] = new Transaksi(idTransaksi, idAnggota, kodeBuku, tanggalPinjam, tanggalKembali);

    }

    public void kembalikanBuku(Scanner input) {
        System.out.print("Masukkan ID / Nama Anggota Peminjam: ");
        String dataAnggota = PerpusUtil.inputStr(input);

        Anggota anggota = anggotaService.cariAnggota(dataAnggota);
        if (anggota == null) {
            System.out.println("Anggota: " + dataAnggota + " Tidak ditemukan.");
            return;
        }

        String idAnggota = anggota.getIdAnggota();

        Transaksi[] pinjaman = new Transaksi[daftarTransaksi.length];
        int count = 0;

        for (int i = 0; i < daftarTransaksi.length; i++) {
            if (daftarTransaksi[i] != null &&
                    daftarTransaksi[i].getIdAnggota().equalsIgnoreCase(idAnggota) &&
                    daftarTransaksi[i].getTanggalKembali() == null) {
                pinjaman[count] = daftarTransaksi[i];
                count++;
            }
        }

        if (count == 0) {
            PerpusUtil.clearScreen();
            System.out.println("Nama Anggota         : " + anggota.getNama());
            System.out.println("ID Anggota           : " + idAnggota);
            System.out.println();
            String msg = "Sementara ini tidak ada buku yang dipinjam.";
            System.out.println("Buku yang dipinjam   : " + msg);
            return;
        }

        PerpusUtil.clearScreen();
        System.out.println();
        System.out.println("Nama Anggota : " + anggota.getNama());
        System.out.println("ID Anggota   : " + idAnggota);
        System.out.println();
        System.out.println("Daftar Buku Dipinjam:");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.printf("%-2s | %-8s | %-10s | %-35s | %-15s |\n", "No", "IDTRX", "Kode Buku", "Judul",
                "Tanggal Pinjam");
        System.out.println("------------------------------------------------------------------------------------");

        for (int i = 0; i < count; i++) {
            Buku buku = bukuService.cariBuku(pinjaman[i].getKodeBuku());
            System.out.printf("%-2d | %-8s | %-10s | %-35s | %-15s |\n",
                    (i + 1),
                    pinjaman[i].getIdTransaksi(),
                    buku.getKodeBuku(),
                    buku.getJudul(),
                    pinjaman[i].getTanggalPinjam());
        }
        System.out.println("------------------------------------------------------------------------------------");

        int pilihan;
        while (true) {
            System.out.print("Pilih nomor buku yang akan dikembalikan: ");
            pilihan = PerpusUtil.inputInt(input);
            if (pilihan >= 1 && pilihan <= count)
                break;
            System.out.println("Pilihan tidak valid.");
        }

        Transaksi trx = pinjaman[pilihan - 1];
        Buku bukuKembali = bukuService.cariBuku(trx.getKodeBuku());

        bukuKembali.setStatus("Tersedia");
        trx.setTanggalKembali(LocalDate.now());

        System.out.println("\nBuku '" + bukuKembali.getJudul() + "' berhasil dikembalikan.");
        System.out.println("Tanggal pengembalian: " + trx.getTanggalKembali());
    }

    public void riwayatPinjam() {
        if (!cekArr()) {
            System.out.println("Belum ada anggota yang meminjam buku.");
            return;
        }

        System.out.println("\n=======================       RIWAYAT PEMINJAMAN       ========================");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("%-4s | %-8s | %-10s | %-10s | %-15s | %-15s |\n",
                "No", "ID TRX", "ID Anggota", "Kode Buku", "Tanggal Pinjam", "Tanggal Kembali");
        System.out.println("-------------------------------------------------------------------------------");

        int no = 1;
        for (int i = 0; i < daftarTransaksi.length; i++) {
            if (daftarTransaksi[i] != null) {
                System.out.printf("%-4d | %-8s | %-10s | %-10s | %-15s | %-15s |\n",
                        no++,
                        daftarTransaksi[i].getIdTransaksi(),
                        daftarTransaksi[i].getIdAnggota(),
                        daftarTransaksi[i].getKodeBuku(),
                        (daftarTransaksi[i].getTanggalPinjam() != null
                                ? daftarTransaksi[i].getTanggalPinjam()
                                : "-"),
                        (daftarTransaksi[i].getTanggalKembali() != null
                                ? daftarTransaksi[i].getTanggalKembali()
                                : "-"));
            }
        }
        System.out.println("-------------------------------------------------------------------------------");
    }

    public void loadData(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int nextIndex = PerpusUtil.cariIndex(daftarTransaksi);

            while ((line = reader.readLine()) != null && nextIndex != -1) {
                String[] parts = line.split("\\|");
                if (parts.length >= 4) {
                    LocalDate pinjam = LocalDate.parse(parts[3].trim());
                    LocalDate kembali = (parts.length >= 5 && !parts[4].trim().isEmpty())
                            ? LocalDate.parse(parts[4].trim())
                            : null;
                    daftarTransaksi[nextIndex] = new Transaksi(parts[0].trim(), parts[1].trim(),
                            parts[2].trim(), pinjam, kembali);
                    nextIndex = PerpusUtil.cariIndex(daftarTransaksi);
                }
            }
        } catch (IOException e) {
            System.out.println("Gagal memuat data transaksi: " + e.getMessage());
        }
    }

    public void saveData(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Transaksi trx : daftarTransaksi) {
                if (trx != null) {
                    writer.write(trx.getIdTransaksi() + "|" +
                            trx.getIdAnggota() + "|" +
                            trx.getKodeBuku() + "|" +
                            trx.getTanggalPinjam() + "|" +
                            (trx.getTanggalKembali() != null ? trx.getTanggalKembali() : ""));
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data transaksi: " + e.getMessage());
        }
    }

}
