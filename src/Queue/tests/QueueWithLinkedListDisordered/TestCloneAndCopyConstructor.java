package Queue.tests.QueueWithLinkedListDisordered;

import Queue.QueueWithLinkedListDisordered;

public class TestCloneAndCopyConstructor {
    public static void main(String[] args) {
        QueueWithLinkedListDisordered<Integer> queueWithLinkedListDisordered = new QueueWithLinkedListDisordered<Integer>(100);
        queueWithLinkedListDisordered.enqueue(1);
        queueWithLinkedListDisordered.enqueue(2);
        queueWithLinkedListDisordered.enqueue(3);
        queueWithLinkedListDisordered.enqueue(4);
        queueWithLinkedListDisordered.enqueue(5);

        @SuppressWarnings("unchecked")
        QueueWithLinkedListDisordered<Integer> clone = (QueueWithLinkedListDisordered<Integer>) queueWithLinkedListDisordered.clone();
        QueueWithLinkedListDisordered<Integer> copy = new QueueWithLinkedListDisordered<Integer>(queueWithLinkedListDisordered);

        System.out.println("queue: " + queueWithLinkedListDisordered);
        System.out.println("clone: " + clone);
        System.out.println("copy:  " + copy);

        System.out.println("queue.toArray(): " + queueWithLinkedListDisordered.toArray());
        System.out.println("clone.toArray(): " + clone.toArray());
        System.out.println("copy.toArray():  " + copy.toArray());

        System.out.println("Adicionando 6 na fila");
        queueWithLinkedListDisordered.enqueue(6);

        System.out.println("queue.toArray(): " + queueWithLinkedListDisordered.toArray());
        System.out.println("clone.toArray(): " + clone.toArray());
        System.out.println("copy.toArray():  " + copy.toArray());

        System.out.println("adicionando 6 e 7 na copia e no clone");
        copy.enqueue(6);
        copy.enqueue(7);

        clone.enqueue(6);
        clone.enqueue(7);

        System.out.println("queue.toArray(): " + queueWithLinkedListDisordered.toArray());
        System.out.println("copy.toArray():  " + copy.toArray());
        System.out.println("clone.toArray(): " + clone.toArray());
    }
}
