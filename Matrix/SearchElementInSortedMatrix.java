package Codes.Matrix;

public class SearchElementInSortedMatrix {
    static void printLocation(int arr[][], int k){
        int row=4,column=5;
        int i=0, j=column-1;
        while(i<row && j>=0){
            if(arr[i][j]==k) {
                System.out.println("Element at index at row " + (i+1) + " & coloum " + (j+1));
                return;
            }

            else if (arr[i][j]>k)
                j--;
            else
                i++;

        }
        System.out.println("Not found");


    }
    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14 , 15},
                {16, 17, 18, 19, 20}};
        int k=12;//the elment to be searched
        printLocation(arr, k);
    }
}
