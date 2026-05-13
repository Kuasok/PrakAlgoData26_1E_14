# LAPORAN JOBSHEET 11 – LINKED LIST

**Nama:** Muhammad Ferdi Afiyanto
**NIM:** 254107020122
**Kelas:** TI-1E

---

## 1. Tujuan Praktikum

Setelah melakukan materi praktikum ini, mahasiswa mampu:
1. Membuat struktur data linked list
2. Membuat linked list pada program
3. Membedakan permasalahan apa yang dapat diselesaikan menggunakan linked list

---

## 2. Percobaan 1 – Pembuatan Single Linked List

### 2.1 Langkah-langkah Percobaan

Percobaan ini menerapkan pembuatan Single Linked List dengan representasi data berupa Node. Single Linked List adalah struktur data linier yang setiap elemennya (node) menyimpan data dan referensi (pointer) ke node berikutnya. Akses terhadap linked list dilakukan melalui pointer `head14` yang menunjuk ke node pertama dan `tail14` yang menunjuk ke node terakhir.

---

### 2.1.1 Kode Class `Mahasiswa14`

```java
public class Mahasiswa14 {
    String nim14;
    String nama14;
    String kelas14;
    double ipk14;

    public Mahasiswa14() {

    }

    public Mahasiswa14(String nim14, String nama14, String kelas14, double ipk14) {
        this.nim14 = nim14;
        this.nama14 = nama14;
        this.kelas14 = kelas14;
        this.ipk14 = ipk14;
    }

    public void tampilInformasi() {
        System.out.println("NIM: " + nim14 + " | Nama: " + nama14 + " | Kelas: " + kelas14 + " | IPK: " + ipk14);
    }
}
```

---

### 2.1.2 Kode Class `Node14`

```java
public class Node14 {
    Mahasiswa14 data14;
    Node14 next14;

    public Node14(Mahasiswa14 data14, Node14 next14) {
        this.data14 = data14;
        this.next14 = next14;
    }
}
```

---

### 2.1.3 Kode Class `SingleLinkedList14` (Percobaan 1)

```java
public class SingleLinkedList14 {
    Node14 head14;
    Node14 tail14;

    public boolean isEmpty() {
        return head14 == null;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked List Kosong");
        } else {
            Node14 temp14 = head14;
            while (temp14 != null) {
                temp14.data14.tampilInformasi();
                temp14 = temp14.next14;
            }
        }
    }

    public void addFirst(Mahasiswa14 data14) {
        Node14 newNode14 = new Node14(data14, null);
        if (isEmpty()) {
            head14 = newNode14;
            tail14 = newNode14;
        } else {
            newNode14.next14 = head14;
            head14 = newNode14;
        }
    }

    public void addLast(Mahasiswa14 data14) {
        Node14 newNode14 = new Node14(data14, null);
        if (isEmpty()) {
            head14 = newNode14;
            tail14 = newNode14;
        } else {
            tail14.next14 = newNode14;
            tail14 = newNode14;
        }
    }

    public void insertAfter(Mahasiswa14 data14, String key14) {
        Node14 newNode14 = new Node14(data14, null);
        Node14 temp14 = head14;
        while (temp14 != null) {
            if (temp14.data14.nama14.equalsIgnoreCase(key14)) {
                newNode14.next14 = temp14.next14;
                temp14.next14 = newNode14;
                if (temp14 == tail14) {
                    tail14 = newNode14;
                }
                break;
            }
            temp14 = temp14.next14;
        }
    }

    public void addAtIndex(Mahasiswa14 data14, int index14) {
        if (index14 < 0) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        if (index14 == 0) {
            addFirst(data14);
            return;
        }
        Node14 newNode14 = new Node14(data14, null);
        Node14 temp14 = head14;
        for (int i14 = 0; i14 < index14 - 1; i14++) {
            if (temp14 == null) {
                System.out.println("Indeks melebihi panjang linked list.");
                return;
            }
            temp14 = temp14.next14;
        }
        if (temp14 == null) {
            System.out.println("Indeks melebihi panjang linked list.");
            return;
        }
        newNode14.next14 = temp14.next14;
        temp14.next14 = newNode14;
        if (temp14 == tail14) {
            tail14 = newNode14;
        }
    }
}
```

---

### 2.1.4 Kode Class `SLLMain14` (Percobaan 1)

```java
public class SLLMain14 {
    public static void main(String[] args) {
        SingleLinkedList14 sll14 = new SingleLinkedList14();

        sll14.print();

        Mahasiswa14 mhs1 = new Mahasiswa14("254107020111", "Anton", "TI-1E", 3.57);
        Mahasiswa14 mhs2 = new Mahasiswa14("254107020112", "Budi", "TI-1E", 3.78);
        Mahasiswa14 mhs3 = new Mahasiswa14("254107020113", "Citra", "TI-1E", 3.34);
        Mahasiswa14 mhs4 = new Mahasiswa14("254107020114", "Dewi", "TI-1E", 3.95);

        sll14.addFirst(mhs1);
        sll14.print();

        sll14.addLast(mhs2);
        sll14.print();

        sll14.insertAfter(mhs3, "Anton");
        sll14.print();

        sll14.addAtIndex(mhs4, 2);
        sll14.print();
    }
}
```

---

### 2.2 Verifikasi Hasil Percobaan 1

```
Linked List Kosong
NIM: 254107020111 | Nama: Anton | Kelas: TI-1E | IPK: 3.57
NIM: 254107020111 | Nama: Anton | Kelas: TI-1E | IPK: 3.57
NIM: 254107020112 | Nama: Budi | Kelas: TI-1E | IPK: 3.78
NIM: 254107020111 | Nama: Anton | Kelas: TI-1E | IPK: 3.57
NIM: 254107020113 | Nama: Citra | Kelas: TI-1E | IPK: 3.34
NIM: 254107020112 | Nama: Budi | Kelas: TI-1E | IPK: 3.78
NIM: 254107020111 | Nama: Anton | Kelas: TI-1E | IPK: 3.57
NIM: 254107020113 | Nama: Citra | Kelas: TI-1E | IPK: 3.34
NIM: 254107020114 | Nama: Dewi | Kelas: TI-1E | IPK: 3.95
NIM: 254107020112 | Nama: Budi | Kelas: TI-1E | IPK: 3.78
```

---

### 2.3 Jawaban Pertanyaan Percobaan 1

**1. Mengapa hasil compile kode program di baris pertama menghasilkan "Linked List Kosong"?**

Pada saat program pertama kali dijalankan, method `print()` dipanggil sebelum ada data yang ditambahkan ke dalam linked list. Pada kondisi awal, pointer `head14` masih bernilai `null` karena belum ada node yang terhubung. Method `isEmpty()` mengembalikan `true` ketika `head14 == null`, sehingga blok kondisi `isEmpty()` di dalam `print()` akan mencetak "Linked List Kosong". Ini menunjukkan bahwa linked list belum memiliki elemen sama sekali — belum ada operasi `addFirst()`, `addLast()`, atau penambahan lain yang dilakukan sebelum pemanggilan `print()` tersebut.

---

**2. Jelaskan kegunaan variable temp secara umum pada setiap method!**

Variabel `temp14` berfungsi sebagai **pointer penelusuran (traversal pointer)** yang digunakan untuk berpindah dari satu node ke node berikutnya tanpa mengubah posisi pointer `head14` dan `tail14`. Secara umum, kegunaan variabel `temp14` pada setiap method adalah sebagai berikut:

- **Pada method `print()`**: `temp14` dimulai dari `head14` dan berpindah ke `temp14.next14` secara bertahap untuk mencetak data setiap node dari awal hingga akhir. Jika `head14` langsung digunakan untuk traversal, maka pointer `head14` akan kehilangan referensi ke node pertama, sehingga seluruh linked list tidak dapat diakses lagi.

- **Pada method `insertAfter()`**: `temp14` digunakan untuk mencari node yang memiliki data sesuai `key14`. Setelah ditemukan, node baru disisipkan setelah node yang ditunjuk `temp14` dengan mengatur `newNode14.next14 = temp14.next14` dan `temp14.next14 = newNode14`.

- **Pada method `addAtIndex()`**: `temp14` digunakan untuk menelusuri linked list hingga mencapai node pada posisi `index14 - 1`, kemudian node baru disisipkan di antara `temp14` dan `temp14.next14`.

Dengan kata lain, `temp14` adalah variabel sementara yang menjaga keutuhan pointer `head14` dan `tail14` sehingga struktur linked list tetap dapat diakses setelah operasi traversal selesai.

---

**3. Lakukan modifikasi agar data dapat ditambahkan dari keyboard!**

Berikut adalah modifikasi class `SLLMain14` agar data mahasiswa dapat ditambahkan melalui input keyboard menggunakan `Scanner`:

```java
import java.util.Scanner;

public class SLLMain14 {
    public static void main(String[] args) {
        Scanner ferdi = new Scanner(System.in);
        SingleLinkedList14 sll14 = new SingleLinkedList14();
        int pilihan14;

        do {
            System.out.println("\n=== Menu Single Linked List ===");
            System.out.println("1. Add First");
            System.out.println("2. Add Last");
            System.out.println("3. Insert After");
            System.out.println("4. Add At Index");
            System.out.println("5. Print");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan14 = ferdi.nextInt();
            ferdi.nextLine();

            switch (pilihan14) {
                case 1:
                    System.out.print("NIM   : ");
                    String nim14 = ferdi.nextLine();
                    System.out.print("Nama  : ");
                    String nama14 = ferdi.nextLine();
                    System.out.print("Kelas : ");
                    String kelas14 = ferdi.nextLine();
                    System.out.print("IPK   : ");
                    double ipk14 = ferdi.nextDouble();
                    ferdi.nextLine();
                    Mahasiswa14 mhs14 = new Mahasiswa14(nim14, nama14, kelas14, ipk14);
                    sll14.addFirst(mhs14);
                    break;
                case 2:
                    System.out.print("NIM   : ");
                    nim14 = ferdi.nextLine();
                    System.out.print("Nama  : ");
                    nama14 = ferdi.nextLine();
                    System.out.print("Kelas : ");
                    kelas14 = ferdi.nextLine();
                    System.out.print("IPK   : ");
                    ipk14 = ferdi.nextDouble();
                    ferdi.nextLine();
                    mhs14 = new Mahasiswa14(nim14, nama14, kelas14, ipk14);
                    sll14.addLast(mhs14);
                    break;
                case 3:
                    System.out.print("NIM   : ");
                    nim14 = ferdi.nextLine();
                    System.out.print("Nama  : ");
                    nama14 = ferdi.nextLine();
                    System.out.print("Kelas : ");
                    kelas14 = ferdi.nextLine();
                    System.out.print("IPK   : ");
                    ipk14 = ferdi.nextDouble();
                    ferdi.nextLine();
                    mhs14 = new Mahasiswa14(nim14, nama14, kelas14, ipk14);
                    System.out.print("Masukkan key (nama setelah node ini disisipkan): ");
                    String key14 = ferdi.nextLine();
                    sll14.insertAfter(mhs14, key14);
                    break;
                case 4:
                    System.out.print("NIM   : ");
                    nim14 = ferdi.nextLine();
                    System.out.print("Nama  : ");
                    nama14 = ferdi.nextLine();
                    System.out.print("Kelas : ");
                    kelas14 = ferdi.nextLine();
                    System.out.print("IPK   : ");
                    ipk14 = ferdi.nextDouble();
                    ferdi.nextLine();
                    mhs14 = new Mahasiswa14(nim14, nama14, kelas14, ipk14);
                    System.out.print("Masukkan indeks: ");
                    int index14 = ferdi.nextInt();
                    ferdi.nextLine();
                    sll14.addAtIndex(mhs14, index14);
                    break;
                case 5:
                    sll14.print();
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

## 3. Percobaan 2 – Modifikasi Elemen pada Single Linked List

### 3.1 Langkah-langkah Percobaan

Percobaan ini menambahkan method-method untuk mengakses elemen, mendapatkan indeks, dan melakukan penghapusan data pada Single Linked List. Method-method ini melengkapi class `SingleLinkedList14` yang sudah dibuat pada Percobaan 1.

---

### 3.1.1 Kode Class `SingleLinkedList14` (Percobaan 2 – Lengkap)

```java
public class SingleLinkedList14 {
    Node14 head14;
    Node14 tail14;

    public boolean isEmpty() {
        return head14 == null;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked List Kosong");
        } else {
            Node14 temp14 = head14;
            while (temp14 != null) {
                temp14.data14.tampilInformasi();
                temp14 = temp14.next14;
            }
        }
    }

    public void addFirst(Mahasiswa14 data14) {
        Node14 newNode14 = new Node14(data14, null);
        if (isEmpty()) {
            head14 = newNode14;
            tail14 = newNode14;
        } else {
            newNode14.next14 = head14;
            head14 = newNode14;
        }
    }

    public void addLast(Mahasiswa14 data14) {
        Node14 newNode14 = new Node14(data14, null);
        if (isEmpty()) {
            head14 = newNode14;
            tail14 = newNode14;
        } else {
            tail14.next14 = newNode14;
            tail14 = newNode14;
        }
    }

    public void insertAfter(Mahasiswa14 data14, String key14) {
        Node14 newNode14 = new Node14(data14, null);
        Node14 temp14 = head14;
        while (temp14 != null) {
            if (temp14.data14.nama14.equalsIgnoreCase(key14)) {
                newNode14.next14 = temp14.next14;
                temp14.next14 = newNode14;
                if (temp14 == tail14) {
                    tail14 = newNode14;
                }
                break;
            }
            temp14 = temp14.next14;
        }
    }

    public void addAtIndex(Mahasiswa14 data14, int index14) {
        if (index14 < 0) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        if (index14 == 0) {
            addFirst(data14);
            return;
        }
        Node14 newNode14 = new Node14(data14, null);
        Node14 temp14 = head14;
        for (int i14 = 0; i14 < index14 - 1; i14++) {
            if (temp14 == null) {
                System.out.println("Indeks melebihi panjang linked list.");
                return;
            }
            temp14 = temp14.next14;
        }
        if (temp14 == null) {
            System.out.println("Indeks melebihi panjang linked list.");
            return;
        }
        newNode14.next14 = temp14.next14;
        temp14.next14 = newNode14;
        if (temp14 == tail14) {
            tail14 = newNode14;
        }
    }

    // === Method Percobaan 2 ===

    public Mahasiswa14 getData(int index14) {
        Node14 temp14 = head14;
        for (int i14 = 0; i14 < index14; i14++) {
            if (temp14 == null) {
                System.out.println("Indeks melebihi panjang linked list.");
                return null;
            }
            temp14 = temp14.next14;
        }
        if (temp14 != null) {
            return temp14.data14;
        } else {
            System.out.println("Indeks melebihi panjang linked list.");
            return null;
        }
    }

    public int indexOf(String key14) {
        Node14 temp14 = head14;
        int index14 = 0;
        while (temp14 != null && !temp14.data14.nama14.equalsIgnoreCase(key14)) {
            temp14 = temp14.next14;
            index14++;
        }
        if (temp14 == null) {
            return -1;
        } else {
            return index14;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List Kosong, tidak dapat dihapus.");
        } else if (head14 == tail14) {
            head14 = tail14 = null;
        } else {
            head14 = head14.next14;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List Kosong, tidak dapat dihapus.");
        } else if (head14 == tail14) {
            head14 = tail14 = null;
        } else {
            Node14 temp14 = head14;
            while (temp14.next14 != tail14) {
                temp14 = temp14.next14;
            }
            temp14.next14 = null;
            tail14 = temp14;
        }
    }

    public void remove(String key14) {
        if (isEmpty()) {
            System.out.println("Linked List Kosong, tidak dapat dihapus.");
        } else {
            Node14 temp14 = head14;
            while (temp14 != null) {
                if (temp14.data14.nama14.equalsIgnoreCase(key14) && temp14 == head14) {
                    removeFirst();
                    break;
                } else if (temp14.next14 != null && temp14.next14.data14.nama14.equalsIgnoreCase(key14)) {
                    temp14.next14 = temp14.next14.next14;
                    if (temp14.next14 == null) {
                        tail14 = temp14;
                    }
                    break;
                }
                temp14 = temp14.next14;
            }
        }
    }

    public void removeAt(int index14) {
        if (index14 == 0) {
            removeFirst();
        } else {
            Node14 temp14 = head14;
            for (int i14 = 0; i14 < index14 - 1; i14++) {
                temp14 = temp14.next14;
            }
            temp14.next14 = temp14.next14.next14;
            if (temp14.next14 == null) {
                tail14 = temp14;
            }
        }
    }
}
```

---

### 3.1.2 Kode Class `SLLMain14` (Percobaan 2 – Lengkap)

```java
public class SLLMain14 {
    public static void main(String[] args) {
        SingleLinkedList14 sll14 = new SingleLinkedList14();

        sll14.print();

        Mahasiswa14 mhs1 = new Mahasiswa14("254107020111", "Anton", "TI-1E", 3.57);
        Mahasiswa14 mhs2 = new Mahasiswa14("254107020112", "Budi", "TI-1E", 3.78);
        Mahasiswa14 mhs3 = new Mahasiswa14("254107020113", "Citra", "TI-1E", 3.34);
        Mahasiswa14 mhs4 = new Mahasiswa14("254107020114", "Dewi", "TI-1E", 3.95);

        sll14.addFirst(mhs1);
        sll14.print();

        sll14.addLast(mhs2);
        sll14.print();

        sll14.insertAfter(mhs3, "Anton");
        sll14.print();

        sll14.addAtIndex(mhs4, 2);
        sll14.print();

        // === Percobaan 2: Akses dan Penghapusan ===
        System.out.println("\nData index 1:");
        Mahasiswa14 data14 = sll14.getData(1);
        if (data14 != null) {
            data14.tampilInformasi();
        }

        System.out.println("Data mahasiswa bernama Budi pada index: " + sll14.indexOf("Budi"));

        System.out.println("\nSetelah removeFirst:");
        sll14.removeFirst();
        sll14.print();

        System.out.println("\nSetelah removeLast:");
        sll14.removeLast();
        sll14.print();

        System.out.println("\nSetelah remove(\"Citra\"):");
        sll14.remove("Citra");
        sll14.print();

        System.out.println("\nSetelah removeAt(0):");
        sll14.removeAt(0);
        sll14.print();
    }
}
```

---

### 3.2 Verifikasi Hasil Percobaan 2

```
Linked List Kosong
NIM: 254107020111 | Nama: Anton | Kelas: TI-1E | IPK: 3.57
NIM: 254107020111 | Nama: Anton | Kelas: TI-1E | IPK: 3.57
NIM: 254107020112 | Nama: Budi | Kelas: TI-1E | IPK: 3.78
NIM: 254107020111 | Nama: Anton | Kelas: TI-1E | IPK: 3.57
NIM: 254107020113 | Nama: Citra | Kelas: TI-1E | IPK: 3.34
NIM: 254107020112 | Nama: Budi | Kelas: TI-1E | IPK: 3.78
NIM: 254107020111 | Nama: Anton | Kelas: TI-1E | IPK: 3.57
NIM: 254107020113 | Nama: Citra | Kelas: TI-1E | IPK: 3.34
NIM: 254107020114 | Nama: Dewi | Kelas: TI-1E | IPK: 3.95
NIM: 254107020112 | Nama: Budi | Kelas: TI-1E | IPK: 3.78

Data index 1:
NIM: 254107020113 | Nama: Citra | Kelas: TI-1E | IPK: 3.34
Data mahasiswa bernama Budi pada index: 3

Setelah removeFirst:
NIM: 254107020113 | Nama: Citra | Kelas: TI-1E | IPK: 3.34
NIM: 254107020114 | Nama: Dewi | Kelas: TI-1E | IPK: 3.95
NIM: 254107020112 | Nama: Budi | Kelas: TI-1E | IPK: 3.78

Setelah removeLast:
NIM: 254107020113 | Nama: Citra | Kelas: TI-1E | IPK: 3.34
NIM: 254107020114 | Nama: Dewi | Kelas: TI-1E | IPK: 3.95

Setelah remove("Citra"):
NIM: 254107020114 | Nama: Dewi | Kelas: TI-1E | IPK: 3.95

Setelah removeAt(0):
Linked List Kosong
```

---

### 3.3 Jawaban Pertanyaan Percobaan 2

**1. Mengapa digunakan keyword break pada fungsi remove? Jelaskan!**

Keyword `break` pada method `remove` digunakan untuk menghentikan perulangan segera setelah node yang dicari sudah ditemukan dan dihapus. Tanpa `break`, perulangan `while` akan terus berjalan menelusuri sisa node dalam linked list meskipun operasi penghapusan sudah selesai dilakukan. Hal ini bukan hanya tidak efisien secara komputasi, tetapi juga berpotensi menyebabkan kesalahan logika — misalnya, jika ada lebih dari satu node dengan nama yang sama, semua node tersebut akan dihapus padahal seharusnya hanya node pertama yang ditemukan yang dihapus. Penggunaan `break` memastikan bahwa hanya satu node (node pertama yang cocok dengan `key14`) yang dihapus, dan proses pencarian dihentikan segera setelah penghapusan berhasil dilakukan.

---

**2. Jelaskan kegunaan kode dibawah pada method remove:**

```java
temp14.next14 = temp14.next14.next14;
if (temp14.next14 == null) {
    tail14 = temp14;
}
```

Potongan kode tersebut memiliki dua fungsi utama:

**Pertama**, baris `temp14.next14 = temp14.next14.next14` berfungsi untuk **menghapus node target** dari linked list dengan mekanisme **bypass (melewati)**. Ketika `temp14` adalah node sebelum node target, maka `temp14.next14` menunjuk ke node target yang akan dihapus, dan `temp14.next14.next14` menunjuk ke node setelah target. Dengan mengatur `temp14.next14 = temp14.next14.next14`, node target dilewati — pointer `next14` dari `temp14` kini langsung menunjuk ke node setelah target. Node target tidak lagi terhubung dalam rantai linked list, sehingga secara efektif sudah dihapus dan akan dihapus oleh garbage collector.

**Kedua**, baris `if (temp14.next14 == null) { tail14 = temp14; }` berfungsi untuk **memperbarui pointer `tail14`** jika node yang dihapus adalah node terakhir (tail). Ketika node terakhir dihapus, `temp14.next14.next14` bernilai `null`, sehingga setelah bypass, `temp14.next14` menjadi `null`. Kondisi ini menandakan bahwa `temp14` kini menjadi node terakhir dalam linked list, sehingga pointer `tail14` harus diperbarui agar tetap menunjuk ke node terakhir yang valid. Tanpa pembaruan ini, `tail14` akan tetap menunjuk ke node yang sudah dihapus, menyebabkan inkonsistensi data.

---

## 4. Tugas Praktikum – Antrian Layanan Unit Kemahasiswaan (Queue Berbasis Linked List)

### Deskripsi

Buat implementasi program antrian layanan unit kemahasiswaan menggunakan Queue berbasis Linked List. Program ini merupakan proyek baru (bukan modifikasi dari percobaan). Fitur yang harus tersedia: cek antrian kosong, cek antrian penuh, mengosongkan antrian, menambahkan antrian, memanggil antrian, menampilkan antrian terdepan dan paling akhir, serta menampilkan jumlah mahasiswa yang masih mengantre.

---

### 4.1 Kode Class `MahasiswaLL14`

```java
public class MahasiswaLL14 {
    String nim14;
    String nama14;
    String kelas14;
    double ipk14;

    public MahasiswaLL14() {

    }

    public MahasiswaLL14(String nim14, String nama14, String kelas14, double ipk14) {
        this.nim14 = nim14;
        this.nama14 = nama14;
        this.kelas14 = kelas14;
        this.ipk14 = ipk14;
    }

    public void tampilInformasi() {
        System.out.println("NIM: " + nim14 + " | Nama: " + nama14 + " | Kelas: " + kelas14 + " | IPK: " + ipk14);
    }
}
```

---

### 4.2 Kode Class `NodeAntrian14`

```java
public class NodeAntrian14 {
    MahasiswaLL14 data14;
    NodeAntrian14 next14;

    public NodeAntrian14(MahasiswaLL14 data14, NodeAntrian14 next14) {
        this.data14 = data14;
        this.next14 = next14;
    }
}
```

---

### 4.3 Kode Class `AntrianLL14`

```java
public class AntrianLL14 {
    NodeAntrian14 head14;
    NodeAntrian14 tail14;
    int size14;
    int max14;

    public AntrianLL14(int max14) {
        this.max14 = max14;
        this.size14 = 0;
    }

    public boolean isEmpty() {
        return head14 == null;
    }

    public boolean isFull() {
        return size14 == max14;
    }

    public void clear() {
        head14 = tail14 = null;
        size14 = 0;
        System.out.println("Antrian berhasil dikosongkan.");
    }

    public void tambahAntrian(MahasiswaLL14 mhs14) {
        if (isFull()) {
            System.out.println("Antrian penuh, tidak dapat menambah mahasiswa.");
            return;
        }
        NodeAntrian14 newNode14 = new NodeAntrian14(mhs14, null);
        if (isEmpty()) {
            head14 = newNode14;
            tail14 = newNode14;
        } else {
            tail14.next14 = newNode14;
            tail14 = newNode14;
        }
        size14++;
        System.out.println(mhs14.nama14 + " berhasil masuk ke antrian.");
    }

    public MahasiswaLL14 panggilAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada mahasiswa untuk dipanggil.");
            return null;
        }
        MahasiswaLL14 mhs14 = head14.data14;
        head14 = head14.next14;
        if (head14 == null) {
            tail14 = null;
        }
        size14--;
        return mhs14;
    }

    public void lihatTerdepan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Mahasiswa terdepan:");
            head14.data14.tampilInformasi();
        }
    }

    public void lihatAkhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Mahasiswa paling akhir:");
            tail14.data14.tampilInformasi();
        }
    }

    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Daftar Mahasiswa dalam Antrian:");
        NodeAntrian14 temp14 = head14;
        int nomor14 = 1;
        while (temp14 != null) {
            System.out.print(nomor14 + ". ");
            temp14.data14.tampilInformasi();
            temp14 = temp14.next14;
            nomor14++;
        }
    }

    public int getJumlahAntrian() {
        return size14;
    }
}
```

---

### 4.4 Kode Class `AntrianLLMain14`

```java
import java.util.Scanner;

public class AntrianLLMain14 {
    public static void main(String[] args) {
        Scanner ferdi = new Scanner(System.in);
        AntrianLL14 antrian14 = new AntrianLL14(30);
        int pilihan14;

        do {
            System.out.println("\n=== Menu Antrian Layanan Unit Kemahasiswaan ===");
            System.out.println("1. Tambah Mahasiswa ke Antrian");
            System.out.println("2. Panggil Antrian");
            System.out.println("3. Lihat Antrian Terdepan");
            System.out.println("4. Lihat Antrian Paling Akhir");
            System.out.println("5. Tampilkan Semua Antrian");
            System.out.println("6. Cek Antrian Kosong");
            System.out.println("7. Cek Antrian Penuh");
            System.out.println("8. Kosongkan Antrian");
            System.out.println("9. Jumlah Mahasiswa dalam Antrian");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan14 = ferdi.nextInt();
            ferdi.nextLine();

            switch (pilihan14) {
                case 1:
                    System.out.print("NIM   : ");
                    String nim14 = ferdi.nextLine();
                    System.out.print("Nama  : ");
                    String nama14 = ferdi.nextLine();
                    System.out.print("Kelas : ");
                    String kelas14 = ferdi.nextLine();
                    System.out.print("IPK   : ");
                    double ipk14 = ferdi.nextDouble();
                    ferdi.nextLine();
                    MahasiswaLL14 mhs14 = new MahasiswaLL14(nim14, nama14, kelas14, ipk14);
                    antrian14.tambahAntrian(mhs14);
                    break;
                case 2:
                    MahasiswaLL14 dipanggil14 = antrian14.panggilAntrian();
                    if (dipanggil14 != null) {
                        System.out.print("Memanggil mahasiswa: ");
                        dipanggil14.tampilInformasi();
                    }
                    break;
                case 3:
                    antrian14.lihatTerdepan();
                    break;
                case 4:
                    antrian14.lihatAkhir();
                    break;
                case 5:
                    antrian14.tampilkanSemua();
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
                        System.out.println("Antrian belum penuh. Sisa kapasitas: " + (30 - antrian14.getJumlahAntrian()));
                    }
                    break;
                case 8:
                    antrian14.clear();
                    break;
                case 9:
                    System.out.println("Jumlah mahasiswa dalam antrian: " + antrian14.getJumlahAntrian());
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

### 4.5 Verifikasi Hasil Tugas

```
=== Menu Antrian Layanan Unit Kemahasiswaan ===
1. Tambah Mahasiswa ke Antrian
2. Panggil Antrian
3. Lihat Antrian Terdepan
4. Lihat Antrian Paling Akhir
5. Tampilkan Semua Antrian
6. Cek Antrian Kosong
7. Cek Antrian Penuh
8. Kosongkan Antrian
9. Jumlah Mahasiswa dalam Antrian
0. Keluar
Pilih menu: 6
Antrian kosong.

=== Menu Antrian Layanan Unit Kemahasiswaan ===
...
Pilih menu: 1
NIM   : 254107020101
Nama  : Ahmad
Kelas : 1E
IPK   : 3.5
Ahmad berhasil masuk ke antrian.

=== Menu Antrian Layanan Unit Kemahasiswaan ===
...
Pilih menu: 1
NIM   : 254107020102
Nama  : Budi
Kelas : 1E
IPK   : 3.7
Budi berhasil masuk ke antrian.

=== Menu Antrian Layanan Unit Kemahasiswaan ===
...
Pilih menu: 1
NIM   : 254107020103
Nama  : Citra
Kelas : 1E
IPK   : 3.2
Citra berhasil masuk ke antrian.

=== Menu Antrian Layanan Unit Kemahasiswaan ===
...
Pilih menu: 3
Mahasiswa terdepan:
NIM: 254107020101 | Nama: Ahmad | Kelas: 1E | IPK: 3.5

=== Menu Antrian Layanan Unit Kemahasiswaan ===
...
Pilih menu: 4
Mahasiswa paling akhir:
NIM: 254107020103 | Nama: Citra | Kelas: 1E | IPK: 3.2

=== Menu Antrian Layanan Unit Kemahasiswaan ===
...
Pilih menu: 5
Daftar Mahasiswa dalam Antrian:
1. NIM: 254107020101 | Nama: Ahmad | Kelas: 1E | IPK: 3.5
2. NIM: 254107020102 | Nama: Budi | Kelas: 1E | IPK: 3.7
3. NIM: 254107020103 | Nama: Citra | Kelas: 1E | IPK: 3.2

=== Menu Antrian Layanan Unit Kemahasiswaan ===
...
Pilih menu: 2
Memanggil mahasiswa: NIM: 254107020101 | Nama: Ahmad | Kelas: 1E | IPK: 3.5

=== Menu Antrian Layanan Unit Kemahasiswaan ===
...
Pilih menu: 5
Daftar Mahasiswa dalam Antrian:
1. NIM: 254107020102 | Nama: Budi | Kelas: 1E | IPK: 3.7
2. NIM: 254107020103 | Nama: Citra | Kelas: 1E | IPK: 3.2

=== Menu Antrian Layanan Unit Kemahasiswaan ===
...
Pilih menu: 9
Jumlah mahasiswa dalam antrian: 2

=== Menu Antrian Layanan Unit Kemahasiswaan ===
...
Pilih menu: 7
Antrian belum penuh. Sisa kapasitas: 28
```

---
