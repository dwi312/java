---

## Catatan Teknis: Penggunaan Class dan Non-Static Method

Dalam instruksi awal, disarankan menggunakan `static method` untuk fitur seperti `tambahMahasiswa`, `hitungRataNilai`, dan lainnya. Namun, dalam implementasi tugas ini saya memilih menggunakan **pendekatan berbasis OOP (Object-Oriented Programming)** dengan struktur **MVC sederhana**.

### Alasan Memilih Pendekatan OOP:

1. **Skalabilitas & Reusability:**
   - Dengan membungkus method ke dalam class (`Services`, `Controller`), program lebih mudah dikembangkan dan dikelola.
   - Misalnya, jika nanti ditambahkan fitur seperti edit, hapus, atau ekspor file, cukup tambahkan method ke class terkait tanpa mengubah struktur utama.

2. **Enkapsulasi:**
   - Data `ArrayList<Mahasiswa>` dikelola oleh class `Services`, sehingga akses ke data dikontrol dan tidak langsung tersebar di program.

3. **Modular & Tanggung Jawab Jelas:**
   - `Mahasiswa` → menyimpan data
   - `Services` → mengelola data
   - `Controller` → logika aplikasi dan antarmuka pengguna
   - `Main` → titik masuk aplikasi
   - Ini sejalan dengan prinsip *Single Responsibility* dalam desain OOP.

4. **Non-static = Lebih Sesuai untuk OOP:**
   - Karena method bekerja atas objek `services` atau `controller`, maka **lebih alami menggunakan non-static method**.
   - Jika menggunakan `static`, semua data dan method akan jadi global, dan sulit dikelola saat aplikasi tumbuh besar.

---

### Hasil Uji:
| Skenario Uji                         | Status | Catatan                                    |
|--------------------------------------|--------|---------------------------------------------|
| Tambah data mahasiswa                | ✅     | Berhasil menambah dan menyimpan data        |
| Input tidak valid (string/spasi)     | ✅     | Ditolak dengan pesan kesalahan              |
| Hitung rata-rata nilai kosong        | ✅     | Ditangani dengan pesan "Data masih kosong"  |
| Cari nilai tertinggi                 | ✅     | Mengembalikan objek Mahasiswa tertinggi     |
| Input nilai di luar rentang (0-100)  | ✅     | Ditolak dan diminta input ulang             |

---

### Evaluasi Pribadi:
- Memahami penggunaan method dengan parameter dan return.
- Mampu membuat program yang modular dan terstruktur.
- Mengetahui pentingnya validasi input.
- Menguasai dasar penggunaan ArrayList dan OOP.
- Perlu latihan lebih lanjut untuk fitur lanjutan seperti edit, hapus, dan ekspor file
---
### Kesimpulan:
Pendekatan yang saya gunakan tetap memenuhi seluruh fungsi yang diminta dalam studi kasus, **namun dengan desain yang lebih modular, bersih, dan mendekati praktik industri nyata.**  
Dengan kata lain, saya tetap memahami penggunaan `static method`, tapi **sengaja memilih pendekatan yang lebih baik untuk jangka panjang.**

---

## Catatan Tambahan
- Program ini dibuat sebagai bagian dari latihan *studi kasus method dalam Java*.
- Tidak menggunakan library eksternal, hanya `java.util.*`.
---