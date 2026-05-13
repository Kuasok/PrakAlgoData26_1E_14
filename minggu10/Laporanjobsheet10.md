# LAPORAN JOBSHEET 10 – QUEUE

**Nama:** Muhammad Ferdi Afiyanto
**NIM:** 254107020122
**Absen:** 14
**Kelas:** TI-1E

---

## 1. Tujuan Praktikum

Setelah melakukan materi praktikum ini, mahasiswa mampu:
1. Mengenal struktur data Queue
2. Membuat dan mendeklarasikan struktur data Queue
3. Menerapkan algoritma Queue dengan menggunakan array

---

## 2. Percobaan 1 – Operasi Dasar Queue

### 2.1 Langkah-langkah Percobaan

Percobaan ini menerapkan operasi dasar pada algoritma Queue menggunakan array berbasis circular. Queue menganut prinsip **FIFO (First In, First Out)** — data yang pertama masuk adalah data yang pertama keluar.

---

### 2.1.1 Kode Class `Queue14`

```java
public class Queue14 {
    int[] data14;
    int front14;
    int rear14;
    int size14;
    int max14;

    public Queue14(int n14) {
        max14 = n14;
        data14 = new int[max14];
        size14 = 0;
        front14 = rear14 = -1;
    }

    public boolean IsEmpty() {
        if (size14 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean IsFull() {
        if (size14 == max14) {
            return true;
        } else {
            return false;
        }
    }

    public void peek() {
        if (!IsEmpty()) {
            System.out.println("Elemen terdepan: " + data14[front14]);
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void print() {
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            int i14 = front14;
            while (i14 != rear14) {
                System.out.print(data14[i14] + " ");
                i14 = (i14 + 1) % max14;
            }
            System.out.println(data14[i14] + " ");
            System.out.println("Jumlah elemen = " + size14);
        }
    }

    public void clear() {
        if (!IsEmpty()) {
            front14 = rear14 = -1;
            size14 = 0;
            System.out.println("Queue berhasil dikosongkan");
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void Enqueue(int dt14) {
        if (IsFull()) {
            System.out.println("Queue sudah penuh");
        } else {
            if (IsEmpty()) {
                front14 = rear14 = 0;
            } else {
                if (rear14 == max14 - 1) {
                    rear14 = 0;
                } else {
                    rear14++;
                }
            }
            data14[rear14] = dt14;
            size14++;
        }
    }

    public int Dequeue() {
        int dt14 = 0;
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            dt14 = data14[front14];
            size14--;
            if (IsEmpty()) {
                front14 = rear14 = -1;
            } else {
                if (front14 == max14 - 1) {
                    front14 = 0;
                } else {
                    front14++;
                }
            }
        }
        return dt14;
    }
}
```

---

### 2.1.2 Kode Class `QueueMain14`

```java
import java.util.Scanner;

public class QueueMain14 {
    public static void menu() {
        System.out.println("Masukkan operasi yang diinginkan:");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Print");
        System.out.println("4. Peek");
        System.out.println("5. Clear");
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        Scanner ferdi = new Scanner(System.in);

        System.out.print("Masukkan kapasitas queue: ");
        int n14 = ferdi.nextInt();

        Queue14 Q14 = new Queue14(n14);

        int pilih14;
        do {
            menu();
            pilih14 = ferdi.nextInt();
            switch (pilih14) {
                case 1:
                    System.out.print("Masukkan data baru: ");
                    int dataMasuk14 = ferdi.nextInt();
                    Q14.Enqueue(dataMasuk14);
                    break;
                case 2:
                    int dataKeluar14 = Q14.Dequeue();
                    if (dataKeluar14 != 0) {
                        System.out.println("Data yang dikeluarkan: " + dataKeluar14);
                    }
                    break;
                case 3:
                    Q14.print();
                    break;
                case 4:
                    Q14.peek();
                    break;
                case 5:
                    Q14.clear();
                    break;
            }
        } while (pilih14 == 1 || pilih14 == 2 || pilih14 == 3 || pilih14 == 4 || pilih14 == 5);
    }
}
```

---

### 2.2 Verifikasi Hasil Percobaan 1

```
Masukkan kapasitas queue: 5
Masukkan operasi yang diinginkan:
1. Enqueue
2. Dequeue
3. Print
4. Peek
5. Clear
--------------------
Pilih: 1
Masukkan data baru: 10

Masukkan operasi yang diinginkan:
1. Enqueue
2. Dequeue
3. Print
4. Peek
5. Clear
--------------------
Pilih: 1
Masukkan data baru: 20

Masukkan operasi yang diinginkan:
1. Enqueue
2. Dequeue
3. Print
4. Peek
5. Clear
--------------------
Pilih: 1
Masukkan data baru: 30

Masukkan operasi yang diinginkan:
1. Enqueue
2. Dequeue
3. Print
4. Peek
5. Clear
--------------------
Pilih: 4
Elemen terdepan: 10

Masukkan operasi yang diinginkan:
1. Enqueue
2. Dequeue
3. Print
4. Peek
5. Clear
--------------------
Pilih: 3
10 20 30 
Jumlah elemen = 3

Masukkan operasi yang diinginkan:
1. Enqueue
2. Dequeue
3. Print
4. Peek
5. Clear
--------------------
Pilih: 2
Data yang dikeluarkan: 10

Masukkan operasi yang diinginkan:
1. Enqueue
2. Dequeue
3. Print
4. Peek
5. Clear
--------------------
Pilih: 3
20 30 
Jumlah elemen = 2

Masukkan operasi yang diinginkan:
1. Enqueue
2. Dequeue
3. Print
4. Peek
5. Clear
--------------------
Pilih: 5
Queue berhasil dikosongkan
```

---

### 2.3 Jawaban Pertanyaan Percobaan 1

**1. Pada konstruktor, mengapa nilai awal atribut front dan rear bernilai -1, sementara atribut size bernilai 0?**

Nilai `front14` dan `rear14` diinisialisasi dengan `-1` untuk menandakan bahwa queue belum memiliki elemen sama sekali. Dalam implementasi circular array, indeks yang valid berkisar dari `0` hingga `max14 - 1`. Dengan mengatur `front14 = rear14 = -1`, kedua pointer tidak menunjuk ke indeks manapun dalam array karena belum ada data. Ketika elemen pertama kali di-enqueue, keduanya akan diatur ke `0`. Sementara itu, `size14` bernilai `0` karena merepresentasikan jumlah elemen yang ada di dalam queue, dan queue yang baru dibuat memang kosong.

---

**2. Pada method Enqueue, jelaskan maksud dan kegunaan dari potongan kode berikut!**

```java
if (rear14 == max14 - 1) {
    rear14 = 0;
} else {
    rear14++;
}
```

Potongan kode tersebut mengimplementasikan mekanisme **circular array** pada operasi Enqueue. Ketika pointer `rear14` sudah berada di indeks terakhir array (`max14 - 1`) dan masih ada ruang kosong di bagian awal array (karena beberapa elemen sudah di-dequeue), maka `rear14` di-reset ke `0` agar dapat mengisi kembali posisi kosong di awal array. Jika `rear14` belum di indeks terakhir, maka cukup ditambah satu (`rear14++`). Tanpa mekanisme ini, queue akan dianggap penuh meskipun masih ada ruang kosong di awal array.

---

**3. Pada method Dequeue, jelaskan maksud dan kegunaan dari potongan kode berikut!**

```java
if (front14 == max14 - 1) {
    front14 = 0;
} else {
    front14++;
}
```

Potongan kode ini menerapkan mekanisme **circular array** pada operasi Dequeue. Ketika pointer `front14` sudah berada di indeks terakhir (`max14 - 1`) dan masih ada elemen tersisa di awal array, maka `front14` di-reset ke `0` untuk menunjuk elemen berikutnya. Jika belum di indeks terakhir, `front14` ditambah satu. Mekanisme ini memastikan `front14` selalu menunjuk elemen terdepan yang valid terlepas dari posisi fisiknya dalam array.

---

**4. Pada method print, mengapa pada proses perulangan variabel i tidak dimulai dari 0 (int i=0), melainkan int i=front?**

Variabel `i` dimulai dari `front14` karena `front14` menunjukkan indeks elemen pertama (terdepan) dalam queue. Dalam circular array, elemen pertama tidak selalu berada di indeks `0` — posisinya bisa di mana saja tergantung dari berapa kali Dequeue telah dilakukan. Jika iterasi dimulai dari indeks `0`, kita akan mencetak elemen yang bukan bagian dari queue atau sudah tidak valid. Memulai dari `i = front14` memastikan iterasi dimulai dari elemen terdepan yang valid.

---

**5. Perhatikan kembali method print, jelaskan maksud dari potongan kode berikut!**

```java
i14 = (i14 + 1) % max14;
```

Kode ini mengimplementasikan perpindahan indeks secara **melingkar (circular)**. Operator `%` (modulo) memastikan ketika `i14` mencapai indeks `max14 - 1` dan ditambah satu, hasilnya kembali ke `0` bukan ke `max14`. Misalnya `(max14 - 1 + 1) % max14 = 0`. Dalam method `print`, kode ini memungkinkan traversal seluruh elemen queue dari `front14` hingga `rear14` meskipun posisi keduanya tidak berurutan secara linear dalam array.

---

**6. Tunjukkan potongan kode program yang merupakan queue overflow!**

Queue overflow terjadi saat Enqueue dipanggil namun queue sudah penuh:

```java
if (IsFull()) {
    System.out.println("Queue sudah penuh");
}
```

Kode ini berada di dalam method `Enqueue`. Ketika `IsFull()` mengembalikan `true` (artinya `size14 == max14`), program mencetak pesan dan tidak melakukan penambahan data. Ini merupakan kondisi **queue overflow**.

---

**7. Modifikasi program sehingga pada saat terjadi queue overflow dan queue underflow, program dihentikan!**

Method `Enqueue` setelah dimodifikasi:

```java
public void Enqueue(int dt14) {
    if (IsFull()) {
        System.out.println("Queue sudah penuh");
        System.exit(0);
    } else {
        if (IsEmpty()) {
            front14 = rear14 = 0;
        } else {
            if (rear14 == max14 - 1) {
                rear14 = 0;
            } else {
                rear14++;
            }
        }
        data14[rear14] = dt14;
        size14++;
    }
}
```

Method `Dequeue` setelah dimodifikasi:

```java
public int Dequeue() {
    int dt14 = 0;
    if (IsEmpty()) {
        System.out.println("Queue masih kosong");
        System.exit(0);
    } else {
        dt14 = data14[front14];
        size14--;
        if (IsEmpty()) {
            front14 = rear14 = -1;
        } else {
            if (front14 == max14 - 1) {
                front14 = 0;
            } else {
                front14++;
            }
        }
    }
    return dt14;
}
```

`System.exit(0)` menghentikan JVM secara langsung saat terjadi overflow atau underflow.

---

## 3. Percobaan 2 – Antrian Layanan Akademik

### 3.1 Langkah-langkah Percobaan

Percobaan ini mengilustrasikan layanan Admin Akademik menggunakan Queue of Object. Data yang disimpan berupa object `Mahasiswa14`, sehingga class Queue dimodifikasi menjadi `AntrianLayanan14`.

---

### 3.1.1 Kode Class `Mahasiswa14`

```java
public class Mahasiswa14 {
    String nim14;
    String nama14;
    String prodi14;
    String kelas14;

    public Mahasiswa14(String nim14, String nama14, String prodi14, String kelas14) {
        this.nim14 = nim14;
        this.nama14 = nama14;
        this.prodi14 = prodi14;
        this.kelas14 = kelas14;
    }

    public void tampilkanData() {
        System.out.println(nim14 + " - " + nama14 + " - " + prodi14 + " - " + kelas14);
    }
}
```

---

### 3.1.2 Kode Class `AntrianLayanan14`

```java
public class AntrianLayanan14 {
    Mahasiswa14[] data14;
    int front14;
    int rear14;
    int size14;
    int max14;

    public AntrianLayanan14(int max14) {
        this.max14 = max14;
        this.data14 = new Mahasiswa14[max14];
        this.front14 = 0;
        this.rear14 = -1;
        this.size14 = 0;
    }

    public boolean isEmpty() {
        if (size14 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (size14 == max14) {
            return true;
        } else {
            return false;
        }
    }

    public void tambahAntrian(Mahasiswa14 mhs14) {
        if (isFull()) {
            System.out.println("Antrian penuh, tidak dapat menambah mahasiswa.");
            return;
        }
        rear14 = (rear14 + 1) % max14;
        data14[rear14] = mhs14;
        size14++;
        System.out.println(mhs14.nama14 + " berhasil masuk ke antrian.");
    }

    public Mahasiswa14 layaniMahasiswa() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return null;
        }
        Mahasiswa14 mhs14 = data14[front14];
        front14 = (front14 + 1) % max14;
        size14--;
        return mhs14;
    }

    public void lihatTerdepan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.print("Mahasiswa terdepan: ");
            System.out.println("NIM - NAMA - PRODI - KELAS");
            data14[front14].tampilkanData();
        }
    }

    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Daftar Mahasiswa dalam Antrian:");
        System.out.println("NIM - NAMA - PRODI - KELAS");
        for (int i14 = 0; i14 < size14; i14++) {
            int index14 = (front14 + i14) % max14;
            System.out.print((i14 + 1) + ". ");
            data14[index14].tampilkanData();
        }
    }

    public int getJumlahAntrian() {
        return size14;
    }
}
```

---

### 3.1.3 Kode Class `LayananAkademikSIAKAD14`

```java
import java.util.Scanner;

public class LayananAkademikSIAKAD14 {
    public static void main(String[] args) {
        Scanner ferdi = new Scanner(System.in);
        AntrianLayanan14 antrian14 = new AntrianLayanan14(5);
        int pilihan14;

        do {
            System.out.println("\n=== Menu Antrian Layanan Akademik ===");
            System.out.println("1. Tambah Mahasiswa ke Antrian");
            System.out.println("2. Layani Mahasiswa");
            System.out.println("3. Lihat Mahasiswa Terdepan");
            System.out.println("4. Lihat Semua Antrian");
            System.out.println("5. Jumlah Mahasiswa dalam Antrian");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan14 = ferdi.nextInt();
            ferdi.nextLine();

            switch (pilihan14) {
                case 1:
                    System.out.print("NIM  : ");
                    String nim14 = ferdi.nextLine();
                    System.out.print("Nama : ");
                    String nama14 = ferdi.nextLine();
                    System.out.print("Prodi : ");
                    String prodi14 = ferdi.nextLine();
                    System.out.print("Kelas : ");
                    String kelas14 = ferdi.nextLine();
                    Mahasiswa14 mhs14 = new Mahasiswa14(nim14, nama14, prodi14, kelas14);
                    antrian14.tambahAntrian(mhs14);
                    break;
                case 2:
                    Mahasiswa14 dilayani14 = antrian14.layaniMahasiswa();
                    if (dilayani14 != null) {
                        System.out.print("Melayani mahasiswa: ");
                        dilayani14.tampilkanData();
                    }
                    break;
                case 3:
                    antrian14.lihatTerdepan();
                    break;
                case 4:
                    antrian14.tampilkanSemua();
                    break;
                case 5:
                    System.out.println("Jumlah dalam antrian: " + antrian14.getJumlahAntrian());
                    break;
                case 0:
                    System.out.println("Terima kasih.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan14 != 0);
    }
}
```

---

### 3.2 Verifikasi Hasil Percobaan 2

```
=== Menu Antrian Layanan Akademik ===
1. Tambah Mahasiswa ke Antrian
2. Layani Mahasiswa
3. Lihat Mahasiswa Terdepan
4. Lihat Semua Antrian
5. Jumlah Mahasiswa dalam Antrian
0. Keluar
Pilih menu: 1
NIM  : 123
Nama : Aldi
Prodi : TI
Kelas : 1A
Aldi berhasil masuk ke antrian.

=== Menu Antrian Layanan Akademik ===
1. Tambah Mahasiswa ke Antrian
2. Layani Mahasiswa
3. Lihat Mahasiswa Terdepan
4. Lihat Semua Antrian
5. Jumlah Mahasiswa dalam Antrian
0. Keluar
Pilih menu: 1
NIM  : 124
Nama : Bobi
Prodi : TI
Kelas : 1G
Bobi berhasil masuk ke antrian.

=== Menu Antrian Layanan Akademik ===
1. Tambah Mahasiswa ke Antrian
2. Layani Mahasiswa
3. Lihat Mahasiswa Terdepan
4. Lihat Semua Antrian
5. Jumlah Mahasiswa dalam Antrian
0. Keluar
Pilih menu: 4
Daftar Mahasiswa dalam Antrian:
NIM - NAMA - PRODI - KELAS
1. 123 - Aldi - TI - 1A
2. 124 - Bobi - TI - 1G

=== Menu Antrian Layanan Akademik ===
1. Tambah Mahasiswa ke Antrian
2. Layani Mahasiswa
3. Lihat Mahasiswa Terdepan
4. Lihat Semua Antrian
5. Jumlah Mahasiswa dalam Antrian
0. Keluar
Pilih menu: 2
Melayani mahasiswa: 123 - Aldi - TI - 1A

=== Menu Antrian Layanan Akademik ===
1. Tambah Mahasiswa ke Antrian
2. Layani Mahasiswa
3. Lihat Mahasiswa Terdepan
4. Lihat Semua Antrian
5. Jumlah Mahasiswa dalam Antrian
0. Keluar
Pilih menu: 4
Daftar Mahasiswa dalam Antrian:
NIM - NAMA - PRODI - KELAS
1. 124 - Bobi - TI - 1G
```

---

### 3.3 Jawaban Pertanyaan Percobaan 2

**Lakukan modifikasi program dengan menambahkan method baru bernama LihatAkhir pada class AntrianLayanan14 yang digunakan untuk mengecek antrian yang berada di posisi belakang. Tambahkan pula daftar menu 6. Cek Antrian paling belakang pada class LayananAkademikSIAKAD14!**

Method `lihatAkhir()` pada class `AntrianLayanan14`:

```java
public void lihatAkhir() {
    if (isEmpty()) {
        System.out.println("Antrian kosong.");
    } else {
        System.out.print("Mahasiswa paling belakang: ");
        System.out.println("NIM - NAMA - PRODI - KELAS");
        data14[rear14].tampilkanData();
    }
}
```

Penambahan menu pada class `LayananAkademikSIAKAD14`:

```java
// Tambahkan di daftar menu:
System.out.println("6. Cek Antrian paling belakang");

// Tambahkan case 6 dalam switch:
case 6:
    antrian14.lihatAkhir();
    break;
```

Contoh output:

```
=== Menu Antrian Layanan Akademik ===
1. Tambah Mahasiswa ke Antrian
2. Layani Mahasiswa
3. Lihat Mahasiswa Terdepan
4. Lihat Semua Antrian
5. Jumlah Mahasiswa dalam Antrian
6. Cek Antrian paling belakang
0. Keluar
Pilih menu: 6
Mahasiswa paling belakang: NIM - NAMA - PRODI - KELAS
124 - Bobi - TI - 1G
```

---

## 4. Tugas Praktikum – Antrian Persetujuan KRS

### Deskripsi

Program antrian persetujuan Kartu Rencana Studi (KRS) oleh Dosen Pembina Akademik (DPA). Setiap 1x panggilan proses KRS terdiri dari 2 mahasiswa (antrian no 1 dan 2). Jumlah antrian maksimal 10, jumlah yang ditangani masing-masing DPA 30 mahasiswa.

---

### 4.1 Kode Class `MahasiswaKRS14` (Tugas)

> **Catatan:** Class ini diberi nama `MahasiswaKRS14` (bukan `Mahasiswa14`) agar tidak bertabrakan dengan class `Mahasiswa14` pada Percobaan 2, karena semua file berada dalam satu folder.

```java
public class MahasiswaKRS14 {
    String nim14;
    String nama14;
    String prodi14;
    String kelas14;

    public MahasiswaKRS14(String nim14, String nama14, String prodi14, String kelas14) {
        this.nim14 = nim14;
        this.nama14 = nama14;
        this.prodi14 = prodi14;
        this.kelas14 = kelas14;
    }

    public void tampilkanData() {
        System.out.println(nim14 + " - " + nama14 + " - " + prodi14 + " - " + kelas14);
    }
}
```

---

### 4.2 Kode Class `AntrianKRS14`

```java
public class AntrianKRS14 {
    MahasiswaKRS14[] data14;
    int front14;
    int rear14;
    int size14;
    int max14;
    int sudahKRS14;

    public AntrianKRS14(int max14) {
        this.max14 = max14;
        this.data14 = new MahasiswaKRS14[max14];
        this.front14 = 0;
        this.rear14 = -1;
        this.size14 = 0;
        this.sudahKRS14 = 0;
    }

    public boolean isEmpty() {
        if (size14 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (size14 == max14) {
            return true;
        } else {
            return false;
        }
    }

    public void clear() {
        if (!isEmpty()) {
            front14 = 0;
            rear14 = -1;
            size14 = 0;
            System.out.println("Antrian berhasil dikosongkan");
        } else {
            System.out.println("Antrian masih kosong");
        }
    }

    public void tambahAntrian(MahasiswaKRS14 mhs14) {
        if (isFull()) {
            System.out.println("Antrian penuh, tidak dapat menambah mahasiswa.");
            return;
        }
        rear14 = (rear14 + 1) % max14;
        data14[rear14] = mhs14;
        size14++;
        System.out.println(mhs14.nama14 + " berhasil masuk ke antrian.");
    }

    public MahasiswaKRS14[] prosesKRS() {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada mahasiswa untuk diproses.");
            return null;
        }
        int jumlahProses14 = Math.min(2, size14);
        MahasiswaKRS14[] diproses14 = new MahasiswaKRS14[jumlahProses14];
        System.out.println("Memproses KRS untuk " + jumlahProses14 + " mahasiswa:");
        for (int i14 = 0; i14 < jumlahProses14; i14++) {
            diproses14[i14] = data14[front14];
            front14 = (front14 + 1) % max14;
            size14--;
            sudahKRS14++;
            System.out.print((i14 + 1) + ". ");
            diproses14[i14].tampilkanData();
        }
        return diproses14;
    }

    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Daftar Mahasiswa dalam Antrian KRS:");
        System.out.println("NIM - NAMA - PRODI - KELAS");
        for (int i14 = 0; i14 < size14; i14++) {
            int index14 = (front14 + i14) % max14;
            System.out.print((i14 + 1) + ". ");
            data14[index14].tampilkanData();
        }
    }

    public void lihat2Terdepan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("2 Mahasiswa terdepan dalam antrian:");
        System.out.println("NIM - NAMA - PRODI - KELAS");
        int jumlah14 = Math.min(2, size14);
        for (int i14 = 0; i14 < jumlah14; i14++) {
            int index14 = (front14 + i14) % max14;
            System.out.print((i14 + 1) + ". ");
            data14[index14].tampilkanData();
        }
    }

    public void lihatAkhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.print("Mahasiswa paling akhir: ");
            System.out.println("NIM - NAMA - PRODI - KELAS");
            data14[rear14].tampilkanData();
        }
    }

    public int getJumlahAntrian() {
        return size14;
    }

    public int getSudahKRS() {
        return sudahKRS14;
    }

    public int getBelumKRS() {
        return 30 - sudahKRS14;
    }
}
```

---

### 4.3 Kode Class `AntrianKRSDemo14`

```java
import java.util.Scanner;

public class AntrianKRSDemo14 {
    public static void main(String[] args) {
        Scanner ferdi = new Scanner(System.in);
        AntrianKRS14 antrian14 = new AntrianKRS14(10);
        int pilihan14;

        do {
            System.out.println("\n=== Menu Antrian KRS ===");
            System.out.println("1. Tambah Mahasiswa ke Antrian");
            System.out.println("2. Proses KRS (2 mahasiswa)");
            System.out.println("3. Lihat Semua Antrian");
            System.out.println("4. Lihat 2 Antrian Terdepan");
            System.out.println("5. Lihat Antrian Paling Akhir");
            System.out.println("6. Cek Antrian Kosong");
            System.out.println("7. Cek Antrian Penuh");
            System.out.println("8. Kosongkan Antrian");
            System.out.println("9. Jumlah Mahasiswa dalam Antrian");
            System.out.println("10. Jumlah Sudah Proses KRS");
            System.out.println("11. Jumlah Belum Proses KRS");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan14 = ferdi.nextInt();
            ferdi.nextLine();

            switch (pilihan14) {
                case 1:
                    System.out.print("NIM  : ");
                    String nim14 = ferdi.nextLine();
                    System.out.print("Nama : ");
                    String nama14 = ferdi.nextLine();
                    System.out.print("Prodi : ");
                    String prodi14 = ferdi.nextLine();
                    System.out.print("Kelas : ");
                    String kelas14 = ferdi.nextLine();
                    MahasiswaKRS14 mhs14 = new MahasiswaKRS14(nim14, nama14, prodi14, kelas14);
                    antrian14.tambahAntrian(mhs14);
                    break;
                case 2:
                    antrian14.prosesKRS();
                    break;
                case 3:
                    antrian14.tampilkanSemua();
                    break;
                case 4:
                    antrian14.lihat2Terdepan();
                    break;
                case 5:
                    antrian14.lihatAkhir();
                    break;
                case 6:
                    if (antrian14.isEmpty()) {
                        System.out.println("Antrian kosong.");
                    } else {
                        System.out.println("Antrian tidak kosong. Ada " + antrian14.getJumlahAntrian() + " mahasiswa.");
                    }
                    break;
                case 7:
                    if (antrian14.isFull()) {
                        System.out.println("Antrian penuh.");
                    } else {
                        System.out.println("Antrian belum penuh. Sisa kapasitas: " + (10 - antrian14.getJumlahAntrian()));
                    }
                    break;
                case 8:
                    antrian14.clear();
                    break;
                case 9:
                    System.out.println("Jumlah mahasiswa dalam antrian: " + antrian14.getJumlahAntrian());
                    break;
                case 10:
                    System.out.println("Jumlah mahasiswa sudah proses KRS: " + antrian14.getSudahKRS());
                    break;
                case 11:
                    System.out.println("Jumlah mahasiswa belum proses KRS: " + antrian14.getBelumKRS());
                    break;
                case 0:
                    System.out.println("Terima kasih.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan14 != 0);
    }
}
```

---

### 4.4 Verifikasi Hasil Tugas

```
=== Menu Antrian KRS ===
1. Tambah Mahasiswa ke Antrian
2. Proses KRS (2 mahasiswa)
3. Lihat Semua Antrian
4. Lihat 2 Antrian Terdepan
5. Lihat Antrian Paling Akhir
6. Cek Antrian Kosong
7. Cek Antrian Penuh
8. Kosongkan Antrian
9. Jumlah Mahasiswa dalam Antrian
10. Jumlah Sudah Proses KRS
11. Jumlah Belum Proses KRS
0. Keluar
Pilih menu: 1
NIM  : 254107020101
Nama : Ahmad
Prodi : TI
Kelas : 1E
Ahmad berhasil masuk ke antrian.

=== Menu Antrian KRS ===
...
Pilih menu: 1
NIM  : 254107020102
Nama : Budi
Prodi : TI
Kelas : 1E
Budi berhasil masuk ke antrian.

=== Menu Antrian KRS ===
...
Pilih menu: 1
NIM  : 254107020103
Nama : Cici
Prodi : TI
Kelas : 1E
Cici berhasil masuk ke antrian.

=== Menu Antrian KRS ===
...
Pilih menu: 4
2 Mahasiswa terdepan dalam antrian:
NIM - NAMA - PRODI - KELAS
1. 254107020101 - Ahmad - TI - 1E
2. 254107020102 - Budi - TI - 1E

=== Menu Antrian KRS ===
...
Pilih menu: 5
Mahasiswa paling akhir: NIM - NAMA - PRODI - KELAS
254107020103 - Cici - TI - 1E

=== Menu Antrian KRS ===
...
Pilih menu: 2
Memproses KRS untuk 2 mahasiswa:
1. 254107020101 - Ahmad - TI - 1E
2. 254107020102 - Budi - TI - 1E

=== Menu Antrian KRS ===
...
Pilih menu: 3
Daftar Mahasiswa dalam Antrian KRS:
NIM - NAMA - PRODI - KELAS
1. 254107020103 - Cici - TI - 1E

=== Menu Antrian KRS ===
...
Pilih menu: 9
Jumlah mahasiswa dalam antrian: 1

=== Menu Antrian KRS ===
...
Pilih menu: 10
Jumlah mahasiswa sudah proses KRS: 2

=== Menu Antrian KRS ===
...
Pilih menu: 11
Jumlah mahasiswa belum proses KRS: 28
```

---
