import java.util.Scanner;

public class MainRoyalDelish14 {
    public static void main(String[] args) {
        Scanner sc14              = new Scanner(System.in);
        AntrianPembeli14 antrian14   = new AntrianPembeli14();
        DaftarPesanan14  pesanan14   = new DaftarPesanan14();
        int pilihan14;

        do {
            System.out.println("==============================");
            System.out.println("SISTEM ANTRIAN ROYAL DELISH");
            System.out.println("==============================");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian dan Pesan");
            System.out.println("4. Laporan Pesanan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu : ");
            pilihan14 = Integer.parseInt(sc14.nextLine());

            switch (pilihan14) {

                case 1: // Tambah Antrian
                    System.out.print("Nama Pembeli : ");
                    String nama14 = sc14.nextLine();
                    System.out.print("No HP        : ");
                    String hp14 = sc14.nextLine();
                    int noAntrian14 = antrian14.getNextNoAntrian14();
                    Pembeli14 newPembeli14 = new Pembeli14(noAntrian14, nama14, hp14);
                    antrian14.tambahAntrian14(newPembeli14);
                    System.out.println("Antrian berhasil ditambahkan dengan nomor: " + noAntrian14);
                    break;

                case 2: // Cetak Antrian
                    antrian14.cetakAntrian14();
                    break;

                case 3: // Hapus Antrian dan Input Pesanan
                    Pembeli14 dilayani14 = antrian14.hapusAntrian14();
                    if (dilayani14 != null) {
                        System.out.println("Melayani: " + dilayani14.namaPembeli14);
                        System.out.print("Kode Pesanan  : ");
                        int kode14 = Integer.parseInt(sc14.nextLine());
                        System.out.print("Nama Pesanan  : ");
                        String namaMakanan14 = sc14.nextLine();
                        System.out.print("Harga         : ");
                        int harga14 = Integer.parseInt(sc14.nextLine());
                        Pesanan14 newPesanan14 = new Pesanan14(
                            kode14, namaMakanan14, harga14, dilayani14.namaPembeli14);
                        pesanan14.tambahPesanan14(newPesanan14);
                        System.out.println(dilayani14.namaPembeli14
                            + " telah memesan " + namaMakanan14);
                    }
                    break;

                case 4: // Laporan Pesanan
                    pesanan14.laporanPesanan14();
                    break;

                case 0:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan14 != 0);

        sc14.close();
    }
}