public class PalindromeSubstrings{

	public static int countPalSubstrings(String s){
		int n= s.length();
        boolean dp[][]= new boolean[n][n];
        int count =0;
        
        //x axis is end 
        //y axis is start
        
        //We will be traversing diagonally
        for(int gap=0; gap< n; gap++){
            for(int row=0, col= gap; col < dp.length; row++, col++){

                //When # of char is 1
                if(gap == 0){
                    //When the gap is zero i.e when we are at diagonal position
                    dp[row][col]= true;
                }
                
                 //when # of char is == 2
                else if(gap == 1){
                     //When we are at 2nd digonal starting from 1st col to 2nd last row
                    if(s.charAt(row) == s.charAt(col)){
                        //if the 1st and last char is same
                       dp[row][col]= true;
                    }
                    else{
                        dp[row][col]= false;
                    }
                }
                
                //when # of character > 2
                else{
                    //dp will only be true is the 1st and last char is same 
                    //When the character inside the boundary which has been already stored is true
                    if(s.charAt(row) == s.charAt(col) && dp[row + 1][col-1] == true){
                        dp[row][col] = true;
                    }
                    else {
                        dp[row][col] = false;
                    }
                }
                
                //finally if we encounter current dp as true we increase count
                count += (dp[row][col]) ? 1 : 0;
            }
        }
        return count;
	}

	public static void main(String[] args) {
		String s="abc";
		System.out.println(countPalSubstrings(s));
		
	}
}