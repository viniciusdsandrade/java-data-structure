package LinkedList.Tests.Unordered.DoubleLinkedListUnordered;

import LinkedList.Unordered.DoubleLinkedListUnordered;

import java.util.List;

public class TestToString {
    public static void main(String[] args) {
        DoubleLinkedListUnordered<Integer> list_integer = new DoubleLinkedListUnordered<>();
        DoubleLinkedListUnordered<String> list_string = new DoubleLinkedListUnordered<>();
        DoubleLinkedListUnordered<Double> list_double = new DoubleLinkedListUnordered<>();
        DoubleLinkedListUnordered<Character> list_char = new DoubleLinkedListUnordered<>();
        DoubleLinkedListUnordered<Boolean> list_boolean = new DoubleLinkedListUnordered<>();
        DoubleLinkedListUnordered<List<Integer>> list_list_integer = new DoubleLinkedListUnordered<>();
        DoubleLinkedListUnordered<Object> list_object = new DoubleLinkedListUnordered<>();

        list_integer.addLast(1);
        list_integer.addLast(2);
        list_integer.addLast(3);
        list_integer.addLast(4);
        list_integer.addLast(5);

        list_string.addLast("Vinícius");
        list_string.addLast("Dos");
        list_string.addLast("Santos");
        list_string.addLast("Andrade");

        list_double.addLast(1.0);
        list_double.addLast(2.0);
        list_double.addLast(3.0);
        list_double.addLast(4.0);
        list_double.addLast(5.0);

        list_char.addLast('V');
        list_char.addLast('i');
        list_char.addLast('n');
        list_char.addLast('í');
        list_char.addLast('c');
        list_char.addLast('i');
        list_char.addLast('u');
        list_char.addLast('s');

        list_boolean.addLast(true);
        list_boolean.addLast(false);
        list_boolean.addLast(true);
        list_boolean.addLast(false);

        List<Integer> sub_list_int_1 = List.of(1, 2, 3, 4, 5);
        List<Integer> sub_list_int_2 = List.of(6, 7, 8, 9, 10);

        list_list_integer.addLast(sub_list_int_1);
        list_list_integer.addLast(sub_list_int_2);

        list_object.addLast(1);
        list_object.addLast("Vinícius");
        list_object.addLast(1.0);
        list_object.addLast('V');
        list_object.addLast(true);
        list_object.addLast(list_list_integer);
        list_object.addLast(list_integer);
        list_object.addLast(list_string);
        list_object.addLast(list_double);
        list_object.addLast(list_char);
        list_object.addLast(list_boolean);
        list_object.addLast(list_object);

        System.out.println("List<Integer>:          " + list_integer);
        System.out.println("List<String>:           " + list_string);
        System.out.println("List<Double>:           " + list_double);
        System.out.println("List<Character>:        " + list_char);
        System.out.println("List<Boolean>:          " + list_boolean);
        System.out.println("List<List<Integer>>:    " + list_list_integer);
        System.out.println("List<Object>:           " + list_object);
    }
}
