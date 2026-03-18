# LAPORAN JOBSHEET 3
## ARRAY OF OBJECTS

**NAMA:** Muhammad Ferdi Afiyanto
**NIM:** 254107020122
**KELAS:** TI-1E

---

## 3.1 Tujuan Praktikum

Setelah melakukan materi praktikum ini, mahasiswa mampu:
1. Memahami dan menjelaskan fungsi array yang berisikan variabel object
2. Menerapkan instansiasi array of objects dalam Java
3. Melakukan operasi terhadap elemen dalam array of objects

---

## 3.2 Membuat Array dari Object, Mengisi dan Menampilkan

### 3.2.1 Langkah-langkah Percobaan

#### Class `Mahasiswa14`

```java
public class Mahasiswa14 {
    public String nim;
    public String nama;
    public String kelas;
    public float ipk;
}
```

#### Class `MahasiswaDemo14`

```java
public class MahasiswaDemo14 {
    public static void main(String[] args) {
        Mahasiswa14[] arrayOfMahasiswa = new Mahasiswa14[3];

        arrayOfMahasiswa[0] = new Mahasiswa14();
        arrayOfMahasiswa[0].nim   = "244107060033";
        arrayOfMahasiswa[0].nama  = "RAFI";
        arrayOfMahasiswa[0].kelas = "SIB-1E";
        arrayOfMahasiswa[0].ipk   = (float) 3.75;

        arrayOfMahasiswa[1] = new Mahasiswa14();
        arrayOfMahasiswa[1].nim   = "2341720172";
        arrayOfMahasiswa[1].nama  = "NUR";
        arrayOfMahasiswa[1].kelas = "TI-2A";
        arrayOfMahasiswa[1].ipk   = (float) 3.36;

        arrayOfMahasiswa[2] = new Mahasiswa14();
        arrayOfMahasiswa[2].nim   = "244107023006";
        arrayOfMahasiswa[2].nama  = "LIA";
        arrayOfMahasiswa[2].kelas = "TI-2E";
        arrayOfMahasiswa[2].ipk   = (float) 3.80;

        System.out.println("NIM   : " + arrayOfMahasiswa[0].nim);
        System.out.println("Nama  : " + arrayOfMahasiswa[0].nama);
        System.out.println("Kelas : " + arrayOfMahasiswa[0].kelas);
        System.out.println("IPK   : " + arrayOfMahasiswa[0].ipk);
        System.out.println("-----------------------------------");

        System.out.println("NIM   : " + arrayOfMahasiswa[1].nim);
        System.out.println("Nama  : " + arrayOfMahasiswa[1].nama);
        System.out.println("Kelas : " + arrayOfMahasiswa[1].kelas);
        System.out.println("IPK   : " + arrayOfMahasiswa[1].ipk);
        System.out.println("-----------------------------------");

        System.out.println("NIM   : " + arrayOfMahasiswa[2].nim);
        System.out.println("Nama  : " + arrayOfMahasiswa[2].nama);
        System.out.println("Kelas : " + arrayOfMahasiswa[2].kelas);
        System.out.println("IPK   : " + arrayOfMahasiswa[2].ipk);
        System.out.println("-----------------------------------");
    }
}
```

### 3.2.2 Verifikasi Hasil Percobaan

```
NIM   : 244107060033
Nama  : RAFI
Kelas : SIB-1E
IPK   : 3.75
-----------------------------------
NIM   : 2341720172
Nama  : NUR
Kelas : TI-2A
IPK   : 3.36
-----------------------------------
NIM   : 244107023006
Nama  : LIA
Kelas : TI-2E
IPK   : 3.8
-----------------------------------
BUILD SUCCESSFUL (total time: 0 seconds)
```

---

### 3.2.3 Pertanyaan

**1. Apakah class yang akan dibuat array of object harus selalu memiliki atribut dan sekaligus method?**

Tidak harus. Class `Mahasiswa14` hanya punya atribut (`nim`, `nama`, `kelas`, `ipk`) tanpa method apapun, tapi tetap bisa dijadikan array of object. Method bersifat opsional, tergantung kebutuhan.

---

**2. Apa yang dilakukan oleh kode program berikut?**

```java
Mahasiswa14[] arrayOfMahasiswa = new Mahasiswa14[3];
```

Membuat array bertipe `Mahasiswa14` berkapasitas 3 elemen. Saat ini semua elemen masih `null` — belum ada objek `Mahasiswa14` yang dibuat, hanya wadahnya saja yang dialokasikan di memori.

---

**3. Apakah class `Mahasiswa14` memiliki konstruktor? Kenapa bisa dipanggil `new Mahasiswa14()`?**

Tidak punya konstruktor eksplisit. Tapi Java otomatis menyediakan **default constructor** (tanpa parameter) untuk setiap class yang tidak mendefinisikan konstruktor sendiri. Itulah yang dipanggil oleh `new Mahasiswa14()`.

---

**4. Apa yang dilakukan oleh kode program berikut?**

```java
arrayOfMahasiswa[0] = new Mahasiswa14();
arrayOfMahasiswa[0].nim   = "244107060033";
arrayOfMahasiswa[0].nama  = "RAFI";
arrayOfMahasiswa[0].kelas = "SIB-1E";
arrayOfMahasiswa[0].ipk   = (float) 3.75;
```

`new Mahasiswa14()` membuat objek baru dan menyimpan referensinya ke indeks 0 array. Baris selanjutnya mengisi nilai atribut objek tersebut satu per satu.

---

**5. Mengapa class `Mahasiswa14` dan `MahasiswaDemo14` dipisahkan?**

Supaya tanggung jawabnya jelas. `Mahasiswa14` hanya sebagai blueprint/model data, `MahasiswaDemo14` yang menangani logika program (buat objek, isi data, tampilkan). Pemisahan ini bikin kode lebih rapi dan `Mahasiswa14` bisa dipakai ulang di class lain.

---

## 3.3 Menerima Input Isian Array Menggunakan Looping

### 3.3.1 Langkah-langkah Percobaan

`MahasiswaDemo14` dimodifikasi dengan menambahkan `Scanner` dan menggunakan `for` loop untuk input serta loop kedua untuk menampilkan data.

```java
import java.util.Scanner;

public class MahasiswaDemo14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Mahasiswa14[] arrayOfMahasiswa = new Mahasiswa14[3];
        String dummy;

        for (int i = 0; i < 3; i++) {
            arrayOfMahasiswa[i] = new Mahasiswa14();
            System.out.println("Masukkan Data Mahasiswa ke-" + (i + 1));
            System.out.print("NIM   : ");
            arrayOfMahasiswa[i].nim = sc.nextLine();
            System.out.print("Nama  : ");
            arrayOfMahasiswa[i].nama = sc.nextLine();
            System.out.print("Kelas : ");
            arrayOfMahasiswa[i].kelas = sc.nextLine();
            System.out.print("IPK   : ");
            dummy = sc.nextLine();
            arrayOfMahasiswa[i].ipk = Float.parseFloat(dummy);
            System.out.println("-----------------------------------");
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("Data Mahasiswa ke-" + (i + 1));
            System.out.println("NIM   : " + arrayOfMahasiswa[i].nim);
            System.out.println("Nama  : " + arrayOfMahasiswa[i].nama);
            System.out.println("Kelas : " + arrayOfMahasiswa[i].kelas);
            System.out.println("IPK   : " + arrayOfMahasiswa[i].ipk);
            System.out.println("-----------------------------------");
        }
    }
}
```

### 3.3.2 Verifikasi Hasil Percobaan

```
Masukkan Data Mahasiswa ke-1
NIM   : 244107060033
Nama  : RAFI
Kelas : SIB-1E
IPK   : 3.75
-----------------------------------
Masukkan Data Mahasiswa ke-2
NIM   : 2341720172
Nama  : NUR
Kelas : TI-2A
IPK   : 3.36
-----------------------------------
Masukkan Data Mahasiswa ke-3
NIM   : 244107023006
Nama  : LIA
Kelas : TI-2E
IPK   : 3.80
-----------------------------------
Data Mahasiswa ke-1
NIM   : 244107060033
Nama  : RAFI
Kelas : SIB-1E
IPK   : 3.75
-----------------------------------
Data Mahasiswa ke-2
NIM   : 2341720172
Nama  : NUR
Kelas : TI-2A
IPK   : 3.36
-----------------------------------
Data Mahasiswa ke-3
NIM   : 244107023006
Nama  : LIA
Kelas : TI-2E
IPK   : 3.8
-----------------------------------
BUILD SUCCESSFUL (total time: 1 minute 46 seconds)
```

---

### 3.3.3 Pertanyaan

**1. Tambahkan method `cetakInfo()` pada class `Mahasiswa14` kemudian modifikasi kode program pada langkah no 3.**

Penambahan `cetakInfo()` pada `Mahasiswa14`:

```java
public class Mahasiswa14 {
    public String nim;
    public String nama;
    public String kelas;
    public float ipk;

    public void cetakInfo() {
        System.out.println("NIM   : " + nim);
        System.out.println("Nama  : " + nama);
        System.out.println("Kelas : " + kelas);
        System.out.println("IPK   : " + ipk);
        System.out.println("-----------------------------------");
    }
}
```

Loop tampil di `MahasiswaDemo14` setelah dimodifikasi:

```java
for (int i = 0; i < 3; i++) {
    System.out.println("Data Mahasiswa ke-" + (i + 1));
    arrayOfMahasiswa[i].cetakInfo();
}
```

---

**2. Mengapa kode berikut menyebabkan error?**

```java
Mahasiswa14[] myArrayOfMahasiswa = new Mahasiswa14[3];
myArrayOfMahasiswa[0].nim = "244107060033";
```

Karena `new Mahasiswa14[3]` hanya membuat array kosong — semua elemen masih `null`. Mengakses `.nim` dari elemen yang `null` menyebabkan **NullPointerException**. Solusinya: instansiasi dulu setiap elemen dengan `myArrayOfMahasiswa[0] = new Mahasiswa14();` sebelum mengisi atributnya.

---

## 3.4 Constructor Berparameter

### 3.4.1 Langkah-langkah Percobaan

#### Class `Matakuliah14`

```java
public class Matakuliah14 {
    public String kode;
    public String nama;
    public int sks;
    public int jumlahJam;

    public Matakuliah14(String kode, String nama, int sks, int jumlahJam) {
        this.kode      = kode;
        this.nama      = nama;
        this.sks       = sks;
        this.jumlahJam = jumlahJam;
    }
}
```

#### Class `MataKuliahDemo14`

```java
import java.util.Scanner;

public class MataKuliahDemo14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Matakuliah14[] arrayOfMatakuliah = new Matakuliah14[3];
        String kode, nama, dummy;
        int sks, jumlahJam;

        for (int i = 0; i < 3; i++) {
            System.out.println("Masukkan Data Matakuliah ke-" + (i + 1));
            System.out.print("Kode       : ");
            kode = sc.nextLine();
            System.out.print("Nama       : ");
            nama = sc.nextLine();
            System.out.print("Sks        : ");
            dummy = sc.nextLine();
            sks = Integer.parseInt(dummy);
            System.out.print("Jumlah Jam : ");
            dummy = sc.nextLine();
            jumlahJam = Integer.parseInt(dummy);
            System.out.println("-----------------------------------");

            arrayOfMatakuliah[i] = new Matakuliah14(kode, nama, sks, jumlahJam);
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("Data Matakuliah ke-" + (i + 1));
            System.out.println("Kode       : " + arrayOfMatakuliah[i].kode);
            System.out.println("Nama       : " + arrayOfMatakuliah[i].nama);
            System.out.println("Sks        : " + arrayOfMatakuliah[i].sks);
            System.out.println("Jumlah Jam : " + arrayOfMatakuliah[i].jumlahJam);
            System.out.println("-----------------------------------");
        }
    }
}
```

### 3.4.2 Verifikasi Hasil Percobaan

```
Masukkan Data Matakuliah ke-1
Kode       : 12345
Nama       : Algoritma & Struktur Data
Sks        : 2
Jumlah Jam : 6
-----------------------------------
Masukkan Data Matakuliah ke-2
Kode       : 54321
Nama       : Sistem Basis Data
Sks        : 2
Jumlah Jam : 4
-----------------------------------
Masukkan Data Matakuliah ke-3
Kode       : 83652
Nama       : Dasar Pemrograman
Sks        : 2
Jumlah Jam : 4
-----------------------------------
Data Matakuliah ke-1
Kode       : 12345
Nama       : Algoritma & Struktur Data
Sks        : 2
Jumlah Jam : 6
-----------------------------------
Data Matakuliah ke-2
Kode       : 54321
Nama       : Sistem Basis Data
Sks        : 2
Jumlah Jam : 4
-----------------------------------
Data Matakuliah ke-3
Kode       : 83652
Nama       : Dasar Pemrograman
Sks        : 2
Jumlah Jam : 4
-----------------------------------
BUILD SUCCESSFUL (total time: 3 minutes 23 seconds)
```

---

### 3.4.3 Pertanyaan

**1. Apakah suatu class dapat memiliki lebih dari 1 constructor? Berikan contohnya.**

Bisa, ini disebut **constructor overloading**. Setiap constructor dibedakan dari jumlah atau tipe parameternya. Contoh pada `Matakuliah14`:

```java
// Constructor tanpa parameter
public Matakuliah14() {
    this.kode      = "-";
    this.nama      = "-";
    this.sks       = 0;
    this.jumlahJam = 0;
}

// Constructor berparameter penuh
public Matakuliah14(String kode, String nama, int sks, int jumlahJam) {
    this.kode      = kode;
    this.nama      = nama;
    this.sks       = sks;
    this.jumlahJam = jumlahJam;
}
```

---

**2. Tambahkan method `tambahData()` pada class `Matakuliah14`, kemudian gunakan di `MataKuliahDemo14`.**

Penambahan method `tambahData()` pada `Matakuliah14`:

```java
public void tambahData(String kode, String nama, int sks, int jumlahJam) {
    this.kode      = kode;
    this.nama      = nama;
    this.sks       = sks;
    this.jumlahJam = jumlahJam;
}
```

Contoh penggunaan di `MataKuliahDemo14`:

```java
// Memperbarui data matakuliah indeks 0 tanpa membuat objek baru
arrayOfMatakuliah[0].tambahData("99999", "Pemrograman Web", 3, 8);
```

---

**3. Tambahkan method `cetakInfo()` pada class `Matakuliah14`, kemudian gunakan di `MataKuliahDemo14`.**

Penambahan method `cetakInfo()` pada `Matakuliah14`:

```java
public void cetakInfo() {
    System.out.println("Kode       : " + kode);
    System.out.println("Nama       : " + nama);
    System.out.println("Sks        : " + sks);
    System.out.println("Jumlah Jam : " + jumlahJam);
    System.out.println("-----------------------------------");
}
```

Loop tampil di `MataKuliahDemo14` setelah dimodifikasi:

```java
for (int i = 0; i < 3; i++) {
    System.out.println("Data Matakuliah ke-" + (i + 1));
    arrayOfMatakuliah[i].cetakInfo();
}
```

---

**4. Modifikasi agar panjang array ditentukan oleh user melalui input Scanner.**

```java
System.out.print("Masukkan jumlah matakuliah: ");
int jumlah = Integer.parseInt(sc.nextLine());
Matakuliah14[] arrayOfMatakuliah = new Matakuliah14[jumlah];

for (int i = 0; i < jumlah; i++) {
    // ... proses input sama seperti sebelumnya
}
```

Dengan ini ukuran array tidak lagi hardcode di angka 3, tapi mengikuti input user.

---

## 3.5 Tugas

### Tugas 1 – Program Data Dosen

#### Class `Dosen14`

```java
public class Dosen14 {
    public String kode;
    public String nama;
    public Boolean jenisKelamin;
    public int usia;

    public Dosen14(String kode, String nama, Boolean jenisKelamin, int usia) {
        this.kode         = kode;
        this.nama         = nama;
        this.jenisKelamin = jenisKelamin;
        this.usia         = usia;
    }
}
```

#### Class `DosenDemo14`

```java
import java.util.Scanner;

public class DosenDemo14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jumlah dosen: ");
        int jumlah = Integer.parseInt(sc.nextLine());

        Dosen14[] arrayOfDosen = new Dosen14[jumlah];

        // Input data menggunakan FOR
        for (int i = 0; i < arrayOfDosen.length; i++) {
            System.out.println("Masukkan Data Dosen ke-" + (i + 1));
            System.out.print("Kode          : ");
            String kode = sc.nextLine();
            System.out.print("Nama          : ");
            String nama = sc.nextLine();
            System.out.print("Jenis Kelamin (Pria/Wanita): ");
            String jkInput = sc.nextLine();
            boolean jk = jkInput.equalsIgnoreCase("Pria");
            System.out.print("Usia          : ");
            int usia = Integer.parseInt(sc.nextLine());
            System.out.println("-----------------------------------");

            arrayOfDosen[i] = new Dosen14(kode, nama, jk, usia);
        }

        // Panggil method static dari DataDosen14
        DataDosen14.dataSemuaDosen(arrayOfDosen);
        DataDosen14.jumlahDosenPerJenisKelamin(arrayOfDosen);
        DataDosen14.rerataUsiaDosenPerJenisKelamin(arrayOfDosen);
        DataDosen14.infoDosenPalingTua(arrayOfDosen);
        DataDosen14.infoDosenPalingMuda(arrayOfDosen);
    }
}
```

---

### Tugas 2 – Class `DataDosen14`

```java
public class DataDosen14 {

    // a) Menampilkan data semua dosen
    public static void dataSemuaDosen(Dosen14[] arrayOfDosen) {
        int i = 1;
        System.out.println("\n--- Data Semua Dosen ---");
        for (Dosen14 d : arrayOfDosen) {
            System.out.println("Data Dosen ke-" + i++);
            System.out.println("Kode          : " + d.kode);
            System.out.println("Nama          : " + d.nama);
            System.out.println("Jenis Kelamin : " + (d.jenisKelamin ? "Pria" : "Wanita"));
            System.out.println("Usia          : " + d.usia);
            System.out.println("------------------------");
        }
    }

    // b) Menampilkan jumlah dosen per jenis kelamin
    public static void jumlahDosenPerJenisKelamin(Dosen14[] arrayOfDosen) {
        int pria = 0, wanita = 0;
        for (Dosen14 d : arrayOfDosen) {
            if (d.jenisKelamin) pria++;
            else wanita++;
        }
        System.out.println("\n--- Jumlah Dosen Per Jenis Kelamin ---");
        System.out.println("Pria   : " + pria);
        System.out.println("Wanita : " + wanita);
    }

    // c) Menampilkan rata-rata usia dosen per jenis kelamin
    public static void rerataUsiaDosenPerJenisKelamin(Dosen14[] arrayOfDosen) {
        int totalUsiaPria = 0, totalUsiaWanita = 0;
        int pria = 0, wanita = 0;

        for (Dosen14 d : arrayOfDosen) {
            if (d.jenisKelamin) {
                totalUsiaPria += d.usia;
                pria++;
            } else {
                totalUsiaWanita += d.usia;
                wanita++;
            }
        }
        System.out.println("\n--- Rata-Rata Usia Dosen ---");
        if (pria > 0)   System.out.println("Pria   : " + (totalUsiaPria / (float) pria));
        if (wanita > 0) System.out.println("Wanita : " + (totalUsiaWanita / (float) wanita));
    }

    // d) Menampilkan data dosen paling tua
    public static void infoDosenPalingTua(Dosen14[] arrayOfDosen) {
        if (arrayOfDosen.length == 0) return;
        Dosen14 tertua = arrayOfDosen[0];
        for (Dosen14 d : arrayOfDosen) {
            if (d.usia > tertua.usia) tertua = d;
        }
        System.out.println("\n--- Dosen Paling Tua ---");
        System.out.println("Nama : " + tertua.nama + " (Usia: " + tertua.usia + ")");
    }

    // e) Menampilkan data dosen paling muda
    public static void infoDosenPalingMuda(Dosen14[] arrayOfDosen) {
        if (arrayOfDosen.length == 0) return;
        Dosen14 termuda = arrayOfDosen[0];
        for (Dosen14 d : arrayOfDosen) {
            if (d.usia < termuda.usia) termuda = d;
        }
        System.out.println("\n--- Dosen Paling Muda ---");
        System.out.println("Nama : " + termuda.nama + " (Usia: " + termuda.usia + ")");
    }
}
```

### Verifikasi Output Tugas

```
Masukkan jumlah dosen: 3
Masukkan Data Dosen ke-1
Kode          : 05032001
Nama          : Bagas
Jenis Kelamin (Pria/Wanita): Wanita
Usia          : 24
-----------------------------------
Masukkan Data Dosen ke-2
Kode          : 06041995
Nama          : Radit
Jenis Kelamin (Pria/Wanita): Pria
Usia          : 30
-----------------------------------
Masukkan Data Dosen ke-3
Kode          : 23061975
Nama          : Reza
Jenis Kelamin (Pria/Wanita): Wanita
Usia          : 50
-----------------------------------

--- Data Semua Dosen ---
Data Dosen ke-1
Kode          : 05032001
Nama          : Anggi
Jenis Kelamin : Wanita
Usia          : 24
------------------------
Data Dosen ke-2
Kode          : 06041995
Nama          : Radit
Jenis Kelamin : Pria
Usia          : 30
------------------------
Data Dosen ke-3
Kode          : 23061975
Nama          : Syifa
Jenis Kelamin : Wanita
Usia          : 50
------------------------

--- Jumlah Dosen Per Jenis Kelamin ---
Pria   : 1
Wanita : 2

--- Rata-Rata Usia Dosen ---
Pria   : 30.0
Wanita : 37.0

--- Dosen Paling Tua ---
Nama : Reza (Usia: 50)

--- Dosen Paling Muda ---
Nama : Bagas (Usia: 24)
BUILD SUCCESSFUL
```

---

## Kesimpulan

1. **Array of Objects** digunakan untuk menyimpan banyak objek dalam satu variabel. `new ClassName[n]` hanya membuat wadah — setiap elemen tetap harus diinstansiasi dengan `new ClassName()` sebelum bisa dipakai, kalau tidak akan `NullPointerException`.

2. Jika class tidak punya konstruktor eksplisit, Java otomatis menyediakan **default constructor**. Begitu kita tambahkan konstruktor berparameter, default constructor tersebut hilang kecuali kita definisikan sendiri (**constructor overloading**).

3. **Looping** untuk input dan output membuat kode jauh lebih ringkas dibanding menulis manual untuk tiap elemen, dan otomatis menyesuaikan jika jumlah data berubah.

4. Method di `DataDosen14` dibuat **static** sehingga bisa dipanggil langsung via nama class (`DataDosen14.metodeName()`) tanpa perlu membuat objek dari class tersebut terlebih dahulu.

5. Memisahkan class model, class demo, dan class helper adalah praktik OOP yang baik — kode lebih mudah dibaca, dirawat, dan digunakan ulang.