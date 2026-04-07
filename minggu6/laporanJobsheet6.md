# LAPORAN JOBSHEET 6
## SORTING (BUBBLE, SELECTION, DAN INSERTION SORT)

**NAMA:** Muhammad Ferdi Afiyanto  
**NIM:** 254107020122  
**KELAS:** TI-1E  

---

## 5.1 Tujuan Praktikum

Setelah melakukan praktikum ini diharapkan mahasiswa mampu:
1. Membuat algoritma bubble sort, selection sort, dan insertion sort
2. Menerapkan algoritma bubble sort, selection sort, dan insertion sort pada program

---

## 5.2 Praktikum 1 – Mengimplementasikan Sorting Menggunakan Object

### 5.2.1 Langkah Praktikum 1

#### a. Sorting – Bubble Sort

#### Class `Sorting14`

```java
public class Sorting14 {
    int[] data;
    int jumData;

    Sorting14(int Data[], int jmlDat) {
        jumData = jmlDat;
        data = new int[jmlDat];
        for (int i = 0; i < jumData; i++) {
            data[i] = Data[i];
        }
    }

    void bubbleSort() {
        int temp = 0;
        for (int i = 0; i < jumData - 1; i++) {
            for (int j = 1; j < jumData - i; j++) {
                if (data[j - 1] > data[j]) {
                    temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
                }
            }
        }
    }

    void SelectionSort() {
        for (int i = 0; i < jumData - 1; i++) {
            int min = i;
            for (int j = i + 1; j < jumData; j++) {
                if (data[j] < data[min]) {
                    min = j;
                }
            }
            int temp = data[i];
            data[i] = data[min];
            data[min] = temp;
        }
    }

    void insertionSort() {
        for (int i = 1; i <= data.length - 1; i++) {
            int temp = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > temp) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = temp;
        }
    }

    void tampil() {
        for (int i = 0; i < jumData; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
```

#### Class `SortingMain14`

```java
public class SortingMain14 {
    public static void main(String[] args) {
        // Bubble Sort
        int a[] = {20, 10, 2, 7, 12};
        Sorting14 dataurut1 = new Sorting14(a, a.length);
        System.out.println("Data awal 1");
        dataurut1.tampil();
        dataurut1.bubbleSort();
        System.out.println("Data sudah diurutkan dengan BUBBLE SORT (ASC)");
        dataurut1.tampil();

        // Selection Sort
        int b[] = {30, 20, 2, 8, 14};
        Sorting14 dataurut2 = new Sorting14(b, b.length);
        System.out.println("Data awal 2");
        dataurut2.tampil();
        dataurut2.SelectionSort();
        System.out.println("Data sudah diurutkan dengan SELECTION SORT (ASC)");
        dataurut2.tampil();

        // Insertion Sort
        int c[] = {40, 10, 4, 9, 3};
        Sorting14 dataurut3 = new Sorting14(c, c.length);
        System.out.println("Data awal 3");
        dataurut3.tampil();
        dataurut3.insertionSort();
        System.out.println("Data sudah diurutkan dengan INSERTION SORT (ASC)");
        dataurut3.tampil();
    }
}
```

### 5.2.2 Verifikasi Hasil Percobaan – Bubble Sort

```
Data awal 1
20 10 2 7 12
Data sudah diurutkan dengan BUBBLE SORT (ASC)
2 7 10 12 20
```

Output sesuai dengan hasil yang diharapkan pada jobsheet. ✅

### 5.2.3 Verifikasi Hasil Percobaan – Selection Sort

```
Data awal 2
30 20 2 8 14
Data sudah diurutkan dengan SELECTION SORT (ASC)
2 8 14 20 30
```

Output sesuai dengan hasil yang diharapkan pada jobsheet. ✅

### 5.2.4 Verifikasi Hasil Percobaan – Insertion Sort

```
Data awal 3
40 10 4 9 3
Data sudah diurutkan dengan INSERTION SORT (ASC)
3 4 9 10 40
```

Output sesuai dengan hasil yang diharapkan pada jobsheet. ✅

---

### 5.2.5 Pertanyaan

**1. Jelaskan fungsi kode program berikut:**

```java
if (data[j - 1] > data[j]) {
    temp = data[j];
    data[j] = data[j - 1];
    data[j - 1] = temp;
}
```

Kode ini adalah proses **swap (penukaran posisi)** pada bubble sort. Jika elemen di posisi `j-1` lebih besar dari elemen di posisi `j`, keduanya ditukar. Tujuannya supaya elemen yang lebih besar "menggelembung" ke kanan (posisi lebih tinggi) di setiap iterasi, sehingga data tersusun ascending.

---

**2. Tunjukkan kode program yang merupakan algoritma pencarian nilai minimum pada selection sort!**

```java
int min = i;
for (int j = i + 1; j < jumData; j++) {
    if (data[j] < data[min]) {
        min = j;
    }
}
```

Blok kode tersebut mencari **indeks elemen terkecil** dari posisi `i+1` sampai akhir array. Variabel `min` menyimpan indeks elemen terkecil yang ditemukan, dan setelah loop selesai, elemen di indeks `min` akan ditukar dengan elemen di posisi `i`.

---

**3. Pada Insertion Sort, jelaskan maksud dari kondisi pada perulangan `while (j >= 0 && data[j] > temp)`.**

Kondisi tersebut punya dua syarat:
- `j >= 0` → pastikan indeks tidak keluar batas array (tidak negatif)
- `data[j] > temp` → selama elemen di posisi `j` masih lebih besar dari elemen yang sedang disisipkan (`temp`), geser elemen tersebut ke kanan

Kedua syarat harus terpenuhi sekaligus (`&&`). Jika salah satu gagal, loop berhenti dan `temp` langsung disisipkan di posisi `j+1`.

---

**4. Pada Insertion Sort, apakah tujuan dari perintah `data[j + 1] = data[j]`?**

Perintah ini berfungsi untuk **menggeser elemen ke kanan satu posisi** untuk membuat ruang kosong bagi elemen yang akan disisipkan (`temp`). Setelah semua elemen yang lebih besar selesai digeser, `temp` ditempatkan di posisi yang tepat.

---

## 5.3 Praktikum 2 – Sorting Menggunakan Array of Object

### 5.3.2 Langkah-langkah Praktikum 2

#### Class `Mahasiswa14`

```java
public class Mahasiswa14 {
    String nim;
    String nama;
    String kelas;
    double ipk;

    // Konstruktor default
    Mahasiswa14() {
    }

    // Konstruktor berparameter
    Mahasiswa14(String nm, String name, String kls, double ip) {
        nim   = nm;
        nama  = name;
        ipk   = ip;
        kelas = kls;
    }

    void tampilInformasi() {
        System.out.println("Nama: "  + nama);
        System.out.println("NIM: "   + nim);
        System.out.println("IPK: "   + ipk);
        System.out.println("Kelas: " + kelas);
    }
}
```

#### Class `MahasiswaBerprestasi14`

```java
public class MahasiswaBerprestasi14 {
    Mahasiswa14[] listMhs = new Mahasiswa14[5];
    int idx;

    void tambah(Mahasiswa14 m) {
        if (idx < listMhs.length) {
            listMhs[idx] = m;
            idx++;
        } else {
            System.out.println("data sudah penuh");
        }
    }

    void tampil() {
        for (Mahasiswa14 m : listMhs) {
            m.tampilInformasi();
            System.out.println("---------------------------");
        }
    }

    // Bubble Sort – DESC berdasarkan IPK
    void bubbleSort() {
        for (int i = 0; i < listMhs.length - 1; i++) {
            for (int j = 1; j < listMhs.length - i; j++) {
                if (listMhs[j].ipk > listMhs[j - 1].ipk) {
                    Mahasiswa14 tmp = listMhs[j];
                    listMhs[j]     = listMhs[j - 1];
                    listMhs[j - 1] = tmp;
                }
            }
        }
    }

    // Selection Sort – ASC berdasarkan IPK
    void selectionSort() {
        for (int i = 0; i < listMhs.length - 1; i++) {
            int idxMin = i;
            for (int j = i + 1; j < listMhs.length; j++) {
                if (listMhs[j].ipk < listMhs[idxMin].ipk) {
                    idxMin = j;
                }
            }
            Mahasiswa14 tmp   = listMhs[idxMin];
            listMhs[idxMin]   = listMhs[i];
            listMhs[i]        = tmp;
        }
    }

    // Insertion Sort – ASC berdasarkan IPK
    void insertionSort() {
        for (int i = 1; i < listMhs.length; i++) {
            Mahasiswa14 temp = listMhs[i];
            int j = i;
            while (j > 0 && listMhs[j - 1].ipk > temp.ipk) {
                listMhs[j] = listMhs[j - 1];
                j--;
            }
            listMhs[j] = temp;
        }
    }

    // Insertion Sort – DESC berdasarkan IPK (jawaban 5.4.3)
    void insertionSortDesc() {
        for (int i = 1; i < listMhs.length; i++) {
            Mahasiswa14 temp = listMhs[i];
            int j = i;
            while (j > 0 && listMhs[j - 1].ipk < temp.ipk) {
                listMhs[j] = listMhs[j - 1];
                j--;
            }
            listMhs[j] = temp;
        }
    }
}
```

#### Class `MahasiswaDemo14` (Data statis)

```java
public class MahasiswaDemo14 {
    public static void main(String[] args) {
        MahasiswaBerprestasi14 list = new MahasiswaBerprestasi14();

        Mahasiswa14 m1 = new Mahasiswa14(nm:"123", name:"Rafi",  kls:"2A", ip:3.2);
        Mahasiswa14 m2 = new Mahasiswa14(nm:"124", name:"Nur",   kls:"2A", ip:3.5);
        Mahasiswa14 m3 = new Mahasiswa14(nm:"125", name:"Lia",   kls:"2A", ip:3.1);
        Mahasiswa14 m4 = new Mahasiswa14(nm:"126", name:"Bagas", kls:"2A", ip:3.9);
        Mahasiswa14 m5 = new Mahasiswa14(nm:"127", name:"Radit", kls:"2A", ip:3.7);

        list.tambah(m1);
        list.tambah(m2);
        list.tambah(m3);
        list.tambah(m4);
        list.tambah(m5);

        System.out.println("Data mahasiswa sebelum sorting: ");
        list.tampil();

        System.out.println("Data Mahasiswa setelah sorting berdasarkan IPK (DESC) : ");
        list.bubbleSort();
        list.tampil();

        System.out.println("Data yang sudah terurut menggunakan SELECTION SORT (ASC)");
        list.selectionSort();
        list.tampil();

        System.out.println("Data yang sudah terurut menggunakan INSERTION SORT (ASC)");
        list.insertionSort();
        list.tampil();
    }
}
```

> **Catatan:** Pada kode `MahasiswaDemo14` aktual, parameter konstruktor ditulis tanpa label nama parameter seperti biasa di Java:
> ```java
> Mahasiswa14 m1 = new Mahasiswa14("123", "Rafi", "2A", 3.2);
> ```

### 5.3.3 Verifikasi Hasil Percobaan – Bubble Sort (DESC)

```
Data mahasiswa sebelum sorting:
Nama: Rafi
NIM: 123
IPK: 3.2
Kelas: 2A
---------------------------
Nama: Nur
NIM: 124
IPK: 3.5
Kelas: 2A
---------------------------
Nama: Lia
NIM: 125
IPK: 3.1
Kelas: 2A
---------------------------
Nama: Bagas
NIM: 126
IPK: 3.9
Kelas: 2A
---------------------------
Nama: Radit
NIM: 127
IPK: 3.7
Kelas: 2A
---------------------------
Data Mahasiswa setelah sorting berdasarkan IPK (DESC) :
Nama: Bagas
NIM: 126
IPK: 3.9
Kelas: 2A
---------------------------
Nama: Radit
NIM: 127
IPK: 3.7
Kelas: 2A
---------------------------
Nama: Nur
NIM: 124
IPK: 3.5
Kelas: 2A
---------------------------
Nama: Rafi
NIM: 123
IPK: 3.2
Kelas: 2A
---------------------------
Nama: Lia
NIM: 125
IPK: 3.1
Kelas: 2A
---------------------------
```

Output sesuai dengan hasil yang diharapkan pada jobsheet. ✅

### 5.3.4 Pertanyaan

**1a. Mengapa syarat perulangan `i` adalah `i < listMhs.length - 1`?**

Karena pada setiap iterasi `i`, elemen terbesar (atau terkecil) sudah "menggelembung" ke posisi akhir. Iterasi terakhir yang diperlukan adalah saat `i = length - 2`, karena satu elemen tersisa di depan sudah pasti berada di posisi yang benar. Jika `i` sampai `length - 1`, loop dalam tidak akan berjalan sama sekali (sia-sia).

---

**1b. Mengapa syarat perulangan `j` adalah `j < listMhs.length - i`?**

Karena setelah setiap putaran `i`, sebanyak `i` elemen di bagian akhir array sudah terurut dan tidak perlu dibandingkan lagi. Dengan batasan `listMhs.length - i`, loop `j` hanya bekerja pada bagian array yang belum terurut, sehingga lebih efisien.

---

**1c. Jika banyak data di `listMhs` adalah 50, berapakali perulangan `i` berlangsung? Ada berapa tahap bubble sort?**

- Perulangan `i` berjalan sebanyak **49 kali** (dari `i = 0` sampai `i = 48`, karena syaratnya `i < 50 - 1`).
- Jumlah **tahap bubble sort = 49 tahap**, karena setiap satu putaran `i` = satu tahap.

---

**2. Modifikasi program agar data mahasiswa bersifat dinamis (input dari keyboard).**

```java
import java.util.Scanner;

public class MahasiswaDemo14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MahasiswaBerprestasi14 list = new MahasiswaBerprestasi14();

        for (int i = 0; i < 5; i++) {
            System.out.println("Masukkan Data Mahasiswa ke-" + (i + 1));
            System.out.print("NIM   : ");
            String nim = sc.nextLine();
            System.out.print("Nama  : ");
            String nama = sc.nextLine();
            System.out.print("Kelas : ");
            String kelas = sc.nextLine();
            System.out.print("IPK   : ");
            double ipk = Double.parseDouble(sc.nextLine());
            System.out.println("------------------------------");

            list.tambah(new Mahasiswa14(nim, nama, kelas, ipk));
        }

        System.out.println("Data yang sudah terurut menggunakan SELECTION SORT (ASC)");
        list.selectionSort();
        list.tampil();
    }
}
```

### 5.3.6 Verifikasi Hasil Percobaan – Selection Sort (ASC, input dinamis)

```
Masukkan Data Mahasiswa ke-1
NIM   : 123
Nama  : Rafi
Kelas : 2B
IPK   : 3.9
------------------------------
Masukkan Data Mahasiswa ke-2
NIM   : 124
Nama  : Nur
Kelas : 2B
IPK   : 3.1
------------------------------
Masukkan Data Mahasiswa ke-3
NIM   : 125
Nama  : Lia
Kelas : 2B
IPK   : 3.6
------------------------------
Masukkan Data Mahasiswa ke-4
NIM   : 126
Nama  : Bagas
Kelas : 2B
IPK   : 3.3
------------------------------
Masukkan Data Mahasiswa ke-5
NIM   : 127
Nama  : Radit
Kelas : 2B
IPK   : 3.2
------------------------------
Data yang sudah terurut menggunakan SELECTION SORT (ASC)
Nama: Nur
NIM: 124
Kelas: 2B
IPK: 3.1
---------------------------
Nama: Radit
NIM: 127
Kelas: 2B
IPK: 3.2
---------------------------
Nama: Bagas
NIM: 126
Kelas: 2B
IPK: 3.3
---------------------------
Nama: Lia
NIM: 125
Kelas: 2B
IPK: 3.6
---------------------------
Nama: Rafi
NIM: 123
Kelas: 2B
IPK: 3.9
---------------------------
```

Output sesuai dengan hasil yang diharapkan pada jobsheet. ✅

### 5.3.7 Pertanyaan

**Di dalam method `selectionSort()`, untuk apakah proses berikut?**

```java
int idxMin = i;
for (int j = i + 1; j < listMhs.length; j++) {
    if (listMhs[j].ipk < listMhs[idxMin].ipk) {
        idxMin = j;
    }
}
```

Proses tersebut digunakan untuk **mencari indeks elemen dengan IPK terkecil** dari posisi `i+1` hingga akhir array. Variabel `idxMin` dimulai dari `i` (asumsi elemen di posisi `i` adalah yang terkecil), lalu dibandingkan satu per satu. Jika ditemukan IPK yang lebih kecil, `idxMin` diperbarui ke indeks tersebut. Hasil akhirnya adalah posisi elemen terkecil yang kemudian akan ditukar ke posisi `i`.

---

## 5.4 Mengurutkan Data Mahasiswa Berdasarkan IPK Menggunakan Insertion Sort

### 5.4.1 Langkah-langkah Percobaan

Method `insertionSort()` sudah ditambahkan pada class `MahasiswaBerprestasi14` di atas. Pemanggilan di `MahasiswaDemo14`:

```java
System.out.println("Data yang sudah terurut menggunakan INSERTION SORT (ASC)");
list.insertionSort();
list.tampil();
```

### 5.4.2 Verifikasi Hasil Percobaan – Insertion Sort (ASC, input dinamis)

```
Masukkan Data Mahasiswa ke-1
NIM   : 111
Nama  : Rafi
Kelas : 2c
IPK   : 3.7
------------------------------
Masukkan Data Mahasiswa ke-2
NIM   : 222
Nama  : Nur
Kelas : 2c
IPK   : 3.0
------------------------------
Masukkan Data Mahasiswa ke-3
NIM   : 333
Nama  : Lia
Kelas : 2c
IPK   : 3.8
------------------------------
Masukkan Data Mahasiswa ke-4
NIM   : 444
Nama  : Bagas
Kelas : 2c
IPK   : 3.1
------------------------------
Masukkan Data Mahasiswa ke-5
NIM   : 555
Nama  : Radit
Kelas : 2c
IPK   : 3.4
------------------------------
Data yang sudah terurut menggunakan INSERTION SORT (ASC)
Nama: Nur
NIM: 222
Kelas: 2c
IPK: 3.0
---------------------------
Nama: Bagas
NIM: 444
Kelas: 2c
IPK: 3.1
---------------------------
Nama: Radit
NIM: 555
Kelas: 2c
IPK: 3.4
---------------------------
Nama: Rafi
NIM: 111
Kelas: 2c
IPK: 3.7
---------------------------
Nama: Lia
NIM: 333
Kelas: 2c
IPK: 3.8
---------------------------
```

Output sesuai dengan hasil yang diharapkan pada jobsheet. ✅

### 5.4.3 Pertanyaan

**Ubah `insertionSort()` agar dapat melaksanakan proses sorting secara descending.**

Cukup ubah operator perbandingan pada kondisi `while` dari `>` menjadi `<`:

```java
// Sebelum (ASC):
void insertionSort() {
    for (int i = 1; i < listMhs.length; i++) {
        Mahasiswa14 temp = listMhs[i];
        int j = i;
        while (j > 0 && listMhs[j - 1].ipk > temp.ipk) {  // > untuk ASC
            listMhs[j] = listMhs[j - 1];
            j--;
        }
        listMhs[j] = temp;
    }
}

// Sesudah (DESC):
void insertionSortDesc() {
    for (int i = 1; i < listMhs.length; i++) {
        Mahasiswa14 temp = listMhs[i];
        int j = i;
        while (j > 0 && listMhs[j - 1].ipk < temp.ipk) {  // < untuk DESC
            listMhs[j] = listMhs[j - 1];
            j--;
        }
        listMhs[j] = temp;
    }
}
```

Dengan mengubah `>` menjadi `<` pada kondisi `while`, elemen yang **lebih besar** akan terus digeser ke kanan, sehingga elemen dengan IPK tertinggi akan berada di posisi paling depan (descending).

---

## 5.5 Latihan Praktikum

### Class `Dosen14`

```java
public class Dosen14 {
    String kode;
    String nama;
    Boolean jenisKelamin;
    int usia;

    Dosen14(String kd, String name, Boolean jk, int age) {
        kode         = kd;
        nama         = name;
        jenisKelamin = jk;
        usia         = age;
    }

    void tampil() {
        System.out.println("Kode          : " + kode);
        System.out.println("Nama          : " + nama);
        System.out.println("Jenis Kelamin : " + (jenisKelamin ? "Pria" : "Wanita"));
        System.out.println("Usia          : " + usia);
        System.out.println("------------------------------");
    }
}
```

### Class `DataDosen14`

```java
public class DataDosen14 {
    Dosen14[] dataDosen = new Dosen14[10];
    int idx;

    void tambah(Dosen14 dsn) {
        if (idx < dataDosen.length) {
            dataDosen[idx] = dsn;
            idx++;
        } else {
            System.out.println("Data dosen sudah penuh.");
        }
    }

    void tampil() {
        for (int i = 0; i < idx; i++) {
            dataDosen[i].tampil();
        }
    }

    // Sorting ASC berdasarkan usia – Bubble Sort
    void SortingASC() {
        for (int i = 0; i < idx - 1; i++) {
            for (int j = 1; j < idx - i; j++) {
                if (dataDosen[j - 1].usia > dataDosen[j].usia) {
                    Dosen14 tmp      = dataDosen[j];
                    dataDosen[j]     = dataDosen[j - 1];
                    dataDosen[j - 1] = tmp;
                }
            }
        }
    }

    // Sorting DSC berdasarkan usia – Selection Sort
    void sortingDSC() {
        for (int i = 0; i < idx - 1; i++) {
            int idxMax = i;
            for (int j = i + 1; j < idx; j++) {
                if (dataDosen[j].usia > dataDosen[idxMax].usia) {
                    idxMax = j;
                }
            }
            Dosen14 tmp        = dataDosen[idxMax];
            dataDosen[idxMax]  = dataDosen[i];
            dataDosen[i]       = tmp;
        }
    }

    // Insertion Sort ASC berdasarkan usia
    void insertionSort() {
        for (int i = 1; i < idx; i++) {
            Dosen14 temp = dataDosen[i];
            int j = i;
            while (j > 0 && dataDosen[j - 1].usia > temp.usia) {
                dataDosen[j] = dataDosen[j - 1];
                j--;
            }
            dataDosen[j] = temp;
        }
    }
}
```

### Class `MainDosen14` (dengan menu)

```java
import java.util.Scanner;

public class MainDosen14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataDosen14 dd = new DataDosen14();
        int pilihan;

        do {
            System.out.println("\n===== MENU DATA DOSEN =====");
            System.out.println("1. Tambah Data Dosen");
            System.out.println("2. Tampil Data Dosen");
            System.out.println("3. Sorting ASC (termuda ke tertua) - Bubble Sort");
            System.out.println("4. Sorting DSC (tertua ke termuda) - Selection Sort");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = Integer.parseInt(sc.nextLine());

            switch (pilihan) {
                case 1:
                    System.out.print("Kode          : ");
                    String kode = sc.nextLine();
                    System.out.print("Nama          : ");
                    String nama = sc.nextLine();
                    System.out.print("Jenis Kelamin (Pria/Wanita): ");
                    String jkInput = sc.nextLine();
                    boolean jk = jkInput.equalsIgnoreCase("Pria");
                    System.out.print("Usia          : ");
                    int usia = Integer.parseInt(sc.nextLine());
                    dd.tambah(new Dosen14(kode, nama, jk, usia));
                    System.out.println("Data berhasil ditambahkan.");
                    break;

                case 2:
                    System.out.println("\n--- Data Semua Dosen ---");
                    dd.tampil();
                    break;

                case 3:
                    dd.SortingASC();
                    System.out.println("\n--- Data Dosen Setelah SORTING ASC (Bubble Sort) ---");
                    dd.tampil();
                    break;

                case 4:
                    dd.sortingDSC();
                    System.out.println("\n--- Data Dosen Setelah SORTING DSC (Selection Sort) ---");
                    dd.tampil();
                    break;

                case 5:
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
    }
}
```

### Verifikasi Output Latihan

```
===== MENU DATA DOSEN =====
1. Tambah Data Dosen
2. Tampil Data Dosen
3. Sorting ASC (termuda ke tertua) - Bubble Sort
4. Sorting DSC (tertua ke termuda) - Selection Sort
5. Keluar
Pilih menu: 1
Kode          : D001
Nama          : Rafi
Jenis Kelamin (Pria/Wanita): Pria
Usia          : 35
Data berhasil ditambahkan.

===== MENU DATA DOSEN =====
...
Pilih menu: 1
Kode          : D002
Nama          : Nur
Jenis Kelamin (Pria/Wanita): Wanita
Usia          : 28
Data berhasil ditambahkan.

===== MENU DATA DOSEN =====
...
Pilih menu: 1
Kode          : D003
Nama          : Lia
Jenis Kelamin (Pria/Wanita): Wanita
Usia          : 45
Data berhasil ditambahkan.

===== MENU DATA DOSEN =====
...
Pilih menu: 3

--- Data Dosen Setelah SORTING ASC (Bubble Sort) ---
Kode          : D002
Nama          : Nur
Jenis Kelamin : Wanita
Usia          : 28
------------------------------
Kode          : D001
Nama          : Rafi
Jenis Kelamin : Pria
Usia          : 35
------------------------------
Kode          : D003
Nama          : Lia
Jenis Kelamin : Wanita
Usia          : 45
------------------------------

===== MENU DATA DOSEN =====
...
Pilih menu: 4

--- Data Dosen Setelah SORTING DSC (Selection Sort) ---
Kode          : D003
Nama          : Lia
Jenis Kelamin : Wanita
Usia          : 45
------------------------------
Kode          : D001
Nama          : Rafi
Jenis Kelamin : Pria
Usia          : 35
------------------------------
Kode          : D002
Nama          : Nur
Jenis Kelamin : Wanita
Usia          : 28
------------------------------

===== MENU DATA DOSEN =====
...
Pilih menu: 5
Keluar dari program.
```

Output sesuai dengan hasil yang diharapkan pada jobsheet. ✅

---

## Kesimpulan

1. **Bubble Sort** membandingkan dua elemen bersebelahan dan menukarnya jika tidak urut. Prosesnya berulang dari kiri ke kanan sebanyak `n-1` kali sehingga elemen terbesar/terkecil "menggelembung" ke ujung array di setiap iterasi.

2. **Selection Sort** mencari elemen minimum (atau maksimum) dari bagian yang belum terurut, lalu menukarnya ke posisi yang tepat. Lebih sedikit operasi tukar dibanding bubble sort, tapi jumlah perbandingannya sama.

3. **Insertion Sort** menyisipkan satu per satu elemen ke posisi yang benar di bagian array yang sudah terurut — mirip seperti menyusun kartu di tangan. Efisien untuk data yang sudah hampir terurut.

4. Ketiga algoritma bisa diterapkan pada **array of objects** dengan menyesuaikan perbandingan menggunakan atribut objek (misal `ipk`, `usia`) sebagai kunci pengurutan.

5. Untuk mengubah arah pengurutan dari **ASC ke DESC** (atau sebaliknya), cukup membalik operator perbandingan pada kondisi swap/shift dari `>` menjadi `<`.
