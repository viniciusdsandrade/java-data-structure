package LinkedList.Tests.Unordered.LinkedListCircularUnordered;

import LinkedList.Unordered.LinkedListCircularUnordered;

public class TestCloneAndCopyConstructor {
    public static void main(String[] args) {
        LinkedListCircularUnordered<Integer> list = new LinkedListCircularUnordered<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        LinkedListCircularUnordered<Integer> listCopy = new LinkedListCircularUnordered<>();
        listCopy.addLast(1);
        listCopy.addLast(4);
        listCopy.addLast(3);
        listCopy.addLast(2);
        listCopy.addLast(5);

        System.out.println("list1.hashCode(): " + list.hashCode());
        System.out.println("list2.hashCode(): " + listCopy.hashCode());

        LinkedListCircularUnordered<Integer> listCopyConstructor = new LinkedListCircularUnordered<>(list);
        @SuppressWarnings("unchecked")
        LinkedListCircularUnordered<Integer> listClone = (LinkedListCircularUnordered<Integer>) list.clone();

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
