package Codes.DynamicProgramming;

public class LongestIncreasingSubSequence {
    static int lis(int arr[]){
        int n=arr.length;
        int tail[]=  new int [n];
        tail[0]=arr[0];
        int len=1;
        for(int i=1;i<n;i++){
            if(arr[i]>tail[len-1]){
                tail[len]=arr[i];
                len++;
            }
            else{
                int ceilIndex=ceil(tail,0, len-1,arr[i]);
                tail[ceilIndex]=arr[i];
            }
        }
        return len;
    }

    static int ceil(int arr[], int l, int r, int x){
        while(r>l){
            int mid=l+(r-l)/2;
            if(arr[ mid]>=x)
                r=mid;
            else
                l=mid+1;
        }
        return r;
    }
    public static void main(String[] args) {
        int arr[]={3,10, 20, 4, 6,7};
        System.out.println(lis(arr));
        
    }
}
