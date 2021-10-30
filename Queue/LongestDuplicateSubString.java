import java.util.HashSet;
import java.util.Set;

class LongestDuplicateSubString{

	private  String longDupString(String s){
		//Binary Search + Rabin karp
        
        //hash() = returns the hashcode of the string
        //nextHash() = returns the hash for the upcoming string by ading 1char and removing 1 char from front
        //dup()= checks for the duplicates
        
        int low=0, high = s.length();
        String res="";
        while(low <= high){
            int mid= low + (high - low) / 2;
            String duplicate= getDuplicate(mid, s);
            
            if(duplicate != null){
                res = duplicate;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return res;
	}




	private String getDuplicate(int size, String s){
        long hashcode= hash(s.substring(0, size));
        
        Set<Long> set= new HashSet<>();
        set.add(hashcode);
        
        long pow=1;
        for(int i=1; i< size; i++) 
            pow *= 31;
        
        //Rolling hash
        for(int i= size; i< s.length(); i++){
            hashcode= nextHash(pow, hashcode, s.charAt(i - size), s.charAt(i));
            
            if(!set.add(hashcode)){
                return s.substring(i- size + 1, i + 1);
            }
        }
        
        return null;
    }
    

    private long hash(String s){
        long hash=0;
        long pow=1;
        
        for(int i=s.length()-1; i >= 0; i--){
            char ch= s.charAt(i);
            hash += (ch - 'a' + 1) * pow;
            pow = (pow * 31);
        }
        
        return hash;
    }
    


    private long nextHash(long pow, long hashCode, char oldChar, char nextChar){
        return (hashCode - (oldChar - 'a' + 1) * pow) * 31 + (nextChar - 'a' + 1);
    }


	public static void main(String[] args) {
		String s="banana";

		// Input: s = "banana"
		// Output: "ana"
		LongestDuplicateSubString obj= new LongestDuplicateSubString();
				System.out.println(obj.longDupString(s));
	}
}