# Exception Handling: Penanganan Pengecualian dalam Pemrograman
Exception Handling adalah mekanisme dalam pemrograman untuk menangani error saat program berjalan agar tidak menyebabkan crash. Tujuannya memastikan program tetap berjalan atau berhenti dengan cara yang aman, sekaligus memberi informasi yang berguna bagi pengembang atau pengguna.

## Apa itu Exception (Pengecualian)
Exception adalah kejadian saat program berjalan yang mengganggu alur normal eksekusi. Saat terjadi, eksekusi method berhenti dan sistem mencari penangan (handler) yang sesuai.
- **Jenis-jenis Exception secara umum**:
    - **Checked Exceptions** – Harus ditangani secara eksplisit (wajib `try-catch` atau deklarasi). Terjadi karena kondisi luar yang dapat dipulihkan, misalnya masalah I/O atau koneksi database.
    Contoh: `IOException`, `SQLException`.
    
    - **Unchecked Exceptions (Runtime Exceptions)** – Tidak wajib ditangani. Biasanya disebabkan bug atau kesalahan logika pemrograman.
    Contoh: `NullPointerException`, `ArrayIndexOutOfBoundsException`, `ArithmeticException`.
    
    - **Errors** – Masalah serius yang biasanya tidak bisa dipulihkan dan tidak ditangani oleh aplikasi.
    Contoh: `OutOfMemoryError`, `StackOverflowError`.

---

## Komponen Utama dalam Exception Handling:
#### 1. `try` **Block**
Blok `try` digunakan untuk membungkus kode yang berpotensi menimbulkan exception. Jika terjadi exception, eksekusi dalam `try` dihentikan dan kendali dialihkan ke blok `catch` yang sesuai.
```java
try {
    // Kode yang berpotensi menimbulkan exception
}

```

#### 2. `catch` **Block**
Blok `catch` berfungsi menangani exception yang muncul dari blok `try`. Setiap `catch` harus menentukan jenis exception yang ditangani, dan satu `try` bisa memiliki beberapa `catch` untuk menangani berbagai jenis exception secara spesifik.
```java
try {
    // Kode yang berpotensi menimbulkan exception
} catch (TipeException1 namaVariabel) {
    // Kode untuk menangani TipeException1
} catch (TipeException2 namaVariabel) {
    // Kode untuk menangani TipeException2
}

```
Detail tentang blok `catch`:
- **Urutan Blok** `catch` – Jika ada beberapa `catch`, eksekusi akan mencari dari atas ke bawah. `Exception` yang lebih spesifik harus ditempatkan sebelum yang lebih umum (misalnya `IOException` sebelum `Exception)` agar tidak terjadi unreachable code.
- **Multiple Catch Blocks** – Memungkinkan penanganan yang berbeda untuk tiap jenis exception.
- **Polimorfisme** – `catch` bisa menangkap exception dari tipe yang ditentukan maupun subclass-nya.

#### 3. `finally` **Block**
Blok `finally` berisi kode yang selalu dijalankan, baik terjadi exception maupun tidak, dan terlepas dari apakah exception ditangani oleh `catch`. Biasanya digunakan untuk resource cleanup seperti menutup file, koneksi database, atau melepaskan sumber daya sistem.
```java
try {
    // Kode yang berpotensi menimbulkan exception
} catch (Exception e) {
    // Penanganan exception
} finally {
    // Kode yang selalu dieksekusi
}

```
Detail tentang blok `finally`:
- `Eksekusi Terjamin` – Blok `finally` akan selalu dijalankan, bahkan jika ada `return`, `break`, atau `continue` di dalam `try` atau `catch`.
- **Exception dalam** `finally` – Jika terjadi exception di `finally`, exception asli (jika ada) bisa hilang karena exception baru dari `finally` akan dilempar. Karena itu, hindari operasi yang rawan error atau tangani exception dengan hati-hati di dalam `finally`.

#### 4. `throw` **Keyword**
Kata kunci `throw` digunakan untuk secara eksplisit melempar exception dari kode program. Dengan ini, pengembang bisa membuat dan melempar **custom exception** atau melakukan **re-throw** terhadap exception yang sudah ada.
```java
// Melempar instance Exception yang sudah ada
throw new MyCustomException("Pesan kesalahan kustom.");

// Melempar kembali exception yang ditangkap
try {
    // ...
} catch (SQLException e) {
    // Lakukan logging atau pemrosesan
    throw e; // Melempar kembali exception
}

```

#### 5. `throws` **Keyword**
Kata kunci `throws` digunakan pada deklarasi method untuk menyatakan bahwa method tersebut bisa melempar satu atau lebih **checked exception**. Ini menjadi kontrak agar pemanggil method menangani exception tersebut atau ikut mendeklarasikannya.
```java
public void bacaFile(String namaFile) throws IOException, FileNotFoundException {
    // Kode untuk membaca file yang berpotensi melempar IOException atau FileNotFoundException
}

```
Detail tentang `throws`:
- **Deklarasi untuk Checked Exception** – `throws` umumnya digunakan untuk checked exception. Untuk unchecked exception, deklarasi ini opsional karena tidak wajib ditangani.
- **Kewajiban Pemanggil** – Jika sebuah method mendeklarasikan `throws`, maka method pemanggil harus:
    - Menangani exception dengan `try-catch`, atau
    - Mendeklarasikan exception yang sama (atau supertype-nya) di tanda tangan method mereka.

---

## Hierarki Exception (Contoh di Java)
Sebagian besar bahasa pemrograman berorientasi objek memiliki hierarki kelas untuk exception. Di Java, semua kelas exception mewarisi dari kelas `Throwable`.
```bash
java.lang.Object
  └── java.lang.Throwable
        ├── java.lang.Error
        └── java.lang.Exception
              ├── java.lang.RuntimeException (Unchecked Exception)
              │     ├── java.lang.NullPointerException
              │     ├── java.lang.ArrayIndexOutOfBoundsException
              │     └── ...
              └── (Checked Exception)
                    ├── java.io.IOException
                    ├── java.sql.SQLException
                    └── ...

```
Memahami hierarki ini penting untuk:
- **Penulisan Blok** `catch`: Memungkinkan penangkapan exception umum atau spesifik.
- **Pembuatan Custom Exception**: Memungkinkan pengembang membuat exception mereka sendiri yang mewarisi dari `Exception` (untuk checked exception) atau `RuntimeException` (untuk unchecked exception).

---

## Implementasi Exception Handling
Contoh Sederhana:
```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContohException {

    public static void main(String[] args) {
        // Contoh 1: ArithmeticException (Unchecked)
        try {
            int hasil = 10 / 0; // Akan menimbulkan ArithmeticException
            System.out.println("Hasil pembagian: " + hasil); // Baris ini tidak akan dieksekusi
        } catch (ArithmeticException e) {
            System.err.println("Terjadi kesalahan aritmatika: " + e.getMessage());
            // Opsi: throw new RuntimeException("Kesalahan fatal pembagian nol");
        } finally {
            System.out.println("Blok finally untuk contoh aritmatika selalu dieksekusi.");
        }

        System.out.println("---");

        // Contoh 2: FileNotFoundException (Checked) dan IOException
        try {
            bacaKontenFile("data.txt");
        } catch (FileNotFoundException e) {
            System.err.println("File tidak ditemukan: " + e.getMessage());
        } catch (IOException e) { // Menangkap superclass dari FileNotFoundException juga bisa
            System.err.println("Terjadi kesalahan I/O: " + e.getMessage());
        } finally {
            System.out.println("Blok finally untuk contoh file selalu dieksekusi.");
        }

        System.out.println("---");

        // Contoh 3: Penggunaan 'throw' untuk custom exception
        try {
            validasiUsia(15);
        } catch (UsiaTidakValidException e) {
            System.err.println("Pengecualian usia: " + e.getMessage());
        }
    }

    // Contoh penggunaan 'throws'
    public static void bacaKontenFile(String namaFile) throws FileNotFoundException, IOException {
        File file = new File(namaFile);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } finally {
            if (scanner != null) {
                scanner.close(); // Pastikan scanner ditutup
            }
        }
    }

    // Definisi custom exception (checked exception)
    static class UsiaTidakValidException extends Exception {
        public UsiaTidakValidException(String message) {
            super(message);
        }
    }

    // Contoh penggunaan 'throw' dengan custom exception
    public static void validasiUsia(int usia) throws UsiaTidakValidException {
        if (usia < 18) {
            throw new UsiaTidakValidException("Usia harus 18 tahun atau lebih.");
        }
        System.out.println("Usia valid: " + usia);
    }
}

```
Penjelasan:
- **Contoh 1 (ArithmeticException)**: Menunjukkan bagaimana `try-catch` menangani `ArithmeticException` yang tidak tercentang. Blok `finally` dijamin dieksekusi.
- **Contoh 2 (FileNotFoundException & IOException)**: Menunjukkan penggunaan `throws` pada tanda tangan method `bacaKontenFile` untuk `FileNotFoundException` (yang merupakan turunan dari `IOException`). Blok `try-catch` di method `main` menangani kedua exception tersebut. Perhatikan penggunaan `finally` untuk memastikan resource `Scanner` ditutup.
- **Contoh 3 (Custom Exception)**: Mendefinisikan `UsiaTidakValidException` sebagai checked exception dan menggunakannya dengan `throw` dalam method `validasiUsia`. Pemanggil method ini (di `main`) diwajibkan untuk menangani exception ini.

---

## Best Practices dalam Exception Handling
```bash
| Prinsip                                     | Penjelasan Singkat                                                                      |
| ------------------------------------------- | --------------------------------------------------------------------------------------- |
| Jangan menelan exception                    | Hindari `catch` kosong atau pesan generik; mempersulit debugging.                       |
| Tangani exception spesifik lebih dulu       | Tangani exception yang paling spesifik sebelum yang umum untuk presisi.                 |
| Gunakan `finally` untuk pembersihan         | Pastikan resource (file, koneksi, socket) selalu ditutup, terlepas dari error.          |
| Lempar custom exception yang informatif     | Sertakan informasi jelas tentang apa yang salah dan alasannya.                          |
| Gunakan logging, bukan `print`              | Catat exception dengan logger (Log4j, SLF4J, dll.) agar mudah dipantau di produksi.     |
| Hindari logika bisnis dalam `catch`         | Blok `catch` hanya untuk penanganan error, bukan proses bisnis utama.                   |
| Pilih jenis exception yang tepat            | Gunakan checked untuk kondisi yang dapat dipulihkan, unchecked untuk error pemrograman. |
| Jangan gunakan exception untuk flow control | Exception hanya untuk kondisi error/tidak biasa, bukan logika program normal.           |

```

---

## Kesimpulan
Exception Handling adalah elemen kunci untuk membangun aplikasi yang kuat dan andal. Dengan menggunakan `try`, `catch`, `finally`, `throw`, dan `throws` secara tepat, developer dapat membuat kode yang tahan terhadap kesalahan, mempermudah debugging, dan menjaga pengalaman pengguna tetap baik. Penanganan yang baik bukan hanya menangkap error, tetapi juga memberi informasi jelas, serta memungkinkan aplikasi pulih atau berhenti dengan cara yang elegan.

```bash
| Konsep       | Tujuan                                                                                                     |
| ------------ | ---------------------------------------------------------------------------------------------------------- |
| try        | Membungkus kode yang berpotensi menimbulkan error agar dapat ditangani.                                    |
| catch      | Menangkap dan menangani error yang terjadi, memberikan respon yang sesuai.                                 |
| finally    | Menjalankan pembersihan resource (misalnya menutup file/koneksi) meski ada error.                          |
| throw      | Melempar exception secara manual untuk kondisi error tertentu.                                             |
| throws     | Menandai bahwa sebuah metode dapat melempar exception, agar diproses oleh pemanggilnya.                    |
| Tujuan Utama | Membuat aplikasi lebih robust, mempermudah debugging, memberi info jelas, dan menangani error dengan aman. |

```
---

#### Dwi312