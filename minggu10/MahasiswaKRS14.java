public class MahasiswaKRS14 {
    String nim14;
    String nama14;
    String prodi14;
    String kelas14;

    public MahasiswaKRS14(String nim14, String nama14, String prodi14, String kelas14) {
        this.nim14 = nim14;
        this.nama14 = nama14;
        this.prodi14 = prodi14;
        this.kelas14 = kelas14;
    }

    public void tampilkanData() {
        System.out.println(nim14 + " - " + nama14 + " - " + prodi14 + " - " + kelas14);
    }
}