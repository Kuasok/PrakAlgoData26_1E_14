/**
 * Class MataKuliah14 merepresentasikan data mata kuliah untuk tugas daftar nilai
 * Menyimpan informasi kode MK, nama MK, dan jumlah SKS
 * Nomor Presensi: 14
 */
public class MataKuliah14 {
    // Atribut mata kuliah dengan suffix 14
    String kodeMk14;
    String namaMk14;
    int sks14;

    // Konstruktor berparameter
    public MataKuliah14(String kodeMk14, String namaMk14, int sks14) {
        this.kodeMk14 = kodeMk14;
        this.namaMk14 = namaMk14;
        this.sks14 = sks14;
    }

    // Konstruktor default
    public MataKuliah14() {
    }

    // Method untuk menampilkan data mata kuliah
    @Override
    public String toString() {
        return String.format("%-10s | %-25s | %d", kodeMk14, namaMk14, sks14);
    }
}
