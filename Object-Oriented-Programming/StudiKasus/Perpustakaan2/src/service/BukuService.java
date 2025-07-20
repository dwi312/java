package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import model.Buku;
import util.PerpusUtil;

public class BukuService {
    private Buku[] daftarBuku = new Buku[50];

    public boolean cekArr() {
        for (int i = 0; i < daftarBuku.length; i++) {
            if (daftarBuku[i] != null) {
                return true;
            }
        }
        return false;
    }

    public Buku cariBuku(String data) {
        for (int i = 0; i < daftarBuku.length; i++) {
            if (daftarBuku[i] != null && 
                (daftarBuku[i].getKodeBuku().equalsIgnoreCase(data) || 
                 daftarBuku[i].getJudul().equalsIgnoreCase(data))) {
                
                return daftarBuku[i];
            }
        }
        return null;
    }

    private String generateKodeBuku() {
        int count = 0;
        for (int i = 0; i < daftarBuku.length; i++) {
            if (daftarBuku[i] != null) {
                count++;
            }
        }
        return "B" + String.format("%03d", count + 1);
    }

    public void tambahBuku(Scanner input) {
        String kodeBuku;
        String judul;
        String penulis;
        String status;

        int slot = PerpusUtil.cariIndex(daftarBuku);
        if (slot == -1) {
            System.out.println("Maaf penyimpanan sudah penuh. tidak bisa menambah buku");
            return;
        }

        boolean judulDupe;

        do {
            System.out.print("Masukan Judul Buku: ");
            judul = PerpusUtil.inputStr(input);

            judulDupe = false;

            if (cariBuku(judul) != null) {
                judulDupe = true;
                System.out.println("Judul Buku sudah terdaftar.");
                continue;
            }
        } while (judulDupe);

        System.out.print("Masukan Nama Penulis: ");
        penulis = PerpusUtil.inputStr(input);

        kodeBuku = generateKodeBuku();
        daftarBuku[slot] = new Buku(kodeBuku, judul, penulis);
        System.out.println("Buku: " + judul + " berhasil disimpan.");
        System.out.println("Kode Buku: " + kodeBuku);
        System.out.println("Tanggal Registrasi: " + LocalDate.now());

    }

    public void tampilDaftarBuku() {
        if (!cekArr()) {
            System.out.println("Data masih kosong");
            return;
        }

        System.out.println("\n ==============================   DAFTAR BUKU   ====================================");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.printf("%-4s | %-6s | %-31s | %-20s | %-10s |\n", "No", "Kode", "Judul", "Penulis", "Status");
        System.out.println("-------------------------------------------------------------------------------------");

        int no = 1;
        for (int i = 0; i < daftarBuku.length; i++) {
            if (daftarBuku[i] != null) {
                System.out.printf("%-4d | %-6s | %-31s | %-20s | %-10s |\n",
                        no++,
                        daftarBuku[i].getKodeBuku(),
                        daftarBuku[i].getJudul(),
                        daftarBuku[i].getPenulis(),
                        daftarBuku[i].getStatus());
            }
        }
        System.out.println("-------------------------------------------------------------------------------------");
    }

    public void bukuTersedia() {
        if (!cekArr()) {
            System.out.println("Tidak ada buku yang tersedia saat ini.");
            return;
        }

        System.out.println("\n=================        DAFTAR BUKU TERSEDIA        =================");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-4s | %-6s | %-31s | %-20s |\n", "No", "Kode", "Judul", "Penulis");
        System.out.println("-----------------------------------------------------------------------");

        int no = 1;
        for (int i = 0; i < daftarBuku.length; i++) {
            if (daftarBuku[i] != null && daftarBuku[i].getStatus().equalsIgnoreCase("Tersedia")) {
                System.out.printf("%-4d | %-6s | %-31s | %-20s |\n",
                        no++,
                        daftarBuku[i].getKodeBuku(),
                        daftarBuku[i].getJudul(),
                        daftarBuku[i].getPenulis());
            }
        }
        System.out.println("-----------------------------------------------------------------------");
    }

    public String pilihBuku(Scanner input) {
        // Buat mapping nomor urut ke index sebenarnya
        int[] indexMaping = new int[daftarBuku.length];
        int count = 0;

        for (int i = 0; i < daftarBuku.length; i++) {
            if (daftarBuku[i] != null && daftarBuku[i].getStatus().equalsIgnoreCase("Tersedia")) {
                indexMaping[count] = i;
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Tidak ada buku yang tersedia.");
            return "";
        }

        int pilihan;
        while (true) {
            System.out.print("Pilih nomor yang tersedia: ");
            pilihan = PerpusUtil.inputInt(input);

            if (pilihan >= 1 && pilihan <= count) {
                int realIndex = indexMaping[pilihan - 1];
                Buku buku = daftarBuku[realIndex];
                buku.setStatus("Dipinjam");

                System.out.println("Kode Buku: " + buku.getKodeBuku() + " telah dipinjam ");
                return buku.getKodeBuku();
            } else {
                System.out.println("Nomor tidak valid.");
            }
        }
    }

    public String kembaliBuku(Scanner input) {
        int[] indexMaping = new int[daftarBuku.length];
        int count = 0;

        for (int i = 0; i < daftarBuku.length; i++) {
            if (daftarBuku[i] != null && daftarBuku[i].getStatus().equalsIgnoreCase("Dipinjam")) {
                indexMaping[count] = i;
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Tidak ada buku yang dipinjam.");
            return "";
        }

        int pilihan;
        while (true) {
            System.out.println("\n--- Daftar Buku yang Dipinjam ---");
            System.out.println("---------------------------------------------------------------------------");
            System.out.printf("%-2s | %-5s | %-35s | %-25s |\n", "No", "ID", "Judul", "Penulis");
            System.out.println("---------------------------------------------------------------------------");

            for (int i = 0; i < count; i++) {
                Buku buku = daftarBuku[indexMaping[i]];
                System.out.printf("%-2d | %-5s | %-35s | %-25s |\n",
                        (i + 1),
                        buku.getKodeBuku(),
                        buku.getJudul(),
                        buku.getPenulis());
            }
            System.out.println("---------------------------------------------------------------------------");

            System.out.print("Pilih nomor yang tersedia: ");
            pilihan = PerpusUtil.inputInt(input);

            if (pilihan >= 1 && pilihan <= count) {
                int realIndex = indexMaping[pilihan - 1];
                Buku buku = daftarBuku[realIndex];
                buku.setStatus("Tersedia");

                System.out.println("Kode Buku: " + buku.getKodeBuku() + " telah dikembalikan.");
                return buku.getKodeBuku();
            } else {
                System.out.println("Nomor tidak valid.");
            }
        }
    }

    public void tampilBukuDipinjam() {
        int[] indexMaping = new int[daftarBuku.length];
        int count = 0;

        for (int i = 0; i < daftarBuku.length; i++) {
            if (daftarBuku[i] != null && daftarBuku[i].getStatus().equalsIgnoreCase("Dipinjam")) {
                indexMaping[count] = i;
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Tidak ada buku yang sedang dipinjam.");
            return;
        }

        System.out.println("\n================= DAFTAR BUKU DIPINJAM =================");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("%-4s | %-6s | %-30s | %-20s |\n", "No", "Kode", "Judul", "Penulis");
        System.out.println("--------------------------------------------------------------------------------");

        for (int i = 0; i < count; i++) {
            Buku buku = daftarBuku[indexMaping[i]];
            System.out.printf("%-4d | %-6s | %-30s | %-20s |\n",
                    (i + 1),
                    buku.getKodeBuku(),
                    buku.getJudul(),
                    buku.getPenulis());
        }
        System.out.println("--------------------------------------------------------------------------------");
    }

    public void loadData(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int nextIndex = PerpusUtil.cariIndex(daftarBuku);

            while ((line = reader.readLine()) != null && nextIndex != -1) {
                String[] parts = line.split("\\|");

                if (parts.length >= 3) {
                    String kodeBuku = parts[0].trim();
                    String judul = parts[1].trim();
                    String penulis = parts[2].trim();
                    String status = "Tersedia";

                    if (parts.length >= 4) {
                        status = parts[3].trim();
                    }

                    daftarBuku[nextIndex] = new Buku(kodeBuku, judul, penulis);
                    daftarBuku[nextIndex].setStatus(status);
                    System.out.println("Line: " + line);
                    System.out.println("Parts: " + Arrays.toString(parts));
                    nextIndex = PerpusUtil.cariIndex(daftarBuku);
                }
            }
            System.out.println("Data Buku selesai dimuat.");
        } catch (Exception e) {
            System.out.println("Gagal memuat data: " + e.getMessage());
        }
    }

    public void saveData(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < daftarBuku.length; i++) {
                if (daftarBuku[i] != null) {
                    writer.write(daftarBuku[i].getKodeBuku() + "|" +
                            daftarBuku[i].getJudul() + "|" +
                            daftarBuku[i].getPenulis() + "|" +
                            daftarBuku[i].getStatus());
                    writer.newLine();
                }
            }
            System.out.println("Data buku berhasil disimpan ke file.");

        } catch (Exception e) {
            System.out.println("Gagal menyimpan data buku: " + e.getMessage());
        }
    }

}
