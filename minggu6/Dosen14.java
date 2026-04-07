public class Dosen14 {
    String kode;
    String nama;
    Boolean jenisKelamin;
    int usia;

    Dosen14(String kd, String name, Boolean jk, int age) {
        kode         = kd;
        nama         = name;
        jenisKelamin = jk;
        usia         = age;
    }

    void tampil() {
        System.out.println("Kode          : " + kode);
        System.out.println("Nama          : " + nama);
        System.out.println("Jenis Kelamin : " + (jenisKelamin ? "Pria" : "Wanita"));
        System.out.println("Usia          : " + usia);
        System.out.println("------------------------------");
    }
}