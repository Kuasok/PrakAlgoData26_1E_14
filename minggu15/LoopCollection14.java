import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

/**
 * Percobaan 2: Menampilkan berbagai cara untuk mengakses elemen pada collection Stack
 * Menunjukkan penggunaan push, pop, peek, iterator, dan sorting pada Stack
 * Nomor Presensi: 14
 */
public class LoopCollection14 {
    public static void main(String[] args) {
        // Membuat Stack dengan tipe data String
        Stack<String> fruits14 = new Stack<>();
        
        // Menambahkan elemen menggunakan push() dan add()
        fruits14.push("Banana");
        fruits14.add("Orange");
        fruits14.add("Watermelon");
        fruits14.add("Leci");
        fruits14.push("Salak");
        
        // Menampilkan elemen menggunakan for-each loop
        System.out.println("Menampilkan elemen menggunakan for-each:");
        for (String fruit14 : fruits14) {
            System.out.println(fruit14);
        }
        
        // Menampilkan elemen menggunakan iterator
        System.out.println("\nMenampilkan elemen menggunakan Iterator:");
        Iterator<String> iterator14 = fruits14.iterator();
        while (iterator14.hasNext()) {
            System.out.println(iterator14.next());
        }
        
        // Menampilkan elemen menggunakan for-each dengan method reference
        System.out.println("\nMenampilkan elemen menggunakan forEach:");
        fruits14.forEach(System.out::println);
        
        // Menampilkan elemen terakhir menggunakan peek()
        System.out.println("\nElemen terakhir (peek): " + fruits14.peek());
        
        // Menghapus elemen teratas menggunakan pop()
        fruits14.pop();
        System.out.println("Setelah pop(), elemen terakhir: " + fruits14.peek());
        
        // Menghapus elemen tertentu menggunakan remove()
        fruits14.remove("Leci");
        System.out.println("\nSetelah menghapus 'Leci':");
        fruits14.forEach(System.out::println);
        
        // Mengubah elemen terakhir menjadi "Strawberry"
        fruits14.set(fruits14.size() - 1, "Strawberry");
        System.out.println("\nSetelah mengubah elemen terakhir menjadi 'Strawberry':");
        fruits14.forEach(System.out::println);
        
        // Menambahkan 3 buah baru dan melakukan sorting
        fruits14.push("Mango");
        fruits14.push("Guava");
        fruits14.push("Avocado");
        
        System.out.println("\nSetelah menambahkan Mango, Guava, Avocado:");
        fruits14.forEach(System.out::println);
        
        // Sorting ascending
        Collections.sort(fruits14);
        System.out.println("\nSetelah sorting ascending:");
        fruits14.forEach(System.out::println);
        
        // Sorting descending
        Collections.sort(fruits14, Collections.reverseOrder());
        System.out.println("\nSetelah sorting descending:");
        fruits14.forEach(System.out::println);
        
        // Menampilkan elemen menggunakan while loop dan pop() (mengosongkan stack)
        System.out.println("\nMengosongkan stack menggunakan while + pop():");
        while (!fruits14.isEmpty()) {
            System.out.println("Pop: " + fruits14.pop());
        }
    }
}
