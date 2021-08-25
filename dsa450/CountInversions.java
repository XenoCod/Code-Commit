package Codes.dsa450;

public class CountInversions {
    static int countInversion(int arr[], int n){
        return mergeSort(arr, 0, n-1);
    }
    static int mergeSort(int arr[], int start, int finish){
        int counter=0;
        if(start<finish){
            int mid=start + (finish-start)/2;
            counter+=mergeSort(arr, start, mid);
            counter+=mergeSort(arr, mid+1, finish);
            counter+=merge(arr, start, mid, finish);
        }
        return counter;
    }
    static int merge(int arr[], int start, int mid, int finish){
        int counter=0;
        int n1=mid-start+1;
        int n2=finish-mid;
        int L[]= new int[n1];
        int R[]= new int [n2];
        for(int i=0;i<n1;i++) L[i]=arr[start+i];
        for(int j=0;j<n2;j++) R[j]=arr[mid+1+j];
        int i=0, j=0, k=start;
        while(i<n1 && j< n2){
            if(L[i]<=R[j]) arr[k]=L[i++];
            else{
                arr[k]=R[j];
                counter+=(n1-i);
                j++;
            }
            k++;
        }
        while(i<n1) arr[k++]=L[i++];
        while (j<n2) arr[k++]=R[j++];
        return counter;
    }
    public static void main(String[] args) {
        int n = 5; int arr[] = {2, 4, 1, 3, 5};
        System.out.println(countInversion(arr, n));
    }
}
