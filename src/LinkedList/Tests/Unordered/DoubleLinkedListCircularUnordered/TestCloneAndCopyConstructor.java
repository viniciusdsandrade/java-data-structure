package LinkedList.Tests.Unordered.DoubleLinkedListCircularUnordered;

import LinkedList.Unordered.DoubleLinkedListCircularUnordered;

public class TestCloneAndCopyConstructor {
    public static void main(String[] args) {
        DoubleLinkedListCircularUnordered<Integer> list = new DoubleLinkedListCircularUnordered<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        DoubleLinkedListCircularUnordered<Integer> list2 = new DoubleLinkedListCircularUnordered<>(list);
        @SuppressWarnings("unchecked")
        DoubleLinkedListCircularUnordered<Integer> list3 = (DoubleLinkedListCircularUnordered<Integer>) list.clone();

        System.out.println("List 1: " + list);
        System.out.println("List 2: " + list2);
        System.out.println("List 3: " + list3);

        list.addLast(6);

        System.out.println("Depois de adicionar 6 ao list:");
        System.out.println("List 1: " + list);
        System.out.println("List 2: " + list2);
        System.out.println("List 3: " + list3);

        list2.addLast(6);
        list2.addLast(7);
        
        list3.addLast(8);
        list3.addLast(6);
        list3.addLast(7);

        System.out.println("Depois de adicionar 6, 7 ao list2 e 6, 7, 8 ao list3:");
        System.out.println("List 1: " + list);
        System.out.println("List 2: " + list2);
        System.out.println("List 3: " + list3);
    }
}
