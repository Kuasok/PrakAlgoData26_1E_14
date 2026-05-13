import java.util.Scanner;

public class DoubleLinkedListMain14 {
    public static void main(String[] args) {
        Scanner ferdi = new Scanner(System.in);
        DoubleLinkedList14 dll14 = new DoubleLinkedList14();
        int pilihan14;

        do {
            System.out.println("\n=== Menu Double Linked List ===");
            System.out.println("1. Add First");
            System.out.println("2. Add Last");
            System.out.println("3. Add at Index");
            System.out.println("4. Insert After (key nama)");
            System.out.println("5. Print");
            System.out.println("6. Print Reverse");
            System.out.println("7. Remove First");
            System.out.println("8. Remove Last");
            System.out.println("9. Remove After (key nama)");
            System.out.println("10. Remove at Index");
            System.out.println("11. Get First");
            System.out.println("12. Get Last");
            System.out.println("13. Get at Index");
            System.out.println("14. Size");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan14 = ferdi.nextInt();
            ferdi.nextLine();

            switch (pilihan14) {
                case 1:
                    System.out.print("NIM   : ");
                    String nim14 = ferdi.nextLine();
                    System.out.print("Nama  : ");
                    String nama14 = ferdi.nextLine();
                    System.out.print("Kelas : ");
                    String kelas14 = ferdi.nextLine();
                    System.out.print("IPK   : ");
                    double ipk14 = ferdi.nextDouble();
                    ferdi.nextLine();
                    Mahasiswa14 mhs14 = new Mahasiswa14(nim14, nama14, kelas14, ipk14);
                    dll14.addFirst(mhs14);
                    break;
                case 2:
                    System.out.print("NIM   : ");
                    nim14 = ferdi.nextLine();
                    System.out.print("Nama  : ");
                    nama14 = ferdi.nextLine();
                    System.out.print("Kelas : ");
                    kelas14 = ferdi.nextLine();
                    System.out.print("IPK   : ");
                    ipk14 = ferdi.nextDouble();
                    ferdi.nextLine();
                    mhs14 = new Mahasiswa14(nim14, nama14, kelas14, ipk14);
                    dll14.addLast(mhs14);
                    break;
                case 3:
                    System.out.print("NIM   : ");
                    nim14 = ferdi.nextLine();
                    System.out.print("Nama  : ");
                    nama14 = ferdi.nextLine();
                    System.out.print("Kelas : ");
                    kelas14 = ferdi.nextLine();
                    System.out.print("IPK   : ");
                    ipk14 = ferdi.nextDouble();
                    ferdi.nextLine();
                    mhs14 = new Mahasiswa14(nim14, nama14, kelas14, ipk14);
                    System.out.print("Masukkan indeks: ");
                    int index14 = ferdi.nextInt();
                    ferdi.nextLine();
                    dll14.add(mhs14, index14);
                    break;
                case 4:
                    System.out.print("NIM   : ");
                    nim14 = ferdi.nextLine();
                    System.out.print("Nama  : ");
                    nama14 = ferdi.nextLine();
                    System.out.print("Kelas : ");
                    kelas14 = ferdi.nextLine();
                    System.out.print("IPK   : ");
                    ipk14 = ferdi.nextDouble();
                    ferdi.nextLine();
                    mhs14 = new Mahasiswa14(nim14, nama14, kelas14, ipk14);
                    System.out.print("Masukkan key (nama): ");
                    String key14 = ferdi.nextLine();
                    dll14.insertAfter(key14, mhs14);
                    break;
                case 5:
                    dll14.print();
                    break;
                case 6:
                    dll14.printReverse();
                    break;
                case 7:
                    Mahasiswa14 hapusFirst14 = dll14.removeFirst();
                    if (hapusFirst14 != null) {
                        System.out.println("Data yang dihapus:");
                        hapusFirst14.tampil();
                    }
                    break;
                case 8:
                    Mahasiswa14 hapusLast14 = dll14.removeLast();
                    if (hapusLast14 != null) {
                        System.out.println("Data yang dihapus:");
                        hapusLast14.tampil();
                    }
                    break;
                case 9:
                    System.out.print("Masukkan key (nama sebelum node yang dihapus): ");
                    String keyRemove14 = ferdi.nextLine();
                    Mahasiswa14 hapusAfter14 = dll14.removeAfter(keyRemove14);
                    if (hapusAfter14 != null) {
                        System.out.println("Data yang dihapus:");
                        hapusAfter14.tampil();
                    }
                    break;
                case 10:
                    System.out.print("Masukkan indeks yang akan dihapus: ");
                    int idxRemove14 = ferdi.nextInt();
                    ferdi.nextLine();
                    Mahasiswa14 hapusIdx14 = dll14.remove(idxRemove14);
                    if (hapusIdx14 != null) {
                        System.out.println("Data yang dihapus:");
                        hapusIdx14.tampil();
                    }
                    break;
                case 11:
                    Mahasiswa14 first14 = dll14.getFirst();
                    if (first14 != null) {
                        System.out.println("Data pertama:");
                        first14.tampil();
                    }
                    break;
                case 12:
                    Mahasiswa14 last14 = dll14.getLast();
                    if (last14 != null) {
                        System.out.println("Data terakhir:");
                        last14.tampil();
                    }
                    break;
                case 13:
                    System.out.print("Masukkan indeks: ");
                    int idx14 = ferdi.nextInt();
                    ferdi.nextLine();
                    Mahasiswa14 dataIdx14 = dll14.getIndex(idx14);
                    if (dataIdx14 != null) {
                        System.out.println("Data pada indeks " + idx14 + ":");
                        dataIdx14.tampil();
                    }
                    break;
                case 14:
                    System.out.println("Jumlah data dalam linked list: " + dll14.size());
                    break;
                case 0:
                    System.out.println("Terima kasih.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan14 != 0);
    }
}
