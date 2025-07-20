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

    private PerpustakaanView view = new PerpustakaanView(this);
    private BukuService buku = new BukuService();
    private AnggotaService anggota = new AnggotaService();
    private TransaksiService transaksi = new TransaksiService(buku, anggota);

    public void run() {
        initDummyData();

        while (!exit) {
            view.menu();
            pilihan = PerpusUtil.inputInt(input);
            exit = view.menuPilihan(pilihan);
        }
        System.out.println("Program berhenti. Terimakasih");
        input.close();
    }

    private void initDummyData() {
        anggota.loadData("data/anggota.txt");
        buku.loadData("data/buku.txt");
        transaksi.loadData("data/transaksi.txt");
    }

    private void saveDummyData() {
        anggota.saveData("data/anggota.txt");
        buku.saveData("data/buku.txt");
        transaksi.saveData("data/transaksi.txt");
    }

    public void tambahBuku() {
        PerpusUtil.clearScreen();
        buku.tambahBuku(input);
        PerpusUtil.enterToContinue(input);
        saveDummyData();
    }

    public void tambahAnggota() {
        PerpusUtil.clearScreen();
        anggota.tambahAnggota(input);
        PerpusUtil.enterToContinue(input);
        saveDummyData();
    }

    public void tampilDaftarBuku() {
        PerpusUtil.clearScreen();
        buku.tampilDaftarBuku();
        PerpusUtil.enterToContinue(input);
    }

    public void tampilDaftarAnggota() {
        PerpusUtil.clearScreen();
        anggota.tampilDaftarAnggota();
        PerpusUtil.enterToContinue(input);
    }

    public void pinjamBuku() {
        PerpusUtil.clearScreen();
        transaksi.pinjamBuku(input);
        PerpusUtil.enterToContinue(input);
        saveDummyData();
    }

    public void kembalikanBuku() {
        PerpusUtil.clearScreen();
        transaksi.kembalikanBuku(input);
        PerpusUtil.enterToContinue(input);
        saveDummyData();
    }

    public void riwayatPinjam() {
        PerpusUtil.clearScreen();
        transaksi.riwayatPinjam();
        PerpusUtil.enterToContinue(input);
    }

}
