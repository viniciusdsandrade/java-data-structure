package Stack.tests;

import Stack.Stack;

import java.util.List;

public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("stack.isFull():         " + stack.isFull());
        System.out.println("stack:                  " + stack.toArray());
        System.out.println("stack.getTamanho():     " + stack.getTamanho());
        System.out.println("stack.getCapacidade():  " + stack.getCapacidade());
        System.out.println("stack.isEmpty():        " + stack.isEmpty());
        System.out.println("stack.peek():           " + stack.peek());
        System.out.println("stack.pop():            " + stack.pop());
        System.out.println("stack:                  " + stack.toArray());
        System.out.println("stack.search(3):        " + stack.search(3));
        System.out.println("stack.search(10):       " + stack.search(10));
        System.out.println("stack.contains(3):      " + stack.contains(3));
        System.out.println("stack.contains(10):     " + stack.contains(10));
        System.out.println("stack.isEmpty():        " + stack.isEmpty());
        System.out.println("stack.clear()");
        stack.clear();
        System.out.println("stack.isEmpty():        " + stack.isEmpty());
        System.out.println("stack:                  " + stack.toArray());

        Stack<Integer> stack2 = new Stack<Integer>(5);
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(4);
        stack2.push(5);

        List<Integer> list = stack2.toList();
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
