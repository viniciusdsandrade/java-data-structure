package LinkedList.Tests.Ordered.DoubleLinkedListOrdered;

import LinkedList.Ordered.DoubleLinkedListOrdered;

public class TestCloneAndCopyConstructor {
    public static void main(String[] args) {
        DoubleLinkedListOrdered<Integer> list = new DoubleLinkedListOrdered<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        DoubleLinkedListOrdered<Integer> list2 = new DoubleLinkedListOrdered<>(list);
        @SuppressWarnings("unchecked")
        DoubleLinkedListOrdered<Integer> list3 = (DoubleLinkedListOrdered<Integer>) list.clone();

        System.out.println("List 1: " + list);
        System.out.println("List 2: " + list2);
        System.out.println("List 3: " + list3);

        list.add(6);

        System.out.println("After adding 6 to list 1:");
        System.out.println("List 1: " + list);
        System.out.println("List 2: " + list2);
        System.out.println("List 3: " + list3);

        list2.add(6);
        list2.add(7);

        list3.add(6);
        list3.add(7);
        list3.add(8);

        System.out.println("After adding 6, 7 and 8 to list 2 and 3:");
        System.out.println("List 1: " + list);
        System.out.println("List 2: " + list2);
        System.out.println("List 3: " + list3);
    }
}
