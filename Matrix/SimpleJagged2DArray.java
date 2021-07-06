package Codes.Matrix;

public class SimpleJagged2DArray {
    public static void main(String[] args) {
        int m=3;
        int arr[][]= new int[m][];
        for(int i=0;i<arr.length;i++){
            arr[i]=new int [i+1];
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]=i+1;
                System.out.print(arr[i][j]+" ");
            }

            System.out.println();
        }
    }
}
