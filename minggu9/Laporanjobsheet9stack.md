# LAPORAN JOBSHEET 9
## STACK

**NAMA:** Muhammad Ferdi Afiyanto  
**NIM:** 254107020114  
**KELAS:** TI-1E  

---

## 9.1 Tujuan Praktikum

Setelah melakukan materi praktikum ini, mahasiswa mampu:
1. Membuat struktur data Stack
2. Menerapkan algoritma Stack ke dalam program Java

---

## 9.2 Percobaan 1 – Mahasiswa Mengumpulkan Tugas

### 9.2.1 Langkah-langkah Percobaan

Percobaan ini mensimulasikan sejumlah mahasiswa yang mengumpulkan berkas tugas di meja dosen secara ditumpuk (stack). Dosen menilai tugas dimulai dari berkas paling atas sesuai prinsip **LIFO (Last In, First Out)**.

#### Class `Mahasiswa14`

```java
public class Mahasiswa14 {
    String nim;
    String nama;
    String kelas;
    int nilai;

    Mahasiswa14() {
    }

    Mahasiswa14(String nama, String nim, String kelas) {
        this.nama  = nama;
        this.nim   = nim;
        this.kelas = kelas;
        nilai      = -1;
    }

    void tugasDinilai(int nilai) {
        this.nilai = nilai;
    }
}
```

#### Class `StackTugasMahasiswa14`

```java
public class StackTugasMahasiswa14 {
    Mahasiswa14[] stack;
    int size;
    int top;

    public StackTugasMahasiswa14(int size) {
        this.size = size;
        stack     = new Mahasiswa14[size];
        top       = -1;
    }

    public boolean isFull() {
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(Mahasiswa14 mhs) {
        if (!isFull()) {
            top++;
            stack[top] = mhs;
        } else {
            System.out.println("Stack penuh! Tidak bisa menambahkan tugas lagi.");
        }
    }

    public Mahasiswa14 pop() {
        if (!isEmpty()) {
            Mahasiswa14 m = stack[top];
            top--;
            return m;
        } else {
            System.out.println("Stack kosong! Tidak ada tugas untuk dinilai.");
            return null;
        }
    }

    public Mahasiswa14 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack kosong! Tidak ada tugas yang dikumpulkan");
            return null;
        }
    }

    public void print() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i].nama + "\t" + stack[i].nim + "\t" + stack[i].kelas);
        }
        System.out.println("");
    }
}
```

> **Catatan:** Method `print()` mengiterasi dari indeks `top` ke `0` sehingga data ditampilkan dari atas (terakhir masuk) ke bawah (pertama masuk), sesuai urutan tampilan stack.

#### Class `MahasiswaDemo14`

```java
import java.util.Scanner;

public class MahasiswaDemo14 {
    public static void main(String[] args) {
        StackTugasMahasiswa14 stack = new StackTugasMahasiswa14(5);
        Scanner scan = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Mengumpulkan Tugas");
            System.out.println("2. Menilai Tugas");
            System.out.println("3. Melihat Tugas Teratas");
            System.out.println("4. Melihat Daftar Tugas");
            System.out.print("Pilih: ");
            pilih = scan.nextInt();
            scan.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("Nama: ");
                    String nama = scan.nextLine();
                    System.out.print("NIM: ");
                    String nim = scan.nextLine();
                    System.out.print("Kelas: ");
                    String kelas = scan.nextLine();
                    Mahasiswa14 mhs = new Mahasiswa14(nama, nim, kelas);
                    stack.push(mhs);
                    System.out.printf("Tugas %s berhasil dikumpulkan\n", mhs.nama);
                    break;
                case 2:
                    Mahasiswa14 dinilai = stack.pop();
                    if (dinilai != null) {
                        System.out.println("Menilai tugas dari " + dinilai.nama);
                        System.out.print("Masukkan nilai (0-100): ");
                        int nilai = scan.nextInt();
                        dinilai.tugasDinilai(nilai);
                        System.out.printf("Nilai Tugas %s adalah %d\n", dinilai.nama, nilai);
                    }
                    break;
                case 3:
                    Mahasiswa14 lihat = stack.peek();
                    if (lihat != null) {
                        System.out.println("Tugas terakhir dikumpulkan oleh " + lihat.nama);
                    }
                    break;
                case 4:
                    System.out.println("Daftar semua tugas");
                    System.out.println("Nama\tNIM\tKelas");
                    stack.print();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih >= 1 && pilih <= 4);
    }
}
```

---

### 9.2.2 Verifikasi Hasil Percobaan 1

```
Menu:
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
Pilih: 1
Nama: Dila
NIM: 1001
Kelas: 1A
Tugas Dila berhasil dikumpulkan

Menu:
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
Pilih: 1
Nama: Erik
NIM: 1002
Kelas: 1B
Tugas Erik berhasil dikumpulkan

Menu:
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
Pilih: 3
Tugas terakhir dikumpulkan oleh Erik

Menu:
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
Pilih: 1
Nama: Tika
NIM: 1003
Kelas: 1C
Tugas Tika berhasil dikumpulkan

Menu:
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
Pilih: 4
Daftar semua tugas
Nama    NIM     Kelas
Tika    1003    1C
Erik    1002    1B
Dila    1001    1A

Menu:
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
Pilih: 2
Menilai tugas dari Tika
Masukkan nilai (0-100): 87
Nilai Tugas Tika adalah 87

Menu:
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
Pilih: 4
Daftar semua tugas
Nama    NIM     Kelas
Erik    1002    1B
Dila    1001    1A
```

Output sesuai dengan hasil yang diharapkan pada jobsheet. ✅

---

### 9.2.3 Pertanyaan

**1. Lakukan perbaikan pada kode program, sehingga keluaran yang dihasilkan sama dengan verifikasi hasil percobaan! Bagian mana yang perlu diperbaiki?**

Perbaikan yang diperlukan ada pada method `print()` di class `StackTugasMahasiswa14`. Pada versi awal, iterasi dimulai dari indeks `0` ke `top`, sehingga daftar tugas ditampilkan dari bawah ke atas. Padahal tampilan yang benar sesuai verifikasi adalah dari atas ke bawah (tugas terakhir masuk di paling atas).

Sebelum diperbaiki:
```java
for (int i = 0; i <= top; i++) {
    System.out.println(stack[i].nama + "\t" + stack[i].nim + "\t" + stack[i].kelas);
}
```

Setelah diperbaiki:
```java
for (int i = top; i >= 0; i--) {
    System.out.println(stack[i].nama + "\t" + stack[i].nim + "\t" + stack[i].kelas);
}
```

Dengan iterasi dari `top` turun ke `0`, data yang terakhir masuk (berada di posisi `top`) akan ditampilkan pertama kali, mencerminkan susunan tumpukan yang sesungguhnya.

---

**2. Berapa banyak data tugas mahasiswa yang dapat ditampung di dalam Stack? Tunjukkan potongan kode programnya!**

Stack dapat menampung **5** data tugas mahasiswa. Kapasitas ini ditentukan saat instansiasi object di dalam method `main`:

```java
StackTugasMahasiswa14 stack = new StackTugasMahasiswa14(5);
```

Di dalam konstruktor, nilai `5` disimpan ke atribut `size` dan digunakan untuk membuat array berkapasitas tetap:

```java
public StackTugasMahasiswa14(int size) {
    this.size = size;
    stack     = new Mahasiswa14[size];  // kapasitas = 5
    top       = -1;
}
```

---

**3. Mengapa perlu pengecekan kondisi `!isFull()` pada method `push`? Kalau kondisi if-else tersebut dihapus, apa dampaknya?**

Pengecekan `!isFull()` diperlukan untuk memastikan masih ada ruang kosong di dalam array sebelum menambahkan data baru. Tanpa pengecekan ini, ketika stack sudah penuh (`top == size - 1`) dan `push` tetap dijalankan, maka `top` akan bertambah melebihi batas indeks array sehingga terjadi **ArrayIndexOutOfBoundsException** dan program akan crash. Pengecekan ini merupakan mekanisme pengaman penting dalam struktur data stack berbasis array statis.

---

**4. Modifikasi kode program pada class `MahasiswaDemo14` dan `StackTugasMahasiswa14` sehingga pengguna juga dapat melihat mahasiswa yang pertama kali mengumpulkan tugas melalui operasi lihat tugas terbawah!**

Tambahkan method `peekBottom()` pada class `StackTugasMahasiswa14`:

```java
public Mahasiswa14 peekBottom() {
    if (!isEmpty()) {
        return stack[0];
    } else {
        System.out.println("Stack kosong! Tidak ada tugas yang dikumpulkan");
        return null;
    }
}
```

Tambahkan menu baru (case 5) pada class `MahasiswaDemo14`:

```java
System.out.println("5. Melihat Tugas Terbawah");
```

```java
case 5:
    Mahasiswa14 bawah = stack.peekBottom();
    if (bawah != null) {
        System.out.println("Mahasiswa pertama mengumpulkan tugas: " + bawah.nama);
    }
    break;
```

Ubah kondisi `do-while` menjadi:
```java
} while (pilih >= 1 && pilih <= 5);
```

Contoh output:
```
Menu:
...
5. Melihat Tugas Terbawah
Pilih: 5
Mahasiswa pertama mengumpulkan tugas: Dila
```

---

**5. Tambahkan method untuk dapat menghitung berapa banyak tugas yang sudah dikumpulkan saat ini, serta tambahkan operasi menunya!**

Tambahkan method `countTugas()` pada class `StackTugasMahasiswa14`:

```java
public int countTugas() {
    return top + 1;
}
```

Tambahkan menu baru (case 6) pada class `MahasiswaDemo14`:

```java
System.out.println("6. Hitung Tugas Terkumpul");
```

```java
case 6:
    System.out.println("Jumlah tugas yang sudah dikumpulkan: " + stack.countTugas());
    break;
```

Ubah kondisi `do-while` menjadi:
```java
} while (pilih >= 1 && pilih <= 6);
```

Contoh output:
```
Menu:
...
6. Hitung Tugas Terkumpul
Pilih: 6
Jumlah tugas yang sudah dikumpulkan: 2
```

---

## 9.3 Percobaan 2 – Konversi Nilai Tugas ke Biner

### 9.3.1 Langkah-langkah Percobaan

Percobaan ini menambahkan fitur konversi nilai tugas bertipe `int` ke bentuk biner menggunakan stack terpisah bernama `StackKonversi`. Pendekatan ini memisahkan tanggung jawab antara stack mahasiswa dan stack konversi karena tipe data yang dikelola berbeda.

#### Class `StackKonversi14`

```java
public class StackKonversi14 {
    int[] tumpukanBiner;
    int size;
    int top;

    public StackKonversi14() {
        this.size      = 32;   // asumsi 32 bit
        tumpukanBiner  = new int[size];
        top            = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack penuh");
        } else {
            top++;
            tumpukanBiner[top] = data;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong.");
            return -1;
        } else {
            int data = tumpukanBiner[top];
            top--;
            return data;
        }
    }
}
```

#### Method `konversiDesimalKeBiner` pada `StackTugasMahasiswa14`

```java
public String konversiDesimalKeBiner(int nilai) {
    StackKonversi14 stack = new StackKonversi14();
    while (nilai > 0) {
        int sisa  = nilai % 2;
        stack.push(sisa);
        nilai     = nilai / 2;
    }
    String biner = new String();
    while (!stack.isEmpty()) {
        biner += stack.pop();
    }
    return biner;
}
```

#### Penambahan pada Case 2 di `MahasiswaDemo14`

```java
case 2:
    Mahasiswa14 dinilai = stack.pop();
    if (dinilai != null) {
        System.out.println("Menilai tugas dari " + dinilai.nama);
        System.out.print("Masukkan nilai (0-100): ");
        int nilai = scan.nextInt();
        dinilai.tugasDinilai(nilai);
        System.out.printf("Nilai Tugas %s adalah %d\n", dinilai.nama, nilai);
        String biner = stack.konversiDesimalKeBiner(nilai);
        System.out.println("Nilai Biner Tugas: " + biner);
    }
    break;
```

---

### 9.3.2 Verifikasi Hasil Percobaan 2

```
Menu:
1. Mengumpulkan Tugas
2. Menilai Tugas
3. Melihat Tugas Teratas
4. Melihat Daftar Tugas
Pilih: 2
Menilai tugas dari Tika
Masukkan nilai (0-100): 87
Nilai Tugas Tika adalah 87
Nilai Biner Tugas: 1010111
```

Output sesuai dengan hasil yang diharapkan pada jobsheet. ✅

---

### 9.3.3 Pertanyaan

**1. Jelaskan alur kerja dari method `konversiDesimalKeBiner`!**

Method `konversiDesimalKeBiner` bekerja dalam dua tahap:

**Tahap 1 – Pembagian dan push sisa:**  
Selama nilai masih lebih dari 0, nilai dibagi 2 dan sisa hasil baginya (`nilai % 2`) di-push ke dalam `StackKonversi`. Karena stack bersifat LIFO, sisa yang diperoleh terakhir (bit paling signifikan) akan berada di posisi `top`.

```
Contoh: nilai = 87
87 % 2 = 1  → push(1),  nilai = 43
43 % 2 = 1  → push(1),  nilai = 21
21 % 2 = 1  → push(1),  nilai = 10
10 % 2 = 0  → push(0),  nilai = 5
 5 % 2 = 1  → push(1),  nilai = 2
 2 % 2 = 0  → push(0),  nilai = 1
 1 % 2 = 1  → push(1),  nilai = 0
```

**Tahap 2 – Pop dan rangkai string:**  
Semua nilai di-pop satu per satu dan dirangkai menjadi string. Karena pop mengambil dari atas (bit paling signifikan lebih dulu), hasilnya adalah representasi biner yang benar.

```
Pop berurutan: 1, 0, 1, 0, 1, 1, 1 → "1010111"
```

Hasil: `87` (desimal) = `1010111` (biner) ✅

---

**2. Pada method `konversiDesimalKeBiner`, ubah kondisi perulangan menjadi `while (kode != 0)`, bagaimana hasilnya? Jelaskan alasannya!**

Hasilnya **sama** selama nilai input adalah bilangan bulat positif. Kondisi `while (nilai > 0)` dan `while (nilai != 0)` secara fungsional identik untuk input positif karena:
- Saat `nilai > 0`: kondisi kedua sama-sama terpenuhi.
- Saat `nilai == 0`: kedua kondisi sama-sama berhenti.

Namun terdapat perbedaan penting untuk **kasus tepi**:
- Jika nilai input adalah **0**, kondisi `while (nilai > 0)` langsung berhenti sehingga string `biner` tetap kosong (`""`). Sedangkan `while (nilai != 0)` juga langsung berhenti karena `0 != 0` adalah `false`. Keduanya menghasilkan string kosong untuk input `0`, yang artinya representasi `"0"` tidak ditangani dengan benar oleh kedua versi.
- Untuk input **negatif**, kondisi `nilai > 0` langsung false sehingga aman, sedangkan `nilai != 0` akan masuk loop dan menghasilkan sisa negatif yang merusak hasil biner.

Kesimpulan: untuk cakupan yang aman, kondisi `nilai > 0` lebih tepat digunakan.

---

## 9.4 Latihan Praktikum

### Deskripsi

Mahasiswa mengajukan surat izin (sakit atau keperluan lain) setiap kali tidak mengikuti perkuliahan. Surat terakhir yang masuk akan diproses lebih dulu oleh admin Prodi sesuai prinsip LIFO.

### Class `Surat14`

```java
public class Surat14 {
    String idSurat;
    String namaMahasiswa;
    String kelas;
    char   jenisIzin;
    int    durasi;

    Surat14() {
    }

    Surat14(String idSurat, String namaMahasiswa, String kelas, char jenisIzin, int durasi) {
        this.idSurat        = idSurat;
        this.namaMahasiswa  = namaMahasiswa;
        this.kelas          = kelas;
        this.jenisIzin      = jenisIzin;
        this.durasi         = durasi;
    }
}
```

### Class `StackSurat14`

```java
public class StackSurat14 {
    Surat14[] stack;
    int size;
    int top;

    public StackSurat14(int size) {
        this.size = size;
        stack     = new Surat14[size];
        top       = -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(Surat14 surat) {
        if (!isFull()) {
            top++;
            stack[top] = surat;
        } else {
            System.out.println("Stack penuh! Tidak bisa menerima surat lagi.");
        }
    }

    public Surat14 pop() {
        if (!isEmpty()) {
            Surat14 s = stack[top];
            top--;
            return s;
        } else {
            System.out.println("Stack kosong! Tidak ada surat untuk diproses.");
            return null;
        }
    }

    public Surat14 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack kosong! Tidak ada surat.");
            return null;
        }
    }

    public Surat14 cariSurat(String nama) {
        for (int i = top; i >= 0; i--) {
            if (stack[i].namaMahasiswa.equalsIgnoreCase(nama)) {
                return stack[i];
            }
        }
        return null;
    }

    public void print() {
        System.out.printf("%-10s %-15s %-8s %-10s %-6s%n",
                          "ID Surat", "Nama", "Kelas", "Jenis Izin", "Durasi");
        for (int i = top; i >= 0; i--) {
            String jenis = (stack[i].jenisIzin == 'S') ? "Sakit" : "Izin";
            System.out.printf("%-10s %-15s %-8s %-10s %-6d hari%n",
                    stack[i].idSurat, stack[i].namaMahasiswa,
                    stack[i].kelas, jenis, stack[i].durasi);
        }
        System.out.println();
    }
}
```

### Class `SuratDemo14`

```java
import java.util.Scanner;

public class SuratDemo14 {
    public static void main(String[] args) {
        StackSurat14 stack = new StackSurat14(10);
        Scanner scan = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Terima Surat Izin");
            System.out.println("2. Proses Surat Izin");
            System.out.println("3. Lihat Surat Izin Terakhir");
            System.out.println("4. Cari Surat");
            System.out.print("Pilih: ");
            pilih = scan.nextInt();
            scan.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("ID Surat          : ");
                    String id    = scan.nextLine();
                    System.out.print("Nama Mahasiswa    : ");
                    String nama  = scan.nextLine();
                    System.out.print("Kelas             : ");
                    String kelas = scan.nextLine();
                    System.out.print("Jenis Izin (S/I)  : ");
                    char jenis   = scan.nextLine().toUpperCase().charAt(0);
                    System.out.print("Durasi (hari)     : ");
                    int durasi   = scan.nextInt();
                    scan.nextLine();
                    Surat14 surat = new Surat14(id, nama, kelas, jenis, durasi);
                    stack.push(surat);
                    System.out.printf("Surat dari %s berhasil diterima.\n", nama);
                    break;
                case 2:
                    Surat14 diproses = stack.pop();
                    if (diproses != null) {
                        String keterangan = (diproses.jenisIzin == 'S') ? "Sakit" : "Izin";
                        System.out.println("Memproses surat dari : " + diproses.namaMahasiswa);
                        System.out.println("Kelas                : " + diproses.kelas);
                        System.out.println("Jenis Izin           : " + keterangan);
                        System.out.println("Durasi               : " + diproses.durasi + " hari");
                        System.out.println("Status               : Surat berhasil divalidasi.");
                    }
                    break;
                case 3:
                    Surat14 teratas = stack.peek();
                    if (teratas != null) {
                        String keterangan = (teratas.jenisIzin == 'S') ? "Sakit" : "Izin";
                        System.out.println("Surat terakhir masuk dari : " + teratas.namaMahasiswa);
                        System.out.println("Kelas                     : " + teratas.kelas);
                        System.out.println("Jenis Izin                : " + keterangan);
                        System.out.println("Durasi                    : " + teratas.durasi + " hari");
                    }
                    break;
                case 4:
                    System.out.print("Masukkan nama mahasiswa yang dicari: ");
                    String cari  = scan.nextLine();
                    Surat14 hasil = stack.cariSurat(cari);
                    if (hasil != null) {
                        String keterangan = (hasil.jenisIzin == 'S') ? "Sakit" : "Izin";
                        System.out.println("Surat ditemukan!");
                        System.out.println("ID Surat   : " + hasil.idSurat);
                        System.out.println("Nama       : " + hasil.namaMahasiswa);
                        System.out.println("Kelas      : " + hasil.kelas);
                        System.out.println("Jenis Izin : " + keterangan);
                        System.out.println("Durasi     : " + hasil.durasi + " hari");
                    } else {
                        System.out.println("Surat dari " + cari + " tidak ditemukan.");
                    }
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih >= 1 && pilih <= 4);
    }
}
```

### Verifikasi Hasil Latihan

```
Menu:
1. Terima Surat Izin
2. Proses Surat Izin
3. Lihat Surat Izin Terakhir
4. Cari Surat
Pilih: 1
ID Surat          : S001
Nama Mahasiswa    : Andi
Kelas             : 2A
Jenis Izin (S/I)  : S
Durasi (hari)     : 3
Surat dari Andi berhasil diterima.

Menu:
...
Pilih: 1
ID Surat          : S002
Nama Mahasiswa    : Budi
Kelas             : 2B
Jenis Izin (S/I)  : I
Durasi (hari)     : 1
Surat dari Budi berhasil diterima.

Menu:
...
Pilih: 3
Surat terakhir masuk dari : Budi
Kelas                     : 2B
Jenis Izin                : Izin
Durasi                    : 1 hari

Menu:
...
Pilih: 4
Masukkan nama mahasiswa yang dicari: Andi
Surat ditemukan!
ID Surat   : S001
Nama       : Andi
Kelas      : 2A
Jenis Izin : Sakit
Durasi     : 3 hari

Menu:
...
Pilih: 2
Memproses surat dari : Budi
Kelas                : 2B
Jenis Izin           : Izin
Durasi               : 1 hari
Status               : Surat berhasil divalidasi.
```

Output sesuai dengan logika stack LIFO yang diharapkan. ✅

---

## Kesimpulan

1. **Stack** adalah struktur data yang mengikuti prinsip **LIFO (Last In, First Out)** — data yang terakhir dimasukkan adalah yang pertama dikeluarkan. Prinsip ini diimplementasikan melalui pointer `top` yang selalu menunjuk indeks elemen teratas.

2. Empat operasi utama Stack yang wajib dipahami adalah: **push** (menambah data ke atas), **pop** (mengeluarkan data dari atas), **peek** (melihat data teratas tanpa menghapus), dan **print** (menampilkan seluruh isi stack dari atas ke bawah).

3. Pengecekan `isFull()` sebelum `push` dan `isEmpty()` sebelum `pop` atau `peek` sangat penting untuk mencegah **ArrayIndexOutOfBoundsException** dan memastikan program tidak crash saat batas array terlampaui atau stack dalam kondisi kosong.

4. Konversi bilangan desimal ke biner memanfaatkan sifat LIFO pada stack: sisa pembagian pertama (bit paling kecil) masuk paling awal dan keluar paling akhir, sehingga saat di-pop urutan bit menjadi benar dari yang paling signifikan.

5. Stack dapat diterapkan pada berbagai kasus nyata seperti pengelolaan antrian berkas tugas, validasi surat izin, konversi bilangan, maupun operasi undo/redo pada aplikasi, dengan hanya menyesuaikan tipe data yang disimpan di dalam array stack.