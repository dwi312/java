import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ContactManager manager = new ContactManager();
        manager.loadData("data.txt");
        int pilihan;

        do {
            System.out.println("\n=== MENU KONTAK ===");
            System.out.println("1. Tambah Kontak");
            System.out.println("2. Lihat Semua Kontak");
            System.out.println("3. Cari Kontak");
            System.out.println("4. Hapus Kontak");
            System.out.println("5. Ubah Kontak");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukan Nama: ");
                    String nama = input.nextLine();
                    System.out.print("Masukan No Tlp: ");
                    String nomor = input.nextLine();
                    manager.tambahkontak(new Contact(nama, nomor));
                    break;
                case 2:
                    manager.lihatKontak();
                    break;
                case 3:
                    manager.cariKontak(input);
                    break;
                case 4:
                    manager.hapusKontak(input);
                    break;
                case 5:
                    System.out.print("Masukkan nomor urut kontak yang diubah: ");
                    int idxUbah = input.nextInt() - 1;
                    input.nextLine();
                    System.out.print("Nama baru: ");
                    String namaBaru = input.nextLine();
                    System.out.print("Nomor telepon baru: ");
                    String nomorBaru = input.nextLine();
                    manager.ubahKontak(idxUbah, namaBaru, nomorBaru);
                    break;
                case 0:
                    System.out.println("Program berhenti");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }

        } while (pilihan != 0);
        manager.saveData("data.txt");
    }

    public static String valdasiStr(Scanner input) {
        boolean valid = false;

        String keyword = "";

        while (!valid) {
            keyword = input.nextLine();
            if (keyword.trim().isEmpty()) {
                System.out.println("Input tidak boleh kosong.");
            } else {
                valid = true;
            }
        }
        return keyword;
    }

    public static int validasiInt(Scanner input) {
        boolean valid = false;
        int angka = -1;

        while (!valid) {
            try {
                String keyword = input.nextLine();

                if (keyword.trim().isEmpty()) {
                    System.out.println("Input tidak boleh kosong.");
                } else {
                    angka = Integer.parseInt(keyword);
                    valid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! harus angka");
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());

            }
        }
        return angka;
    }

}
