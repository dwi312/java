package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import model.Anggota;
import util.PerpusUtil;

public class AnggotaService {
    private Anggota[] daftarAnggota = new Anggota[10];
    private int index = 0;

    public int cariIndex() {
        for (int i = 0; i < daftarAnggota.length; i++) {
            if (daftarAnggota[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public boolean cekArr() {
        for (int i = 0; i < daftarAnggota.length; i++) {
            if (daftarAnggota[i] != null) {
                return true;
            }
        }
        return false;
    }

    public Anggota cariAnggota(String idAnggota) {
        for (int i = 0; i < index; i++) {
            if (daftarAnggota[i].getIdAnggota().equalsIgnoreCase(idAnggota)) {
                return daftarAnggota[i];
            }
        }
        return null;
    }

    public void tambahAnggota(Scanner input) {
        index = cariIndex();

        String idAnggota;
        String nama;
        String kontak;

        if (index == -1) {
            System.out.println("Maaf penyimpanan sudah penuh. tidak bisa menambah Anggota");
            return;
        }

        boolean idDupe;

        do {
            System.out.print("Masukan idAnggota: ");
            idAnggota = PerpusUtil.inputStr(input);
            idDupe = false;
            for (int i = 0; i < daftarAnggota.length; i++) {
                if (cariAnggota(idAnggota) != null) {
                    idDupe = true;
                    System.out.println("ID sudah terdaftar. silahkan masukan ID lain.");
                    break;
                }
            }
        } while (idDupe);

        System.out.print("Masukan Nama Anggota: ");
        nama = PerpusUtil.inputStr(input);

        System.out.print("Masukan Kontak Anggota: ");
        kontak = PerpusUtil.inputStr(input);

        daftarAnggota[index] = new Anggota(idAnggota, nama, kontak);
        index++;
        System.out.println("Nama: " + nama + " berhasil didaftarkan.");
    }

    public void tampilDaftarAnggota() {
        if (!cekArr()) {
            System.out.println("Data masih kosong");
            return;
        }

        // Header tabel
        System.out.println();
        System.out.println(" --------------------------------------------------------------------------------------"); // Sesuaikan panjang garis
        System.out.printf("%-1s | %-15s | %-35s | %-25s |\n", "No", "ID", "Nama", "Kontak");
        System.out.println(" ---------------------------------------------------------------------------------------"); // Sesuaikan panjang garis
        

        for (int i = 0; i < daftarAnggota.length; i++) {
            if (daftarAnggota[i] != null) {
                System.out.printf("%-2d | %-15s | %-35s | %-25s |\n",
                    (i + 1),
                    daftarAnggota[i].getIdAnggota(),
                    daftarAnggota[i].getNama(),
                    "[" + daftarAnggota[i].getKontak() + "]");
            }
        }
    }
    
    public void loadData(String filePath){
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = reader.readLine()) != null && index < daftarAnggota.length) {
                String[] parts = line.split("\\|");
                
                if (parts.length == 4) {
                    daftarAnggota[index] = new Anggota(
                        parts[0].trim(),
                        parts[1].trim(),
                        parts[2].trim()
                        );
                    index++;
                }
            }
            System.out.println("Data Anggota selesai dimuat.");
        } catch (Exception e) {
            System.out.println("Gagal memuat data: " + e.getMessage());
        }
    }
 
}
