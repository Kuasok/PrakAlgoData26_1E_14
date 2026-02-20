package minggu1;

import java.util.Scanner;

public class array {
    public static void main(String[] args) {
        Scanner ferdi = new Scanner(System.in);
        String[] matkul14 = {
            "Pancasila", "Konsep Teknologi Informasi", "Critical Thinking dan Problem Solving",
            "Matematika Dasar", "Bahasa Inggris", "Dasar Pemrograman", 
            "Praktikum Dasar Pemrograman", "Keselamatan dan Kesehatan Kerja"
        };
        
        int[] sks = {2, 2, 2, 3, 2, 2, 3, 2};
        double[] nilaiAngka14 = new double[matkul14.length];
        String[] nilaiHuruf14 = new String[matkul14.length];
        double[] bobotNilai14 = new double[matkul14.length];
        
        System.out.println("Program Menghitung IP Semester");
        System.out.println("==============================");
        
        for (int i = 0; i < matkul14.length; i++) {
            System.out.print("masukkan nilai Angka untuk MK " + matkul14[i] + ": ");
            nilaiAngka14[i] = ferdi.nextDouble();
            

            if (nilaiAngka14[i] > 80) { nilaiHuruf14[i] = "A"; bobotNilai14[i] = 4.0; }
            else if (nilaiAngka14[i] > 73) { nilaiHuruf14[i] = "B+"; bobotNilai14[i] = 3.5; }
            else if (nilaiAngka14[i] > 65) { nilaiHuruf14[i] = "B"; bobotNilai14[i] = 3.0; }
            else if (nilaiAngka14[i] > 60) { nilaiHuruf14[i] = "C+"; bobotNilai14[i] = 2.5; }
            else if (nilaiAngka14[i] > 50) { nilaiHuruf14[i] = "C"; bobotNilai14[i] = 2.0; }
            else if (nilaiAngka14[i] > 39) { nilaiHuruf14[i] = "D"; bobotNilai14[i] = 1.0; }
            else { nilaiHuruf14[i] = "E"; bobotNilai14[i] = 0.0; }
        }
        
        System.out.println("==============================");
        System.out.println("hasil Konversi Nilai");
        System.out.println("==============================");
        System.out.printf("%-40s %-12s %-12s %-12s\n", "MK", "Nilai Angka", "Nilai Huruf", "Bobot Nilai");
        
        double totalBobotSKS14 = 0;
        int totalSKS14 = 0;
        for (int i = 0; i < matkul14.length; i++) {
            System.out.printf("%-40s %-12.2f %-12s %-12.2f\n", matkul14[i], nilaiAngka14[i], nilaiHuruf14[i], bobotNilai14[i]);
            totalBobotSKS14 += (bobotNilai14[i] * sks[i]);
            totalSKS14 += sks[i];
        }
        
        System.out.println("==============================");
        double ip = totalBobotSKS14 / totalSKS14;
        System.out.printf("IP : %.2f\n", ip);
    }
}
