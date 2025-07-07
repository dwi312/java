import java.util.Scanner;

public class DeretAngka {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exit = false;

        do {
            System.out.println("");
            System.out.println("=========== Program ini akan mencetak angka dari 1 hingga N ==========");
            System.out.println("1. Mengunakan for loop");
            System.out.println("2. Mengunakan while loop");
            System.out.println("3. Mengunakan do while loop");
            System.out.println("4. Keluar");
            System.out.println("");
            System.out.println("Pilih no (1-4) : ");
            int pilihan = input.nextInt();
            
            int num = -1;

            switch(pilihan) {
                case 1:
                    System.out.println("Masukan nilai N : ");
                    num = input.nextInt();
                    System.out.println("Nilai N =  " + num);
                    System.out.println("");
                    
                    for(int i = 1; i <= num; i++) {
                        System.out.print(i + " ");
                    }    
                    
                    break;
                case 2:
                    System.out.println("Masukan nilai N : ");
                    num = input.nextInt();

                    System.out.println("Nilai N =  " + num);
                    System.out.println("");

                    int i = 1;
                    while(i <= num) {
                        System.out.print(i + " ");
                        i++;
                    }
                    
                    break;
                case 3:
                    System.out.println("Masukan nilai N : ");
                    num = input.nextInt();
                    
                    System.out.println("Nilai N =  " + num);
                    System.out.println("");
                    
                    int j = 1;
                    do {
                        System.out.print(j + " ");
                        j++;
                    }while(j <= num);
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
