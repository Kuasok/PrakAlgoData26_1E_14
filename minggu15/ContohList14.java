import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Percobaan 1: Penggunaan Collection untuk menambah, mengakses, dan menghapus elemen
 * Menunjukkan penggunaan ArrayList dengan tipe generic dan tanpa generic
 * Nomor Presensi: 14
 */
public class ContohList14 {
    public static void main(String[] args) {
        // List dengan generic Integer
        List<Integer> l14 = new ArrayList<>();
        
        // Menambahkan elemen ke list
        l14.add(1);
        l14.add(2);
        l14.add(3);
        l14.add(4);
        
        // Menampilkan elemen dengan enhanced for loop
        System.out.println("List l14:");
        for (Integer nilai14 : l14) {
            System.out.println(nilai14);
        }
        
        // List dengan generic String
        List<String> list14 = new ArrayList<>();
        list14.add("Coba");
        list14.add("Dua");
        list14.add("Tiga");
        
        System.out.println("\nList list14:");
        for (String s14 : list14) {
            System.out.println(s14);
        }
        
        // LinkedList dengan berbagai tipe data (menggunakan Object)
        List<Object> listObj14 = new LinkedList<>();
        listObj14.add(3.14);        // Double
        listObj14.add("Polinema");  // String
        listObj14.add(100);         // Integer
        listObj14.add(3.14f);       // Float
        listObj14.add(true);        // Boolean
        listObj14.add('A');         // Character
        
        System.out.println("\nList dengan berbagai tipe data (Object):");
        for (Object obj14 : listObj14) {
            System.out.println(obj14);
        }
        
        // List dengan tipe data spesifik (generic) - Hanya String
        List<String> listString14 = new ArrayList<>();
        listString14.add("Satu");
        listString14.add("Dua");
        listString14.add("Tiga");
        
        System.out.println("\nList dengan tipe data spesifik (String):");
        for (String s14 : listString14) {
            System.out.println(s14);
        }
        
        // Demonstrasi mengakses elemen berdasarkan index
        System.out.println("\nAkses elemen index 0 dari listString14: " + listString14.get(0));
        
        // Demonstrasi menghapus elemen
        listString14.remove(1); // Menghapus elemen index 1
        System.out.println("Setelah menghapus index 1: " + listString14);
    }
}
