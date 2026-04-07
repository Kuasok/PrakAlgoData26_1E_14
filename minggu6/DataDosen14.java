public class DataDosen14 {
    Dosen14[] dataDosen = new Dosen14[10];
    int idx;

    void tambah(Dosen14 dsn) {
        if (idx < dataDosen.length) {
            dataDosen[idx] = dsn;
            idx++;
        } else {
            System.out.println("Data dosen sudah penuh.");
        }
    }

    void tampil() {
        for (int i = 0; i < idx; i++) {
            dataDosen[i].tampil();
        }
    }

    // Sorting ASC berdasarkan usia – Bubble Sort
    void SortingASC() {
        for (int i = 0; i < idx - 1; i++) {
            for (int j = 1; j < idx - i; j++) {
                if (dataDosen[j - 1].usia > dataDosen[j].usia) {
                    Dosen14 tmp      = dataDosen[j];
                    dataDosen[j]     = dataDosen[j - 1];
                    dataDosen[j - 1] = tmp;
                }
            }
        }
    }

    // Sorting DSC berdasarkan usia – Selection Sort
    void sortingDSC() {
        for (int i = 0; i < idx - 1; i++) {
            int idxMax = i;
            for (int j = i + 1; j < idx; j++) {
                if (dataDosen[j].usia > dataDosen[idxMax].usia) {
                    idxMax = j;
                }
            }
            Dosen14 tmp        = dataDosen[idxMax];
            dataDosen[idxMax]  = dataDosen[i];
            dataDosen[i]       = tmp;
        }
    }

    // Insertion Sort ASC berdasarkan usia
    void insertionSort() {
        for (int i = 1; i < idx; i++) {
            Dosen14 temp = dataDosen[i];
            int j = i;
            while (j > 0 && dataDosen[j - 1].usia > temp.usia) {
                dataDosen[j] = dataDosen[j - 1];
                j--;
            }
            dataDosen[j] = temp;
        }
    }
}