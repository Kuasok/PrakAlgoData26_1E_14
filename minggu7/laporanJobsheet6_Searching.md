# LAPORAN JOBSHEET 6
## SEARCHING

**NAMA:** Muhammad Ferdi Afiyanto  
**NIM:** 254107020122  
**KELAS:** TI-1E  

---

## 6.1 Tujuan Praktikum

Setelah melakukan materi praktikum ini, mahasiswa mampu:
1. Menjelaskan mengenai algoritma Searching
2. Membuat dan mendeklarasikan struktur algoritma Searching
3. Menerapkan dan mengimplementasikan algoritma Searching

---

## 6.2 Searching – Algoritma Sequential Search

### 6.2.1 Langkah-langkah Percobaan Sequential Search

Praktikum ini melanjutkan class `Mahasiswa14`, `MahasiswaBerprestasi14`, dan `MahasiswaDemo14` dari Jobsheet 5, kemudian ditambahkan method-method untuk keperluan searching.

#### Class `Mahasiswa14`

```java
public class Mahasiswa14 {
    String nim;
    String nama;
    String kelas;
    double ipk;

    Mahasiswa14() {
    }

    Mahasiswa14(String nm, String name, String kls, double ip) {
        nim   = nm;
        nama  = name;
        ipk   = ip;
        kelas = kls;
    }

    void tampilInformasi() {
        System.out.println("Nama: "  + nama);
        System.out.println("NIM: "   + nim);
        System.out.println("Kelas: " + kelas);
        System.out.println("IPK: "   + ipk);
    }
}
```

#### Class `MahasiswaBerprestasi14` (ditambah method searching)

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

    // Sequential Search berdasarkan IPK
    int sequentialSearching(double cari) {
        int posisi = -1;
        for (int j = 0; j < listMhs.length; j++) {
            if (listMhs[j].ipk == cari) {
                posisi = j;
                break;
            }
        }
        return posisi;
    }

    // Menampilkan posisi hasil pencarian
    void tampilPoisisi(double x, int pos) {
        if (pos != -1) {
            System.out.println("data mahasiswa dengan IPK :" + x +
                               "  ditemukan pada indeks " + pos);
        } else {
            System.out.println("data " + x + " tidak ditemukan");
        }
    }

    // Menampilkan detail data mahasiswa hasil pencarian
    void tampilDataSearch(double x, int pos) {
        if (pos != -1) {
            System.out.println("nim\t : " + listMhs[pos].nim);
            System.out.println("nama\t : " + listMhs[pos].nama);
            System.out.println("kelas\t : " + listMhs[pos].kelas);
            System.out.println("ipk\t : " + x);
        } else {
            System.out.println("Data mahasiswa dengan IPK " + x + " tidak ditemukan");
        }
    }

    // Binary Search berdasarkan IPK (data harus terurut ASC)
    int findBinarySearch(double cari, int left, int right) {
        int mid;
        if (right >= left) {
            mid = (left + right) / 2;
            if (cari == listMhs[mid].ipk) {
                return mid;
            } else if (listMhs[mid].ipk > cari) {
                return findBinarySearch(cari, left, mid - 1);
            } else {
                return findBinarySearch(cari, mid + 1, right);
            }
        }
        return -1;
    }
}
```

#### Class `MahasiswaDemo14` – Sequential Search

```java
import java.util.Scanner;

public class MahasiswaDemo14 {
    public static void main(String[] args) {
        MahasiswaBerprestasi14 list = new MahasiswaBerprestasi14();
        Scanner sc = new Scanner(System.in);
        int jumMhs = 5;

        for (int i = 0; i < jumMhs; i++) {
            System.out.println("Masukkan Data Mahasiswa ke-" + (i + 1));
            System.out.print("NIM   : ");
            String nim = sc.nextLine();
            System.out.print("Nama  : ");
            String nama = sc.nextLine();
            System.out.print("Kelas : ");
            String kelas = sc.nextLine();
            System.out.print("IPK   : ");
            String ip = sc.nextLine();
            Double ipk = Double.parseDouble(ip);
            System.out.println("------------------------------");
            list.tambah(new Mahasiswa14(nim, nama, kelas, ipk));
        }

        list.tampil();

        // Pencarian menggunakan Sequential Search
        System.out.println("------------------------------------------------");
        System.out.println("Pencarian data");
        System.out.println("------------------------------------------------");
        System.out.println("masukkan ipk mahasiswa yang dicari: ");
        System.out.print("IPK: ");
        double cari = sc.nextDouble();

        System.out.println("menggunakan sequential searching");
        double posisi = list.sequentialSearching(cari);
        int pss = (int) posisi;
        list.tampilPoisisi(cari, pss);
        list.tampilDataSearch(cari, pss);

        // Pencarian menggunakan Binary Search
        System.out.println("------------------------------------------------");
        System.out.println("Pencarian data");
        System.out.println("------------------------------------------------");
        System.out.println("masukkan ipk mahasiswa yang dicari: ");
        System.out.print("IPK: ");
        double cari2 = sc.nextDouble();
        System.out.println("------------------------------");
        System.out.println("menggunakan binary search");
        System.out.println("------------------------------");
        double posisi2 = list.findBinarySearch(cari2, 0, jumMhs - 1);
        int pss2 = (int) posisi2;
        list.tampilPoisisi(cari2, pss2);
        list.tampilDataSearch(cari2, pss2);
    }
}
```

### 6.2.2 Verifikasi Hasil Percobaan – Sequential Search

```
Masukkan Data Mahasiswa ke-1
NIM   : 111
Nama  : Rafi
Kelas : 2
IPK   : 3.6
------------------------------
Masukkan Data Mahasiswa ke-2
NIM   : 222
Nama  : Nur
Kelas : 2
IPK   : 3.8
------------------------------
Masukkan Data Mahasiswa ke-3
NIM   : 333
Nama  : Lia
Kelas : 2
IPK   : 3.0
------------------------------
Masukkan Data Mahasiswa ke-4
NIM   : 444
Nama  : Bagas
Kelas : 2
IPK   : 3.5
------------------------------
Masukkan Data Mahasiswa ke-5
NIM   : 555
Nama  : Radit
Kelas : 2
IPK   : 3.3
------------------------------
Nama: Rafi
NIM: 111
Kelas: 2
IPK: 3.6
---------------------------
Nama: Nur
NIM: 222
Kelas: 2
IPK: 3.8
---------------------------
Nama: Lia
NIM: 333
Kelas: 2
IPK: 3.0
---------------------------
Nama: Bagas
NIM: 444
Kelas: 2
IPK: 3.5
---------------------------
Nama: Radit
NIM: 555
Kelas: 2
IPK: 3.3
---------------------------
------------------------------------------------
Pencarian data
------------------------------------------------
masukkan ipk mahasiswa yang dicari:
IPK: 3.5
menggunakan sequential searching
data mahasiswa dengan IPK :3.5  ditemukan pada indeks 3
nim      : 444
nama     : Bagas
kelas    : 2
ipk      : 3.5
```

Output sesuai dengan hasil yang diharapkan pada jobsheet. ✅

---

### 6.2.3 Pertanyaan

**1. Jelaskan perbedaan method `tampilDataSearch` dan `tampilPosisi` pada class `MahasiswaBerprestasi`!**

- **`tampilPoisisi`** hanya menampilkan **keterangan posisi/indeks** tempat data ditemukan, atau pesan bahwa data tidak ditemukan. Output-nya singkat, seperti: *"data mahasiswa dengan IPK 3.5 ditemukan pada indeks 3"*.
- **`tampilDataSearch`** menampilkan **detail lengkap data mahasiswa** (nim, nama, kelas, ipk) yang ada di posisi hasil pencarian. Jika tidak ditemukan, menampilkan pesan tidak ditemukan.

Intinya: `tampilPoisisi` = info posisi saja, `tampilDataSearch` = detail datanya.

---

**2. Jelaskan fungsi `break` pada kode program berikut!**

```java
if (listMhs[j].ipk == cari) {
    posisi = j;
    break;
}
```

`break` berfungsi untuk **menghentikan loop** begitu data yang dicari sudah ditemukan. Tanpa `break`, loop akan terus berjalan hingga elemen terakhir meskipun data sudah ketemu, yang berarti membuang-buang waktu komputasi.

---

**3. Apa fungsi variabel `pos` atau indeks hasil pencarian dalam program sequential search?**

Variabel `pos` menyimpan **indeks (posisi)** elemen dalam array `listMhs` tempat data yang dicari ditemukan. Nilai ini kemudian digunakan oleh `tampilPoisisi` dan `tampilDataSearch` untuk mengakses dan menampilkan data di indeks tersebut. Jika data tidak ditemukan, `pos` bernilai `-1` sebagai penanda "tidak ada".

---

**4. Jika terdapat lebih dari satu data dengan nilai IPK yang sama, hasil pencarian sequential search akan menampilkan data ke berapa?**

Akan menampilkan **data yang pertama ditemukan** (indeks terkecil). Karena ada `break`, begitu elemen pertama yang cocok ditemukan, loop langsung berhenti dan `posisi` tidak diperbarui lagi. Jadi data duplikat berikutnya diabaikan.

---

**5. Apa yang terjadi jika perintah `break` dihapus?**

Loop akan terus berjalan sampai elemen terakhir. Jika ada data IPK yang sama lebih dari satu, variabel `posisi` akan terus diperbarui ke indeks yang lebih besar. Akibatnya program akan menampilkan **data terakhir** yang memiliki IPK sama, bukan yang pertama.

---

## 6.3 Searching – Algoritma Binary Search

### 6.3.1 Langkah-langkah Percobaan Binary Search

Method `findBinarySearch` sudah ditambahkan pada class `MahasiswaBerprestasi14` di atas. Binary search membutuhkan **data yang sudah terurut** (ASC) sebelum pencarian dilakukan.

Pemanggilan di `MahasiswaDemo14`:

```java
// Pencarian menggunakan Binary Search
System.out.println("masukkan ipk mahasiswa yang dicari: ");
System.out.print("IPK: ");
double cari2 = sc.nextDouble();
System.out.println("------------------------------");
System.out.println("menggunakan binary search");
System.out.println("------------------------------");
double posisi2 = list.findBinarySearch(cari2, 0, jumMhs - 1);
int pss2 = (int) posisi2;
list.tampilPoisisi(cari2, pss2);
list.tampilDataSearch(cari2, pss2);
```

### 6.3.2 Verifikasi Hasil Percobaan – Binary Search

Data diinput secara terurut ASC berdasarkan IPK:

```
Masukkan Data Mahasiswa ke-1
NIM   : 111
Nama  : Rafi
Kelas : 2
IPK   : 3.1
------------------------------
Masukkan Data Mahasiswa ke-2
NIM   : 222
Nama  : Nur
Kelas : 2
IPK   : 3.2
------------------------------
Masukkan Data Mahasiswa ke-3
NIM   : 333
Nama  : Lia
Kelas : 2
IPK   : 3.3
------------------------------
Masukkan Data Mahasiswa ke-4
NIM   : 444
Nama  : Bagas
Kelas : 2
IPK   : 3.5
------------------------------
Masukkan Data Mahasiswa ke-5
NIM   : 555
Nama  : Radit
Kelas : 2
IPK   : 3.7
------------------------------
Nama: Rafi
NIM: 111
Kelas: 2
IPK: 3.1
---------------------------
Nama: Nur
NIM: 222
Kelas: 2
IPK: 3.2
---------------------------
Nama: Lia
NIM: 333
Kelas: 2
IPK: 3.3
---------------------------
Nama: Bagas
NIM: 444
Kelas: 2
IPK: 3.5
---------------------------
Nama: Radit
NIM: 555
Kelas: 2
IPK: 3.7
---------------------------
------------------------------------------------
Pencarian data
------------------------------------------------
masukkan ipk mahasiswa yang dicari:
IPK: 3.7
------------------------------
menggunakan binary search
------------------------------
data mahasiswa dengan IPK :3.7  ditemukan pada indeks 4
nim      : 555
nama     : Radit
kelas    : 2
ipk      : 3.7
```

Output sesuai dengan hasil yang diharapkan pada jobsheet. ✅

---

### 6.3.3 Pertanyaan

**1. Tunjukkan pada kode program yang mana proses *divide* dijalankan!**

```java
mid = (left + right) / 2;
```

Baris ini adalah proses **divide** — membagi rentang pencarian menjadi dua bagian dengan menghitung indeks tengah (`mid`). Hasil pembagian ini digunakan untuk menentukan ke bagian mana pencarian akan dilanjutkan.

---

**2. Tunjukkan pada kode program yang mana proses *conquer* dijalankan!**

```java
else if (listMhs[mid].ipk > cari) {
    return findBinarySearch(cari, left, mid - 1);  // cari di bagian kiri
} else {
    return findBinarySearch(cari, mid + 1, right); // cari di bagian kanan
}
```

Inilah proses **conquer** — memanggil dirinya sendiri secara rekursif hanya pada **setengah bagian** yang relevan (kiri atau kanan), sehingga masalah terus mengecil hingga data ditemukan atau `right < left`.

---

**3. Apa fungsi `left`, `right`, dan `mid`?**

- **`left`** → batas indeks kiri (awal) dari rentang pencarian saat ini
- **`right`** → batas indeks kanan (akhir) dari rentang pencarian saat ini
- **`mid`** → indeks tengah yang dihitung dari `(left + right) / 2`, digunakan sebagai titik pembanding. Jika elemen di `mid` bukan yang dicari, pencarian dilanjutkan ke kiri (`mid-1`) atau kanan (`mid+1`)

---

**4. Jika data IPK yang dimasukkan tidak urut, apakah program masih bisa berjalan?**

Program tetap bisa **berjalan tanpa error**, tetapi **hasilnya bisa salah**. Binary search mengasumsikan data sudah terurut — jika data acak, algoritma bisa "membuang" setengah array yang sebenarnya mengandung data yang dicari, sehingga data ada tapi dikembalikan sebagai "tidak ditemukan" (`-1`).

---

**5. Jika IPK dimasukkan DESC (3.8, 3.7, 3.5, 3.4, 3.2) dan yang dicari 3.2, apakah hasilnya sesuai?**

**Tidak sesuai.** Binary search standar mengasumsikan data ASC. Jika data DESC dan mencari 3.2 (nilai terkecil), algoritma akan terus mengarah ke kiri yang ternyata berisi nilai lebih besar, akhirnya mengembalikan `-1` (tidak ditemukan) padahal data ada.

**Solusi:** Balik kondisi perbandingan pada binary search agar cocok untuk data DESC:

```java
int findBinarySearchDesc(double cari, int left, int right) {
    int mid;
    if (right >= left) {
        mid = (left + right) / 2;
        if (cari == listMhs[mid].ipk) {
            return mid;
        } else if (listMhs[mid].ipk < cari) {
            // data DESC: nilai lebih besar ada di kiri
            return findBinarySearchDesc(cari, left, mid - 1);
        } else {
            return findBinarySearchDesc(cari, mid + 1, right);
        }
    }
    return -1;
}
```

Perubahan kunci: `listMhs[mid].ipk > cari` diubah menjadi `listMhs[mid].ipk < cari` karena arah urutan terbalik.

---

**6. Bagaimana binary search menentukan bahwa data tidak ditemukan?**

Binary search mengembalikan `-1` ketika kondisi `right >= left` tidak lagi terpenuhi, yaitu saat `right < left`. Kondisi ini berarti rentang pencarian sudah habis (tidak ada elemen tersisa untuk diperiksa) dan data yang dicari tidak ada di dalam array. Ini adalah **base case** dari rekursi yang menandakan kegagalan pencarian.

---

**7. Modifikasi program agar jumlah mahasiswa yang diinputkan sesuai masukan dari keyboard.**

```java
import java.util.Scanner;

public class MahasiswaDemo14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumMhs = Integer.parseInt(sc.nextLine());

        // Sesuaikan ukuran array dengan input user
        MahasiswaBerprestasi14 list = new MahasiswaBerprestasi14();
        list.listMhs = new Mahasiswa14[jumMhs]; // override ukuran array

        for (int i = 0; i < jumMhs; i++) {
            System.out.println("Masukkan Data Mahasiswa ke-" + (i + 1));
            System.out.print("NIM   : ");
            String nim = sc.nextLine();
            System.out.print("Nama  : ");
            String nama = sc.nextLine();
            System.out.print("Kelas : ");
            String kelas = sc.nextLine();
            System.out.print("IPK   : ");
            String ip = sc.nextLine();
            Double ipk = Double.parseDouble(ip);
            System.out.println("------------------------------");
            list.tambah(new Mahasiswa14(nim, nama, kelas, ipk));
        }

        list.tampil();

        // Sequential Search
        System.out.println("------------------------------------------------");
        System.out.println("Pencarian data");
        System.out.println("------------------------------------------------");
        System.out.println("masukkan ipk mahasiswa yang dicari: ");
        System.out.print("IPK: ");
        double cari = sc.nextDouble();

        System.out.println("menggunakan sequential searching");
        int pss = list.sequentialSearching(cari);
        list.tampilPoisisi(cari, pss);
        list.tampilDataSearch(cari, pss);

        // Binary Search (pastikan data sudah diinput secara ASC)
        System.out.println("------------------------------------------------");
        System.out.println("Pencarian data");
        System.out.println("------------------------------------------------");
        System.out.println("masukkan ipk mahasiswa yang dicari: ");
        System.out.print("IPK: ");
        double cari2 = sc.nextDouble();
        System.out.println("------------------------------");
        System.out.println("menggunakan binary search");
        System.out.println("------------------------------");
        int pss2 = list.findBinarySearch(cari2, 0, jumMhs - 1);
        list.tampilPoisisi(cari2, pss2);
        list.tampilDataSearch(cari2, pss2);
    }
}
```

Contoh output dengan `jumMhs` dinamis:

```
Masukkan jumlah mahasiswa: 3
Masukkan Data Mahasiswa ke-1
NIM   : 111
Nama  : Rafi
Kelas : 2A
IPK   : 3.1
------------------------------
Masukkan Data Mahasiswa ke-2
NIM   : 222
Nama  : Nur
Kelas : 2A
IPK   : 3.5
------------------------------
Masukkan Data Mahasiswa ke-3
NIM   : 333
Nama  : Lia
Kelas : 2A
IPK   : 3.8
------------------------------
...
masukkan ipk mahasiswa yang dicari:
IPK: 3.5
menggunakan sequential searching
data mahasiswa dengan IPK :3.5  ditemukan pada indeks 1
nim      : 222
nama     : Nur
kelas    : 2A
ipk      : 3.5
------------------------------
masukkan ipk mahasiswa yang dicari:
IPK: 3.8
menggunakan binary search
------------------------------
data mahasiswa dengan IPK :3.8  ditemukan pada indeks 2
nim      : 333
nama     : Lia
kelas    : 2A
ipk      : 3.8
```

Output sesuai dengan hasil yang diharapkan pada jobsheet. ✅

---

## Kesimpulan

1. **Sequential Search** memeriksa setiap elemen array satu per satu dari awal hingga data ditemukan atau seluruh array habis diperiksa. Tidak butuh data terurut, tetapi kurang efisien untuk data besar — kompleksitas waktu **O(n)**.

2. **Binary Search** membagi rentang pencarian menjadi dua di setiap langkah rekursif. Jauh lebih cepat dengan kompleksitas **O(log n)**, tetapi **wajib menggunakan data yang sudah terurut** sebagai syarat utama.

3. Variabel `posisi` / `pos` bernilai `-1` sebagai penanda data tidak ditemukan, dan digunakan oleh method tampil untuk memilih pesan yang sesuai (ditemukan atau tidak).

4. Perintah `break` pada sequential search penting untuk efisiensi — menghentikan loop saat data pertama yang cocok ditemukan, sehingga tidak meneruskan pencarian yang tidak perlu.

5. Untuk mengubah arah binary search dari ASC ke DESC, cukup membalik operator perbandingan pada kondisi rekursi (`>` menjadi `<`), karena arah urutan data memengaruhi ke mana pencarian diarahkan.
