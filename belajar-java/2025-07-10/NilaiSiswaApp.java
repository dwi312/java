
import java.util.Scanner;

public class NilaiSiswaApp {
    public static void main(String[] args) {
        NilaiSiswa nilaiSiswa = new NilaiSiswa();
        Scanner input = new Scanner(System.in);
        int pilihan;
        

        for(boolean exit = false; !exit;) {

            menu();
            pilihan = input.nextInt();


            switch (pilihan) {
                case 1:
                    nilaiSiswa.inputNilai(input);
                    System.out.println("Nilai berhasil di simpan.");
                    break;
                case 2:
                    nilaiSiswa.tampilkanNilai();
                    break;
                case 3:
                    nilaiSiswa.hitungTotal();
                    nilaiSiswa.hitungRataRata();
                    System.out.println("Total nilai  : " + nilaiSiswa.total);
                    System.out.println("Rata-rata nilai  : " + nilaiSiswa.avg);
                
                    break;
                case 4:
                    System.out.println("Nilai tertinggi  : " + nilaiSiswa.cariMax());
                    System.out.println("Nilai terendah  : " + nilaiSiswa.cariMin());
                    
                    break;
                case 0:
                    System.out.println("Program berakhir.");
                    exit = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
            System.out.println();
        }
        input.close();
        
    }

    public static void menu(){
        System.out.println("====== Menu Program Nilai Siswa ======");
        System.out.println("1. Input nilai siswa");
        System.out.println("2. Tampilkan semua nilai");
        System.out.println("3. Hitung total dan rata-rata");
        System.out.println("4. Tampilkan nilai maksimum dan minimum");
        System.out.println("0. Keluar");
        System.out.print("Pilih (1-4): ");
    }

}
