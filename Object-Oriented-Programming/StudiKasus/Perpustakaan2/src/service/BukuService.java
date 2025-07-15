package service;

import java.util.Scanner;

import model.Buku;
import util.PerpusUtil;

public class BukuService {
    private Scanner input = new Scanner(System.in);
    private Buku[] daftarBuku = new Buku[10];

    public int cariIndex(String kodeBuku) {
        for (int i = 0; i < daftarBuku.length; i++) {
            if (daftarBuku[i] != null && daftarBuku[i].getKodeBuku().equalsIgnoreCase(kodeBuku)) {
                return i;
            }
        }
        return -1;
    }

    public boolean cekArr() {
        for (int i = 0; i < daftarBuku.length; i++) {
            if (daftarBuku[i] != null) {
                return true;
            }
        }
        return false;
    }

    public void tambahBuku() {
        String kodeBuku;
        String judul;
        String penulis;
        String status;
        
        if (cekArr()) {
            System.out.println("Maaf penyimpanan sudah penuh. tidak bisa menambah buku");
            return;
        }

        int index = -1;

        for (int i = 0; i < daftarBuku.length; i++) {
            if (daftarBuku[i] == null) {
                index = i;
                break;
            }
        }
        
        boolean kodeDupe;
        
        do {
            System.out.print("Masukan Kode Buku: ");
            kodeBuku = PerpusUtil.inputStr(input);
            
            kodeDupe = false;

            for (int i = 0; i < daftarBuku.length; i++) {
                if (daftarBuku[i] != null && daftarBuku[i].getKodeBuku().equalsIgnoreCase(kodeBuku)) {
                    kodeDupe = true;
                    System.out.println("Kode buku sudah terdaftar. silahkan masukan kode lain.");
                    break;
                }
            }
        } while (kodeDupe);
        
        System.out.print("Masukan Judul Buku: ");
        judul = PerpusUtil.inputStr(input);

        System.out.print("Masukan Nama Penulis: ");
        penulis = PerpusUtil.inputStr(input);
        
        
        
        System.out.println(index);
        daftarBuku[index] = new Buku(kodeBuku, judul, penulis);

        System.out.println("Buku: " + judul + " berhasil disimpan.");

    }

    public void tampilkanSemuaBuku() {
        if (!cekArr()) {
            System.out.println("Data masih kosong");
            return;
        }

        for (int i = 0; i < daftarBuku.length; i++) {
            if (daftarBuku[i] != null) {
                System.out.println((i+1)+ ". " + daftarBuku[i]);
            }
        }
    }





}
