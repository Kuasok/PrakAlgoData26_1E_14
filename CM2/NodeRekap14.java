public class NodeRekap14 {
    String namaPesanan14;
    int jumlah14;
    NodeRekap14 prev14;
    NodeRekap14 next14;

    public NodeRekap14(String namaPesanan14) {
        this.namaPesanan14 = namaPesanan14;
        this.jumlah14 = 1; // Saat pertama kali menu dibuat, jumlah otomatis 1
        this.prev14 = null;
        this.next14 = null;
    }
}