package TestMandatoryMethods;

import Stack.Stack;

public class MainPilhaArraytoString {
    public static void main(String[] args) throws Exception {

        // create a new stack
        Stack<Integer> stackOriginal = new Stack<Integer>(1);
        stackOriginal.push(1);
        stackOriginal.push(2);
        stackOriginal.push(3);
        stackOriginal.push(4);
        stackOriginal.push(5);

        Stack<Integer> otherStack = new Stack<Integer>(1);
        otherStack.push(1);
        otherStack.push(2);
        otherStack.push(3);
        otherStack.push(4);
        otherStack.push(5);

        Stack<Integer> smallStack = new Stack<Integer>(1);
        smallStack.push(1);
        smallStack.push(2);
        smallStack.push(3);

        // Percorrendo pilha
        System.out.println("Percorrendo Pilha");
        System.out.println("stackOriginal : " + stackOriginal.toArray());
        System.out.println("OtherStack:     " + otherStack.toArray());
        System.out.println("copyOtherStack: " + smallStack.toArray());
        System.out.println();

        // test toString the Stack
        System.out.println("Test toString()");
        System.out.println("stackOriginal : " + stackOriginal.toString());
        System.out.println("OtherStack:     " + otherStack.toString());
        System.out.println("copyOtherStack: " + smallStack.toString());
        System.out.println();
    }
}
