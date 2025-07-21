
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
    private ArrayList<Contact> kontak = new ArrayList<>();

    public void tambahkontak(Contact c) {
        kontak.add(c);
        System.out.println("Kontak berhasil ditambah,");
    }

    public void lihatKontak() {
        if (kontak.isEmpty()) {
            System.out.println("Daftar kontak kosong");
        } else {
            System.out.println("=== Daftar Kontak ===");
            for (int i = 0; i < kontak.size(); i++) {
                System.out.println((i + 1) + ". " + kontak.get(i));
            }
        }
    }

    public void cariKontak(Scanner input) {
        boolean ditemukan = false;
        System.out.print("Masukan Nama yang dicari: ");
        String nama = Main.valdasiStr(input);

        for (Contact c : kontak) {
            if (c.getNama().toLowerCase().contains(nama.toLowerCase())) {
                System.out.println("Ditemukan: " + c);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Kontak tidak ditemukan.");
        }
    }

    public void hapusKontak(Scanner input) {
        boolean ulang = false;
        Contact kontakHapus = null;

        while (!ulang) {
            System.out.print("Masukan Nama yang akan dihapus:");
            String nama = Main.valdasiStr(input);

            for (Contact c : kontak) {
                if (c.getNama().toLowerCase().contains(nama.toLowerCase())) {
                    System.out.println("Nama: " + c);
                    kontakHapus = c;
                    break;
                }
            }

            String konfirmasi = "";
            if (kontakHapus != null) {
                System.out.println("Yakin inggin dihapus? (y / n)");
                konfirmasi = Main.valdasiStr(input);

                if (konfirmasi.equalsIgnoreCase("y")) {
                    kontak.remove(kontakHapus);
                    System.out.println("Kontak berhasil dihapus.");
                    ulang = true;
                } else {
                    System.out.println("Kontak batal dihapus.");
                    return;
                }
            } else {
                System.out.println("Kontak tidak ditemukan.");
                System.out.println("Keluar ? (y / n)");
                konfirmasi  = Main.valdasiStr(input);
                if (konfirmasi.equalsIgnoreCase("y")) {
                    ulang = true;
                }
            }
        }

    }

    public void ubahKontak(int index, String namaBaru, String nomorBaru) {
        if (index >= 0 && index < kontak.size()) {
            Contact c = kontak.get(index);
            c.setNama(namaBaru);
            c.setNomorTelepon(nomorBaru);
            System.out.println("Kontak berhasil diubah");
        } else {
            System.out.println("index tidak valid");
        }
    }

    public int getJumlahKontak() {
        return kontak.size();
    }

    public void loadData(String filePath) {
        kontak.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\-");
                if (parts.length == 2) {
                    String nama = parts[0].trim();
                    String nomorTelepon = parts[1].trim();

                    kontak.add(new Contact(nama, nomorTelepon));
                    System.out.println("Loaded: " + parts[0] + " - " + parts[1]);
                }
            }
            System.out.println("Data selesai dimuat.");
        } catch (Exception e) {
            System.out.println("Gagal memuat data: " + e.getMessage());
        }
    }

    public void saveData(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Contact c : kontak) {
                writer.write(c.getNama() + " - " + c.getNomorTelepon());
                writer.newLine();
            }
            System.out.println("Data berhasil disimpan ke file.");
        } catch (Exception e) {
            System.out.println("Gagal menyimpan data: " + e.getMessage());
        }
    }

}
