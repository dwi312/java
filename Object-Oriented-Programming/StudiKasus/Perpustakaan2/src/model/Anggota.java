package model;
public class Anggota {
    private String idAnggota;
    private String nama;
    private String kontak;

    public Anggota(String idAnggota, String nama, String kontak) {
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.kontak = kontak;
    }

    public String getIdAnggota() {
        return idAnggota;
    }

    public String getNama() {
        return nama;
    }
    
    public String getKontak() {
        return kontak;
    }

    @Override
    public String toString() {
        return idAnggota + " | " + nama + " | " + " [" + kontak + "] ";
    }


}
