package minggu1;
import java.util.Scanner;

public class tugas2 {
    static Scanner ferdi = new Scanner(System.in);
    static String[][] jadwal14;
    static int n14;


    public static void inputData14() {
        System.out.print("Masukkan jumlah jadwal kuliah: ");
        n14 = ferdi.nextInt();
        ferdi.nextLine();
        jadwal14 = new String[n14][4];

        for (int i14 = 0; i14 < n14; i14++) {
            System.out.println("\nMasukkan Data Jadwal ke-" + (i14 + 1));
            System.out.print("Nama Mata Kuliah : ");
            jadwal14[i14][0] = ferdi.nextLine();
            System.out.print("Ruang            : ");
            jadwal14[i14][1] = ferdi.nextLine();
            System.out.print("Hari             : ");
            jadwal14[i14][2] = ferdi.nextLine();
            System.out.print("Jam (00.00-24.00): ");
            jadwal14[i14][3] = ferdi.nextLine();
        }
    }


    public static void tampilkanSemua14() {
        System.out.println("\n============================================================================");
        System.out.printf("%-5s | %-25s | %-10s | %-10s | %-10s\n", "No", "Mata Kuliah", "Ruang", "Hari", "Jam");
        System.out.println("----------------------------------------------------------------------------");
        for (int i14 = 0; i14 < n14; i14++) {
            System.out.printf("%-5d | %-25s | %-10s | %-10s | %-10s\n", (i14 + 1), jadwal14[i14][0], jadwal14[i14][1], jadwal14[i14][2], jadwal14[i14][3]);
        }
        System.out.println("============================================================================");
    }


    public static void cariBerdasarkanHari14() {
        System.out.print("\nMasukkan hari yang dicari: ");
        String hariCari14 = ferdi.nextLine();
        boolean ditemukan14 = false;
        
        System.out.println("\nHasil Pencarian Hari: " + hariCari14);
        for (int i14 = 0; i14 < n14; i14++) {
            if (jadwal14[i14][2].equalsIgnoreCase(hariCari14)) {
                System.out.printf("- %s (%s) Jam: %s\n", jadwal14[i14][0], jadwal14[i14][1], jadwal14[i14][3]);
                ditemukan14 = true;
            }
        }
        if (!ditemukan14) System.out.println("Jadwal tidak ditemukan pada hari tersebut.");
    }


    public static void cariBerdasarkanMatkul14() {
        System.out.print("\nMasukkan Nama Mata Kuliah yang dicari: ");
        String matkulCari14 = ferdi.nextLine();
        boolean ditemukan14 = false;

        for (int i14 = 0; i14 < n14; i14++) {
            if (jadwal14[i14][0].equalsIgnoreCase(matkulCari14)) {
                System.out.println("\nDetail Jadwal:");
                System.out.println("Nama  : " + jadwal14[i14][0]);
                System.out.println("Ruang : " + jadwal14[i14][1]);
                System.out.println("Hari  : " + jadwal14[i14][2]);
                System.out.println("Jam   : " + jadwal14[i14][3]);
                ditemukan14 = true;
                break;
            }
        }
        if (!ditemukan14) System.out.println("Mata kuliah tidak ditemukan.");
    }

    public static void main(String[] args) {
        inputData14();
        int pilihan14;
        do {
            System.out.println("\n--- MENU JADWAL KULIAH ---");
            System.out.println("1. Tampilkan Semua Jadwal");
            System.out.println("2. Cari Berdasarkan Hari");
            System.out.println("3. Cari Berdasarkan Mata Kuliah");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan14 = ferdi.nextInt();
            ferdi.nextLine(); 

            switch (pilihan14) {
                case 1: tampilkanSemua14(); break;
                case 2: cariBerdasarkanHari14(); break;
                case 3: cariBerdasarkanMatkul14(); break;
            }
        } while (pilihan14 != 4);
        System.out.println("Selesai.");
    }
}