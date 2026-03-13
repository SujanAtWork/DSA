import java.util.*;

class MinHeap{
    int[] heap;
    int size;
    int capacity;

    MinHeap(int capacity){
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return 2 * i + 1; }
    int right(int i) { return 2 * i + 2; }

    // Insert Elements
    void insert(int value){
        if(size == capacity){
            System.out.println("Heap is full");
            return;
        }

        heap[size] = value;
        int current = size;
        size++;

        // Heapify up
        while(current > 0 && heap[current] < heap[parent(current)]){
            int p = parent(current);

            int temp = heap[p];
            heap[p] = heap[current];
            heap[current] = temp;

            current = p;
        }
    }

    // Display Elements
    void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Delete Min
    int deleteMin(){
        if (size <= 0) return -1;

        int root = heap[0];
        heap[0] = heap[size-1];
        size--;

        heapify(0);
        return root;
    }

    void heapify(int i){
        int smallest = i;
        int l = left(i);
        int r = right(i);

        if(l < size && heap[l] < heap[smallest])
            smallest = l;

        if(r < size && heap[r] < heap[smallest])
            smallest = r;

        if (smallest != i) {
            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;

            heapify(smallest);
        }
    }
}

class MaxHeap{
    int[] heap;
    int size;
    int capacity;

    MaxHeap(int capacity){
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return 2 * i + 1; }
    int right(int i) { return 2 * i + 2; }

    void insert(int value){
        if(size == capacity){
            System.out.println("Heap is full");
            return;
        }

        heap[size] = value;
        int current = size;
        size++;

        // Heapify up
        while(current > 0 && heap[current] > heap[parent(current)]){
            int p = parent(current);

            int temp = heap[p];
            heap[p] = heap[current];
            heap[current] = temp;

            current = p;
        }
    }

    void display(){
        for(int i = 0; i < size; i++){
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Delete Max
    int deleteMax() {
        if (size <= 0) return -1;

        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;

        heapify(0);

        return root;
    }

    void heapify(int i) {
        int largest = i;
        int l = left(i);
        int r = right(i);

        if (l < size && heap[l] > heap[largest])
            largest = l;

        if (r < size && heap[r] > heap[largest])
            largest = r;

        if (largest != i) {
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;

            heapify(largest);
        }
    }
}

public class Heap{
    public static void main(String[] args){
        MinHeap m = new MinHeap(10);
        MaxHeap h = new MaxHeap(10);
        Scanner sc = new Scanner(System.in);

        int choice;
        int value;

        do{
            System.out.println("==== Heap ====");
            System.out.println("1. Insert In MinHeap");
            System.out.println("2. Display MinHeap");
            System.out.println("3. Insert in MaxHeap");
            System.out.println("4. Display MaxHeap");
            System.out.println("5. Delete Min");
            System.out.println("6. Delete Max");
            System.out.println("0. Exit");
            System.out.print("Enter Your Choice: ");

            choice = sc.nextInt();
            System.out.println();

            switch(choice){
                case 1:
                    System.out.print("Enter Value to Insert In MinHeap: ");
                    value = sc.nextInt();
                    m.insert(value);
                    break;

                case 2:
                    System.out.print("MinHeap: ");
                    m.display();
                    break;

                case 3:
                    System.out.print("Enter Value to Insert In MaxHeap: ");
                    value = sc.nextInt();
                    h.insert(value);
                    break;

                case 4:
                    System.out.print("MaxHeap: ");
                    h.display();
                    break;

                case 5:
                    m.deleteMin();
                    System.out.print("New MinHeap: ");
                    m.display();
                    break;

                case 6:
                    h.deleteMax();
                    System.out.print("New MaxHeap: ");
                    h.display();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Input! Try Again");
            }

        } while(choice != 0);

        sc.close();
    }
}
