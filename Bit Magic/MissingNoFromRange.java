import java.util.Scanner;

public class MissingNoFromRange {
    static  int missingNum(int arr[], int n, int r){
        int res=0;
        int temp=0;
        for(int i=1;i<=r;i++){
            res^=i;
        }
        for(int i=0;i<n;i++){
            temp^=arr[i];
        }
        return res^temp;

    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int range=sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println(missingNum(arr,n,range));
    }
}