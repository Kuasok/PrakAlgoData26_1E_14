public class SingleLinkedList14 {
    Node14 head14;
    Node14 tail14;

    public boolean isEmpty() {
        return head14 == null;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked List Kosong");
        } else {
            Node14 temp14 = head14;
            while (temp14 != null) {
                temp14.data14.tampilInformasi();
                temp14 = temp14.next14;
            }
        }
    }

    public void addFirst(Mahasiswa14 data14) {
        Node14 newNode14 = new Node14(data14, null);
        if (isEmpty()) {
            head14 = newNode14;
            tail14 = newNode14;
        } else {
            newNode14.next14 = head14;
            head14 = newNode14;
        }
    }

    public void addLast(Mahasiswa14 data14) {
        Node14 newNode14 = new Node14(data14, null);
        if (isEmpty()) {
            head14 = newNode14;
            tail14 = newNode14;
        } else {
            tail14.next14 = newNode14;
            tail14 = newNode14;
        }
    }

    public void insertAfter(Mahasiswa14 data14, String key14) {
        Node14 newNode14 = new Node14(data14, null);
        Node14 temp14 = head14;
        while (temp14 != null) {
            if (temp14.data14.nama14.equalsIgnoreCase(key14)) {
                newNode14.next14 = temp14.next14;
                temp14.next14 = newNode14;
                if (temp14 == tail14) {
                    tail14 = newNode14;
                }
                break;
            }
            temp14 = temp14.next14;
        }
    }

    public void addAtIndex(Mahasiswa14 data14, int index14) {
        if (index14 < 0) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        if (index14 == 0) {
            addFirst(data14);
            return;
        }
        Node14 newNode14 = new Node14(data14, null);
        Node14 temp14 = head14;
        for (int i14 = 0; i14 < index14 - 1; i14++) {
            if (temp14 == null) {
                System.out.println("Indeks melebihi panjang linked list.");
                return;
            }
            temp14 = temp14.next14;
        }
        if (temp14 == null) {
            System.out.println("Indeks melebihi panjang linked list.");
            return;
        }
        newNode14.next14 = temp14.next14;
        temp14.next14 = newNode14;
        if (temp14 == tail14) {
            tail14 = newNode14;
        }
    }

    public Mahasiswa14 getData(int index14) {
        Node14 temp14 = head14;
        for (int i14 = 0; i14 < index14; i14++) {
            if (temp14 == null) {
                System.out.println("Indeks melebihi panjang linked list.");
                return null;
            }
            temp14 = temp14.next14;
        }
        if (temp14 != null) {
            return temp14.data14;
        } else {
            System.out.println("Indeks melebihi panjang linked list.");
            return null;
        }
    }

    public int indexOf(String key14) {
        Node14 temp14 = head14;
        int index14 = 0;
        while (temp14 != null && !temp14.data14.nama14.equalsIgnoreCase(key14)) {
            temp14 = temp14.next14;
            index14++;
        }
        if (temp14 == null) {
            return -1;
        } else {
            return index14;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List Kosong, tidak dapat dihapus.");
        } else if (head14 == tail14) {
            head14 = tail14 = null;
        } else {
            head14 = head14.next14;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List Kosong, tidak dapat dihapus.");
        } else if (head14 == tail14) {
            head14 = tail14 = null;
        } else {
            Node14 temp14 = head14;
            while (temp14.next14 != tail14) {
                temp14 = temp14.next14;
            }
            temp14.next14 = null;
            tail14 = temp14;
        }
    }

    public void remove(String key14) {
        if (isEmpty()) {
            System.out.println("Linked List Kosong, tidak dapat dihapus.");
        } else {
            Node14 temp14 = head14;
            while (temp14 != null) {
                if (temp14.data14.nama14.equalsIgnoreCase(key14) && temp14 == head14) {
                    removeFirst();
                    break;
                } else if (temp14.next14 != null && temp14.next14.data14.nama14.equalsIgnoreCase(key14)) {
                    temp14.next14 = temp14.next14.next14;
                    if (temp14.next14 == null) {
                        tail14 = temp14;
                    }
                    break;
                }
                temp14 = temp14.next14;
            }
        }
    }

    public void removeAt(int index14) {
        if (index14 == 0) {
            removeFirst();
        } else {
            Node14 temp14 = head14;
            for (int i14 = 0; i14 < index14 - 1; i14++) {
                temp14 = temp14.next14;
            }
            temp14.next14 = temp14.next14.next14;
            if (temp14.next14 == null) {
                tail14 = temp14;
            }
        }
    }
}
