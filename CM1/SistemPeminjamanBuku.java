import java.util.Scanner;

// Class Mahasiswa
class Mahasiswa {
    String nim;
    String nama;
    String prodi;
    
    public Mahasiswa(String nim, String nama, String prodi) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
    }
    
    public void tampilMahasiswa() {
        System.out.println("NIM: " + nim + " | Nama: " + nama + " | Prodi: " + prodi);
    }
}

// Class Buku
class Buku {
    String kodeBuku;
    String judul;
    int tahunTerbit;
    
    public Buku(String kodeBuku, String judul, int tahunTerbit) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }
    
    public void tampilBuku() {
        System.out.println("Kode: " + kodeBuku + " | Judul: " + judul + " | Tahun: " + tahunTerbit);
    }
}

// Class Peminjaman
class Peminjaman {
    Mahasiswa mhs;
    Buku buku;
    int lamaPinjam;
    int batasPinjam = 5;
    int terlambat;
    int denda;
    
    public Peminjaman(Mahasiswa mhs, Buku buku, int lamaPinjam) {
        this.mhs = mhs;
        this.buku = buku;
        this.lamaPinjam = lamaPinjam;
        hitungDenda();
    }
    
    public void hitungDenda() {
        if (lamaPinjam > batasPinjam) {
            terlambat = lamaPinjam - batasPinjam;
            denda = terlambat * 2000;
        } else {
            terlambat = 0;
            denda = 0;
        }
    }
    
    public void tampilPeminjaman() {
        System.out.println(mhs.nama + " | " + buku.judul + " | Lama: " + lamaPinjam + 
                         " | Terlambat: " + terlambat + " | Denda: " + denda);
    }
}

// Main Class
public class SistemPeminjamanBuku {
    
    // Method untuk menampilkan menu
    public static void tampilkanMenu() {
        System.out.println("\n=== SISTEM PEMINJAMAN RUANG BACA JTI ===");
        System.out.println("1. Tampilkan Mahasiswa");
        System.out.println("2. Tampilkan Buku");
        System.out.println("3. Tampilkan Peminjaman");
        System.out.println("4. Urutkan Berdasarkan Denda");
        System.out.println("5. Cari Berdasarkan NIM");
        System.out.println("0. Keluar");
        System.out.print("Pilih: ");
    }
    
    // Method untuk menampilkan semua mahasiswa
    public static void tampilkanMahasiswa(Mahasiswa[] mahasiswa) {
        System.out.println("\nDaftar Mahasiswa:");
        for (int i = 0; i < mahasiswa.length; i++) {
            mahasiswa[i].tampilMahasiswa();
        }
    }
    
    // Method untuk menampilkan semua buku
    public static void tampilkanBuku(Buku[] buku) {
        System.out.println("\nDaftar Buku:");
        for (int i = 0; i < buku.length; i++) {
            buku[i].tampilBuku();
        }
    }
    
    // Method untuk menampilkan semua peminjaman
    public static void tampilkanPeminjaman(Peminjaman[] peminjaman) {
        System.out.println("\nData Peminjaman:");
        for (int i = 0; i < peminjaman.length; i++) {
            peminjaman[i].tampilPeminjaman();
        }
    }
    
    // Method sorting menggunakan Insertion Sort berdasarkan denda (descending)
    public static void urutkanBerdasarkanDenda(Peminjaman[] peminjaman) {
        for (int i = 1; i < peminjaman.length; i++) {
            Peminjaman key = peminjaman[i];
            int j = i - 1;
            
            // Urutkan descending (denda terbesar di depan)
            while (j >= 0 && peminjaman[j].denda < key.denda) {
                peminjaman[j + 1] = peminjaman[j];
                j = j - 1;
            }
            peminjaman[j + 1] = key;
        }
        
        System.out.println("\nSetelah diurutkan (Denda terbesar):");
        tampilkanPeminjaman(peminjaman);
    }
    
    // Method searching menggunakan Sequential Search berdasarkan NIM
    public static void cariBerdasarkanNIM(Peminjaman[] peminjaman, String nim) {
        System.out.println("\nMasukkan NIM: " + nim);
        boolean found = false;
        
        for (int i = 0; i < peminjaman.length; i++) {
            if (peminjaman[i].mhs.nim.equals(nim)) {
                peminjaman[i].tampilPeminjaman();
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("Data peminjaman dengan NIM " + nim + " tidak ditemukan.");
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Inisialisasi data mahasiswa
        Mahasiswa[] mahasiswa = new Mahasiswa[3];
        mahasiswa[0] = new Mahasiswa("22001", "Andi", "Teknik Informatika");
        mahasiswa[1] = new Mahasiswa("22002", "Budi", "Teknik Informatika");
        mahasiswa[2] = new Mahasiswa("22003", "Citra", "Sistem Informasi Bisnis");
        
        // Inisialisasi data buku
        Buku[] buku = new Buku[4];
        buku[0] = new Buku("B001", "Algoritma", 2020);
        buku[1] = new Buku("B002", "Basis Data", 2019);
        buku[2] = new Buku("B003", "Pemrograman", 2021);
        buku[3] = new Buku("B004", "Fisika", 2024);
        
        // Inisialisasi data peminjaman
        Peminjaman[] peminjaman = new Peminjaman[5];
        peminjaman[0] = new Peminjaman(mahasiswa[0], buku[0], 7);  // Andi - Algoritma - 7 hari
        peminjaman[1] = new Peminjaman(mahasiswa[1], buku[1], 3);  // Budi - Basis Data - 3 hari
        peminjaman[2] = new Peminjaman(mahasiswa[2], buku[2], 10); // Citra - Pemrograman - 10 hari
        peminjaman[3] = new Peminjaman(mahasiswa[2], buku[3], 6);  // Citra - Fisika - 6 hari
        peminjaman[4] = new Peminjaman(mahasiswa[0], buku[1], 4);  // Andi - Basis Data - 4 hari
        
        // Menu loop
        int pilihan;
        do {
            tampilkanMenu();
            pilihan = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (pilihan) {
                case 1:
                    tampilkanMahasiswa(mahasiswa);
                    break;
                case 2:
                    tampilkanBuku(buku);
                    break;
                case 3:
                    tampilkanPeminjaman(peminjaman);
                    break;
                case 4:
                    urutkanBerdasarkanDenda(peminjaman);
                    break;
                case 5:
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();
                    cariBerdasarkanNIM(peminjaman, nim);
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
        
        scanner.close();
    }
}
