package LinkedList.Tests.Ordered.DoubleLinkedListCircularOrdered;

import LinkedList.Ordered.DoubleLinkedListCircularOrdered;

public class TestEqualsAndHashCode {
    public static void main(String[] args) {
        DoubleLinkedListCircularOrdered<Integer> list1 = new DoubleLinkedListCircularOrdered<>();
        DoubleLinkedListCircularOrdered<Integer> list2 = new DoubleLinkedListCircularOrdered<>();
        DoubleLinkedListCircularOrdered<Integer> list3 = new DoubleLinkedListCircularOrdered<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        
        list2.add(4);
        list2.add(2);
        list2.add(1);
        list2.add(3);
        
        list3.add(4);
        list3.add(2);
        list3.add(1);
        list3.add(0);
        
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
        System.out.println("list3: " + list3);

        System.out.println("list1.equals(list2): " + list1.equals(list2));
        System.out.println("list1.equals(list3): " + list1.equals(list3));
        System.out.println("list1.hashCode(): " + list1.hashCode());
        System.out.println("list2.hashCode(): " + list2.hashCode());
        System.out.println("list3.hashCode(): " + list3.hashCode());
    }
}
