import java.util.Scanner;

public class MahasiswaDemo14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumMhs = Integer.parseInt(sc.nextLine());

        MahasiswaBerprestasi14 list = new MahasiswaBerprestasi14();
        list.listMhs = new Mahasiswa14[jumMhs];

        for (int i = 0; i < jumMhs; i++) {
            System.out.println("Masukkan Data Mahasiswa ke-" + (i + 1));
            System.out.print("NIM   : ");
            String nim = sc.nextLine();
            System.out.print("Nama  : ");
            String nama = sc.nextLine();
            System.out.print("Kelas : ");
            String kelas = sc.nextLine();
            System.out.print("IPK   : ");
            String ip = sc.nextLine();
            double ipk = Double.parseDouble(ip);
            System.out.println("------------------------------");
            list.tambah(new Mahasiswa14(nim, nama, kelas, ipk));
        }

        list.tampil();

        System.out.println("------------------------------------------------");
        System.out.println("Pencarian data");
        System.out.println("------------------------------------------------");
        System.out.println("masukkan ipk mahasiswa yang dicari: ");
        System.out.print("IPK: ");
        double cari = sc.nextDouble();

        System.out.println("menggunakan sequential searching");
        int pss = list.sequentialSearching(cari);
        list.tampilPoisisi(cari, pss);
        list.tampilDataSearch(cari, pss);

        System.out.println("------------------------------------------------");
        System.out.println("Pencarian data");
        System.out.println("------------------------------------------------");
        System.out.println("masukkan ipk mahasiswa yang dicari: ");
        System.out.print("IPK: ");
        double cari2 = sc.nextDouble();
        System.out.println("------------------------------");
        System.out.println("menggunakan binary search");
        System.out.println("------------------------------");
        int pss2 = list.findBinarySearch(cari2, 0, jumMhs - 1);
        list.tampilPoisisi(cari2, pss2);
        list.tampilDataSearch(cari2, pss2);

        sc.close();
    }
}