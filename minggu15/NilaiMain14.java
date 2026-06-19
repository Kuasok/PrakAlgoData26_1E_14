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
 * Nomor Presensi: 14
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
            System.out.println("\n+---------------------------------------------------+");
            System.out.println("|       DAFTAR NILAI MAHASISWA SEMESTER             |");
            System.out.println("+---------------------------------------------------+");
            System.out.println("|  1. Tambah Mahasiswa                              |");
            System.out.println("|  2. Tambah Mata Kuliah                            |");
            System.out.println("|  3. Tambah Nilai                                  |");
            System.out.println("|  4. Tampil Nilai                                  |");
            System.out.println("|  5. Cari Data Mahasiswa                           |");
            System.out.println("|  6. Urut Data Nilai                               |");
            System.out.println("|  7. Tampil Mahasiswa                              |");
            System.out.println("|  8. Tampil Mata Kuliah                            |");
            System.out.println("|  9. Tambah ke Antrian Hapus (Queue)               |");
            System.out.println("| 10. Tampil Antrian Hapus                          |");
            System.out.println("| 11. Proses Hapus dari Queue                       |");
            System.out.println("|  0. Keluar                                        |");
            System.out.println("+---------------------------------------------------+");
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
