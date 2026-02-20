package minggu1;

import java.util.Scanner;

public class perulangan {
    public static void main(String[] args) {
        Scanner ferdi = new Scanner(System.in);
        
        System.out.print("Masukkan NIM: ");
        long nim14 = ferdi.nextLong();
        int n14 = (int) (nim14 % 100);
        
        if (n14 < 10) {
            n14 += 10;
        }
        
        System.out.println("n : " + n14);
        
        for (int i14 = 1; i14 <= n14; i14++) {

            if (i14 == 10 || i14 == 15) {
                continue;
            }
            if (i14 % 3 == 0) {
                System.out.print("# ");
            } 
            else if (i14 % 2 != 0) {
                System.out.print("* ");
            } 
            else {
                System.out.print(i14 + " ");
            }
        }
    }
}