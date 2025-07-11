
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SiswaController {
    private Scanner input = new Scanner(System.in);
    private boolean exit;
    private int pilihan;

    private Siswa[] daftarSiswa;
    private int jumlahSiswa;
    private static final int NILAI_AWAL = 3;

    public SiswaController() {
        this.daftarSiswa = new Siswa[NILAI_AWAL];
        this.jumlahSiswa = 0;
    }

    
    public void run() {
        for (exit = false; !exit;) {
            menu();
            inputValid();
            input.nextLine();
            menuPilihan(pilihan);
            System.out.println();
        }
        input.close();
    }

    public void tambahSiswa() {
        // Menambah data siswa baru.
        System.out.println("=== Tambah siswa ===");
        if(jumlahSiswa == daftarSiswa.length) {
            resizeArray();
        }

        System.out.print("Masukan Nama Siswa : ");
        String nama = input.nextLine();
        
        String nim;
        boolean nimDuplikat;
        do { 
            System.out.print("Masukan Nim Siswa : ");
            nim = input.nextLine();
            nimDuplikat = false;

            for(int i = 0; i < jumlahSiswa; i++) {
                nimDuplikat = true;
                System.out.println("NIM sudah terdaftar.");
                break;
            }
        } while (nimDuplikat);

        int nilai = -1;
        while (nilai < 0 || nilai > 100) {
            try {
                System.out.print("Masukan Nilai Siswa (0-100): ");
                nilai = input.nextInt();
                input.nextLine();
                if(nilai < 0 || nilai > 100) {
                    System.out.println("Nilai harus diantara 0 dan 100.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input nilai harus angka.");
                input.nextLine();
            }
            
        }

        daftarSiswa[jumlahSiswa] = new Siswa(nama, nim, nilai);
        jumlahSiswa++;
        System.out.println("Siswa " + nama + " berhasil ditambahkan.");

    }

    public void daftarSiswa() {
        // menampilkan daftar seluruh siswa (Nama, nim, nilai)
        System.out.println("\n=== Daftar Siswa ===");
        if (dataKosong()) {
            System.out.println("Belum ada data siswa.");
            return;
        }
        for (int i = 0; i < jumlahSiswa; i++) {
            System.out.print((i + 1) + ". ");
            daftarSiswa[i].displaySiswa();
        }
        
    }
    
    public void rangkingSiswa() {
        // menampilkan nilai siswa diurutkan dgn nilai tertinggi
        System.out.println("\n=== Rangking Siswa (Nilai Tertinggi) ===");
        if (dataKosong()) {
            System.out.println("Belum ada data siswa untuk diranking.");
            return;
        }

        // Buat salinan array agar tidak mengubah urutan asli daftarSiswa
        Siswa[] siswaUntukSorting = Arrays.copyOf(daftarSiswa, jumlahSiswa);

        // Algoritma pengurutan Bubble Sort (atau bisa pakai Selection Sort, dll.)
        for (int i = 0; i < jumlahSiswa - 1; i++) {
            for (int j = 0; j < jumlahSiswa - 1 - i; j++) {
                if (siswaUntukSorting[j].getNilai() < siswaUntukSorting[j + 1].getNilai()) {
                    // Tukar posisi jika elemen saat ini lebih kecil dari elemen berikutnya
                    Siswa temp = siswaUntukSorting[j];
                    siswaUntukSorting[j] = siswaUntukSorting[j + 1];
                    siswaUntukSorting[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < jumlahSiswa; i++) {
            System.out.print((i + 1) + ". ");
            siswaUntukSorting[i].displaySiswa();
        }

    }

    public void ubahDataSiswa() {
        // merubah data siswa dengan mencari nama atau nim yang terdaftar.
        // data yang dirubah (nama, nim, nilai)
        // perbarui data
        System.out.println("\n=== Ubah Data Siswa ===");
        if (dataKosong()) {
            System.out.println("Belum ada data siswa untuk diubah.");
            return;
        }

        System.out.print("Masukkan NIM siswa yang akan diubah datanya: ");
        String nimCari = input.nextLine();

        int indeksDitemukan = -1;
        for (int i = 0; i < jumlahSiswa; i++) {
            if (daftarSiswa[i].getNim().equalsIgnoreCase(nimCari)) {
                indeksDitemukan = i;
                break;
            }
        }

        if (indeksDitemukan != -1) {
            System.out.println("Siswa ditemukan. Data saat ini:");
            daftarSiswa[indeksDitemukan].displaySiswa();

            System.out.println("\nMasukkan data baru (biarkan kosong untuk tidak mengubah):");
            System.out.print("Nama baru (" + daftarSiswa[indeksDitemukan].getNama() + "): ");
            String newNama = input.nextLine();
            if (!newNama.isEmpty()) {
                daftarSiswa[indeksDitemukan].setNama(newNama);
            }

            String newNim = daftarSiswa[indeksDitemukan].getNim(); // Inisialisasi dengan NIM lama
            boolean nimDuplikat;
            do {
                nimDuplikat = false;
                System.out.print("NIM baru (" + daftarSiswa[indeksDitemukan].getNim() + "): ");
                String tempNim = input.nextLine();
                if (!tempNim.isEmpty()) {
                    // Periksa duplikasi NIM baru
                    for (int i = 0; i < jumlahSiswa; i++) {
                        if (i != indeksDitemukan && daftarSiswa[i].getNim().equalsIgnoreCase(tempNim)) {
                            nimDuplikat = true;
                            System.out.println("NIM baru sudah terdaftar. Masukkan NIM yang unik.");
                            break;
                        }
                    }
                    if (!nimDuplikat) {
                        newNim = tempNim;
                        daftarSiswa[indeksDitemukan].setNim(newNim);
                    }
                } else { 
                    break;
                }
            } while (nimDuplikat);


            int newNilai = daftarSiswa[indeksDitemukan].getNilai(); // Inisialisasi dengan nilai lama
            System.out.print("Nilai baru (" + daftarSiswa[indeksDitemukan].getNilai() + ") (0-100): ");
            String nilaiStr = input.nextLine();
            if (!nilaiStr.isEmpty()) {
                try {
                    int tempNilai = Integer.parseInt(nilaiStr);
                    if (tempNilai >= 0 && tempNilai <= 100) {
                        newNilai = tempNilai;
                        daftarSiswa[indeksDitemukan].setNilai(newNilai);
                    } else {
                        System.out.println("Nilai harus antara 0 dan 100. Nilai tidak diubah.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input nilai tidak valid. Nilai tidak diubah.");
                }
            }
            System.out.println("Data siswa berhasil diperbarui.");
            daftarSiswa[indeksDitemukan].displaySiswa();
        } else {
            System.out.println("Siswa dengan NIM '" + nimCari + "' tidak ditemukan.");
        }

    }

    public void hapusSiswa() {
        // Metode untuk menghapus data siswa berdasarkan NIM
        System.out.println("\n=== Hapus Siswa ===");
        if (dataKosong()) {
            System.out.println("Belum ada data siswa untuk dihapus.");
            return;
        }

        System.out.print("Masukkan NIM siswa yang akan dihapus: ");
        String nimHapus = input.nextLine();

        int indeksDitemukan = -1;
        for (int i = 0; i < jumlahSiswa; i++) {
            if (daftarSiswa[i].getNim().equalsIgnoreCase(nimHapus)) {
                indeksDitemukan = i;
                break;
            }
        }

        if (indeksDitemukan != -1) {
            System.out.println("Siswa ditemukan: ");
            daftarSiswa[indeksDitemukan].displaySiswa();
            System.out.print("Apakah Anda yakin ingin menghapus siswa ini? (ya/tidak): ");
            String konfirmasi = input.nextLine();

            if (konfirmasi.equalsIgnoreCase("ya")) {
                // Geser semua elemen setelah indeks yang dihapus ke kiri
                for (int i = indeksDitemukan; i < jumlahSiswa - 1; i++) {
                    daftarSiswa[i] = daftarSiswa[i + 1];
                }
                daftarSiswa[jumlahSiswa - 1] = null; // Hapus referensi terakhir
                jumlahSiswa--; // Kurangi jumlah siswa

                // Opsional: Perkecil array jika terlalu banyak ruang kosong
                if (daftarSiswa.length > NILAI_AWAL && jumlahSiswa < daftarSiswa.length / 3) {
                    shrinkArray();
                }

                System.out.println("Siswa berhasil dihapus.");
            } else {
                System.out.println("Penghapusan dibatalkan.");
            }
        } else {
            System.out.println("Siswa dengan NIM '" + nimHapus + "' tidak ditemukan.");
        }
    }

    public boolean dataKosong() {
        // Pengecekan bila data masih kosong
        return jumlahSiswa == 0;
    }

    private void resizeArray() {
        int kapasitasBaru = daftarSiswa.length * 2;
        // Gunakan Arrays.copyOf untuk membuat array baru dan menyalin elemen
        daftarSiswa = Arrays.copyOf(daftarSiswa, kapasitasBaru);
        System.out.println("Kapasitas penyimpanan diperbesar menjadi " + kapasitasBaru + ".");
    }

    private void shrinkArray() {
        int kapasitasBaru = daftarSiswa.length / 2;
        if (kapasitasBaru < NILAI_AWAL) { 
            kapasitasBaru = NILAI_AWAL;
        }
        daftarSiswa = Arrays.copyOf(daftarSiswa, kapasitasBaru);
        System.out.println("Kapasitas penyimpanan diperkecil menjadi " + kapasitasBaru + ".");
    }

    public void menu() {
        System.out.println("=== Program manajemen siswa ===");
        System.out.println("1. Lihat daftar siswa");
        System.out.println("2. Rangking siswa");
        System.out.println("3. Tambah siswa");
        System.out.println("4. Ubah data siswa");
        System.out.println("5. Hapus siswa");
        System.out.println("0. Keluar");
        System.out.print("Pilihan (1-5) : ");
    }

    public boolean menuPilihan(int pilihan) {
        exit = false;
        switch (pilihan) {
            case 1:
                 daftarSiswa();
                break;
            case 2:
                rangkingSiswa();
                break;
            case 3:
                tambahSiswa();
                break;
            case 4:
                ubahDataSiswa();
                break;
            case 5:
                hapusSiswa();
                break;
            case 0:
                System.out.println("Program berhenti. Terimakasih");
                exit = true;
                break;
            default:
                System.out.println("Pilihan tidak valid");
                break;
        }
        return exit;
    }

    public boolean inputValid() {
        boolean valid = false;

        while (!valid) {
            try {
                pilihan = input.nextInt();
                valid  = true;
            } catch (InputMismatchException e) {
                System.out.print("Input harus angka : ");
                input.next();
            }

        }
        return valid;
    }

}
