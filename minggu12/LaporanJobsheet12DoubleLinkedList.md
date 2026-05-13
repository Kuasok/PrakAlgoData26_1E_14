# LAPORAN JOBSHEET 12 – DOUBLE LINKED LIST

**Nama:** Muhammad Ferdi Afiyanto
**NIM:** 254107020122
**Kelas:** TI-1E

---

## 1. Tujuan Praktikum

Setelah melakukan praktikum ini, mahasiswa mampu:
1. Memahami algoritma double linked list
2. Membuat dan mendeklarasikan struktur algoritma double linked list
3. Menerapkan operasi penambahan, pencarian, dan penghapusan data pada Double Linked List

---

## 2. Percobaan 1 – Operasi Penambahan pada Double Linked List

### 2.1 Langkah-langkah Percobaan

Percobaan ini mengimplementasikan struktur data Double Linked List beserta beberapa operasi dasar seperti penambahan data di awal, penambahan data di akhir, pencarian data, penyisipan node setelah data tertentu, dan menampilkan isi linked list. Pada Double Linked List, setiap node memiliki dua pointer yaitu `next14` yang menunjuk ke node berikutnya dan `prev14` yang menunjuk ke node sebelumnya, sehingga traversal dapat dilakukan ke dua arah.

---

### 2.1.1 Kode Class `Mahasiswa14`

```java
public class Mahasiswa14 {
    String nim14;
    String nama14;
    String kelas14;
    double ipk14;

    public Mahasiswa14(String nim14, String nama14, String kelas14, double ipk14) {
        this.nim14 = nim14;
        this.nama14 = nama14;
        this.kelas14 = kelas14;
        this.ipk14 = ipk14;
    }

    public void tampil() {
        System.out.println("NIM: " + nim14 + " | Nama: " + nama14 + " | Kelas: " + kelas14 + " | IPK: " + ipk14);
    }
}
```

---

### 2.1.2 Kode Class `Node14`

```java
public class Node14 {
    Mahasiswa14 data14;
    Node14 prev14;
    Node14 next14;

    public Node14(Node14 prev14, Mahasiswa14 data14, Node14 next14) {
        this.prev14 = prev14;
        this.data14 = data14;
        this.next14 = next14;
    }
}
```

---

### 2.1.3 Kode Class `DoubleLinkedList14` (Percobaan 1)

```java
public class DoubleLinkedList14 {
    Node14 head14;
    int size14;

    public DoubleLinkedList14() {
        head14 = null;
        size14 = 0;
    }

    public boolean isEmpty() {
        return head14 == null;
    }

    public void addFirst(Mahasiswa14 data14) {
        if (isEmpty()) {
            head14 = new Node14(null, data14, null);
        } else {
            Node14 newNode14 = new Node14(null, data14, head14);
            head14.prev14 = newNode14;
            head14 = newNode14;
        }
        size14++;
    }

    public void addLast(Mahasiswa14 data14) {
        if (isEmpty()) {
            addFirst(data14);
        } else {
            Node14 temp14 = head14;
            while (temp14.next14 != null) {
                temp14 = temp14.next14;
            }
            Node14 newNode14 = new Node14(temp14, data14, null);
            temp14.next14 = newNode14;
            size14++;
        }
    }

    public void add(Mahasiswa14 data14, int index14) {
        if (index14 < 0 || index14 > size14) {
            System.out.println("Indeks di luar batas.");
            return;
        }
        if (index14 == 0) {
            addFirst(data14);
        } else {
            Node14 temp14 = head14;
            for (int i14 = 0; i14 < index14 - 1; i14++) {
                temp14 = temp14.next14;
            }
            Node14 newNode14 = new Node14(temp14, data14, temp14.next14);
            if (temp14.next14 != null) {
                temp14.next14.prev14 = newNode14;
            }
            temp14.next14 = newNode14;
            size14++;
        }
    }

    public void insertAfter(String key14, Mahasiswa14 data14) {
        Node14 temp14 = head14;
        while (temp14 != null) {
            if (temp14.data14.nama14.equalsIgnoreCase(key14)) {
                Node14 newNode14 = new Node14(temp14, data14, temp14.next14);
                if (temp14.next14 != null) {
                    temp14.next14.prev14 = newNode14;
                }
                temp14.next14 = newNode14;
                size14++;
                break;
            }
            temp14 = temp14.next14;
        }
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong");
        } else {
            Node14 temp14 = head14;
            while (temp14 != null) {
                temp14.data14.tampil();
                temp14 = temp14.next14;
            }
        }
    }
}
```

---

### 2.1.4 Kode Class `DoubleLinkedListMain14` (Percobaan 1)

```java
import java.util.Scanner;

public class DoubleLinkedListMain14 {
    public static void main(String[] args) {
        Scanner ferdi = new Scanner(System.in);
        DoubleLinkedList14 dll14 = new DoubleLinkedList14();
        int pilihan14;

        do {
            System.out.println("\n=== Menu Double Linked List ===");
            System.out.println("1. Add First");
            System.out.println("2. Add Last");
            System.out.println("3. Add at Index");
            System.out.println("4. Insert After (key nama)");
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
                    dll14.addFirst(mhs14);
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
                    dll14.addLast(mhs14);
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
                    System.out.print("Masukkan indeks: ");
                    int index14 = ferdi.nextInt();
                    ferdi.nextLine();
                    dll14.add(mhs14, index14);
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
                    System.out.print("Masukkan key (nama): ");
                    String key14 = ferdi.nextLine();
                    dll14.insertAfter(key14, mhs14);
                    break;
                case 5:
                    dll14.print();
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

### 2.2 Verifikasi Hasil Percobaan 1

```
=== Menu Double Linked List ===
1. Add First
2. Add Last
3. Add at Index
4. Insert After (key nama)
5. Print
0. Keluar
Pilih menu: 1
NIM   : 254107020111
Nama  : Anton
Kelas : TI-1E
IPK   : 3.57

=== Menu Double Linked List ===
...
Pilih menu: 2
NIM   : 254107020112
Nama  : Budi
Kelas : TI-1E
IPK   : 3.78

=== Menu Double Linked List ===
...
Pilih menu: 2
NIM   : 254107020113
Nama  : Citra
Kelas : TI-1E
IPK   : 3.34

=== Menu Double Linked List ===
...
Pilih menu: 5
NIM: 254107020111 | Nama: Anton | Kelas: TI-1E | IPK: 3.57
NIM: 254107020112 | Nama: Budi | Kelas: TI-1E | IPK: 3.78
NIM: 254107020113 | Nama: Citra | Kelas: TI-1E | IPK: 3.34

=== Menu Double Linked List ===
...
Pilih menu: 4
NIM   : 254107020114
Nama  : Dewi
Kelas : TI-1E
IPK   : 3.95
Masukkan key (nama): Budi

=== Menu Double Linked List ===
...
Pilih menu: 5
NIM: 254107020111 | Nama: Anton | Kelas: TI-1E | IPK: 3.57
NIM: 254107020112 | Nama: Budi | Kelas: TI-1E | IPK: 3.78
NIM: 254107020114 | Nama: Dewi | Kelas: TI-1E | IPK: 3.95
NIM: 254107020113 | Nama: Citra | Kelas: TI-1E | IPK: 3.34
```

---

### 2.3 Jawaban Pertanyaan Percobaan 1

**1. Jelaskan perbedaan struktur dan mekanisme traversal antara Single Linked List dan Double Linked List!**

Perbedaan utama antara Single Linked List dan Double Linked List terletak pada jumlah pointer yang dimiliki setiap node dan arah traversal yang dapat dilakukan. Pada Single Linked List, setiap node hanya memiliki satu pointer yaitu `next` yang menunjuk ke node berikutnya. Traversal hanya dapat dilakukan dalam satu arah yaitu dari head menuju tail — kita tidak bisa bergerak mundur dari tail ke head. Untuk mengakses node sebelumnya, kita harus memulai traversal dari awal (head) lagi.

Sebaliknya, pada Double Linked List, setiap node memiliki dua pointer yaitu `prev` yang menunjuk ke node sebelumnya dan `next` yang menunjuk ke node berikutnya. Hal ini memungkinkan traversal dilakukan ke dua arah — dari head ke tail maupun dari tail ke head. Kelebihan ini membuat operasi seperti penghapusan node terakhir (removeLast) menjadi lebih efisien karena kita tidak perlu menelusuri dari awal untuk menemukan node sebelum tail; cukup mengakses `tail.prev` secara langsung. Namun, Double Linked List membutuhkan memori lebih banyak karena setiap node menyimpan dua pointer dibandingkan satu pointer pada Single Linked List.

---

**2. Perhatikan class Node, di dalamnya terdapat atribut next dan prev. Jelaskan fungsi masing-masing atribut tersebut pada proses traversal dan manipulasi node!**

Atribut `next14` berfungsi sebagai pointer yang menunjuk ke node berikutnya (node di sebelah kanan) dalam urutan linked list. Pada proses traversal maju (forward), `next14` digunakan untuk berpindah dari node saat ini ke node berikutnya secara berurutan dari head hingga tail. Pada operasi manipulasi seperti `addFirst` dan `insertAfter`, atribut `next14` dari node sebelumnya harus diperbarui agar menunjuk ke node baru yang disisipkan.

Atribut `prev14` berfungsi sebagai pointer yang menunjuk ke node sebelumnya (node di sebelah kiri) dalam urutan linked list. Pada proses traversal mundur (backward), `prev14` digunakan untuk berpindah dari node saat ini ke node sebelumnya dari tail menuju head. Pada operasi manipulasi seperti `addFirst` dan `insertAfter`, atribut `prev14` dari node setelah posisi penyisipan harus diperbarui agar menunjuk kembali ke node baru. Kedua pointer ini saling melengkapi untuk menjaga integritas hubungan antar node dalam Double Linked List.

---

**3. Perhatikan konstruktor pada class DoubleLinkedList. Jelaskan fungsi konstruktor tersebut terhadap kondisi awal linked list!**

Konstruktor pada class `DoubleLinkedList14` berfungsi untuk menginisialisasi kondisi awal linked list agar berada dalam keadaan kosong dan siap digunakan. Di dalam konstruktor, atribut `head14` diatur menjadi `null` yang menandakan belum ada node yang terhubung dalam linked list, dan atribut `size14` diatur menjadi `0` yang menandakan jumlah data masih kosong. Inisialisasi ini penting karena jika `head14` tidak diatur ke `null`, maka method `isEmpty()` yang memeriksa kondisi `head14 == null` tidak akan bekerja dengan benar. Konstruktor memastikan bahwa sebelum ada operasi penambahan data, linked list berada dalam kondisi yang konsisten dan terprediksi.

---

**4. Perhatikan potongan kode berikut:**
```java
if (isEmpty()) {
    head14 = tail14 = newNode14;
}
```
**Mengapa head dan tail harus menunjuk node yang sama ketika linked list masih kosong?**

Ketika linked list masih kosong dan node pertama ditambahkan, maka node tersebut sekaligus menjadi node pertama (head) dan node terakhir (tail) dalam linked list. Head dan tail harus menunjuk ke node yang sama karena pada saat itu hanya ada satu node yang ada di dalam linked list. Node tersebut tidak memiliki node sebelumnya maupun node sesudahnya — pointer `prev14` dan `next14` keduanya bernilai `null`.

Pada implementasi jobsheet ini yang hanya menggunakan atribut `head14` tanpa atribut `tail14` secara eksplisit, prinsip yang sama berlaku: ketika linked list kosong dan node pertama ditambahkan, `head14` menunjuk ke node tersebut dan node tersebut menjadi satu-satunya node. Jika atribut `tail14` digunakan, maka `tail14` juga harus menunjuk ke node yang sama agar operasi seperti `addLast` dan `removeLast` dapat menemukan node terakhir dengan benar tanpa perlu traversal dari head.

---

**5. Modifikasi method print() agar menampilkan pesan "Linked List masih kosong" ketika tidak terdapat data pada linked list!**

Method `print()` sudah dimodifikasi pada kode final di atas. Berikut potongan kode modifikasinya:

```java
public void print() {
    if (isEmpty()) {
        System.out.println("Linked List masih kosong");
    } else {
        Node14 temp14 = head14;
        while (temp14 != null) {
            temp14.data14.tampil();
            temp14 = temp14.next14;
        }
    }
}
```

Penambahan kondisi `isEmpty()` di awal method `print()` memastikan bahwa ketika linked list tidak memiliki data sama sekali (`head14 == null`), program tidak mencoba mengakses `head14.data14` yang akan menyebabkan `NullPointerException`. Sebaliknya, program akan menampilkan pesan "Linked List masih kosong" yang informatif bagi pengguna.

---

**6. Modifikasi kode program dengan menambahkan method printReverse() untuk menampilkan seluruh data pada Double Linked List secara terbalik, dimulai dari node tail menuju head!**

Berikut adalah method `printReverse()` yang ditambahkan ke class `DoubleLinkedList14`:

```java
public void printReverse() {
    if (isEmpty()) {
        System.out.println("Linked List masih kosong");
    } else {
        Node14 temp14 = head14;
        while (temp14.next14 != null) {
            temp14 = temp14.next14;
        }
        while (temp14 != null) {
            temp14.data14.tampil();
            temp14 = temp14.prev14;
        }
    }
}
```

Method ini bekerja dengan dua tahap: pertama, traversal maju dari `head14` hingga menemukan node terakhir (node yang `next14`-nya bernilai `null`). Kedua, traversal mundur dari node terakhir tersebut menggunakan pointer `prev14` hingga kembali ke `head14` yang `prev14`-nya bernilai `null`. Inilah keunggulan Double Linked List dibandingkan Single Linked List — kita dapat menelusuri data dari belakang ke depan karena setiap node menyimpan referensi ke node sebelumnya.

---

## 3. Percobaan 2 – Operasi Penghapusan pada Double Linked List

### 3.1 Langkah-langkah Percobaan

Percobaan ini menambahkan method untuk menghapus node pada Double Linked List, yaitu `removeFirst()` untuk menghapus node di bagian awal dan `removeLast()` untuk menghapus node di bagian akhir. Keunggulan Double Linked List terlihat pada operasi `removeLast()` yang lebih efisien karena dapat mengakses node sebelum tail secara langsung melalui pointer `prev`.

---

### 3.1.1 Kode Class `DoubleLinkedList14` (Percobaan 2 – Lengkap)

```java
public class DoubleLinkedList14 {
    Node14 head14;
    int size14;

    public DoubleLinkedList14() {
        head14 = null;
        size14 = 0;
    }

    public boolean isEmpty() {
        return head14 == null;
    }

    public void addFirst(Mahasiswa14 data14) {
        if (isEmpty()) {
            head14 = new Node14(null, data14, null);
        } else {
            Node14 newNode14 = new Node14(null, data14, head14);
            head14.prev14 = newNode14;
            head14 = newNode14;
        }
        size14++;
    }

    public void addLast(Mahasiswa14 data14) {
        if (isEmpty()) {
            addFirst(data14);
        } else {
            Node14 temp14 = head14;
            while (temp14.next14 != null) {
                temp14 = temp14.next14;
            }
            Node14 newNode14 = new Node14(temp14, data14, null);
            temp14.next14 = newNode14;
            size14++;
        }
    }

    public void add(Mahasiswa14 data14, int index14) {
        if (index14 < 0 || index14 > size14) {
            System.out.println("Indeks di luar batas.");
            return;
        }
        if (index14 == 0) {
            addFirst(data14);
        } else {
            Node14 temp14 = head14;
            for (int i14 = 0; i14 < index14 - 1; i14++) {
                temp14 = temp14.next14;
            }
            Node14 newNode14 = new Node14(temp14, data14, temp14.next14);
            if (temp14.next14 != null) {
                temp14.next14.prev14 = newNode14;
            }
            temp14.next14 = newNode14;
            size14++;
        }
    }

    public void insertAfter(String key14, Mahasiswa14 data14) {
        Node14 temp14 = head14;
        while (temp14 != null) {
            if (temp14.data14.nama14.equalsIgnoreCase(key14)) {
                Node14 newNode14 = new Node14(temp14, data14, temp14.next14);
                if (temp14.next14 != null) {
                    temp14.next14.prev14 = newNode14;
                }
                temp14.next14 = newNode14;
                size14++;
                break;
            }
            temp14 = temp14.next14;
        }
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong");
        } else {
            Node14 temp14 = head14;
            while (temp14 != null) {
                temp14.data14.tampil();
                temp14 = temp14.next14;
            }
        }
    }

    public void printReverse() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong");
        } else {
            Node14 temp14 = head14;
            while (temp14.next14 != null) {
                temp14 = temp14.next14;
            }
            while (temp14 != null) {
                temp14.data14.tampil();
                temp14 = temp14.prev14;
            }
        }
    }

    // === Method Percobaan 2 ===

    public Mahasiswa14 removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong, tidak dapat dihapus.");
            return null;
        }
        Mahasiswa14 dataHapus14 = head14.data14;
        if (head14.next14 == null) {
            head14 = null;
        } else {
            head14 = head14.next14;
            head14.prev14 = null;
        }
        size14--;
        return dataHapus14;
    }

    public Mahasiswa14 removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong, tidak dapat dihapus.");
            return null;
        }
        Mahasiswa14 dataHapus14;
        if (head14.next14 == null) {
            dataHapus14 = head14.data14;
            head14 = null;
        } else {
            Node14 temp14 = head14;
            while (temp14.next14.next14 != null) {
                temp14 = temp14.next14;
            }
            dataHapus14 = temp14.next14.data14;
            temp14.next14 = null;
        }
        size14--;
        return dataHapus14;
    }
}
```

---

### 3.1.2 Kode Class `DoubleLinkedListMain14` (Percobaan 2 – Lengkap)

```java
import java.util.Scanner;

public class DoubleLinkedListMain14 {
    public static void main(String[] args) {
        Scanner ferdi = new Scanner(System.in);
        DoubleLinkedList14 dll14 = new DoubleLinkedList14();
        int pilihan14;

        do {
            System.out.println("\n=== Menu Double Linked List ===");
            System.out.println("1. Add First");
            System.out.println("2. Add Last");
            System.out.println("3. Add at Index");
            System.out.println("4. Insert After (key nama)");
            System.out.println("5. Print");
            System.out.println("6. Print Reverse");
            System.out.println("7. Remove First");
            System.out.println("8. Remove Last");
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
                    dll14.addFirst(mhs14);
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
                    dll14.addLast(mhs14);
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
                    System.out.print("Masukkan indeks: ");
                    int index14 = ferdi.nextInt();
                    ferdi.nextLine();
                    dll14.add(mhs14, index14);
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
                    System.out.print("Masukkan key (nama): ");
                    String key14 = ferdi.nextLine();
                    dll14.insertAfter(key14, mhs14);
                    break;
                case 5:
                    dll14.print();
                    break;
                case 6:
                    dll14.printReverse();
                    break;
                case 7:
                    Mahasiswa14 hapusFirst14 = dll14.removeFirst();
                    if (hapusFirst14 != null) {
                        System.out.println("Data yang dihapus:");
                        hapusFirst14.tampil();
                    }
                    break;
                case 8:
                    Mahasiswa14 hapusLast14 = dll14.removeLast();
                    if (hapusLast14 != null) {
                        System.out.println("Data yang dihapus:");
                        hapusLast14.tampil();
                    }
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
=== Menu Double Linked List ===
1. Add First
2. Add Last
3. Add at Index
4. Insert After (key nama)
5. Print
6. Print Reverse
7. Remove First
8. Remove Last
0. Keluar
Pilih menu: 1
NIM   : 254107020111
Nama  : Anton
Kelas : TI-1E
IPK   : 3.57

=== Menu Double Linked List ===
...
Pilih menu: 2
NIM   : 254107020112
Nama  : Budi
Kelas : TI-1E
IPK   : 3.78

=== Menu Double Linked List ===
...
Pilih menu: 2
NIM   : 254107020113
Nama  : Citra
Kelas : TI-1E
IPK   : 3.34

=== Menu Double Linked List ===
...
Pilih menu: 5
NIM: 254107020111 | Nama: Anton | Kelas: TI-1E | IPK: 3.57
NIM: 254107020112 | Nama: Budi | Kelas: TI-1E | IPK: 3.78
NIM: 254107020113 | Nama: Citra | Kelas: TI-1E | IPK: 3.34

=== Menu Double Linked List ===
...
Pilih menu: 7
Data yang dihapus:
NIM: 254107020111 | Nama: Anton | Kelas: TI-1E | IPK: 3.57

=== Menu Double Linked List ===
...
Pilih menu: 5
NIM: 254107020112 | Nama: Budi | Kelas: TI-1E | IPK: 3.78
NIM: 254107020113 | Nama: Citra | Kelas: TI-1E | IPK: 3.34

=== Menu Double Linked List ===
...
Pilih menu: 8
Data yang dihapus:
NIM: 254107020113 | Nama: Citra | Kelas: TI-1E | IPK: 3.34

=== Menu Double Linked List ===
...
Pilih menu: 5
NIM: 254107020112 | Nama: Budi | Kelas: TI-1E | IPK: 3.78

=== Menu Double Linked List ===
...
Pilih menu: 6
NIM: 254107020112 | Nama: Budi | Kelas: TI-1E | IPK: 3.78
```

---

### 3.3 Jawaban Pertanyaan Percobaan 2

**1. Perhatikan potongan kode berikut pada method removeFirst():**
```java
head14 = head14.next14;
head14.prev14 = null;
```
**Jelaskan fungsi masing-masing statement tersebut pada proses penghapusan node!**

Baris pertama `head14 = head14.next14` berfungsi untuk **menggeser pointer head ke node berikutnya**. Node yang semula ditunjuk oleh `head14` (node pertama) akan kehilangan referensi dari `head14`, dan `head14` kini menunjuk ke node kedua yang menjadi node pertama yang baru. Tanpa statement ini, `head14` masih menunjuk ke node lama yang seharusnya sudah dihapus, sehingga linked list tidak berubah.

Baris kedua `head14.prev14 = null` berfungsi untuk **memutus hubungan pointer prev dari node head yang baru ke node lama**. Setelah `head14` bergeser ke node berikutnya, node head yang baru masih memiliki pointer `prev14` yang menunjuk ke node lama (node yang akan dihapus). Dengan mengatur `head14.prev14 = null`, hubungan dua arah antara node head baru dan node yang dihapus diputus, sehingga node yang dihapus benar-benar terlepas dari linked list dan dapat di-garbage collect. Jika statement ini diabaikan, node head baru masih memiliki pointer `prev14` yang menunjuk ke node yang sudah seharusnya tidak menjadi bagian dari linked list, yang dapat menyebabkan inkonsistensi data.

---

**2. Modifikasi method removeFirst() dan removeLast() agar program menampilkan data yang berhasil dihapus!**

Method `removeFirst()` dan `removeLast()` sudah dimodifikasi pada kode final di atas agar mengembalikan data mahasiswa yang berhasil dihapus. Berikut penjelasan modifikasinya:

Pada method `removeFirst()`, sebelum pointer `head14` digeser, data dari node pertama disimpan terlebih dahulu ke variabel `dataHapus14` dengan kode `Mahasiswa14 dataHapus14 = head14.data14`. Setelah proses penghapusan selesai, method mengembalikan `dataHapus14` sehingga pemanggil method dapat menampilkan informasi data yang baru saja dihapus.

Pada method `removeLast()`, sebelum pointer `next14` dari node sebelum tail diatur ke `null`, data dari node terakhir disimpan ke variabel `dataHapus14` dengan kode `dataHapus14 = temp14.next14.data14`. Setelah proses penghapusan selesai, method mengembalikan `dataHapus14` sehingga pemanggil dapat menampilkan informasi data yang dihapus.

Pada class `DoubleLinkedListMain14`, pemanggilan method dilakukan seperti berikut:

```java
case 7:
    Mahasiswa14 hapusFirst14 = dll14.removeFirst();
    if (hapusFirst14 != null) {
        System.out.println("Data yang dihapus:");
        hapusFirst14.tampil();
    }
    break;
case 8:
    Mahasiswa14 hapusLast14 = dll14.removeLast();
    if (hapusLast14 != null) {
        System.out.println("Data yang dihapus:");
        hapusLast14.tampil();
    }
    break;
```

Pengecekan `!= null` penting untuk menangani kasus ketika linked list kosong dan method mengembalikan `null`, sehingga program tidak mengalami `NullPointerException` saat memanggil `tampil()`.

---

## 4. Tugas Praktikum

### Deskripsi

Tugas ini menambahkan beberapa method pada class `DoubleLinkedList14` untuk melengkapi operasi-operasi yang belum diimplementasikan, yaitu: `add(int index, Mahasiswa data)`, `removeAfter(String key)`, `remove(int index)`, `getFirst()`, `getLast()`, `getIndex(int index)`, serta atribut dan method `size()` untuk menghitung jumlah data.

---

### 4.1 Kode Class `DoubleLinkedList14` (Lengkap dengan Tugas)

```java
public class DoubleLinkedList14 {
    Node14 head14;
    int size14;

    public DoubleLinkedList14() {
        head14 = null;
        size14 = 0;
    }

    public boolean isEmpty() {
        return head14 == null;
    }

    public void addFirst(Mahasiswa14 data14) {
        if (isEmpty()) {
            head14 = new Node14(null, data14, null);
        } else {
            Node14 newNode14 = new Node14(null, data14, head14);
            head14.prev14 = newNode14;
            head14 = newNode14;
        }
        size14++;
    }

    public void addLast(Mahasiswa14 data14) {
        if (isEmpty()) {
            addFirst(data14);
        } else {
            Node14 temp14 = head14;
            while (temp14.next14 != null) {
                temp14 = temp14.next14;
            }
            Node14 newNode14 = new Node14(temp14, data14, null);
            temp14.next14 = newNode14;
            size14++;
        }
    }

    public void add(Mahasiswa14 data14, int index14) {
        if (index14 < 0 || index14 > size14) {
            System.out.println("Indeks di luar batas.");
            return;
        }
        if (index14 == 0) {
            addFirst(data14);
        } else {
            Node14 temp14 = head14;
            for (int i14 = 0; i14 < index14 - 1; i14++) {
                temp14 = temp14.next14;
            }
            Node14 newNode14 = new Node14(temp14, data14, temp14.next14);
            if (temp14.next14 != null) {
                temp14.next14.prev14 = newNode14;
            }
            temp14.next14 = newNode14;
            size14++;
        }
    }

    public void insertAfter(String key14, Mahasiswa14 data14) {
        Node14 temp14 = head14;
        while (temp14 != null) {
            if (temp14.data14.nama14.equalsIgnoreCase(key14)) {
                Node14 newNode14 = new Node14(temp14, data14, temp14.next14);
                if (temp14.next14 != null) {
                    temp14.next14.prev14 = newNode14;
                }
                temp14.next14 = newNode14;
                size14++;
                break;
            }
            temp14 = temp14.next14;
        }
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong");
        } else {
            Node14 temp14 = head14;
            while (temp14 != null) {
                temp14.data14.tampil();
                temp14 = temp14.next14;
            }
        }
    }

    public void printReverse() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong");
        } else {
            Node14 temp14 = head14;
            while (temp14.next14 != null) {
                temp14 = temp14.next14;
            }
            while (temp14 != null) {
                temp14.data14.tampil();
                temp14 = temp14.prev14;
            }
        }
    }

    public Mahasiswa14 removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong, tidak dapat dihapus.");
            return null;
        }
        Mahasiswa14 dataHapus14 = head14.data14;
        if (head14.next14 == null) {
            head14 = null;
        } else {
            head14 = head14.next14;
            head14.prev14 = null;
        }
        size14--;
        return dataHapus14;
    }

    public Mahasiswa14 removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong, tidak dapat dihapus.");
            return null;
        }
        Mahasiswa14 dataHapus14;
        if (head14.next14 == null) {
            dataHapus14 = head14.data14;
            head14 = null;
        } else {
            Node14 temp14 = head14;
            while (temp14.next14.next14 != null) {
                temp14 = temp14.next14;
            }
            dataHapus14 = temp14.next14.data14;
            temp14.next14 = null;
        }
        size14--;
        return dataHapus14;
    }

    // === Method Tugas ===

    public Mahasiswa14 removeAfter(String key14) {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong, tidak dapat dihapus.");
            return null;
        }
        Node14 temp14 = head14;
        while (temp14 != null) {
            if (temp14.data14.nama14.equalsIgnoreCase(key14)) {
                if (temp14.next14 == null) {
                    System.out.println("Tidak ada node setelah " + key14 + " yang dapat dihapus.");
                    return null;
                }
                Mahasiswa14 dataHapus14 = temp14.next14.data14;
                temp14.next14 = temp14.next14.next14;
                if (temp14.next14 != null) {
                    temp14.next14.prev14 = temp14;
                }
                size14--;
                return dataHapus14;
            }
            temp14 = temp14.next14;
        }
        System.out.println("Key \"" + key14 + "\" tidak ditemukan.");
        return null;
    }

    public Mahasiswa14 remove(int index14) {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong, tidak dapat dihapus.");
            return null;
        }
        if (index14 < 0 || index14 >= size14) {
            System.out.println("Indeks di luar batas.");
            return null;
        }
        if (index14 == 0) {
            return removeFirst();
        }
        Node14 temp14 = head14;
        for (int i14 = 0; i14 < index14 - 1; i14++) {
            temp14 = temp14.next14;
        }
        Mahasiswa14 dataHapus14 = temp14.next14.data14;
        temp14.next14 = temp14.next14.next14;
        if (temp14.next14 != null) {
            temp14.next14.prev14 = temp14;
        }
        size14--;
        return dataHapus14;
    }

    public Mahasiswa14 getFirst() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
            return null;
        }
        return head14.data14;
    }

    public Mahasiswa14 getLast() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
            return null;
        }
        Node14 temp14 = head14;
        while (temp14.next14 != null) {
            temp14 = temp14.next14;
        }
        return temp14.data14;
    }

    public Mahasiswa14 getIndex(int index14) {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
            return null;
        }
        if (index14 < 0 || index14 >= size14) {
            System.out.println("Indeks di luar batas.");
            return null;
        }
        Node14 temp14 = head14;
        for (int i14 = 0; i14 < index14; i14++) {
            temp14 = temp14.next14;
        }
        return temp14.data14;
    }

    public int size() {
        return size14;
    }
}
```

---

### 4.2 Kode Class `DoubleLinkedListMain14` (Lengkap dengan Tugas)

```java
import java.util.Scanner;

public class DoubleLinkedListMain14 {
    public static void main(String[] args) {
        Scanner ferdi = new Scanner(System.in);
        DoubleLinkedList14 dll14 = new DoubleLinkedList14();
        int pilihan14;

        do {
            System.out.println("\n=== Menu Double Linked List ===");
            System.out.println("1. Add First");
            System.out.println("2. Add Last");
            System.out.println("3. Add at Index");
            System.out.println("4. Insert After (key nama)");
            System.out.println("5. Print");
            System.out.println("6. Print Reverse");
            System.out.println("7. Remove First");
            System.out.println("8. Remove Last");
            System.out.println("9. Remove After (key nama)");
            System.out.println("10. Remove at Index");
            System.out.println("11. Get First");
            System.out.println("12. Get Last");
            System.out.println("13. Get at Index");
            System.out.println("14. Size");
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
                    dll14.addFirst(mhs14);
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
                    dll14.addLast(mhs14);
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
                    System.out.print("Masukkan indeks: ");
                    int index14 = ferdi.nextInt();
                    ferdi.nextLine();
                    dll14.add(mhs14, index14);
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
                    System.out.print("Masukkan key (nama): ");
                    String key14 = ferdi.nextLine();
                    dll14.insertAfter(key14, mhs14);
                    break;
                case 5:
                    dll14.print();
                    break;
                case 6:
                    dll14.printReverse();
                    break;
                case 7:
                    Mahasiswa14 hapusFirst14 = dll14.removeFirst();
                    if (hapusFirst14 != null) {
                        System.out.println("Data yang dihapus:");
                        hapusFirst14.tampil();
                    }
                    break;
                case 8:
                    Mahasiswa14 hapusLast14 = dll14.removeLast();
                    if (hapusLast14 != null) {
                        System.out.println("Data yang dihapus:");
                        hapusLast14.tampil();
                    }
                    break;
                case 9:
                    System.out.print("Masukkan key (nama sebelum node yang dihapus): ");
                    String keyRemove14 = ferdi.nextLine();
                    Mahasiswa14 hapusAfter14 = dll14.removeAfter(keyRemove14);
                    if (hapusAfter14 != null) {
                        System.out.println("Data yang dihapus:");
                        hapusAfter14.tampil();
                    }
                    break;
                case 10:
                    System.out.print("Masukkan indeks yang akan dihapus: ");
                    int idxRemove14 = ferdi.nextInt();
                    ferdi.nextLine();
                    Mahasiswa14 hapusIdx14 = dll14.remove(idxRemove14);
                    if (hapusIdx14 != null) {
                        System.out.println("Data yang dihapus:");
                        hapusIdx14.tampil();
                    }
                    break;
                case 11:
                    Mahasiswa14 first14 = dll14.getFirst();
                    if (first14 != null) {
                        System.out.println("Data pertama:");
                        first14.tampil();
                    }
                    break;
                case 12:
                    Mahasiswa14 last14 = dll14.getLast();
                    if (last14 != null) {
                        System.out.println("Data terakhir:");
                        last14.tampil();
                    }
                    break;
                case 13:
                    System.out.print("Masukkan indeks: ");
                    int idx14 = ferdi.nextInt();
                    ferdi.nextLine();
                    Mahasiswa14 dataIdx14 = dll14.getIndex(idx14);
                    if (dataIdx14 != null) {
                        System.out.println("Data pada indeks " + idx14 + ":");
                        dataIdx14.tampil();
                    }
                    break;
                case 14:
                    System.out.println("Jumlah data dalam linked list: " + dll14.size());
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

### 4.3 Verifikasi Hasil Tugas

```
=== Menu Double Linked List ===
1. Add First
2. Add Last
3. Add at Index
4. Insert After (key nama)
5. Print
6. Print Reverse
7. Remove First
8. Remove Last
9. Remove After (key nama)
10. Remove at Index
11. Get First
12. Get Last
13. Get at Index
14. Size
0. Keluar
Pilih menu: 1
NIM   : 254107020111
Nama  : Anton
Kelas : TI-1E
IPK   : 3.57

Pilih menu: 2
NIM   : 254107020112
Nama  : Budi
Kelas : TI-1E
IPK   : 3.78

Pilih menu: 2
NIM   : 254107020113
Nama  : Citra
Kelas : TI-1E
IPK   : 3.34

Pilih menu: 2
NIM   : 254107020114
Nama  : Dewi
Kelas : TI-1E
IPK   : 3.95

Pilih menu: 5
NIM: 254107020111 | Nama: Anton | Kelas: TI-1E | IPK: 3.57
NIM: 254107020112 | Nama: Budi | Kelas: TI-1E | IPK: 3.78
NIM: 254107020113 | Nama: Citra | Kelas: TI-1E | IPK: 3.34
NIM: 254107020114 | Nama: Dewi | Kelas: TI-1E | IPK: 3.95

Pilih menu: 11
Data pertama:
NIM: 254107020111 | Nama: Anton | Kelas: TI-1E | IPK: 3.57

Pilih menu: 12
Data terakhir:
NIM: 254107020114 | Nama: Dewi | Kelas: TI-1E | IPK: 3.95

Pilih menu: 13
Masukkan indeks: 2
Data pada indeks 2:
NIM: 254107020113 | Nama: Citra | Kelas: TI-1E | IPK: 3.34

Pilih menu: 14
Jumlah data dalam linked list: 4

Pilih menu: 3
NIM   : 254107020115
Nama  : Eko
Kelas : TI-1E
IPK   : 3.45
Masukkan indeks: 2

Pilih menu: 5
NIM: 254107020111 | Nama: Anton | Kelas: TI-1E | IPK: 3.57
NIM: 254107020112 | Nama: Budi | Kelas: TI-1E | IPK: 3.78
NIM: 254107020115 | Nama: Eko | Kelas: TI-1E | IPK: 3.45
NIM: 254107020113 | Nama: Citra | Kelas: TI-1E | IPK: 3.34
NIM: 254107020114 | Nama: Dewi | Kelas: TI-1E | IPK: 3.95

Pilih menu: 9
Masukkan key (nama sebelum node yang dihapus): Budi
Data yang dihapus:
NIM: 254107020115 | Nama: Eko | Kelas: TI-1E | IPK: 3.45

Pilih menu: 5
NIM: 254107020111 | Nama: Anton | Kelas: TI-1E | IPK: 3.57
NIM: 254107020112 | Nama: Budi | Kelas: TI-1E | IPK: 3.78
NIM: 254107020113 | Nama: Citra | Kelas: TI-1E | IPK: 3.34
NIM: 254107020114 | Nama: Dewi | Kelas: TI-1E | IPK: 3.95

Pilih menu: 10
Masukkan indeks yang akan dihapus: 1
Data yang dihapus:
NIM: 254107020112 | Nama: Budi | Kelas: TI-1E | IPK: 3.78

Pilih menu: 5
NIM: 254107020111 | Nama: Anton | Kelas: TI-1E | IPK: 3.57
NIM: 254107020113 | Nama: Citra | Kelas: TI-1E | IPK: 3.34
NIM: 254107020114 | Nama: Dewi | Kelas: TI-1E | IPK: 3.95

Pilih menu: 6
NIM: 254107020114 | Nama: Dewi | Kelas: TI-1E | IPK: 3.95
NIM: 254107020113 | Nama: Citra | Kelas: TI-1E | IPK: 3.34
NIM: 254107020111 | Nama: Anton | Kelas: TI-1E | IPK: 3.57

Pilih menu: 14
Jumlah data dalam linked list: 3
```

---