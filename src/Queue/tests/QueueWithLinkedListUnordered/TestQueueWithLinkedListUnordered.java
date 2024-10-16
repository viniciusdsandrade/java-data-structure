package Queue.tests.QueueWithLinkedListUnordered;

import Queue.QueueWithLinkedListUnordered;

import java.util.List;

public class TestQueueWithLinkedListUnordered {
    public static void main(String[] args) {
        QueueWithLinkedListUnordered<Integer> queueWithLinkedListUnordered = new QueueWithLinkedListUnordered<Integer>(5);
        queueWithLinkedListUnordered.enqueue(1);
        queueWithLinkedListUnordered.enqueue(2);
        queueWithLinkedListUnordered.enqueue(3);
        queueWithLinkedListUnordered.enqueue(4);
        queueWithLinkedListUnordered.enqueue(5);

        System.out.println("queue.isFull():         " + queueWithLinkedListUnordered.isFull());
        System.out.println("queue:                  " + queueWithLinkedListUnordered.toArray());
        System.out.println("queue.getTamanho():     " + queueWithLinkedListUnordered.getTamanho());
        System.out.println("queue.getCapacidade():  " + queueWithLinkedListUnordered.getCapacidade());
        System.out.println("queue.isEmpty():        " + queueWithLinkedListUnordered.isEmpty());
        System.out.println("queue.peek():           " + queueWithLinkedListUnordered.peek());
        System.out.println("queue.peekLast():       " + queueWithLinkedListUnordered.peekLast());
        System.out.println("queue.dequeue():        " + queueWithLinkedListUnordered.dequeue());
        System.out.println("queue.toArray():        " + queueWithLinkedListUnordered.toArray());
        System.out.println("queue.search(3):        " + queueWithLinkedListUnordered.search(3));
        System.out.println("queue.search(10):       " + queueWithLinkedListUnordered.search(10));
        System.out.println("queue.contains(3):      " + queueWithLinkedListUnordered.contains(3));
        System.out.println("queue.contains(10):     " + queueWithLinkedListUnordered.contains(10));
        System.out.println("queue.isEmpty():        " + queueWithLinkedListUnordered.isEmpty());
        System.out.println("queue.clear(): ");
        queueWithLinkedListUnordered.clear();
        System.out.println("queue.isEmpty():        " + queueWithLinkedListUnordered.isEmpty());
        System.out.println("queue:                  " + queueWithLinkedListUnordered.toArray());

        QueueWithLinkedListUnordered<Integer> queueWithLinkedListUnordered2 = new QueueWithLinkedListUnordered<Integer>(5);
        queueWithLinkedListUnordered2.enqueue(1);
        queueWithLinkedListUnordered2.enqueue(2);
        queueWithLinkedListUnordered2.enqueue(3);
        queueWithLinkedListUnordered2.enqueue(4);
        queueWithLinkedListUnordered2.enqueue(5);

        List<Integer> list = queueWithLinkedListUnordered2.toList();
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
