# Log Belajar Java Dasar - Hari 4
📅 Tanggal : 2025-07-09  
📁 Folder : `belajar-java/2025-07-09`

---

## Materi Dipelajari:
- Struktur perulangan:
  - `for`
  - `while`
  - `do while`

### Struktur `for`
```java
for (int i = 1; i <= N; i++) {
    System.out.println(i);
}
```

### Struktur `while`
```java
int i = 1;
while (i <= N) {
    System.out.println(i);
    i++;
}
```

### Struktur `do while`
```java
int i = 1;
do {
    System.out.println(i);
    i++;
} while (i <= N);
```

- Penggunaan perulangan dalam studi kasus:
  - Deret angka
  - Bilangan genap & ganjil
  - Faktorial
  - Tabel perkalian
  - Deret Fibonacci
- Struktur menu interaktif untuk latihan
- Pemisahan logika ke dalam fungsi (`method`) sederhana

---

## File yang Dibuat:
| Nama File             | Deskripsi                                                                 |
|-----------------------|---------------------------------------------------------------------------|
| `DeretAngka.java`     | Mencetak angka 1 sampai N dengan `for`, `while`, dan `do while`           |
| `GenapGanjil.java`    | Menampilkan bilangan genap dan ganjil hingga N                            |
| `Faktorial.java`      | Menghitung faktorial dari N menggunakan tiga jenis loop                   |
| `TabelPerkalian.java` | Membuat tabel perkalian NxN menggunakan nested loop                       |
| `Latihan1.java`       | Soal latihan: jumlah bilangan, kelipatan 3, segitiga bintang, Fibonacci   |

---

## Trial & Error:
- Salah letak `hasil = 1;` menyebabkan hasil faktorial tidak reset → ✅ diperbaiki
- Kesalahan logika nested loop ditelusuri saat buat segitiga bintang → ✅ diperbaiki
- Deret Fibonacci ditulis dengan penjelasan proses perubahan nilai `a`, `b`, dan `next`
- Menu dibuat interaktif dengan `do while` + `switch-case`

---

## Catatan Pribadi:
- `for` cocok untuk jumlah iterasi yang pasti
- `while` dan `do while` cocok untuk kondisi dinamis
- Faktorial butuh `hasil` di-reset tiap kasus
- Deret Fibonacci dimulai dari 0 dan 1, lalu menjumlahkan dua bilangan sebelumnya
- `next = a + b; a = b; b = next;` adalah dasar algoritma Fibonacci
- Bilangan prima akan dipelajari lebih lanjut
- Gunakan `method` untuk memecah logika agar lebih rapi (dipelajari mulai besok)

---

## Tujuan Hari Ini:
- Memahami dan menerapkan berbagai jenis perulangan
- Mampu mengolah input & menampilkan output sesuai pola
- Mengorganisir logika kontrol dalam menu yang sistematis
- Mencatat hasil belajar dan pengamatan secara terstruktur

---

## Target Hari ke-5:
- Mengenal **array 1 dimensi**
- Menyimpan & mengakses banyak nilai
- Mencari nilai **maksimum, minimum, total, dan rata-rata**
- Membuat program sederhana seperti:
  - Nilai siswa
  - Deret angka menggunakan array
  - Pencarian angka tertentu dalam array

---

✍️ **Dwi312**
