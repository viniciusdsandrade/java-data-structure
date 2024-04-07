package LinkedList.Tests.Ordered.LinkedListCircularOrdered;

import LinkedList.Ordered.LinkedListCircularOrdered;

public class TestLinkedListCircularOrdered {

    // Método para verificar se a lista é circular
    public static <X extends Comparable<X>> boolean verificaCircularidade(LinkedListCircularOrdered<X> lista) {
        // Verifica se a lista está vazia
        if (lista.primeiro == null || lista.ultimo == null) return false;

        // Verifica se o último nó aponta corretamente para o primeiro nó
        return lista.ultimo.proximo == lista.primeiro;
    }

    // Método para verificar se a lista circular está ordenada
    public static <X extends Comparable<X>> boolean verificaOrdenacao(LinkedListCircularOrdered<X> lista) {
        // Verifica se a lista é circular
        if (!verificaCircularidade(lista)) return false;

        // Verifica se a lista está vazia ou contém apenas um elemento
        if (lista.primeiro == lista.ultimo) return true;

        // Percorre a lista e verifica se cada elemento é menor ou igual ao próximo elemento
        LinkedListCircularOrdered<X>.Node current = lista.primeiro;
        while (current != lista.ultimo) {
            if (current.elemento.compareTo(current.proximo.elemento) > 0) {
                return false;
            }
            current = current.proximo;
        }
        return true;
    }

    // Método para verificar se a lista é simplesmente encadeada
    public static <X extends Comparable<X>> boolean verificaSimplesmenteEncadeada(LinkedListCircularOrdered<X> lista) {
        // Verifica se a lista está vazia ou contém apenas um nó
        if (lista.primeiro == null || lista.primeiro.proximo == null) return true;

        // Inicia a verificação a partir do primeiro nó
        LinkedListCircularOrdered<X>.Node current = lista.primeiro;

        // Percorre a lista até encontrar um nó que aponta para o primeiro nó novamente
        while (current.proximo != lista.primeiro) {
            // Avança para o próximo nó
            current = current.proximo;

            // Se encontrarmos um nó que aponta para o primeiro nó novamente, a lista não é simplesmente encadeada
            if (current == lista.primeiro) return false;
        }

        // Se chegamos ao final da lista sem encontrar o primeiro nó novamente, a lista é simplesmente encadeada
        return true;
    }

    public static void main(String[] args) {
        LinkedListCircularOrdered<Integer> int_list = new LinkedListCircularOrdered<>();
        int_list.add(2);
        int_list.add(1);
        int_list.add(4);
        int_list.add(3);
        int_list.add(5);
        int_list.add(0);

        boolean isCircular = verificaCircularidade(int_list);
        System.out.println("A lista é circular: " + isCircular);

        boolean isOrdered = verificaOrdenacao(int_list);
        System.out.println("A lista é ordenada: " + isOrdered);

        boolean isSinglyLinked = verificaSimplesmenteEncadeada(int_list);
        System.out.println("A lista é simplesmente encadeada: " + isSinglyLinked);

        LinkedListCircularOrdered<Character> char_list = new LinkedListCircularOrdered<>();
        char_list.add('e');
        char_list.add('a');
        char_list.add('d');
        char_list.add('c');
        char_list.add('b');

        LinkedListCircularOrdered<String> str_list = new LinkedListCircularOrdered<>();
        str_list.add("Vinícius");
        str_list.add("Arthur");
        str_list.add("Bárbara");
        str_list.add("Carlos");
        str_list.add("Eduardo");

        LinkedListCircularOrdered<Double> double_list = new LinkedListCircularOrdered<>();
        double_list.add(2.0);
        double_list.add(1.0);
        double_list.add(4.0);
        double_list.add(3.0);
        double_list.add(5.0);
        double_list.add(0.0);

        LinkedListCircularOrdered<Float> float_list = new LinkedListCircularOrdered<>();
        float_list.add(2.0f);
        float_list.add(1.0f);
        float_list.add(4.0f);
        float_list.add(3.0f);
        float_list.add(5.0f);
        float_list.add(0.0f);

        LinkedListCircularOrdered<Long> long_list = new LinkedListCircularOrdered<>();
        long_list.add(2L);
        long_list.add(1L);
        long_list.add(4L);
        long_list.add(3L);
        long_list.add(5L);
        long_list.add(0L);

        LinkedListCircularOrdered<Short> short_list = new LinkedListCircularOrdered<>();
        short_list.add((short) 2);
        short_list.add((short) 1);
        short_list.add((short) 4);
        short_list.add((short) 3);
        short_list.add((short) 5);
        short_list.add((short) 0);

        LinkedListCircularOrdered<Byte> byte_list = new LinkedListCircularOrdered<>();
        byte_list.add((byte) 2);
        byte_list.add((byte) 1);
        byte_list.add((byte) 4);
        byte_list.add((byte) 3);
        byte_list.add((byte) 5);
        byte_list.add((byte) 0);

        System.out.println("int_list:       " + int_list);
        System.out.println("char_list:      " + char_list);
        System.out.println("str_list:       " + str_list);
        System.out.println("double_list:    " + double_list);
        System.out.println("float_list:     " + float_list);
        System.out.println("long_list:      " + long_list);
        System.out.println("short_list:     " + short_list);
        System.out.println("byte_list:      " + byte_list);

        int primeiro = int_list.primeiro.elemento;
        int ultimo = int_list.ultimo.elemento;

        int proximoDoPrimeiro = int_list.primeiro.proximo.elemento;
        int proximoDoUltimo = int_list.ultimo.proximo.elemento;

        int proximoDoProximoDoPrimeiro = int_list.primeiro.proximo.proximo.elemento;
        int proximoDoProximoDoUltimo = int_list.ultimo.proximo.proximo.elemento;

        int proximoDoProximoDoProximoDoPrimeiro = int_list.primeiro.proximo.proximo.proximo.elemento;
        int proximoDoProximoDoProximoDoUltimo = int_list.ultimo.proximo.proximo.proximo.elemento;

        System.out.println("int_list:       " + int_list);
        System.out.println("primeiro: " + primeiro);
        System.out.println("ultimo: " + ultimo);
        System.out.println("proximoDoPrimeiro: " + proximoDoPrimeiro);
        System.out.println("proximoDoUltimo:  " + proximoDoUltimo);
        System.out.println("proximoDoProximoDoPrimeiro: " + proximoDoProximoDoPrimeiro);
        System.out.println("proximoDoProximoDoUltimo:  " + proximoDoProximoDoUltimo);
        System.out.println("proximoDoProximoDoProximoDoPrimeiro: " + proximoDoProximoDoProximoDoPrimeiro);
        System.out.println("proximoDoProximoDoProximoDoUltimo:  " + proximoDoProximoDoProximoDoUltimo);

        System.out.println("int_list:       " + int_list);
        
        int getFirst = int_list.primeiro.elemento;
        int getLast = int_list.ultimo.elemento;
        
        System.out.println("int_list:   " + int_list);
        System.out.println("getFirst:   " + getFirst);
        System.out.println("getLast:    " + getLast);
        
        int_list.removeFirst();
        System.out.println("int_list.removeFirst(): " + int_list);
        
        int_list.removeLast();
        System.out.println("int_list.removeLast():  " + int_list);
        
        int_list.removeAt(2);
        System.out.println("int_list.removeAt(2):   " + int_list);
        
        boolean contais_2 = int_list.contains(2);
        boolean contais_3 = int_list.contains(3);
        
        System.out.println("int_list.contains(2): " + contais_2);
        System.out.println("int_list.contains(3): " + contais_3);
        
        int index_2 = int_list.indexOf(2);
        int index_3 = int_list.indexOf(3);
        
        System.out.println("int_list.indexOf(2): " + index_2);
        System.out.println("int_list.indexOf(3): " + index_3);

        System.out.println("int_list:       " + int_list);
        boolean isEmpty = int_list.isEmpty();
        int size = int_list.getTamanho();
        System.out.println("int_list.isEmpty(): " + isEmpty);
        System.out.println("int_list.size():    " + size);
        
        int_list.clear();
        System.out.println("int_list.clear(): " + int_list);
        
        isEmpty = int_list.isEmpty();
        size = int_list.getTamanho();
        
        System.out.println("int_list.isEmpty(): " + isEmpty);
        System.out.println("int_list.size():    " + size);

        LinkedListCircularOrdered<Integer> int_list2 = new LinkedListCircularOrdered<>();
        System.out.println("int_list2.getTamanho(): " + int_list2.getTamanho());
        int_list2.add(1);
        System.out.println("int_list2.getTamanho(): " + int_list2.getTamanho());
        int_list2.add(2);
        System.out.println("int_list2.getTamanho(): " + int_list2.getTamanho());
        int_list2.removeAt(0);
        System.out.println("int_list2.getTamanho(): " + int_list2.getTamanho());
        int_list2.removeAt(0);
        System.out.println("int_list2.getTamanho(): " + int_list2.getTamanho());

    }
}
