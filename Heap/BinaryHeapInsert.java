package Codes.Heap;

public class BinaryHeapInsert {
    public static void main(String[] args) {
        MinHeap m= new MinHeap(15);
        m.insert(10);
        m.insert(20);
        m.insert(15);
        m.insert(40);
        m.insert(50);
        m.insert(100);
        m.insert(25);
        m.insert(45);
        System.out.println(m.extractMin());
        m.print();
        System.out.println();
        m.decreaseKey(3, 5);
        m.print();
        m.deleteKey(4);
        m.print();


    }
}
