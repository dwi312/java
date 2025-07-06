
import java.util.Scanner;

public class NamaHari {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String hari;

        System.out.println("Pilih hari : ");
        System.out.println("1. Senin");
        System.out.println("2. Selasa");
        System.out.println("3. Rabu");
        System.out.println("4. Kamis");
        System.out.println("5. Jumat");
        System.out.println("6. Sabtu");
        System.out.println("7. Minggu");
        System.out.println("");
        System.out.println("Masukan Pilihan (1-7) : ");
        int kodeHari = input.nextInt();

        switch (kodeHari) {
            case 1:
                hari = "Senin";
                break;
            case 2:
                hari = "Selasa";
                break;
            case 3:
                hari = "Rabu";
                break;
            case 4:
                hari = "Kamis";
                break;
            case 5:
                hari = "Jumat";
                break;
            case 6:
                hari = "Sabtu";
                break;
            case 7:
                hari = "Minggu";
                break;
            default:
                // throw new AssertionError("Kode hari tidak valid. pilih 1 ~ 7");
                System.out.println("Kode hari tidak valid. pilih 1 ~ 7");
                 input.close();
                 return;
        }

        System.out.println("Anda memlih hari " + hari);
        input.close();
    }

}
