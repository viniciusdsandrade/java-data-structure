package LinkedList.tests.LinkedListDisordered;

import LinkedList.LinkedListDisordered;

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

        LinkedListDisordered<String> linked_string = new LinkedListDisordered<>();
        linked_string.add("Vinícius");
        linked_string.add("Dos");
        linked_string.add("Santos");
        linked_string.add("Andrade");
        System.out.println(linked_string);

        LinkedListDisordered<Character> linked_char = new LinkedListDisordered<>();
        linked_char.add('V');
        linked_char.add('i');
        linked_char.add('n');
        linked_char.add('í');
        linked_char.add('c');
        linked_char.add('i');
        linked_char.add('u');
        linked_char.add('s');
        System.out.println(linked_char);

        LinkedListDisordered<Boolean> linked_bool = new LinkedListDisordered<>();
        linked_bool.add(true);
        linked_bool.add(false);
        linked_bool.add(true);
        linked_bool.add(false);
        System.out.println(linked_bool);

        LinkedListDisordered<Double> linked_double = new LinkedListDisordered<>();
        linked_double.add(3.14);
        linked_double.add(2.71);
        linked_double.add(1.61);
        linked_double.add(1.41);
        System.out.println(linked_double);

        LinkedListDisordered<Float> linked_float = new LinkedListDisordered<>();
        linked_float.add(3.14f);
        linked_float.add(2.71f);
        linked_float.add(1.61f);
        linked_float.add(1.41f);
        System.out.println(linked_float);

        LinkedListDisordered<Long> linked_long = new LinkedListDisordered<>();
        linked_long.add(314L);
        linked_long.add(271L);
        linked_long.add(161L);
        linked_long.add(141L);
        System.out.println(linked_long);

        LinkedListDisordered<LinkedListDisordered<Integer>> linked_linked_int = new LinkedListDisordered<>();
        LinkedListDisordered<Integer> sublist1_1 = new LinkedListDisordered<>();
        sublist1_1.add(1);
        sublist1_1.add(2);
        sublist1_1.add(3);

        LinkedListDisordered<Integer> sublist2_2 = new LinkedListDisordered<>();
        sublist2_2.add(4);
        sublist2_2.add(5);
        sublist2_2.add(6);

        linked_linked_int.add(sublist1_1);
        linked_linked_int.add(sublist2_2);

        System.out.println(linked_linked_int);

        LinkedListDisordered<LinkedListDisordered<String>> linked_linked_string = new LinkedListDisordered<>();
        LinkedListDisordered<String> sublist3 = new LinkedListDisordered<>();
        sublist3.add("Vinícius");
        sublist3.add("Dos");
        sublist3.add("Santos");
        sublist3.add("Andrade");

        LinkedListDisordered<String> sublist4 = new LinkedListDisordered<>();
        sublist4.add("Arthur");
        sublist4.add("Dos");
        sublist4.add("Santos");
        sublist4.add("Andrade");

        linked_linked_string.add(sublist3);
        linked_linked_string.add(sublist4);

        System.out.println(linked_linked_string);

        LinkedListDisordered<LinkedListDisordered<Character>> linked_linked_char = new LinkedListDisordered<>();
        LinkedListDisordered<Character> sublist5 = new LinkedListDisordered<>();
        sublist5.add('V');
        sublist5.add('i');
        sublist5.add('n');
        sublist5.add('í');
        sublist5.add('c');
        sublist5.add('i');
        sublist5.add('u');
        sublist5.add('s');

        LinkedListDisordered<Character> sublist6 = new LinkedListDisordered<>();
        sublist6.add('A');
        sublist6.add('r');
        sublist6.add('t');
        sublist6.add('h');
        sublist6.add('u');
        sublist6.add('r');

        linked_linked_char.add(sublist5);
        linked_linked_char.add(sublist6);

        System.out.println(linked_linked_char);

        LinkedListDisordered<LinkedListDisordered<Boolean>> linked_linked_bool = new LinkedListDisordered<>();
        LinkedListDisordered<Boolean> sublist7 = new LinkedListDisordered<>();
        sublist7.add(true);
        sublist7.add(false);
        sublist7.add(true);
        sublist7.add(false);

        LinkedListDisordered<Boolean> sublist8 = new LinkedListDisordered<>();
        sublist8.add(false);
        sublist8.add(true);
        sublist8.add(false);
        sublist8.add(true);

        linked_linked_bool.add(sublist7);
        linked_linked_bool.add(sublist8);

        System.out.println(linked_linked_bool);

        LinkedListDisordered<LinkedListDisordered<Double>> linked_linked_double = new LinkedListDisordered<>();
        LinkedListDisordered<Double> sublist9 = new LinkedListDisordered<>();
        sublist9.add(3.14);
        sublist9.add(2.71);
        sublist9.add(1.61);
        sublist9.add(1.41);

        LinkedListDisordered<Double> sublist10 = new LinkedListDisordered<>();
        sublist10.add(3.14);
        sublist10.add(2.71);
        sublist10.add(1.61);
        sublist10.add(1.41);

        linked_linked_double.add(sublist9);
        linked_linked_double.add(sublist10);

        System.out.println(linked_linked_double);

        LinkedListDisordered<LinkedListDisordered<Float>> linked_linked_float = new LinkedListDisordered<>();
        LinkedListDisordered<Float> sublist11 = new LinkedListDisordered<>();
        sublist11.add(3.14f);
        sublist11.add(2.71f);
        sublist11.add(1.61f);
        sublist11.add(1.41f);

        LinkedListDisordered<Float> sublist12 = new LinkedListDisordered<>();
        sublist12.add(3.14f);
        sublist12.add(2.71f);
        sublist12.add(1.61f);
        sublist12.add(1.41f);

        linked_linked_float.add(sublist11);
        linked_linked_float.add(sublist12);

        System.out.println(linked_linked_float);

        LinkedListDisordered<LinkedListDisordered<Long>> linked_linked_long = new LinkedListDisordered<>();
        LinkedListDisordered<Long> sublist13 = new LinkedListDisordered<>();
        sublist13.add(314L);
        sublist13.add(271L);
        sublist13.add(161L);
        sublist13.add(141L);

        LinkedListDisordered<Long> sublist14 = new LinkedListDisordered<>();
        sublist14.add(314L);
        sublist14.add(271L);
        sublist14.add(161L);
        sublist14.add(141L);

        linked_linked_long.add(sublist13);
        linked_linked_long.add(sublist14);

        System.out.println(linked_linked_long);
    }
}