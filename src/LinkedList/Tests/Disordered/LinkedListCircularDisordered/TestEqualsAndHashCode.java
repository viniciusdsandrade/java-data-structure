package LinkedList.Tests.Disordered.LinkedListCircularDisordered;

import LinkedList.Disordered.LinkedListCircularDisordered;

public class TestEqualsAndHashCode {
    public static void main(String[] args) {
        LinkedListCircularDisordered<Integer> list = new LinkedListCircularDisordered<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);

        LinkedListCircularDisordered<Integer> list1 = new LinkedListCircularDisordered<>();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list1.addLast(5);

        LinkedListCircularDisordered<Integer> list2 = new LinkedListCircularDisordered<>();
        list2.addLast(1);
        list2.addLast(5);

        LinkedListCircularDisordered<Integer> list3 = new LinkedListCircularDisordered<>();
        list3.addLast(1);
        list3.addLast(2);
        list3.addLast(3);
        list3.addLast(4);
        list3.addLast(5);

        System.out.println("list:  " + list);
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
        System.out.println("list3: " + list3);
        System.out.println("list.hashCode():  " + list.hashCode());
        System.out.println("list1.hashCode(): " + list1.hashCode());
        System.out.println("list2.hashCode(): " + list2.hashCode());
        System.out.println("list3.hashCode(): " + list3.hashCode());
        
        System.out.println("list.equals(list1):  " + list.equals(list1));
        System.out.println("list1.equals(list2): " + list1.equals(list2));
        System.out.println("list1.equals(list3): " + list1.equals(list3));
        System.out.println("list2.equals(list3): " + list2.equals(list3));
    }
}