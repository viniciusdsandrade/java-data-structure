package LinkedList.tests.LinkedListDisordered;

import LinkedList.LinkedListDisordered;

public class TestLinkedListDisordered {
    public static void main(String[] args) {

        LinkedListDisordered<Object> list = new LinkedListDisordered<>();

        list.add(1);
        list.add(2);

        list.add("Hello");
        list.add("World");

        list.add(4.5);
        list.add(6.7);

        list.add(4L);
        list.add(6L);

        list.add(4.5f);
        list.add(6.7f);

        list.add(4.5d);
        list.add(6.7d);

        list.add('a');
        list.add('b');

        list.add(true);
        list.add(false);

        list.add(null);

        LinkedListDisordered<LinkedListDisordered<Integer>> list2 = new LinkedListDisordered<>();
        LinkedListDisordered<Integer> sublist1 = new LinkedListDisordered<>();
        sublist1.add(1);
        sublist1.add(2);
        sublist1.add(3);

        LinkedListDisordered<Integer> sublist2 = new LinkedListDisordered<>();
        sublist2.add(4);
        sublist2.add(5);
        sublist2.add(6);

        list2.add(sublist1);
        list2.add(sublist2);

        list.add(list2);

        System.out.println(list);
    }
}
