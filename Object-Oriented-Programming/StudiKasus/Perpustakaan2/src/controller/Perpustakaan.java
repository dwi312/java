package controller;

import java.util.Scanner;
import service.AnggotaService;
import service.BukuService;
import service.TransaksiService;
import util.PerpusUtil;
import view.PerpustakaanView;

public class Perpustakaan {
    private Scanner input = new Scanner(System.in);
    private boolean exit = false;
    private int pilihan;

    private PerpustakaanView view = new PerpustakaanView();
    private BukuService buku = new BukuService();
    private AnggotaService anggota = new AnggotaService();
    private TransaksiService transaksi = new TransaksiService(buku, anggota);

    public void run() {
        initDummyData();

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
                buku.tambahBuku(input);
                PerpusUtil.enterToContinue(input);
                saveDummyData();
                break;

            case 2:
                PerpusUtil.clearScreen();
                anggota.tambahAnggota(input);
                PerpusUtil.enterToContinue(input);
                saveDummyData();
                break;

            case 3:
                PerpusUtil.clearScreen();
                buku.tampilDaftarBuku();
                PerpusUtil.enterToContinue(input);
                break;

            case 4:
                PerpusUtil.clearScreen();
                anggota.tampilDaftarAnggota();
                PerpusUtil.enterToContinue(input);
                break;

            case 5:
                PerpusUtil.clearScreen();
                transaksi.pinjamBuku(input);
                PerpusUtil.enterToContinue(input);
                saveDummyData();
                break;

            case 6:
                PerpusUtil.clearScreen();
                transaksi.kembalikanBuku(input);
                PerpusUtil.enterToContinue(input);
                saveDummyData();
                break;

            case 7:
                PerpusUtil.clearScreen();
                transaksi.riwayatPinjam();
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

    // Di PerpustakaanController.java
    private void initDummyData() {
        anggota.loadData("lib/anggota.txt");
        buku.loadData("lib/buku.txt");
        transaksi.loadData("lib/transaksi.txt");
    }

    private void saveDummyData() {
        anggota.saveData("lib/anggota.txt");
        buku.saveData("lib/buku.txt");
        transaksi.saveData("lib/transaksi.txt");
    }

}
