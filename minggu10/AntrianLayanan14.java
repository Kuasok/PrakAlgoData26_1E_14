public class AntrianLayanan14 {
    Mahasiswa14[] data14;
    int front14;
    int rear14;
    int size14;
    int max14;

    public AntrianLayanan14(int max14) {
        this.max14 = max14;
        this.data14 = new Mahasiswa14[max14];
        this.front14 = 0;
        this.rear14 = -1;
        this.size14 = 0;
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

    public void tambahAntrian(Mahasiswa14 mhs14) {
        if (isFull()) {
            System.out.println("Antrian penuh, tidak dapat menambah mahasiswa.");
            return;
        }
        rear14 = (rear14 + 1) % max14;
        data14[rear14] = mhs14;
        size14++;
        System.out.println(mhs14.nama14 + " berhasil masuk ke antrian.");
    }

    public Mahasiswa14 layaniMahasiswa() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return null;
        }
        Mahasiswa14 mhs14 = data14[front14];
        front14 = (front14 + 1) % max14;
        size14--;
        return mhs14;
    }

    public void lihatTerdepan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.print("Mahasiswa terdepan: ");
            System.out.println("NIM - NAMA - PRODI - KELAS");
            data14[front14].tampilkanData();
        }
    }

    public void lihatAkhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.print("Mahasiswa paling belakang: ");
            System.out.println("NIM - NAMA - PRODI - KELAS");
            data14[rear14].tampilkanData();
        }
    }

    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Daftar Mahasiswa dalam Antrian:");
        System.out.println("NIM - NAMA - PRODI - KELAS");
        for (int i14 = 0; i14 < size14; i14++) {
            int index14 = (front14 + i14) % max14;
            System.out.print((i14 + 1) + ". ");
            data14[index14].tampilkanData();
        }
    }

    public int getJumlahAntrian() {
        return size14;
    }
}