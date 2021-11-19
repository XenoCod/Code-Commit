class CombinationIterator {
    List<String> list;
    private int len;
    private int nextIndex;

    public CombinationIterator(String characters, int combinationLength) {
        list= new ArrayList<>();
        this.len= combinationLength;
        backtrack(list, characters, len, new StringBuilder(), 0);  
        nextIndex = 0;
            }
    
    public String next() {
        return list.get(nextIndex++);
    }
    
    public boolean hasNext() {
        return nextIndex < list.size();
        
    }
    
    private void backtrack(List<String> list, String s, int len, StringBuilder sb, int ind){
        if(sb.length() == len){
            list.add(sb.toString());
            return;
        }
        
        for(int i=ind; i< s.length(); i++){
            sb.append(s.charAt(i));
            backtrack(list, s, len, sb, i + 1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
}



class CombinationIterator{
	public static void main(String[] args) {
		Scanner sc;
// Design the CombinationIterator class:

// CombinationIterator(string characters, int combinationLength) Initializes the object with a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
// next() Returns the next combination of length combinationLength in lexicographical order.
// hasNext() Returns true if and only if there exists a next combination.
 

// Example 1:

// Input
// ["CombinationIterator", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
// [["abc", 2], [], [], [], [], [], []]
// Output
// [null, "ab", true, "ac", true, "bc", false]


	}
}