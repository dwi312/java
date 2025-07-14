package src.model;

public class Siswa {
    private String nama;
    private String nim;
    private int nilai;

    public Siswa(String nama, String nim, int nilai) {
        this.nama = nama;
        this.nim = nim;
        this.nilai = nilai;
    }

    public String getNama () {
        return nama;
    }

    public String getNim () {
        return nim;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }

    public void tampilkanInfo() {
        System.out.println(nama + " | NIM: " + nim + " | Nilai: " + nilai);
    }

}
