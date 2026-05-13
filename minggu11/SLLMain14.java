import java.util.Scanner;

public class SLLMain14 {
    public static void main(String[] args) {
        Scanner ferdi = new Scanner(System.in);
        SingleLinkedList14 sll14 = new SingleLinkedList14();
        int pilihan14;

        do {
            System.out.println("\n=== Menu Single Linked List ===");
            System.out.println("1. Add First");
            System.out.println("2. Add Last");
            System.out.println("3. Insert After");
            System.out.println("4. Add At Index");
            System.out.println("5. Get Data (by index)");
            System.out.println("6. Index Of (by nama)");
            System.out.println("7. Remove First");
            System.out.println("8. Remove Last");
            System.out.println("9. Remove (by nama)");
            System.out.println("10. Remove At (by index)");
            System.out.println("11. Print");
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
                    sll14.addFirst(mhs14);
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
                    sll14.addLast(mhs14);
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
                    System.out.print("Masukkan key (nama setelah node ini disisipkan): ");
                    String key14 = ferdi.nextLine();
                    sll14.insertAfter(mhs14, key14);
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
                    System.out.print("Masukkan indeks: ");
                    int index14 = ferdi.nextInt();
                    ferdi.nextLine();
                    sll14.addAtIndex(mhs14, index14);
                    break;
                case 5:
                    System.out.print("Masukkan indeks: ");
                    int idx14 = ferdi.nextInt();
                    ferdi.nextLine();
                    Mahasiswa14 data14 = sll14.getData(idx14);
                    if (data14 != null) {
                        System.out.println("Data pada indeks " + idx14 + ":");
                        data14.tampilInformasi();
                    }
                    break;
                case 6:
                    System.out.print("Masukkan nama yang dicari: ");
                    String cari14 = ferdi.nextLine();
                    int pos14 = sll14.indexOf(cari14);
                    if (pos14 != -1) {
                        System.out.println("Nama " + cari14 + " ditemukan pada indeks: " + pos14);
                    } else {
                        System.out.println("Nama " + cari14 + " tidak ditemukan.");
                    }
                    break;
                case 7:
                    sll14.removeFirst();
                    System.out.println("Node pertama berhasil dihapus.");
                    break;
                case 8:
                    sll14.removeLast();
                    System.out.println("Node terakhir berhasil dihapus.");
                    break;
                case 9:
                    System.out.print("Masukkan nama yang akan dihapus: ");
                    String hapus14 = ferdi.nextLine();
                    sll14.remove(hapus14);
                    System.out.println("Node dengan nama " + hapus14 + " berhasil dihapus.");
                    break;
                case 10:
                    System.out.print("Masukkan indeks yang akan dihapus: ");
                    int idxHapus14 = ferdi.nextInt();
                    ferdi.nextLine();
                    sll14.removeAt(idxHapus14);
                    System.out.println("Node pada indeks " + idxHapus14 + " berhasil dihapus.");
                    break;
                case 11:
                    sll14.print();
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
