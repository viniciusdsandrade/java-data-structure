package Stack.tests;

import Stack.Stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestStack {

    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack<Integer>(10);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        Object[] toList = stack.toArrayObject();
        System.out.println(Arrays.toString(toList));

        Arrays.stream(toList)
                .min(Comparator.comparingInt(o -> (Integer) o))
                .ifPresent(System.out::println);

        System.out.println();
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.toArray());

        stack.pop();

        System.out.println();
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.toArray());

        Integer num = stack.pop();

        System.out.println();
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.toArray());

        stack.clear();

        System.out.println();
        System.out.println(stack.toArray());


    }
}
