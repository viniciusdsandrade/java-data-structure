package LinkedList.Tests.Unordered.LinkedListUnordered;

import LinkedList.Unordered.LinkedListUnordered;

public class TestToString {
    public static void main(String[] args) {

        /*
         * Testando o método toString
         * Integer
         * String
         * Double
         * Long
         * Float
         * Character
         * Boolean
         * Null
         * LinkedListDisordered<Integer>
         * LinkedListDisordered<String>
         * LinkedListDisordered<Character>
         * LinkedListDisordered<Boolean>
         * LinkedListDisordered<Double>
         * LinkedListDisordered<Float>
         * LinkedListDisordered<Long>
         * LinkedListDisordered<LinkedListDisordered<Integer>>
         * LinkedListDisordered<LinkedListDisordered<String>>
         * LinkedListDisordered<LinkedListDisordered<Character>>
         * LinkedListDisordered<LinkedListDisordered<Boolean>>
         * LinkedListDisordered<LinkedListDisordered<Double>>
         * LinkedListDisordered<LinkedListDisordered<Float>>
         * LinkedListDisordered<LinkedListDisordered<Long>>
         */
        LinkedListUnordered<Object> list = new LinkedListUnordered<>();
        list.addLast(1);
        list.addLast(2);

        list.addLast("Hello");
        list.addLast("World");

        list.addLast(4.5);
        list.addLast(6.7);

        list.addLast(4L);
        list.addLast(6L);

        list.addLast(4.5f);
        list.addLast(6.7f);

        list.addLast(4.5d);
        list.addLast(6.7d);

        list.addLast('a');
        list.addLast('b');

        list.addLast(true);
        list.addLast(false);

        //list.addLast(null);

        LinkedListUnordered<LinkedListUnordered<Integer>> list2 = new LinkedListUnordered<>();
        LinkedListUnordered<Integer> sublist1 = new LinkedListUnordered<>();
        sublist1.addLast(1);
        sublist1.addLast(2);
        sublist1.addLast(3);

        LinkedListUnordered<Integer> sublist2 = new LinkedListUnordered<>();
        sublist2.addLast(4);
        sublist2.addLast(5);
        sublist2.addLast(6);

        list2.addLast(sublist1);
        list2.addLast(sublist2);

        list.addLast(list2);

        System.out.println(list);

        LinkedListUnordered<String> linked_string = new LinkedListUnordered<>();
        linked_string.addLast("Vinícius");
        linked_string.addLast("Dos");
        linked_string.addLast("Santos");
        linked_string.addLast("Andrade");
        System.out.println(linked_string);

        LinkedListUnordered<Character> linked_char = new LinkedListUnordered<>();
        linked_char.addLast('V');
        linked_char.addLast('i');
        linked_char.addLast('n');
        linked_char.addLast('í');
        linked_char.addLast('c');
        linked_char.addLast('i');
        linked_char.addLast('u');
        linked_char.addLast('s');
        System.out.println(linked_char);

        LinkedListUnordered<Boolean> linked_bool = new LinkedListUnordered<>();
        linked_bool.addLast(true);
        linked_bool.addLast(false);
        linked_bool.addLast(true);
        linked_bool.addLast(false);
        System.out.println(linked_bool);

        LinkedListUnordered<Double> linked_double = new LinkedListUnordered<>();
        linked_double.addLast(3.14);
        linked_double.addLast(2.71);
        linked_double.addLast(1.61);
        linked_double.addLast(1.41);
        System.out.println(linked_double);

        LinkedListUnordered<Float> linked_float = new LinkedListUnordered<>();
        linked_float.addLast(3.14f);
        linked_float.addLast(2.71f);
        linked_float.addLast(1.61f);
        linked_float.addLast(1.41f);
        System.out.println(linked_float);

        LinkedListUnordered<Long> linked_long = new LinkedListUnordered<>();
        linked_long.addLast(314L);
        linked_long.addLast(271L);
        linked_long.addLast(161L);
        linked_long.addLast(141L);
        System.out.println(linked_long);

        LinkedListUnordered<LinkedListUnordered<Integer>> linked_linked_int = new LinkedListUnordered<>();
        LinkedListUnordered<Integer> sublist1_1 = new LinkedListUnordered<>();
        sublist1_1.addLast(1);
        sublist1_1.addLast(2);
        sublist1_1.addLast(3);

        LinkedListUnordered<Integer> sublist2_2 = new LinkedListUnordered<>();
        sublist2_2.addLast(4);
        sublist2_2.addLast(5);
        sublist2_2.addLast(6);

        linked_linked_int.addLast(sublist1_1);
        linked_linked_int.addLast(sublist2_2);

        System.out.println(linked_linked_int);

        LinkedListUnordered<LinkedListUnordered<String>> linked_linked_string = new LinkedListUnordered<>();
        LinkedListUnordered<String> sublist3 = new LinkedListUnordered<>();
        sublist3.addLast("Vinícius");
        sublist3.addLast("Dos");
        sublist3.addLast("Santos");
        sublist3.addLast("Andrade");

        LinkedListUnordered<String> sublist4 = new LinkedListUnordered<>();
        sublist4.addLast("Arthur");
        sublist4.addLast("Dos");
        sublist4.addLast("Santos");
        sublist4.addLast("Andrade");

        linked_linked_string.addLast(sublist3);
        linked_linked_string.addLast(sublist4);

        System.out.println(linked_linked_string);

        LinkedListUnordered<LinkedListUnordered<Character>> linked_linked_char = new LinkedListUnordered<>();
        LinkedListUnordered<Character> sublist5 = new LinkedListUnordered<>();
        sublist5.addLast('V');
        sublist5.addLast('i');
        sublist5.addLast('n');
        sublist5.addLast('í');
        sublist5.addLast('c');
        sublist5.addLast('i');
        sublist5.addLast('u');
        sublist5.addLast('s');

        LinkedListUnordered<Character> sublist6 = new LinkedListUnordered<>();
        sublist6.addLast('A');
        sublist6.addLast('r');
        sublist6.addLast('t');
        sublist6.addLast('h');
        sublist6.addLast('u');
        sublist6.addLast('r');

        linked_linked_char.addLast(sublist5);
        linked_linked_char.addLast(sublist6);

        System.out.println(linked_linked_char);

        LinkedListUnordered<LinkedListUnordered<Boolean>> linked_linked_bool = new LinkedListUnordered<>();
        LinkedListUnordered<Boolean> sublist7 = new LinkedListUnordered<>();
        sublist7.addLast(true);
        sublist7.addLast(false);
        sublist7.addLast(true);
        sublist7.addLast(false);

        LinkedListUnordered<Boolean> sublist8 = new LinkedListUnordered<>();
        sublist8.addLast(false);
        sublist8.addLast(true);
        sublist8.addLast(false);
        sublist8.addLast(true);

        linked_linked_bool.addLast(sublist7);
        linked_linked_bool.addLast(sublist8);

        System.out.println(linked_linked_bool);

        LinkedListUnordered<LinkedListUnordered<Double>> linked_linked_double = new LinkedListUnordered<>();
        LinkedListUnordered<Double> sublist9 = new LinkedListUnordered<>();
        sublist9.addLast(3.14);
        sublist9.addLast(2.71);
        sublist9.addLast(1.61);
        sublist9.addLast(1.41);

        LinkedListUnordered<Double> sublist10 = new LinkedListUnordered<>();
        sublist10.addLast(3.14);
        sublist10.addLast(2.71);
        sublist10.addLast(1.61);
        sublist10.addLast(1.41);

        linked_linked_double.addLast(sublist9);
        linked_linked_double.addLast(sublist10);

        System.out.println(linked_linked_double);

        LinkedListUnordered<LinkedListUnordered<Float>> linked_linked_float = new LinkedListUnordered<>();
        LinkedListUnordered<Float> sublist11 = new LinkedListUnordered<>();
        sublist11.addLast(3.14f);
        sublist11.addLast(2.71f);
        sublist11.addLast(1.61f);
        sublist11.addLast(1.41f);

        LinkedListUnordered<Float> sublist12 = new LinkedListUnordered<>();
        sublist12.addLast(3.14f);
        sublist12.addLast(2.71f);
        sublist12.addLast(1.61f);
        sublist12.addLast(1.41f);

        linked_linked_float.addLast(sublist11);
        linked_linked_float.addLast(sublist12);

        System.out.println(linked_linked_float);

        LinkedListUnordered<LinkedListUnordered<Long>> linked_linked_long = new LinkedListUnordered<>();
        LinkedListUnordered<Long> sublist13 = new LinkedListUnordered<>();
        sublist13.addLast(314L);
        sublist13.addLast(271L);
        sublist13.addLast(161L);
        sublist13.addLast(141L);

        LinkedListUnordered<Long> sublist14 = new LinkedListUnordered<>();
        sublist14.addLast(314L);
        sublist14.addLast(271L);
        sublist14.addLast(161L);
        sublist14.addLast(141L);

        linked_linked_long.addLast(sublist13);
        linked_linked_long.addLast(sublist14);

        System.out.println(linked_linked_long);
    }
}