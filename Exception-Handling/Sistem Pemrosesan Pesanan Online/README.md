# Studi Kasus: Sistem Pemrosesan Pesanan Online
## Skenario
Sebuah perusahaan e-commerce (perdagangan elektronik) mengembangkan sistem pemrosesan pesanan online. Ketika seorang pelanggan melakukan pemesanan, sistem harus melalui beberapa langkah kritis:
- 1. Validasi Stok Produk: Memeriksa ketersediaan stok untuk setiap produk dalam pesanan.
- 2. Validasi Pembayaran: Memverifikasi informasi pembayaran pelanggan (misalnya, kartu kredit, saldo -dompet digital).
- 3. Pengurangan Stok: Mengurangi jumlah stok produk yang dipesan dari inventaris.
- 4. Pencatatan Transaksi: Menyimpan detail pesanan ke database.
- 5. Pengiriman Notifikasi: Mengirim email konfirmasi pesanan ke pelanggan.

Setiap langkah ini berpotensi menimbulkan kondisi yang tidak terduga atau kesalahan.

---

## Potensi Pengecualian dan Penanganannya
Identifikasi potensi exception (pengecualian) yang mungkin terjadi di setiap langkah dan bagaimana Exception Handling dapat diterapkan.

- 1. Validasi Stok Produk
Potensi Exception:
    - `ProdukTidakDitemukanException`: Pelanggan mencoba memesan produk yang tidak ada dalam katalog sistem. Ini adalah checked exception karena ini adalah kondisi yang diharapkan dan dapat diatasi (misalnya, dengan menampilkan pesan kesalahan kepada pelanggan).
    - `StokTidakCukupException`: Jumlah produk yang dipesan melebihi stok yang tersedia. Ini juga checked exception yang perlu ditangani secara eksplisit.
Penanganan:
    - Sistem akan mencoba memvalidasi stok.
    - Jika `ProdukTidakDitemukanException` dilemparkan, sistem akan menangkapnya dan menampilkan pesan "Produk tidak valid" kepada pelanggan, kemudian menyarankan untuk menghapus produk tersebut dari keranjang.
    - Jika `StokTidakCukupException` dilemparkan, sistem akan menangkapnya, menampilkan pesan "Stok tidak cukup untuk [Nama Produk]", dan menyarankan pelanggan untuk mengurangi jumlah atau memilih produk lain.
    - Dalam kedua kasus, proses pemesanan akan dihentikan pada tahap ini, dan tidak ada operasi database yang dilakukan.

- 2. Validasi Pembayaran
Potensi Exception:
    - `KoneksiGatewayPembayaranGagalException`: Sistem gagal terhubung ke payment gateway (gerbang pembayaran) eksternal. Ini adalah checked exception karena masalah jaringan atau layanan eksternal adalah hal yang dapat terjadi.
    - `PembayaranDitolakException`: Payment gateway menolak transaksi (misalnya, kartu kadaluarsa, dana tidak cukup, CVV salah). Ini adalah checked exception yang perlu ditangani.
    - `FormatPembayaranTidakValidException`: Informasi pembayaran yang dimasukkan pelanggan tidak sesuai format (misalnya, nomor kartu kredit salah format). Ini bisa berupa unchecked exception jika dianggap sebagai programming error di sisi frontend yang seharusnya divalidasi, atau checked exception jika divalidasi di backend.
Penanganan:
    - Sistem akan mencoba memproses pembayaran.
    - Jika `KoneksiGatewayPembayaranGagalException` dilemparkan, sistem akan menangkapnya, mencatat kesalahan ke log (catatan aktivitas program) untuk investigasi, dan menampilkan pesan "Maaf, terjadi masalah pada sistem pembayaran. Silakan coba beberapa saat lagi." kepada pelanggan. Proses pemesanan akan dihentikan.
    - Jika `PembayaranDitolakException` dilemparkan, sistem akan menangkapnya, menampilkan pesan yang lebih spesifik seperti "Pembayaran Anda ditolak. Mohon periksa kembali detail pembayaran atau gunakan metode lain."
    - Blok `finally` akan memastikan bahwa koneksi ke payment gateway ditutup, terlepas dari hasil transaksi.

- 3. Pengurangan Stok
Potensi Exception:
    - `OptimisticLockingException`: Terjadi konflik saat memperbarui stok, di mana pengguna lain mungkin telah mengurangi stok pada saat yang sama. Ini adalah unchecked exception karena seringkali menunjukkan masalah konkurensi atau race condition (kondisi balapan) yang harus dikelola oleh logika aplikasi, bukan oleh penanganan exception standar. Sistem harus mencoba lagi operasi tersebut atau mengembalikan kesalahan.
Penanganan:
    - Sistem akan mencoba mengurangi stok di database.
    - Jika OptimisticLockingException terjadi, sistem mungkin akan mencoba ulang operasi pengurangan stok beberapa kali atau segera mengembalikan kesalahan kepada pelanggan, menyarankan mereka untuk mencoba lagi. Ini perlu strategi yang cermat agar tidak memblokir sistem.

- 4. Pencatatan Transaksi
Potensi Exception:
    - DatabaseConnectionException: Gagal terhubung ke database. Ini adalah checked exception.
    - SQLIntegrityConstraintViolationException: Terjadi pelanggaran integritas data SQL (misalnya, mencoba memasukkan pesanan dengan ID yang sudah ada). Ini bisa berupa unchecked exception di beberapa framework atau checked exception di lainnya, seringkali menunjukkan programming error dalam logika bisnis.
    - DataTooLongException: Upaya menyimpan data yang melebihi batas kolom database. Ini juga bisa berupa unchecked exception.
Penanganan:
    - Sistem akan mencoba menyimpan data pesanan.
    - Jika DatabaseConnectionException dilemparkan, sistem akan menangkapnya, mencatat kesalahan yang parah, dan memberitahu pelanggan bahwa "Terjadi masalah internal. Pesanan Anda tidak dapat diproses saat ini. Silakan hubungi dukungan pelanggan."
    - Jika SQLIntegrityConstraintViolationException atau DataTooLongException terjadi, ini kemungkinan besar adalah bug internal. Sistem akan menangkapnya, mencatat detail exception lengkap ke log sistem untuk dianalisis oleh pengembang, dan menampilkan pesan kesalahan generik kepada pelanggan, misalnya "Maaf, terjadi kesalahan tak terduga. Tim kami telah diberitahu."
    - Dalam skenario ini, jika pencatatan transaksi gagal setelah stok dikurangi, sistem harus memiliki mekanisme kompensasi atau rollback (mengembalikan perubahan) untuk mengembalikan stok yang sudah dikurangi. Ini adalah bagian penting dari transaksi yang reliable.

- 5. Pengiriman Notifikasi
Potensi Exception:
    - MailServerUnavailableException: Sistem pengiriman email tidak dapat dijangkau. Ini adalah checked exception.
    - InvalidEmailAddressException: Alamat email pelanggan tidak valid. Ini juga checked exception.
Penanganan:
    - Sistem akan mencoba mengirim email konfirmasi.
    - Jika MailServerUnavailableException dilemparkan, sistem akan menangkapnya. Daripada menghentikan seluruh proses, sistem akan mencatat exception ini ke log dan mungkin menandai pesanan untuk pengiriman notifikasi ulang nanti (misalnya, melalui queue atau retry mechanism). Pelanggan tetap akan melihat pesanan mereka berhasil.
    - Jika InvalidEmailAddressException terjadi, sistem akan mencatatnya dan tidak akan mencoba lagi mengirim email ke alamat tersebut, tetapi pesanan tetap dianggap berhasil.