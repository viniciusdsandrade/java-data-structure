package Stack.tests;

import Stack.Stack;

public class TestStack {

    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack<Integer>(10);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);


        System.out.println("stack: " + stack);
        System.out.println("stack.peek(): " + stack.peek());
        System.out.println("stack.toArray()" + stack.toArray());
    }
}
