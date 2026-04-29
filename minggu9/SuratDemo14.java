import java.util.Scanner;

public class SuratDemo14 {
    public static void main(String[] args) {
        StackSurat14 stack = new StackSurat14(10);
        Scanner scan = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Terima Surat Izin");
            System.out.println("2. Proses Surat Izin");
            System.out.println("3. Lihat Surat Izin Terakhir");
            System.out.println("4. Cari Surat");
            System.out.print("Pilih: ");
            pilih = scan.nextInt();
            scan.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("ID Surat          : ");
                    String id    = scan.nextLine();
                    System.out.print("Nama Mahasiswa    : ");
                    String nama  = scan.nextLine();
                    System.out.print("Kelas             : ");
                    String kelas = scan.nextLine();
                    System.out.print("Jenis Izin (S/I)  : ");
                    char jenis   = scan.nextLine().toUpperCase().charAt(0);
                    System.out.print("Durasi (hari)     : ");
                    int durasi   = scan.nextInt();
                    scan.nextLine();
                    Surat14 surat = new Surat14(id, nama, kelas, jenis, durasi);
                    stack.push(surat);
                    System.out.printf("Surat dari %s berhasil diterima.\n", nama);
                    break;
                case 2:
                    Surat14 diproses = stack.pop();
                    if (diproses != null) {
                        String keterangan = (diproses.jenisIzin == 'S') ? "Sakit" : "Izin";
                        System.out.println("Memproses surat dari : " + diproses.namaMahasiswa);
                        System.out.println("Kelas                : " + diproses.kelas);
                        System.out.println("Jenis Izin           : " + keterangan);
                        System.out.println("Durasi               : " + diproses.durasi + " hari");
                        System.out.println("Status               : Surat berhasil divalidasi.");
                    }
                    break;
                case 3:
                    Surat14 teratas = stack.peek();
                    if (teratas != null) {
                        String keterangan = (teratas.jenisIzin == 'S') ? "Sakit" : "Izin";
                        System.out.println("Surat terakhir masuk dari : " + teratas.namaMahasiswa);
                        System.out.println("Kelas                     : " + teratas.kelas);
                        System.out.println("Jenis Izin                : " + keterangan);
                        System.out.println("Durasi                    : " + teratas.durasi + " hari");
                    }
                    break;
                case 4:
                    System.out.print("Masukkan nama mahasiswa yang dicari: ");
                    String cari  = scan.nextLine();
                    Surat14 hasil = stack.cariSurat(cari);
                    if (hasil != null) {
                        String keterangan = (hasil.jenisIzin == 'S') ? "Sakit" : "Izin";
                        System.out.println("Surat ditemukan!");
                        System.out.println("ID Surat   : " + hasil.idSurat);
                        System.out.println("Nama       : " + hasil.namaMahasiswa);
                        System.out.println("Kelas      : " + hasil.kelas);
                        System.out.println("Jenis Izin : " + keterangan);
                        System.out.println("Durasi     : " + hasil.durasi + " hari");
                    } else {
                        System.out.println("Surat dari " + cari + " tidak ditemukan.");
                    }
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih >= 1 && pilih <= 4);
    }
}