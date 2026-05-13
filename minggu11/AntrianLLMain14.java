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
