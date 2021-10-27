import java.util.*;


class DecodeString{

	private String decodeString(String s){
		 Deque<Character> st= new ArrayDeque<>();
        for(char c: s.toCharArray())
            st.offer(c);
        return decode(st);
	}

	private String decode(Deque<Character> st){
        StringBuilder sb= new StringBuilder();
        int num=0;
        while(!st.isEmpty()){
            char c= st.poll();
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            else if(c == '['){
                String substr= decode(st);
                
                for(int i=0; i<num; i++) sb.append(substr);
                num=0;
            }
            
            else if(c == ']')
                break;
            
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

	public static void main(String[] args) {
		String s="3[a]2[bc]";
		DecodeString obj= new DecodeString();
				System.out.println(obj.decodeString(s));

		// Input: s = "3[a]2[bc]"
		// Output: "aaabcbc"
	}
}