package Stack.tests;

import Stack.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>(100);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        
        System.out.println("stack.toArray(): " + stack.toArray());

        int x = stack.peek();
        System.out.println("stack.peek(): " + x);

        int y = stack.pop();
        System.out.println("stack.pop(): " + y);
        
        System.out.println("stack.toArray(): " + stack.toArray());

        x = stack.peek();
        System.out.println("stack.peek(): " + x);

        y = stack.pop();
        System.out.println("stack.pop(): " + y);
        
        System.out.println("stack.toArray(): " + stack.toArray());

        x = stack.peek();
        System.out.println("stack.peek(): " + x);

        y = stack.pop();
        System.out.println("stack.pop(): " + y);
        
        System.out.println("stack.toArray(): " + stack.toArray());

        x = stack.peek();
        System.out.println("stack.peek(): " + x);

        y = stack.pop();
        System.out.println("stack.pop(): " + y);

        System.out.println("stack: " + stack);
        System.out.println("stack.toArray(): " + stack.toArray());
    }
}
