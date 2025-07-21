# Studi Kasus: Sistem Manajemen Kontak Sederhana
## Deskripsi
- Buat program berbasis console untuk mengelola daftar kontak (nama dan nomor telepon). Data kontak harus disimpan menggunakan `ArrayList`.
- Program mendukung fitur `tambah`, `lihat`, `cari`, `hapus`, dan `ubah` data kontak, dengan **menu interaktif**.

### Spesifikasi Program
- Gunakan `ArrayList<Contact>` untuk menyimpan data.
- Setiap kontak memiliki:
    - `String nama`
    - `String nomorTelepon`
- Menu utama:
    ```bash
    === MENU KONTAK ===
    1. Tambah Kontak
    2. Lihat Semua Kontak
    3. Cari Kontak
    4. Hapus Kontak
    5. Ubah Kontak
    0. Keluar
    Pilih: 

    ```
- Cari kontak berdasarkan nama (case-insensitive).
- Data disimpan hanya selama program berjalan (tidak perlu file I/O untuk versi dasar).

---

## Struktur Program
- `Contact.java` → Class untuk data kontak.
- `ContactManager.java` → Class yang berisi `ArrayList<Contact>` dan **method CRUD**.
- `Main.java` → Class utama dengan menu interaktif.

---

#### Selamat mencoba!