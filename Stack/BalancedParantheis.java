///package Codes.Stack;

import java.util.Stack;

public class BalancedParantheis {
	
    public boolean match(char a, char b){
        return ((a=='(' && b==')') || (a=='{' && b=='}') || (a=='[' && b==']'));
    }
    
    public boolean isValid(String s){
    	Stack<Character> deq= new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                deq.push(c);
            }
            else{
                if(deq.isEmpty())
                    return false;
                else if(!match(deq.peek(), c))
                    return false;
                else
                    deq.pop();
            }

        }

        return (deq.isEmpty());
    }
    
    public static void main(String[] args) {
        String s="({[]})";
        BalancedParantheis obj= new BalancedParantheis();
        System.out.println(obj.isValid(s));
    }
}
