# Log Belajar Java Dasar - hari 3
tanggal : 2025-07-08
Folder : `belajar-java/2025-07-08`

## Materi Dipelajari :
- Struktur percabangan `if`, `else if`, dan `else`
- Struktur `switch-case` dan penggunaannya untuk kondisi tetap
- Perbedaan antara `if` dan `switch`
- Validasi input menggunakan `Scanner`
- Penanganan input tidak valid tanpa `AssertionError`

### 🔹 Struktur if - else if - else
- Struktur ini digunakan ketika kita ingin mengevaluasi kondisi secara bertingkat.
```java
if (nilai >= 90) {
    System.out.println("A");
} else if (nilai >= 80) {
    System.out.println("B");
} else {
    System.out.println("C atau di bawahnya");
}
```

---

### 🔹 Struktur switch-case
- Cocok digunakan jika kondisi bersifat tetap dan spesifik (misalnya angka pilihan menu).
```java
switch (kode) {
    case 1:
        System.out.println("Pilihan 1");
        break;
    case 2:
        System.out.println("Pilihan 2");
        break;
    default:
        System.out.println("Pilihan tidak valid");
}
```

---

## File yang dibuat :
| Nama File          | Deskripsi                                                                  |
|--------------------|----------------------------------------------------------------------------|
| `CekBilangan.java` | Mengecek apakah bilangan positif, negatif, atau nol + ganjil/genap         |
| `NamaHari.java`    | Menampilkan nama hari berdasarkan angka (1–7) menggunakan `switch-case`    |
| `KategoriUmur.java`| (Opsional) Menentukan kategori umur dengan `if - else if - else`           |

---

## Trial & Error :
- Program berhasil memeriksa bilangan positif/negatif dan genap/ganjil
- Percobaan menggunakan `else if` tanpa `if` → **Error: else without if**
- Menggunakan `throw new AssertionError()` di `switch-case` → program berhenti secara kasar
- Solusi: gunakan `default:` dengan `System.out.println(...)` dan `return;` agar aman


---

## Catatan Pribadi :
- `if` cocok untuk kondisi bertingkat (misalnya rentang nilai)
- `switch` cocok untuk pilihan tetap seperti hari, bulan, menu
- Jangan gunakan `AssertionError` untuk memvalidasi input dari pengguna
#### Apa itu `AssertionError()` ?
    `AssertionError` adalah jenis exception di Java yang biasanya:
    - Digunakan untuk debugging internal oleh programmer
    - Bukan untuk ditampilkan kepada pengguna
    - Jika muncul, program akan langsung berhenti (crash)
- Tutup `Scanner` setelah selesai (`input.close();`) agar tidak muncul warning
- Latihan ini membantu memahami logika percabangan yang penting untuk kontrol program

---

## Tujuan Hari ini :
- Mampu menggunakan `if`, `else if`, dan `else` dalam berbagai kondisi
- Menggunakan `switch-case` secara tepat dan aman
- Menulis program yang bisa berinteraksi dengan input pengguna
- Mendokumentasikan log dan source code dengan rapi

---

## Target Besok :
- Belajar struktur perulangan: `for`, `while`, `do while`
- Membuat program:
  - Menampilkan bilangan genap/ganjil hingga N
  - Menghitung faktorial dari sebuah angka
  - Menampilkan deret angka (misal: 1 2 3 ... n)
  - Membuat tabel perkalian (nested loop)

---
#### Dwi312