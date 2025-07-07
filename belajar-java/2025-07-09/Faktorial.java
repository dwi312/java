import java.util.Scanner;

public class Faktorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exit = false;

        do {
            System.out.println();
            System.out.println("========= Program Menghitung Faktorial =========");
            System.out.println("1. Menggunakan for loop");
            System.out.println("2. Menggunakan while loop");
            System.out.println("3. Menggunakan do while loop");
            System.out.println("4. Keluar");
            System.out.print("Pilih no (1-4): ");
            int pilihan = input.nextInt();

            int n = -1;
            int hasil = 1;

            switch (pilihan) {
                case 1:
                    System.out.println("Masukan nilai N : ");
                    n = input.nextInt();
                    System.out.println("Nilai N =  " + n);
                    System.out.println("");
                    
                    for(int i = 1; i <= n; i++) {
                        hasil *= i;
                    } 
                    System.out.println("Hasil faktorial " + n + " = " + hasil);
                    break;
                case 2:
                    System.out.println("Masukan nilai N : ");
                    n = input.nextInt();

                    System.out.println("Nilai N =  " + n);
                    System.out.println("");

                    int i = 1;
                    while(i <= n) {
                        hasil *= i;
                        i++;
                    }
                    System.out.println("Hasil faktorial " + n + " = " + hasil);
                    
                    break;
                case 3:
                    System.out.println("Masukan nilai N : ");
                    n = input.nextInt();
                    
                    System.out.println("Nilai N =  " + n);
                    System.out.println("");
                    
                    int j = 1;
                    do {
                        hasil *= j;
                        j++;
                    }while(j <= n);
                    System.out.println("Hasil faktorial " + n + " = " + hasil);
                    break;
                case 4:
                    System.out.println("Terima kasih.");
                    exit = true;
                    
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
            hasil = 1;
        } while (!exit);
        input.close();
    }

}
