import java.util.*;


class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        
        if(tokens == null || tokens.length == 0) return 0;
        Arrays.sort(tokens);
        if(power < tokens[0]) return 0;
        
        int start=0, end=tokens.length-1;
        int score=0;
        while(start <= end){
            if(power >= tokens[start]){
                power -= tokens[start];
                start++;
                score++;
            }
            else if(score >= 1 && start < end){
                power += tokens[end];
                end--;
                score--;
            }
            else break;
        }
        
        return score;
        
    }
}

class BagOfTokens{
	public static void main(String[] args) {
		Solution obj= new Solution();
		int nums[]={100,200,300,400};
		int power=200;
		
				System.out.println(obj.bagOfTokensScore(nums, power));
	}
}