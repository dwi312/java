public class BukuCetak extends Buku {
    private int jumlahHalaman;

    public BukuCetak(String judul, String penulis, int tahunTerbit, int jumlahHalaman) {
        super(judul, penulis, tahunTerbit);
        this.jumlahHalaman = jumlahHalaman;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis: Buku Cetak");
        System.out.println("Jumlah Halaman: " + jumlahHalaman);
        System.out.println("------------------------");
    }


}
