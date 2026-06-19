import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Tugas 2: Implementasi Queue untuk penghapusan data mahasiswa
 * Queue bersifat FIFO (First In First Out)
 * Mahasiswa yang pertama masuk antrian akan pertama kali diproses penghapusannya
 * Nomor Presensi: 14
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
            System.out.println("\n+--------------------------------------+");
            System.out.println("|     ANTRIAN HAPUS MAHASISWA (QUEUE)  |");
            System.out.println("+--------------------------------------+");
            System.out.println("|  1. Tambah ke Antrian (Enqueue)      |");
            System.out.println("|  2. Proses Hapus (Dequeue)           |");
            System.out.println("|  3. Lihat Elemen Terdepan (Peek)     |");
            System.out.println("|  4. Tampil Antrian                   |");
            System.out.println("|  5. Kosongkan Antrian                |");
            System.out.println("|  0. Keluar                           |");
            System.out.println("+--------------------------------------+");
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
