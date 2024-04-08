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


        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("stack: " + stack.toArray());
        System.out.println("stack.getTamanho(): " + stack.getTamanho());
        System.out.println("stack.getCapacidade(): " + stack.getCapacidade());
        System.out.println("stack.isEmpty(): " + stack.isEmpty());
        System.out.println("stack.peek(): " + stack.peek());
        System.out.println("stack.pop(): " + stack.pop());
        System.out.println("stack: " + stack.toArray());
        System.out.println("stack.search(3): " + stack.search(3));
        System.out.println("stack.search(10): " + stack.search(10));
        System.out.println("stack.contains(3): " + stack.contains(3));
        System.out.println("stack.contains(10): " + stack.contains(10));
        System.out.println("stack.isEmpty(): " + stack.isEmpty());
        System.out.println("stack.clear()");
        stack.clear();
        System.out.println("stack.isEmpty(): " + stack.isEmpty());
        System.out.println("stack: " + stack.toArray());
    }
}
