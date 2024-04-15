package Stack.tests.StackWithLinkedListDisordered;

import Stack.StackWithLinkedListDisordered;

import java.util.List;

public class TestStackWithLinkedListDisordered {
    public static void main(String[] args) {
        StackWithLinkedListDisordered<Integer> stackWithLinkedListDisordered = new StackWithLinkedListDisordered<Integer>(5);
        stackWithLinkedListDisordered.push(1);
        stackWithLinkedListDisordered.push(2);
        stackWithLinkedListDisordered.push(3);
        stackWithLinkedListDisordered.push(4);
        stackWithLinkedListDisordered.push(5);

        System.out.println("stack.isFull():         " + stackWithLinkedListDisordered.isFull());
        System.out.println("stack:                  " + stackWithLinkedListDisordered.toArray());
        System.out.println("stack.getTamanho():     " + stackWithLinkedListDisordered.getTamanho());
        System.out.println("stack.getCapacidade():  " + stackWithLinkedListDisordered.getCapacidade());
        System.out.println("stack.isEmpty():        " + stackWithLinkedListDisordered.isEmpty());
        System.out.println("stack.peek():           " + stackWithLinkedListDisordered.peek());
        System.out.println("stack.pop():            " + stackWithLinkedListDisordered.pop());
        System.out.println("stack:                  " + stackWithLinkedListDisordered.toArray());
        System.out.println("stack.search(3):        " + stackWithLinkedListDisordered.search(3));
        System.out.println("stack.search(10):       " + stackWithLinkedListDisordered.search(10));
        System.out.println("stack.contains(3):      " + stackWithLinkedListDisordered.contains(3));
        System.out.println("stack.contains(10):     " + stackWithLinkedListDisordered.contains(10));
        System.out.println("stack.isEmpty():        " + stackWithLinkedListDisordered.isEmpty());
        System.out.println("stack.clear()");
        stackWithLinkedListDisordered.clear();
        System.out.println("stack.isEmpty():        " + stackWithLinkedListDisordered.isEmpty());
        System.out.println("stack:                  " + stackWithLinkedListDisordered.toArray());

        StackWithLinkedListDisordered<Integer> stackWithLinkedListDisordered2 = new StackWithLinkedListDisordered<Integer>(5);
        stackWithLinkedListDisordered2.push(1);
        stackWithLinkedListDisordered2.push(2);
        stackWithLinkedListDisordered2.push(3);
        stackWithLinkedListDisordered2.push(4);
        stackWithLinkedListDisordered2.push(5);

        List<Integer> list = stackWithLinkedListDisordered2.toList();
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
