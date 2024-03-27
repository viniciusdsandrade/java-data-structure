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
        
        @SuppressWarnings("unchecked")
        LinkedListOrdered<Integer> clone = (LinkedListOrdered<Integer>) list.clone();
        LinkedListOrdered<Integer> copy = new LinkedListOrdered<>(list);
        
        System.out.println("List:   " + list);
        System.out.println("Clone:  " + clone);
        System.out.println("Copy:   " + copy);
        
        
        list.add(6);
        list.add(7);

        System.out.println();
        System.out.println("List:   " + list);
        System.out.println("Clone:  " + clone);
        System.out.println("Copy:   " + copy);
        
    }
}
