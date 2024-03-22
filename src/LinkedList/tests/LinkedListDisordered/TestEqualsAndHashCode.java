package LinkedList.tests.LinkedListDisordered;

import LinkedList.LinkedListDisordered;
import java.util.ArrayList;
import java.util.List;

public class TestEqualsAndHashCode {
    public static void main(String[] args) {
        LinkedListDisordered<List<LinkedListDisordered<Integer>>> list1 = new LinkedListDisordered<>();
        LinkedListDisordered<List<LinkedListDisordered<Integer>>> list2 = new LinkedListDisordered<>();

        // Adicionando elementos a list1
        List<LinkedListDisordered<Integer>> sublist1 = new ArrayList<>();
        LinkedListDisordered<Integer> sublist1_1 = new LinkedListDisordered<>();
        sublist1_1.addLast(1);
        sublist1_1.addLast(2);
        sublist1_1.addLast(3);
        sublist1_1.addLast(4);
        sublist1.addLast(sublist1_1);
        list1.addLast(sublist1);

        // Adicionando elementos a list2
        List<LinkedListDisordered<Integer>> sublist2 = new ArrayList<>();
        LinkedListDisordered<Integer> sublist2_1 = new LinkedListDisordered<>();
        sublist2_1.addLast(1);
        sublist2_1.addLast(2);
        sublist2_1.addLast(3);
        sublist2_1.addLast(4);
        sublist2.addLast(sublist2_1);
        list2.addLast(sublist2);

        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);

        // Testando igualdade
        System.out.println("HashCode de list1:   " + list1.hashCode());
        System.out.println("HashCode de list2:   " + list2.hashCode());
        System.out.println("list1.equals(list2): " + list1.equals(list2));
    }
}