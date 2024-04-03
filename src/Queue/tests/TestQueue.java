package Queue.tests;

import Queue.Queue;

public class TestQueue {
    public static void main(String[] args) {

        Queue<Integer> queue = new Queue<Integer>(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("queue: " + queue.toArray());
        System.out.println("queue.getTamanho(): " + queue.getTamanho());
        System.out.println("queue.getCapacidade(): " + queue.getCapacidade());
        System.out.println("queue.isEmpty(): " + queue.isEmpty());
        System.out.println("queue.peek(): " + queue.peek());
        System.out.println("queue.dequeue(): " + queue.dequeue());
        System.out.println("queue: " + queue.toArray());
        System.out.println("queue.search(3): " + queue.search(3));
        System.out.println("queue.search(10): " + queue.search(10));
        System.out.println("queue.contains(3): " + queue.contains(3));
        System.out.println("queue.contains(10): " + queue.contains(10));
        System.out.println("queue.isEmpty(): " + queue.isEmpty());
        System.out.println("queue.clear()");
        queue.clear();
        System.out.println("queue.isEmpty(): " + queue.isEmpty());
        System.out.println("queue: " + queue.toArray());
    }
}
