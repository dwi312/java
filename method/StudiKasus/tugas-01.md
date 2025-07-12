# Tugas Studi Kasus: Method dalam Java

## Studi Kasus: Aplikasi Pengelolaan Nilai Mahasiswa

### Deskripsi Masalah
Anda diminta membuat aplikasi sederhana untuk mengelola data nilai mahasiswa. Aplikasi ini mampu:
1. Menampilkan judul aplikasi.
2. Menambah data nilai mahasiswa ke dalam daftar.
3. Menghitung rata-rata nilai dari daftar mahasiswa.
4. Menampilkan semua data mahasiswa beserta nilainya.
5. Mencari mahasiswa dengan nilai tertinggi.

### Kelas dan Method yang Dibutuhkan

#### 1. Kelas Mahasiswa
- **Field:** `String nama`, `int nilai`
- **Method:** Constructor, getter/setter (opsional)

#### 2. Kelas Main
- Buat `ArrayList<Mahasiswa>` untuk menyimpan data.
- Implementasikan method berikut:

| Nama Method                | Tipe      | Parameter                       | Return      | Fungsi                                                                 |
|----------------------------|-----------|----------------------------------|-------------|-----------------------------------------------------------------------|
| tampilJudul                | static    | -                                | void        | Menampilkan judul aplikasi                                            |
| tambahMahasiswa            | static    | (ArrayList<Mahasiswa> daftar)    | void        | Menambah mahasiswa dengan input nama dan nilai                        |
| tampilkanData              | static    | (ArrayList<Mahasiswa> daftar)    | void        | Menampilkan seluruh data mahasiswa                                    |
| hitungRataNilai            | static    | (ArrayList<Mahasiswa> daftar)    | double      | Menghitung dan mengembalikan rata-rata nilai                          |
| cariNilaiTertinggi         | static    | (ArrayList<Mahasiswa> daftar)    | Mahasiswa   | Mengembalikan objek Mahasiswa dengan nilai tertinggi                  |

### Instruksi
1. Buat kelas `Mahasiswa` sesuai kebutuhan di atas.
2. Buat kelas utama (`Main`) dan implementasikan semua method sesuai tabel.
3. Di dalam `main`, buat menu sederhana untuk menjalankan fungsi-fungsi di atas.
4. Gunakan konsep **static method** untuk utility yang tidak bergantung pada objek.
5. Praktikkan penggunaan parameter dan return value.
6. Pastikan program modular dan mudah dikembangkan.

### Contoh Output (minimal)
```
== APLIKASI NILAI MAHASISWA ==
1. Tambah data mahasiswa
2. Tampilkan semua data
3. Hitung rata-rata nilai
4. Cari nilai tertinggi
5. Keluar
Pilih menu: 1
Nama: Budi
Nilai: 80
...
Pilih menu: 3
Rata-rata nilai: 78.5
...
Pilih menu: 4
Mahasiswa dengan nilai tertinggi: Budi (80)
```

### Catatan
- Gunakan method sesuai struktur dan penjelasan pada file README.
- Tidak perlu membuat GUI, cukup aplikasi konsol.
- Bonus: Tambahkan validasi input jika ingin lebih menantang.

---

Selamat mencoba!