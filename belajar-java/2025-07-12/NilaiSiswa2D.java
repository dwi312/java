
import java.util.Scanner;

public class NilaiSiswa2D {
    int[][] nilai;
    int jumlahSiswa;
    int jumlahMapel;

    public void inputNilai(Scanner input) {
        // TODO: input jumlah siswa dan jumlah mapel
        
        System.out.print("Masukan jumlah siswa : ");
        jumlahSiswa = input.nextInt();
        
        System.out.println();

        System.out.print("Masukan jumlah mapel : ");
        jumlahMapel = input.nextInt();
        
        // Inisialisasi array 2D setelah mendapatkan dimensi
        nilai = new int[jumlahSiswa][jumlahMapel];

        // TODO: isi array 2 dimensi nilai[siswa][mapel]

        // Loop melalui setiap siswa
        for(int i = 0; i < jumlahSiswa; i++) {
            System.out.println("Masukkan nilai untuk siswa ke-"+ (i+1) + " : ");
            
            // Loop melalui setiap mata pelajaran
            for(int j = 0; j < jumlahMapel;j++) {
                System.out.print("  Mapel ke-" + (j + 1) + " : ");
                nilai[i][j] = input.nextInt();
            }
        }
    }
    
    public void tabelNilai() {
        // TODO: tampilkan isi tabel dengan format baris-per-siswa
        System.out.println("\n--- Daftar nilai siswa ---");
        
        if (cekArray()) {
            return;
        }

        for(int i = 0; i < jumlahSiswa; i++) {
            System.out.println("Nilai siswa ke-"+ (i+1) + " : ");
            
            for(int j = 0; j < jumlahMapel;j++) {
                System.out.print("  Mapel ke-" + (j + 1) + " : ");
                System.out.print(nilai[i][j]);
                System.out.println();
            }
            System.out.println();
        }
        
    }

    public void totalSiswa() {
        // TODO: hitung dan tampilkan total nilai per siswa

        System.out.println("\n--- Total nilai siswa ---");
        System.out.println();

        if (cekArray()) {
            return;
        }
         
        for(int i = 0; i < jumlahSiswa; i++) {
            double totalNilai = 0;
            for(int j = 0; j < jumlahMapel; j++) {
                totalNilai += nilai[i][j];
            }
            System.out.println("Siswa ke-"+(i+1)+" : " + totalNilai);
        }
    }
    
    public void rataRataSiswa() {
        // TODO: hitung dan tampilkan rata-rata nilai per siswa
        System.out.println("\n--- Rata-rata nilai siswa ---");
        System.out.println();
        if (cekArray()) {
            return;
        }

        for(int i = 0; i < jumlahSiswa; i++) {
            double totalNilai = 0;
            double rataRata = 0;
            for(int j = 0; j < jumlahMapel; j++) {
                totalNilai += nilai[i][j];
            }
            rataRata = totalNilai / jumlahMapel;
            System.out.println("Nilai Rata-rata siswa ke-"+(i+1)+" : " + rataRata);
        }
    }

    public void cariNilai(int cari) {
       // TODO: cari nilai dalam array, tampilkan posisinya jika ada
        System.out.println("\n--- Mencari nilai siswa ---");
        System.out.println();

        if(cekArray()) {
            return;
        }

        boolean ditemukan = false;
        for(int i = 0; i < jumlahSiswa; i++) {
            for(int j = 0; j < jumlahMapel; j++) {
                if(nilai[i][j] == cari) {
                    System.out.println("Nilai " + cari + " ditemukan pada Siswa ke-" + (i + 1) + ", Mapel ke-" + (j + 1) + ".");
                    ditemukan = true;
                }
            }
        }

        if(!ditemukan) {
            System.out.println("Nilai " + cari + " tidak ditemukan dalam data.");
        }
    }

    public void urutkanNilaiPerSiswa() {
        // (opsional lanjutan) urutkan nilai tiap siswa dari kecil ke besar
        System.out.println("\n--- Mengurutkan nilai siswa ---");
        System.out.println();

        if (cekArray()) {
            return;
        }

        // Implementasi ini akan lebih kompleks karena membutuhkan penyalinan array atau algoritma sort.
        // konsep algoritma sort dengan bubble short.

         for (int i = 0; i < jumlahSiswa; i++) {
            // Bubble sort untuk setiap siswa
            for (int j = 0; j < jumlahMapel - 1; j++) {
                for (int k = 0; k < jumlahMapel - j - 1; k++) {
                    if (nilai[i][k] > nilai[i][k + 1]) {
                        // Tukar nilai
                        int temp = nilai[i][k];
                        nilai[i][k] = nilai[i][k + 1];
                        nilai[i][k + 1] = temp;
                    }
                }
            }
            // Tampilkan hasil setelah diurutkan
            System.out.print("Nilai siswa ke-" + (i + 1) + " setelah diurutkan: ");
            for (int j = 0; j < jumlahMapel; j++) {
                System.out.print(nilai[i][j] + " ");
            }
            System.out.println();
        }

    }

    public boolean  cekArray() {
        if(nilai == null) {
            System.out.println("Data masih kosong... ");
            return true;
        }
        return false;
    }





}
