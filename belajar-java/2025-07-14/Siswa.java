public class Siswa {
    String nama;
    String nim;
    int nilai;

    public Siswa(String nama, String nim, int nilai) {
        this.nama = nama;
        this.nim = nim;
        this.nilai = nilai;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
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

    public void displaySiswa() {
        System.out.println("Nama : " + nama + " , Nim : " + nim + " , Nilai : " + nilai);
    }

}