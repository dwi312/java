# Log Belajar Java Dasar - Hari 6
**Tanggal**: 2025-07-11  
**Folder**: `belajar-java/2025-07-11`

---

## Materi Dipelajari:
- **Array 2 Dimensi (`int[][]`)**
  - Menyimpan data nilai siswa dan mata pelajaran
  - Akses data dengan indeks `[baris][kolom]` → `[siswa][mapel]`
- Input jumlah siswa dan mata pelajaran secara dinamis
- Menampilkan data dalam bentuk tabel (per siswa)
- Menghitung:
  - Total nilai per siswa
  - Rata-rata nilai per siswa
- Pencarian nilai tertentu dan menampilkan posisinya
- Validasi kondisi array kosong sebelum diproses
- Pembuatan program berbasis class dan menu interaktif


- **Struktur Array 2 Dimensi**:
```java
// Contoh struktur array 2 dimensi
int[][] nilai = new int[jumlahSiswa][jumlahMapel];

// Input dan akses data
for (int i = 0; i < jumlahSiswa; i++) {
    for (int j = 0; j < jumlahMapel; j++) {
        nilai[i][j] = input.nextInt();
    }
}
```


---

## File yang Dibuat:
| Nama File              | Deskripsi                                                                |
| ---------------------- | ------------------------------------------------------------------------ |
| `NilaiSiswa2D.java`    | Class utama: input nilai, tampilkan tabel, hitung total, rata-rata, cari |
| `NilaiSiswaApp2D.java` | Menu interaktif menggunakan `switch-case` dan method dari objek class    |


### Fitur Program:
| No | Fitur                                  | Status        |
| -- | -------------------------------------- | ------------- |
| 1  | Input jumlah siswa dan jumlah mapel    | Selesai       |
| 2  | Input nilai tiap siswa dan mapel       | Selesai       |
| 3  | Menampilkan tabel nilai siswa          | Selesai       |
| 4  | Menampilkan total nilai per siswa      | Selesai       |
| 5  | Menampilkan rata-rata nilai per siswa  | Selesai       |
| 6  | Mencari nilai tertentu dalam array     | Selesai       |
| 7  | Cek array kosong sebelum proses        | Selesai       |
| 8  | Menu navigasi interaktif dengan switch | Selesai       |
| 9  | Urutan nilai tiap siswa (opsional)     | Belum dibuat  |

---

## Trial & Error:
- Penanganan null array dengan method cekArray() sangat efektif
- Perulangan 2 dimensi (for bersarang) digunakan untuk proses input dan output
- Proses pencarian nilai sudah mendukung multiple match (bisa ditemukan di beberapa posisi)
- Belum mengimplementasikan fitur pengurutan nilai (sudah diberi placeholder method)

---

## Catatan Pribadi:
- Array 2 dimensi sangat berguna untuk menyimpan data tabular seperti nilai siswa
- Penting untuk menginisialisasi array setelah tahu ukuran
- Program semakin kompleks, tapi dengan class dan method, struktur tetap rapi
- Validasi sebelum akses array sangat penting agar program tidak error
- Rencana untuk pengembangan fitur sorting bisa dilanjutkan di hari berikutnya

---

## Tujuan Hari Ini:
- Belajar menyimpan dan memproses data dengan array 2 dimensi
- Membuat program modular menggunakan class dan menu interaktif
- Melatih logika perulangan bersarang (nested loop)
- Memahami pencarian nilai dan pemosisian data

---

## Target Hari ke-7:
- Mengimplementasikan sorting nilai per siswa (misal dengan bubble sort)
- Menambahkan fitur tampilan rata-rata per mata pelajaran
- Menyimpan data ke file atau menampilkan statistik umum
- Menambahkan tampilan tabel yang lebih rapi

---

#### Dwi312