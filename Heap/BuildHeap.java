package Codes.Heap;




public class BuildHeap {
    static int left(int i){   return 2*i+1;}
    static int right(int i) {return 2*i+2;}
    static  int parent(int i) {return  (i-1)/2;}

    static void heapify(int arr[], int i, int size){
        int lt=left(i), rt=right(i);
        int smallest=i;
        if (lt < size && arr[lt] < arr[i])
            smallest = lt;
        if (rt < size && arr[rt] < arr[smallest])
            smallest = rt;
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            heapify(arr, smallest, arr.length);
        }
    }
    static void buildHeap(int arr[]){
        for(int i=(arr.length-2)/2;i>=0;i--)
            heapify(arr,i,arr.length);
    }
    static void printHeap(int arr[]){
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }




    public static void main(String[] args) {
        int arr[]={10, 5, 20,2, 4,8};
        buildHeap(arr);
        printHeap(arr);

    }
}
