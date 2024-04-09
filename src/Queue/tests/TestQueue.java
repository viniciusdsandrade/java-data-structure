package Queue.tests;

import Queue.Queue;

import java.util.List;

public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("queue.isFull():         "    + queue.isFull());
        System.out.println("queue:                  " + queue.toArray());
        System.out.println("queue.getTamanho():     " + queue.getTamanho());
        System.out.println("queue.getCapacidade():  " + queue.getCapacidade());
        System.out.println("queue.isEmpty():        " + queue.isEmpty());
        System.out.println("queue.peek():           " + queue.peek());
        System.out.println("queue.peekLast():       " + queue.peekLast());
        System.out.println("queue.dequeue():        " + queue.dequeue());
        System.out.println("queue.toArray():        " + queue.toArray());
        System.out.println("queue.search(3):        " + queue.search(3));
        System.out.println("queue.search(10):       " + queue.search(10));
        System.out.println("queue.contains(3):      " + queue.contains(3));
        System.out.println("queue.contains(10):     " + queue.contains(10));
        System.out.println("queue.isEmpty():        " + queue.isEmpty());
        System.out.println("queue.clear(): ");
        queue.clear();
        System.out.println("queue.isEmpty():        " + queue.isEmpty());
        System.out.println("queue:                  " + queue.toArray());

        Queue<Integer> queue2 = new Queue<Integer>(5);
        queue2.enqueue(1);
        queue2.enqueue(2);
        queue2.enqueue(3);
        queue2.enqueue(4);
        queue2.enqueue(5);

        List<Integer> list = queue2.toList();
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
