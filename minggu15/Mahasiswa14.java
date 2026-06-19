/**
 * Class Mahasiswa14 merepresentasikan data mahasiswa
 * digunakan sebagai objek dalam collection ListMahasiswa14
 * Nomor Presensi: 14
 */
public class Mahasiswa14 {
    // Atribut mahasiswa dengan suffix 14
    String nim14;
    String nama14;
    String tglLahir14;
    String gender14;

    // Konstruktor default
    public Mahasiswa14() {
    }

    // Konstruktor berparameter
    public Mahasiswa14(String nim14, String nama14, String tglLahir14, String gender14) {
        this.nim14 = nim14;
        this.nama14 = nama14;
        this.tglLahir14 = tglLahir14;
        this.gender14 = gender14;
    }

    // Method untuk menampilkan data mahasiswa
    @Override
    public String toString() {
        return "Mahasiswa{" +
                "nim='" + nim14 + '\'' +
                ", nama='" + nama14 + '\'' +
                ", tglLahir='" + tglLahir14 + '\'' +
                ", gender='" + gender14 + '\'' +
                '}';
    }
}
