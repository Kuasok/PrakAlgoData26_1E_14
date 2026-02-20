package minggu1;
import java.util.Scanner;

public class tugas1 {
    public static void main(String[] args) {
        char[] KODE14 = {'A', 'B', 'D', 'E', 'F', 'G', 'H', 'L', 'N', 'T'};
        char[][] KOTA14 = {
            {'B', 'A', 'N', 'T', 'E', 'N'},
            {'J', 'A', 'K', 'A', 'R', 'T', 'A'},
            {'B', 'A', 'N', 'D', 'U', 'N', 'G'},
            {'C', 'I', 'R', 'E', 'B', 'O', 'N'},
            {'B', 'O', 'G', 'O', 'R'},
            {'P', 'E', 'K', 'A', 'L', 'O', 'N', 'G', 'A', 'N'},
            {'S', 'E', 'M', 'A', 'R', 'A', 'N', 'G'},
            {'S', 'U', 'R', 'A', 'B', 'A', 'Y', 'A'},
            {'M', 'A', 'L', 'A', 'N', 'G'},
            {'T', 'E', 'G', 'A', 'L'}
        };

        Scanner ferdi = new Scanner(System.in);
        System.out.print("Masukkan Kode Plat: ");
        char cari14 = ferdi.next().toUpperCase().charAt(0);

        int index = -1;
        for (int i14 = 0; i14 < KODE14.length; i14++) {
            if (KODE14[i14] == cari14) {
                index = i14;
                break;
            }
        }

        if (index != -1) {
            System.out.print("Kota: ");
            for (int j14 = 0; j14 < KOTA14[index].length; j14++) {
                System.out.print(KOTA14[index][j14]);
            }
            System.out.println();
        } else {
            System.out.println("Kode plat tidak ditemukan.");
        }
    }
}