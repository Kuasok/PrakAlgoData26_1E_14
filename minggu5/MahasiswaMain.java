public class MahasiswaMain {
    public static void main(String[] args) {

        Mahasiswa[] data = {
            new Mahasiswa("Ahmad", "220101001", 2022, 78, 82),
            new Mahasiswa("Budi",  "220101002", 2022, 85, 88),
            new Mahasiswa("Cindy", "220101003", 2021, 90, 87),
            new Mahasiswa("Dian",  "220101004", 2021, 76, 79),
            new Mahasiswa("Eko",   "220101005", 2023, 92, 95),
            new Mahasiswa("Fajar", "220101006", 2020, 88, 85),
            new Mahasiswa("Gina",  "220101007", 2023, 80, 83),
            new Mahasiswa("Hadi",  "220101008", 2020, 82, 84)
        };

        int n = data.length;
        int[] nilaiUTS = new int[n];
        int[] nilaiUAS = new int[n];

        for (int i = 0; i < n; i++) {
            nilaiUTS[i] = data[i].nilaiUTS;
            nilaiUAS[i] = data[i].nilaiUAS;
        }

        NilaiMahasiswa nm = new NilaiMahasiswa();


        int maxUTS = nm.maxUTS_DC(nilaiUTS, 0, n - 1);
        System.out.println("a) Nilai UTS Tertinggi (DC): " + maxUTS);


        int minUTS = nm.minUTS_DC(nilaiUTS, 0, n - 1);
        System.out.println("b) Nilai UTS Terendah (DC): " + minUTS);


        double rataUAS = nm.rataUAS_BF(nilaiUAS);
        System.out.println("c) Rata-rata Nilai UAS (BF): " + rataUAS);
    }
}
