package controller;

import java.util.Scanner;

import service.BukuService;
import util.PerpusUtil;
import view.PerpustakaanView;

public class Perpustakaan {
    private Scanner input = new Scanner(System.in);
    private boolean exit = false;
    private int pilihan;
    
    private PerpustakaanView view = new PerpustakaanView();
    private BukuService buku = new BukuService();

    public void run(){
        while (!exit) {
            view.menu();
            pilihan = PerpusUtil.inputInt(input);
            exit = menuPilihan(pilihan);
        }
        System.out.println("Program berhenti. Terimakasih");
        input.close();
    }

    public boolean menuPilihan(int pilihan) {
        switch (pilihan) {
            case 1:
                PerpusUtil.clearScreen();
                System.out.println("\n=== Tambah Buku ===");
                buku.tambahBuku();
                PerpusUtil.enterToContinue(input);
                break;

            case 2:
                PerpusUtil.clearScreen();
                System.out.println("\n=== Tambah Anggota ===");

                PerpusUtil.enterToContinue(input);
                break;

            case 3:
                PerpusUtil.clearScreen();
                System.out.println("\n=== Daftar Buku ===");
                buku.tampilkanSemuaBuku();
                PerpusUtil.enterToContinue(input);
                break;

            case 4:
                PerpusUtil.clearScreen();
                System.out.println("\n=== Daftar Anggota ===");
                
                PerpusUtil.enterToContinue(input);
                break;

            case 5:
                PerpusUtil.clearScreen();
                System.out.println("\n=== Pinjam Buku ===");
                
                PerpusUtil.enterToContinue(input);
                break;
            
            case 6:
                PerpusUtil.clearScreen();
                System.out.println("\n=== Kembalikan Buku ===");
                
                PerpusUtil.enterToContinue(input);
                break;

            case 7:
                PerpusUtil.clearScreen();
                System.out.println("\n=== Riwayat Peminjaman ===");
                
                PerpusUtil.enterToContinue(input);
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
