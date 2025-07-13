# Tugas Studi Kasus: OOP (Object-Oriented Programming)
## Studi Kasus: Manajemen Data Buku di Perpustakaan

---

## Deskripsi Masalah:
Perpustakaan ingin memiliki sistem sederhana untuk menyimpan dan menampilkan informasi buku. Buku terdiri dari dua jenis:
- Buku Cetak, memiliki atribut tambahan: jumlah halaman.
- Buku Digital, memiliki atribut tambahan: ukuran file (dalam MB).

---

## Tujuan Belajar:
- Membuat class induk (Buku) untuk menyimpan data umum.
- Membuat class turunan (BukuCetak dan BukuDigital) yang mewarisi dari Buku.
- Menggunakan constructor untuk inisialisasi data.
- Menerapkan enkapsulasi dengan private dan getter/setter.
- Menerapkan polimorfisme dengan method overriding.

---

## Spesifikasi:
1. **Class Buku (Superclass)**
- Atribut:
    - `judul`
    - `penulis`
    - `tahunTerbit`
- Method:
    - Constructor untuk inisialisasi
    - Getter (dan setter jika perlu)
    - `tampilkanInfo()` untuk menampilkan detail umum
2. **Class BukuCetak (Subclass)**
- Tambahan atribut:
    - `jumlahHalaman`
- Override `tampilkanInfo()` untuk menampilkan semua data termasuk jenis buku
3. **Class BukuDigital (Subclass)**
- Tambahan atribut:
    - `ukuranFileMB`
- Override `tampilkanInfo()` untuk menampilkan semua data termasuk jenis buku
4. **Class Main**
- Buat objek dari BukuCetak dan `BukuDigital`
- Tampilkan informasi buku menggunakan method `tampilkanInfo()`

---

## Struktur Folder yang Disarankan:
```
PerpustakaanOOP/
├── Buku.java
├── BukuCetak.java
├── BukuDigital.java
└── Main.java

```
---

## Output yang Diharapkan (Contoh):
```
Judul: Java Dasar
Penulis: Dwi Susilo
Tahun Terbit: 2024
Jenis: Buku Cetak
Jumlah Halaman: 320
------------------------
Judul: Pemrograman Web
Penulis: Atmojo
Tahun Terbit: 2025
Jenis: Buku Digital
Ukuran File: 2.5 MB
------------------------

```
---

#### Selamat mencoba!