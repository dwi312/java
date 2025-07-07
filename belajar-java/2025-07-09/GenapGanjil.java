import java.util.Scanner;

public class GenapGanjil {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exit = false;

        do {
            System.out.println();
            System.out.println("========= Program Menampilkan Bilangan Genap & Ganjil =========");
            System.out.println("1. Menampilkan bilangan genap & ganjil (for loop)");
            System.out.println("2. Menampilkan bilangan genap & ganjil (while loop)");
            System.out.println("3. Menampilkan bilangan genap & ganjil (do while loop)");
            System.out.println("4. Keluar");
            System.out.print("Pilih no (1-4): ");
            int pilihan = input.nextInt();

            int num;

            switch(pilihan) {
                case 1:
                    System.out.print("Masukkan nilai N : ");
                    num = input.nextInt();

                    System.out.println("\nBilangan Genap dari 1 hingga " + num + " (for loop):");
                    
                    for(int i = 1; i <= num; i++) {
                        if(i % 2 == 0) {
                            System.out.print(i + " ");
                        }
                    }

                    System.out.println("");
                    System.out.println("\nBilangan Ganjil dari 1 hingga " + num + " (for loop):");
                    
                    for(int i = 1; i <= num; i++) {
                        if(i % 2 != 0) {
                            System.out.print(i + " ");
                        }
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Masukkan nilai N : ");
                    num = input.nextInt();

                    System.out.println("\nBilangan Genap dari 1 hingga " + num + " (while loop):");

                    int i = 1;
                    while(i <= num) {
                        if(i % 2 == 0) {
                            System.out.print(i + " ");
                        }
                        i++;
                    }

                    System.out.println("");
                    System.out.println("\nBilangan Ganjil dari 1 hingga " + num + " (while loop):");

                    int j = 1;
                    while(j <= num) {
                        if(j % 2 != 0) {
                            System.out.print(j + " ");
                        }
                        j++;
                    }

                    break;
                case 3:
                    System.out.print("Masukkan nilai N : ");
                    num = input.nextInt();

                    System.out.println("\nBilangan Genap dari 1 hingga " + num + " (do while loop):");
                    
                    int a = 1;
                    do {
                        if(a % 2 == 0) {
                            System.out.print(a + " ");
                        }
                        a++;
                    }while(a <= num);

                    System.out.println("\nBilangan Ganjil dari 1 hingga " + num + " (do while loop):");

                    int b = 1;
                    do {
                        if(b % 2 != 0) {
                            System.out.print(b + " ");
                        }
                        b++;
                    }while(b <= num);

                    break;
                case 4:
                    System.out.println("Terima kasih.");
                    exit = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
            System.out.println("");
        }while(!exit);
        input.close();

    }

}
