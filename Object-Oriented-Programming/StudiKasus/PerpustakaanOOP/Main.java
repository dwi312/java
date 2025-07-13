

public class Main {
    public static void main(String[] args) {
       BukuCetak cetak1 = new BukuCetak("Doraemon", "Fujitsu", 1984, 100);
       BukuDigital digital1 = new BukuDigital("Dragon Ball", "Akira Toriyama", 1990, 10);

       cetak1.tampilkanInfo();
       digital1.tampilkanInfo();
    }

}
