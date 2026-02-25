public class MataKuliahMain14 {
    public static void main(String[] args) {

        MataKuliah14 mk1 = new MataKuliah14();
        mk1.kodeMK = "ALSD25";
        mk1.nama = "Algoritma dan Struktur Data";
        mk1.sks = 3;
        mk1.jumlahJam = 6;

        System.out.println("--- Informasi Mata Kuliah 1 ---");
        mk1.tampilInformasi();
        mk1.ubahSKS(4);
        mk1.tambahJam(2);
        mk1.kurangiJam(3);
        
        System.out.println();


        MataKuliah14 mk2 = new MataKuliah14("PBO25", "Pemrograman Berorientasi Objek", 3, 6);
        System.out.println("--- Informasi Mata Kuliah 2 ---");
        mk2.tampilInformasi();
        mk2.kurangiJam(10);
    }
}