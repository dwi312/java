# Log Belajar Java Dasar - Hari 7
**Tanggal**: 2025-07-12  
**Folder**: `belajar-java/2025-07-12`

---

## Materi Dipelajari:

- **Array 2 Dimensi**:
  - Menyimpan data nilai siswa dalam format `int[][]`
  - Menampilkan tabel nilai siswa berdasarkan baris (siswa) dan kolom (mapel)
  - Menghitung total nilai dan rata-rata per siswa
  - Mencari nilai tertentu dalam array 2D
  - Validasi array kosong sebelum proses

- **Algoritma Bubble Sort**:
  - Digunakan untuk **mengurutkan nilai setiap siswa** dari kecil ke besar
  - Implementasi sorting dilakukan per baris dalam array 2 dimensi

```java
// Contoh struktur Bubble Sort dalam array 2 dimensi
for (int i = 0; i < jumlahSiswa; i++) {
    for (int j = 0; j < jumlahMapel - 1; j++) {
        for (int k = 0; k < jumlahMapel - j - 1; k++) {
            if (nilai[i][k] > nilai[i][k + 1]) {
                int temp = nilai[i][k];
                nilai[i][k] = nilai[i][k + 1];
                nilai[i][k + 1] = temp;
            }
        }
    }
}
```
---

## Update file dari :
**Folder**: `belajar-java/2025-07-11`
| File                   | Deskripsi                                                         |
| ---------------------- | ----------------------------------------------------------------- |
| `NilaiSiswa2D.java`    | Logic array 2D: input, tampil, hitung total/rata-rata, cari, sort |
| `NilaiSiswaApp2D.java` | Menu interaktif yang memanggil method pada objek `NilaiSiswa2D`   |




### Fitur Program:
Menu interaktif untuk menjalankan fungsi:
- Mengurutkan nilai per siswa (Bubble sort)

---

## Trial & Error:
- Tantangan saat mengimplementasikan Bubble Sort pada array 2 dimensi.

---

## Catatan Pribadi:
- Mengurutkan nilai per siswa membutuhkan pemahaman sorting per baris array.
- Penting untuk memahami cara kerja nested loop untuk array 2D.
- Program semakin kompleks, tapi mudah dikelola karena dipisah ke method dan class.

---

## Tujuan Hari Ini:
- Menambahkan logika engurutan nilai sebagai fitur lanjutan.
- Meningkatkan penguasaan array 2 dimensi.
- Memahami implementasi algoritma sorting (bubble sort) pada array 2D.

---

## Rangkuman Capaian Hari ke-7:
- Array 2 Dimensi lanjutan
- Pengurutan nilai per siswa menggunakan Bubble Sort
- Struktur data 2D dengan logika nested loop

---

## Target Hari ke-8:
- Mengenal konsep array of object
- Menyimpan dan menampilkan data lengkap siswa (nama, NIM, nilai)
- Meningkatkan struktur program dengan class Siswa
- Menampilkan ranking siswa berdasarkan nilai tertinggi

---

#### Dwi312