package Queue.tests;

import Queue.Queue;

public class TestEqualsAndHashCode {
    public static void main(String[] args) {
        Queue<String> queue_str = new Queue<String>(5);
        Queue<Character> queue_char = new Queue<Character>(5);
        queue_str.enqueue("a");
        queue_str.enqueue("b");
        queue_str.enqueue("c");
        queue_str.enqueue("d");
        queue_str.enqueue("e");

        queue_char.enqueue('a');
        queue_char.enqueue('b');
        queue_char.enqueue('c');
        queue_char.enqueue('d');
        queue_char.enqueue('e');

        System.out.println("queue_str.hashCode():   " + queue_str.hashCode());
        System.out.println("queue_char.hashCode():  " + queue_char.hashCode());

        Queue<Float> queue_float = new Queue<Float>(5);
        Queue<Double> queue_double = new Queue<Double>(5);
        queue_float.enqueue(1.1f);
        queue_float.enqueue(2.2f);
        queue_float.enqueue(3.3f);
        queue_float.enqueue(4.4f);
        queue_float.enqueue(5.5f);

        queue_double.enqueue(1.1);
        queue_double.enqueue(2.2);
        queue_double.enqueue(3.3);
        queue_double.enqueue(4.4);
        queue_double.enqueue(5.5);

        System.out.println("queue_float.hashCode():     " + queue_float.hashCode());
        System.out.println("queue_double.hashCode():    " + queue_double.hashCode());

        Queue<Byte> queue_byte = new Queue<Byte>(5);
        Queue<Short> queue_short = new Queue<Short>(5);
        Queue<Integer> queue_int = new Queue<Integer>(5);
        Queue<Long> queue_long = new Queue<Long>(5);

        queue_byte.enqueue((byte) 1);
        queue_byte.enqueue((byte) 2);
        queue_byte.enqueue((byte) 3);
        queue_byte.enqueue((byte) 4);
        queue_byte.enqueue((byte) 5);

        queue_short.enqueue((short) 1);
        queue_short.enqueue((short) 2);
        queue_short.enqueue((short) 3);
        queue_short.enqueue((short) 4);
        queue_short.enqueue((short) 5);

        queue_int.enqueue(1);
        queue_int.enqueue(2);
        queue_int.enqueue(3);
        queue_int.enqueue(4);
        queue_int.enqueue(5);

        queue_long.enqueue(1L);
        queue_long.enqueue(2L);
        queue_long.enqueue(3L);
        queue_long.enqueue(4L);
        queue_long.enqueue(5L);

        System.out.println("queue_byte.hashCode():  " + queue_byte.hashCode());
        System.out.println("queue_short.hashCode(): " + queue_short.hashCode());
        System.out.println("queue_int.hashCode():   " + queue_int.hashCode());
        System.out.println("queue_long.hashCode():  " + queue_long.hashCode());
    }
}
