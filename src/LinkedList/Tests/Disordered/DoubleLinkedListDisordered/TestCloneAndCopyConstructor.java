package LinkedList.Tests.Disordered.DoubleLinkedListDisordered;

import LinkedList.Disordered.DoubleLinkedListDisordered;

public class TestCloneAndCopyConstructor {
    public static void main(String[] args) {
        DoubleLinkedListDisordered<Integer> list = new DoubleLinkedListDisordered<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        DoubleLinkedListDisordered<Integer> list2 = new DoubleLinkedListDisordered<>(list);
        @SuppressWarnings("unchecked")
        DoubleLinkedListDisordered<Integer> list3 = (DoubleLinkedListDisordered<Integer>) list.clone();

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

        list3.addLast(6);
        list3.addLast(7);
        list3.addLast(8);

        System.out.println("Depois de adicionar 6, 7 ao list2 e 6, 7, 8 ao list3:");
        System.out.println("List 1: " + list);
        System.out.println("List 2: " + list2);
        System.out.println("List 3: " + list3);
    }
}
