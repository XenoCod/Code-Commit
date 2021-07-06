package Codes.Matrix;

public class TransposeOfMatrix {
//    static int n=4;

    static void swap(int arr[][], int i, int j){
        int temp=arr[i][j];
        arr[i][j]=arr[j][i];
        arr[j][i]=temp;
    }
    static void transposeMatrix(int arr[][]){
        int n= arr.length;
        for(int i=0;i<n;i++) {
            for (int j = i + 1; j < n; j++)
                swap(arr, i, j);
        }
    }
    public static void main(String[] args) {

        int arr[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        transposeMatrix( arr);
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }
}
