public class DoubleLinkedList14 {
    Node14 head14;
    int size14;

    public DoubleLinkedList14() {
        head14 = null;
        size14 = 0;
    }

    public boolean isEmpty() {
        return head14 == null;
    }

    public void addFirst(Mahasiswa14 data14) {
        if (isEmpty()) {
            head14 = new Node14(null, data14, null);
        } else {
            Node14 newNode14 = new Node14(null, data14, head14);
            head14.prev14 = newNode14;
            head14 = newNode14;
        }
        size14++;
    }

    public void addLast(Mahasiswa14 data14) {
        if (isEmpty()) {
            addFirst(data14);
        } else {
            Node14 temp14 = head14;
            while (temp14.next14 != null) {
                temp14 = temp14.next14;
            }
            Node14 newNode14 = new Node14(temp14, data14, null);
            temp14.next14 = newNode14;
            size14++;
        }
    }

    public void add(Mahasiswa14 data14, int index14) {
        if (index14 < 0 || index14 > size14) {
            System.out.println("Indeks di luar batas.");
            return;
        }
        if (index14 == 0) {
            addFirst(data14);
        } else {
            Node14 temp14 = head14;
            for (int i14 = 0; i14 < index14 - 1; i14++) {
                temp14 = temp14.next14;
            }
            Node14 newNode14 = new Node14(temp14, data14, temp14.next14);
            if (temp14.next14 != null) {
                temp14.next14.prev14 = newNode14;
            }
            temp14.next14 = newNode14;
            size14++;
        }
    }

    public void insertAfter(String key14, Mahasiswa14 data14) {
        Node14 temp14 = head14;
        while (temp14 != null) {
            if (temp14.data14.nama14.equalsIgnoreCase(key14)) {
                Node14 newNode14 = new Node14(temp14, data14, temp14.next14);
                if (temp14.next14 != null) {
                    temp14.next14.prev14 = newNode14;
                }
                temp14.next14 = newNode14;
                size14++;
                break;
            }
            temp14 = temp14.next14;
        }
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong");
        } else {
            Node14 temp14 = head14;
            while (temp14 != null) {
                temp14.data14.tampil();
                temp14 = temp14.next14;
            }
        }
    }

    public void printReverse() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong");
        } else {
            Node14 temp14 = head14;
            while (temp14.next14 != null) {
                temp14 = temp14.next14;
            }
            while (temp14 != null) {
                temp14.data14.tampil();
                temp14 = temp14.prev14;
            }
        }
    }

    public Mahasiswa14 removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong, tidak dapat dihapus.");
            return null;
        }
        Mahasiswa14 dataHapus14 = head14.data14;
        if (head14.next14 == null) {
            head14 = null;
        } else {
            head14 = head14.next14;
            head14.prev14 = null;
        }
        size14--;
        return dataHapus14;
    }

    public Mahasiswa14 removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong, tidak dapat dihapus.");
            return null;
        }
        Mahasiswa14 dataHapus14;
        if (head14.next14 == null) {
            dataHapus14 = head14.data14;
            head14 = null;
        } else {
            Node14 temp14 = head14;
            while (temp14.next14.next14 != null) {
                temp14 = temp14.next14;
            }
            dataHapus14 = temp14.next14.data14;
            temp14.next14 = null;
        }
        size14--;
        return dataHapus14;
    }

    public Mahasiswa14 removeAfter(String key14) {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong, tidak dapat dihapus.");
            return null;
        }
        Node14 temp14 = head14;
        while (temp14 != null) {
            if (temp14.data14.nama14.equalsIgnoreCase(key14)) {
                if (temp14.next14 == null) {
                    System.out.println("Tidak ada node setelah " + key14 + " yang dapat dihapus.");
                    return null;
                }
                Mahasiswa14 dataHapus14 = temp14.next14.data14;
                temp14.next14 = temp14.next14.next14;
                if (temp14.next14 != null) {
                    temp14.next14.prev14 = temp14;
                }
                size14--;
                return dataHapus14;
            }
            temp14 = temp14.next14;
        }
        System.out.println("Key \"" + key14 + "\" tidak ditemukan.");
        return null;
    }

    public Mahasiswa14 remove(int index14) {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong, tidak dapat dihapus.");
            return null;
        }
        if (index14 < 0 || index14 >= size14) {
            System.out.println("Indeks di luar batas.");
            return null;
        }
        if (index14 == 0) {
            return removeFirst();
        }
        Node14 temp14 = head14;
        for (int i14 = 0; i14 < index14 - 1; i14++) {
            temp14 = temp14.next14;
        }
        Mahasiswa14 dataHapus14 = temp14.next14.data14;
        temp14.next14 = temp14.next14.next14;
        if (temp14.next14 != null) {
            temp14.next14.prev14 = temp14;
        }
        size14--;
        return dataHapus14;
    }

    public Mahasiswa14 getFirst() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
            return null;
        }
        return head14.data14;
    }

    public Mahasiswa14 getLast() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
            return null;
        }
        Node14 temp14 = head14;
        while (temp14.next14 != null) {
            temp14 = temp14.next14;
        }
        return temp14.data14;
    }

    public Mahasiswa14 getIndex(int index14) {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
            return null;
        }
        if (index14 < 0 || index14 >= size14) {
            System.out.println("Indeks di luar batas.");
            return null;
        }
        Node14 temp14 = head14;
        for (int i14 = 0; i14 < index14; i14++) {
            temp14 = temp14.next14;
        }
        return temp14.data14;
    }

    public int size() {
        return size14;
    }
}
