package Stack.tests;

import Stack.Stack;

public class TestEqualsAndHashCode {
    public static void main(String[] args) {
        Stack<String> stack_str = new Stack<String>(5);
        Stack<Character> stack_char = new Stack<Character>(5);
        stack_str.push("a");
        stack_str.push("b");
        stack_str.push("c");
        stack_str.push("d");
        stack_str.push("e");

        stack_char.push('a');
        stack_char.push('b');
        stack_char.push('c');
        stack_char.push('d');
        stack_char.push('e');
        System.out.println("stack_str.hashCode():   " + stack_str.hashCode());
        System.out.println("stack_char.hashCode():  " + stack_char.hashCode());

        Stack<Float> stack_float = new Stack<Float>(5);
        Stack<Double> stack_double = new Stack<Double>(5);
        stack_float.push(1.1f);
        stack_float.push(2.2f);
        stack_float.push(3.3f);
        stack_float.push(4.4f);
        stack_float.push(5.5f);

        stack_double.push(1.1);
        stack_double.push(2.2);
        stack_double.push(3.3);
        stack_double.push(4.4);
        stack_double.push(5.5);
        System.out.println("stack_float.hashCode():     " + stack_float.hashCode());
        System.out.println("stack_double.hashCode():    " + stack_double.hashCode());

        Stack<Byte> stack_byte = new Stack<Byte>(5);
        Stack<Short> stack_short = new Stack<Short>(5);
        Stack<Integer> stack_int = new Stack<Integer>(5);
        Stack<Long> stack_long = new Stack<Long>(5);
        stack_byte.push((byte) 1);
        stack_byte.push((byte) 2);
        stack_byte.push((byte) 3);
        stack_byte.push((byte) 4);
        stack_byte.push((byte) 5);

        stack_short.push((short) 1);
        stack_short.push((short) 2);
        stack_short.push((short) 3);
        stack_short.push((short) 4);
        stack_short.push((short) 5);

        stack_int.push(1);
        stack_int.push(2);
        stack_int.push(3);
        stack_int.push(4);
        stack_int.push(5);

        stack_long.push(1L);
        stack_long.push(2L);
        stack_long.push(3L);
        stack_long.push(4L);
        stack_long.push(5L);

        System.out.println("stack_byte.hashCode():  " + stack_byte.hashCode());
        System.out.println("stack_short.hashCode(): " + stack_short.hashCode());
        System.out.println("stack_int.hashCode():   " + stack_int.hashCode());
        System.out.println("stack_long.hashCode():  " + stack_long.hashCode());
    }
}
