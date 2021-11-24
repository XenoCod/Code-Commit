//Count the vowels of all substring of a string
// Input: word = "aba"
// Output: 6
// Explanation: 
// All possible substrings are: "a", "ab", "aba", "b", "ba", and "a".
// - "b" has 0 vowels in it
// - "a", "ab", "ba", and "a" have 1 vowel each
// - "aba" has 2 vowels in it
// Hence, the total sum of vowels = 0 + 1 + 1 + 1 + 1 + 2 = 6.

public class VowelsOfStrings{
	public static void main(String[] args) {
		 long res=0, prev= 0;
        for(int i=0; i< word.length(); i++){
            char c= word.charAt(i);
            if(c == 'a' || c == 'e' || c =='i' || c == 'o' || c=='u')
                prev += (i + 1);
            res += prev;
        }
        return res;
	}
} 
