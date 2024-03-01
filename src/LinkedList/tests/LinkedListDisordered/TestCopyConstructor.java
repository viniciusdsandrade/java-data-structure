package LinkedList.tests.LinkedListDisordered;

import LinkedList.LinkedListDisordered;

public class TestCopyConstructor {
    public static void main(String[] args) {
        LinkedListDisordered<Integer> list = new LinkedListDisordered<>();
        list.add(1);
        list.add(2);
        list.add(3);

        LinkedListDisordered<Integer> list2 = new LinkedListDisordered<>(list);

        @SuppressWarnings("unchecked")
        LinkedListDisordered<Integer> list3 = (LinkedListDisordered<Integer>) list.clone();

        list.add(4);

        System.out.println("Original list:" + list);
        System.out.println("Copy constructor list:" + list2);
        System.out.println("Clone list:" + list3);
    }
}
