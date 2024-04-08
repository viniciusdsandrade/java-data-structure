package LinkedList.Tests.Ordered.LinkedListOrdered;

import LinkedList.Ordered.LinkedListOrdered;

public class TestLinkedListOrdered {

    // Método para verificar se a lista é simplesmente encadeada
    public static <X extends Comparable<X>> boolean verificaSimplesmenteEncadeada(LinkedListOrdered<X> lista) {
        // Verifica se a lista está vazia ou contém apenas um elemento
        if (lista.primeiro == null || lista.primeiro.proximo == null) return true;

        // Verifica se há algum nó com mais de uma referência para o próximo nó
        LinkedListOrdered<X>.Node current = lista.primeiro;
        while (current != null) {
            if (countReferencesToNext(current) > 1) return false;
            current = current.proximo;
        }

        return true;
    }

    // Método auxiliar para contar as referências para o próximo nó de um determinado nó
    private static <X extends Comparable<X>> int countReferencesToNext(LinkedListOrdered<X>.Node node) {
        int count = 0;
        LinkedListOrdered<X>.Node current = node;
        while (current != null) {
            if (current.proximo == node) count++;
            current = current.proximo;
        }
        return count;
    }

    // Método para verificar se a lista está ordenada
    public static <X extends Comparable<X>> boolean verificaOrdenacao(LinkedListOrdered<X> lista) {
        // Verifica se a lista está vazia ou contém apenas um elemento
        if (lista.primeiro == null || lista.primeiro.proximo == null) return true;

        // Percorre a lista e verifica se cada elemento é menor ou igual ao próximo elemento
        LinkedListOrdered<X>.Node current = lista.primeiro;
        while (current.proximo != null) {
            if (current.elemento.compareTo(current.proximo.elemento) > 0) {
                return false;
            }
            current = current.proximo;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        LinkedListOrdered<Integer> int_list = new LinkedListOrdered<>();
        int_list.add(0);
        int_list.add(1);
        int_list.add(2);
        int_list.add(3);
        int_list.add(4);
        int_list.add(5);

        // Verificando se a lista é simplesmente encadeada
        boolean isSinglyLinked = verificaSimplesmenteEncadeada(int_list);
        System.out.println("A lista é simplesmente encadeada: " + isSinglyLinked);

        // Verificando se a lista está ordenada
        boolean isOrdered = verificaOrdenacao(int_list);
        System.out.println("A lista está ordenada: " + isOrdered);

        LinkedListOrdered<Character> char_list = new LinkedListOrdered<>();
        char_list.add('b');
        char_list.add('a');
        char_list.add('d');
        char_list.add('c');
        char_list.add('e');

        LinkedListOrdered<String> str_list = new LinkedListOrdered<>();
        str_list.add("Vinícius");
        str_list.add("Ana");
        str_list.add("Carlos");
        str_list.add("Bruna");
        str_list.add("Eduardo");

        LinkedListOrdered<Double> double_list = new LinkedListOrdered<>();
        double_list.add(2.0);
        double_list.add(1.0);
        double_list.add(4.0);
        double_list.add(3.0);
        double_list.add(5.0);

        LinkedListOrdered<Float> float_list = new LinkedListOrdered<>();
        float_list.add(2.0f);
        float_list.add(1.0f);
        float_list.add(4.0f);
        float_list.add(3.0f);
        float_list.add(5.0f);

        LinkedListOrdered<Long> long_list = new LinkedListOrdered<>();
        long_list.add(2L);
        long_list.add(1L);
        long_list.add(4L);
        long_list.add(3L);
        long_list.add(5L);

        LinkedListOrdered<Short> short_list = new LinkedListOrdered<>();
        short_list.add((short) 2);
        short_list.add((short) 1);
        short_list.add((short) 4);
        short_list.add((short) 3);
        short_list.add((short) 5);

        LinkedListOrdered<Byte> byte_list = new LinkedListOrdered<>();
        byte_list.add((byte) 2);
        byte_list.add((byte) 1);
        byte_list.add((byte) 4);
        byte_list.add((byte) 3);
        byte_list.add((byte) 5);

        System.out.println("List:           " + int_list);
        System.out.println("Char List:      " + char_list);
        System.out.println("String List:    " + str_list);
        System.out.println("Double List:    " + double_list);
        System.out.println("Float List:     " + float_list);
        System.out.println("Long List:      " + long_list);
        System.out.println("Short List:     " + short_list);
        System.out.println("Byte List:      " + byte_list);

        System.out.println("int_list:   " + int_list);
        int getFirst = int_list.getFirst();
        int getLast = int_list.getLast();

        System.out.println("Get First:  " + getFirst);
        System.out.println("Get Last:   " + getLast);

        int_list.deleteFirst();
        System.out.println("Delete First: " + int_list);

        int_list.deleteLast();
        System.out.println("Delete Last:  " + int_list);

        int_list.deleteAt(2);
        System.out.println("Delete At(2): " + int_list);

        boolean contains_2 = int_list.contains(2);
        boolean contains_3 = int_list.contains(3);

        System.out.println("Contains 2: " + contains_2);
        System.out.println("Contains 3: " + contains_3);

        int index_2 = int_list.indexOf(2);
        int index_3 = int_list.indexOf(3);

        System.out.println("Index of 2: " + index_2);
        System.out.println("Index of 3: " + index_3);

        boolean isEmpty = int_list.isEmpty();
        int size = int_list.getTamanho();

        System.out.println("Is Empty: " + isEmpty);
        System.out.println("Size: " + size);

        int_list.clear();
        System.out.println("Clear: " + int_list);

        isEmpty = int_list.isEmpty();
        size = int_list.getTamanho();

        System.out.println("Is Empty: " + isEmpty);
        System.out.println("Size: " + size);

        LinkedListOrdered<Integer> int_list2 = new LinkedListOrdered<>();
        System.out.println("int_list2.getTamanho(): " + int_list2.getTamanho());
        int_list2.add(1);
        System.out.println("int_list2.getTamanho(): " + int_list2.getTamanho());
        int_list2.add(2);
        System.out.println("int_list2.getTamanho(): " + int_list2.getTamanho());
        int_list2.deleteAt(0);
        System.out.println("int_list2.getTamanho(): " + int_list2.getTamanho());
        int_list2.deleteAt(0);
        System.out.println("int_list2.getTamanho(): " + int_list2.getTamanho());
    }
}
