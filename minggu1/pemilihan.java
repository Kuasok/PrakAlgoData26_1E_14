package minggu1;
import java.util.Scanner;

public class pemilihan {
    public static void main(String[] args) {
        Scanner ferdi = new Scanner(System.in);
        
        System.out.println("Program Menghitung Nilai Akhir");
        System.out.println("==============================");
        
        System.out.print("Masukkan Nilai Tugas: ");
        double tugas14 = ferdi.nextDouble();
        System.out.print("Masukkan Nilai Kuis: ");
        double kuis14 = ferdi.nextDouble();
        System.out.print("Masukkan Nilai UTS: ");
        double uts14 = ferdi.nextDouble();
        System.out.print("Masukkan Nilai UAS: ");
        double uas14 = ferdi.nextDouble();
        
        System.out.println("==============================");
        

        if (tugas14 < 0 || tugas14 > 100 || kuis14 < 0 || kuis14 > 100 || 
            uts14 < 0 || uts14 > 100 || uas14 < 0 || uas14 > 100) {
            System.out.println("nilai tidak valid");
            System.out.println("==============================");
        } else {

            double nilaiAkhir14 = (0.2 * tugas14) + (0.2 * kuis14) + (0.3 * uts14) + (0.3 * uas14);
            String nilaiHuruf14 ;
            

            if (nilaiAkhir14 > 80 && nilaiAkhir14 <= 100) nilaiHuruf14 = "A";
            else if (nilaiAkhir14 > 73) nilaiHuruf14 = "B+";
            else if (nilaiAkhir14 > 65) nilaiHuruf14 = "B";
            else if (nilaiAkhir14 > 60) nilaiHuruf14 = "C+";
            else if (nilaiAkhir14 > 50) nilaiHuruf14 = "C";
            else if (nilaiAkhir14 > 39) nilaiHuruf14 = "D";
            else nilaiHuruf14 = "E";
            
            System.out.println("nilai akhir : " + nilaiAkhir14);
            System.out.println("Nilai Huruf : " + nilaiHuruf14);
            System.out.println("==============================");
            

            if (nilaiHuruf14.equals("D") || nilaiHuruf14.equals("E")) {
                System.out.println("ANDA TIDAK LULUS");
            } else {
                System.out.println("SELAMAT ANDA LULUS");
            }
        }
    }
}