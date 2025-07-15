package model;

import java.time.LocalDate;

public class Transaksi {
    private String idTransaksi;
    private String idAnggota;
    private String kodeBuku;
    private LocalDate tanggalPinjam;
    private LocalDate tanggalKembali;

    public Transaksi(String idTransaksi, String idAnggota, String kodeBuku, LocalDate tanggalPinjam, LocalDate tanggalKembali) {
        this.idTransaksi = idTransaksi;
        this.idAnggota = idAnggota;
        this.kodeBuku = kodeBuku;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
    }

    @Override
    public String toString() {
        return idTransaksi +
             " | Anggota: " + idAnggota +
             " | Buku: " + kodeBuku +
             " | Pinkam: " + tanggalPinjam +
             " | Kembali: " + tanggalKembali
             ;
    }
}
