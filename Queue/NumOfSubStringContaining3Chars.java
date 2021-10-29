class NumOfSubStringContaining3Chars{

	private static int numberOfSubstrings(String s){
		int map[]= new int[3];
        
        int end=0, start=0, res=0;
        while(end < s.length()){
            map[s.charAt(end) - 'a']++;

            while(map[0] >= 1 && map[1] >=1 && map[2] >=1){//Keep sliding the window untill the condition satisfies
                res += s.length() - end;// no of substring from start to end
                		// System.out.println(s.substring(start, end + 1));
                map[s.charAt(start) - 'a']--;
                start++;
            }
            end++;
        }
        return res;
	}



	public static void main(String[] args) {
		//count no of substring with atleast one if of all 3 chars
		// Input: s = "abcabc"
		// Output: 10
// Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again)
				String s="abcabc";
				System.out.println(numberOfSubstrings(s));
	}

}