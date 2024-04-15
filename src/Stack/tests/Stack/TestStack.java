package Stack.tests.Stack;

import Stack.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("stack.peek():    " + stack);
        System.out.println("stack.toArray(): " + stack.toArray());
        System.out.println("stack.isFull():  " + stack.isFull());
        System.out.println("stack.isEmpty(): " + stack.isEmpty());

        System.out.println("stack.pop():     " + stack.pop());
        System.out.println("stack.pop():     " + stack.pop());

        System.out.println("stack.peek():    " + stack.peek());
        System.out.println("stack.toArray(): " + stack.toArray());

        System.out.println("stack.pop():     " + stack.pop());
        System.out.println("stack.pop():     " + stack.pop());
        System.out.println("stack.pop():     " + stack.pop());


        try {
            System.out.println("stack.peek():    " + stack.peek());
        } catch (Exception err) {
            System.err.println(err.getMessage());
        }


        //System.out.println("stack.peek():    " + stack.peek());
        System.out.println("stack.toArray(): " + stack.toArray());

        System.out.println("stack.isEmpty(): " + stack.isEmpty());
        System.out.println("stack.isFull():  " + stack.isFull());
    }
}
