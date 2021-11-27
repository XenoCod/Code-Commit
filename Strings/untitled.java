/*
Input: street = "H..H"
Output: 2
Explanation:
We can put buckets at index 1 and index 2.
"H..H" -> "HBBH" ('B' denotes where a bucket is placed).
The house at index 0 has a bucket to its right, and the house at index 3 has a bucket to its left.
Thus, for every house, there is at least one bucket collecting rainwater from it.
*/

class MinBucketsToCollectRainwater{
	public static void main(String[] args) {
		int count=0;
        int n= s.length();
        
        for(int i=0; i< n; i++){
            if(s.charAt(i) == 'H'){
                if(i + 1 < n && s.charAt(i+1) == '.'){
                    count++;
                    i += 2;
                    continue;
                }
                
                if(i - 1 >= 0 && s.charAt(i-1) == '.'){
                    count++;
                    continue;
                }
                return -1;
            }
        }
        return count;
	}
}