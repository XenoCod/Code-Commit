import java.util.*;

class ReorganizeString{
	static String reorganize(String s){
		Map<Character, Integer> map= new HashMap<>();
        //Build a map with freq
        for(char c: s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        
        //build a max heap
        PriorityQueue<Character> pq= new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());
        
        
        StringBuilder sb= new StringBuilder();
        while(pq.size() > 1){
            char curr= pq.remove();     //remove the 1st char with most freq
            char next= pq.remove();     //remove the 2nd higehst freq char
            
            sb.append(curr);            //Append both to res
            sb.append(next);
            
            map.put(curr, map.get(curr) - 1);       //decreas their count in map
            map.put(next, map.get(next) - 1);
            
            if(map.get(curr) > 0) pq.add(curr);     //if their freq > 0 add them to pq again
            if(map.get(next) > 0) pq.add(next);
            
        }
        
        if(!pq.isEmpty()){
            //Take the last char
            char curr= pq.remove();
            
            //If the char freq freq is more than one then its not possible to build string 
            if(map.get(curr) > 1) return "";
            else sb.append(curr); //else build the string and return
        }   
        return sb.toString();
	}
	public static void main(String[] args) {
		String s="aab";
		//Reorganize in such a manner such that no two adjacent string repeat
		// o/p aba
		System.out.println(reorganize(s));
	}
}