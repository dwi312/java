package model;
public class Buku {
    private String kodeBuku;
    private String judul;
    private String penulis;
    private String status;

    public Buku(String kodeBuku, String judul, String penulis) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.status = "Tersedia";
    }

    public String getKodeBuku() {
        return kodeBuku;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    @Override
    public String toString() {
        return kodeBuku + " | " + judul + " | " + penulis + "  [" + status +"]";
    }

}
