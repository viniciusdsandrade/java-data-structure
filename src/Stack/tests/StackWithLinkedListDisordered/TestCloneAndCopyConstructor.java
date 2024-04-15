package Stack.tests.StackWithLinkedListDisordered;

import Stack.StackWithLinkedListDisordered;

public class TestCloneAndCopyConstructor {
    public static void main(String[] args) {
        StackWithLinkedListDisordered<Integer> stackWithLinkedListDisordered = new StackWithLinkedListDisordered<Integer>(100);
        stackWithLinkedListDisordered.push(1);
        stackWithLinkedListDisordered.push(2);
        stackWithLinkedListDisordered.push(3);
        stackWithLinkedListDisordered.push(4);

        @SuppressWarnings("unchecked")
        StackWithLinkedListDisordered<Integer> clone = (StackWithLinkedListDisordered<Integer>) stackWithLinkedListDisordered.clone();
        StackWithLinkedListDisordered<Integer> copy = new StackWithLinkedListDisordered<Integer>(stackWithLinkedListDisordered);
        System.out.println("stack: " + stackWithLinkedListDisordered);
        System.out.println("clone: " + clone);
        System.out.println("copy:  " + copy);

        System.out.println("stack.toArray(): " + stackWithLinkedListDisordered.toArray());
        System.out.println("clone.toArray(): " + clone.toArray());
        System.out.println("copy.toArray():  " + copy.toArray());

        System.out.println("Adicionando 5 na pilha");
        stackWithLinkedListDisordered.push(5);

        System.out.println("stack.toArray(): " + stackWithLinkedListDisordered.toArray());
        System.out.println("clone.toArray(): " + clone.toArray());
        System.out.println("copy.toArray():  " + copy.toArray());

        System.out.println("adicionando 5 e 6 na copia e no clone");
        copy.push(5);
        clone.push(5);
        copy.push(6);
        clone.push(6);

        System.out.println("stack.toArray(): " + stackWithLinkedListDisordered.toArray());
        System.out.println("clone.toArray(): " + clone.toArray());
        System.out.println("copy.toArray():  " + copy.toArray());
    }
}
