package Codes.Searching;
import java.util.*;

public class FloyddLoopAlgo {
    /* Question follows below constraints
    * Find the most repeating element in the array
    * arr.length>=2
    * Only one element repeats any number of times
    * All the elements from 0 to max(arr) are present
    * so, arr[element] = 0<=max(arr)<=n-2
    * Not allowed to modify the array
    * */
    static int mostRepeatedWithout0s(int arr[], int n){
//        if the arr does not contain 0
//    we intialize two element slow and fast to transerve the array fast moves 2x slow's speed
//this guraantees the slow and fast will meet at some point and we have the point and return the slow or fast element

        //1st phase to find the loop within the array
        int slow= arr[0], fast=arr[0];
        do{
            slow=arr[slow];
            fast= arr[arr[fast]];
        }while(slow!=fast);
        //2nd phase to find the loop endpoint in the array
        slow=arr[0];
        while(slow!=fast){
            slow=arr[slow];
            fast=arr[fast];
        }
        return slow;

    }

    //If the array contains 0s then we add the +1 to slow and fast value to avoid self loops
    // and so we just assume all the index are starting from element 1
    static int mostReapeatedWith0s(int arr[], int n){
        int slow =arr[0]+1;
        int fast=arr[0]+1;
        do{
            slow=arr[slow]+1;
            fast=arr[arr[fast]+1]+1;

        }while(slow!=fast);
        //2nd phase
        slow=arr[0]+1;
        while(slow!=fast){
            slow=arr[slow]+1;
            fast=arr[fast]+1;
        }
        return slow-1;

    }


    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter size");
        int n=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("Enter elements");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println(mostRepeatedWithout0s(arr,n));
        System.out.println(mostReapeatedWith0s(arr,n));


    }
}
