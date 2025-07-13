# Tugas Studi Kasus: OOP (Object-Oriented Programming) - Array of Object
## Studi Kasus: Manajemen Data Siswa

---

## Deskripsi Masalah:
Buatlah sebuah program Java sederhana untuk mengelola data siswa menggunakan Array of Object. Setiap siswa memiliki atribut:
- nama (String)
- nim (String)
- nilai (int)
Gunakan array tetap (misalnya 5 siswa) dan implementasikan operasi dasar secara manual (**tanpa ArrayList**).

---

## Tujuan Belajar:
- Membuat class Siswa untuk menyimpan data siswa (Object-Oriented Programming).
- Menggunakan constructor untuk inisialisasi data.
- Menerapkan enkapsulasi (menggunakan private dan getter/setter).
- Mengelola data menggunakan array object (Siswa[]).


---

## Spesifikasi Program:
1. **Class `Siswa`**
- Atribut: `nama`, `nim`, `nilai`
- Method:
    - Constructor untuk inisialisasi
    - Getter (dan setter jika perlu)
    - `tampilkanInfo()` untuk menampilkan data siswa
2. **Class `Main` atau class lain**:
Implementasikan fitur berikut dalam bentuk menu:
| No | Fitur                                | Keterangan                                               |
| -- | ------------------------------------ | -------------------------------------------------------- |
| 1  | Menambahkan data siswa ke array      | Input data siswa dan simpan ke elemen array yang kosong  |
| 2  | Menampilkan semua data siswa         | Tampilkan semua data siswa yang sudah diisi (tidak null) |
| 3  | Mengubah data siswa berdasarkan NIM  | Cari siswa berdasarkan NIM, lalu ubah nama atau nilainya |
| 4  | Menghapus data siswa berdasarkan NIM | Set elemen array menjadi `null` jika data ditemukan      |
| 5  | Mencari siswa berdasarkan nama/NIM   | Cari dan tampilkan data siswa jika ditemukan             |

---

## Ketentuan:
- Gunakan deklarasi:
```java
 Siswa[] daftarSiswa = new Siswa[5];
```
- **Tidak menggunakan** `ArrayList`
- Gunakan `Scanner` untuk input data dari pengguna
- Gunakan perulangan `for`, `while`, atau `do-while` untuk mengelola array dan menu

---

## Output yang Diharapkan (Contoh):
```
=== PROGRAM MANAJEMEN DATA SISWA ===

1. Tambah Siswa
2. Tampilkan Semua Siswa
3. Ubah Data Siswa
4. Hapus Siswa
5. Cari Siswa
6. Keluar
---------------------------
Pilih menu (1-6): 1

Masukkan Nama Siswa  : Jokowow
Masukkan NIM         : 23001
Masukkan Nilai       : 85
Data siswa berhasil ditambahkan!

Pilih menu (1-6): 1

Masukkan Nama Siswa  : Phbowow
Masukkan NIM         : 23002
Masukkan Nilai       : 90
Data siswa berhasil ditambahkan!

Pilih menu (1-6): 2

=== DAFTAR SISWA ===
1. Jokowow | NIM: 23001 | Nilai: 85
2. Phbowow | NIM: 23002 | Nilai: 90
do-while
Pilih menu (1-6): 3

Masukkan NIM yang ingin diubah: 23001
Masukkan Nama Baru  : Jokowow
Masukkan Nilai Baru : 95
Data siswa berhasil diperbarui.

Pilih menu (1-6): 5

Masukkan NIM yang dicari: 23002
Siswa ditemukan:
Nama  : Phbowow
NIM   : 23002
Nilai : 90

Pilih menu (1-6): 4

Masukkan NIM yang ingin dihapus: 23002
Data siswa berhasil dihapus.

Pilih menu (1-6): 2

=== DAFTAR SISWA ===
1. Jokowow | NIM: 23001 | Nilai: 95

Pilih menu (1-6): 6
Terima kasih telah menggunakan program!


```
---

## Tantangan Tambahan (Opsional):
- Buat method modular seperti:
  - tambahSiswa()
  - hapusSiswa()
  - ubahSiswa()
  - tampilkanSemua()
- Tambahkan validasi jika:
  - NIM duplikat
  - Array sudah penuh
  - Data tidak ditemukan saat diubah/dihapus
- Tambahkan penomoran otomatis saat menampilkan data siswa

---

#### Selamat mencoba dan Semangat Mengerjakan!