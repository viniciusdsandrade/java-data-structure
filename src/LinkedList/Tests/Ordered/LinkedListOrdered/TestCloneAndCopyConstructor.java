package LinkedList.Tests.Ordered.LinkedListOrdered;

import LinkedList.Ordered.LinkedListOrdered;

public class TestCloneAndCopyConstructor {
    public static void main(String[] args) throws Exception {
        LinkedListOrdered<Integer> list = new LinkedListOrdered<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        LinkedListOrdered<Integer> copy = new LinkedListOrdered<>(list);
        @SuppressWarnings("unchecked")
        LinkedListOrdered<Integer> clone = (LinkedListOrdered<Integer>) list.clone();

        System.out.println("List:   " + list);
        System.out.println("Clone:  " + clone);
        System.out.println("Copy:   " + copy);

        list.add(6);

        System.out.println("Depois de adicionar 6 a list");
        System.out.println("List:   " + list);
        System.out.println("Clone:  " + clone);
        System.out.println("Copy:   " + copy);

        clone.add(6);
        clone.add(7);

        copy.add(6);
        copy.add(7);
        copy.add(8);

        System.out.println("Depois de adicionar 6 e 7 a clone e 6, 7 e 8 a copy");
        System.out.println("List:   " + list);
        System.out.println("Clone:  " + clone);
        System.out.println("Copy:   " + copy);
    }
}
