# Tugas Studi Kasus: Manajemen Data Buku di Perpustakaan
## Tanggal: 2025-07-13  

---

## Studi Kasus: Manajemen Data Buku di Perpustakaan

### Tujuan Pembelajaran:
- Menerapkan konsep Object-Oriented Programming (OOP) dalam Java.
- Membuat struktur program berbasis class dan object.
- Memahami konsep inheritance, enkapsulasi, constructor, dan polymorphism (overriding).

---

## Fitur Program yang Diimplementasikan:
1. **Class `Buku` (Superclass)**
   - Atribut: `judul`, `penulis`, `tahunTerbit`
   - Method: constructor, getter/setter, `tampilkanInfo()`

2. **Class `BukuCetak` (Subclass)**
   - Tambahan atribut: `jumlahHalaman`
   - Override method `tampilkanInfo()` untuk menampilkan info tambahan

3. **Class `BukuDigital` (Subclass)**
   - Tambahan atribut: `ukuranFileMB`
   - Override method `tampilkanInfo()` untuk menampilkan info tambahan

4. **Class `Main`**
   - Membuat dan menguji objek dari `BukuCetak` dan `BukuDigital`
   - Menampilkan semua informasi buku ke terminal

---

## Konsep OOP yang Diterapkan:
| Konsep         | Status | Keterangan                                       |
|----------------|--------|--------------------------------------------------|
| Class & Object | ✅     | Menggunakan `Buku`, `BukuCetak`, `BukuDigital`   |
| Constructor    | ✅     | Digunakan untuk inisialisasi semua objek         |
| Enkapsulasi    | ✅     | Atribut `private`, akses via getter/setter       |
| Inheritance    | ✅     | `extends` dari class `Buku`                      |
| Polimorfisme   | ✅     | Override `tampilkanInfo()` di subclass           |

---

## Hasil Uji Program:

```text
Judul: Doraemon
Penulis: Fujitsu
Tahun Terbit: 1984
Jenis: Buku Cetak
Jumlah Halaman: 100
------------------------
Judul: Dragon Ball
Penulis: Akira Toriyama
Tahun Terbit: 1990
Jenis: Buku Digital
Ukuran File: 10.0 MB
------------------------
```
Output sesuai dengan spesifikasi. Tidak ada error.

---

## Catatan Tambahan:
- Struktur class sudah modular dan mudah dikembangkan.
- Bisa diperluas dengan fitur input pengguna (Scanner) atau manajemen array of object.

---

## Rencana Selanjutnya:
- Menambahkan input dinamis dari pengguna.
- Menyimpan dan membaca data buku dari file .txt atau .csv.
- Menampilkan daftar semua buku menggunakan array dan perulangan.

---

#### © 2025 Dwi312 – Studi Kasus: OOP (Object-Oriented Programming)