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
        heap[size] = value;
        int current = size;
        size++;

        // Heapify up
        while(current > 0 && heap[current] < heap[(current-1)/2]){
            int parent = (current -1 )/2;
            //Swap
            int temp = heap[parent];
            heap[parent] = heap[current];
            heap[current] = temp;

            current = parent;
        }
    }

// Display Elements
    void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Delete Element
    int deleteMin(){
        if (size<=1) return -1;
        int root = heap[0];
        heap [0] = heap[size-1];
        size--;

        // Heapify
        Heapify(0);
        return root;
    }
    int Heapify(int i){
        int smallest = i;
        int l = left(i);
        int r = right(i);

        if(l < size && heap[l] < heap[smallest])
            smallest = l;
        if(r< size && heap[r] < heap[smallest])
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
        heap[size] = value;
        int current = size;
        size++;
        //Heapify
        while(current>0 && heap[current] > heap[(current - 1)/2]){
            int parent = (current -1)/2;

            // swap
            int temp = heap[parent];
            heap[parent] = heap[current];
            heap[current] = temp;

            current = parent;
        }
    }

    void display(){
        for(int i = 0; i<size; i++){
            System.out.println(heap[i] + " ");
        }
        System.out.println();
    }

    //Delete Max
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
            System.out.println("Enter Your Choice");
            choice = sc.nextInt();
            System.out.println();
            switch(choice){
                case 1:
                    System.out.println("Enter Value to Insert In MinHeap");
                    value = sc.nextInt();
                    m.insert(value);
                    break;
                case 2:
                   System.out.println("MinHeap: ");
                   m.display();
                   break;
                case 3:
                    System.out.println("Enter Value to Insert In Maxheap");
                    value = sc.nextInt();
                    h.insert(value);
                    break;
                case 4:
                    System.out.println("MaxHeap: ");
                    m.display();
                    break;
                case 5:
                    m.deleteMin();
                    System.out.println("New MinHeap: ");
                    m.display();
                    break;
                case 6:
                System.out.println("DeleteMax");
                h.deleteMax();
                System.out.println("New MaxHeap");
                h.display();
                break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Input! Try Again");
                    break;
            }
        } while(choice != 0);
    }
}
