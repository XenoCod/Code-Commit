//package Codes.Stack;


import java.util.ArrayDeque;

class YStack{
    ArrayDeque<Integer> mainStack;
    ArrayDeque<Integer> tempStack;

    YStack(){
        mainStack =  new ArrayDeque<>();
        tempStack= new ArrayDeque<>();


    }
    void push(int x){
        if(mainStack.isEmpty()){
             mainStack.push(x);
            tempStack.push(x);
        }
        mainStack.push(x);
        if(mainStack.peek()<=tempStack.peek()){
            tempStack.push(x);
        }
    }

    void pop(){
    if(mainStack.peek()==tempStack.peek())
        tempStack.pop();
    mainStack.pop();
    }

    int getMin(){
        return tempStack.peek();
    }
}


public class getMinInStack {
	
    public static void main(String[] args) {
        YStack s= new YStack();
        s.push(5);
        s.push(10);
        s.push(20);
        s.push(2);
        s.push(6);
        s.push(4);
        s.pop();
        s.pop();
        s.push(2);
        s.pop();
        s.push(1);
        s.pop();
        s.pop();

//        Output=>5

//        TC-2
//        s.push(4);
//        s.push(5);
//        s.push(8);
//        s.push(1);
//        s.pop();
//        Output=>4

        System.out.println(s.getMin());


    }
}
