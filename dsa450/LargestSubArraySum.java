package Codes.dsa450;

public class LargestSubArraySum {
    static int subArraySum(int arr[]){
        int n=arr.length;
        int sum=0, res=arr[0];
        for(int i=0;i<n;i++){
            sum+=arr[i];
            res=Math.max(res,sum);
            if(sum<0) sum=0;

        }
        return res;
    }
    public static void main(String[] args) {
        int arr[]= {-1,-2,-3,-2,-5};
        System.out.println(subArraySum(arr));
    }
}
