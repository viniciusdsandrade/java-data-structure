package LinkedList.Tests.Ordered.LinkedListOrdered;

import LinkedList.Ordered.LinkedListOrdered;

public class TestToString {
    public static void main(String[] args) {
        LinkedListOrdered<Integer> list_integer = new LinkedListOrdered<>();
        LinkedListOrdered<String> list_string = new LinkedListOrdered<>();
        LinkedListOrdered<Double> list_double = new LinkedListOrdered<>();
        LinkedListOrdered<Character> list_char = new LinkedListOrdered<>();
        LinkedListOrdered<Boolean> list_boolean = new LinkedListOrdered<>();

        list_integer.add(1);
        list_integer.add(2);
        list_integer.add(3);
        list_integer.add(4);
        list_integer.add(5);
        
        list_string.add("Vinícius");
        list_string.add("Dos");
        list_string.add("Santos");
        list_string.add("Andrade");
        
        list_double.add(1.0);
        list_double.add(2.0);
        list_double.add(3.0);
        list_double.add(4.0);
        list_double.add(5.0);
        
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
        
        System.out.println("Integer:        " + list_integer);
        System.out.println("String:         " + list_string);
        System.out.println("Double:         " + list_double);
        System.out.println("Character:      " + list_char);
        System.out.println("Boolean:        " + list_boolean);
    }
}
