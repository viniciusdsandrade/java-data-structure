package LinkedList.Tests.Ordered.LinkedListOrdered;

import LinkedList.Ordered.LinkedListOrdered;

public class TestLinkedListOrdered {
    public static void main(String[] args) throws Exception {
        LinkedListOrdered<Integer> list = new LinkedListOrdered<>();
        
        list.add(10);
        list.add(5);
        list.add(15);
        list.add(3);
        list.add(7);
        list.add(12);

        System.out.println(list);
        
        list.deleteAt(5);
        System.out.println(list);
    }
}
