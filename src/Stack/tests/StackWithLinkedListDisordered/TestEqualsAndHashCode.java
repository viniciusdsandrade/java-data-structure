package Stack.tests.StackWithLinkedListDisordered;

import Stack.StackWithLinkedListDisordered;

public class TestEqualsAndHashCode {
    public static void main(String[] args) {
        StackWithLinkedListDisordered<String> stack_WithLinkedListDisordered_str = new StackWithLinkedListDisordered<String>(5);
        StackWithLinkedListDisordered<Character> stack_WithLinkedListDisordered_char = new StackWithLinkedListDisordered<Character>(5);
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
        System.out.println("stack_str.hashCode():   " + stack_WithLinkedListDisordered_str.hashCode());
        System.out.println("stack_char.hashCode():  " + stack_WithLinkedListDisordered_char.hashCode());

        StackWithLinkedListDisordered<Float> stack_WithLinkedListDisordered_float = new StackWithLinkedListDisordered<Float>(5);
        StackWithLinkedListDisordered<Double> stack_WithLinkedListDisordered_double = new StackWithLinkedListDisordered<Double>(5);
        stack_WithLinkedListDisordered_float.push(1.1f);
        stack_WithLinkedListDisordered_float.push(2.2f);
        stack_WithLinkedListDisordered_float.push(3.3f);
        stack_WithLinkedListDisordered_float.push(4.4f);
        stack_WithLinkedListDisordered_float.push(5.5f);

        stack_WithLinkedListDisordered_double.push(1.1);
        stack_WithLinkedListDisordered_double.push(2.2);
        stack_WithLinkedListDisordered_double.push(3.3);
        stack_WithLinkedListDisordered_double.push(4.4);
        stack_WithLinkedListDisordered_double.push(5.5);
        System.out.println("stack_float.hashCode():     " + stack_WithLinkedListDisordered_float.hashCode());
        System.out.println("stack_double.hashCode():    " + stack_WithLinkedListDisordered_double.hashCode());

        StackWithLinkedListDisordered<Byte> stack_WithLinkedListDisordered_byte = new StackWithLinkedListDisordered<Byte>(5);
        StackWithLinkedListDisordered<Short> stack_WithLinkedListDisordered_short = new StackWithLinkedListDisordered<Short>(5);
        StackWithLinkedListDisordered<Integer> stack_WithLinkedListDisordered_int = new StackWithLinkedListDisordered<Integer>(5);
        StackWithLinkedListDisordered<Long> stack_WithLinkedListDisordered_long = new StackWithLinkedListDisordered<Long>(5);
        stack_WithLinkedListDisordered_byte.push((byte) 1);
        stack_WithLinkedListDisordered_byte.push((byte) 2);
        stack_WithLinkedListDisordered_byte.push((byte) 3);
        stack_WithLinkedListDisordered_byte.push((byte) 4);
        stack_WithLinkedListDisordered_byte.push((byte) 5);

        stack_WithLinkedListDisordered_short.push((short) 1);
        stack_WithLinkedListDisordered_short.push((short) 2);
        stack_WithLinkedListDisordered_short.push((short) 3);
        stack_WithLinkedListDisordered_short.push((short) 4);
        stack_WithLinkedListDisordered_short.push((short) 5);

        stack_WithLinkedListDisordered_int.push(1);
        stack_WithLinkedListDisordered_int.push(2);
        stack_WithLinkedListDisordered_int.push(3);
        stack_WithLinkedListDisordered_int.push(4);
        stack_WithLinkedListDisordered_int.push(5);

        stack_WithLinkedListDisordered_long.push(1L);
        stack_WithLinkedListDisordered_long.push(2L);
        stack_WithLinkedListDisordered_long.push(3L);
        stack_WithLinkedListDisordered_long.push(4L);
        stack_WithLinkedListDisordered_long.push(5L);

        System.out.println("stack_byte.hashCode():  " + stack_WithLinkedListDisordered_byte.hashCode());
        System.out.println("stack_short.hashCode(): " + stack_WithLinkedListDisordered_short.hashCode());
        System.out.println("stack_int.hashCode():   " + stack_WithLinkedListDisordered_int.hashCode());
        System.out.println("stack_long.hashCode():  " + stack_WithLinkedListDisordered_long.hashCode());
    }
}
