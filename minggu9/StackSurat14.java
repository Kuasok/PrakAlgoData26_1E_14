public class StackSurat14 {
    Surat14[] stack;
    int size;
    int top;

    public StackSurat14(int size) {
        this.size = size;
        stack     = new Surat14[size];
        top       = -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(Surat14 surat) {
        if (!isFull()) {
            top++;
            stack[top] = surat;
        } else {
            System.out.println("Stack penuh! Tidak bisa menerima surat lagi.");
        }
    }

    public Surat14 pop() {
        if (!isEmpty()) {
            Surat14 s = stack[top];
            top--;
            return s;
        } else {
            System.out.println("Stack kosong! Tidak ada surat untuk diproses.");
            return null;
        }
    }

    public Surat14 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack kosong! Tidak ada surat.");
            return null;
        }
    }

    public Surat14 cariSurat(String nama) {
        for (int i = top; i >= 0; i--) {
            if (stack[i].namaMahasiswa.equalsIgnoreCase(nama)) {
                return stack[i];
            }
        }
        return null;
    }

    public void print() {
        System.out.printf("%-10s %-15s %-8s %-10s %-6s%n",
                          "ID Surat", "Nama", "Kelas", "Jenis Izin", "Durasi");
        for (int i = top; i >= 0; i--) {
            String jenis = (stack[i].jenisIzin == 'S') ? "Sakit" : "Izin";
            System.out.printf("%-10s %-15s %-8s %-10s %-6d hari%n",
                    stack[i].idSurat, stack[i].namaMahasiswa,
                    stack[i].kelas, jenis, stack[i].durasi);
        }
        System.out.println();
    }
}