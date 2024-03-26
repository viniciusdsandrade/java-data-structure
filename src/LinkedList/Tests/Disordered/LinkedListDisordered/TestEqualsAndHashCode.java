package LinkedList.Tests.Disordered.LinkedListDisordered;

import LinkedList.Disordered.LinkedListDisordered;

import java.util.ArrayList;
import java.util.List;

public class TestEqualsAndHashCode {
    public static void main(String[] args) {
        LinkedListDisordered<List<LinkedListDisordered<List<Integer>>>> list1 = new LinkedListDisordered<>();
        LinkedListDisordered<List<LinkedListDisordered<List<Integer>>>> list2 = new LinkedListDisordered<>();

        List<Integer> listInt1 = new ArrayList<>();
        listInt1.add(1);
        listInt1.add(2);
        listInt1.add(3);
        listInt1.add(4);

        List<Integer> listInt2 = new ArrayList<>();
        listInt2.add(5);
        listInt2.add(6);
        listInt2.add(7);
        listInt2.add(8);

        LinkedListDisordered<List<Integer>> listIntList1 = new LinkedListDisordered<>();
        listIntList1.addLast(listInt1);
        
        LinkedListDisordered<List<Integer>> listIntList2 = new LinkedListDisordered<>();
        listIntList2.addLast(listInt2);

        List<LinkedListDisordered<List<Integer>>> listIntListList1 = new ArrayList<>();
        listIntListList1.add(listIntList1);
        listIntListList1.add(listIntList2);

        List<LinkedListDisordered<List<Integer>>> listIntListList2 = new ArrayList<>();
        listIntListList2.add(listIntList2);
        listIntListList2.add(listIntList1);
        
        list1.addLast(listIntListList2);
        list2.addLast(listIntListList1);

        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);

        System.out.println("list1.hashCode(): " + list1.hashCode());
        System.out.println("list2.hashCode(): " + list2.hashCode());

        System.out.println("list1.equals(list2): " + list1.equals(list2));
    }
}