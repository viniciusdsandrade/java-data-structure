package LinkedList.Tests.Ordered.DoubleLinkedListCircularOrdered;

import LinkedList.Ordered.DoubleLinkedListCircularOrdered;

public class TestCloneAndCopyConstructor {
    public static void main(String[] args) {
        DoubleLinkedListCircularOrdered<Integer> list = new DoubleLinkedListCircularOrdered<>();
        list.add(6);
        list.add(5);
        list.add(3);
        list.add(4);
        list.add(0);
        list.add(-1);
        list.add(1);
        list.add(2);
        System.out.println("List original: " + list);
        
        @SuppressWarnings("unchecked")
        DoubleLinkedListCircularOrdered<Integer> list_clone = (DoubleLinkedListCircularOrdered<Integer>) list.clone();
        System.out.println("List clone:    " + list_clone);
        
        DoubleLinkedListCircularOrdered<Integer> list_copy = new DoubleLinkedListCircularOrdered<>(list);
        System.out.println("List copy:     " + list_copy);
        
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
    }
}
