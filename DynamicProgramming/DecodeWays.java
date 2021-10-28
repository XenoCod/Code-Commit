class DecodeWays{

	private static int decode(String s){
		int dp[]= new int[s.length()];
        if(s.length() == 1){
            if(s.equals("0")) return 0;
            else return 1;
        }
        
        dp[0]= (s.charAt(0) == '0') ? 0 : 1;
        
        for(int i=1; i<s.length(); i++){
            char curr= s.charAt(i);
            char prev= s.charAt(i-1);
            
            if(prev == '0' && curr == '0') dp[i] =0;
            
            else if(prev == '0' && curr != '0') dp[i]= dp[i-1];
            
            else if(prev != '0' && curr == '0'){
                if(prev == '1' || prev == '2')
                    dp[i]= (i >=2 ? dp[i-2] : 1);
                else 
                    dp[i]=0;
            }
            
            else{
                dp[i]= dp[i-1];
                
                if(Integer.parseInt(s.substring(i-1, i+1)) <= 26)
                    dp[i] += (i >= 2 ? dp[i-2] : 1);
            }
        }
        return dp[s.length() -1];
	}


	public static void main(String[] args) {
		String s="226";
				System.out.println(decode(s));
		/*
		'A' -> "1"
	'B' -> "2"
...
	'Z' -> "26"

	Input: s = "226"
	Output: 3
	Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).


	Input: s = "12"
	Output: 2
	Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
		*/
	}
}