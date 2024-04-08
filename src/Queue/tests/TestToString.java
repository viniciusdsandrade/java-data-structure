package Queue.tests;

import Queue.Queue;

public class TestToString {
    public static void main(String[] args) {
        Queue<Integer> queue_int = new Queue<Integer>(5);
        Queue<String> queue_str = new Queue<String>(5);
        Queue<Character> queue_char = new Queue<Character>(5);
        Queue<Float> queue_float = new Queue<Float>(5);
        Queue<Boolean> queue_bool = new Queue<Boolean>(5);
        Queue<Double> queue_double = new Queue<Double>(5);
        Queue<Long> queue_long = new Queue<Long>(5);
        Queue<Short> queue_short = new Queue<Short>(5);
        Queue<Byte> queue_byte = new Queue<Byte>(5);


        queue_int.enqueue(1);
        queue_int.enqueue(2);
        queue_int.enqueue(3);
        queue_int.enqueue(4);
        queue_int.enqueue(5);

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

        queue_float.enqueue(1.1f);
        queue_float.enqueue(2.2f);
        queue_float.enqueue(3.3f);
        queue_float.enqueue(4.4f);
        queue_float.enqueue(5.5f);

        queue_bool.enqueue(true);
        queue_bool.enqueue(false);
        queue_bool.enqueue(true);
        queue_bool.enqueue(false);
        queue_bool.enqueue(true);

        queue_double.enqueue(1.1);
        queue_double.enqueue(2.2);
        queue_double.enqueue(3.3);
        queue_double.enqueue(4.4);
        queue_double.enqueue(5.5);

        queue_long.enqueue(1L);
        queue_long.enqueue(2L);
        queue_long.enqueue(3L);
        queue_long.enqueue(4L);
        queue_long.enqueue(5L);

        queue_short.enqueue((short) 1);
        queue_short.enqueue((short) 2);
        queue_short.enqueue((short) 3);
        queue_short.enqueue((short) 4);
        queue_short.enqueue((short) 5);

        queue_byte.enqueue((byte) 1);
        queue_byte.enqueue((byte) 2);
        queue_byte.enqueue((byte) 3);
        queue_byte.enqueue((byte) 4);
        queue_byte.enqueue((byte) 5);

        System.out.println("Test do método toString()");
        System.out.println("Queue<Integer>:     " + queue_int);
        System.out.println("Queue<String>:      " + queue_str);
        System.out.println("Queue<Character>:   " + queue_char);
        System.out.println("Queue<Float>:       " + queue_float);
        System.out.println("Queue<Boolean>:     " + queue_bool);
        System.out.println("Queue<Double>:      " + queue_double);
        System.out.println("Queue<Long>:        " + queue_long);
        System.out.println("Queue<Short>:       " + queue_short);
        System.out.println("Queue<Byte>:        " + queue_byte);
        System.out.println();
        System.out.println("Test do método toArray()");
        System.out.println("Queue<Integer>:     " + queue_int.toArray());
        System.out.println("Queue<String>:      " + queue_str.toArray());
        System.out.println("Queue<Character>:   " + queue_char.toArray());
        System.out.println("Queue<Float>:       " + queue_float.toArray());
        System.out.println("Queue<Boolean>:     " + queue_bool.toArray());
        System.out.println("Queue<Double>:      " + queue_double.toArray());
        System.out.println("Queue<Long>:        " + queue_long.toArray());
        System.out.println("Queue<Short>:       " + queue_short.toArray());
        System.out.println("Queue<Byte>:        " + queue_byte.toArray());
    }
}
