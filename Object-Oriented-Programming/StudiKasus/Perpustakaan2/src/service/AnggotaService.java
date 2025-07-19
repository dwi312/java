package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Scanner;
import model.Anggota;
import util.PerpusUtil;

public class AnggotaService {
    private Anggota[] daftarAnggota = new Anggota[50];

    public boolean cekArr() {
        for (int i = 0; i < daftarAnggota.length; i++) {
            if (daftarAnggota[i] != null) {
                return true;
            }
        }
        return false;
    }

    public Anggota cariAnggota(String data) {
        for (int i = 0; i < daftarAnggota.length; i++) {
            if (daftarAnggota[i] != null && (daftarAnggota[i].getIdAnggota().equalsIgnoreCase(data) ||
                    daftarAnggota[i].getNama().equalsIgnoreCase(data))) {
                return daftarAnggota[i];
            }
        }
        return null;
    }

    private String generateIdAnggota() {
        int count = 0;
        for (int i = 0; i < daftarAnggota.length; i++) {
            if (daftarAnggota[i] != null) {
                count++;
            }
        }
        return "B" + String.format("%03d", count + 1);
    }

    public void tambahAnggota(Scanner input) {
        int slot = PerpusUtil.cariIndex(daftarAnggota);

        String idAnggota;
        String nama;
        String kontak;

        if (slot == -1) {
            System.out.println("Maaf penyimpanan sudah penuh. tidak bisa menambah Anggota");
            return;
        }

        boolean namaDupe;

        do {
            System.out.print("Masukan Nama Anggota: ");
            nama = PerpusUtil.inputStr(input);

            namaDupe = false;
            if (cariAnggota(nama) != null) {
                namaDupe = true;
                System.out.println("ID sudah terdaftar. silahkan masukan ID lain.");
                continue;
            }
        } while (namaDupe);

        System.out.print("Masukan Kontak Anggota: ");
        kontak = PerpusUtil.inputStr(input);

        idAnggota = generateIdAnggota();
        daftarAnggota[slot] = new Anggota(idAnggota, nama, kontak);
        System.out.println("Nama: " + nama + " berhasil didaftarkan.");
        System.out.println("ID Anggota: " + idAnggota);
        System.out.println("Tanggal Registrasi: " + LocalDate.now());
    }

    public void tampilDaftarAnggota() {
        if (!cekArr()) {
            System.out.println("Data masih kosong");
            return;
        }

        // Header tabel
        System.out.println("\n =========================   DAFTAR ANGGOTA  =============================");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("%-4s | %-10s | %-30s | %-20s |\n", "No", "ID", "Nama", "Kontak");
        System.out.println("---------------------------------------------------------------------------");

        int no = 1;
        for (int i = 0; i < daftarAnggota.length; i++) {
            if (daftarAnggota[i] != null) {
                System.out.printf("%-4d | %-10s | %-30s | %-20s |\n",
                        no++,
                        daftarAnggota[i].getIdAnggota(),
                        daftarAnggota[i].getNama(),
                        daftarAnggota[i].getKontak());
            }
        }
        System.out.println("---------------------------------------------------------------------------");
    }

    public void loadData(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int nextIndex = PerpusUtil.cariIndex(daftarAnggota);

            while ((line = reader.readLine()) != null && nextIndex != -1) {
                String[] parts = line.split("\\|");

                if (parts.length == 3) {
                    daftarAnggota[nextIndex] = new Anggota(
                            parts[0].trim(),
                            parts[1].trim(),
                            parts[2].trim());
                    nextIndex = PerpusUtil.cariIndex(daftarAnggota);
                }
            }
            System.out.println("Data Anggota selesai dimuat.");
        } catch (Exception e) {
            System.out.println("Gagal memuat data: " + e.getMessage());
        }
    }

    public void saveData(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < daftarAnggota.length; i++) {
                if (daftarAnggota[i] != null) {
                    writer.write(daftarAnggota[i].getIdAnggota() + "|" +
                            daftarAnggota[i].getNama() + "|" +
                            daftarAnggota[i].getKontak());
                    writer.newLine();
                }
            }
            System.out.println("Data anggota berhasil disimpan ke file.");

        } catch (Exception e) {
            System.out.println("Gagal menyimpan data buku: " + e.getMessage());
        }
    }

}
