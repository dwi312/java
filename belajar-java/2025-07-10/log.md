# Log Belajar Java Dasar - Hari 5
Tanggal : 2025-07-10  
Folder : `belajar-java/2025-07-10`

---

## Materi Dipelajari:
- **Array 1 Dimensi**:
  - Menyimpan banyak nilai (`int[]`)
  - Menampilkan isi array dengan loop
  - Menghitung **total nilai** dan **rata-rata**
  - Menentukan **nilai maksimum** dan **nilai minimum**
- Menampilkan proses perbandingan nilai min dan max di dalam loop
- Struktur logika `if` dan pengurutan pengecekan
- Membangun program modular dengan class (`NilaiSiswa`) dan menu interaktif (`NilaiSiswaApp`)
- Implementasi switch-case, method pemrosesan, dan pengecekan data kosong

- **Struktur Array 1 Dimensi**:
```java
int[] siswa = new int[jumlahSiswa];

for (int i = 0; i < siswa.length; i++) {
    System.out.print("Masukkan nilai siswa ke-" + (i + 1) + ": ");
    siswa[i] = input.nextInt();
}
```
- **Struktur program modular dengan class**:
```java
public class NilaiSiswa {
    int[] siswa;
    int total;
    double avg;

    public void inputNilai(Scanner input) { ... }
    public void tampilkanNilai() { ... }
    public int hitungTotal() { ... }
    public double hitungRataRata() { ... }
    public int cariMax() { ... }
    public int cariMin() { ... }
}
```

---

## File yang Dibuat:
| Nama File            | Deskripsi                                                                  |
|----------------------|----------------------------------------------------------------------------|
| `NilaiSiswa.java`    | Class utama berisi logic input, tampil, hitung total, rata-rata, min, max |
| `NilaiSiswaApp.java` | Class dengan menu interaktif berbasis `switch-case` menggunakan objek      |

---

## Trial & Error:
- **Kesalahan inisialisasi array dengan `int[] siswa = new int[n];` sebelum `n` diisi** → sudah diperbaiki
- Hasil `min` tidak muncul di output → karena nilai awal `min = siswa[0]`, tidak masuk kondisi `if`
- Penambahan proses pengecekan `if-else` agar terlihat proses `min` dan `max` berjalan
- Awalnya program masih semua di `main`, kemudian dipisah ke dalam class dan method
- Ditambahkan validasi **data kosong** sebelum hitung atau tampilkan data
- Debug `System.out.println()` pada proses perbandingan min dan max digunakan untuk memahami alur logika

---

## Catatan Pribadi:
- Array sangat membantu untuk menyimpan banyak nilai sekaligus
- Inisialisasi nilai `min` dan `max` harus tepat (`siswa[0]`) sebelum perbandingan
- Rata-rata sebaiknya dikonversi ke `double` agar hasilnya akurat
- Menambahkan menu dan class membuat kode lebih terstruktur dan siap dikembangkan
- Penting mengecek kondisi array kosong sebelum melakukan proses seperti perhitungan total atau min/max
- Struktur class membantu memisahkan tugas-tugas logika, agar `main()` tidak terlalu panjang

---

## Tujuan Hari Ini:
- Memahami konsep dasar array 1 dimensi
- Menampilkan, menghitung, dan menganalisis data dari array
- Membangun program modular berbasis class
- Menyusun program dengan menu yang interaktif

---

## Target Hari ke-6:
- Mengenal **array 2 dimensi**
- Membuat **tabel data** seperti matriks nilai siswa
- Pencarian nilai dalam array (linear search)
- Penambahan fitur lanjutan seperti pengurutan nilai
- Meningkatkan struktur program berbasis class dan method

---

#### Dwi312