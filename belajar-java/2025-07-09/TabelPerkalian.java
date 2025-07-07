
import java.util.Scanner;

public class TabelPerkalian {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exit = false;

        do {
            System.out.println("");
            System.out.println("========== Program Tabel Perkalian ==========");
            System.out.println("1. Menggunakan for loop");
            System.out.println("2. Menggunakan while loop");
            System.out.println("3. Menggunakan do while loop");
            System.out.println("4. Keluar");
            System.out.println("");
            System.out.println("Pilih no (1-4) : ");
            int pilihan = input.nextInt();
            
            int num = -1;

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nilai N : ");
                    num = input.nextInt();
                    System.out.println("Tabel perkalian "+ num + " (for loop) :");
                    
                    for(int i = 1; i <= num; i++) {
                        for(int j = 1; j <= num; j++) {
                            System.out.print(i * j + "\t|   ");
                        }
                        System.out.println();
                    }
                    
                    break;
                case 2:
                    System.out.print("Masukkan nilai N : ");
                    num = input.nextInt();
                    System.out.println("Tabel perkalian "+ num + " (while loop) :");
                    System.out.println("");
                    
                    int i = 1;
                    while(i <= num) {
                        int j = 1;
                        while(j <= num) {
                            System.out.print(i * j + "\t|   ");
                            j++;
                        }
                        System.out.println("");
                        i++;
                    }

                    break;
                case 3:
                    System.out.print("Masukkan nilai N : ");
                    num = input.nextInt();
                    System.out.println("Tabel perkalian "+ num + " (do while loop) :");
                    System.out.println("");
                    
                    int a = 1;
                    do {
                        int b = 1;
                        do {
                            System.out.print(a * b + "\t|   ");
                            b++;
                        }while(b <= num);
                        System.out.println("");
                        a++;
                    }while(a <= num);
                    break;
                case 4:
                    System.out.println("Terima kasih.");
                    exit = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
            System.out.println("");
        } while (!exit);
        input.close();

    }

}
