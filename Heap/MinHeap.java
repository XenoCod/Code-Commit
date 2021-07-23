package Codes.Heap;

class MinHeap {
    int arr[];
    int size;
    int capacity;
    MinHeap(int c){
        arr= new int [c];
        capacity=c;
        size=0;

    }
    static int left(int i){
        return (2*i)+1;
    }
    static int right(int i){
        return (2*i)+2;
    }
    static int parent(int i){
        return (i-1)/2;
    }
    public void insert(int x){
        if(size==capacity)
            return;
        size++;
        arr[size-1]=x;
        for(int i=size-1;i!=0 && arr[parent(i)]>arr[i];){
            int temp=arr[i];
            arr[i]=arr[parent(i)];
            arr[parent(i)]=temp;
            i=parent(i);
        }


    }

    public void heapify(int i)  {
            int lt = left(i);
            int rt = right(i);
            int smallest = i;
            if (lt < size && arr[lt] < arr[i])
                smallest = lt;
            if (rt < size && arr[rt] < arr[smallest])
                smallest = rt;
            if (smallest != i) {
                int temp = arr[i];
                arr[i] = arr[smallest];
                arr[smallest] = temp;
                heapify(smallest);
            }
        }


    public int extractMin(){
        if (size <= 0)
            return Integer.MAX_VALUE;
        if (size == 1)
        {
            size--;
            return arr[0];
        }
        int temp = arr[0];
        arr[0] = arr[size-1];
        arr[size-1] = temp;
        size--;
        heapify(0);

        return arr[size];
    }


        public void print() {

            for (int i = 0; i < size; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }



        void decreaseKey(int i, int x)
        {
            arr[i] = x;
            while (i != 0 && arr[parent(i)] > arr[i])
            {
                int temp = arr[i];
                arr[i] = arr[parent(i)];
                arr[parent(i)] = temp;
                i = parent(i);
            }
        }

        void deleteKey(int i){
            decreaseKey(i, Integer.MIN_VALUE);
            extractMin();
        }




}




