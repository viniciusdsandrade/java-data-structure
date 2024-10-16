package Queue.tests.QueueWithLinkedListUnordered;

import Queue.QueueWithLinkedListUnordered;

public class TestCloneAndCopyConstructor {
    public static void main(String[] args) {
        QueueWithLinkedListUnordered<Integer> queueWithLinkedListUnordered = new QueueWithLinkedListUnordered<Integer>(100);
        queueWithLinkedListUnordered.enqueue(1);
        queueWithLinkedListUnordered.enqueue(2);
        queueWithLinkedListUnordered.enqueue(3);
        queueWithLinkedListUnordered.enqueue(4);
        queueWithLinkedListUnordered.enqueue(5);

        @SuppressWarnings("unchecked")
        QueueWithLinkedListUnordered<Integer> clone = (QueueWithLinkedListUnordered<Integer>) queueWithLinkedListUnordered.clone();
        QueueWithLinkedListUnordered<Integer> copy = new QueueWithLinkedListUnordered<Integer>(queueWithLinkedListUnordered);

        System.out.println("queue: " + queueWithLinkedListUnordered);
        System.out.println("clone: " + clone);
        System.out.println("copy:  " + copy);

        System.out.println("queue.toArray(): " + queueWithLinkedListUnordered.toArray());
        System.out.println("clone.toArray(): " + clone.toArray());
        System.out.println("copy.toArray():  " + copy.toArray());

        System.out.println("Adicionando 6 na fila");
        queueWithLinkedListUnordered.enqueue(6);

        System.out.println("queue.toArray(): " + queueWithLinkedListUnordered.toArray());
        System.out.println("clone.toArray(): " + clone.toArray());
        System.out.println("copy.toArray():  " + copy.toArray());

        System.out.println("adicionando 6 e 7 na copia e no clone");
        copy.enqueue(6);
        copy.enqueue(7);

        clone.enqueue(6);
        clone.enqueue(7);

        System.out.println("queue.toArray(): " + queueWithLinkedListUnordered.toArray());
        System.out.println("copy.toArray():  " + copy.toArray());
        System.out.println("clone.toArray(): " + clone.toArray());
    }
}
