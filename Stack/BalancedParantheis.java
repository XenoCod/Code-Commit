///package Codes.Stack;

import java.util.ArrayDeque;

public class BalancedParantheis {
    public static boolean match(char a, char b){
        return ((a=='(' && b==')') || (a=='{' && b=='}') || (a=='[' && b==']'));
    }
    public static boolean isValid(String s){
        ArrayDeque<Character> deq= new ArrayDeque<>();
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
        String s="()[]{}";
        System.out.println(isValid(s));
    }
}
