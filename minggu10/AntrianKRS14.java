public class AntrianKRS14 {
    MahasiswaKRS14[] data14;
    int front14;
    int rear14;
    int size14;
    int max14;
    int sudahKRS14;

    public AntrianKRS14(int max14) {
        this.max14 = max14;
        this.data14 = new MahasiswaKRS14[max14];
        this.front14 = 0;
        this.rear14 = -1;
        this.size14 = 0;
        this.sudahKRS14 = 0;
    }

    public boolean isEmpty() {
        if (size14 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (size14 == max14) {
            return true;
        } else {
            return false;
        }
    }

    public void clear() {
        if (!isEmpty()) {
            front14 = 0;
            rear14 = -1;
            size14 = 0;
            System.out.println("Antrian berhasil dikosongkan");
        } else {
            System.out.println("Antrian masih kosong");
        }
    }

    public void tambahAntrian(MahasiswaKRS14 mhs14) {
        if (isFull()) {
            System.out.println("Antrian penuh, tidak dapat menambah mahasiswa.");
            return;
        }
        rear14 = (rear14 + 1) % max14;
        data14[rear14] = mhs14;
        size14++;
        System.out.println(mhs14.nama14 + " berhasil masuk ke antrian.");
    }

    public MahasiswaKRS14[] prosesKRS() {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada mahasiswa untuk diproses.");
            return null;
        }
        int jumlahProses14 = Math.min(2, size14);
        MahasiswaKRS14[] diproses14 = new MahasiswaKRS14[jumlahProses14];
        System.out.println("Memproses KRS untuk " + jumlahProses14 + " mahasiswa:");
        for (int i14 = 0; i14 < jumlahProses14; i14++) {
            diproses14[i14] = data14[front14];
            front14 = (front14 + 1) % max14;
            size14--;
            sudahKRS14++;
            System.out.print((i14 + 1) + ". ");
            diproses14[i14].tampilkanData();
        }
        return diproses14;
    }

    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Daftar Mahasiswa dalam Antrian KRS:");
        System.out.println("NIM - NAMA - PRODI - KELAS");
        for (int i14 = 0; i14 < size14; i14++) {
            int index14 = (front14 + i14) % max14;
            System.out.print((i14 + 1) + ". ");
            data14[index14].tampilkanData();
        }
    }

    public void lihat2Terdepan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("2 Mahasiswa terdepan dalam antrian:");
        System.out.println("NIM - NAMA - PRODI - KELAS");
        int jumlah14 = Math.min(2, size14);
        for (int i14 = 0; i14 < jumlah14; i14++) {
            int index14 = (front14 + i14) % max14;
            System.out.print((i14 + 1) + ". ");
            data14[index14].tampilkanData();
        }
    }

    public void lihatAkhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.print("Mahasiswa paling akhir: ");
            System.out.println("NIM - NAMA - PRODI - KELAS");
            data14[rear14].tampilkanData();
        }
    }

    public int getJumlahAntrian() {
        return size14;
    }

    public int getSudahKRS() {
        return sudahKRS14;
    }

    public int getBelumKRS() {
        return 30 - sudahKRS14;
    }
}