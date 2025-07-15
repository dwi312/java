# Tugas Studi Kasus: OOP (Object-Oriented Programming) - Array of Object
## Studi Kasus: Sistem Pengelolaan Perpustakaan

---

## Deskripsi :
Membuat aplikasi console untuk mengelola data buku dan anggota perpustakaan dengan fitur peminjaman dan pengembalian.

---

## Tujuan Belajar :
- Menggunakan lebih dari satu class (`Buku`, `Anggota`, `Transaksi`)
- Menerapkan **array of object** untuk menyimpan data
- Modularisasi method dan logika menu
- Validasi dan pencarian berdasarkan atribut
- (Opsional) Menerapkan **inheritance** atau **relasi antar objek**

---

## Spesifikasi Program :
- **Struktur Data**:
```
Buku[] daftarBuku = new Buku[10];
Anggota[] daftarAnggota = new Anggota[10];
Transaksi[] daftarTransaksi = new Transaksi[20]; (opsional)

```
- **Fitur Program**:
```
| Menu                  | Deskripsi                                |
| --------------------- | ---------------------------------------- |
| 1. Tambah Buku        | Input data buku dan simpan ke array      |
| 2. Tambah Anggota     | Input data anggota                       |
| 3. Daftar Buku        | Menampilkan semua buku                   |
| 4. Daftar Anggota     | Menampilkan semua anggota                |
| 5. Pinjam Buku        | Pilih buku dan anggota, simpan transaksi |
| 6. Kembalikan Buku    | Tandai buku sebagai kembali              |
| 7. Riwayat Peminjaman | Menampilkan data peminjaman (opsional)   |
| 8. Keluar             | Selesai                                  |

```

**Class yang Dibuat**:
- `Buku`: kodeBuku, judul, penulis, status (tersedia/dipinjam)
- `Anggota`: idAnggota, nama, kontak
- `Transaksi`: idTransaksi, idAnggota, kodeBuku, tanggalPinjam, tanggalKembali

---

## Ketentuan:
- Tidak menggunakan `ArrayList`, gunakan `array[]` biasa.
- Input menggunakan `Scanner`.
- Menu menggunakan `do-while` atau `while`.
- Gunakan pendekatan modular: pisahkan fungsi per fitur dalam method berbeda.
- Data disimpan sementara (tidak perlu disimpan ke file atau database).
- Gunakan validasi sederhana (misalnya: buku sudah dipinjam tidak bisa dipinjam lagi).

---

## Output yang Diharapkan (Contoh) :
```
=== SISTEM PERPUSTAKAAN SEDERHANA ===

1. Tambah Buku
2. Tambah Anggota
3. Daftar Buku
4. Daftar Anggota
5. Pinjam Buku
6. Kembalikan Buku
7. Riwayat Peminjaman
0. Keluar
-------------------------------------
Pilih menu: 1

Masukkan kode buku : B001
Masukkan judul buku : Belajar Java
Masukkan penulis : Akira toriyama
Data buku berhasil ditambahkan!

```
---

## Tantangan Tambahan (Opsional) :
- Buat validasi buku sudah dipinjam
- Cegah anggota meminjam lebih dari 2 buku
- Sorting buku berdasarkan judul (bonus)
- Pencarian anggota berdasarkan nama atau ID

---

#### Selamat mencoba dan Semangat Mengerjakan!