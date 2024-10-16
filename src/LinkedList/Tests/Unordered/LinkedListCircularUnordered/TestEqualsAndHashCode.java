package LinkedList.Tests.Unordered.LinkedListCircularUnordered;

import LinkedList.Unordered.LinkedListCircularUnordered;

public class TestEqualsAndHashCode {
    public static void main(String[] args) {
        LinkedListCircularUnordered<Integer> list_int1 = new LinkedListCircularUnordered<>();
        LinkedListCircularUnordered<Integer> list_int2 = new LinkedListCircularUnordered<>();
        list_int1.addLast(1);
        list_int1.addLast(2);
        list_int1.addLast(3);
        list_int1.addLast(4);
        list_int1.addLast(5);

        list_int2.addFirst(1);
        list_int2.addFirst(2);
        list_int2.addFirst(3);
        list_int2.addFirst(4);
        list_int2.addFirst(5);

        System.out.println("list_int1:  " + list_int1);
        System.out.println("list_int2:  " + list_int2);

        System.out.println("list_int1.hashCode():  " + list_int1.hashCode());
        System.out.println("list_int2.hashCode():  " + list_int2.hashCode());
        System.out.println("list_int1.equals(list_int2):  " + list_int1.equals(list_int2));

        LinkedListCircularUnordered<Integer> list = new LinkedListCircularUnordered<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);

        LinkedListCircularUnordered<Integer> list1 = new LinkedListCircularUnordered<>();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list1.addLast(5);

        LinkedListCircularUnordered<Integer> list2 = new LinkedListCircularUnordered<>();
        list2.addLast(1);
        list2.addLast(5);

        LinkedListCircularUnordered<Integer> list3 = new LinkedListCircularUnordered<>();
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