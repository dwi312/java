# Array of Object di Java
**Apa Itu Array of Object?**:
Array of Object adalah array (larik) yang menyimpan kumpulan object dari sebuah class, bukan tipe data primitif.
- Contoh:
Struktur deklarasi array of object di Java dapat dianalogi seperti ini:

```java
[access_modifier] [non_access_modifier] [class_type][] namaArray = new [class_type][ukuran];

```

```java
private static Siswa[] daftar = new Siswa[5];

```
Artinya: `array berukuran 5` yang akan menyimpan object `daftar` dari class `Siswa`.

---
```java
private static Siswa daftar = new Siswa();

```
- Ini hanya membuat 1 object Siswa, bukan daftar.
- Biasanya digunakan untuk object tunggal.

---

## Karakteristik Array of Object
| Karakteristik | Penjelasan                                                      |
| ------------- | --------------------------------------------------------------- |
| Ukuran tetap  | Setelah dibuat, ukuran array tidak bisa diubah                  |
| Tipe objek    | Hanya menyimpan object dari 1 tipe class                        |
| Nilai awal    | Semua elemen berisi `null` sampai diinisialisasi                |
| Akses cepat   | Akses via index: `daftar[0]`, `daftar[1]`, dst.                 |
| Tidak dinamis | Harus dikelola secara manual jika ingin menambah atau menghapus |

---

## Struktur Umum
```java
public class Siswa {
    String nama;
    String nim;
    
    public Siswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }
}

```
Array of Object:
```java
Siswa[] daftar = new Siswa[3];

```
---

## Operasi Dasar pada Array of Object
1. Membuat Array
```java
Siswa[] daftar = new Siswa[10]; // array 10 elemen (semua null)

```
2. Inisialisasi Isi Array
```java
daftar[0] = new Siswa("Joko", "001");
daftar[1] = new Siswa("Wowo", "002");

```
3. Menampilkan Isi Array
```java
for (int i = 0; i < daftar.length; i++) {
    if (daftar[i] != null) {
        System.out.println(daftar[i].nama + " - " + daftar[i].nim);
    }
}

```
4. Mengubah Data dalam Array
```java
daftar[0].nama = "Jokowow";
daftar[1].nama = "Phbowow";
daftar[1].setNim("capres-001");
daftar[2].setNim("capres-002");

```
5. Menghapus Isi Array
Karena array tidak bisa menghapus elemen langsung, maka:
- Menjadikannya null:
```java
daftar[1] = null;

```
- Salin ke array baru tanpa elemen yang ingin dihapus:
```java
Siswa[] baru = new Siswa[daftar.length - 1];
// salin manual kecuali indeks yang ingin dihapus

```
6. Mencari Object Berdasarkan Properti
```java
for (int i = 0; i < daftar.length; i++) {
    if (daftar[i] != null && daftar[i].nama.equals("Jokowow")) {
        System.out.println("Ditemukan di indeks ke-" + i);
    }
}

```
7. Resize Array (Tambahkan Elemen Baru)
Karena array tidak dinamis, maka:
- Buat array baru
- Salin semua elemen lama
- Tambahkan elemen baru
```java
Siswa[] lama = daftar;
daftar = new Siswa[lama.length + 1];
for (int i = 0; i < lama.length; i++) {
    daftar[i] = lama[i];
}
daftar[lama.length] = new Siswa("Baru", "003");

```

---

## Tips & Best Practice
| Tips                                  | Penjelasan                                    |
| ------------------------------------- | --------------------------------------------- |
| Gunakan `null` untuk slot kosong      | Agar bisa mengecek apakah elemen sudah terisi |
| Cek null sebelum akses method         | Hindari `NullPointerException`                |
| Gunakan `ArrayList` jika data dinamis | Lebih praktis dan powerful                    |
| Buat method bantu                     | Misalnya: tambah, cari, hapus, tampilkan      |

---

## Kapan Gunakan Array of Object?
- Data yang disimpan bersifat kompleks
Misalnya, setiap entri memiliki beberapa atribut (seperti nama, NIM, nilai, dll) dan memiliki class untuk merepresentasikan data tersebut, seperti Siswa, Buku, atau Pegawai.
- Ukuran data diketahui dan tetap
Jika jumlah data pasti dari awal, misalnya 5 siswa, maka Siswa[] sangat cocok digunakan karena array memiliki ukuran tetap.
- Fokus belajar pada dasar OOP dan array statis
- Operasi tidak terlalu kompleks

**Perbedaan Array of Object vs Array Biasa (primitif)**:
| Aspek             | Array of Object                           | Array Biasa (Primitif)                |
| ----------------- | ----------------------------------------- | ------------------------------------- |
| Isi               | Object (hasil dari class)                 | Tipe data primitif (int, double, etc) |
| Perlu konstruktor | ✅ Ya, buat dengan `new Class(...)`        | ❌ Tidak perlu, langsung isi nilai     |
| Akses properti    | Melalui method/field (misal `.getNama()`) | Langsung pakai nilai                  |
| Cocok untuk       | Data kompleks & OOP                       | Data sederhana                        |
| Contoh deklarasi  | `Siswa[] daftar = new Siswa[5];`          | `int[] nilai = new int[5];`           |

contoh:
- array biasa:
```java
int[] nilai = new int[3];
nilai[0] = 80;
nilai[1] = 90;
nilai[2] = 85;

```
- array of Object:
```java
Siswa[] daftar = new Siswa[3];
daftar[0] = new Siswa("Dwi", "123");

```
---

## Perbandingan Ringkas
| Gunakan `Siswa[]` ketika...                            | Gunakan `ArrayList<Siswa>` ketika...                    |
| ------------------------------------------------------ | ------------------------------------------------------- |
| Ukuran data sudah diketahui dari awal (misal 10 siswa) | Ukuran data tidak tetap, bisa bertambah atau berkurang  |
| Fokus belajar dasar Java OOP dan array                 | Fokus pada efisiensi, kemudahan, dan fleksibilitas      |
| Tidak sering menambah/menghapus elemen                 | Perlu banyak operasi tambah, hapus, filter, dll         |
| Ingin belajar cara kerja array manual                  | Butuh performa dan fitur bawaan seperti `add`, `remove` |

---

## Kesimpulan
- Array of Object = menyimpan banyak object dari class tertentu.
- Operasi penting: buat, isi, tampilkan, ubah, hapus, cari.
- Array tetap bisa digunakan, tapi perlu usaha ekstra untuk menambah/menghapus elemen.
- Jika butuh fleksibilitas, gunakan ArrayList.

---

### Dwi312
