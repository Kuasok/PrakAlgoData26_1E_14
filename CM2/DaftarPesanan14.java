public class DaftarPesanan14 {
    NodePesanan14 head14;
    NodePesanan14 tail14;
    int size14;
    int totalPendapatan14;

    public DaftarPesanan14() {
        head14           = null;
        tail14           = null;
        size14           = 0;
        totalPendapatan14 = 0;
    }

    public boolean isEmpty14() {
        return head14 == null;
    }

    // Tambah pesanan - addLast
    public void tambahPesanan14(Pesanan14 pesanan14) {
        NodePesanan14 newNode14 = new NodePesanan14(pesanan14);
        if (isEmpty14()) {
            head14 = tail14 = newNode14;
        } else {
            tail14.next14    = newNode14;
            newNode14.prev14 = tail14;
            tail14           = newNode14;
        }
        size14++;
        totalPendapatan14 += pesanan14.harga14;
    }

    // Insertion Sort ascending berdasarkan namaPesanan14
    // Menukar data (bukan node) agar pointer DLL tetap valid
    private void insertionSortByNama14() {
        if (head14 == null || head14.next14 == null) return;

        NodePesanan14 sorted14 = head14.next14;
        while (sorted14 != null) {
            Pesanan14 key14       = sorted14.data14;
            NodePesanan14 prev14  = sorted14.prev14;

            while (prev14 != null
                    && prev14.data14.namaPesanan14
                               .compareToIgnoreCase(key14.namaPesanan14) > 0) {
                prev14.next14.data14 = prev14.data14;
                prev14               = prev14.prev14;
            }

            if (prev14 == null) {
                head14.data14 = key14;
            } else {
                prev14.next14.data14 = key14;
            }
            sorted14 = sorted14.next14;
        }
    }

    // Laporan pesanan – tampil terurut by namaPesanan
    public void laporanPesanan14() {
        if (isEmpty14()) {
            System.out.println("Belum ada pesanan.");
            return;
        }
        insertionSortByNama14();
        System.out.println("======================================");
        System.out.println("LAPORAN PESANAN (URUT NAMA PESANAN)");
        System.out.println("======================================");
        System.out.printf("%-14s %-20s %-10s %-15s%n",
            "Kode Pesanan", "Nama Pesanan", "Harga", "Pembeli");
        NodePesanan14 tmp14 = head14;
        while (tmp14 != null) {
            System.out.printf("%-14d %-20s %-10d %-15s%n",
                tmp14.data14.kodePesanan14,
                tmp14.data14.namaPesanan14,
                tmp14.data14.harga14,
                tmp14.data14.namaPembeli14);
            tmp14 = tmp14.next14;
        }
        System.out.println("--------------------------------------");
        System.out.println("Total Pendapatan : Rp " + totalPendapatan14);
        System.out.println("Jumlah Pesanan   : " + size14);
    }

    public int getTotalPendapatan14() {
        return totalPendapatan14;
    }

    public int getSize14() {
        return size14;
    }
}