package view;

import controller.Perpustakaan;
import util.PerpusUtil;

public class PerpustakaanView {
     private Perpustakaan perpustakaan;

    public PerpustakaanView(Perpustakaan perpustakaan) {
        this.perpustakaan = perpustakaan;
    }

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

    public boolean menuPilihan(int pilihan) {
        boolean exit = false;

        switch (pilihan) {
            case 1:
                perpustakaan.tambahBuku();
                break;

            case 2:
                perpustakaan.tambahAnggota();
                break;

            case 3:
                perpustakaan.tampilDaftarBuku();
                break;

            case 4:
                perpustakaan.tampilDaftarAnggota();
                break;

            case 5:
                perpustakaan.pinjamBuku();
                break;

            case 6:
                perpustakaan.kembalikanBuku();
                break;

            case 7:
                perpustakaan.riwayatPinjam();
                break;

            case 0:
                exit = true;
                break;

            default:
                System.out.println("Pilihan tidak valid! pilih 1-6");
                break;
        }
        System.out.println();
        return exit;
    }

}
