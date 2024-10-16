package LinkedList.Tests.Unordered.LinkedListCircularUnordered;

import LinkedList.Unordered.LinkedListCircularUnordered;

import java.util.LinkedList;
import java.util.List;

public class TestToString {
    public static void main(String[] args) {
        LinkedListCircularUnordered<String> list_string = new LinkedListCircularUnordered<>();
        LinkedListCircularUnordered<Integer> list_int = new LinkedListCircularUnordered<>();
        LinkedListCircularUnordered<Double> list_double = new LinkedListCircularUnordered<>();
        LinkedListCircularUnordered<Character> list_char = new LinkedListCircularUnordered<>();
        LinkedListCircularUnordered<Boolean> list_boolean = new LinkedListCircularUnordered<>();
        LinkedListCircularUnordered<Float> list_float = new LinkedListCircularUnordered<>();
        LinkedListCircularUnordered<Long> list_long = new LinkedListCircularUnordered<>();
        LinkedListCircularUnordered<Short> list_short = new LinkedListCircularUnordered<>();

        list_string.addLast("Vinícius");
        list_string.addLast("Dos");
        list_string.addLast("Santos");
        list_string.addLast("Andrade");

        list_int.addLast(1);
        list_int.addLast(2);
        list_int.addLast(3);
        list_int.addLast(4);
        list_int.addLast(5);

        list_double.addLast(1.1);
        list_double.addLast(2.2);
        list_double.addLast(3.3);
        list_double.addLast(4.4);
        list_double.addLast(5.5);

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

        list_float.addLast(1.1f);
        list_float.addLast(2.2f);
        list_float.addLast(3.3f);
        list_float.addLast(4.4f);
        list_float.addLast(5.5f);

        list_long.addLast(1L);
        list_long.addLast(2L);
        list_long.addLast(3L);
        list_long.addLast(4L);
        list_long.addLast(5L);

        list_short.addLast((short) 1);
        list_short.addLast((short) 2);
        list_short.addLast((short) 3);
        list_short.addLast((short) 4);
        list_short.addLast((short) 5);

        System.out.println("LinkedListCircularDisordered<String>:       " + list_string);
        System.out.println("LinkedListCircularDisordered<Integer>:      " + list_int);
        System.out.println("LinkedListCircularDisordered<Double>:       " + list_double);
        System.out.println("LinkedListCircularDisordered<Character>:    " + list_char);
        System.out.println("LinkedListCircularDisordered<Boolean>:      " + list_boolean);
        System.out.println("LinkedListCircularDisordered<Float>:        " + list_float);
        System.out.println("LinkedListCircularDisordered<Long>:         " + list_long);
        System.out.println("LinkedListCircularDisordered<Short>:        " + list_short);

        // Criando as listas
        LinkedListCircularUnordered<LinkedListCircularUnordered<Integer>> list_linked_list_int = new LinkedListCircularUnordered<>();
        LinkedListCircularUnordered<List<LinkedListCircularUnordered<Integer>>> list_list_linked_list_int = new LinkedListCircularUnordered<>();
        LinkedListCircularUnordered<LinkedListCircularUnordered<List<Integer>>> list_linked_list_list_int = new LinkedListCircularUnordered<>();
        LinkedListCircularUnordered<List<List<LinkedListCircularUnordered<List<Integer>>>>> list_list_list_linked_list_list_int = new LinkedListCircularUnordered<>();

        // Criando alguns elementos para inserção
        LinkedListCircularUnordered<Integer> subList1 = new LinkedListCircularUnordered<>();
        LinkedListCircularUnordered<Integer> subList2 = new LinkedListCircularUnordered<>();
        subList1.addLast(1);
        subList1.addLast(2);
        subList2.addLast(3);
        subList2.addLast(4);

        List<LinkedListCircularUnordered<Integer>> list1 = new LinkedList<>();
        list1.add(subList1);
        list1.add(subList2);

        List<Integer> subList3 = new LinkedList<>();
        subList3.add(5);
        subList3.add(6);
        subList3.add(7);

        LinkedListCircularUnordered<List<Integer>> subList4 = new LinkedListCircularUnordered<>();
        subList4.addLast(subList3);

        List<List<LinkedListCircularUnordered<List<Integer>>>> list2 = new LinkedList<>();

        List<Integer> subList5 = List.of(8, 9, 10);
        LinkedListCircularUnordered<List<Integer>> subList6 = new LinkedListCircularUnordered<>();
        subList6.addLast(subList5);
        List<LinkedListCircularUnordered<List<Integer>>> subList7 = new LinkedList<>();
        subList7.add(subList6);
        list2.add(subList7);

        // Inserindo elementos nas listas
        list_linked_list_int.addLast(subList1);
        list_linked_list_int.addLast(subList2);
        list_list_linked_list_int.addLast(list1);
        list_linked_list_list_int.addLast(subList4);
        list_list_list_linked_list_list_int.addLast(list2);

        // Testando o método toString()
        System.out.println("LinkedListCircularDisordered<LinkedListCircularDisordered<Integer>>:                    " + list_linked_list_int);
        System.out.println("LinkedListCircularDisordered<List<LinkedListCircularDisordered<Integer>>>:              " + list_list_linked_list_int);
        System.out.println("LinkedListCircularDisordered<LinkedListCircularDisordered<List<Integer>>>:              " + list_linked_list_list_int);
        System.out.println("LinkedListCircularDisordered<List<List<LinkedListCircularDisordered<List<Integer>>>>>:  " + list_list_list_linked_list_list_int);
    }
}
