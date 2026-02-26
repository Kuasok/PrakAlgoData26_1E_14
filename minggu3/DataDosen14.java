public class DataDosen14 {
    public static void dataSemuaDosen(Dosen14[] arrayOfDosen) {
        int i = 1;
        System.out.println("\n--- Data Semua Dosen ---");
        for (Dosen14 d : arrayOfDosen) {
            System.out.println("Data Dosen ke-" + i++);
            System.out.println("Kode          : " + d.kode);
            System.out.println("Nama          : " + d.nama);
            System.out.println("Jenis Kelamin : " + (d.jenisKelamin ? "Pria" : "Wanita"));
            System.out.println("Usia          : " + d.usia);
            System.out.println("------------------------");
        }
    }
    
    public static void jumlahDosenPerJenisKelamin(Dosen14[] arrayOfDosen) {
        int pria = 0, wanita = 0;
        for (Dosen14 d : arrayOfDosen) {
            if (d.jenisKelamin) pria++;
            else wanita++;
        }
        System.out.println("\n--- Jumlah Dosen Per Jenis Kelamin ---");
        System.out.println("Pria   : " + pria);
        System.out.println("Wanita : " + wanita);
    }
    
    public static void rerataUsiaDosenPerJenisKelamin(Dosen14[] arrayOfDosen) {
        int totalUsiaPria = 0, totalUsiaWanita = 0;
        int pria = 0, wanita = 0;
        
        for (Dosen14 d : arrayOfDosen) {
            if (d.jenisKelamin) {
                totalUsiaPria += d.usia;
                pria++;
            } else {
                totalUsiaWanita += d.usia;
                wanita++;
            }
        }
        System.out.println("\n--- Rata-Rata Usia Dosen ---");
        if (pria > 0) System.out.println("Pria   : " + (totalUsiaPria / (float) pria));
        if (wanita > 0) System.out.println("Wanita : " + (totalUsiaWanita / (float) wanita));
    }
    
    public static void infoDosenPalingTua(Dosen14[] arrayOfDosen) {
        if (arrayOfDosen.length == 0) return;
        Dosen14 tertua = arrayOfDosen[0];
        for (Dosen14 d : arrayOfDosen) {
            if (d.usia > tertua.usia) tertua = d;
        }
        System.out.println("\n--- Dosen Paling Tua ---");
        System.out.println("Nama : " + tertua.nama + " (Usia: " + tertua.usia + ")");
    }
    
    public static void infoDosenPalingMuda(Dosen14[] arrayOfDosen) {
        if (arrayOfDosen.length == 0) return;
        Dosen14 termuda = arrayOfDosen[0];
        for (Dosen14 d : arrayOfDosen) {
            if (d.usia < termuda.usia) termuda = d;
        }
        System.out.println("\n--- Dosen Paling Muda ---");
        System.out.println("Nama : " + termuda.nama + " (Usia: " + termuda.usia + ")");
    }
}