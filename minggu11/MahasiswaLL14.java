public class MahasiswaLL14 {
    String nim14;
    String nama14;
    String kelas14;
    double ipk14;

    public MahasiswaLL14() {

    }

    public MahasiswaLL14(String nim14, String nama14, String kelas14, double ipk14) {
        this.nim14 = nim14;
        this.nama14 = nama14;
        this.kelas14 = kelas14;
        this.ipk14 = ipk14;
    }

    public void tampilInformasi() {
        System.out.println("NIM: " + nim14 + " | Nama: " + nama14 + " | Kelas: " + kelas14 + " | IPK: " + ipk14);
    }
}
