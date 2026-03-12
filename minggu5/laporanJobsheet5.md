# LAPORAN JOBSHEET 5
## BRUTE FORCE DAN DIVIDE AND CONQUER

**NAMA:** Muhammad Ferdi Afiyanto  
**NIM:** 254107020122  
**KELAS:** TI-1E  

---

## 5.1 Tujuan Praktikum

Setelah melakukan materi praktikum ini, mahasiswa mampu:
1. Membuat algoritma Brute Force dan Divide and Conquer
2. Menerapkan penggunaan algoritma Brute Force dan Divide and Conquer

---

## 5.2 Menghitung Nilai Faktorial dengan Algoritma Brute Force dan Divide and Conquer

### 5.2.1 Langkah-langkah Percobaan

#### Class `Faktorial`

```java
package minggu5;

public class Faktorial {

    int faktorialBF(int n) {
        int fakto = 1;
        for (int i = 1; i <= n; i++) {
            fakto = fakto * i;
        }
        return fakto;
    }

    int faktorialDC(int n) {
        if (n == 1) {
            return 1;
        } else {
            int fakto = n * faktorialDC(n - 1);
            return fakto;
        }
    }
}
```

#### Class `MainFaktorial`

```java
package minggu5;

import java.util.Scanner;

public class MainFaktorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nilai: ");
        int nilai = input.nextInt();

        Faktorial fk = new Faktorial();
        System.out.println("Nilai faktorial " + nilai + " menggunakan BF: " + fk.faktorialBF(nilai));
        System.out.println("Nilai faktorial " + nilai + " menggunakan DC: " + fk.faktorialDC(nilai));
    }
}
```

### 5.2.2 Verifikasi Hasil Percobaan

```
Masukkan nilai: 5
Nilai faktorial 5 menggunakan BF: 120
Nilai faktorial 5 menggunakan DC: 120
```

---

### 5.2.3 Pertanyaan

**1. Pada base line Algoritma Divide and Conquer untuk melakukan pencarian nilai faktorial, jelaskan perbedaan bagian kode pada penggunaan `if` dan `else`!**

- **Bagian `if (n == 1)`** merupakan **base case** (kondisi dasar/batas rekursi). Ketika nilai `n` mencapai 1, fungsi langsung mengembalikan nilai `1` tanpa memanggil dirinya sendiri lagi. Ini adalah titik berhenti dari rekursi.
- **Bagian `else`** merupakan **recursive case**. Ketika nilai `n` lebih dari 1, fungsi memanggil dirinya sendiri dengan argumen `n-1` (memecah masalah menjadi sub-masalah yang lebih kecil), lalu mengalikannya dengan `n`. Inilah inti dari strategi Divide and Conquer — memecah masalah besar menjadi masalah yang lebih kecil sampai mencapai base case.

---

**2. Apakah memungkinkan perulangan pada method `faktorialBF()` diubah selain menggunakan `for`? Buktikan!**

Ya, memungkinkan. Perulangan `for` dapat diganti dengan `while` maupun `do-while`.

**Menggunakan `while`:**
```java
int faktorialBF(int n) {
    int fakto = 1;
    int i = 1;
    while (i <= n) {
        fakto = fakto * i;
        i++;
    }
    return fakto;
}
```

**Menggunakan `do-while`:**
```java
int faktorialBF(int n) {
    int fakto = 1;
    int i = 1;
    do {
        fakto = fakto * i;
        i++;
    } while (i <= n);
    return fakto;
}
```

Keduanya menghasilkan output yang sama, misalnya untuk `n = 5`, tetap menghasilkan `120`.

---

**3. Jelaskan perbedaan antara `fakto *= i;` dan `int fakto = n * faktorialDC(n-1);` !**

| | `fakto *= i` | `int fakto = n * faktorialDC(n-1)` |
|---|---|---|
| **Jenis** | Iteratif (perulangan) | Rekursif (memanggil diri sendiri) |
| **Cara kerja** | Mengalikan nilai `fakto` saat ini dengan nilai `i` secara berulang dalam loop, hasilnya disimpan di variabel yang sama | Memanggil kembali fungsi `faktorialDC` dengan nilai `n-1`, lalu hasilnya dikalikan `n`. Proses berlanjut sampai base case |
| **Pendekatan** | Brute Force – menyelesaikan masalah langsung dari nilai 1 hingga n | Divide and Conquer – memecah masalah n! menjadi n × (n-1)! |
| **Stack memori** | Tidak menggunakan call stack tambahan | Menggunakan call stack sebanyak kedalaman rekursi |

---

**4. Buat Kesimpulan tentang perbedaan cara kerja method `faktorialBF()` dan `faktorialDC()`!**

- **`faktorialBF()`** menggunakan pendekatan **iteratif (Brute Force)**. Method ini menghitung faktorial dengan cara mengalikan semua bilangan dari 1 hingga n secara berurutan menggunakan perulangan `for`. Proses berlangsung secara linear dari bawah ke atas (1 → 2 → 3 → ... → n).

- **`faktorialDC()`** menggunakan pendekatan **rekursif (Divide and Conquer)**. Method ini memecah masalah faktorial n menjadi sub-masalah yang lebih kecil, yaitu n × faktorial(n-1), hingga mencapai base case (n == 1). Proses berlangsung dari atas ke bawah (n → n-1 → ... → 1) lalu hasil dikombinasikan saat kembali (combine).

Keduanya menghasilkan nilai yang sama, namun berbeda dari sisi cara kerja, penggunaan memori, dan struktur kode.

---

## 5.3 Menghitung Hasil Pangkat dengan Algoritma Brute Force dan Divide and Conquer

### 5.3.1 Langkah-langkah Percobaan

#### Class `Pangkat`

```java
package minggu5;

public class Pangkat {

    int nilai, pangkat;

    Pangkat(int n, int p) {
        nilai = n;
        pangkat = p;
    }

    int pangkatBF(int a, int n) {
        int hasil = 1;
        for (int i = 0; i < n; i++) {
            hasil = hasil * a;
        }
        return hasil;
    }

    int pangkatDC(int a, int n) {
        if (n == 1) {
            return a;
        } else {
            if (n % 2 == 1) {
                return (pangkatDC(a, n / 2) * pangkatDC(a, n / 2) * a);
            } else {
                return (pangkatDC(a, n / 2) * pangkatDC(a, n / 2));
            }
        }
    }
}
```

#### Class `MainPangkat`

```java

import java.util.Scanner;

public class MainPangkat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan jumlah elemen: ");
        int elemen = input.nextInt();

        Pangkat[] png = new Pangkat[elemen];
        for (int i = 0; i < elemen; i++) {
            System.out.print("Masukan nilai basis elemen ke-" + (i + 1) + ": ");
            int basis = input.nextInt();
            System.out.print("Masukan nilai pangkat elemen ke-" + (i + 1) + ": ");
            int pangkat = input.nextInt();
            png[i] = new Pangkat(basis, pangkat);
        }

        System.out.println("HASIL PANGKAT BRUTEFORCE:");
        for (Pangkat p : png) {
            System.out.println(p.nilai + "^" + p.pangkat + ": " + p.pangkatBF(p.nilai, p.pangkat));
        }

        System.out.println("HASIL PANGKAT DIVIDE AND CONQUER:");
        for (Pangkat p : png) {
            System.out.println(p.nilai + "^" + p.pangkat + ": " + p.pangkatDC(p.nilai, p.pangkat));
        }
    }
}
```

### 5.3.2 Verifikasi Hasil Percobaan

```
Masukkan jumlah elemen: 3
Masukan nilai basis elemen ke-1: 2
Masukan nilai pangkat elemen ke-1: 3
Masukan nilai basis elemen ke-2: 4
Masukan nilai pangkat elemen ke-2: 5
Masukan nilai basis elemen ke-3: 6
Masukan nilai pangkat elemen ke-3: 7
HASIL PANGKAT BRUTEFORCE:
2^3: 8
4^5: 1024
6^7: 279936
HASIL PANGKAT DIVIDE AND CONQUER:
2^3: 8
4^5: 1024
6^7: 279936
```

---

### 5.3.3 Pertanyaan

**1. Jelaskan mengenai perbedaan 2 method yang dibuat yaitu `pangkatBF()` dan `pangkatDC()`!**

- **`pangkatBF(int a, int n)`** menggunakan pendekatan **Brute Force iteratif**. Method ini menghitung a^n dengan cara mengalikan `a` sebanyak `n` kali menggunakan loop `for`. Kompleksitas waktu: **O(n)**.

- **`pangkatDC(int a, int n)`** menggunakan pendekatan **Divide and Conquer rekursif**. Method ini membagi masalah a^n menjadi dua sub-masalah yaitu a^(n/2) × a^(n/2). Jika pangkat ganjil, ditambah satu faktor `a`. Hal ini mengurangi jumlah operasi perkalian secara signifikan. Kompleksitas waktu: **O(log n)**.

---

**2. Apakah tahap *combine* sudah termasuk dalam kode tersebut? Tunjukkan!**

Ya, tahap **combine** sudah termasuk. Tahap combine terjadi saat hasil dari sub-masalah digabungkan kembali, yaitu pada baris:

```java
// Pangkat genap - combine dua hasil sub-masalah
return (pangkatDC(a, n / 2) * pangkatDC(a, n / 2));

// Pangkat ganjil - combine dua hasil sub-masalah + satu faktor tambahan
return (pangkatDC(a, n / 2) * pangkatDC(a, n / 2) * a);
```

Perkalian hasil dua rekursi `pangkatDC(a, n/2)` merupakan tahap **combine** dari Divide and Conquer.

---

**3. Pada method `pangkatBF()` terdapat parameter untuk melewatkan nilai yang akan dipangkatkan dan pangkat berapa, padahal di class `Pangkat` telah ada atribut `nilai` dan `pangkat`. Apakah method tersebut tetap relevan untuk memiliki parameter? Apakah bisa jika method tersebut dibuat tanpa parameter? Jika bisa, seperti apa method `pangkatBF()` yang tanpa parameter?**

Method dengan parameter tetap relevan jika ingin fleksibel (bisa menghitung pangkat dari nilai lain di luar atribut objek). Namun, jika method hanya akan menggunakan atribut yang sudah ada di dalam class, maka **bisa dibuat tanpa parameter** dengan mengakses langsung atribut `nilai` dan `pangkat`:

```java
int pangkatBF() {
    int hasil = 1;
    for (int i = 0; i < pangkat; i++) {
        hasil = hasil * nilai;
    }
    return hasil;
}
```

Dengan versi tanpa parameter, pemanggilan cukup: `p.pangkatBF()` tanpa perlu menyertakan argumen.

---

**4. Tarik kesimpulan tentang cara kerja method `pangkatBF()` dan `pangkatDC()`!**

- **`pangkatBF()`** bekerja secara **iteratif** — mengalikan basis sebanyak pangkat kali dalam sebuah loop. Cara ini sederhana namun kurang efisien untuk pangkat yang besar karena jumlah operasi sebanding dengan nilai pangkat (O(n)).

- **`pangkatDC()`** bekerja secara **rekursif** — memecah masalah menjadi separuhnya di setiap langkah. Untuk pangkat genap: hasil = subhasil × subhasil; untuk pangkat ganjil: hasil = subhasil × subhasil × a. Ini jauh lebih efisien karena jumlah operasi hanya O(log n).

Kesimpulan: `pangkatDC()` lebih efisien dari sisi kompleksitas waktu dibanding `pangkatBF()`, terutama untuk nilai pangkat yang besar.

---

## 5.4 Menghitung Sum Array dengan Algoritma Brute Force dan Divide and Conquer

### 5.4.1 Langkah-langkah Percobaan

#### Class `Sum`

```java

public class Sum {

    double keuntungan[];

    Sum(int el) {
        keuntungan = new double[el];
    }

    double totalBF() {
        double total = 0;
        for (int i = 0; i < keuntungan.length; i++) {
            total = total + keuntungan[i];
        }
        return total;
    }

    double totalDC(double arr[], int l, int r) {
        if (l == r) {
            return arr[l];
        }

        int mid = (l + r) / 2;
        double lsum = totalDC(arr, l, mid);
        double rsum = totalDC(arr, mid + 1, r);
        return lsum + rsum;
    }
}
```

#### Class `MainSum`

```java
package minggu5;

import java.util.Scanner;

public class MainSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan jumlah elemen: ");
        int elemen = input.nextInt();

        Sum sm = new Sum(elemen);
        for (int i = 0; i < elemen; i++) {
            System.out.print("Masukkan keuntungan ke-" + (i + 1) + ": ");
            sm.keuntungan[i] = input.nextDouble();
        }

        System.out.println("Total keuntungan menggunakan Bruteforce: " + sm.totalBF());
        System.out.println("Total keuntungan menggunakan Divide and Conquer: " + sm.totalDC(sm.keuntungan, 0, elemen - 1));
    }
}
```

### 5.4.2 Verifikasi Hasil Percobaan

```
Masukkan jumlah elemen: 5
Masukkan keuntungan ke-1: 10
Masukkan keuntungan ke-2: 20
Masukkan keuntungan ke-3: 30
Masukkan keuntungan ke-4: 40
Masukkan keuntungan ke-5: 50
Total keuntungan menggunakan Bruteforce: 150.0
Total keuntungan menggunakan Divide and Conquer: 150.0
```

---

### 5.4.3 Pertanyaan

**1. Kenapa dibutuhkan variable `mid` pada method `TotalDC()`?**

Variable `mid` dibutuhkan untuk menentukan **titik pembagian** array menjadi dua bagian (kiri dan kanan). Ini adalah inti dari proses **Divide** dalam strategi Divide and Conquer. Tanpa `mid`, kita tidak bisa memisahkan array menjadi sub-array yang lebih kecil untuk diproses secara rekursif.

```java
int mid = (l + r) / 2;
```

`mid` dihitung sebagai rata-rata indeks kiri (`l`) dan kanan (`r`), sehingga array selalu dibagi dua secara merata.

---

**2. Untuk apakah statement di bawah ini dilakukan dalam `TotalDC()`?**
```java
double lsum = totalDC(arr, l, mid);
double rsum = totalDC(arr, mid + 1, r);
```

Statement ini merupakan tahap **Conquer** — setiap sub-array yang sudah dibagi dipanggil secara rekursif untuk dihitung totalnya masing-masing:
- `lsum` = total penjumlahan elemen dari indeks `l` sampai `mid` (bagian kiri)
- `rsum` = total penjumlahan elemen dari indeks `mid+1` sampai `r` (bagian kanan)

Rekursi terus berlanjut sampai mencapai base case (satu elemen).

---

**3. Kenapa diperlukan penjumlahan hasil `lsum` dan `rsum` seperti di bawah ini?**
```java
return lsum + rsum;
```

Ini adalah tahap **Combine** dari Divide and Conquer. Setelah kedua sub-masalah (kiri dan kanan) diselesaikan secara rekursif, hasilnya harus digabungkan kembali untuk mendapatkan total keseluruhan. Penjumlahan `lsum + rsum` menyatukan kembali hasil perhitungan dari kedua bagian array.

---

**4. Apakah base case dari `totalDC()`?**

Base case dari `totalDC()` adalah:
```java
if (l == r) {
    return arr[l];
}
```

Kondisi `l == r` berarti hanya ada **satu elemen** dalam bagian array yang sedang diproses. Dalam kondisi ini, tidak perlu dibagi lagi — cukup kembalikan nilai elemen tersebut sebagai hasil.

---

**5. Tarik Kesimpulan tentang cara kerja `totalDC()`**

`totalDC()` bekerja dengan tiga tahap Divide and Conquer:
1. **Divide:** Array dibagi menjadi dua bagian menggunakan nilai `mid`.
2. **Conquer:** Setiap bagian dijumlahkan secara rekursif sampai mencapai base case (satu elemen).
3. **Combine:** Hasil dari bagian kiri (`lsum`) dan bagian kanan (`rsum`) dijumlahkan untuk mendapatkan total keseluruhan.

Metode ini efisien karena memecah masalah menjadi sub-masalah yang semakin kecil, dengan kompleksitas waktu **O(n)** — sama dengan Brute Force untuk kasus penjumlahan, namun menunjukkan pola Divide and Conquer yang bisa diterapkan pada masalah yang lebih kompleks.

---

## 4.5 Latihan Praktikum

### Data Mahasiswa

| Nama  | NIM       | Tahun Masuk | Nilai UTS | Nilai UAS |
|-------|-----------|-------------|-----------|-----------|
| Ahmad | 220101001 | 2022        | 78        | 82        |
| Budi  | 220101002 | 2022        | 85        | 88        |
| Cindy | 220101003 | 2021        | 90        | 87        |
| Dian  | 220101004 | 2021        | 76        | 79        |
| Eko   | 220101005 | 2023        | 92        | 95        |
| Fajar | 220101006 | 2020        | 88        | 85        |
| Gina  | 220101007 | 2023        | 80        | 83        |
| Hadi  | 220101008 | 2020        | 82        | 84        |

### Class `Mahasiswa`

```java

public class Mahasiswa {
    String nama;
    String nim;
    int tahunMasuk;
    int nilaiUTS;
    int nilaiUAS;

    Mahasiswa(String nama, String nim, int tahunMasuk, int nilaiUTS, int nilaiUAS) {
        this.nama = nama;
        this.nim = nim;
        this.tahunMasuk = tahunMasuk;
        this.nilaiUTS = nilaiUTS;
        this.nilaiUAS = nilaiUAS;
    }
}
```

### Class `NilaiMahasiswa`

```java
package minggu5;

public class NilaiMahasiswa {

    int maxUTS_DC(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = (l + r) / 2;
        int leftMax  = maxUTS_DC(arr, l, mid);
        int rightMax = maxUTS_DC(arr, mid + 1, r);
        return (leftMax > rightMax) ? leftMax : rightMax;
    }

    int minUTS_DC(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = (l + r) / 2;
        int leftMin  = minUTS_DC(arr, l, mid);
        int rightMin = minUTS_DC(arr, mid + 1, r);
        return (leftMin < rightMin) ? leftMin : rightMin;
    }

    double rataUAS_BF(int[] arr) {
        double total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        return total / arr.length;
    }
}
```

### Class `MainLatihan`

```java
package minggu5;

public class MainLatihan {
    public static void main(String[] args) {

        Mahasiswa[] data = {
            new Mahasiswa("Ahmad", "220101001", 2022, 78, 82),
            new Mahasiswa("Budi",  "220101002", 2022, 85, 88),
            new Mahasiswa("Cindy", "220101003", 2021, 90, 87),
            new Mahasiswa("Dian",  "220101004", 2021, 76, 79),
            new Mahasiswa("Eko",   "220101005", 2023, 92, 95),
            new Mahasiswa("Fajar", "220101006", 2020, 88, 85),
            new Mahasiswa("Gina",  "220101007", 2023, 80, 83),
            new Mahasiswa("Hadi",  "220101008", 2020, 82, 84)
        };

        int n = data.length;
        int[] nilaiUTS = new int[n];
        int[] nilaiUAS = new int[n];

        for (int i = 0; i < n; i++) {
            nilaiUTS[i] = data[i].nilaiUTS;
            nilaiUAS[i] = data[i].nilaiUAS;
        }

        NilaiMahasiswa nm = new NilaiMahasiswa();

        int maxUTS = nm.maxUTS_DC(nilaiUTS, 0, n - 1);
        System.out.println("a) Nilai UTS Tertinggi (DC): " + maxUTS);

        int minUTS = nm.minUTS_DC(nilaiUTS, 0, n - 1);
        System.out.println("b) Nilai UTS Terendah (DC): " + minUTS);

        double rataUAS = nm.rataUAS_BF(nilaiUAS);
        System.out.println("c) Rata-rata Nilai UAS (BF): " + rataUAS);
    }
}
```

### Output Program

```
a) Nilai UTS Tertinggi (DC): 92
b) Nilai UTS Terendah (DC): 76
c) Rata-rata Nilai UAS (BF): 85.375
```

---
