# Log Pengerjaan Tugas Studi Kasus: OOP - Array of Object

## Informasi Umum
- **Judul Tugas** : Manajemen Data Siswa (Array of Object)
- **Topik**       : OOP (Object-Oriented Programming)
- **Bahasa**      : Java
- **Struktur Data** : Array of Object (bukan ArrayList)

---

## Tujuan Pembelajaran
- Menerapkan prinsip OOP: enkapsulasi, class, dan object.
- Mengelola data menggunakan array tetap (`Siswa[]`) tanpa `ArrayList`
- Mengembangkan program modular berbasis menu.
- Menerapkan enkapsulasi melalui `private`, getter, dan setter
- Menyusun program modular berbasis menu interaktif

---

## Struktur Kelas

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

## Fitur yang Diimplementasikan

| No | Fitur                                | Status   |
|----|--------------------------------------|----------|
| 1  | Menambahkan data siswa               |  Selesai |
| 2  | Menampilkan semua data siswa         |  Selesai |
| 3  | Mengubah data siswa berdasarkan NIM  |  Selesai |
| 4  | Menghapus data siswa berdasarkan NIM |  Selesai |
| 5  | Mencari siswa berdasarkan NIM        |  Selesai |
| 6  | Menu interaktif dengan do-while      |  Selesai |
| 7  | Validasi input kosong/salah          |  Selesai |
| 8  | Validasi NIM duplikat & array penuh  |  Selesai |
| 9  | Modularisasi method dan folder       |  Selesai |

---

## Konsep OOP yang Digunakan

- **Encapsulation**: Semua atribut `Siswa` bersifat `private`, diakses melalui getter/setter
- **Class & Object**: Data siswa disimpan dalam array of object `Siswa[]`
- **Constructor**: Digunakan untuk inisialisasi objek
- **Modularisasi**: Program dibagi menjadi beberapa class (MVC sederhana)

---

## Catatan Tambahan
- Tugas telah dikerjakan **sesuai instruksi** (menggunakan 2 class utama), namun dikembangkan lebih lanjut secara modular.
- Struktur kode telah dipisah berdasarkan tanggung jawab (`controller`, `model`, `view`, `util`) sesuai prinsip MVC.
- Program mengikuti prinsip OOP dengan pemisahan class.
- Validasi input dan UX diperhatikan, Input sudah divalidasi dengan robust (angka, string kosong, rentang nilai).
- Program dapat dengan mudah dikembangkan lebih lanjut: penyimpanan file, sorting, pagination, dsb.
- Tidak menggunakan `ArrayList`, hanya `Siswa[]`.
- Program mudah dikembangkan (misal menambah file CSV atau ekspor).

---

## 🧪 Hasil Uji

- [x] Menambahkan siswa baru ✅
- [x] Menampilkan daftar siswa ✅
- [x] Mengubah data berdasarkan NIM ✅
- [x] Menghapus data siswa ✅
- [x] Mencari siswa berdasarkan NIM ✅
- [x] Validasi input dan NIM ganda ✅
- [x] Layar bersih ✅

---

## Status Akhir
- Struktur MVC sederhana:
    - Memisahkan controller, model, view, dan util. Ini tidak diwajibkan dalam tugas, tapi sangat bagus untuk pembelajaran lanjutan.
- Validasi NIM duplikat:
    - Mencegah entri ganda saat input
- Validasi nilai (0-100):
    - Tidak bisa input yang nilainya tidak valid (-10 dan diatas 100). 
- Pergeseran array saat hapus:
    - Supaya array tetap rapat (tidak ada null di tengah).
- Utility class `Util`:
    - Memisahkan logika input dan UI (misal clearScreen, enterToContinue).

| Aspek                                    |
| ---------------------------------------- |
| OOP & Modularisasi                       |
| Validasi Input                           |
| Struktur Folder / Package                |
| UX (tampilan, interaksi)                 |
| Manajemen Array of Object                |
| Fitur Bonus (validasi, hapus geser, dll) |

---

### Dwi312
