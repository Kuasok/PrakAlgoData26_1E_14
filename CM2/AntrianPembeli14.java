public class AntrianPembeli14 {
    NodePembeli14 head14;
    NodePembeli14 tail14;
    int size14;
    int counter14; // nomor antrian otomatis

    public AntrianPembeli14() {
        head14   = null;
        tail14   = null;
        size14   = 0;
        counter14 = 0;
    }

    // Cek apakah antrian kosong
    public boolean isEmpty14() {
        return head14 == null;
    }

    // Dapatkan nomor antrian berikutnya
    public int getNextNoAntrian14() {
        return ++counter14;
    }

    // Tambah antrian - addLast (enqueue ke belakang)
    public void tambahAntrian14(Pembeli14 pembeli14) {
        NodePembeli14 newNode14 = new NodePembeli14(pembeli14);
        if (isEmpty14()) {
            head14 = tail14 = newNode14;
        } else {
            tail14.next14    = newNode14;
            newNode14.prev14 = tail14;
            tail14           = newNode14;
        }
        size14++;
    }

    // Hapus antrian - removeFirst (dequeue dari depan, FIFO)
    public Pembeli14 hapusAntrian14() {
        if (isEmpty14()) {
            System.out.println("Antrian kosong, tidak ada yang bisa dilayani.");
            return null;
        }
        Pembeli14 dilayani14 = head14.data14;
        if (head14 == tail14) {
            head14 = tail14 = null;
        } else {
            head14       = head14.next14;
            head14.prev14 = null;
        }
        size14--;
        return dilayani14;
    }

    // Cetak seluruh antrian
    public void cetakAntrian14() {
        if (isEmpty14()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("==============================");
        System.out.println("Daftar Antrian Pembeli");
        System.out.println("==============================");
        System.out.printf("%-12s %-20s %-15s%n", "No Antrian", "Nama", "No HP");
        NodePembeli14 tmp14 = head14;
        while (tmp14 != null) {
            System.out.printf("%-12d %-20s %-15s%n",
                tmp14.data14.noAntrian14,
                tmp14.data14.namaPembeli14,
                tmp14.data14.noHp14);
            tmp14 = tmp14.next14;
        }
    }

    // Tampilkan antrian terdepan (peek)
    public void lihatTerdepan14() {
        if (isEmpty14()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Antrian terdepan: " + head14.data14.namaPembeli14
                + " (No. " + head14.data14.noAntrian14 + ")");
        }
    }

    // Tampilkan antrian paling akhir
    public void lihatAkhir14() {
        if (isEmpty14()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Antrian paling akhir: " + tail14.data14.namaPembeli14
                + " (No. " + tail14.data14.noAntrian14 + ")");
        }
    }

    public int getSize14() {
        return size14;
    }
}