package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import model.Buku;
import util.PerpusUtil;

public class BukuService {
    private Buku[] daftarBuku = new Buku[10];
    private int index = 0;

    public int cariIndex() {
        for (int i = 0; i < daftarBuku.length; i++) {
            if (daftarBuku[i] == null) {
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

    public Buku cariBuku(String kodeBuku) {
        for (int i = 0; i < index; i++) {
            if (daftarBuku[i].getKodeBuku().equalsIgnoreCase(kodeBuku)) {
                return daftarBuku[i];
            }
        }
        return null;
    }

    public void tambahBuku(Scanner input) {
        index = cariIndex();

        String kodeBuku;
        String judul;
        String penulis;
        String status;

        if (index == -1) {
            System.out.println("Maaf penyimpanan sudah penuh. tidak bisa menambah buku");
            return;
        }

        boolean kodeDupe;

        do {
            System.out.print("Masukan Kode Buku: ");
            kodeBuku = PerpusUtil.inputStr(input);

            kodeDupe = false;

            for (int i = 0; i < daftarBuku.length; i++) {
                if (cariBuku(kodeBuku) != null) {
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

        daftarBuku[index] = new Buku(kodeBuku, judul, penulis);
        index++;
        System.out.println("Buku: " + judul + " berhasil disimpan.");

    }

    public void tampilDaftarBuku() {
        if (!cekArr()) {
            System.out.println("Data masih kosong");
            return;
        }

        // Header tabel
        System.out.println();
        System.out.println(" -------------------------------------------------------------------------------------------"); // Sesuaikan panjang garis
        System.out.printf("%-1s | %-5s | %-35s | %-25s | %-12s |\n", "No", "id", "Judul", "Penulis", "Status");
        System.out.println(" -------------------------------------------------------------------------------------------"); // Sesuaikan panjang garis
        
        for (int i = 0; i < daftarBuku.length; i++) {
            if (daftarBuku[i] != null) {
                System.out.printf("%-2d | %-5s | %-35s | %-25s | %-12s |\n",
                    (i + 1),
                    daftarBuku[i].getKodeBuku(),
                    daftarBuku[i].getJudul(),
                    daftarBuku[i].getPenulis(),
                    "[" + daftarBuku[i].getStatus() + "]");
            }
        }
    }

    public void bukuTersedia() {
        if (!cekArr()) {
            System.out.println("Tidak ada buku yang tersedia saat ini.");
            return;
        }

        System.out.println("\n--- Daftar Buku yang Tersedia ---");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("%-2s | %-5s | %-35s | %-25s |\n", "No", "ID", "Judul", "Penulis");
        System.out.println("---------------------------------------------------------------------------");

        int num = 0;
        for (int i = 0; i < daftarBuku.length; i++) {
            if (daftarBuku[i] != null && daftarBuku[i].getStatus().equalsIgnoreCase("Tersedia")) {
                num++;
                System.out.printf("%-2d | %-5s | %-35s | %-25s |\n",
                    num,
                    daftarBuku[i].getKodeBuku(),
                    daftarBuku[i].getJudul(),
                    daftarBuku[i].getPenulis());
            }

            if (num == 0) {
                System.out.println("Tidak ada buku yang tersedia untuk dipinjam saat ini.");
            }
        }
        System.out.println("---------------------------------------------------------------------------");
    }

    public String pilihBuku(Scanner input) {
        String kodeBukuSementara = "";
        boolean numValid;
        do {
            System.out.print("Pilih nomor yang tersedia: ");
            int num = PerpusUtil.inputInt(input);
            
            numValid = false;
            for (int i = 0; i < daftarBuku.length; i++) {
                if (daftarBuku[num].getStatus().equalsIgnoreCase("Tersedia")) {
                    kodeBukuSementara =  daftarBuku[num].getKodeBuku();
                } else {
                    numValid = true;
                    System.out.println("Pilihan: " + num +" tidak valid.");
                    break;
                }
            }
        } while (numValid);

        return kodeBukuSementara;
    }

    public void loadData(String filePath){
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            int nextIndex = cariIndex();

            while((line = reader.readLine()) != null && index < daftarBuku.length) {
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
                    this.index = nextIndex +1;
                    nextIndex = cariIndex(); 
                }
            }
            System.out.println("Data Buku selesai dimuat.");
        } catch (Exception e) {
            System.out.println("Gagal memuat data: " + e.getMessage());
        }
    }

    public Buku bukuDipinjam() {
        for (int i = 0; i < daftarBuku.length; i++) {
            if (daftarBuku[i].getStatus().equalsIgnoreCase("Dipinjam")) {
                return daftarBuku[i];
            }
        }
        return null;
    }

}
