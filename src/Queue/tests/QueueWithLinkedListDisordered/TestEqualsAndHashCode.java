package Queue.tests.QueueWithLinkedListDisordered;

import Queue.QueueWithLinkedListDisordered;

public class TestEqualsAndHashCode {
    public static void main(String[] args) {
        QueueWithLinkedListDisordered<String> queue_WithLinkedListDisordered_str = new QueueWithLinkedListDisordered<String>(5);
        QueueWithLinkedListDisordered<Character> queue_WithLinkedListDisordered_char = new QueueWithLinkedListDisordered<Character>(5);
        queue_WithLinkedListDisordered_str.enqueue("a");
        queue_WithLinkedListDisordered_str.enqueue("b");
        queue_WithLinkedListDisordered_str.enqueue("c");
        queue_WithLinkedListDisordered_str.enqueue("d");
        queue_WithLinkedListDisordered_str.enqueue("e");

        queue_WithLinkedListDisordered_char.enqueue('a');
        queue_WithLinkedListDisordered_char.enqueue('b');
        queue_WithLinkedListDisordered_char.enqueue('c');
        queue_WithLinkedListDisordered_char.enqueue('d');
        queue_WithLinkedListDisordered_char.enqueue('e');

        System.out.println("queue_str.hashCode():   " + queue_WithLinkedListDisordered_str.hashCode());
        System.out.println("queue_char.hashCode():  " + queue_WithLinkedListDisordered_char.hashCode());

        QueueWithLinkedListDisordered<Float> queue_WithLinkedListDisordered_float = new QueueWithLinkedListDisordered<Float>(5);
        QueueWithLinkedListDisordered<Double> queue_WithLinkedListDisordered_double = new QueueWithLinkedListDisordered<Double>(5);
        queue_WithLinkedListDisordered_float.enqueue(1.1f);
        queue_WithLinkedListDisordered_float.enqueue(2.2f);
        queue_WithLinkedListDisordered_float.enqueue(3.3f);
        queue_WithLinkedListDisordered_float.enqueue(4.4f);
        queue_WithLinkedListDisordered_float.enqueue(5.5f);

        queue_WithLinkedListDisordered_double.enqueue(1.1);
        queue_WithLinkedListDisordered_double.enqueue(2.2);
        queue_WithLinkedListDisordered_double.enqueue(3.3);
        queue_WithLinkedListDisordered_double.enqueue(4.4);
        queue_WithLinkedListDisordered_double.enqueue(5.5);

        System.out.println("queue_float.hashCode():     " + queue_WithLinkedListDisordered_float.hashCode());
        System.out.println("queue_double.hashCode():    " + queue_WithLinkedListDisordered_double.hashCode());

        QueueWithLinkedListDisordered<Byte> queue_WithLinkedListDisordered_byte = new QueueWithLinkedListDisordered<Byte>(5);
        QueueWithLinkedListDisordered<Short> queue_WithLinkedListDisordered_short = new QueueWithLinkedListDisordered<Short>(5);
        QueueWithLinkedListDisordered<Integer> queue_WithLinkedListDisordered_int = new QueueWithLinkedListDisordered<Integer>(5);
        QueueWithLinkedListDisordered<Long> queue_WithLinkedListDisordered_long = new QueueWithLinkedListDisordered<Long>(5);

        queue_WithLinkedListDisordered_byte.enqueue((byte) 1);
        queue_WithLinkedListDisordered_byte.enqueue((byte) 2);
        queue_WithLinkedListDisordered_byte.enqueue((byte) 3);
        queue_WithLinkedListDisordered_byte.enqueue((byte) 4);
        queue_WithLinkedListDisordered_byte.enqueue((byte) 5);

        queue_WithLinkedListDisordered_short.enqueue((short) 1);
        queue_WithLinkedListDisordered_short.enqueue((short) 2);
        queue_WithLinkedListDisordered_short.enqueue((short) 3);
        queue_WithLinkedListDisordered_short.enqueue((short) 4);
        queue_WithLinkedListDisordered_short.enqueue((short) 5);

        queue_WithLinkedListDisordered_int.enqueue(1);
        queue_WithLinkedListDisordered_int.enqueue(2);
        queue_WithLinkedListDisordered_int.enqueue(3);
        queue_WithLinkedListDisordered_int.enqueue(4);
        queue_WithLinkedListDisordered_int.enqueue(5);

        queue_WithLinkedListDisordered_long.enqueue(1L);
        queue_WithLinkedListDisordered_long.enqueue(2L);
        queue_WithLinkedListDisordered_long.enqueue(3L);
        queue_WithLinkedListDisordered_long.enqueue(4L);
        queue_WithLinkedListDisordered_long.enqueue(5L);

        System.out.println("queue_byte.hashCode():  " + queue_WithLinkedListDisordered_byte.hashCode());
        System.out.println("queue_short.hashCode(): " + queue_WithLinkedListDisordered_short.hashCode());
        System.out.println("queue_int.hashCode():   " + queue_WithLinkedListDisordered_int.hashCode());
        System.out.println("queue_long.hashCode():  " + queue_WithLinkedListDisordered_long.hashCode());
    }
}
