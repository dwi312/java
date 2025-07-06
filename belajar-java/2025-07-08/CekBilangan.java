
import java.util.Scanner;

public class CekBilangan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input dari pengguna
        System.out.println("Masukan Angka anda : ");
        int angka = input.nextInt();
        input.nextLine(); // Untuk mengonsumsi sisa newline
        
        System.out.println("");
        System.out.println("Angka yang anda masukan adalah : " + angka);

        // Mengecek bilangan positif, negatif, atau nol
        if(angka > 0) {
            System.out.println("Pengecekan Bilangan = Positif");
        } else if (angka < 0) {
            System.out.println("Pengecekan Bilangan = Negatif");
        } else {
            System.out.println("Pengecekan Bilangan = Nol");
        }

        // Mengecek genap atau ganjil
        if(angka % 2 == 0) {
            System.out.println("Genap");
        } else {
            System.out.println("Ganjil");
        }

        // Menutup Scanner untuk menghindari warning
        input.close();

    }


}
