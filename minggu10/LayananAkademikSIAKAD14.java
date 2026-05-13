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
            System.out.println("6. Cek Antrian paling belakang");
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
                case 6:
                    antrian14.lihatAkhir();
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