# Log Belajar Java Dasar - Hari 9
**Tanggal**: 2025-07-11
**Folder**: `belajar-java/2025-07-14`

---

## Materi Dipelajari:
- **Input/Output (I/O) File Sederhana di Java**:
  - Membaca dan menulis data ke/dari file teks (.txt, .csv).
  - Penggunaan kelas-kelas dasar I/O: `FileReader`, `BufferedReader`, `FileWriter`, `PrintWriter`.
  - Penanganan pengecualian `IOException` dan `FileNotFoundException`.
  - Pentingnya menutup aliran (stream) I/O dan penggunaan `try-with-resources`.
  - Konsep mode penulisan file: Overwrite (menimpa) vs. Append (menambahkan).

## File yang Dibuat/update:
- `SiswaController.java` (kelas utama untuk logika program manajemen siswa)
- `data_siswa.txt` (file teks untuk menyimpan data siswa)

---

### Fitur Program:
- Mengubah data siswa yang sudah ada (berdasarkan NIM).
- Menambah Menu pilihan:
  - `6. Simpan data ke file`
  - `7. Ambil data dari file`
- Menyimpan data siswa ke file `data_siswa.txt`.
- Mengambil/memuat data siswa dari file `data_siswa.txt`.
- Mengelola kapasitas array daftarSiswa secara dinamis (resize dan shrink).

---

##  Hasil Uji:
- Program berhasil menyimpan data siswa ke `data_siswa.txt` dengan format NIM,Nama,Nilai, termasuk baris header.
- Program berhasil memuat data siswa dari `data_siswa.txt`, mengabaikan baris header, dan menangani format yang tidak valid atau NIM duplikat di file.
- Operasi CRUD (Create, Read, Update, Delete) pada data siswa di memori bekerja dengan baik.
- NIM duplikat dicegah saat penambahan siswa baru dan ditangani saat pemuatan dari file.
- Data di file konsisten dengan data di memori saat program keluar (karena mode overwrite saat menyimpan).

---

##   Struktur Folder:
2025-07-11/
├── Siswa.java
├── SiswaApp.java
├── SiswaController.java
├── data_siswa.txt
└── log.md

---

##  apa itu I/O File Sederhana:
- I/O File Sederhana dalam Java berarti proses dasar Input/Output (I/O) data ke atau dari file di penyimpanan (disk). Ini digunakan untuk:
  - Menyimpan data agar tidak hilang saat program ditutup (misalnya data siswa).
  - Membaca kembali data yang telah disimpan sebelumnya.

**Kapan kita butuh apa itu I/O File Sederhana**
- Aplikasi perlu menyimpan atau memuat data secara persisten, bahkan setelah program ditutup. 
- Saat kita ingin menyimpan data dari program ke luar (misalnya ke .txt atau .csv).
- membaca data ke dalam program tanpa database.
- Fleksibilitas untuk mengedit data secara manual di luar program.
- Volume data tidak terlalu besar atau kompleks.

**Pengertian Sederhana:**
- I/O sederhana maksudnya:
  - Menggunakan file teks biasa (`.txt`, `.csv`)
  - Memakai class dasar di Java seperti:
    - `FileWriter`, `PrintWriter` → untuk menulis ke file
    - `FileReader`, `BufferedReader` → untuk membaca dari file
  - Tidak menggunakan database, JSON, atau library eksternal

---

## Contoh Penggunaan:
**menyimpan :**
```java
try (FileWriter fw = new FileWriter("data.txt");
     PrintWriter pw = new PrintWriter(fw)) {
    pw.println("230001,Andi,90");
    pw.println("230002,Budi,75");
} catch (IOException e) {
    e.printStackTrace();
}
```

**Membaca:**
```java
try (FileReader fr = new FileReader("data.txt");
     BufferedReader br = new BufferedReader(fr)) {
    String baris;
    while ((baris = br.readLine()) != null) {
        System.out.println("Baris: " + baris);
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

---

## Trial & Error:
- `FileNotFoundException` & `IOException`: Awalnya muncul karena inisialisasi `FileReader`/`FileWriter` di luar blok `try-catch`. Solusi: Memindahkan inisialisasi ke dalam blok `try-with-resources` di metode `bacaDariFile()` dan `simpanDataFile()`.
- **Duplikasi NIM** di `tambahSiswa()`: Logika pengecekan NIM duplikat awal salah, selalu menandai `nimDuplikat` sebagai `true` jika ada data. Solusi: Membandingkan NIM yang diinput dengan `getNim()` dari setiap siswa di `daftarSiswa`.
- **Duplikasi Data dan Header saat Menyimpan**: Menggunakan `FileWriter(filePath, true)` (append mode) dengan `simpanFile.println("NIM, Nama, Nilai")` menyebabkan duplikasi header dan seluruh data setiap kali disimpan. Solusi: Kembali ke mode overwrite (`FileWriter(filePath)`) dan pastikan `bacaDariFile()` membersihkan data sebelum memuat, sehingga file selalu mencerminkan status memori terkini.
- Pemuatan Otomatis Data: Awalnya data tidak dimuat saat program dimulai. Solusi: Memanggil bacaDariFile() di awal metode run().

---

## Catatan Pribadi:
> I/O File itu penting untuk persistensi data, meskipun sederhana.
> `try-with-resources` adalah teman terbaik saat berurusan dengan resource yang perlu ditutup (seperti file). Sangat mempermudah hidup!
> Memahami perbedaan antara overwrite dan append sangat krusial saat menyimpan data ke file. Untuk aplikasi manajemen data, overwrite biasanya lebih aman dan konsisten.
> Validasi input dan penanganan pengecualian sangat penting agar program robust dan tidak crash karena input yang tidak terduga atau masalah file.
> Struktur kode yang rapi (misalnya, memisahkan logika Siswa dari SiswaController) membantu keterbacaan dan pemeliharaan.
---

## Tujuan Hari Ini:
- Memahami konsep dasar I/O File di Java.
- Mampu membaca data dari file teks ke dalam program.
- Mampu menyimpan data dari program ke file teks.
- Mengintegrasikan fungsionalitas I/O file ke dalam program manajemen siswa yang sudah ada.
- Mengatasi masalah-masalah umum terkait I/O file (pengecualian, duplikasi, format).

---

## Target Hari ke-10:
- Ganti array dengan ArrayList<Siswa> → lebih ringkas dan profesional.
- Pisahkan ke dalam package → struktur seperti model, controller, app.
- Belajar sedikit enum, static, dan final untuk menambah kekuatan program.
- Eksplor fitur lanjutan file seperti simpan otomatis, backup, atau export ke format yang bisa dibuka Excel.
- Implementasi unit test (opsional) untuk testing method secara otomatis.

---

#### Dwi312
