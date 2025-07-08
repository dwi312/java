import java.util.Scanner;

public class NilaiSiswa {
    Scanner input = new Scanner(System.in);
    
    int n;
    int[] siswa = new int[n];
    int total = 0; 
    double avg = 0; 
    int max;
    int min;

    public void inputNilai(Scanner input) {
        System.out.print("Masukkan jumlah siswa : ");
        n = input.nextInt();
        siswa = new int[n];
        System.out.println("Jumlah siswa ada : " + siswa.length);
        
        for(int i = 0; i < siswa.length; i++) {
            System.out.print("Masukkan nilai untuk siswa ke-"+ (i+1) + " : ");
            siswa[i] = input.nextInt();
        }
        return; 
    }

    public void tampilkanNilai() {
        System.out.println("Daftar nilai siswa : ");
        if (siswa.length == 0) {
            System.out.println("Data masih kosong.");
        } else {
            for(int i = 0; i < siswa.length; i++) {
                System.out.println("Nilai siswa ke-"+ (i+1) + " : "+siswa[i]);
            }
        }
    }

    public int hitungTotal() {
        if (siswa.length == 0) {
            System.out.println("Data masih kosong.");
        } else {
            for(int i = 0; i < siswa.length; i++) {
                total += siswa[i];
            }
        }

        return total;
    }

    public double hitungRataRata() {
        if (siswa.length == 0) {
            System.out.println("Data masih kosong.");
        } else {
            avg = (double) total / siswa.length;
        }
        return  avg;
    }

    public int cariMax() {
        if (siswa.length == 0) {
            System.out.println("Data masih kosong.");
        } else {
            max = siswa[0];
            for(int i = 0; i < siswa.length; i++) {
                if(siswa[i] > max) {
                    max = siswa[i];
                }
            }
        }

        return max;
    }

    public int cariMin() {
        if (siswa.length == 0) {
            System.out.println("Data masih kosong.");
        } else {
            min = siswa[0];
            for(int i = 0; i < siswa.length; i++) {
                if(siswa[i] < min) {
                    min = siswa[i];
                }
            }

        }

        return min;
    }

    // ======================= Penting ga penting  =======================================
    // ======================= sayang dihapus  =======================================
    // public static void main(String[] args) {

    //     System.out.print("Masukkan jumlah siswa : ");
    //     int n = input.nextInt();
    //     int[] siswa = new int[n];
    //     int total = 0; 
    //     double avg = 0; 
    //     System.out.println("Jumlah siswa ada : " + siswa.length);

        
        
    //     for(int i = 0; i < siswa.length; i++) {
    //         System.out.print("Masukkan nilai untuk siswa ke-"+ (i+1) + " : ");
    //         siswa[i] = input.nextInt();
    //     }
        
    //     System.out.println("Daftar nilai siswa : ");
    //     for(int i = 0; i < siswa.length; i++) {
    //         System.out.println("Nilai siswa ke-"+ (i+1) + " : "+siswa[i]);
    //     }

    //     int min = siswa[0];
    //     // =================================================== 
    //     System.out.println("");
    //     System.out.println("Pengecekan");
    //     System.out.println("Nilai min pertama : " + min);
    //     // =================================================== 
        
    //     int max = siswa[0]; 
    //     // =================================================== 
    //     System.out.println("Nilai max pertama : " + max);
    //     System.out.println("");
    //     // =================================================== 
        
    //     for (int i = 0; i < siswa.length; i++) {
    //         total += siswa[i]; 

    //         System.out.println("");
    //         System.out.println("Pengecekan di loop ke "+ (i+1));
            
            
    //         if (siswa[i] < min) {
    //             min = siswa[i];
    //             System.out.println("Prosses, nilai MIN sekarang : " + min);
    //         } else {
    //             System.out.println("tidak ada proses niai MIN, nilai masih : " + min);
    //         }
            
    //         if (siswa[i] > max) {
    //             max = siswa[i];                
    //             System.out.println("Prosses, nilai MAX sekarang : " + max);
    //         } else {
    //             System.out.println("tidak ada proses nilai Max, nilai masih : " + max);
    //         }
    //         System.out.println("");
    //     }

    //     avg = (double) total / siswa.length;


    //     System.out.println();
    //     System.out.println("Total nilai  : " + total);
    //     System.out.println("Rata-rata nilai  : " + avg);
    //     System.out.println("Nilai tertinggi  : " + max);
    //     System.out.println("Nilai terendah  : " + min);
    

    //     input.close();
    // }
    

}
