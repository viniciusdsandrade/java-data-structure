package LinkedList.Tests.Ordered.DoubleLinkedListCircularOrdered;

import LinkedList.Ordered.DoubleLinkedListCircularOrdered;

public class TestToString {
    public static void main(String[] args) {
        DoubleLinkedListCircularOrdered<String> list_string = new DoubleLinkedListCircularOrdered<>();
        DoubleLinkedListCircularOrdered<Integer> list_int = new DoubleLinkedListCircularOrdered<>();
        DoubleLinkedListCircularOrdered<Double> list_double = new DoubleLinkedListCircularOrdered<>();
        DoubleLinkedListCircularOrdered<Character> list_char = new DoubleLinkedListCircularOrdered<>();
        DoubleLinkedListCircularOrdered<Boolean> list_boolean = new DoubleLinkedListCircularOrdered<>();
        DoubleLinkedListCircularOrdered<Float> list_float = new DoubleLinkedListCircularOrdered<>();
        DoubleLinkedListCircularOrdered<Long> list_long = new DoubleLinkedListCircularOrdered<>();
        DoubleLinkedListCircularOrdered<Short> list_short = new DoubleLinkedListCircularOrdered<>();
        list_string.add("Vinícius");
        list_string.add("Dos");
        list_string.add("Andrade");
        list_string.add("Santos");
        
        list_int.add(1);
        list_int.add(2);
        list_int.add(3);
        list_int.add(4);
        list_int.add(5);
        
        list_double.add(1.1);
        list_double.add(2.2);
        list_double.add(3.3);
        list_double.add(4.4);
        list_double.add(5.5);
        
        list_char.add('V');
        list_char.add('i');
        list_char.add('n');
        list_char.add('í');
        list_char.add('c');
        list_char.add('i');
        list_char.add('u');
        list_char.add('s');
        
        list_boolean.add(true);
        list_boolean.add(false);
        list_boolean.add(true);
        list_boolean.add(false);
            
        list_float.add(1.1f);
        list_float.add(2.2f);
        list_float.add(3.3f);
        list_float.add(4.4f);
        list_float.add(5.5f);
        
        list_long.add(1L);
        list_long.add(2L);
        list_long.add(3L);
        list_long.add(4L);
        list_long.add(5L);
        
        list_short.add((short) 1);
        list_short.add((short) 2);
        list_short.add((short) 3);
        list_short.add((short) 4);
        list_short.add((short) 5);
        
        System.out.println("String:     " + list_string);
        System.out.println("Integer:    " + list_int);
        System.out.println("Double:     " + list_double);
        System.out.println("Character:  " + list_char);
        System.out.println("Boolean:    " + list_boolean);
        System.out.println("Float:      " + list_float);
        System.out.println("Long:       " + list_long);
        System.out.println("Short:      " + list_short);
    }
}
