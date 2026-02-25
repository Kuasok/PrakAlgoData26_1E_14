public class DosenMain14 {
    public static void main(String[] args) {
        Dosen14 dosen1 = new Dosen14();
        dosen1.idDosen = "D001";
        dosen1.nama = "Budi Santoso";
        dosen1.statusAktif = true;
        dosen1.tahunBergabung = 2015;
        dosen1.bidangKeahlian = "Basis Data";

        System.out.println("--- Informasi Dosen 1 ---");
        dosen1.tampilInformasi();
        dosen1.setStatusAktif(false);
        System.out.println("Masa Kerja: " + dosen1.hitungMasaKerja(2026) + " tahun");
        
        System.out.println();

        Dosen14 dosen2 = new Dosen14("D002", "Siti Aminah", true, 2018, "Kecerdasan Buatan");
        System.out.println("--- Informasi Dosen 2 ---");
        dosen2.tampilInformasi();
        dosen2.ubahKeahlian("Machine Learning");
        System.out.println("Masa Kerja: " + dosen2.hitungMasaKerja(2026) + " tahun");
    }
}