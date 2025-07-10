import java.util.Scanner;

public class NilaiSiswaApp2D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        NilaiSiswa2D nilaiSiswa = new NilaiSiswa2D();

        for(boolean berhenti = false; !berhenti;) {
            menu();
            int pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    nilaiSiswa.inputNilai(input);
                    break;
                case 2:
                    nilaiSiswa.tabelNilai();;
                    break;
                case 3:
                    nilaiSiswa.totalSiswa();
                    break;
                case 4:
                    nilaiSiswa.rataRataSiswa();
                    break;
                case 5:
                    System.out.print("Masukkan nilai yang dicari: ");
                    int cari = input.nextInt();
                    nilaiSiswa.cariNilai(cari);
                    break;
                case 0:
                    System.out.println("Program berhenti.");
                    berhenti = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
            
            System.out.println();
        }
        input.close();
    }

    public static void menu() {
        System.out.println("=== MENU PROGRAM NILAI SISWA 2D ===");
        System.out.println("1. Input Nilai");
        System.out.println("2. Tampilkan Tabel Nilai");
        System.out.println("3. Hitung Total per Siswa");
        System.out.println("4. Hitung Rata-rata per Siswa");
        System.out.println("5. Cari Nilai");
        System.out.println("6. Urutkan Nilai Setiap Siswa");
        System.out.println("0. Keluar");
        System.out.print("Pilihan: ");

    }

}
