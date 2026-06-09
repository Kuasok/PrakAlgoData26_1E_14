# LAPORAN JOBSHEET 14 – TREE

**Nama:** Muhammad Ferdi Afiyanto
**NIM:** 254107020122
**Kelas:** TI-1E

---

## 1. Tujuan Praktikum

Setelah melakukan praktikum ini, mahasiswa mampu:
1. Memahami model Tree khususnya Binary Tree
2. Membuat dan mendeklarasikan struktur algoritma Binary Tree
3. Menerapkan dan mengimplementasikan algoritma Binary Tree dalam kasus Binary Search Tree

---

## 2. Kegiatan Praktikum 1 – Implementasi Binary Search Tree menggunakan Linked List

### 2.1 Langkah-langkah Percobaan

Pada percobaan ini diimplementasikan Binary Search Tree (BST) menggunakan linked list. BST adalah struktur data pohon biner di mana setiap node menyimpan data, dan posisi node ditentukan berdasarkan nilai kuncinya — dalam kasus ini adalah nilai IPK mahasiswa. Node dengan IPK lebih kecil ditempatkan di subtree kiri, sedangkan yang lebih besar di subtree kanan.

Terdapat empat class yang dibuat:
- `Mahasiswa14` — menyimpan data mahasiswa
- `Node14` — merepresentasikan satu node dalam tree
- `BinaryTree14` — mengelola operasi BST (add, find, delete, traverse)
- `BinaryTreeMain14` — class utama untuk menjalankan program

---

### 2.1.1 Kode Class `Mahasiswa14`

```java
public class Mahasiswa14 {
    String nim;
    String nama;
    String kelas;
    double ipk;

    public Mahasiswa14() {
    }

    public Mahasiswa14(String nim, String nama, String kelas, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.ipk = ipk;
    }

    public void tampilInformasi() {
        System.out.println("NIM: " + this.nim + " " +
                "Nama: " + this.nama + " " +
                "Kelas: " + this.kelas + " " +
                "IPK: " + this.ipk);
    }
}
```

---

### 2.1.2 Kode Class `Node14`

```java
public class Node14 {
    Mahasiswa14 mahasiswa;
    Node14 left, right;

    public Node14() {
    }

    public Node14(Mahasiswa14 mahasiswa) {
        this.mahasiswa = mahasiswa;
        left = right = null;
    }
}
```

---

### 2.1.3 Kode Class `BinaryTree14`

```java
public class BinaryTree14 {
    Node14 root;

    public BinaryTree14() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(Mahasiswa14 mahasiswa) {
        Node14 newNode = new Node14(mahasiswa);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node14 current = root;
            Node14 parent = null;
            while (true) {
                parent = current;
                if (mahasiswa.ipk < current.mahasiswa.ipk) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    boolean find(double ipk) {
        boolean result = false;
        Node14 current = root;
        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                result = true;
                break;
            } else if (ipk > current.mahasiswa.ipk) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return result;
    }

    void traversePreOrder(Node14 node) {
        if (node != null) {
            node.mahasiswa.tampilInformasi();
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    void traverseInOrder(Node14 node) {
        if (node != null) {
            traverseInOrder(node.left);
            node.mahasiswa.tampilInformasi();
            traverseInOrder(node.right);
        }
    }

    void traversePostOrder(Node14 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            node.mahasiswa.tampilInformasi();
        }
    }

    Node14 getSuccessor(Node14 del) {
        Node14 successor = del.right;
        Node14 successorParent = del;
        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }
        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    void delete(double ipk) {
        if (isEmpty()) {
            System.out.println("Binary tree kosong");
            return;
        }
        Node14 parent = root;
        Node14 current = root;
        boolean isLeftChild = false;
        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                break;
            } else if (ipk < current.mahasiswa.ipk) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else if (ipk > current.mahasiswa.ipk) {
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }

        if (current == null) {
            System.out.println("Data tidak ditemukan");
            return;
        } else {
            if (current.left == null && current.right == null) {
                if (current == root) {
                    root = null;
                } else {
                    if (isLeftChild) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
            } else if (current.left == null) {
                if (current == root) {
                    root = current.right;
                } else {
                    if (isLeftChild) {
                        parent.left = current.right;
                    } else {
                        parent.right = current.right;
                    }
                }
            } else if (current.right == null) {
                if (current == root) {
                    root = current.left;
                } else {
                    if (isLeftChild) {
                        parent.left = current.left;
                    } else {
                        parent.right = current.left;
                    }
                }
            } else {
                Node14 successor = getSuccessor(current);
                System.out.println("Jika 2 anak, current = ");
                successor.mahasiswa.tampilInformasi();
                if (current == root) {
                    root = successor;
                } else {
                    if (isLeftChild) {
                        parent.left = successor;
                    } else {
                        parent.right = successor;
                    }
                }
                successor.left = current.left;
            }
        }
    }
}
```

---

### 2.1.4 Kode Class `BinaryTreeMain14`

```java
public class BinaryTreeMain14 {
    public static void main(String[] args) {
        BinaryTree14 bst = new BinaryTree14();

        bst.add(new Mahasiswa14(nim:"244160121", nama:"Ali", kelas:"A", ipk:3.57));
        bst.add(new Mahasiswa14(nim:"244160221", nama:"Badar", kelas:"B", ipk:3.85));
        bst.add(new Mahasiswa14(nim:"244160185", nama:"Candra", kelas:"C", ipk:3.21));
        bst.add(new Mahasiswa14(nim:"244160220", nama:"Dewi", kelas:"B", ipk:3.54));

        System.out.println("\nDaftar semua mahasiswa (in oder traversal):");
        bst.traverseInOrder(bst.root);

        System.out.println("\nPencarian data mahasiswa:");
        System.out.print("Cari mahasiswa dengan ipk: 3.54 : ");
        String hasilCari = bst.find(ipk:3.54)?"Ditemukan":"Tidak ditemukan";
        System.out.println(hasilCari);

        System.out.print("Cari mahasiswa dengan ipk: 3.22 : ");
        hasilCari = bst.find(ipk:3.22)?"Ditemukan":"Tidak ditemukan";
        System.out.println(hasilCari);

        bst.add(new Mahasiswa14(nim:"244160131", nama:"Devi", kelas:"A", ipk:3.72));
        bst.add(new Mahasiswa14(nim:"244160205", nama:"Ehsan", kelas:"D", ipk:3.37));
        bst.add(new Mahasiswa14(nim:"244160170", nama:"Fizi", kelas:"B", ipk:3.46));
        System.out.println("\nDaftar semua mahasiswa setelah penambahan 3 mahasiswa:");
        System.out.println("InOrder Traversal:");
        bst.traverseInOrder(bst.root);
        System.out.println("\nPreOrder Traversal:");
        bst.traversePreOrder(bst.root);
        System.out.println("\nPostOrder Traversal:");
        bst.traversePostOrder(bst.root);

        System.out.println("\nPenghapusan data mahasiswa");
        bst.delete(ipk:3.57);
        System.out.println("\nDaftar semua mahasiswa setelah penghapusan 1 mahasiswa (in order traversal):");
        bst.traverseInOrder(bst.root);
    }
}
```

---

### 2.2 Verifikasi Hasil Percobaan 1

```
Daftar semua mahasiswa (in oder traversal):
NIM: 244160185 Nama: Candra Kelas: C IPK: 3.21
NIM: 244160220 Nama: Dewi Kelas: B IPK: 3.54
NIM: 244160121 Nama: Ali Kelas: A IPK: 3.57
NIM: 244160221 Nama: Badar Kelas: B IPK: 3.85

Pencarian data mahasiswa:
Cari mahasiswa dengan ipk: 3.54 : Ditemukan
Cari mahasiswa dengan ipk: 3.22 : Tidak ditemukan

Daftar semua mahasiswa setelah penambahan 3 mahasiswa:
InOrder Traversal:
NIM: 244160185 Nama: Candra Kelas: C IPK: 3.21
NIM: 244160205 Nama: Ehsan Kelas: D IPK: 3.37
NIM: 244160170 Nama: Fizi Kelas: B IPK: 3.46
NIM: 244160220 Nama: Dewi Kelas: B IPK: 3.54
NIM: 244160121 Nama: Ali Kelas: A IPK: 3.57
NIM: 244160131 Nama: Devi Kelas: A IPK: 3.72
NIM: 244160221 Nama: Badar Kelas: B IPK: 3.85

PreOrder Traversal:
NIM: 244160121 Nama: Ali Kelas: A IPK: 3.57
NIM: 244160185 Nama: Candra Kelas: C IPK: 3.21
NIM: 244160205 Nama: Ehsan Kelas: D IPK: 3.37
NIM: 244160170 Nama: Fizi Kelas: B IPK: 3.46
NIM: 244160220 Nama: Dewi Kelas: B IPK: 3.54
NIM: 244160221 Nama: Badar Kelas: B IPK: 3.85
NIM: 244160131 Nama: Devi Kelas: A IPK: 3.72

PostOrder Traversal:
NIM: 244160170 Nama: Fizi Kelas: B IPK: 3.46
NIM: 244160205 Nama: Ehsan Kelas: D IPK: 3.37
NIM: 244160220 Nama: Dewi Kelas: B IPK: 3.54
NIM: 244160185 Nama: Candra Kelas: C IPK: 3.21
NIM: 244160131 Nama: Devi Kelas: A IPK: 3.72
NIM: 244160221 Nama: Badar Kelas: B IPK: 3.85
NIM: 244160121 Nama: Ali Kelas: A IPK: 3.57

Penghapusan data mahasiswa

Daftar semua mahasiswa setelah penghapusan 1 mahasiswa (in order traversal):
NIM: 244160185 Nama: Candra Kelas: C IPK: 3.21
NIM: 244160205 Nama: Ehsan Kelas: D IPK: 3.37
NIM: 244160170 Nama: Fizi Kelas: B IPK: 3.46
NIM: 244160220 Nama: Dewi Kelas: B IPK: 3.54
NIM: 244160131 Nama: Devi Kelas: A IPK: 3.72
NIM: 244160221 Nama: Badar Kelas: B IPK: 3.85
```

---

### 2.3 Pertanyaan Percobaan 1

**1. Mengapa dalam binary search tree proses pencarian data bisa lebih efektif dilakukan dibanding binary tree biasa?**

Pada Binary Search Tree (BST), setiap node memiliki aturan bahwa nilai di subtree kiri selalu lebih kecil dan nilai di subtree kanan selalu lebih besar dari node induknya. Aturan ini membuat pencarian tidak perlu mengunjungi seluruh node — cukup membandingkan nilai yang dicari dengan node saat ini, lalu bergerak ke kiri atau kanan. Kompleksitas pencarian rata-rata adalah O(log n), jauh lebih efisien dibanding binary tree biasa yang tidak memiliki aturan urutan sehingga harus menelusuri semua node dalam kasus terburuk (O(n)).

**2. Untuk apakah di class Node, kegunaan dari atribut left dan right?**

Atribut `left` dan `right` bertipe `Node` yang berfungsi sebagai pointer (referensi) ke node anak kiri dan node anak kanan. Atribut `left` menunjuk ke node yang memiliki nilai IPK lebih kecil, sedangkan `right` menunjuk ke node dengan nilai IPK lebih besar. Keduanya adalah fondasi dari struktur pohon biner yang memungkinkan traversal dan pencarian data secara rekursif maupun iteratif.

**3a. Untuk apakah kegunaan dari atribut root di dalam class BinaryTree?**

Atribut `root` adalah referensi ke node pertama (akar) dari tree. Semua operasi pada tree — seperti add, find, delete, dan traverse — dimulai dari `root`. Tanpa `root`, program tidak dapat mengakses satupun node dalam tree.

**3b. Ketika objek tree pertama kali dibuat, apakah nilai dari root?**

Nilai `root` adalah `null`, yang artinya tree masih kosong dan belum memiliki satu pun node.

**4. Ketika tree masih kosong, dan akan ditambahkan sebuah node baru, proses apa yang akan terjadi?**

Ketika method `add()` dipanggil dan tree masih kosong (`isEmpty()` bernilai `true`), node baru langsung dijadikan sebagai `root`. Tidak ada perbandingan IPK yang dilakukan karena node tersebut adalah satu-satunya node dan sekaligus menjadi akar dari tree.

**5. Jelaskan secara detil untuk apa baris program berikut pada method add():**

```java
parent = current;
if (mahasiswa.ipk < current.mahasiswa.ipk) {
    current = current.left;
    if (current == null) {
        parent.left = newNode;
        return;
    }
} else {
    current = current.right;
    if (current == null) {
        parent.right = newNode;
        return;
    }
}
```

Baris ini adalah inti dari proses pencarian posisi yang tepat untuk node baru:
- `parent = current` menyimpan node saat ini sebagai referensi induk sebelum bergerak ke anak.
- Jika IPK mahasiswa baru lebih kecil dari IPK node saat ini, `current` berpindah ke anak kiri. Jika anak kiri `null`, node baru disisipkan di sana (`parent.left = newNode`).
- Jika IPK mahasiswa baru lebih besar atau sama, `current` berpindah ke anak kanan. Jika anak kanan `null`, node baru disisipkan di sana (`parent.right = newNode`).
- `return` digunakan untuk keluar dari loop setelah node berhasil disisipkan.

**6. Jelaskan langkah-langkah pada method delete() saat menghapus sebuah node yang memiliki dua anak. Bagaimana method getSuccessor() membantu dalam proses ini?**

Langkah-langkah penghapusan node dengan dua anak:
1. Cari node yang akan dihapus beserta parent-nya menggunakan loop.
2. Karena node memiliki dua anak (left dan right keduanya tidak null), tidak bisa langsung dihapus begitu saja karena akan memutus struktur tree.
3. Dipanggil `getSuccessor(current)` untuk mencari **in-order successor**, yaitu node terkecil di subtree kanan dari node yang akan dihapus.
4. Successor menggantikan posisi node yang dihapus: successor disambungkan ke parent node yang dihapus, dan subtree kiri node lama dipindahkan menjadi subtree kiri successor.

Method `getSuccessor()` bekerja dengan cara:
- Mulai dari `del.right` (anak kanan node yang dihapus), terus bergerak ke kiri (`successor.left`) sampai menemukan node paling kiri (nilai terkecil di subtree kanan).
- Jika successor bukan langsung `del.right`, maka `successorParent.left = successor.right` untuk menyambungkan ulang subtree kanan successor ke posisinya, lalu `successor.right = del.right` agar successor mengambil alih subtree kanan node yang dihapus.

---

## 3. Kegiatan Praktikum 2 – Implementasi Binary Tree dengan Array

### 3.1 Langkah-langkah Percobaan

Pada percobaan ini, Binary Tree diimplementasikan menggunakan array. Data tree disimpan langsung dalam array bertipe `Mahasiswa14[]`. Hubungan antar node direpresentasikan secara implisit menggunakan indeks: untuk node pada indeks `i`, anak kirinya berada di indeks `2*i+1` dan anak kanannya di indeks `2*i+2`. Traversal dilakukan secara in-order menggunakan rekursi.

---

### 3.1.1 Kode Class `BinaryTreeArray14`

```java
public class BinaryTreeArray14 {
    Mahasiswa14[] dataMahasiswa;
    int idxLast;

    public BinaryTreeArray14() {
        this.dataMahasiswa = new Mahasiswa14[10];
    }

    void populateData(Mahasiswa14 dataMhs[], int idxLast) {
        this.dataMahasiswa = dataMhs;
        this.idxLast = idxLast;
    }

    void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast) {
            if (dataMahasiswa[idxStart] != null) {
                traverseInOrder(2 * idxStart + 1);
                dataMahasiswa[idxStart].tampilInformasi();
                traverseInOrder(2 * idxStart + 2);
            }
        }
    }
}
```

---

### 3.1.2 Kode Class `BinaryTreeArrayMain14`

```java
public class BinaryTreeArrayMain14 {
    public static void main(String[] args) {
        BinaryTreeArray14 bta = new BinaryTreeArray14();
        Mahasiswa14 mhs1 = new Mahasiswa14(nim:"244160121", nama:"Ali", kelas:"A", ipk:3.57);
        Mahasiswa14 mhs2 = new Mahasiswa14(nim:"244160185", nama:"Candra", kelas:"C", ipk:3.41);
        Mahasiswa14 mhs3 = new Mahasiswa14(nim:"244160221", nama:"Badar", kelas:"B", ipk:3.75);
        Mahasiswa14 mhs4 = new Mahasiswa14(nim:"244160220", nama:"Dewi", kelas:"B", ipk:3.35);

        Mahasiswa14 mhs5 = new Mahasiswa14(nim:"244160131", nama:"Devi", kelas:"A", ipk:3.48);
        Mahasiswa14 mhs6 = new Mahasiswa14(nim:"244160205", nama:"Ehsan", kelas:"D", ipk:3.61);
        Mahasiswa14 mhs7 = new Mahasiswa14(nim:"244160170", nama:"Fizi", kelas:"B", ipk:3.86);

        Mahasiswa14[] dataMahasiswas = {mhs1, mhs2, mhs3, mhs4, mhs5, mhs6, mhs7, null, null, null};
        int idxLast = 6;
        bta.populateData(dataMahasiswas, idxLast);
        System.out.println("\nInorder Traversal Mahasiswa: ");
        bta.traverseInOrder(idxStart:0);
    }
}
```

---

### 3.2 Verifikasi Hasil Percobaan 2

```
Inorder Traversal Mahasiswa: 
NIM: 244160220 Nama: Dewi Kelas: B IPK: 3.35
NIM: 244160185 Nama: Candra Kelas: C IPK: 3.41
NIM: 244160131 Nama: Devi Kelas: A IPK: 3.48
NIM: 244160121 Nama: Ali Kelas: A IPK: 3.57
NIM: 244160205 Nama: Ehsan Kelas: D IPK: 3.61
NIM: 244160221 Nama: Badar Kelas: B IPK: 3.75
NIM: 244160170 Nama: Fizi Kelas: B IPK: 3.86
```

---

### 3.3 Pertanyaan Percobaan 2

**1. Apakah kegunaan dari atribut data dan idxLast yang ada di class BinaryTreeArray?**

- `dataMahasiswa` adalah array yang menyimpan semua objek `Mahasiswa14` yang menjadi node-node dalam binary tree. Posisi dalam array mencerminkan posisi node dalam pohon.
- `idxLast` menyimpan indeks terakhir yang valid dalam array, digunakan sebagai batas rekursi agar traversal tidak melampaui data yang ada.

**2. Apakah kegunaan dari method populateData()?**

Method `populateData()` digunakan untuk mengisi array `dataMahasiswa` dengan data yang sudah disiapkan dari luar class (dari `main()`), sekaligus menetapkan nilai `idxLast` sebagai batas akhir data yang valid dalam tree.

**3. Apakah kegunaan dari method traverseInOrder()?**

Method `traverseInOrder()` digunakan untuk mengunjungi dan menampilkan semua node dalam tree secara in-order (kiri → root → kanan). Karena array diisi sesuai struktur pohon biner level-order, traversal in-order menghasilkan urutan data dari nilai terkecil ke terbesar.

**4. Jika suatu node binary tree disimpan dalam array indeks 2, maka di indeks berapakah posisi left child dan right child masing-masing?**

Rumus: left child = `2*i+1`, right child = `2*i+2`.
Untuk indeks 2:
- Left child: `2*2+1 = 5`
- Right child: `2*2+2 = 6`

**5. Apa kegunaan statement `int idxLast = 6` pada praktikum 2 percobaan nomor 4?**

`idxLast = 6` menandai bahwa indeks terakhir yang berisi data valid dalam array adalah indeks ke-6 (mhs7 = Fizi). Ini digunakan oleh method `traverseInOrder()` sebagai kondisi batas (`idxStart <= idxLast`) agar rekursi tidak memproses indeks yang di luar jangkauan data.

**6. Mengapa indeks `2*idxStart+1` dan `2*idxStart+2` digunakan dalam pemanggilan rekursif, dan apa kaitannya dengan struktur pohon biner yang disusun dalam array?**

Pada penyimpanan binary tree dalam array (representasi level-order), berlaku rumus matematika bahwa untuk sebuah node di indeks `i`:
- Anak kirinya selalu berada di indeks `2*i+1`
- Anak kanannya selalu berada di indeks `2*i+2`

Rumus ini berasal dari sifat pohon biner yang disimpan level per level dari kiri ke kanan. Dengan demikian, relasi parent-child yang biasanya direpresentasikan dengan pointer `left` dan `right` pada linked list, digantikan oleh perhitungan indeks secara matematis pada implementasi array.

---

## 4. Tugas Praktikum

### 4.1 Deskripsi Tugas

Tugas meliputi penambahan beberapa method baru:
1. `addRekursif()` — menambahkan node secara rekursif
2. `cariMinIPK()` — menemukan mahasiswa dengan IPK terkecil
3. `cariMaxIPK()` — menemukan mahasiswa dengan IPK terbesar
4. `tampilMahasiswaIPKdiAtas(double ipkBatas)` — menampilkan mahasiswa dengan IPK di atas batas tertentu
5. Modifikasi `BinaryTreeArray14`: method `add(Mahasiswa14 data)` dan `traversePreOrder()`

---

### 4.2 Kode Tugas – Tambahan Method di `BinaryTree14`

#### Method `addRekursif()`

```java
public Node14 addRekursif(Node14 current, Mahasiswa14 mahasiswa) {
    if (current == null) {
        return new Node14(mahasiswa);
    }
    if (mahasiswa.ipk < current.mahasiswa.ipk) {
        current.left = addRekursif(current.left, mahasiswa);
    } else {
        current.right = addRekursif(current.right, mahasiswa);
    }
    return current;
}

public void addRekursif(Mahasiswa14 mahasiswa) {
    root = addRekursif(root, mahasiswa);
}
```

#### Method `cariMinIPK()` dan `cariMaxIPK()`

```java
public void cariMinIPK() {
    if (isEmpty()) {
        System.out.println("Tree kosong");
        return;
    }
    Node14 current = root;
    while (current.left != null) {
        current = current.left;
    }
    System.out.println("Mahasiswa dengan IPK terkecil:");
    current.mahasiswa.tampilInformasi();
}

public void cariMaxIPK() {
    if (isEmpty()) {
        System.out.println("Tree kosong");
        return;
    }
    Node14 current = root;
    while (current.right != null) {
        current = current.right;
    }
    System.out.println("Mahasiswa dengan IPK terbesar:");
    current.mahasiswa.tampilInformasi();
}
```

#### Method `tampilMahasiswaIPKdiAtas()`

```java
public void tampilMahasiswaIPKdiAtas(Node14 node, double ipkBatas) {
    if (node != null) {
        tampilMahasiswaIPKdiAtas(node.left, ipkBatas);
        if (node.mahasiswa.ipk > ipkBatas) {
            node.mahasiswa.tampilInformasi();
        }
        tampilMahasiswaIPKdiAtas(node.right, ipkBatas);
    }
}

public void tampilMahasiswaIPKdiAtas(double ipkBatas) {
    System.out.println("Mahasiswa dengan IPK di atas " + ipkBatas + ":");
    tampilMahasiswaIPKdiAtas(root, ipkBatas);
}
```

---

### 4.3 Kode Tugas – Modifikasi `BinaryTreeArray14`

#### Tambahan Method `add()` dan `traversePreOrder()`

```java
public void add(Mahasiswa14 data) {
    if (idxLast < dataMahasiswa.length) {
        dataMahasiswa[idxLast] = data;
        idxLast++;
    } else {
        System.out.println("Array penuh, tidak bisa menambah data.");
    }
}

void traversePreOrder(int idxStart) {
    if (idxStart <= idxLast) {
        if (dataMahasiswa[idxStart] != null) {
            dataMahasiswa[idxStart].tampilInformasi();
            traversePreOrder(2 * idxStart + 1);
            traversePreOrder(2 * idxStart + 2);
        }
    }
}
```

---

### 4.4 Verifikasi Hasil Tugas

```
=== UJI TUGAS PRAKTIKUM ===

-- addRekursif --
Mahasiswa berhasil ditambahkan secara rekursif.

InOrder setelah addRekursif:
NIM: 244160185 Nama: Candra Kelas: C IPK: 3.21
NIM: 244160205 Nama: Ehsan Kelas: D IPK: 3.37
NIM: 244160170 Nama: Fizi Kelas: B IPK: 3.46
NIM: 244160220 Nama: Dewi Kelas: B IPK: 3.54
NIM: 244160121 Nama: Ali Kelas: A IPK: 3.57
NIM: 244160131 Nama: Devi Kelas: A IPK: 3.72
NIM: 244160221 Nama: Badar Kelas: B IPK: 3.85

Mahasiswa dengan IPK terkecil:
NIM: 244160185 Nama: Candra Kelas: C IPK: 3.21

Mahasiswa dengan IPK terbesar:
NIM: 244160221 Nama: Badar Kelas: B IPK: 3.85

Mahasiswa dengan IPK di atas 3.50:
NIM: 244160220 Nama: Dewi Kelas: B IPK: 3.54
NIM: 244160121 Nama: Ali Kelas: A IPK: 3.57
NIM: 244160131 Nama: Devi Kelas: A IPK: 3.72
NIM: 244160221 Nama: Badar Kelas: B IPK: 3.85

-- BinaryTreeArray add() dan traversePreOrder() --
PreOrder Traversal Mahasiswa:
NIM: 244160121 Nama: Ali Kelas: A IPK: 3.57
NIM: 244160185 Nama: Candra Kelas: C IPK: 3.41
NIM: 244160220 Nama: Dewi Kelas: B IPK: 3.35
NIM: 244160131 Nama: Devi Kelas: A IPK: 3.48
NIM: 244160221 Nama: Badar Kelas: B IPK: 3.75
NIM: 244160205 Nama: Ehsan Kelas: D IPK: 3.61
NIM: 244160170 Nama: Fizi Kelas: B IPK: 3.86
```

---
