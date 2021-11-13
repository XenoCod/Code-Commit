package Codes.Matrix;

public class BoundaryOfMatrix {
    static int r=4, c=4;
    static void printBoundary(int arr[][]){
        //Handing the corner cases
        if(r==1)jj
            for(int i=0;i<c;i++)
                System.out.print(arr[0][i]+" ");

        else if(c==1)
            for(int i=1;i<r;i++)
                System.out.print(arr[i][0]+" ");

        //normal cases
        else {
            //Printing 1st row
            for (int i=0;i<c;i++)
                System.out.print(arr[0][i]+" ");
            //printing last coloum
            for(int i=1;i<r;i++)
                System.out.print(arr[i][c-1]+" ");
            //Printing last row
            for(int i=c-2;i>=0;i--)
                System.out.print(arr[r-1][i]+" ");
            //Printing the first coloum
            for(int i=r-2;i>=0;i--)
                System.out.print(arr[i][0]+" ");
        }


    }


    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        printBoundary( arr);
    }
}
