package StudiKasus.tugas01;

import java.util.ArrayList;

public class Services {
    private ArrayList<Mahasiswa> daftarMahasiswa;

    public Services() {
        this.daftarMahasiswa = new ArrayList<>();
    }

    /**
     * Menambahkan objek Mahasiswa baru ke daftar.
     * @param mahasiswa Objek Mahasiswa yang akan ditambahkan.
     */
    public void tambahMahasiswa(Mahasiswa mahasiswa) {
        if (mahasiswa != null) {
            this.daftarMahasiswa.add(mahasiswa);
            System.out.println("Mahasiswa " + mahasiswa.getNama() + " berhasil ditambah.");
        } else {
            System.out.println("Gagal menambah mahasiswa.");
        }
        
    }

    public void tampilkanData() {
        dataKosong();

        for(int i = 0; i < daftarMahasiswa.size(); i++) {
            System.out.println(daftarMahasiswa.get(i));
        }

    }
    
    public double hitungRataNilai() {
        double total = 0;
        if(daftarMahasiswa.isEmpty()) {
            System.out.println("Data masih kosong");
            return total;
        }

        for(int i = 0; i < daftarMahasiswa.size(); i++) {
           total += (double) daftarMahasiswa.get(i).getNilai();
        }

        double rataRata = total / daftarMahasiswa.size();

        System.out.println("Nilai rata-rata: " + rataRata);
        
        return rataRata;
    }
    
    public Mahasiswa cariNilaiTertinggi() {
        if(daftarMahasiswa.isEmpty()) {
            System.out.println("Data masih kosong");
            return null;
        }

        // Inisialisasi mahasiswa dengan nilai tertinggi sementara
        Mahasiswa topNilai = daftarMahasiswa.get(0);

        // ambil elemen kedua sampai akhir
        for(int i = 1; i < daftarMahasiswa.size(); i++) {
            Mahasiswa nilaiSekarang = daftarMahasiswa.get(i);

            // Bandingkan nilai mahasiswa saat ini dengan nilai tertinggi yang sudah ditemukan
            if(nilaiSekarang.getNilai() > topNilai.getNilai()) {
                topNilai = nilaiSekarang;
            }
        }
        System.out.println("Nilai tertinggi saat ini : ");
        System.out.println("Nama : " + topNilai.getNama() + " , Nilai : " + topNilai.getNilai());

        return  topNilai;
        
    }

    public void dataKosong() {
        if(daftarMahasiswa.isEmpty()) {
            System.out.println("Data masih kosong");
            return;
        }
    }

}
