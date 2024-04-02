package LinkedList.Tests.Ordered.LinkedListOrdered;

import LinkedList.Ordered.LinkedListOrdered;

public class TestEqualsAndHashCode {
    public static void main(String[] args) {
        LinkedListOrdered<Integer> list = new LinkedListOrdered<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
        LinkedListOrdered<Integer> list1 = new LinkedListOrdered<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        
        LinkedListOrdered<Integer> list2 = new LinkedListOrdered<>();
        list2.add(1);
        list2.add(5);
        
        LinkedListOrdered<Integer> list3 = new LinkedListOrdered<>();
        list3.add(1);
        list3.add(0);
        list3.add(0);
        list3.add(0);
        list3.add(5);

        System.out.println("list:   " + list);
        System.out.println("list1:  " + list1);
        System.out.println("list2:  " + list2);
        System.out.println("list3:  " + list3);
        System.out.println("list.hashCode():    " + list.hashCode());
        System.out.println("list1.hashCode():   " + list1.hashCode());
        System.out.println("list2.hashCode():   " + list2.hashCode());
        System.out.println("list3.hashCode():   " + list3.hashCode());
        System.out.println("list.equals(list1):  " + list.equals(list1));
        System.out.println("list1.equals(list2): " + list1.equals(list2));
        System.out.println("list1.equals(list3): " + list1.equals(list3));
        System.out.println("list2.equals(list3): " + list2.equals(list3));
    }
}
