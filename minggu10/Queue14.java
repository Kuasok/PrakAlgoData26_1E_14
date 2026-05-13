public class Queue14 {
    int[] data14;
    int front14;
    int rear14;
    int size14;
    int max14;

    public Queue14(int n14) {
        max14 = n14;
        data14 = new int[max14];
        size14 = 0;
        front14 = rear14 = -1;
    }

    public boolean IsEmpty() {
        if (size14 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean IsFull() {
        if (size14 == max14) {
            return true;
        } else {
            return false;
        }
    }

    public void peek() {
        if (!IsEmpty()) {
            System.out.println("Elemen terdepan: " + data14[front14]);
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void print() {
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            int i14 = front14;
            while (i14 != rear14) {
                System.out.print(data14[i14] + " ");
                i14 = (i14 + 1) % max14;
            }
            System.out.println(data14[i14] + " ");
            System.out.println("Jumlah elemen = " + size14);
        }
    }

    public void clear() {
        if (!IsEmpty()) {
            front14 = rear14 = -1;
            size14 = 0;
            System.out.println("Queue berhasil dikosongkan");
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void Enqueue(int dt14) {
        if (IsFull()) {
            System.out.println("Queue sudah penuh");
        } else {
            if (IsEmpty()) {
                front14 = rear14 = 0;
            } else {
                if (rear14 == max14 - 1) {
                    rear14 = 0;
                } else {
                    rear14++;
                }
            }
            data14[rear14] = dt14;
            size14++;
        }
    }

    public int Dequeue() {
        int dt14 = 0;
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            dt14 = data14[front14];
            size14--;
            if (IsEmpty()) {
                front14 = rear14 = -1;
            } else {
                if (front14 == max14 - 1) {
                    front14 = 0;
                } else {
                    front14++;
                }
            }
        }
        return dt14;
    }
}