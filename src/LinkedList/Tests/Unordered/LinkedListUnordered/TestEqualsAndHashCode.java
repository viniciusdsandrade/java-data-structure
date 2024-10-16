package LinkedList.Tests.Unordered.LinkedListUnordered;

import LinkedList.Unordered.LinkedListUnordered;

import java.util.ArrayList;
import java.util.List;

public class TestEqualsAndHashCode {
    public static void main(String[] args) {


        LinkedListUnordered<Integer> list_int1 = new LinkedListUnordered<>();
        LinkedListUnordered<Integer> list_int2 = new LinkedListUnordered<>();

        list_int1.addLast(1);
        list_int1.addLast(2);
        list_int1.addLast(3);
        list_int1.addLast(4);
        list_int1.addLast(5);

        list_int2.addFirst(1);
        list_int2.addFirst(2);
        list_int2.addFirst(3);
        list_int2.addFirst(4);
        list_int2.addFirst(5);

        System.out.println("list_int1:  " + list_int1);
        System.out.println("list_int2:  " + list_int2);

        System.out.println("list_int1.hashCode():  " + list_int1.hashCode());
        System.out.println("list_int2.hashCode():  " + list_int2.hashCode());

        System.out.println("list_int1.equals(list_int2):  " + list_int1.equals(list_int2));

        LinkedListUnordered<Character> list_char1 = new LinkedListUnordered<>();
        LinkedListUnordered<String> list_string1 = new LinkedListUnordered<>();
        list_char1.addLast('V');
        list_char1.addLast('i');
        list_char1.addLast('n');
        list_char1.addLast('í');
        list_char1.addLast('c');
        list_char1.addLast('i');
        list_char1.addLast('u');
        list_char1.addLast('s');

        list_string1.addLast("V");
        list_string1.addLast("i");
        list_string1.addLast("n");
        list_string1.addLast("í");
        list_string1.addLast("c");
        list_string1.addLast("i");
        list_string1.addLast("u");
        list_string1.addLast("s");

        System.out.println("list_char1:    " + list_char1);
        System.out.println("list_string1:  " + list_string1);

        System.out.println("list_char1.hashCode():     " + list_char1.hashCode());
        System.out.println("list_string1.hashCode():   " + list_string1.hashCode());

        LinkedListUnordered<Byte> list_byte = new LinkedListUnordered<>();
        LinkedListUnordered<Short> list_short = new LinkedListUnordered<>();
        LinkedListUnordered<Integer> list_integer = new LinkedListUnordered<>();
        LinkedListUnordered<Long> list_long = new LinkedListUnordered<>();
        list_byte.addLast((byte) 1);
        list_byte.addLast((byte) 2);
        list_byte.addLast((byte) 3);
        list_byte.addLast((byte) 4);
        list_byte.addLast((byte) 5);

        list_short.addLast((short) 1);
        list_short.addLast((short) 2);
        list_short.addLast((short) 3);
        list_short.addLast((short) 4);
        list_short.addLast((short) 5);

        list_integer.addLast(1);
        list_integer.addLast(2);
        list_integer.addLast(3);
        list_integer.addLast(4);
        list_integer.addLast(5);

        list_long.addLast(1L);
        list_long.addLast(2L);
        list_long.addLast(3L);
        list_long.addLast(4L);
        list_long.addLast(5L);

        System.out.println("list_byte:      " + list_byte);
        System.out.println("list_short:     " + list_short);
        System.out.println("list_integer:   " + list_integer);
        System.out.println("list_long:      " + list_long);

        System.out.println("list_byte.hashCode():       " + list_byte.hashCode());
        System.out.println("list_short.hashCode():      " + list_short.hashCode());
        System.out.println("list_integer.hashCode():    " + list_integer.hashCode());
        System.out.println("list_long.hashCode():       " + list_long.hashCode());


        LinkedListUnordered<List<LinkedListUnordered<List<Integer>>>> list1 = new LinkedListUnordered<>();
        LinkedListUnordered<List<LinkedListUnordered<List<Integer>>>> list2 = new LinkedListUnordered<>();

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

        LinkedListUnordered<List<Integer>> listIntList1 = new LinkedListUnordered<>();
        listIntList1.addLast(listInt1);

        LinkedListUnordered<List<Integer>> listIntList2 = new LinkedListUnordered<>();
        listIntList2.addLast(listInt2);

        List<LinkedListUnordered<List<Integer>>> listIntListList1 = new ArrayList<>();
        listIntListList1.add(listIntList1);
        listIntListList1.add(listIntList2);

        List<LinkedListUnordered<List<Integer>>> listIntListList2 = new ArrayList<>();
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