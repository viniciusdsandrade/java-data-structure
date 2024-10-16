package Stack.tests.StackWithLinkedListUnordered;

import Stack.StackWithLinkedListUnordered;

import java.util.List;

public class TestStackWithLinkedListUnordered {
    public static void main(String[] args) {
        StackWithLinkedListUnordered<Integer> stackWithLinkedListUnordered = new StackWithLinkedListUnordered<Integer>(5);
        stackWithLinkedListUnordered.push(1);
        stackWithLinkedListUnordered.push(2);
        stackWithLinkedListUnordered.push(3);
        stackWithLinkedListUnordered.push(4);
        stackWithLinkedListUnordered.push(5);

        System.out.println("stack.isFull():         " + stackWithLinkedListUnordered.isFull());
        System.out.println("stack:                  " + stackWithLinkedListUnordered.toArray());
        System.out.println("stack.getTamanho():     " + stackWithLinkedListUnordered.getTamanho());
        System.out.println("stack.getCapacidade():  " + stackWithLinkedListUnordered.getCapacidade());
        System.out.println("stack.isEmpty():        " + stackWithLinkedListUnordered.isEmpty());
        System.out.println("stack.peek():           " + stackWithLinkedListUnordered.peek());
        System.out.println("stack.pop():            " + stackWithLinkedListUnordered.pop());
        System.out.println("stack:                  " + stackWithLinkedListUnordered.toArray());
        System.out.println("stack.search(3):        " + stackWithLinkedListUnordered.search(3));
        System.out.println("stack.search(10):       " + stackWithLinkedListUnordered.search(10));
        System.out.println("stack.contains(3):      " + stackWithLinkedListUnordered.contains(3));
        System.out.println("stack.contains(10):     " + stackWithLinkedListUnordered.contains(10));
        System.out.println("stack.isEmpty():        " + stackWithLinkedListUnordered.isEmpty());
        System.out.println("stack.clear()");
        stackWithLinkedListUnordered.clear();
        System.out.println("stack.isEmpty():        " + stackWithLinkedListUnordered.isEmpty());
        System.out.println("stack:                  " + stackWithLinkedListUnordered.toArray());

        StackWithLinkedListUnordered<Integer> stackWithLinkedListUnordered2 = new StackWithLinkedListUnordered<Integer>(5);
        stackWithLinkedListUnordered2.push(1);
        stackWithLinkedListUnordered2.push(2);
        stackWithLinkedListUnordered2.push(3);
        stackWithLinkedListUnordered2.push(4);
        stackWithLinkedListUnordered2.push(5);

        List<Integer> list = stackWithLinkedListUnordered2.toList();
        System.out.println("list:                   " + list);

        Object[] array = list.toArray();
        System.out.print("array:                  [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
