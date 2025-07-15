package view;

import util.PerpusUtil;

public class PerpustakaanView {

    public void menu() {
        PerpusUtil.clearScreen();
        System.out.println("=== SISTEM PERPUSTAKAAN SEDERHANA ===");
        System.out.println();
        System.out.println("1. Tambah Buku");
        System.out.println("2. Tambah Anggota");
        System.out.println("3. Daftar Buku");
        System.out.println("4. Daftar Anggota");
        System.out.println("5. Pinjam Buku");
        System.out.println("6. Kembalikan Buku");
        System.out.println("7. Riwayat Peminjaman");
        System.out.println("0. keluar");
        System.out.println("-------------------------------------");
        System.out.print("Pilih menu: ");
    }

}
