package minggu1;

import java.util.Locale;

public class fungsi {

    static int[][] stock14 = {
        {10, 5, 15, 7},
        {6, 11, 9, 12},
        {2, 10, 10, 5},
        {5, 7, 12, 9}
    };
    
    static int[] harga14 = {75000, 50000, 60000, 10000};
    static String[] cabang14 = {"RoyalGarden 1", "RoyalGarden 2", "RoyalGarden 3", "RoyalGarden 4"};

    public static void tampilkanPendapatan14() {
        System.out.println("Pendapatan Setiap Cabang (Jika Terjual Habis):");
        for (int i14 = 0; i14 < stock14.length; i14++) {
            int total14 = 0;
            for (int j14 = 0; j14 < stock14[i14].length; j14++) {
                total14 += stock14[i14][j14] * harga14[j14];
            }
            String totalFormatted14 = String.format(Locale.GERMANY, "%, d", total14).replace(',', '.');
            String status14 = (total14 > 1500000) ? "Sangat Baik" : "Perlu Evaluasi";
            System.out.println(cabang14[i14] + " : Rp " + totalFormatted14.trim() + " (" + status14 + ")");
        }
    }

    public static void main(String[] args) {
        tampilkanPendapatan14();
    }
}
