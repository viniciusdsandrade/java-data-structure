package TestMandatoryMethods;
import  Stack.Stack;

public class MainPilhaArrayClone {
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

        // Test the clone method
        System.out.println("Test the clone method");
        @SuppressWarnings("unchecked")
        Stack<Integer> cloneStackOriginal = (Stack<Integer>) stackOriginal.clone();
        @SuppressWarnings("unchecked")
        Stack<Integer> cloneOtherStack = (Stack<Integer>) otherStack.clone();
        @SuppressWarnings("unchecked")
        Stack<Integer> cloneSmallStack = (Stack<Integer>) smallStack.clone();

        // Percorrendo clone
        System.out.println("Percorrendo Clone");
        System.out.println("clone StackOriginal:    " + cloneStackOriginal.toArray());
        System.out.println("clone OtherStack:       " + cloneOtherStack.toArray());
        System.out.println("clone CopyOtherStack:   " + cloneSmallStack.toArray());
        System.out.println();

        // Tenha certeza que a copia original não foi modificada e os clones e as copias
        // são iguais
        System.out.println(
                "Tenha certeza que a copia original não foi modificada e os clones e as copias são iguais");
        System.out.println("       StackOriginal: " + stackOriginal.toArray());
        System.out.println("clone  StackOriginal: " + cloneStackOriginal.toArray());
        System.out.println();

        System.out.println("       OtherStack: " + otherStack.toArray());
        System.out.println("clone  OtherStack: " + cloneOtherStack.toArray());
        System.out.println();

        System.out.println("       CopyOtherStack: " + smallStack.toArray());
        System.out.println("clone  CopyOtherStack: " + cloneSmallStack.toArray());
        System.out.println();

    }
}
