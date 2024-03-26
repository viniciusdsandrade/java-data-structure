package LinkedList.Tests.Disordered.DoubleLinkedListCircularDisordered;

import LinkedList.Disordered.DoubleLinkedListCircularDisordered;

public class TestCloneAndCopyConstructor {
    public static void main(String[] args) {
        DoubleLinkedListCircularDisordered<Integer> list = new DoubleLinkedListCircularDisordered<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        DoubleLinkedListCircularDisordered<Integer> list2 = new DoubleLinkedListCircularDisordered<>(list);
        @SuppressWarnings("unchecked")
        DoubleLinkedListCircularDisordered<Integer> list3 = (DoubleLinkedListCircularDisordered<Integer>) list.clone();

        System.out.println("List 1: " + list);
        System.out.println("List 2: " + list2);
        System.out.println("List 3: " + list3);

        list.addLast(6);

        System.out.println("Depois de adicionar 6 ao list:");
        System.out.println("List 1: " + list);
        System.out.println("List 2: " + list2);
        System.out.println("List 3: " + list3);
    }
}
