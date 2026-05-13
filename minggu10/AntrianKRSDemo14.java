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