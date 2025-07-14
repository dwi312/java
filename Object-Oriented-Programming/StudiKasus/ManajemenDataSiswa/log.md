# 📘 Log Pengerjaan Tugas Studi Kasus: OOP - Array of Object

## 📝 Informasi Umum
- **Judul Tugas** : Manajemen Data Siswa (Array of Object)
- **Topik**       : OOP (Object-Oriented Programming)
- **Bahasa**      : Java
- **Struktur Data** : Array of Object (bukan ArrayList)

---

## 🎯 Tujuan Pembelajaran
- Menerapkan prinsip OOP: enkapsulasi, class, dan object.
- Mengelola data menggunakan array tetap (`Siswa[] daftarSiswa = new Siswa[5];`).
- Mengembangkan program modular berbasis menu.
- Menggunakan Scanner untuk input data dinamis dari pengguna.

---

## 🧱 Struktur Kelas

### 1. `Siswa`
- Atribut: `nama`, `nim`, `nilai`
- Method:
  - Constructor
  - Getter dan Setter
  - `tampilkanInfo()`

### 2. `SiswaController`
- Menangani logika program (CRUD)
- Fitur:
  - Tambah siswa
  - Tampilkan semua
  - Ubah siswa
  - Hapus siswa
  - Cari siswa

### 3. `SiswaView`
- Menampilkan menu ke layar

### 4. `Util`
- Fungsi utilitas:
  - Validasi input
  - Clear screen
  - Tekan Enter untuk lanjut

### 5. `Main`
- Menjalankan program utama dengan `siswa.run();`

---

## ✅ Fitur yang Diimplementasikan

| No | Fitur                                | Status   |
|----|--------------------------------------|----------|
| 1  | Menambahkan data siswa               | ✅ Selesai |
| 2  | Menampilkan semua data siswa         | ✅ Selesai |
| 3  | Mengubah data siswa berdasarkan NIM  | ✅ Selesai |
| 4  | Menghapus data siswa berdasarkan NIM | ✅ Selesai |
| 5  | Mencari siswa berdasarkan NIM        | ✅ Selesai |
| 6  | Menu interaktif dengan do-while      | ✅ Selesai |
| 7  | Validasi input kosong/salah          | ✅ Selesai |
| 8  | Validasi NIM duplikat & array penuh | ✅ Selesai |
| 9  | Modularisasi method dan folder       | ✅ Selesai |

---

## 📂 Struktur Folder dan File

src/
├── Main.java
├── controller/
│ └── SiswaController.java
├── model/
│ └── Siswa.java
├── view/
│ └── SiswaView.java
└── util/
└── Util.java


---

## 💡 Catatan Tambahan
- Program mengikuti prinsip OOP dengan pemisahan class.
- Tidak menggunakan `ArrayList`, hanya `Siswa[]`.
- Input sudah divalidasi dengan robust (angka, string kosong, rentang nilai).
- Program mudah dikembangkan (misal menambah file CSV atau ekspor).

---

## 🧪 Hasil Uji

- [x] Menambahkan siswa baru ✅
- [x] Menampilkan daftar siswa ✅
- [x] Mengubah data berdasarkan NIM ✅
- [x] Menghapus data siswa ✅
- [x] Mencari siswa berdasarkan NIM ✅
- [x] Validasi input dan NIM ganda ✅

---

## 🏁 Status Akhir
**✅ Tugas berhasil diselesaikan dengan lengkap dan sesuai instruksi.**

---

### Dwi312
