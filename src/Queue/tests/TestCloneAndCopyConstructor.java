package Queue.tests;

import Queue.Queue;

public class TestCloneAndCopyConstructor {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>(100);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        @SuppressWarnings("unchecked")
        Queue<Integer> clone = (Queue<Integer>) queue.clone();
        Queue<Integer> copy = new Queue<Integer>(queue);

        System.out.println("queue: " + queue);
        System.out.println("clone: " + clone);
        System.out.println("copy:  " + copy);

        System.out.println("queue.toArray(): " + queue.toArray());
        System.out.println("clone.toArray(): " + clone.toArray());
        System.out.println("copy.toArray():  " + copy.toArray());

        System.out.println("Adicionando 6 na fila");
        queue.enqueue(6);

        System.out.println("queue.toArray(): " + queue.toArray());
        System.out.println("clone.toArray(): " + clone.toArray());
        System.out.println("copy.toArray():  " + copy.toArray());

        System.out.println("adicionando 6 e 7 na copia e no clone");
        copy.enqueue(6);
        copy.enqueue(7);

        clone.enqueue(6);
        clone.enqueue(7);

        System.out.println("queue.toArray(): " + queue.toArray());
        System.out.println("copy.toArray():  " + copy.toArray());
        System.out.println("clone.toArray(): " + clone.toArray());
    }
}
