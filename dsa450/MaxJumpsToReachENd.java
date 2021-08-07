package Codes.dsa450;

public class MaxJumpsToReachENd {
    static int maxJumps(int arr[]){
        int currEnd=0, jumps=0, currFarthest=0;
        if(arr[0]==0) return -1;
        for(int i=0;i< arr.length-1;i++){
            currFarthest=Math.max(currFarthest, i+arr[i]);
            if(i==currEnd){
                jumps++;
                currEnd=currFarthest;
            }
        }
        return currFarthest>=arr.length-1?jumps:-1;
    }
    public static void main(String[] args) {
        int arr[]={1,4,3,2,6,7};
        System.out.println(maxJumps(arr));
    }
}
