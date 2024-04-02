package LinkedList.Tests.Ordered.DoubleLinkedListCircularOrdered;

import LinkedList.Ordered.DoubleLinkedListCircularOrdered;

public class TestCloneAndCopyConstructor {
    public static void main(String[] args) {
        DoubleLinkedListCircularOrdered<Integer> list1 = new DoubleLinkedListCircularOrdered<>();
        list1.add(4);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(-1);
        list1.add(0);
        list1.add(9);
        System.out.println("List1:  " + list1);
        
        DoubleLinkedListCircularOrdered<Integer> list = new DoubleLinkedListCircularOrdered<>();
        list.add(6);
        list.add(5);
        list.add(3);
        list.add(4);
        list.add(9);
        list.add(0);
        list.add(-1);
        list.add(1);
        list.add(2);
        
        @SuppressWarnings("unchecked")
        DoubleLinkedListCircularOrdered<Integer> list_clone = (DoubleLinkedListCircularOrdered<Integer>) list.clone();
        DoubleLinkedListCircularOrdered<Integer> list_copy = new DoubleLinkedListCircularOrdered<>(list);
        System.out.println("List original: " + list);
        System.out.println("List copy:     " + list_copy);
        System.out.println("List clone:    " + list_clone);

        list.removeFirst();
        list.removeLast();

        System.out.println("Depois de remover o primeiro e o último elemento da lista original:");
        System.out.println("List original: " + list);
        System.out.println("List clone:    " + list_clone);
        System.out.println("List copy:     " + list_copy);

        list.removeAt(2);

        System.out.println("Depois de remover o terceiro elemento da lista original:");
        System.out.println("List original: " + list);
        System.out.println("List clone:    " + list_clone);
        System.out.println("List copy:     " + list_copy);
        
        list.add(6);
        list.add(7);
        list.add(8);

        System.out.println("Depois de adicionar 6, 7 e 8 na lista original:");
        System.out.println("List original: " + list);
        System.out.println("List clone:    " + list_clone);
        System.out.println("List copy:     " + list_copy);

        System.out.println("Depois de adicionar 0, -1 no clone e na copia");
        list_clone.add(0);
        list_copy.add(0);
        System.out.println("List original: " + list);
        System.out.println("List clone:    " + list_clone);
        System.out.println("List copy:     " + list_copy);
    }
}
