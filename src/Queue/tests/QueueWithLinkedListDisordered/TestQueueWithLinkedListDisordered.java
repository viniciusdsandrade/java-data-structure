package Queue.tests.QueueWithLinkedListDisordered;

import Queue.QueueWithLinkedListDisordered;

import java.util.List;

public class TestQueueWithLinkedListDisordered {
    public static void main(String[] args) {
        QueueWithLinkedListDisordered<Integer> queueWithLinkedListDisordered = new QueueWithLinkedListDisordered<Integer>(5);
        queueWithLinkedListDisordered.enqueue(1);
        queueWithLinkedListDisordered.enqueue(2);
        queueWithLinkedListDisordered.enqueue(3);
        queueWithLinkedListDisordered.enqueue(4);
        queueWithLinkedListDisordered.enqueue(5);

        System.out.println("queue.isFull():         "    + queueWithLinkedListDisordered.isFull());
        System.out.println("queue:                  " + queueWithLinkedListDisordered.toArray());
        System.out.println("queue.getTamanho():     " + queueWithLinkedListDisordered.getTamanho());
        System.out.println("queue.getCapacidade():  " + queueWithLinkedListDisordered.getCapacidade());
        System.out.println("queue.isEmpty():        " + queueWithLinkedListDisordered.isEmpty());
        System.out.println("queue.peek():           " + queueWithLinkedListDisordered.peek());
        System.out.println("queue.peekLast():       " + queueWithLinkedListDisordered.peekLast());
        System.out.println("queue.dequeue():        " + queueWithLinkedListDisordered.dequeue());
        System.out.println("queue.toArray():        " + queueWithLinkedListDisordered.toArray());
        System.out.println("queue.search(3):        " + queueWithLinkedListDisordered.search(3));
        System.out.println("queue.search(10):       " + queueWithLinkedListDisordered.search(10));
        System.out.println("queue.contains(3):      " + queueWithLinkedListDisordered.contains(3));
        System.out.println("queue.contains(10):     " + queueWithLinkedListDisordered.contains(10));
        System.out.println("queue.isEmpty():        " + queueWithLinkedListDisordered.isEmpty());
        System.out.println("queue.clear(): ");
        queueWithLinkedListDisordered.clear();
        System.out.println("queue.isEmpty():        " + queueWithLinkedListDisordered.isEmpty());
        System.out.println("queue:                  " + queueWithLinkedListDisordered.toArray());

        QueueWithLinkedListDisordered<Integer> queueWithLinkedListDisordered2 = new QueueWithLinkedListDisordered<Integer>(5);
        queueWithLinkedListDisordered2.enqueue(1);
        queueWithLinkedListDisordered2.enqueue(2);
        queueWithLinkedListDisordered2.enqueue(3);
        queueWithLinkedListDisordered2.enqueue(4);
        queueWithLinkedListDisordered2.enqueue(5);

        List<Integer> list = queueWithLinkedListDisordered2.toList();
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
