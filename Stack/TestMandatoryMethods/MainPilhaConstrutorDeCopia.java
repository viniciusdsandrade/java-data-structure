package TestMandatoryMethods;

import Stack.Stack;

public class MainPilhaConstrutorDeCopia {
    public static void main(String[] args) throws Exception {

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

        // Percorrendo a pilha
        System.out.println("Percorrendo a pilha Original (LIFO - Last in First Out) \n");
        System.out.println("stackOriginal : " + stackOriginal.toArray());
        System.out.println("OtherStack:     " + otherStack.toArray());
        System.out.println("copyOtherStack: " + smallStack.toArray());
        System.out.println();

        // Test the copy constructor
        System.out.println("Test the copy constructor\n");
        Stack<Integer> copiedStackOriginal = new Stack<>(stackOriginal);
        Stack<Integer> copiedOtherStack = new Stack<>(otherStack);
        Stack<Integer> copiedSmallStack = new Stack<>(smallStack);

        System.out.println("Percorrendo a cópia da stack feita pelo construtor de cópia");
        System.out.println("copied StackOriginal    " + copiedStackOriginal.toArray());
        System.out.println("copied OtherStack       " + copiedOtherStack.toArray());
        System.out.println("copied CopyOtherStack   " + copiedSmallStack.toArray());
        System.out.println();
    }
}
