# ArrayList dalam Java
- `ArrayList` adalah salah satu implementasi dari interface `List` dalam Java Collection Framework yang menggunakan array dinamis sebagai media penyimpanan. Tidak seperti array biasa dengan ukuran tetap, `ArrayList` dapat menambah atau mengurangi ukuran secara dinamis sesuai kebutuhan.
- `ArrayList` berada dalam package java.util, sehingga perlu di-import sebelum digunakan.

### Karakteristik ArrayList
- Mengizinkan elemen duplikat.
- Menjaga urutan elemen (insertion order).
- Memungkinkan akses elemen menggunakan indeks.
- Ukuran dapat berubah secara dinamis (tidak seperti array biasa).
- Tidak synchronized (tidak aman untuk multi-threading kecuali dibungkus dengan `Collections.synchronizedList`).

---

## Deklarasi dan Inisialisasi
Untuk menggunakan ArrayList, kita perlu mengimpor package:
```java
import java.util.ArrayList;

```
Deklarasi:
```java
ArrayList<String> daftarNama = new ArrayList<>();
ArrayList<Integer> angka = new ArrayList<>();

```
- Gunakan Generic (<T>) untuk menentukan tipe data elemen.
- Tipe data primitif (seperti int, double) harus menggunakan Wrapper Class (Integer, Double).

---

## Operasi Dasar pada ArrayList
Beberapa method umum yang sering digunakan:
| **Method**            | **Fungsi**                               |
| --------------------- | ---------------------------------------- |
| `add(E e)`            | Menambahkan elemen ke akhir list.        |
| `add(int index, E e)` | Menyisipkan elemen pada posisi tertentu. |
| `get(int index)`      | Mengambil elemen berdasarkan indeks.     |
| `set(int index, E e)` | Mengganti elemen di indeks tertentu.     |
| `remove(int index)`   | Menghapus elemen pada indeks tertentu.   |
| `remove(Object o)`    | Menghapus elemen yang cocok.             |
| `size()`              | Mendapatkan jumlah elemen dalam list.    |
| `contains(Object o)`  | Mengecek apakah elemen ada dalam list.   |
| `isEmpty()`           | Mengecek apakah list kosong.             |
| `clear()`             | Menghapus semua elemen dalam list.       |

---

## Contoh Program Dasar
Program sederhana untuk mendemonstrasikan `ArrayList`:
```java
import java.util.ArrayList;

public class DemoArrayList {
    public static void main(String[] args) {
        ArrayList<String> nama = new ArrayList<>();

        // Menambahkan elemen
        nama.add("Andi");
        nama.add("Budi");
        nama.add("Citra");
        System.out.println("Daftar Nama: " + nama);

        // Menyisipkan pada indeks tertentu
        nama.add(1, "Dewi");
        System.out.println("Setelah disisipkan: " + nama);

        // Mengambil elemen
        System.out.println("Elemen indeks 2: " + nama.get(2));

        // Mengganti elemen
        nama.set(0, "Ayu");
        System.out.println("Setelah diganti: " + nama);

        // Menghapus elemen
        nama.remove("Citra");
        System.out.println("Setelah dihapus: " + nama);

        // Mengecek keberadaan
        System.out.println("Apakah ada Budi? " + nama.contains("Budi"));

        // Ukuran list
        System.out.println("Jumlah elemen: " + nama.size());
    }
}

```
**Output**:
```bash
Daftar Nama: [Andi, Budi, Citra]
Setelah disisipkan: [Andi, Dewi, Budi, Citra]
Elemen indeks 2: Budi
Setelah diganti: [Ayu, Dewi, Budi, Citra]
Setelah dihapus: [Ayu, Dewi, Budi]
Apakah ada Budi? true
Jumlah elemen: 3

```
---

## Iterasi pada ArrayList
- **For Loop Biasa**
```java
for (int i = 0; i < nama.size(); i++) {
    System.out.println(nama.get(i));
}

```
- **For-Each Loop**
```java
for (String n : nama) {
    System.out.println(n);
}

```
- **Menggunakan Iterator**
```java
import java.util.Iterator;

Iterator<String> it = nama.iterator();
while (it.hasNext()) {
    System.out.println(it.next());
}

```
---

## Perbedaan Array vs ArrayList
```bash
| **Array**                                                 | **ArrayList**                                           |
| --------------------------------------------------------- | ------------------------------------------------------- |
| Ukuran tetap (fixed).                                     | Ukuran dinamis (bisa bertambah/berkurang).              |
| Menyimpan tipe data primitif dan objek.                   | Hanya menyimpan objek (gunakan Wrapper untuk primitif). |
| Tidak memiliki method bawaan seperti `add` atau `remove`. | Memiliki banyak method untuk manipulasi data.           |
| Lebih cepat untuk operasi sederhana.                      | Lebih fleksibel dan mudah digunakan.                    |

```

---

## Studi Kasus Mini
Contoh aplikasi sederhana: **Manajemen Daftar Tugas**
```java
import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp {
    public static void main(String[] args) {
        ArrayList<String> tugas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== MENU TODO LIST ===");
            System.out.println("1. Tambah Tugas");
            System.out.println("2. Lihat Tugas");
            System.out.println("3. Hapus Tugas");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();
            sc.nextLine(); // buang newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan tugas: ");
                    tugas.add(sc.nextLine());
                    break;
                case 2:
                    System.out.println("Daftar Tugas: " + tugas);
                    break;
                case 3:
                    System.out.print("Masukkan nomor tugas yang dihapus (0-based): ");
                    int idx = sc.nextInt();
                    if (idx >= 0 && idx < tugas.size()) {
                        tugas.remove(idx);
                        System.out.println("Tugas dihapus.");
                    } else {
                        System.out.println("Nomor tidak valid.");
                    }
                    break;
                case 0:
                    System.out.println("Keluar...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }
}

```

---

## Kelebihan dan Kekurangan ArrayList
#### Kelebihan:
- Ukuran dinamis, mudah menambah/menghapus elemen.
- Banyak method bawaan untuk manipulasi data.
- Mendukung iterasi dengan Iterator dan for-each.

#### Kekurangan:
- Operasi penyisipan dan penghapusan di tengah lebih lambat dibanding LinkedList karena perlu menggeser elemen.
- Tidak aman untuk multi-thread tanpa sinkronisasi manual.
- Sedikit lebih lambat dibanding array biasa untuk akses langsung karena ada overhead manajemen.

---

## Kapan Menggunakan ArrayList?
Gunakan ArrayList ketika:
- Jumlah data dinamis dan sering berubah.
- Akses data lebih sering dibanding modifikasi di tengah.
- Membutuhkan API koleksi yang lengkap (sorting, searching, dsb.).

> Jika operasi **insert/delete di tengah list sangat sering**, gunakan `LinkedList`.

---

## Tips & Best Practice Menggunakan ArrayList
- **Gunakan Generic (Tipe Data) Secara Eksplisit**
    - Selalu gunakan ArrayList<T> dengan tipe data yang jelas agar aman dari type casting dan error runtime.
    - Contoh:
    ```java
    ArrayList<String> daftar = new ArrayList<>();  // Aman

    ```
- **Hindari Penyisipan dan Penghapusan di Tengah List Terlalu Sering**
    - Operasi `add(index, element)` dan `remove(index)` membutuhkan penggeseran elemen, yang berpotensi memperlambat performa jika data sangat banyak.
    - Untuk manipulasi intensif di tengah list, gunakan `LinkedList`.
- **Gunakan `for-each` atau `Iterator` untuk Iterasi**
    - Menggunakan `for-each` lebih bersih:
    ```java
    for (String s : daftar) {
        System.out.println(s);
    }

    ```
- **Batasi Penggunaan Tipe Primitif, Gunakan Wrapper**
    - `ArrayList` hanya bisa menyimpan objek, bukan tipe primitif.
    - Contoh:
    ```java
    ArrayList<Integer> angka = new ArrayList<>();  // Bukan int[]

    ```
- **Gunakan `Collections.sort()` atau `Comparator` untuk Pengurutan**
    - Jangan implementasi sorting manual jika tidak perlu.
    - Contoh:
    ```java
    Collections.sort(daftar); // Mengurutkan String

    ```
- **Gunakan `isEmpty()` Daripada Mengecek `size() == 0`**
    - Lebih mudah dibaca:
    ```java
    if (daftar.isEmpty()) {
        System.out.println("List kosong");
    }

    ```
- **Kosongkan List dengan `clear()` daripada Membuat Ulang**
    - Lebih efisien daripada membuat `ArrayList` baru.
- **Gunakan Kapasitas Awal Jika Diketahui**
    - Jika tahu jumlah data, gunakan:
    ```java
    ArrayList<String> data = new ArrayList<>(100); // Hindari resize berulang

    ```
---

## Perbandingan Ringkas
```bash
| **Aspek**        | **Array of Object**                                   | **ArrayList**                                                   |
| ---------------- | ----------------------------------------------------- | --------------------------------------------------------------- |
| **Ukuran**       | Tetap setelah dibuat (fixed).                         | Dinamis (bisa bertambah dan berkurang otomatis).                |
| **Deklarasi**    | `Siswa[] daftar = new Siswa[10];`                     | `ArrayList<Siswa> daftar = new ArrayList<>();`                  |
| **Generic**      | Tidak mendukung, hanya tipe tertentu secara manual.   | Mendukung Generic (`ArrayList<T>`) untuk keamanan tipe.         |
| **Operasi CRUD** | Harus manual (`for`, `if`, dll).                      | Memiliki method bawaan: `add`, `remove`, `get`, `set`, `clear`. |
| **Iterasi**      | Hanya dengan loop manual.                             | Bisa pakai `for-each`, `Iterator`, dan `Stream API`.            |
| **Performa**     | Lebih cepat untuk akses langsung (sederhana).         | Sedikit lebih lambat karena manajemen dinamis.                  |
| **Kegunaan**     | Cocok untuk jumlah data tetap dan struktur sederhana. | Cocok untuk data yang sering berubah (dinamis).                 |

```

---

### Kesimpulan
- **ArrayList** adalah struktur data dinamis dari Java Collection Framework yang memudahkan pengelolaan data karena menyediakan **banyak method bawaan** (`add`, `remove`, `get`, `set`, dll.) dan mendukung **Generic** untuk keamanan tipe.
- Dibanding **Array of Object**, `ArrayList` lebih fleksibel karena ukuran bisa bertambah atau berkurang tanpa perlu membuat array baru.
- Namun, **Array of Object** lebih sederhana dan lebih cepat untuk akses data jika ukuran tetap dan operasi hanya baca/tulis sederhana.
- Gunakan:
    - **Array of Object** → saat jumlah data tetap dan operasi sederhana.
    - **ArrayList** → saat data bersifat dinamis, sering berubah, dan membutuhkan operasi CRUD yang fleksibel.

---

#### Dwi312