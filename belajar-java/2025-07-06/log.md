# Log Belajar Java Dasar - 1
tanggal : 2025-07-06
Foldfer : `belajar-java/2025-07-06`

## Tujuan Hari ini :
- Memahami bagaimana Java bekerja
- Mampu membuat dan menjalankan program Java sederhana
- Mengenal bagian-bagian dari struktur program Java

## Materi Dipelajari :
- Pengenalan bahasa java
- Struktur dasar program dasar
    `   public class HelloWorld {                       `
    `       public static void main(String[] args) {    `
    `           System.out.println("Halo, Dunia!");     `
    `       }                                           `
    `   }                                               `

    Penjelasan per bagian :
    | Baris                                    | Penjelasan                                                                                       |
| ---------------------------------------- | ------------------------------------------------------------------------------------------------ |
| `public class HelloWorld`                | Mendefinisikan **kelas utama** bernama `HelloWorld`. Setiap file Java harus punya 1 class utama. |
| `{`                                      | Tanda kurung buka menandai awal dari isi class.                                                  |
| `public static void main(String[] args)` | Method utama tempat program dieksekusi pertama kali. Wajib ada di setiap program Java.           |
| `System.out.println("Halo, Dunia!");`    | Mencetak teks ke layar. `System.out.println` adalah perintah untuk menampilkan teks.             |
| `}`                                      | Menutup blok kode `main` dan `class`.                                                            |


- Cara compile dan run program java mengunakan terminal (`javac`, `java`)
    Langkah:
    Compile
    `   javac HelloWorld.java   `
    Jalankan
    `   java HelloWorld         `

    
- Fungsi `main()` sebagai titil awal program
- Fungsi `System.out.println()` untuk menampilkan output ke layar

## File yang dibuat :
1. `HelloWorld.java`
2. `Nama.java`

## Catatan Pribadi :
- Semua file Java harus disimpan dengan nama yang **sama** seperti nama kelasnya (misal: `HelloWorld.java` untuk `public class HelloWorld`)
- Program dijalankan dengan 2 langkah: `javac` (compile) dan `java` (run)
- Perintah `System.out.println()` digunakan untuk mencetak ke layar
- Saat pertama kali pakai **Git** dan push ke **GitHub**, ternyata **tidak bisa pakai password biasa** — perlu buat **Personal Access Token (PAT)** agar berhasil. Ini pengalaman penting untuk setup awal **GitHub**.

## Target Besok :
- Tipe data, Variable, Operator dasar
- Buat program sederhana : konversi suhu dan hitung luas segitiga


Dwi312