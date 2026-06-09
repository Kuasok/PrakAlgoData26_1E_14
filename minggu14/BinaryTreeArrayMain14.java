public class BinaryTreeArrayMain14 {
    public static void main(String[] args) {

        // ===== PERCOBAAN 2 =====
        BinaryTreeArray14 bta = new BinaryTreeArray14();

        Mahasiswa14 mhs1 = new Mahasiswa14("244160121", "Ali", "A", 3.57);
        Mahasiswa14 mhs2 = new Mahasiswa14("244160185", "Candra", "C", 3.41);
        Mahasiswa14 mhs3 = new Mahasiswa14("244160221", "Badar", "B", 3.75);
        Mahasiswa14 mhs4 = new Mahasiswa14("244160220", "Dewi", "B", 3.35);
        Mahasiswa14 mhs5 = new Mahasiswa14("244160131", "Devi", "A", 3.48);
        Mahasiswa14 mhs6 = new Mahasiswa14("244160205", "Ehsan", "D", 3.61);
        Mahasiswa14 mhs7 = new Mahasiswa14("244160170", "Fizi", "B", 3.86);

        Mahasiswa14[] dataMahasiswas = {mhs1, mhs2, mhs3, mhs4, mhs5, mhs6, mhs7, null, null, null};
        int idxLast = 6;
        bta.populateData(dataMahasiswas, idxLast);

        System.out.println("\nInorder Traversal Mahasiswa: ");
        bta.traverseInOrder(0);

        // ===== TUGAS: add() dan traversePreOrder() =====
        System.out.println("\n-- BinaryTreeArray add() dan traversePreOrder() --");
        BinaryTreeArray14 bta2 = new BinaryTreeArray14();
        bta2.add(new Mahasiswa14("244160121", "Ali", "A", 3.57));
        bta2.add(new Mahasiswa14("244160185", "Candra", "C", 3.41));
        bta2.add(new Mahasiswa14("244160221", "Badar", "B", 3.75));
        bta2.add(new Mahasiswa14("244160220", "Dewi", "B", 3.35));
        bta2.add(new Mahasiswa14("244160131", "Devi", "A", 3.48));
        bta2.add(new Mahasiswa14("244160205", "Ehsan", "D", 3.61));
        bta2.add(new Mahasiswa14("244160170", "Fizi", "B", 3.86));

        System.out.println("PreOrder Traversal Mahasiswa:");
        bta2.traversePreOrder(0);
    }
}
