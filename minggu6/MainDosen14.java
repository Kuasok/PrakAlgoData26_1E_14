import java.util.Scanner;

public class MainDosen14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataDosen14 dd = new DataDosen14();
        int pilihan;

        do {
            System.out.println("\n===== MENU DATA DOSEN =====");
            System.out.println("1. Tambah Data Dosen");
            System.out.println("2. Tampil Data Dosen");
            System.out.println("3. Sorting ASC (termuda ke tertua) - Bubble Sort");
            System.out.println("4. Sorting DSC (tertua ke termuda) - Selection Sort");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = Integer.parseInt(sc.nextLine());

            switch (pilihan) {
                case 1:
                    System.out.print("Kode          : ");
                    String kode = sc.nextLine();
                    System.out.print("Nama          : ");
                    String nama = sc.nextLine();
                    System.out.print("Jenis Kelamin (Pria/Wanita): ");
                    String jkInput = sc.nextLine();
                    boolean jk = jkInput.equalsIgnoreCase("Pria");
                    System.out.print("Usia          : ");
                    int usia = Integer.parseInt(sc.nextLine());
                    dd.tambah(new Dosen14(kode, nama, jk, usia));
                    System.out.println("Data berhasil ditambahkan.");
                    break;

                case 2:
                    System.out.println("\n--- Data Semua Dosen ---");
                    dd.tampil();
                    break;

                case 3:
                    dd.SortingASC();
                    System.out.println("\n--- Data Dosen Setelah SORTING ASC (Bubble Sort) ---");
                    dd.tampil();
                    break;

                case 4:
                    dd.sortingDSC();
                    System.out.println("\n--- Data Dosen Setelah SORTING DSC (Selection Sort) ---");
                    dd.tampil();
                    break;

                case 5:
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
    }
}