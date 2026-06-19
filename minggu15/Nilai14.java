/**
 * Class Nilai14 merepresentasikan data nilai mahasiswa untuk satu mata kuliah
 * Menghubungkan MahasiswaTugas14 dan MataKuliah14 dengan nilai
 * Nomor Presensi: 14
 */
public class Nilai14 {
    // Atribut nilai dengan suffix 14
    double nilai14;
    MahasiswaTugas14 mahasiswa14;
    MataKuliah14 mataKuliah14;

    // Konstruktor berparameter
    public Nilai14(MahasiswaTugas14 mahasiswa14, MataKuliah14 mataKuliah14, double nilai14) {
        this.mahasiswa14 = mahasiswa14;
        this.mataKuliah14 = mataKuliah14;
        this.nilai14 = nilai14;
    }

    // Konstruktor default
    public Nilai14() {
    }

    // Method untuk menampilkan data nilai lengkap
    @Override
    public String toString() {
        return String.format("%-10s | %-15s | %-10s | %-25s | %d  | %.2f",
                mahasiswa14.nim14, mahasiswa14.nama14,
                mataKuliah14.kodeMk14, mataKuliah14.namaMk14,
                mataKuliah14.sks14, nilai14);
    }
}
