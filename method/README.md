# Method (Fungsi) dalam Java
## Apa itu Method
- Dalam Java, method adalah blok kode di dalam suatu class yang berisi instruksi untuk melakukan tugas tertentu.
- Method mirip dengan fungsi (function), tetapi selalu didefinisikan dalam konteks OOP (Object-Oriented Programming) dan terkait dengan sebuah objek atau kelas.
- Dengan kata lain, method mendeskripsikan perilaku atau aksi yang dapat dilakukan oleh objek dari kelas tersebut (misalnya, menghitung nilai, memodifikasi atribut, atau berinteraksi dengan objek lain).
- Sebuah method bisa jadi mengembalikan nilai tertentu (return value) atau tidak (void), serta dapat menerima argumen/input yang diproses di dalamnya.
- Method (fungsi) adalah blok kode yang bisa dipanggil berkali-kali untuk menjalankan tugas tertentu.
**Tujuannya**:
    - Menghindari duplikasi kode
    - Membuat program lebih rapi dan mudah dibaca
    - Memisahkan logika menjadi bagian-bagian kecil

---

## Struktur dasar Method
**Struktur umum method meliputi beberapa bagian utama**:
- method tanpa nilai balik (void) dan tanpa parameter
```java
public static void sapa() {
    System.out.println("Halo, selamat belajar Java!");
}
```

- method dengan parameter
```java
public static void sapaNama(String nama) {
    System.out.println("Halo, " + nama);
}
```

- method dengan nilai balik
```java
public static int tambah(int a, int b) {
    return a + b;
}
```

---

## Cara Memanggil Method
```java
public class Contoh {
    public static void main(String[] args) {
        sapa(); // memanggil method tanpa parameter
        sapaNama("Dwi"); // memanggil method dengan parameter
        int hasil = tambah(5, 7);
        System.out.println("Hasil: " + hasil);
    }
    
    // method-method di bawah bisa berada di luar main
    public static void sapa() { ... }
    public static void sapaNama(String nama) { ... }
    public static int tambah(int a, int b) { ... }
}
```

---

## Parameter dan Return Value
| Jenis Method           | Contoh                                 | Penjelasan                              |
| ---------------------- | -------------------------------------- | --------------------------------------- |
| Tanpa parameter & void | `public static void cetak()`           | Tidak menerima atau mengembalikan nilai |
| Dengan parameter       | `public static void sapa(String nama)` | Menerima input, tidak mengembalikan     |
| Dengan return value    | `public static int kali(int a, int b)` | Mengembalikan hasil perhitungan         |

---

### Contoh sederhana:
**a. Cetak bilangan genap dari 1–N**
```java
public static void cetakGenap(int n) {
    for (int i = 1; i <= n; i++) {
        if (i % 2 == 0) System.out.print(i + " ");
    }
}
```

**b. Hitung faktorial**
```java
public static int faktorial(int n) {
    int hasil = 1;
    for (int i = 2; i <= n; i++) {
        hasil *= i;
    }
    return hasil;
}
```

**c. Cek bilangan prima**
```java
public static boolean isPrima(int n) {
    if (n <= 1) return false;
    for (int i = 2; i <= Math.sqrt(n); i++) {
        if (n % i == 0) return false;
    }
    return true;
}
```

**d. Contoh Method Berdasarkan Kombinasi**

| Jenis                         | Contoh                                     | Keterangan                  |
| ----------------------------- | ------------------------------------------ | --------------------------- |
| Tanpa parameter, tanpa return | `void tampilHalo()`                        | Sekadar mencetak            |
| Dengan parameter              | `void sapa(String nama)`                   | Menerima input              |
| Dengan return                 | `int kali(int a, int b)`                   | Mengembalikan hasil         |
| Dengan parameter + return     | `double hitungRata(int total, int jumlah)` | Hitung dan kembalikan nilai |

---

## Modularisasi dengan Method
Dalam program besar (misalnya data siswa), kamu bisa memecah fitur ke dalam method:
```java
public static void tambahSiswa(ArrayList<Siswa> daftar) { ... }
public static void tampilkanSiswa(ArrayList<Siswa> daftar) { ... }
public static void hapusSiswa(ArrayList<Siswa> daftar) { ... }
```

---

#### Dwi312