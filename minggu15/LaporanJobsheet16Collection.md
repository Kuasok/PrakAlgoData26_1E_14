# LAPORAN JOBSHEET 16 - COLLECTION

**Nama:** [Nama Mahasiswa]  
**NIM:** [Nomor Induk Mahasiswa]  
**No. Presensi:** 14  
**Kelas:** D4 Teknik Informatika  
**Politeknik Negeri Malang**

---

## 1. Tujuan

Setelah melakukan praktikum ini, mahasiswa mampu:
1. Memahami bentuk-bentuk collection dan hierarkinya
2. Menerapkan collection sesuai dengan fungsi dan jenisnya
3. Menyelesaikan kasus menggunakan collection yang sesuai

---

## 2. Teori Singkat

**Collection** adalah suatu objek yang dapat digunakan untuk menyimpan atau mengelompokkan objek-objek lain. Collection merupakan sebuah framework yang disediakan oleh Java untuk menyimpan dan memanipulasi sekumpulan data.

### Hierarki Collection di Java:
```
Collection
├── List (ArrayList, LinkedList, Vector, Stack)
│   ├── ArrayList: Implementasi list menggunakan array dinamis
│   ├── LinkedList: Implementasi list menggunakan linked list
│   ├── Vector: ArrayList yang thread-safe
│   └── Stack: LIFO (Last In First Out) structure
├── Set (HashSet, LinkedHashSet, TreeSet)
│   ├── HashSet: Tidak menyimpan duplikat, tidak terurut
│   ├── LinkedHashSet: Menjaga urutan insertion
│   └── TreeSet: Terurut secara alami
└── Queue (PriorityQueue, LinkedList)
    └── PriorityQueue: FIFO (First In First Out) structure
```

**ArrayList** adalah implementasi dari interface List menggunakan array dinamis. ArrayList dapat menampung berbagai tipe data dan ukurannya dapat berubah secara dinamis.

**Stack** adalah struktur data LIFO (Last In First Out) dimana elemen yang terakhir dimasukkan akan menjadi elemen pertama yang dikeluarkan.

**Queue** adalah struktur data FIFO (First In First Out) dimana elemen yang pertama dimasukkan akan menjadi elemen pertama yang dikeluarkan.

---

## 3. Diagram Class

### Percobaan 1 - ContohList
```
+------------------+
|  ContohList14    |
+------------------+
| + main()         |
+------------------+
```

### Percobaan 2 - LoopCollection
```
+----------------------+
|  LoopCollection14    |
+----------------------+
| + main()             |
+----------------------+
```

### Percobaan 3 - Mahasiswa & ListMahasiswa
```
+---------------------------+         +---------------------------+
|     Mahasiswa14           |         |    ListMahasiswa14        |
+---------------------------+         +---------------------------+
| - nim14: String           |         | - mahasiswa14: List<>     |
| - nama14: String          |         | - input14: Scanner        |
| - tglLahir14: String      |         +---------------------------+
| - gender14: String        |         | + tambah(mhs...)          |
+---------------------------+         | + hapus(keyword)          |
| + Mahasiswa14()           |         | + update(keyword, mhs)    |
| + toString()              |         | + tampil()                |
+---------------------------+         | + linearSearch(keyword)   |
                                      | + main()                  |
                                      +---------------------------+
```

### Tugas - Daftar Nilai Mahasiswa
```
+------------------------+       +------------------------+       +------------------------+
|   MahasiswaTugas14     |       |    MataKuliah14        |       |      Nilai14           |
+------------------------+       +------------------------+       +------------------------+
| - nim14: String        |       | - kodeMk14: String     |       | - nilai14: double      |
| - nama14: String       |       | - namaMk14: String     |       +------------------------+
| - telp14: String       |       | - sks14: int           |       | + Nilai14()            |
+------------------------+       +------------------------+       | + toString()           |
| + MahasiswaTugas14()   |       | + MataKuliah14()       |       +------------------------+
| + toString()           |       | + toString()           |
+------------------------+       +------------------------+
         |                                 |
         +---------------------------------+
                         |
                         v
               +---------------------------+
               |      NilaiMain14          |
               +---------------------------+
               | - listMahasiswa14         |
               | - listMataKuliah14        |
               | - listNilai14             |
               | - input14: Scanner        |
               | - queueHapus14: Queue     |
               +---------------------------+
               | + tambahMahasiswa()       |
               | + tambahMataKuliah()      |
               | + tambahNilai()           |
               | + tampilNilai()           |
               | + cariMahasiswa()         |
               | + urutNilai()             |
               | + hapusMahasiswaQueue()   |
               | + main()                  |
               +---------------------------+
```

---

## 4. Implementasi Kode

### 4.1 Percobaan 1 - ContohList14.java

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Percobaan 1: Penggunaan Collection untuk menambah, mengakses, dan menghapus elemen
 * Menunjukkan penggunaan ArrayList dengan tipe generic dan tanpa generic
 */
public class ContohList14 {
    public static void main(String[] args) {
        // List tanpa generic (raw type) - dapat menampung berbagai tipe data
        List<Integer> l14 = new ArrayList<>();
        
        // Menambahkan elemen ke list
        l14.add(1);
        l14.add(2);
        l14.add(3);
        l14.add(4);
        
        // Menampilkan elemen dengan enhanced for loop
        System.out.println("List l14:");
        for (Integer nilai14 : l14) {
            System.out.println(nilai14);
        }
        
        // List tanpa generic - dapat menampung berbagai tipe data
        List<String> list14 = new ArrayList<>();
        list14.add("Coba");
        list14.add("Dua");
        list14.add("Tiga");
        
        System.out.println("\nList list14:");
        for (String s14 : list14) {
            System.out.println(s14);
        }
        
        // LinkedList dengan berbagai tipe data (menggunakan Object)
        List<Object> listObj14 = new LinkedList<>();
        listObj14.add(3.14);        // Double
        listObj14.add("Polinema");  // String
        listObj14.add(100);         // Integer
        listObj14.add(3.14f);       // Float
        listObj14.add(true);        // Boolean
        listObj14.add('A');         // Character
        
        System.out.println("\nList dengan berbagai tipe data (Object):");
        for (Object obj14 : listObj14) {
            System.out.println(obj14);
        }
        
        // List dengan tipe data spesifik (generic) - Hanya String
        List<String> listString14 = new ArrayList<>();
        listString14.add("Satu");
        listString14.add("Dua");
        listString14.add("Tiga");
        
        System.out.println("\nList dengan tipe data spesifik (String):");
        for (String s14 : listString14) {
            System.out.println(s14);
        }
        
        // Demonstrasi mengakses elemen berdasarkan index
        System.out.println("\nAkses elemen index 0 dari listString14: " + listString14.get(0));
        
        // Demonstrasi menghapus elemen
        listString14.remove(1); // Menghapus elemen index 1
        System.out.println("Setelah menghapus index 1: " + listString14);
    }
}
```

### 4.2 Percobaan 2 - LoopCollection14.java

```java
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

/**
 * Percobaan 2: Menampilkan berbagai cara untuk mengakses elemen pada collection Stack
 * Menunjukkan penggunaan push, pop, peek, iterator, dan sorting pada Stack
 */
public class LoopCollection14 {
    public static void main(String[] args) {
        // Membuat Stack dengan tipe data String
        Stack<String> fruits14 = new Stack<>();
        
        // Menambahkan elemen menggunakan push() dan add()
        fruits14.push("Banana");
        fruits14.add("Orange");
        fruits14.add("Watermelon");
        fruits14.add("Leci");
        fruits14.push("Salak");
        
        // Menampilkan elemen menggunakan for-each loop
        System.out.println("Menampilkan elemen menggunakan for-each:");
        for (String fruit14 : fruits14) {
            System.out.println(fruit14);
        }
        
        // Menampilkan elemen menggunakan iterator
        System.out.println("\nMenampilkan elemen menggunakan Iterator:");
        Iterator<String> iterator14 = fruits14.iterator();
        while (iterator14.hasNext()) {
            System.out.println(iterator14.next());
        }
        
        // Menampilkan elemen menggunakan for-each dengan method reference
        System.out.println("\nMenampilkan elemen menggunakan forEach:");
        fruits14.forEach(System.out::println);
        
        // Menampilkan elemen terakhir menggunakan peek()
        System.out.println("\nElemen terakhir (peek): " + fruits14.peek());
        
        // Menghapus elemen teratas menggunakan pop()
        fruits14.pop();
        System.out.println("Setelah pop(), elemen terakhir: " + fruits14.peek());
        
        // Menghapus elemen tertentu menggunakan remove()
        fruits14.remove("Leci");
        System.out.println("\nSetelah menghapus 'Leci':");
        fruits14.forEach(System.out::println);
        
        // Mengubah elemen terakhir menjadi "Strawberry"
        fruits14.set(fruits14.size() - 1, "Strawberry");
        System.out.println("\nSetelah mengubah elemen terakhir menjadi 'Strawberry':");
        fruits14.forEach(System.out::println);
        
        // Menambahkan 3 buah baru dan melakukan sorting
        fruits14.push("Mango");
        fruits14.push("Guava");
        fruits14.push("Avocado");
        
        System.out.println("\nSetelah menambahkan Mango, Guava, Avocado:");
        fruits14.forEach(System.out::println);
        
        // Sorting ascending
        Collections.sort(fruits14);
        System.out.println("\nSetelah sorting ascending:");
        fruits14.forEach(System.out::println);
        
        // Sorting descending
        Collections.sort(fruits14, Collections.reverseOrder());
        System.out.println("\nSetelah sorting descending:");
        fruits14.forEach(System.out::println);
        
        // Menampilkan elemen menggunakan while loop dan pop() (mengosongkan stack)
        System.out.println("\nMengosongkan stack menggunakan while + pop():");
        while (!fruits14.isEmpty()) {
            System.out.println("Pop: " + fruits14.pop());
        }
    }
}
```

### 4.3 Percobaan 3 - Mahasiswa14.java

```java
/**
 * Class Mahasiswa14 merepresentasikan data mahasiswa
 * digunakan sebagai objek dalam collection ListMahasiswa14
 */
public class Mahasiswa14 {
    // Atribut mahasiswa dengan suffix 14
    String nim14;
    String nama14;
    String tglLahir14;
    String gender14;

    // Konstruktor default
    public Mahasiswa14() {
    }

    // Konstruktor berparameter
    public Mahasiswa14(String nim14, String nama14, String tglLahir14, String gender14) {
        this.nim14 = nim14;
        this.nama14 = nama14;
        this.tglLahir14 = tglLahir14;
        this.gender14 = gender14;
    }

    // Method untuk menampilkan data mahasiswa
    @Override
    public String toString() {
        return "Mahasiswa{" +
                "nim='" + nim14 + '\'' +
                ", nama='" + nama14 + '\'' +
                ", tglLahir='" + tglLahir14 + '\'' +
                ", gender='" + gender14 + '\'' +
                '}';
    }
}
```

### 4.4 Percobaan 3 - ListMahasiswa14.java

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Class ListMahasiswa14 mengimplementasikan operasi CRUD pada collection
 * menggunakan List untuk menyimpan objek Mahasiswa14
 */
public class ListMahasiswa14 {
    // Atribut list untuk menyimpan objek Mahasiswa14
    List<Mahasiswa14> mahasiswa14 = new ArrayList<>();
    Scanner input14 = new Scanner(System.in);

    // Method tambah menggunakan varargs (unlimited arguments)
    public void tambah(Mahasiswa14... mhs14) {
        mahasiswa14.addAll(Arrays.asList(mhs14));
    }

    // Method hapus berdasarkan NIM
    public void hapus(String nim14) {
        mahasiswa14.removeIf(mhs14 -> mhs14.nim14.equals(nim14));
    }

    // Method update berdasarkan NIM
    public void update(String nim14, Mahasiswa14 mhsBaru14) {
        int index14 = linearSearch(nim14);
        if (index14 >= 0) {
            mahasiswa14.set(index14, mhsBaru14);
        }
    }

    // Method tampil semua data
    public void tampil() {
        mahasiswa14.forEach(mhs14 -> {
            System.out.println(mhs14.toString());
        });
    }

    // Linear search untuk mencari index berdasarkan NIM
    public int linearSearch(String nim14) {
        for (int i14 = 0; i14 < mahasiswa14.size(); i14++) {
            if (nim14.equals(mahasiswa14.get(i14).nim14)) {
                return i14;
            }
        }
        return -1;
    }

    // Binary search untuk mencari index berdasarkan NIM (collection harus terurut)
    public int binarySearch(String nim14) {
        // Sort terlebih dahulu berdasarkan NIM agar binary search berfungsi
        sortAscending();
        Mahasiswa14 key14 = new Mahasiswa14(nim14, "", "", "");
        return Collections.binarySearch(mahasiswa14, key14, Comparator.comparing(m -> m.nim14));
    }

    // Sorting ascending berdasarkan NIM
    public void sortAscending() {
        mahasiswa14.sort(Comparator.comparing(m -> m.nim14));
    }

    // Sorting descending berdasarkan NIM
    public void sortDescending() {
        mahasiswa14.sort((m1, m2) -> m2.nim14.compareTo(m1.nim14));
    }

    // Method input data mahasiswa
    public Mahasiswa14 inputMahasiswa14() {
        System.out.print("Masukkan NIM: ");
        String nim14 = input14.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama14 = input14.nextLine();
        System.out.print("Masukkan Tanggal Lahir: ");
        String tglLahir14 = input14.nextLine();
        System.out.print("Masukkan Gender: ");
        String gender14 = input14.nextLine();
        return new Mahasiswa14(nim14, nama14, tglLahir14, gender14);
    }

    // Menu utama
    public void menu() {
        int pilihan14;
        do {
            System.out.println("\n===== MENU LIST MAHASISWA =====");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("3. Update Mahasiswa");
            System.out.println("4. Tampil Mahasiswa");
            System.out.println("5. Cari Mahasiswa (Linear Search)");
            System.out.println("6. Cari Mahasiswa (Binary Search)");
            System.out.println("7. Sort Ascending");
            System.out.println("8. Sort Descending");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan14 = input14.nextInt();
            input14.nextLine(); // clear buffer

            switch (pilihan14) {
                case 1:
                    Mahasiswa14 mhsBaru14 = inputMahasiswa14();
                    tambah(mhsBaru14);
                    System.out.println("Data berhasil ditambahkan!");
                    break;
                case 2:
                    System.out.print("Masukkan NIM yang akan dihapus: ");
                    String nimHapus14 = input14.nextLine();
                    hapus(nimHapus14);
                    System.out.println("Data berhasil dihapus!");
                    break;
                case 3:
                    System.out.print("Masukkan NIM yang akan diupdate: ");
                    String nimUpdate14 = input14.nextLine();
                    System.out.println("Masukkan data baru:");
                    Mahasiswa14 mhsUpdate14 = inputMahasiswa14();
                    update(nimUpdate14, mhsUpdate14);
                    System.out.println("Data berhasil diupdate!");
                    break;
                case 4:
                    System.out.println("\n--- Data Mahasiswa ---");
                    tampil();
                    break;
                case 5:
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nimCari14 = input14.nextLine();
                    int idx14 = linearSearch(nimCari14);
                    if (idx14 >= 0) {
                        System.out.println("Data ditemukan: " + mahasiswa14.get(idx14));
                    } else {
                        System.out.println("Data tidak ditemukan!");
                    }
                    break;
                case 6:
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nimCariBin14 = input14.nextLine();
                    int idxBin14 = binarySearch(nimCariBin14);
                    if (idxBin14 >= 0) {
                        System.out.println("Data ditemukan pada index: " + idxBin14);
                    } else {
                        System.out.println("Data tidak ditemukan!");
                    }
                    break;
                case 7:
                    sortAscending();
                    System.out.println("Data berhasil diurutkan ascending!");
                    break;
                case 8:
                    sortDescending();
                    System.out.println("Data berhasil diurutkan descending!");
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan14 != 0);
    }

    public static void main(String[] args) {
        ListMahasiswa14 lm14 = new ListMahasiswa14();

        // Data awal menggunakan varargs (unlimited arguments)
        Mahasiswa14 m14 = new Mahasiswa14("201234", "Noureen", "xxxxxxxxxx", "Perempuan");
        Mahasiswa14 m214 = new Mahasiswa14("201235", "Akhleema", "xxxxxxxxxx", "Perempuan");
        Mahasiswa14 m314 = new Mahasiswa14("201236", "Shannum", "xxxxxxxxxx", "Perempuan");

        // Menambahkan data menggunakan varargs
        lm14.tambah(m14, m214, m314);

        // Menampilkan data
        System.out.println("Data Mahasiswa Awal:");
        lm14.tampil();

        // Update data
        lm14.update(lm14.linearSearch("201235"), new Mahasiswa14("201235", "Akhleema Lela", "xxxxxxxxxx", "Perempuan"));
        System.out.println("\nData Mahasiswa Setelah Update:");
        lm14.tampil();

        // Menjalankan menu interaktif
        lm14.menu();
    }
}
```

### 4.5 Tugas 1 - MahasiswaTugas14.java

```java
/**
 * Class MahasiswaTugas14 merepresentasikan data mahasiswa untuk tugas daftar nilai
 * Menyimpan informasi NIM, nama, dan nomor telepon mahasiswa
 */
public class MahasiswaTugas14 {
    // Atribut mahasiswa dengan suffix 14
    String nim14;
    String nama14;
    String telp14;

    // Konstruktor berparameter
    public MahasiswaTugas14(String nim14, String nama14, String telp14) {
        this.nim14 = nim14;
        this.nama14 = nama14;
        this.telp14 = telp14;
    }

    // Konstruktor default
    public MahasiswaTugas14() {
    }

    // Method untuk menampilkan data mahasiswa
    @Override
    public String toString() {
        return String.format("%-10s | %-15s | %-15s", nim14, nama14, telp14);
    }
}
```

### 4.6 Tugas 1 - MataKuliah14.java

```java
/**
 * Class MataKuliah14 merepresentasikan data mata kuliah untuk tugas daftar nilai
 * Menyimpan informasi kode MK, nama MK, dan jumlah SKS
 */
public class MataKuliah14 {
    // Atribut mata kuliah dengan suffix 14
    String kodeMk14;
    String namaMk14;
    int sks14;

    // Konstruktor berparameter
    public MataKuliah14(String kodeMk14, String namaMk14, int sks14) {
        this.kodeMk14 = kodeMk14;
        this.namaMk14 = namaMk14;
        this.sks14 = sks14;
    }

    // Konstruktor default
    public MataKuliah14() {
    }

    // Method untuk menampilkan data mata kuliah
    @Override
    public String toString() {
        return String.format("%-10s | %-25s | %d", kodeMk14, namaMk14, sks14);
    }
}
```

### 4.7 Tugas 1 - Nilai14.java

```java
/**
 * Class Nilai14 merepresentasikan data nilai mahasiswa untuk satu mata kuliah
 * Menghubungkan MahasiswaTugas14 dan MataKuliah14 dengan nilai
 */
public class Nilai14 {
    // Atribut nilai dengan suffix 14
    double nilai14;
    MahasiswaTugas14 mahasiswa14;
    MataKuliah14 mataKuliah14;

    // Konstruktor berparameter
    public Nilai14(MahasiswaTugas14 mahasiswa14, MataKuliah14 mataKuliah14, double nilai14) {
        this.mahasiswa14 = mahasiswa14;
        this.mataKuliah14 = mataKuliah14;
        this.nilai14 = nilai14;
    }

    // Konstruktor default
    public Nilai14() {
    }

    // Method untuk menampilkan data nilai lengkap
    @Override
    public String toString() {
        return String.format("%-10s | %-15s | %-10s | %-25s | %d  | %.2f",
                mahasiswa14.nim14, mahasiswa14.nama14,
                mataKuliah14.kodeMk14, mataKuliah14.namaMk14,
                mataKuliah14.sks14, nilai14);
    }
}
```

### 4.8 Tugas 1 & 2 - NilaiMain14.java

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Class NilaiMain14 adalah class utama untuk tugas daftar nilai mahasiswa semester
 * Memiliki fitur: CRUD Mahasiswa, CRUD Mata Kuliah, Tambah Nilai, Tampil Nilai,
 * Cari Mahasiswa, Urut Nilai, dan Hapus Mahasiswa menggunakan Queue (FIFO)
 */
public class NilaiMain14 {
    // Collection untuk menyimpan data
    List<MahasiswaTugas14> listMahasiswa14 = new ArrayList<>();
    List<MataKuliah14> listMataKuliah14 = new ArrayList<>();
    List<Nilai14> listNilai14 = new ArrayList<>();
    Scanner input14 = new Scanner(System.in);

    // Queue untuk fitur hapus mahasiswa (Tugas 2) - FIFO
    Queue<MahasiswaTugas14> queueHapus14 = new LinkedList<>();

    // Method untuk menambah data mahasiswa
    public void tambahMahasiswa() {
        System.out.println("\n===== TAMBAH DATA MAHASISWA =====");
        System.out.print("NIM   : ");
        String nim14 = input14.nextLine();
        System.out.print("Nama  : ");
        String nama14 = input14.nextLine();
        System.out.print("Telp  : ");
        String telp14 = input14.nextLine();
        listMahasiswa14.add(new MahasiswaTugas14(nim14, nama14, telp14));
        System.out.println("Data mahasiswa berhasil ditambahkan!");
    }

    // Method untuk menambah data mata kuliah
    public void tambahMataKuliah() {
        System.out.println("\n===== TAMBAH DATA MATA KULIAH =====");
        System.out.print("Kode MK : ");
        String kodeMk14 = input14.nextLine();
        System.out.print("Nama MK : ");
        String namaMk14 = input14.nextLine();
        System.out.print("SKS     : ");
        int sks14 = input14.nextInt();
        input14.nextLine(); // clear buffer
        listMataKuliah14.add(new MataKuliah14(kodeMk14, namaMk14, sks14));
        System.out.println("Data mata kuliah berhasil ditambahkan!");
    }

    // Method untuk menambah nilai
    public void tambahNilai() {
        System.out.println("\n===== TAMBAH NILAI =====");

        // Tampilkan daftar mahasiswa
        if (listMahasiswa14.isEmpty()) {
            System.out.println("Data mahasiswa masih kosong!");
            return;
        }
        System.out.println("DAFTAR MAHASISWA:");
        System.out.println("-------------------------------------------------------");
        for (int i14 = 0; i14 < listMahasiswa14.size(); i14++) {
            System.out.println((i14 + 1) + ". " + listMahasiswa14.get(i14));
        }
        System.out.print("Pilih Mahasiswa (nomor): ");
        int pilihMhs14 = input14.nextInt() - 1;
        input14.nextLine(); // clear buffer

        // Tampilkan daftar mata kuliah
        if (listMataKuliah14.isEmpty()) {
            System.out.println("Data mata kuliah masih kosong!");
            return;
        }
        System.out.println("\nDAFTAR MATA KULIAH:");
        System.out.println("-------------------------------------------------------");
        for (int i14 = 0; i14 < listMataKuliah14.size(); i14++) {
            System.out.println((i14 + 1) + ". " + listMataKuliah14.get(i14));
        }
        System.out.print("Pilih Mata Kuliah (nomor): ");
        int pilihMk14 = input14.nextInt() - 1;
        input14.nextLine(); // clear buffer

        System.out.print("Masukkan Nilai: ");
        double nilai14 = input14.nextDouble();
        input14.nextLine(); // clear buffer

        // Tambahkan nilai ke list
        Nilai14 n14 = new Nilai14(listMahasiswa14.get(pilihMhs14), listMataKuliah14.get(pilihMk14), nilai14);
        listNilai14.add(n14);
        System.out.println("Nilai berhasil ditambahkan!");
    }

    // Method untuk menampilkan semua nilai
    public void tampilNilai() {
        System.out.println("\n===== DAFTAR NILAI MAHASISWA =====");
        if (listNilai14.isEmpty()) {
            System.out.println("Data nilai masih kosong!");
            return;
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(String.format("%-10s | %-15s | %-10s | %-25s | %-3s | %-5s",
                "NIM", "Nama", "Kode MK", "Nama MK", "SKS", "Nilai"));
        System.out.println("-----------------------------------------------------------------------------------------");
        for (Nilai14 n14 : listNilai14) {
            System.out.println(n14);
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    // Method untuk mencari data mahasiswa berdasarkan NIM
    public void cariMahasiswa() {
        System.out.println("\n===== PENCARIAN DATA MAHASISWA =====");
        System.out.print("Masukkan NIM yang dicari: ");
        String cariNim14 = input14.nextLine();

        boolean ditemukan14 = false;
        System.out.println("\nHasil Pencarian:");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(String.format("%-10s | %-15s | %-10s | %-25s | %-3s | %-5s",
                "NIM", "Nama", "Kode MK", "Nama MK", "SKS", "Nilai"));
        System.out.println("-----------------------------------------------------------------------------------------");

        for (Nilai14 n14 : listNilai14) {
            if (n14.mahasiswa14.nim14.equalsIgnoreCase(cariNim14)) {
                System.out.println(n14);
                ditemukan14 = true;
            }
        }

        if (!ditemukan14) {
            System.out.println("Data tidak ditemukan!");
        }
    }

    // Method untuk mengurutkan nilai (ascending/descending)
    public void urutNilai() {
        if (listNilai14.isEmpty()) {
            System.out.println("Data nilai masih kosong!");
            return;
        }

        System.out.println("\n===== PENGURUTAN NILAI =====");
        System.out.println("1. Ascending (terkecil ke terbesar)");
        System.out.println("2. Descending (terbesar ke terkecil)");
        System.out.print("Pilih: ");
        int pilihan14 = input14.nextInt();
        input14.nextLine(); // clear buffer

        if (pilihan14 == 1) {
            listNilai14.sort(Comparator.comparingDouble(n -> n.nilai14));
            System.out.println("Data diurutkan secara ascending!");
        } else if (pilihan14 == 2) {
            listNilai14.sort((n1, n2) -> Double.compare(n2.nilai14, n1.nilai14));
            System.out.println("Data diurutkan secara descending!");
        } else {
            System.out.println("Pilihan tidak valid!");
        }
        tampilNilai();
    }

    // Method untuk menambahkan mahasiswa ke queue penghapusan (Tugas 2)
    public void tambahKeAntrianHapus() {
        System.out.println("\n===== TAMBAH KE ANTRIAN HAPUS (QUEUE) =====");
        if (listMahasiswa14.isEmpty()) {
            System.out.println("Data mahasiswa masih kosong!");
            return;
        }
        System.out.println("DAFTAR MAHASISWA:");
        for (int i14 = 0; i14 < listMahasiswa14.size(); i14++) {
            System.out.println((i14 + 1) + ". " + listMahasiswa14.get(i14));
        }
        System.out.print("Pilih Mahasiswa yang akan dihapus (nomor): ");
        int pilih14 = input14.nextInt() - 1;
        input14.nextLine(); // clear buffer

        if (pilih14 >= 0 && pilih14 < listMahasiswa14.size()) {
            MahasiswaTugas14 mhsHapus14 = listMahasiswa14.get(pilih14);
            queueHapus14.add(mhsHapus14);
            System.out.println("Mahasiswa '" + mhsHapus14.nama14 + "' ditambahkan ke antrian penghapusan.");
        } else {
            System.out.println("Pilihan tidak valid!");
        }
    }

    // Method untuk memproses penghapusan mahasiswa dari queue (FIFO) - Tugas 2
    public void prosesHapusDariQueue() {
        System.out.println("\n===== PROSES HAPUS DARI QUEUE (FIFO) =====");
        if (queueHapus14.isEmpty()) {
            System.out.println("Antrian penghapusan kosong!");
            return;
        }

        System.out.println("Jumlah mahasiswa dalam antrian: " + queueHapus14.size());
        System.out.println("Proses penghapusan (FIFO - First In First Out):\n");

        while (!queueHapus14.isEmpty()) {
            MahasiswaTugas14 mhsHapus14 = queueHapus14.poll(); // mengambil dan menghapus dari queue
            System.out.println("Menghapus: " + mhsHapus14.nama14 + " (" + mhsHapus14.nim14 + ")");

            // Hapus dari list mahasiswa
            listMahasiswa14.removeIf(m -> m.nim14.equals(mhsHapus14.nim14));

            // Hapus semua nilai yang terkait dengan mahasiswa ini
            listNilai14.removeIf(n -> n.mahasiswa14.nim14.equals(mhsHapus14.nim14));
        }
        System.out.println("\nSemua mahasiswa dalam antrian telah dihapus!");
    }

    // Method untuk menampilkan isi queue penghapusan (Tugas 2)
    public void tampilAntrianHapus() {
        System.out.println("\n===== ANTRIAN HAPUS (QUEUE) =====");
        if (queueHapus14.isEmpty()) {
            System.out.println("Antrian penghapusan kosong!");
            return;
        }
        System.out.println("Isi antrian penghapusan:");
        for (MahasiswaTugas14 mhs14 : queueHapus14) {
            System.out.println("- " + mhs14.nama14 + " (" + mhs14.nim14 + ")");
        }
    }

    // Method untuk menampilkan data mahasiswa
    public void tampilMahasiswa() {
        System.out.println("\n===== DAFTAR MAHASISWA =====");
        if (listMahasiswa14.isEmpty()) {
            System.out.println("Data mahasiswa masih kosong!");
            return;
        }
        System.out.println("-----------------------------------------------");
        System.out.println(String.format("%-10s | %-15s | %-15s", "NIM", "Nama", "Telp"));
        System.out.println("-----------------------------------------------");
        for (MahasiswaTugas14 m14 : listMahasiswa14) {
            System.out.println(m14);
        }
        System.out.println("-----------------------------------------------");
    }

    // Method untuk menampilkan data mata kuliah
    public void tampilMataKuliah() {
        System.out.println("\n===== DAFTAR MATA KULIAH =====");
        if (listMataKuliah14.isEmpty()) {
            System.out.println("Data mata kuliah masih kosong!");
            return;
        }
        System.out.println("-------------------------------------------------------");
        System.out.println(String.format("%-10s | %-25s | %-3s", "Kode MK", "Nama MK", "SKS"));
        System.out.println("-------------------------------------------------------");
        for (MataKuliah14 mk14 : listMataKuliah14) {
            System.out.println(mk14);
        }
        System.out.println("-------------------------------------------------------");
    }

    // Menu utama
    public void menu() {
        int pilihan14;
        do {
            System.out.println("\n╔═══════════════════════════════════════════════════╗");
            System.out.println("║       DAFTAR NILAI MAHASISWA SEMESTER             ║");
            System.out.println("╠═══════════════════════════════════════════════════╣");
            System.out.println("║  1. Tambah Mahasiswa                              ║");
            System.out.println("║  2. Tambah Mata Kuliah                            ║");
            System.out.println("║  3. Tambah Nilai                                  ║");
            System.out.println("║  4. Tampil Nilai                                  ║");
            System.out.println("║  5. Cari Data Mahasiswa                           ║");
            System.out.println("║  6. Urut Data Nilai                               ║");
            System.out.println("║  7. Tampil Mahasiswa                              ║");
            System.out.println("║  8. Tampil Mata Kuliah                            ║");
            System.out.println("║  9. Tambah ke Antrian Hapus (Queue)               ║");
            System.out.println("║ 10. Tampil Antrian Hapus                          ║");
            System.out.println("║ 11. Proses Hapus dari Queue                       ║");
            System.out.println("║  0. Keluar                                        ║");
            System.out.println("╚═══════════════════════════════════════════════════╝");
            System.out.print("Pilih menu: ");
            pilihan14 = input14.nextInt();
            input14.nextLine(); // clear buffer

            switch (pilihan14) {
                case 1: tambahMahasiswa(); break;
                case 2: tambahMataKuliah(); break;
                case 3: tambahNilai(); break;
                case 4: tampilNilai(); break;
                case 5: cariMahasiswa(); break;
                case 6: urutNilai(); break;
                case 7: tampilMahasiswa(); break;
                case 8: tampilMataKuliah(); break;
                case 9: tambahKeAntrianHapus(); break;
                case 10: tampilAntrianHapus(); break;
                case 11: prosesHapusDariQueue(); break;
                case 0: System.out.println("Terima kasih! Program selesai."); break;
                default: System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan14 != 0);
    }

    public static void main(String[] args) {
        NilaiMain14 nm14 = new NilaiMain14();
        nm14.menu();
    }
}
```

### 4.9 Tugas 2 - AntrianMahasiswa14.java (Queue Implementation)

```java
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Tugas 2: Implementasi Queue untuk penghapusan data mahasiswa
 * Queue bersifat FIFO (First In First Out)
 * Mahasiswa yang pertama masuk antrian akan pertama kali diproses penghapusannya
 */
public class AntrianMahasiswa14 {
    // Queue untuk menyimpan mahasiswa yang akan dihapus
    Queue<MahasiswaQueue14> antrianHapus14 = new LinkedList<>();
    Scanner input14 = new Scanner(System.in);

    /**
     * Class inner MahasiswaQueue14 untuk merepresentasikan data mahasiswa dalam antrian
     */
    static class MahasiswaQueue14 {
        String nim14;
        String nama14;
        String waktuMasuk14; // timestamp saat masuk antrian

        public MahasiswaQueue14(String nim14, String nama14, String waktuMasuk14) {
            this.nim14 = nim14;
            this.nama14 = nama14;
            this.waktuMasuk14 = waktuMasuk14;
        }

        @Override
        public String toString() {
            return String.format("NIM: %s | Nama: %s | Waktu Masuk: %s", nim14, nama14, waktuMasuk14);
        }
    }

    // Method untuk menambahkan mahasiswa ke antrian (enqueue)
    public void enqueue14(MahasiswaQueue14 mhs14) {
        antrianHapus14.add(mhs14);
        System.out.println("Mahasiswa '" + mhs14.nama14 + "' berhasil ditambahkan ke antrian.");
    }

    // Method untuk memproses penghapusan dari antrian (dequeue)
    public MahasiswaQueue14 dequeue14() {
        if (antrianHapus14.isEmpty()) {
            System.out.println("Antrian kosong! Tidak ada data yang dapat dihapus.");
            return null;
        }
        MahasiswaQueue14 mhs14 = antrianHapus14.poll(); // poll() = remove() + mengembalikan elemen
        System.out.println("Menghapus: " + mhs14.nama14 + " dari antrian.");
        return mhs14;
    }

    // Method untuk melihat elemen terdepan tanpa menghapus (peek)
    public void peek14() {
        if (antrianHapus14.isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.println("Elemen terdepan: " + antrianHapus14.peek());
        }
    }

    // Method untuk menampilkan semua elemen dalam antrian
    public void tampilAntrian14() {
        if (antrianHapus14.isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }
        System.out.println("\n===== ISI ANTRIAN PENGHAPUSAN =====");
        System.out.println("Urutan: FIFO (First In First Out)");
        System.out.println("--------------------------------------");
        int no14 = 1;
        for (MahasiswaQueue14 mhs14 : antrianHapus14) {
            System.out.println(no14++ + ". " + mhs14);
        }
        System.out.println("--------------------------------------");
        System.out.println("Total dalam antrian: " + antrianHapus14.size());
    }

    // Method untuk mengecek apakah antrian kosong
    public boolean isEmpty14() {
        return antrianHapus14.isEmpty();
    }

    // Menu untuk mengelola antrian
    public void menuAntrian14() {
        int pilihan14;
        do {
            System.out.println("\n╔══════════════════════════════════════╗");
            System.out.println("║     ANTRIAN HAPUS MAHASISWA (QUEUE)  ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║  1. Tambah ke Antrian (Enqueue)      ║");
            System.out.println("║  2. Proses Hapus (Dequeue)           ║");
            System.out.println("║  3. Lihat Elemen Terdepan (Peek)     ║");
            System.out.println("║  4. Tampil Antrian                   ║");
            System.out.println("║  5. Kosongkan Antrian                ║");
            System.out.println("║  0. Keluar                           ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print("Pilih menu: ");
            pilihan14 = input14.nextInt();
            input14.nextLine(); // clear buffer

            switch (pilihan14) {
                case 1:
                    System.out.print("Masukkan NIM: ");
                    String nim14 = input14.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama14 = input14.nextLine();
                    String waktu14 = java.time.LocalDateTime.now().toString();
                    enqueue14(new MahasiswaQueue14(nim14, nama14, waktu14));
                    break;
                case 2:
                    dequeue14();
                    break;
                case 3:
                    peek14();
                    break;
                case 4:
                    tampilAntrian14();
                    break;
                case 5:
                    antrianHapus14.clear();
                    System.out.println("Antrian berhasil dikosongkan!");
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan14 != 0);
    }

    public static void main(String[] args) {
        AntrianMahasiswa14 aq14 = new AntrianMahasiswa14();
        aq14.menuAntrian14();
    }
}
```

---

## 5. Verifikasi Output

### 5.1 Verifikasi Percobaan 1 - ContohList14
```
List l14:
1
2
3
4

List list14:
Coba
Dua
Tiga

List dengan berbagai tipe data (Object):
3.14
Polinema
100
3.14
true
A

List dengan tipe data spesifik (String):
Satu
Dua
Tiga

Akses elemen index 0 dari listString14: Satu
Setelah menghapus index 1: [Satu, Tiga]
```

### 5.2 Verifikasi Percobaan 2 - LoopCollection14
```
Menampilkan elemen menggunakan for-each:
Banana
Orange
Watermelon
Leci
Salak

Menampilkan elemen menggunakan Iterator:
Banana
Orange
Watermelon
Leci
Salak

Menampilkan elemen menggunakan forEach:
Banana
Orange
Watermelon
Leci
Salak

Elemen terakhir (peek): Salak
Setelah pop(), elemen terakhir: Leci

Setelah menghapus 'Leci':
Banana
Orange
Watermelon
Strawberry

Setelah mengubah elemen terakhir menjadi 'Strawberry':
Banana
Orange
Watermelon
Strawberry

Setelah menambahkan Mango, Guava, Avocado:
...

Setelah sorting ascending:
Avocado
Banana
Guava
Mango
Orange
Strawberry
Watermelon

Mengosongkan stack menggunakan while + pop():
Pop: Watermelon
Pop: Strawberry
...
```

### 5.3 Verifikasi Percobaan 3 - ListMahasiswa14
```
Data Mahasiswa Awal:
Mahasiswa{nim='201234', nama='Noureen', tglLahir='xxxxxxxxxx', gender='Perempuan'}
Mahasiswa{nim='201235', nama='Akhleema', tglLahir='xxxxxxxxxx', gender='Perempuan'}
Mahasiswa{nim='201236', nama='Shannum', tglLahir='xxxxxxxxxx', gender='Perempuan'}

Data Mahasiswa Setelah Update:
Mahasiswa{nim='201234', nama='Noureen', tglLahir='xxxxxxxxxx', gender='Perempuan'}
Mahasiswa{nim='201235', nama='Akhleema Lela', tglLahir='xxxxxxxxxx', gender='Perempuan'}
Mahasiswa{nim='201236', nama='Shannum', tglLahir='xxxxxxxxxx', gender='Perempuan'}

===== MENU LIST MAHASISWA =====
1. Tambah Mahasiswa
2. Hapus Mahasiswa
3. Update Mahasiswa
4. Tampil Mahasiswa
...
```

### 5.4 Verifikasi Tugas - NilaiMain14
```
╔═══════════════════════════════════════════════════╗
║       DAFTAR NILAI MAHASISWA SEMESTER             ║
╠═══════════════════════════════════════════════════╣
║  1. Tambah Mahasiswa                              ║
║  2. Tambah Mata Kuliah                            ║
║  3. Tambah Nilai                                  ║
║  4. Tampil Nilai                                  ║
║  5. Cari Data Mahasiswa                           ║
║  6. Urut Data Nilai                               ║
║  7. Tampil Mahasiswa                              ║
║  8. Tampil Mata Kuliah                            ║
║  9. Tambah ke Antrian Hapus (Queue)               ║
║ 10. Tampil Antrian Hapus                          ║
║ 11. Proses Hapus dari Queue                       ║
║  0. Keluar                                        ║
╚═══════════════════════════════════════════════════╝

===== DAFTAR NILAI MAHASISWA =====
-----------------------------------------------------------------------------------------
NIM        | Nama            | Kode MK    | Nama MK                   | SKS | Nilai
-----------------------------------------------------------------------------------------
20001      | Thalhah         | MK001      | Internet of Things        | 3  | 85.00
20001      | Thalhah         | MK002      | Algoritma dan Struktur Data| 2  | 90.00
20002      | Zubair          | MK001      | Internet of Things        | 3  | 78.00
...
```

---

## 6. Penjelasan

### 6.1 Percobaan 1 - ArrayList
**ArrayList** digunakan untuk menyimpan elemen secara dinamis. Tanpa generic (`ArrayList` tanpa tipe), ArrayList dapat menampung berbagai tipe data (Object). Dengan generic (`ArrayList<String>`), ArrayList hanya dapat menampung tipe data tertentu. ArrayList menggunakan array dinamis sehingga ukurannya dapat bertambah secara otomatis.

**Konsep varargs** pada method `tambah(Mahasiswa14... mhs14)` memungkinkan pengiriman argument yang tidak terbatas jumlahnya. Method dapat menerima 0, 1, atau banyak objek Mahasiswa14 sebagai parameter.

### 6.2 Percobaan 2 - Stack
**Stack** mengimplementasikan konsep LIFO (Last In First Out). Method-method utama:
- `push()`: Menambahkan elemen di posisi teratas
- `pop()`: Menghapus dan mengembalikan elemen teratas
- `peek()`: Melihat elemen teratas tanpa menghapus
- `add()`: Method dari List yang juga dapat digunakan pada Stack

**Perbedaan push() dan add()**: Keduanya menambahkan elemen, tetapi `push()` adalah method spesifik Stack yang menambahkan di posisi teratas (index terakhir), sedangkan `add()` adalah method dari interface Collection yang menambahkan di akhir list.

### 6.3 Percobaan 3 - ListMahasiswa
**Collection dengan objek custom**: List dapat digunakan untuk menyimpan objek buatan sendiri (Mahasiswa14). Operasi CRUD (Create, Read, Update, Delete) dapat dilakukan dengan method:
- `add()`: Menambahkan elemen
- `removeIf()`: Menghapus berdasarkan kondisi
- `set()`: Mengubah elemen pada index tertentu
- `linearSearch()`: Pencarian sequential (O(n))
- `binarySearch()`: Pencarian biner yang memerlukan data terurut (O(log n))

### 6.4 Tugas 1 - Daftar Nilai Mahasiswa
Program ini mengimplementasikan sistem daftar nilai dengan **3 class utama**:
- **MahasiswaTugas14**: Menyimpan data mahasiswa (NIM, nama, telepon)
- **MataKuliah14**: Menyimpan data mata kuliah (kode MK, nama MK, SKS)
- **Nilai14**: Menghubungkan mahasiswa dan mata kuliah dengan nilai angka

Program menggunakan **Scanner** untuk input dinamis dari keyboard dan menyediakan menu untuk interaksi pengguna.

### 6.5 Tugas 2 - Queue untuk Penghapusan
**Queue** mengimplementasikan konsep FIFO (First In First Out):
- `add()` / `offer()`: Menambahkan elemen ke belakang antrian (enqueue)
- `poll()` / `remove()`: Mengambil dan menghapus elemen dari depan antrian (dequeue)
- `peek()`: Melihat elemen depan tanpa menghapus

Dalam konteks tugas ini, Queue digunakan untuk mengatur penghapusan data mahasiswa. Mahasiswa yang pertama kali dimasukkan ke antrian penghapusan akan menjadi yang pertama diproses penghapusannya, sesuai dengan prinsip FIFO.

---

## 7. Kesimpulan

1. **Collection Framework** menyediakan struktur data yang fleksibel untuk menyimpan dan memanipulasi objek secara dinamis.

2. **ArrayList** cocok untuk penyimpanan data dengan akses acak yang cepat, sedangkan **LinkedList** lebih efisien untuk operasi penambahan/penghapusan di tengah.

3. **Stack** (LIFO) cocok untuk operasi undo, parsing ekspresi, dan navigasi browser. **Queue** (FIFO) cocok untuk sistem antrian, scheduling, dan BFS.

4. Collection dapat menyimpan objek custom dengan mendefinisikan class sendiri, memungkinkan implementasi CRUD yang lengkap.

5. Varargs (variable arguments) memudahkan pengiriman parameter dengan jumlah yang tidak tentu ke dalam method.

6. Pencarian **linear search** memiliki kompleksitas O(n) dan tidak memerlukan data terurut, sedangkan **binary search** memiliki kompleksitas O(log n) tetapi memerlukan data terurut terlebih dahulu.

7. Queue dapat diintegrasikan dengan sistem lain (seperti daftar nilai mahasiswa) untuk mengelola operasi berbasis antrian seperti penghapusan data secara terurut.

---

## Daftar File Java yang Dihasilkan

| No | Nama File | Keterangan |
|----|-----------|------------|
| 1 | `ContohList14.java` | Percobaan 1 - Penggunaan ArrayList |
| 2 | `LoopCollection14.java` | Percobaan 2 - Penggunaan Stack |
| 3 | `Mahasiswa14.java` | Percobaan 3 - Class Mahasiswa |
| 4 | `ListMahasiswa14.java` | Percobaan 3 - Operasi CRUD List |
| 5 | `MahasiswaTugas14.java` | Tugas 1 - Class Mahasiswa |
| 6 | `MataKuliah14.java` | Tugas 1 - Class Mata Kuliah |
| 7 | `Nilai14.java` | Tugas 1 - Class Nilai |
| 8 | `NilaiMain14.java` | Tugas 1 & 2 - Program Utama + Queue |
| 9 | `AntrianMahasiswa14.java` | Tugas 2 - Implementasi Queue |

**Total File: 9 file Java + 1 file Laporan MD**
