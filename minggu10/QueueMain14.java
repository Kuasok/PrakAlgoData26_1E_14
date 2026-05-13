import java.util.Scanner;

public class QueueMain14 {
    public static void menu() {
        System.out.println("Masukkan operasi yang diinginkan:");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Print");
        System.out.println("4. Peek");
        System.out.println("5. Clear");
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        Scanner ferdi = new Scanner(System.in);

        System.out.print("Masukkan kapasitas queue: ");
        int n14 = ferdi.nextInt();

        Queue14 Q14 = new Queue14(n14);

        int pilih14;
        do {
            menu();
            pilih14 = ferdi.nextInt();
            switch (pilih14) {
                case 1:
                    System.out.print("Masukkan data baru: ");
                    int dataMasuk14 = ferdi.nextInt();
                    Q14.Enqueue(dataMasuk14);
                    break;
                case 2:
                    int dataKeluar14 = Q14.Dequeue();
                    if (dataKeluar14 != 0) {
                        System.out.println("Data yang dikeluarkan: " + dataKeluar14);
                    }
                    break;
                case 3:
                    Q14.print();
                    break;
                case 4:
                    Q14.peek();
                    break;
                case 5:
                    Q14.clear();
                    break;
            }
        } while (pilih14 == 1 || pilih14 == 2 || pilih14 == 3 || pilih14 == 4 || pilih14 == 5);
    }
}