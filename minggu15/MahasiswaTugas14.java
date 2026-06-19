/**
 * Class MahasiswaTugas14 merepresentasikan data mahasiswa untuk tugas daftar nilai
 * Menyimpan informasi NIM, nama, dan nomor telepon mahasiswa
 * Nomor Presensi: 14
 */
public class MahasiswaTugas14 {
    // Atribut mahasiswa dengan suffix 14
    String nim14;
    String nama14;
    String telp14;

    // Konstruktor berparameter
    public MahasiswaTugas14(String nim14, String nama14, String telp14) {
        this.nim14 = nim14;
        this.nama14 = nama14;
        this.telp14 = telp14;
    }

    // Konstruktor default
    public MahasiswaTugas14() {
    }

    // Method untuk menampilkan data mahasiswa
    @Override
    public String toString() {
        return String.format("%-10s | %-15s | %-15s", nim14, nama14, telp14);
    }
}
