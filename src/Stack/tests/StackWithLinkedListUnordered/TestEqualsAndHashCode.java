package Stack.tests.StackWithLinkedListUnordered;

import Stack.StackWithLinkedListUnordered;

public class TestEqualsAndHashCode {
    public static void main(String[] args) {
        StackWithLinkedListUnordered<String> stack_WithLinkedListDisordered_str = new StackWithLinkedListUnordered<String>(5);
        StackWithLinkedListUnordered<Character> stack_WithLinkedListDisordered_char = new StackWithLinkedListUnordered<Character>(5);
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

        StackWithLinkedListUnordered<Float> stack_WithLinkedListDisordered_float = new StackWithLinkedListUnordered<Float>(5);
        StackWithLinkedListUnordered<Double> stack_WithLinkedListDisordered_double = new StackWithLinkedListUnordered<Double>(5);
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

        StackWithLinkedListUnordered<Byte> stack_WithLinkedListDisordered_byte = new StackWithLinkedListUnordered<Byte>(5);
        StackWithLinkedListUnordered<Short> stack_WithLinkedListDisordered_short = new StackWithLinkedListUnordered<Short>(5);
        StackWithLinkedListUnordered<Integer> stack_WithLinkedListDisordered_int = new StackWithLinkedListUnordered<Integer>(5);
        StackWithLinkedListUnordered<Long> stack_WithLinkedListDisordered_long = new StackWithLinkedListUnordered<Long>(5);
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
