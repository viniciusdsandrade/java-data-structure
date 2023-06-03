package TestMandatoryMethods; 

import Stack.Stack;

public class MainPilhaArrayCompareTo {
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

        // test the compareTo method
        System.out.println("test the compareTo method");
        System.out.println("stackOriginal vs OtherStack");
        System.out.println("Comparison stackOriginal  to OtherStack:     " + stackOriginal.compareTo(otherStack));
        System.out.println("Comparison OtherStack to stackOriginal:      " + otherStack.compareTo(stackOriginal));
        System.out.println();

        System.out.println("stackOriginal vs smallStack");
        System.out.println("Comparison stackOriginal  to smallStack:     " + stackOriginal.compareTo(smallStack));
        System.out.println("Comparison smallStack     to stackOriginal:  " + smallStack.compareTo(stackOriginal));
        System.out.println();

        System.out.println("otherStack vs smallStack");
        System.out.println("Comparison SmallStack to OtherStack:         " + smallStack.compareTo(otherStack));
        System.out.println("Comparison OtherStack  to SmallStack:        " + otherStack.compareTo(smallStack));
        System.out.println();
    }
}
