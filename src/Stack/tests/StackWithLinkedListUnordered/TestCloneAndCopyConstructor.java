package Stack.tests.StackWithLinkedListUnordered;

import Stack.StackWithLinkedListUnordered;

public class TestCloneAndCopyConstructor {
    public static void main(String[] args) {
        StackWithLinkedListUnordered<Integer> stackWithLinkedListUnordered = new StackWithLinkedListUnordered<Integer>(100);
        stackWithLinkedListUnordered.push(1);
        stackWithLinkedListUnordered.push(2);
        stackWithLinkedListUnordered.push(3);
        stackWithLinkedListUnordered.push(4);

        @SuppressWarnings("unchecked")
        StackWithLinkedListUnordered<Integer> clone = (StackWithLinkedListUnordered<Integer>) stackWithLinkedListUnordered.clone();
        StackWithLinkedListUnordered<Integer> copy = new StackWithLinkedListUnordered<Integer>(stackWithLinkedListUnordered);
        System.out.println("stack: " + stackWithLinkedListUnordered);
        System.out.println("clone: " + clone);
        System.out.println("copy:  " + copy);

        System.out.println("stack.toArray(): " + stackWithLinkedListUnordered.toArray());
        System.out.println("clone.toArray(): " + clone.toArray());
        System.out.println("copy.toArray():  " + copy.toArray());

        System.out.println("Adicionando 5 na pilha");
        stackWithLinkedListUnordered.push(5);

        System.out.println("stack.toArray(): " + stackWithLinkedListUnordered.toArray());
        System.out.println("clone.toArray(): " + clone.toArray());
        System.out.println("copy.toArray():  " + copy.toArray());

        System.out.println("adicionando 5 e 6 na copia e no clone");
        copy.push(5);
        clone.push(5);
        copy.push(6);
        clone.push(6);

        System.out.println("stack.toArray(): " + stackWithLinkedListUnordered.toArray());
        System.out.println("clone.toArray(): " + clone.toArray());
        System.out.println("copy.toArray():  " + copy.toArray());
    }
}
