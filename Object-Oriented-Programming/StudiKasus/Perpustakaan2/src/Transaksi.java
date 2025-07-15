public class Transaksi {
    private int idTransaksi;
    private int idAnggota;
    private int kodeBuku;
    private String tanggalPinjam;
    private String tanggalKembali;

    public Transaksi(int idTransaksi, int idAnggota, int kodeBuku, String tanggalPinjam, String tanggalKembali) {
        this.idTransaksi = idTransaksi;
        this.idAnggota = idAnggota;
        this.kodeBuku = kodeBuku;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
    }
}
