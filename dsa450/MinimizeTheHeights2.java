package Codes.dsa450;

import java.util.Arrays;

public class MinimizeTheHeights2 {
    static int getMin(int arr[], int k){
        Arrays.sort(arr);
        int n=arr.length;
        int ans=arr[n-1]-arr[0];
        int smallest=arr[0]+k;
        int largest=arr[n-1]-k;
        int min, max;
        for(int i=0;i<n-1;i++){
            min=Math.min(smallest, arr[i+1]-k);
            max=Math.max(largest, arr[i]+k);
            if(min<0) continue;;
            ans=Math.min(ans, max-min);
        }
        return ans;

    }
    public static void main(String[] args) {
        int arr[]={12, 16,3,9,20};
        int k=3;
        System.out.println(getMin(arr, k));
    }
}
