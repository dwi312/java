package StudiKasus.tugas01;


import java.util.Scanner;

public class Controller {
    private Scanner input = new Scanner(System.in);
    private  int pilihan;
    private boolean exit;

    private Services services;

    public Controller() {
        this.services = new Services();
    }

    public void run() {
        for(exit = false; !exit;) {
            menu();
            pilihan = inputValid();
            exit = menuPilihan(pilihan);
            System.out.println();
        }
        input.close();
        System.out.println("Program berhenti. Terimakasih");
    }

    public void menu() {
        System.out.println("== APLIKASI NILAI MAHASISWA ==");
        System.out.println("1. Tambah data mahasiswa");
        System.out.println("2. Tampilkan semua data");
        System.out.println("3. Hitung rata-rata nilai");
        System.out.println("4. Cari nilai tertinggi");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu: ");
    }

    public boolean menuPilihan(int pilihan) {
        exit = false;

        switch (pilihan) {
            case 1:
                System.out.println("==== Tambah data mahasiswa ====");

                Mahasiswa mahasiswaBaru = getDataMahasiswa();
                
                if(mahasiswaBaru != null) {
                    services.tambahMahasiswa(mahasiswaBaru);
                }

                break;
            case 2:
                System.out.println("==== Tampilkan semua data ====");
                services.tampilkanData();
                break;
            case 3:
                System.out.println("==== Rata-rata nilai ====");
                services.hitungRataNilai();
                break;
            case 4:
                System.out.println("==== cari nilai tertinggi ====");
                services.cariNilaiTertinggi();
                break;
            case 5:
                exit = true;
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
        return exit;
    }

    private Mahasiswa getDataMahasiswa() {
        System.out.print("Masukan Nama: ");
        String nama = input.nextLine();
        
        boolean kosong;
        for(kosong = false; !kosong;) {
            if (nama.isEmpty()) {
                System.out.println("Nama mahasiswa tidak boleh kosong: ");
                nama = input.nextLine();            
            } else {
                kosong = true;
            }
        }
        
        System.out.print("Masukan Nilai: ");
        int nilai = inputValid();

        boolean batas;
        for(batas = false; !batas;) {
            if(nilai < 0 || nilai > 100) {
                System.out.println("Nilai harus diantara 0-100.");
                nilai = inputValid();
            } else {
                batas = true;
            }
        }

        return new Mahasiswa(nama, nilai);
    }


    public int inputValid() {
        int angka = -1;
        boolean valid;

        for(valid = false; !valid;) {
            try {
                String bukanAngka = input.nextLine();

                // Memeriksa inputan penguna (enter atau spasi)
                if(bukanAngka.trim().isEmpty()) {
                    System.out.println("Input tidak boleh kosong");
                } else {
                    // Jika tidak kosong konversi ke integer
                    angka = Integer.parseInt(bukanAngka);
                    valid = true;                
                }
            } catch (NumberFormatException e) {
                // jika string tidak bisa dikonversi jadi angka
                System.out.println("Input tidak valid! input harus angka. ");
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }
        }

        return angka;
    }

}
