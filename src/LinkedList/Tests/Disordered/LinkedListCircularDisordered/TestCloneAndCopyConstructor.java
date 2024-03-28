package LinkedList.Tests.Disordered.LinkedListCircularDisordered;

import LinkedList.Disordered.LinkedListCircularDisordered;

public class TestCloneAndCopyConstructor {
    public static void main(String[] args) {
        LinkedListCircularDisordered<Integer> list = new LinkedListCircularDisordered<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        LinkedListCircularDisordered<Integer> listCopy = new LinkedListCircularDisordered<>();
        listCopy.addLast(1);
        listCopy.addLast(4);
        listCopy.addLast(3);
        listCopy.addLast(2);
        listCopy.addLast(5);

        System.out.println("list1.hashCode(): " + list.hashCode());
        System.out.println("list2.hashCode(): " + listCopy.hashCode());

        LinkedListCircularDisordered<Integer> listCopyConstructor = new LinkedListCircularDisordered<>(list);
        @SuppressWarnings("unchecked")
        LinkedListCircularDisordered<Integer> listClone = (LinkedListCircularDisordered<Integer>) list.clone();

        System.out.println("list:   " + list);
        System.out.println("copy:   " + listCopyConstructor);
        System.out.println("clone:  " + listClone);

        System.out.println("list.hashCode():  " + list.hashCode());
        System.out.println("copy.hashCode():  " + listCopyConstructor.hashCode());
        System.out.println("clone.hashCode(): " + listClone.hashCode());
        System.out.println();

        System.out.println("Modificando list...");
        list.addFirst(0);
        list.addLast(6);

        System.out.println("list:   " + list);
        System.out.println("copy:   " + listCopyConstructor);
        System.out.println("clone:  " + listClone);

        System.out.println("list.hashCode():  " + list.hashCode());
        System.out.println("copy.hashCode():  " + listCopyConstructor.hashCode());
        System.out.println("clone.hashCode(): " + listClone.hashCode());
    }
}
