# Method (Fungsi) dalam Java
## Apa itu Method
- Method adalah blok kode yang dapat dipanggil untuk menjalankan suatu aksi.
- Dalam Java, semua method berada dalam class.
- Method dapat menerima input (`parameter`) dan/atau mengembalikan nilai (`return`).
- Bertujuan untuk modularisasi program, mencegah duplikasi, dan mempermudah pemeliharaan.

---

## Struktur dasar Method
```java
[access_modifier] [non_access_modifier] [return_type] namaMethod([parameter]) {
    // isi kode
    [return hasil]; // jika return_type bukan void
}
```
| Bagian                | Contoh                  | Keterangan                   |
| --------------------- | ----------------------- | ---------------------------- |
| access\_modifier      | `public`, `private`     | Hak akses method             |
| non\_access\_modifier | `static`, `final`, ...  | Modifier tambahan            |
| return\_type          | `void`, `int`, `String` | Tipe nilai yang dikembalikan |
| namaMethod            | `tampil`, `jumlah`      | Nama method                  |
| parameter             | `(int x, String y)`     | Nilai yang dikirim ke method |



## Jenis Method
| Jenis                          | Contoh                                 | Penjelasan                                 |
| ------------------------------ | -------------------------------------- | ------------------------------------------ |
| Tanpa return, tanpa parameter  | `public static void tampil()`          | Tidak menerima input & tidak mengembalikan |
| Tanpa return, dengan parameter | `public static void sapa(String nama)` | Menerima input tanpa mengembalikan nilai   |
| Dengan return                  | `public static int kuadrat(int x)`     | Mengembalikan hasil                        |

---
## Static vs Non-Static Method
| Tipe         | Ciri-ciri                                        | Pemanggilan          |
| ------------ | ------------------------------------------------ | -------------------- |
| `static`     | Milik class, bisa dipanggil langsung tanpa objek | `NamaClass.method()` |
| `non-static` | Milik objek, butuh `new` untuk dipanggil         | `obj.method()`       |

---

## Contoh Method
```java
public static void tampilJudul() {
    System.out.println("== APLIKASI NILAI ==");
}

public static int kuadrat(int x) {
    return x * x;
}

public void sapa(String nama) {
    System.out.println("Halo, " + nama);
}

public double hitungRata(int total, int jumlah) {
    return (double) total / jumlah;
}

```
### Contoh Program Lengkap
```java
public class MethodDemo {

    public static void tampilJudul() {
        System.out.println("== DEMO METHOD ==");
    }

    public static int tambah(int a, int b) {
        return a + b;
    }

    public void sapaUser(String nama) {
        System.out.println("Halo, " + nama + "!");
    }

    public double hitungRata(int total, int jumlah) {
        return (double) total / jumlah;
    }

    public static void main(String[] args) {
        tampilJudul(); // static

        int hasil = tambah(3, 4);
        System.out.println("Hasil tambah: " + hasil);

        MethodDemo demo = new MethodDemo();
        demo.sapaUser("Dwi");

        double rata = demo.hitungRata(80, 4);
        System.out.println("Rata-rata: " + rata);
    }
}


```

---

## Rangkuman Konsep
| Konsep        | Penjelasan                                      |
| ------------- | ----------------------------------------------- |
| `void`        | Method tidak mengembalikan nilai                |
| `return`      | Digunakan untuk mengembalikan nilai             |
| `parameter`   | Input ke dalam method                           |
| `static`      | Method milik class, dipanggil tanpa objek       |
| `non-static`  | Method milik objek, dipanggil lewat instance    |
| `overloading` | Method dengan nama sama, tapi parameter berbeda |

---

## Modularisasi Program
```java
public static void tambahSiswa(ArrayList<Siswa> daftar) { ... }
public static void tampilkanSiswa(ArrayList<Siswa> daftar) { ... }
public static void hapusSiswa(ArrayList<Siswa> daftar) { ... }

```
---

## Tips Praktis
- Gunakan static untuk method global/utility
- Gunakan non-static untuk operasi berbasis objek/data
- Gunakan return jika butuh hasil untuk diproses lagi
- Gunakan void untuk aksi tanpa hasil (misal cetak)

---

### Referensi Tambahan
- [Oracle Java Documentation](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html)
- Tutorial internal : `belajar-java/method`

---

#### Dwi312