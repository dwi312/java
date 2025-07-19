package model;

import java.time.LocalDate;

public class Transaksi {
    private String idTransaksi;
    private String idAnggota;
    private String kodeBuku;
    private LocalDate tanggalPinjam;
    private LocalDate tanggalKembali;

    public Transaksi(String idTransaksi, String idAnggota, String kodeBuku, LocalDate tanggalPinjam,
            LocalDate tanggalKembali) {
        this.idTransaksi = idTransaksi;
        this.idAnggota = idAnggota;
        this.kodeBuku = kodeBuku;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public String getIdAnggota() {
        return idAnggota;
    }

    public String getKodeBuku() {
        return kodeBuku;
    }

    public LocalDate getTanggalPinjam() {
        return tanggalPinjam;
    }

    public LocalDate getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(LocalDate tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    @Override
    public String toString() {
        return idTransaksi +
                " | Anggota: " + idAnggota +
                " | Buku: " + kodeBuku +
                " | Pinjam: " + tanggalPinjam +
                " | Kembali: " + tanggalKembali;
    }
}
