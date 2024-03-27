package LinkedList.Tests.Ordered.DoubleLinkedListCircularOrdered;

import LinkedList.Ordered.DoubleLinkedListCircularOrdered;

public class TestDoubleLinkedListCircularOrdered {
    public static void main(String[] args) {
        DoubleLinkedListCircularOrdered<Integer> list = new DoubleLinkedListCircularOrdered<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        System.out.println(list);
    }
}

