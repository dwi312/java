package SoalLatihan;

import java.util.Scanner;

/**
 *  Soal Latihan
 *  1. Menjumlahkan Bilangan
 *  2. Menampilkan Deret Bilangan Kelipatan 3
 *  3. Mencetak Segitiga Bintang Siku-Siku
 *  4. Deret Fibonacci
 *  
 */

public class Latihan1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exit = false;
        
        do {
            menuPilihan();
            int pilihan = input.nextInt();

            int num;
            int jumlah = 0;

            switch (pilihan) {
                case 1:
                    System.out.print("Masukan nilai N : ");
                    num = input.nextInt();
                    System.out.println();
                    System.out.println("Nilai N :  " + num);
                    

                    for(int i = 1; i <= num; i++) {
                        jumlah += i;
                    }
                    System.out.println("Jumlah = " + jumlah);

                    break;
                case 2:
                    System.out.print("Masukan nilai N : ");
                    num = input.nextInt();
                    System.out.println();
                    System.out.println("Nilai N :  " + num);
                    
                    System.out.print("Hasil : ");
                    for(int i = 1; i <= num; i++) {
                        if(i % 3 == 0) {
                            jumlah = i;
                            System.out.print(jumlah + " ");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Masukan nilai N : ");
                    num = input.nextInt();
                    System.out.println();
                    System.out.println("Nilai N :  " + num);
                    System.out.println();

                    for(int i = 1; i <= num; i++) {
                        for(int j = 1; j <= i -1; j++) {
                            System.out.print("* ");
                        }
                        System.out.println("* ");
                    }
                    break;
                case 4:
                    System.out.print("Masukan nilai N : ");
                    num = input.nextInt();
                    System.out.println();
                    System.out.print("Hasil : ");
                    
                    int a = 0, b = 1;

                    System.out.println("Deret Fibonacci sebanyak " + num + " bilangan:");
                    for (int i = 1; i <= num; i++) {
                        System.out.print(a + " "); // loop pertama langsung cetak 0
                        // lalu proses next = 0+1 
                        int next = a + b; // next = 1
                        a = b; // nilai a = 1
                        b = next; // nilai b = 1
                    }

                    break;
                case 0:
                    System.out.println("Terima kasih.");
                    exit = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
            System.out.println();
        }while(!exit);
        input.close();


    }

    public static void menuPilihan() {
        System.out.println();
        System.out.println("========= Soal Latihan =========");
        System.out.println("1. Menjumlahkan Bilangan");
        System.out.println("2. Menampilkan Deret Bilangan Kelipatan 3");
        System.out.println("3. Mencetak Segitiga Bintang Siku-Siku");
        System.out.println("4. Deret Fibonacci");
        System.out.println("0. Keluar");
        System.out.print("Pilih no (1-6): ");
    }

}
