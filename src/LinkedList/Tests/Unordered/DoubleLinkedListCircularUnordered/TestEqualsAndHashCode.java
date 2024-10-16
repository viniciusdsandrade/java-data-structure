package LinkedList.Tests.Unordered.DoubleLinkedListCircularUnordered;

import LinkedList.Unordered.DoubleLinkedListCircularUnordered;

public class TestEqualsAndHashCode {
    public static void main(String[] args) {
        DoubleLinkedListCircularUnordered<Integer> list1 = new DoubleLinkedListCircularUnordered<>();
        DoubleLinkedListCircularUnordered<Integer> list2 = new DoubleLinkedListCircularUnordered<>();
        DoubleLinkedListCircularUnordered<Integer> list3 = new DoubleLinkedListCircularUnordered<>();

        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list1.addLast(5);

        list2.addFirst(1);
        list2.addFirst(2);
        list2.addFirst(3);
        list2.addFirst(4);
        list2.addFirst(5);

        System.out.println("List1: " + list1);
        System.out.println("List2: " + list2);

        System.out.println("List1.hashCode(): " + list1.hashCode());
        System.out.println("List2.hashCode(): " + list2.hashCode());

        System.out.println("List1.equals(List2): " + list1.equals(list2));

        list3.addLast(1);
        list3.addLast(2);
        list3.addLast(3);
        list3.addLast(4);
        list3.addLast(5);

        System.out.println("List3: " + list3);
        System.out.println("List3.hashCode(): " + list3.hashCode());
    }
}
