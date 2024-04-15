package Queue.tests.QueueWithLinkedListDisordered;

import Queue.QueueWithLinkedListDisordered;

public class TestToString {
    public static void main(String[] args) {
        QueueWithLinkedListDisordered<Integer> queue_WithLinkedListDisordered_int = new QueueWithLinkedListDisordered<Integer>(5);
        QueueWithLinkedListDisordered<String> queue_WithLinkedListDisordered_str = new QueueWithLinkedListDisordered<String>(5);
        QueueWithLinkedListDisordered<Character> queue_WithLinkedListDisordered_char = new QueueWithLinkedListDisordered<Character>(5);
        QueueWithLinkedListDisordered<Float> queue_WithLinkedListDisordered_float = new QueueWithLinkedListDisordered<Float>(5);
        QueueWithLinkedListDisordered<Boolean> queue_WithLinkedListDisordered_bool = new QueueWithLinkedListDisordered<Boolean>(5);
        QueueWithLinkedListDisordered<Double> queue_WithLinkedListDisordered_double = new QueueWithLinkedListDisordered<Double>(5);
        QueueWithLinkedListDisordered<Long> queue_WithLinkedListDisordered_long = new QueueWithLinkedListDisordered<Long>(5);
        QueueWithLinkedListDisordered<Short> queue_WithLinkedListDisordered_short = new QueueWithLinkedListDisordered<Short>(5);
        QueueWithLinkedListDisordered<Byte> queue_WithLinkedListDisordered_byte = new QueueWithLinkedListDisordered<Byte>(5);


        queue_WithLinkedListDisordered_int.enqueue(1);
        queue_WithLinkedListDisordered_int.enqueue(2);
        queue_WithLinkedListDisordered_int.enqueue(3);
        queue_WithLinkedListDisordered_int.enqueue(4);
        queue_WithLinkedListDisordered_int.enqueue(5);

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

        queue_WithLinkedListDisordered_float.enqueue(1.1f);
        queue_WithLinkedListDisordered_float.enqueue(2.2f);
        queue_WithLinkedListDisordered_float.enqueue(3.3f);
        queue_WithLinkedListDisordered_float.enqueue(4.4f);
        queue_WithLinkedListDisordered_float.enqueue(5.5f);

        queue_WithLinkedListDisordered_bool.enqueue(true);
        queue_WithLinkedListDisordered_bool.enqueue(false);
        queue_WithLinkedListDisordered_bool.enqueue(true);
        queue_WithLinkedListDisordered_bool.enqueue(false);
        queue_WithLinkedListDisordered_bool.enqueue(true);

        queue_WithLinkedListDisordered_double.enqueue(1.1);
        queue_WithLinkedListDisordered_double.enqueue(2.2);
        queue_WithLinkedListDisordered_double.enqueue(3.3);
        queue_WithLinkedListDisordered_double.enqueue(4.4);
        queue_WithLinkedListDisordered_double.enqueue(5.5);

        queue_WithLinkedListDisordered_long.enqueue(1L);
        queue_WithLinkedListDisordered_long.enqueue(2L);
        queue_WithLinkedListDisordered_long.enqueue(3L);
        queue_WithLinkedListDisordered_long.enqueue(4L);
        queue_WithLinkedListDisordered_long.enqueue(5L);

        queue_WithLinkedListDisordered_short.enqueue((short) 1);
        queue_WithLinkedListDisordered_short.enqueue((short) 2);
        queue_WithLinkedListDisordered_short.enqueue((short) 3);
        queue_WithLinkedListDisordered_short.enqueue((short) 4);
        queue_WithLinkedListDisordered_short.enqueue((short) 5);

        queue_WithLinkedListDisordered_byte.enqueue((byte) 1);
        queue_WithLinkedListDisordered_byte.enqueue((byte) 2);
        queue_WithLinkedListDisordered_byte.enqueue((byte) 3);
        queue_WithLinkedListDisordered_byte.enqueue((byte) 4);
        queue_WithLinkedListDisordered_byte.enqueue((byte) 5);

        System.out.println("Test do método toString()");
        System.out.println("Queue<Integer>:     " + queue_WithLinkedListDisordered_int);
        System.out.println("Queue<String>:      " + queue_WithLinkedListDisordered_str);
        System.out.println("Queue<Character>:   " + queue_WithLinkedListDisordered_char);
        System.out.println("Queue<Float>:       " + queue_WithLinkedListDisordered_float);
        System.out.println("Queue<Boolean>:     " + queue_WithLinkedListDisordered_bool);
        System.out.println("Queue<Double>:      " + queue_WithLinkedListDisordered_double);
        System.out.println("Queue<Long>:        " + queue_WithLinkedListDisordered_long);
        System.out.println("Queue<Short>:       " + queue_WithLinkedListDisordered_short);
        System.out.println("Queue<Byte>:        " + queue_WithLinkedListDisordered_byte);
        System.out.println();
        System.out.println("Test do método toArray()");
        System.out.println("Queue<Integer>:     " + queue_WithLinkedListDisordered_int.toArray());
        System.out.println("Queue<String>:      " + queue_WithLinkedListDisordered_str.toArray());
        System.out.println("Queue<Character>:   " + queue_WithLinkedListDisordered_char.toArray());
        System.out.println("Queue<Float>:       " + queue_WithLinkedListDisordered_float.toArray());
        System.out.println("Queue<Boolean>:     " + queue_WithLinkedListDisordered_bool.toArray());
        System.out.println("Queue<Double>:      " + queue_WithLinkedListDisordered_double.toArray());
        System.out.println("Queue<Long>:        " + queue_WithLinkedListDisordered_long.toArray());
        System.out.println("Queue<Short>:       " + queue_WithLinkedListDisordered_short.toArray());
        System.out.println("Queue<Byte>:        " + queue_WithLinkedListDisordered_byte.toArray());
    }
}
