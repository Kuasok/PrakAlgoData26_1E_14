public class BinaryTreeArray14 {
    Mahasiswa14[] dataMahasiswa;
    int idxLast;

    public BinaryTreeArray14() {
        this.dataMahasiswa = new Mahasiswa14[10];
        this.idxLast = 0;
    }

    // ===================== PERCOBAAN 2 =====================

    void populateData(Mahasiswa14 dataMhs[], int idxLast) {
        this.dataMahasiswa = dataMhs;
        this.idxLast = idxLast;
    }

    void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast) {
            if (dataMahasiswa[idxStart] != null) {
                traverseInOrder(2 * idxStart + 1);
                dataMahasiswa[idxStart].tampilInformasi();
                traverseInOrder(2 * idxStart + 2);
            }
        }
    }

    // ===================== TUGAS 4: add & traversePreOrder =====================

    public void add(Mahasiswa14 data) {
        if (idxLast < dataMahasiswa.length) {
            dataMahasiswa[idxLast] = data;
            idxLast++;
        } else {
            System.out.println("Array penuh, tidak bisa menambah data.");
        }
    }

    void traversePreOrder(int idxStart) {
        if (idxStart <= idxLast) {
            if (dataMahasiswa[idxStart] != null) {
                dataMahasiswa[idxStart].tampilInformasi();
                traversePreOrder(2 * idxStart + 1);
                traversePreOrder(2 * idxStart + 2);
            }
        }
    }
}
