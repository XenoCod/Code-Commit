package Codes.dsa450;

public class NextPermutation {
    static void nextPermutation(int arr[]){
        int n=arr.length;
        if(n<=1) return;
        int i=n-2;
        while(i>=0 && arr[i+1]<=arr[i]) i--;
        if(i>=0){
            int j=n-1;
            while(arr[i] >= arr[j]) j--;
            swap(arr, i, j);

        }
        reverse(arr, i+1, n-1);

    }
    static private void swap(int arr[], int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    static private void reverse(int arr[], int l, int r){
        while(l<r) swap(arr, l++, r--);
    }
    public static void main(String[] args) {
        int arr[]={1,5, 8, 9};
        nextPermutation(arr);
        for(int i:arr)
            System.out.print(i+" ");
    }
}
