# Trial & Error:
- Loop do-while di pilihBuku() terus berulang

## Output:
```
=== Pinjam Buku ===
Masukkan ID Anggota Peminjam: A001

--- Daftar Buku yang Tersedia ---

---------------------------------------------------------------------------
No | ID    | Judul                               | Penulis                   |
---------------------------------------------------------------------------
1  | B002  | Design Patterns                     | Erich Gamma               |
2  | B003  | The Pragmatic Programmer            | Andrew Hunt               |
3  | B004  | Refactoring                         | Martin Fowler             |
4  | B005  | Head First Java                     | Kathy Sierra              |
5  | B006  | Effective Java                      | Joshua Bloch              |
6  | B007  | Java: The Complete Reference        | Herbert Schildt           |
7  | B008  | Introduction to Algorithms          | Thomas H. Cormen          |
8  | B009  | Structure Computer Programs         | Harold Abelson            |
9  | B010  | The Art of Computer Programming     | Donald Knuth              |
---------------------------------------------------------------------------
Pilih nomor yang tersedia: 1
Pilih nomor yang tersedia: 1
Pilih nomor yang tersedia: 1
Pilih nomor yang tersedia: 1
Pilih nomor yang tersedia: 1
Pilih nomor yang tersedia: 1
Pilih nomor yang tersedia: 1

```
## Code:
```java
public String pilihBuku(Scanner input) {
    String kodeBukuSementara = "";
    int num;
    boolean ulang;
    
    do {
        System.out.print("Pilih nomor yang tersedia: ");
        num = PerpusUtil.inputInt(input);
        ulang = false;
        
        if(num < 1 || num > daftarBuku.length || daftarBuku[num - 1] == null) {
            ulang = true;
            System.out.println("Pilihan: " + num +" tidak valid.");
        } else if (!daftarBuku[num-1].getStatus().equalsIgnoreCase("Tersedia")) {
            ulang = true;
        } else {
            kodeBukuSementara = daftarBuku[num-1].getKodeBuku();
            daftarBuku[num-1].setStatus("Dipinjam");
        }
        
    } while (ulang);
    
    return kodeBukuSementara;
}
```

### Loop do-while di pilihBuku() terus berulang karena:
- **daftar buku yang tersedia** data hanya menampilkan yang status `Tersedia`,tapi validasi num membandingkan dengan `daftarBuku.length` (10 elemen total), bukan jumlah buku yang benar-benar ditampilkan.
- Nomor yang tampil (1,2,3,...) bukan langsung index array `daftarBuku`,
tapi urutan berdasarkan filter `bukuTersedia()`. Jadi, `num` yang dipilih **tidak sama dengan posisi di array**.
- Saat user pilih "1", program tetap looping karena mungkin **elemen** di `daftarBuku[num-1]` `null` atau **statusnya tidak cocok**, walau di daftar buku tersedia terlihat valid.

### Solusi
#### Simpan sementara mapping nomor → index array
- membuat array `indexMapping[]` supaya setiap nomor di daftar buku tersedia tahu dia berada di index ke berapa di `daftarBuku`.
```java
int[] indexMapping = new int[daftarBuku.length];
int count = 0;
```

### Cacatan Teknis
- Nomor pilihan user 1..N selalu cocok dengan buku yang tampil, tidak perlu mengakses `null`.
- Tidak bergantung ke panjang `daftarBuku` (10 slot), tapi ke jumlah buku yang benar-benar tersedia.
- Tidak akan terjebak dalam `looping` tanpa henti.