package Stack.tests;

import Stack.Stack;

public class TestEqualsAndHashCode {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<Integer>(9);
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        Stack<Integer> stack2 = new Stack<Integer>(3);
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);

        Stack<Integer> stack3 = new Stack<Integer>(2);
        stack3.push(1);
        stack3.push(2);

        System.out.println("stack1: " + stack1.toArray());
        System.out.println("stack2: " + stack2.toArray());
        System.out.println("stack3: " + stack3.toArray());
        System.out.println();
        System.out.println("stack1.hashCode(): " + stack1.hashCode());
        System.out.println("stack2.hashCode(): " + stack2.hashCode());
        System.out.println("stack3.hashCode(): " + stack3.hashCode());
        System.out.println();
        System.out.println("stack1.equals(stack2): " + stack1.equals(stack2));
        System.out.println("stack1.equals(stack3): " + stack1.equals(stack3));
        System.out.println("stack2.equals(stack3): " + stack2.equals(stack3));
    }
}
