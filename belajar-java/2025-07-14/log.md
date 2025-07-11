# Log Belajar Java Dasar - Hari 8  
**Tanggal**: 2025-07-13  
**Folder**: `belajar-java/2025-07-13`

---

## Materi Dipelajari:

- **Array of Object**:
  - Menyimpan data siswa dalam bentuk objek array `Siswa[]`
  - Mengelola atribut `nama`, `nim`, dan `nilai`
  - Mengakses dan memodifikasi elemen array objek
- **Class dan Method**:
  - Pemisahan class `Siswa`, `SiswaController`, dan `SiswaApp`
  - Penerapan konsep OOP (enkapsulasi dan modularitas)
- **Pengelolaan Data Siswa**:
  - Tambah siswa (dengan validasi dan resize array)
  - Ubah data berdasarkan NIM
  - Hapus data dengan konfirmasi
  - Tampilkan daftar siswa
  - Rangking berdasarkan nilai (menggunakan Bubble Sort)
- **Validasi Input**:
  - Input angka dengan pengecekan exception
  - Validasi nilai harus 0–100
  - Deteksi NIM duplikat

---

##  Kapan kita butuh Array of Object?:
**Ketika kita ingin menyimpan banyak data yang kompleks.** Misalnya data siswa:
  - Nama
  - NIM
  - Nilai

**Kalau gunakan array biasa, harus membuat 3 array terpisah:**
```java
String[] nama;
String[] nim;
int[] nilai;
```

**Tapi dengan Array of Object, kita bisa buat satu class:**
```java
class Siswa {
    String nama;
    String nim;
    int nilai;
}

Siswa[] daftarSiswa = new Siswa[3];
```

---
## Contoh sederhana:
```java
class Siswa {
    String nama;
    String nim;
    int nilai;

    // Constructor
    public Siswa(String nama, String nim, int nilai) {
        this.nama = nama;
        this.nim = nim;
        this.nilai = nilai;
    }

    // Method untuk menampilkan data siswa
    public void tampilkan() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Nilai: " + nilai);
    }
}

public class ContohArrayOfObject {
    public static void main(String[] args) {
        Siswa[] daftar = new Siswa[2];

        daftar[0] = new Siswa("Ani", "202501", 90);
        daftar[1] = new Siswa("Budi", "202502", 80);

        for (Siswa s : daftar) {
            s.tampilkan();
            System.out.println();
        }
    }
}
```
---

## File yang Dibuat:

- `Siswa.java`
- `SiswaController.java`
- `SiswaApp.java`

### Fitur Program:

- Manajemen data siswa berbasis OOP
- Menu interaktif dengan input validasi
- Struktur dinamis array object (`resize` dan `shrink`)
- Sorting rangking berdasarkan nilai tertinggi
- Ubah data fleksibel dengan input opsional
- Hapus data dengan verifikasi pengguna

---

## Trial & Error:

- Penanganan exception pada input angka (`InputMismatchException`)
- Duplikasi NIM saat tambah/ubah data
- Logika update data menggunakan input kosong
- Validasi nilai diubah tidak menghapus jika salah
- Penyesuaian resize dan shrink array sesuai kebutuhan data

---

## Catatan Pribadi:

> Hari ini belajar banyak tentang _object-oriented programming_ dan implementasi nyata dalam program sederhana. Menarik melihat bagaimana array of object sangat fleksibel untuk mewakili data kompleks, dan bagaimana struktur program menjadi lebih rapi saat dipisah ke dalam class.
> Array of Object menyimpan kumpulan objek dalam satu array.
> Kita bisa mengakses setiap objek dalam array, dan memanggil method atau mengakses atributnya.

---

## Tujuan Hari Ini:

✅ Memahami dan mengimplementasikan array of object  
✅ Membuat class `Siswa` dan controller-nya  
✅ Menambahkan fitur tambah, lihat, ubah, hapus, dan ranking  
✅ Menyusun menu interaktif berbasis OOP

---

## Target Hari ke-9:

- Menyimpan dan membaca data siswa dari file (I/O sederhana)
- Ekspor dan impor data ke/dari `.txt` atau `.csv`
- Penerapan `FileWriter`, `FileReader`, atau `BufferedReader`
- Menambahkan opsi simpan/ambil data dari file di menu

---

#### Dwi312
