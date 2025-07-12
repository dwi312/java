package StudiKasus.tugas01;

public class Mahasiswa {
    private String nama;
    private int nilai;

    public Mahasiswa(String nama, int nilai) {
        this.nama = nama;
        this.nilai = nilai;
    }

    public String getNama() {
        return nama;
    }

    public void  setNama(String nama) {
        this.nama = nama;
    }

    public int getNilai() {
        return nilai;
    }

    public void  setNilai(int nilai) {
        this.nilai = nilai;
    }

    @Override
    public String toString() {
        return  "Nama : " + nama + " , NILAI : " + nilai;
    }

}
