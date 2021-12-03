package Matrix;

public class GridGame {
    public static void main(String[] args) {
        int n= grid[0].length;
        long nums[][]= new long[2][n];
        long res=Long.MAX_VALUE;

        long upperRight= 0, lowerLeft= 0;

        // Taken by the ROBOT 1
        for(int i: grid[0])
            upperRight += i;

        for(int i=0; i< grid[0].length; i++){
            upperRight -= grid[0][i];//Relased by the robot 1
            res= Math.min(res, Math.max(upperRight, lowerLeft));
            lowerLeft += grid[1][i];//picked by the robot 2
        }
        return res;
    }
}
