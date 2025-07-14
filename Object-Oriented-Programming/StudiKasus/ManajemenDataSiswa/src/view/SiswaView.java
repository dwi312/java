package src.view;

import java.util.Scanner;

import src.util.Util;

public class SiswaView {

    public void menu() {
        Util.clearScreen();
        System.out.println("\n=== PROGRAM MANAJEMEN DATA SISWA ===");
        System.out.println();
        System.out.println("1. Tambah Siswa");
        System.out.println("2. Tampilkan Semua Siswa");
        System.out.println("3. Ubah Data Siswa");
        System.out.println("4. Hapus Siswa");
        System.out.println("5. Cari Siswa");
        System.out.println("6. Keluar");
        System.out.println("---------------------------");
        System.out.print("Pilih menu (1-6): ");
    }

}
