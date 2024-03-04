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
    }
}