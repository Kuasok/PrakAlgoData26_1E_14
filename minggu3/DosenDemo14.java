import java.util.Scanner;

public class DosenDemo14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jumlah dosen: ");
        int jumlah = Integer.parseInt(sc.nextLine());
        
        Dosen14[] arrayOfDosen = new Dosen14[jumlah];
        
        for(int i = 0; i < arrayOfDosen.length; i++) {
            System.out.println("Masukkan Data Dosen ke-" + (i + 1));
            System.out.print("Kode          : ");
            String kode = sc.nextLine();
            System.out.print("Nama          : ");
            String nama = sc.nextLine();
            System.out.print("Jenis Kelamin (Pria/Wanita): ");
            String jkInput = sc.nextLine();
            boolean jk = jkInput.equalsIgnoreCase("Pria");
            System.out.print("Usia          : ");
            int usia = Integer.parseInt(sc.nextLine());
            System.out.println("-----------------------------------");
            
            arrayOfDosen[i] = new Dosen14(kode, nama, jk, usia);
        }
        
        DataDosen14.dataSemuaDosen(arrayOfDosen);
        DataDosen14.jumlahDosenPerJenisKelamin(arrayOfDosen);
        DataDosen14.rerataUsiaDosenPerJenisKelamin(arrayOfDosen);
        DataDosen14.infoDosenPalingTua(arrayOfDosen);
        DataDosen14.infoDosenPalingMuda(arrayOfDosen);
    }
}