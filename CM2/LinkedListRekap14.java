public class LinkedListRekap14 {
    NodeRekap14 head14;
    NodeRekap14 tail14;
    int size14;

    public LinkedListRekap14() {
        head14 = null;
        tail14 = null;
        size14 = 0;
    }

    public boolean isEmpty14() {
        return head14 == null;
    }

    // Fungsi untuk menambah menu baru atau memperbarui jumlah jika menu sudah ada
    public void tambahAtauUpdate14(String namaPesanan14) {
        if (isEmpty14()) {
            head14 = tail14 = new NodeRekap14(namaPesanan14);
            size14++;
            return;
        }

        NodeRekap14 tmp = head14;
        boolean found = false;
        
        // Cek apakah menu sudah ada di list
        while (tmp != null) {
            if (tmp.namaPesanan14.equalsIgnoreCase(namaPesanan14)) {
                tmp.jumlah14++; // Jika ada, tambahkan jumlahnya 1
                found = true;
                break;
            }
            tmp = tmp.next14;
        }

        // Jika belum ada di list, tambahkan sebagai node baru di akhir (addLast)
        if (!found) {
            NodeRekap14 newNode = new NodeRekap14(namaPesanan14);
            tail14.next14 = newNode;
            newNode.prev14 = tail14;
            tail14 = newNode;
            size14++;
        }
    }

    // Insertion Sort Descending berdasarkan jumlah14 (menukar isi data)
    private void sortDescendingByJumlah14() {
        if (isEmpty14() || head14.next14 == null) return;

        NodeRekap14 sorted14 = head14.next14;
        while (sorted14 != null) {
            String keyNama = sorted14.namaPesanan14;
            int keyJumlah  = sorted14.jumlah14;
            NodeRekap14 prev14 = sorted14.prev14;

            // Geser ke belakang jika jumlahnya lebih kecil dari keyJumlah (agar Descending)
            while (prev14 != null && prev14.jumlah14 < keyJumlah) {
                prev14.next14.namaPesanan14 = prev14.namaPesanan14;
                prev14.next14.jumlah14      = prev14.jumlah14;
                prev14                      = prev14.prev14;
            }

            if (prev14 == null) {
                head14.namaPesanan14 = keyNama;
                head14.jumlah14      = keyJumlah;
            } else {
                prev14.next14.namaPesanan14 = keyNama;
                prev14.next14.jumlah14      = keyJumlah;
            }
            sorted14 = sorted14.next14;
        }
    }

    // Mencetak hasil rekap setelah diurutkan
    public void cetakRekap14() {
        if (isEmpty14()) {
            System.out.println("Belum ada data rekap pesanan.");
            return;
        }
        
        // Panggil algoritma pengurutan sebelum dicetak
        sortDescendingByJumlah14();
        
        System.out.println("======================================");
        System.out.println("REKAP PESANAN (URUT DESCENDING JUMLAH)");
        System.out.println("======================================");
        System.out.printf("%-20s %-10s%n", "Nama Pesanan", "Jumlah Terjual");
        NodeRekap14 tmp = head14;
        while (tmp != null) {
            System.out.printf("%-20s %-10d%n", tmp.namaPesanan14, tmp.jumlah14);
            tmp = tmp.next14;
        }
        System.out.println("--------------------------------------");
    }
}