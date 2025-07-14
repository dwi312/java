package src.controller;

import java.util.Scanner;

import src.model.Siswa;
import src.util.Util;
import src.view.SiswaView;

public class SiswaController {
    private Scanner input = new Scanner(System.in);
    private boolean exit = false;
    private int pilihan;

    private SiswaView view = new SiswaView();
    private Siswa[] daftarSiswa = new Siswa[5];

    public void run() {
        while (!exit) {
            view.menu();
            pilihan = Util.inputInt(input);
            exit = menuPilihan(pilihan);
        }
        System.out.println("Program berhenti. terimakasih");
        input.close();
    }

    public boolean menuPilihan(int pilihan) {
        switch (pilihan) {
            case 1:
                Util.clearScreen();
                System.out.println("\n=== Tambah Siswa ===");
                tambahSiswa();
                Util.enterToContinue(input);
                break;

            case 2:
                Util.clearScreen();
                System.out.println("\n=== Daftar Siswa ===");
                tampilkanSemua();
                Util.enterToContinue(input);
                break;

            case 3:
                Util.clearScreen();
                System.out.println("\n=== Ubah Data Siswa ===");
                ubahSiswa();
                Util.enterToContinue(input);
                break;

            case 4:
                Util.clearScreen();
                System.out.println("\n=== Hapus Siswa ===");
                hapusSiswa();
                Util.enterToContinue(input);
                break;

            case 5:
                Util.clearScreen();
                System.out.println("\n=== Cari Siswa ===");
                cariSiswa();
                Util.enterToContinue(input);
                break;

            case 6:
                exit = true;
                break;

            default:
                System.out.println("Pilihan tidak valid! pilih 1-6");
                break;
        }
        System.out.println();
        return exit;
    }

    public void tambahSiswa() {
        String nama;
        String nim;
        int nilai;
        int index = -1;

        for (int i = 0; i < daftarSiswa.length; i++) {
            if (daftarSiswa[i] == null) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Maaf, sudah tidak bisa menambah siswa.");
            return;
        }

        System.out.print("Masukkan Nama Siswa  : ");
        nama = Util.inputStr(input);

        boolean nimDupe;
        do {
            System.out.print("Masukkan NIM         : ");
            nim = Util.inputStr(input);

            nimDupe = false;
            for (int i = 0; i < daftarSiswa.length; i++) {
                if (daftarSiswa[i] != null && daftarSiswa[i].getNim().equalsIgnoreCase(nim)) {
                    nimDupe = true;
                    System.out.println("NIM sudah terdaftar.");
                    break;
                }
            }
        } while (nimDupe);

        boolean nilaiValid;
        do {
            System.out.print("Masukkan Nilai       : ");
            nilai = Util.inputInt(input);

            nilaiValid = true;
            if (nilai < 0 || nilai > 100) {
                nilaiValid = false;
                System.out.println("Rentang nilai harus antara 0 sampai 100.");
            }
        } while (!nilaiValid);

        daftarSiswa[index] = new Siswa(nama, nim, nilai);

        System.out.println("Siswa " + nama + " berhasil ditambah.");
    }

    public void tampilkanSemua() {
        if (!cekArr()) {
            System.out.println("Data masih kosong.");
            return;
        }

        for (int i = 0; i < daftarSiswa.length; i++) {
            if (daftarSiswa[i] != null) {
                System.out.print((i + 1) + ". ");
                daftarSiswa[i].tampilkanInfo();
            }
        }
    }

    public void ubahSiswa() {
        if (!cekArr()) {
            System.out.println("Data masih kosong.");
            return;
        }

        String nim;
        System.out.print("Masukkan NIM yang ingin diubah: ");
        nim = Util.inputStr(input);

        int index = cariIndex(nim);

        if (index == -1) {
            System.out.print("NIM: " + nim + " tidak ditemukan.");
            return;
        }

        String nama = daftarSiswa[index].getNama();
        System.out.print("Masukkan Nama Baru  : ");
        nama = Util.inputStr(input);

        int nilai = daftarSiswa[index].getNilai();
        System.out.print("Masukkan Nilai Baru  : ");
        nilai = Util.inputInt(input);

        daftarSiswa[index] = new Siswa(nama, nim, nilai);
        System.out.println("Data siswa berhasil diperbarui.");

    }

    public void hapusSiswa() {
        if (!cekArr()) {
            System.out.println("Data masih kosong.");
            return;
        }

        String nim;
        System.out.print("Masukkan NIM yang ingin dihapus: ");
        nim = Util.inputStr(input);

        int index = cariIndex(nim);

        if (index == -1) {
            System.out.print("NIM: " + nim + " tidak ditemukan.");
            return;
        }

        for (int i = index; i < daftarSiswa.length - 1; i++) {
            daftarSiswa[i] = daftarSiswa[i + 1];
        }

        daftarSiswa[daftarSiswa.length - 1] = null;

        System.out.println("Data siswa berhasil dihapus.");

    }

    public void cariSiswa() {
        if (!cekArr()) {
            System.out.println("Data masih kosong.");
            return;
        }

        String nim;
        System.out.print("Masukkan NIM yang dicari: ");
        nim = Util.inputStr(input);

        for (int i = 0; i < daftarSiswa.length; i++) {
            if (daftarSiswa[i] != null && daftarSiswa[i].getNim().equalsIgnoreCase(nim)) {
                System.out.println("Siswa ditemukan:");
                System.out.println("Nama  : " + daftarSiswa[i].getNama());
                System.out.println("NIM   : " + daftarSiswa[i].getNim());
                System.out.println("Nilai : " + daftarSiswa[i].getNilai());
            }
        }

    }

    public int cariIndex(String nim) {
        for (int i = 0; i < daftarSiswa.length; i++) {
            if (daftarSiswa[i] != null && daftarSiswa[i].getNim().equalsIgnoreCase(nim)) {
                return i;
            }
        }

        return -1;
    }

    public boolean cekArr() {
        boolean cek = false;
        for (int i = 0; i < daftarSiswa.length; i++) {
            if (daftarSiswa[i] != null) {
                cek = true;
            }
        }
        return cek;
    }

}
