package Stack.tests.StackWithLinkedListUnordered;

import Stack.StackWithLinkedListUnordered;

public class TestToString {
    public static void main(String[] args) {
        StackWithLinkedListUnordered<Integer> stack_WithLinkedListDisordered_int = new StackWithLinkedListUnordered<Integer>(5);
        StackWithLinkedListUnordered<String> stack_WithLinkedListDisordered_str = new StackWithLinkedListUnordered<String>(5);
        StackWithLinkedListUnordered<Character> stack_WithLinkedListDisordered_char = new StackWithLinkedListUnordered<Character>(5);
        StackWithLinkedListUnordered<Float> stack_WithLinkedListDisordered_float = new StackWithLinkedListUnordered<Float>(5);
        StackWithLinkedListUnordered<Boolean> stack_WithLinkedListDisordered_bool = new StackWithLinkedListUnordered<Boolean>(5);
        StackWithLinkedListUnordered<Double> stack_WithLinkedListDisordered_double = new StackWithLinkedListUnordered<Double>(5);
        StackWithLinkedListUnordered<Long> stack_WithLinkedListDisordered_long = new StackWithLinkedListUnordered<Long>(5);
        StackWithLinkedListUnordered<Short> stack_WithLinkedListDisordered_short = new StackWithLinkedListUnordered<Short>(5);
        StackWithLinkedListUnordered<Byte> stack_WithLinkedListDisordered_byte = new StackWithLinkedListUnordered<Byte>(5);

        stack_WithLinkedListDisordered_int.push(1);
        stack_WithLinkedListDisordered_int.push(2);
        stack_WithLinkedListDisordered_int.push(3);
        stack_WithLinkedListDisordered_int.push(4);
        stack_WithLinkedListDisordered_int.push(5);

        stack_WithLinkedListDisordered_str.push("a");
        stack_WithLinkedListDisordered_str.push("b");
        stack_WithLinkedListDisordered_str.push("c");
        stack_WithLinkedListDisordered_str.push("d");
        stack_WithLinkedListDisordered_str.push("e");

        stack_WithLinkedListDisordered_char.push('a');
        stack_WithLinkedListDisordered_char.push('b');
        stack_WithLinkedListDisordered_char.push('c');
        stack_WithLinkedListDisordered_char.push('d');
        stack_WithLinkedListDisordered_char.push('e');

        stack_WithLinkedListDisordered_float.push(1.1f);
        stack_WithLinkedListDisordered_float.push(2.2f);
        stack_WithLinkedListDisordered_float.push(3.3f);
        stack_WithLinkedListDisordered_float.push(4.4f);
        stack_WithLinkedListDisordered_float.push(5.5f);

        stack_WithLinkedListDisordered_bool.push(true);
        stack_WithLinkedListDisordered_bool.push(false);
        stack_WithLinkedListDisordered_bool.push(true);
        stack_WithLinkedListDisordered_bool.push(false);
        stack_WithLinkedListDisordered_bool.push(true);

        stack_WithLinkedListDisordered_double.push(1.1);
        stack_WithLinkedListDisordered_double.push(2.2);
        stack_WithLinkedListDisordered_double.push(3.3);
        stack_WithLinkedListDisordered_double.push(4.4);
        stack_WithLinkedListDisordered_double.push(5.5);

        stack_WithLinkedListDisordered_long.push(1L);
        stack_WithLinkedListDisordered_long.push(2L);
        stack_WithLinkedListDisordered_long.push(3L);
        stack_WithLinkedListDisordered_long.push(4L);
        stack_WithLinkedListDisordered_long.push(5L);

        stack_WithLinkedListDisordered_short.push((short) 1);
        stack_WithLinkedListDisordered_short.push((short) 2);
        stack_WithLinkedListDisordered_short.push((short) 3);
        stack_WithLinkedListDisordered_short.push((short) 4);
        stack_WithLinkedListDisordered_short.push((short) 5);

        stack_WithLinkedListDisordered_byte.push((byte) 1);
        stack_WithLinkedListDisordered_byte.push((byte) 2);
        stack_WithLinkedListDisordered_byte.push((byte) 3);
        stack_WithLinkedListDisordered_byte.push((byte) 4);
        stack_WithLinkedListDisordered_byte.push((byte) 5);

        System.out.println("Teste do método toString()");
        System.out.println("Stack<Integer>:     " + stack_WithLinkedListDisordered_int);
        System.out.println("Stack<String>:      " + stack_WithLinkedListDisordered_str);
        System.out.println("Stack<Character>:   " + stack_WithLinkedListDisordered_char);
        System.out.println("Stack<Float>:       " + stack_WithLinkedListDisordered_float);
        System.out.println("Stack<Boolean>:     " + stack_WithLinkedListDisordered_bool);
        System.out.println("Stack<Double>:      " + stack_WithLinkedListDisordered_double);
        System.out.println("Stack<Long>:        " + stack_WithLinkedListDisordered_long);
        System.out.println("Stack<Short>:       " + stack_WithLinkedListDisordered_short);
        System.out.println("Stack<Byte>:        " + stack_WithLinkedListDisordered_byte);
        System.out.println();
        System.out.println("Teste do método toArray()");
        System.out.println("Stack<Integer>:     " + stack_WithLinkedListDisordered_int.toArray());
        System.out.println("Stack<String>:      " + stack_WithLinkedListDisordered_str.toArray());
        System.out.println("Stack<Character>:   " + stack_WithLinkedListDisordered_char.toArray());
        System.out.println("Stack<Float>:       " + stack_WithLinkedListDisordered_float.toArray());
        System.out.println("Stack<Boolean>:     " + stack_WithLinkedListDisordered_bool.toArray());
        System.out.println("Stack<Double>:      " + stack_WithLinkedListDisordered_double.toArray());
        System.out.println("Stack<Long>:        " + stack_WithLinkedListDisordered_long.toArray());
        System.out.println("Stack<Short>:       " + stack_WithLinkedListDisordered_short.toArray());
        System.out.println("Stack<Byte>:        " + stack_WithLinkedListDisordered_byte.toArray());

    }
}
