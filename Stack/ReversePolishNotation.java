package Stack;

import java.util.Stack;

public class ReversePolishNotation {
	void eval(String [] tokens) {
		 Stack<Integer> st= new Stack<>();
	        for(String c: tokens){
	            if(!checkNum(c)) st.push(Integer.parseInt(c));
	            else{
	                //We pe rform the operation
	                int a=  st.pop();
	                int b= st.pop();
	                
	                switch(c){
	                    case "+": st.push(a+b); break;
	                    case "-": st.push(b-a); break;
	                    case "/": st.push(b/a); break;
	                    case "*": st.push(a*b); break;
	                }
	            }
	            
	        }
//	        return st.pop();
	        System.out.println(st.pop());
	    }
	    
	
	private boolean checkNum(String c){
        return (c.equals("+")  || c.equals("-") || c.equals("/") || c.equals("*"));
    }
	    
	
	
	
	public static void main(String[] args) {
		String s[]= {"2","1","+","3","*"};
		ReversePolishNotation obj= new ReversePolishNotation();
		obj.eval(s);
	}

}
