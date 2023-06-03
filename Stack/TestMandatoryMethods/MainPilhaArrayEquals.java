package TestMandatoryMethods;

import Stack.Stack;

public class MainPilhaArrayEquals {
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

        // ToString
        System.out.println(stackOriginal);
        System.out.println(otherStack);
        System.out.println(smallStack);

        // test the equals method
        System.out.println("test the equals method");
        System.out.println("stackOriginal.equals(StackOriginal) ?   " + stackOriginal.equals(stackOriginal));
        System.out.println("stackOriginal.equals(OtherStack)    ?   " + stackOriginal.equals(otherStack));
        System.out.println("stackOriginal.equals(SmallStack)    ?   " + stackOriginal.equals(smallStack));
        System.out.println();

        // test the equals method
        System.out.println("test the equals method");
        System.out.println("OtherStack.equals(OtherStack)    ?      " + otherStack.equals(otherStack));
        System.out.println("OtherStack.equals(StackOriginal) ?      " + otherStack.equals(stackOriginal));
        System.out.println("OtherStack.equals(SmallStack)    ?      " + otherStack.equals(smallStack));
        System.out.println();

        // test the equals method
        System.out.println("test the equals method");
        System.out.println("SmallStack.equals(SmallStack)    ?      " + smallStack.equals(smallStack));
        System.out.println("SmallStack.equals(StackOriginal) ?      " + smallStack.equals(stackOriginal));
        System.out.println("SmallStack.equals(OtherStack)    ?      " + smallStack.equals(otherStack));
        System.out.println();

    }
}
