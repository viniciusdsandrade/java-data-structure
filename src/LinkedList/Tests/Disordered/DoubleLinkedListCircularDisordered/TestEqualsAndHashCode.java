package LinkedList.Tests.Disordered.DoubleLinkedListCircularDisordered;

import LinkedList.Disordered.DoubleLinkedListCircularDisordered;

public class TestEqualsAndHashCode {
    public static void main(String[] args) {
        DoubleLinkedListCircularDisordered<Integer> list1 = new DoubleLinkedListCircularDisordered<>();
        DoubleLinkedListCircularDisordered<Integer> list2 = new DoubleLinkedListCircularDisordered<>();

        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list1.addLast(5);

        list2.addLast(1);
        list2.addLast(2);
        list2.addLast(3);
        list2.addLast(4);
        list2.addLast(5);

        System.out.println("List1: " + list1);
        System.out.println("List2: " + list2);

        System.out.println("List1.hashCode(): " + list1.hashCode());
        System.out.println("List2.hashCode(): " + list2.hashCode());
    }
}
