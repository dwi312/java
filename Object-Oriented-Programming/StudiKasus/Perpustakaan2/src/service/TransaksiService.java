package service;

import java.time.LocalDate;
import java.util.Scanner;
import model.Anggota;
import model.Buku;
import model.Transaksi;
import util.PerpusUtil;

public class TransaksiService {
    private Transaksi[] daftarTransaksi = new Transaksi[20];
    private int index = 0;

    private BukuService bukuService;
    private AnggotaService anggotaService;

    public TransaksiService(BukuService bukuService, AnggotaService anggotaService) {
        this.bukuService = bukuService;
        this.anggotaService = anggotaService;
    }

    public int cariIndex() {
        for (int i = 0; i < daftarTransaksi.length; i++) {
            if (daftarTransaksi[i] == null) {
                return index = i;
            }
        }
        return -1;
    }

    public boolean cekArr() {
        for (int i = 0; i < daftarTransaksi.length; i++) {
            if (daftarTransaksi[i] != null) {
                return true;
            }
        }
        return false;
    }

    public Transaksi cariTransaksi(String idTransaksi) {
        for (int i = 0; i < index; i++) {
            if (daftarTransaksi[i].getIdTransaksi().equalsIgnoreCase(idTransaksi)) {
                return daftarTransaksi[i];
            }
        }
        return null;
    }

    private String generateIdTransaksi() {
        return "TR" + String.format("%03d", index + 1);
    }

    public void pijamBuku(Scanner input) {
        index = cariIndex();

        if (index == -1) {
            System.out.println("Maaf, penyimpanan transaksi sudah penuh.");
            return;
        }

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
            if (daftarTransaksi[i] != null && daftarTransaksi[i].getIdAnggota().equals(idAnggota)) {
                jumlahPinjam++;
            }
        }

        if ( 2 <= jumlahPinjam) {
            System.out.println("Batas peminjam hanya 2 buku.");
            return;
        }

        bukuService.bukuTersedia();
        String kodeBuku = bukuService.pilihBuku(input);
        LocalDate tanggalPinjam = LocalDate.now();
        LocalDate tanggalKembali = null;
        String idTransaksi = generateIdTransaksi();

        System.out.println("Buku berhasil dipinjam.");
        System.out.println("Tanggal: " + tanggalPinjam);

        daftarTransaksi[index] = new Transaksi(idTransaksi, idAnggota, kodeBuku, tanggalPinjam, tanggalKembali);
        
    }

    public void kembalikanBuku(Scanner input) {
        index = cariIndex();
        int[] indexMaping = new int[daftarTransaksi.length];
        int count = 0;

        if (!cekArr()) {
            System.out.println("Belum ada anggota yang meminjam buku.");
            return;
        }

        System.out.print("Masukkan ID / Nama Anggota Peminjam: ");
        String dataAnggota = PerpusUtil.inputStr(input);
        
        Anggota anggota = anggotaService.cariAnggota(dataAnggota);
        Buku buku = bukuService.bukuDipinjam();

        LocalDate tanggalPinjamTemp = LocalDate.now();
        String idTransaksiTemp = "0";

        if (anggota == null) {
            System.out.println("Pencarian: " + dataAnggota + " tidak ditemukan.");
            return;
        }

        System.out.println("Nama: "+ anggota.getNama());
        System.out.println();
        
        System.out.println("---- Daftar Buku yang dipinjam ----");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-2s | %-5s | %-35s | %-25s | %-25s |\n", "No", "ID", "Judul", "Tanggal Pinjam", "Tanggal Kembali");
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        
        for (int i = 0; i < daftarTransaksi.length; i++) {
            if (daftarTransaksi[i] != null && anggota.getIdAnggota().equalsIgnoreCase(dataAnggota)) {
                System.out.printf("%-2d | %-5s | %-35s | %-25s | %-25s |\n",
                    (i+1),
                    daftarTransaksi[i].getIdTransaksi(),
                    bukuService.bukuDipinjam().getJudul(),
                    daftarTransaksi[i].getTanggalPinjam(),
                    daftarTransaksi[i].getTanggalKembali());
                    tanggalPinjamTemp = daftarTransaksi[i].getTanggalPinjam();
                    idTransaksiTemp = daftarTransaksi[i].getIdTransaksi();
                }
            }
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            String kodeBuku = bukuService.kembaliBuku(input);
            LocalDate tanggalPinjam = tanggalPinjamTemp;
            String idTransaksi = idTransaksiTemp;
            LocalDate tanggalKembali = LocalDate.now();
            System.out.println("Buku berhasil dikembalikan.");
            System.out.println("Tanggal: " + tanggalKembali);
            daftarTransaksi[index] = new Transaksi(idTransaksi, anggota.getIdAnggota(), kodeBuku, tanggalPinjam, tanggalKembali);
        }
        
        public void riwayatPinjam() {
            index = cariIndex();
            
            if (!cekArr()) {
                System.out.println("Belum ada anggota yang meminjam buku.");
                return;
            }
            
            System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-1s | %-5s | %-15s | %-15s | %-15s | %-15s |\n", "No", "ID Transaksi","ID Anggota", "Kode Buku", "Tanngal Pinjam", "Tanngal Kembali");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
        
        for (int i = 0; i < daftarTransaksi.length; i++) {
            if (daftarTransaksi[i] != null) {
                System.out.printf("%-2d | %-12s | %-15s | %-15s | %-15s | %-15s |\n",
                    (i + 1),
                    daftarTransaksi[i].getIdTransaksi(),
                    daftarTransaksi[i].getIdAnggota(),
                    daftarTransaksi[i].getKodeBuku(),
                    "[" + daftarTransaksi[i].getTanggalPinjam() + "]",
                    "[" + daftarTransaksi[i].getTanggalKembali() + "]");
            }
        }


    }

}
