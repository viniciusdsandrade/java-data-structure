package Stack.tests;

import Stack.Stack;

public class TestCloneAndCopyConstructor {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>(100);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        @SuppressWarnings("unchecked")
        Stack<Integer> clone = (Stack<Integer>) stack.clone();
        Stack<Integer> copy = new Stack<Integer>(stack);
        System.out.println("stack: " + stack);
        System.out.println("clone: " + clone);
        System.out.println("copy:  " + copy);

        System.out.println("stack.toArray(): " + stack.toArray());
        System.out.println("stack.toArray(): " + stack.toArray());
        System.out.println("copy.toArray():  " + copy.toArray());

        System.out.println("Adicionando 5 na pilha");
        stack.push(5);

        System.out.println("stack.toArray(): " + stack.toArray());
        System.out.println("stack.toArray(): " + stack.toArray());
        System.out.println("copy.toArray():  " + copy.toArray());

        System.out.println("adicionando 5 e 6 na copia e no clone");
        copy.push(5);
        clone.push(5);
        copy.push(6);
        clone.push(6);

        System.out.println("stack.toArray(): " + stack.toArray());
        System.out.println("copy.toArray():  " + copy.toArray());
        System.out.println("clone.toArray(): " + clone.toArray());
    }
}
