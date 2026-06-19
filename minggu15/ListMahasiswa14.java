import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Class ListMahasiswa14 mengimplementasikan operasi CRUD pada collection
 * menggunakan List untuk menyimpan objek Mahasiswa14
 * Nomor Presensi: 14
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
