# Dasar Pemrograman Berorientasi Objek (OOP) dalam Java

Repositori ini berisi ringkasan dan contoh kode dari konsep-konsep dasar OOP (Object-Oriented Programming) menggunakan bahasa pemrograman Java.

---

## Tujuan Pembelajaran

- Memahami konsep Class dan Object dalam Java
- Menggunakan Constructor untuk inisialisasi objek
- Menerapkan Enkapsulasi menggunakan modifier `private`, `public`, dan `protected`
- Menerapkan Pewarisan (Inheritance) antar class menggunakan `extends`
- Menggunakan Polimorfisme, baik Overloading maupun Overriding

---

## 1. Class dan Object

- **Class** adalah blueprint/cetakan dari objek.
- **Object** adalah instance nyata dari class.

```java
class Mahasiswa {
    String nama;
    int umur;

    void tampilkanInfo() {
        System.out.println("Nama: " + nama + ", Umur: " + umur);
    }
}

public class Main {
    public static void main(String[] args) {
        Mahasiswa mhs = new Mahasiswa();
        mhs.nama = "Dwi";
        mhs.umur = 20;
        mhs.tampilkanInfo();
    }
}

```

## 2. Constructor

- **Constructor** digunakan untuk menginisialisasi objek saat dibuat.

```java
Mahasiswa mhs = new Mahasiswa("Dwi", 20);

```
```java
class Mahasiswa {
    String nama;
    int umur;

    Mahasiswa(String n, int u) {
        nama = n;
        umur = u;
    }

    void tampilkanInfo() {
        System.out.println("Nama: " + nama + ", Umur: " + umur);
    }
}

```

## 3. Enkapsulasi

- Menyembunyikan data dengan menggunakan modifier private dan mengaksesnya melalui method getter dan setter.

```java
class Mahasiswa {
    private String nama;

    public void setNama(String n) {
        nama = n;
    }

    public String getNama() {
        return nama;
    }
}

```

| Modifier    | Class | Subclass | Package | Luar Class |
| ----------- | ----- | -------- | ------- | ---------- |
| `private`   | ✅     | ❌        | ❌       | ❌          |
| `default`   | ✅     | ❌        | ✅       | ❌          |
| `protected` | ✅     | ✅        | ✅       | ❌          |
| `public`    | ✅     | ✅        | ✅       | ✅          |

## 4. Inheritance (extends)

- Subclass mewarisi atribut dan method dari superclass menggunakan `extends`.

```java
class Mahasiswa {
    String nama = "Dwi";

    void belajar() {
        System.out.println(nama + " sedang belajar.");
    }
}

class MahasiswaAktif extends Mahasiswa {
    void ikutOrganisasi() {
        System.out.println(nama + " ikut organisasi.");
    }
}

```

## 5. Polimorfisme
### a. Overloading (Method dengan nama sama, parameter berbeda)

```java
class Kalkulator {
    int tambah(int a, int b) {
        return a + b;
    }

    double tambah(double a, double b) {
        return a + b;
    }
}

```

### b. Overriding (Menimpa method dari superclass)

```java
class Hewan {
    void bersuara() {
        System.out.println("Hewan bersuara");
    }
}

class Kucing extends Hewan {
    @Override
    void bersuara() {
        System.out.println("Meong!");
    }
}

```
---

## Tujuan Pembelajaran
- Memahami struktur class dan object.
- Menggunakan constructor untuk inisialisasi.
- Menerapkan enkapsulasi agar data aman.
- Menggunakan inheritance untuk pewarisan sifat.
- Memahami konsep polimorfisme: overloading & overriding.

---

## Kesimpulan
Pemrograman Berorientasi Objek (OOP) membantu kita dalam:
- Menyusun kode yang modular dan terstruktur
- Mempermudah reusability dan pemeliharaan
- Meningkatkan keamanan melalui enkapsulasi
- Membuat kode fleksibel dan dinamis melalui polimorfisme

---

## Struktur Direktori
```
belajar-java/
├── oop-dasar/
│   ├── ClassObject.java
│   ├── Constructor.java
│   ├── Enkapsulasi.java
│   ├── Inheritance.java
│   ├── Overloading.java
│   ├── Overriding.java
│   └── README.md

```

---

## Referensi
- [Oracle Java Documentation](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html)
- [Tutorial OOP Java - W3Schoolsesmi Java - Oracle](https://www.w3schools.com/java/java_oop.asp)
- [Tutorial internal : `belajar-java/Object-Oriented Programming`](https://github.com/dwi312/java/tree/main/Object-Oriented Programming)

---

## Dwi1312
