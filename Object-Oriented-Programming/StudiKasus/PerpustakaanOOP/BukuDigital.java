public class BukuDigital extends Buku{
    private double ukuranFileMB;

    public BukuDigital(String judul, String penulis, int tahunTerbit, double ukuranFileMB) {
        super(judul, penulis, tahunTerbit);
        this.ukuranFileMB = ukuranFileMB;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis: Buku Digital");
        System.out.println("Ukuran File: " + ukuranFileMB + " MB");
        System.out.println("------------------------");
    }

}
