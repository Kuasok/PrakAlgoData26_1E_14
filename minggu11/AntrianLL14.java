public class AntrianLL14 {
    NodeAntrian14 head14;
    NodeAntrian14 tail14;
    int size14;
    int max14;

    public AntrianLL14(int max14) {
        this.max14 = max14;
        this.size14 = 0;
    }

    public boolean isEmpty() {
        return head14 == null;
    }

    public boolean isFull() {
        return size14 == max14;
    }

    public void clear() {
        head14 = tail14 = null;
        size14 = 0;
        System.out.println("Antrian berhasil dikosongkan.");
    }

    public void tambahAntrian(MahasiswaLL14 mhs14) {
        if (isFull()) {
            System.out.println("Antrian penuh, tidak dapat menambah mahasiswa.");
            return;
        }
        NodeAntrian14 newNode14 = new NodeAntrian14(mhs14, null);
        if (isEmpty()) {
            head14 = newNode14;
            tail14 = newNode14;
        } else {
            tail14.next14 = newNode14;
            tail14 = newNode14;
        }
        size14++;
        System.out.println(mhs14.nama14 + " berhasil masuk ke antrian.");
    }

    public MahasiswaLL14 panggilAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada mahasiswa untuk dipanggil.");
            return null;
        }
        MahasiswaLL14 mhs14 = head14.data14;
        head14 = head14.next14;
        if (head14 == null) {
            tail14 = null;
        }
        size14--;
        return mhs14;
    }

    public void lihatTerdepan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Mahasiswa terdepan:");
            head14.data14.tampilInformasi();
        }
    }

    public void lihatAkhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Mahasiswa paling akhir:");
            tail14.data14.tampilInformasi();
        }
    }

    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Daftar Mahasiswa dalam Antrian:");
        NodeAntrian14 temp14 = head14;
        int nomor14 = 1;
        while (temp14 != null) {
            System.out.print(nomor14 + ". ");
            temp14.data14.tampilInformasi();
            temp14 = temp14.next14;
            nomor14++;
        }
    }

    public int getJumlahAntrian() {
        return size14;
    }
}
