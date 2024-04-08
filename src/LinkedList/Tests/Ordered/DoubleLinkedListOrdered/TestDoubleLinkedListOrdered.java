package LinkedList.Tests.Ordered.DoubleLinkedListOrdered;

import LinkedList.Ordered.DoubleLinkedListOrdered;

public class TestDoubleLinkedListOrdered {

    // Método para verificar se todos os nós estão corretamente duplamente ligados
    public static <X extends Comparable<X>> boolean verificaDuplamenteLigada(DoubleLinkedListOrdered<X> lista) {
        // Verifica se a lista está vazia
        if (lista.primeiro == null)
            return true; // Uma lista vazia está corretamente duplamente ligada

        // Verifica se a lista contém apenas um elemento
        if (lista.primeiro.proximo == null)
            return lista.primeiro.anterior == null; // Se tiver apenas um elemento, ele deve ser seu próprio anterior

        // Inicializa o nó atual como o primeiro nó da lista
        DoubleLinkedListOrdered<X>.Node atual = lista.primeiro;

        // Percorre todos os nós da lista
        while (atual != null) {
            // Verifica se o próximo nó do nó atual está corretamente ligado
            if (atual.proximo != null && atual.proximo.anterior != atual)
                return false; // O próximo nó não está corretamente ligado

            // Avança para o próximo nó
            atual = atual.proximo;
        }

        // Retorna true se todos os nós estiverem corretamente ligados
        return true;
    }

    // Método para verificar se a lista duplamente ligada está ordenada
    public static <X extends Comparable<X>> boolean verificaOrdenacao(DoubleLinkedListOrdered<X> lista) {
        // Verifica se a lista está vazia ou contém apenas um elemento
        if (lista.primeiro == null || lista.primeiro.proximo == null) return true;

        // Percorre a lista e verifica se cada elemento é menor ou igual ao próximo elemento
        DoubleLinkedListOrdered<X>.Node current = lista.primeiro;
        while (current.proximo != null) {
            if (current.elemento.compareTo(current.proximo.elemento) > 0) {
                return false;
            }
            current = current.proximo;
        }
        return true;
    }

    public static void main(String[] args) {
        DoubleLinkedListOrdered<Integer> int_list = new DoubleLinkedListOrdered<>();
        int_list.add(0);
        int_list.add(1);
        int_list.add(2);
        int_list.add(3);
        int_list.add(4);
        int_list.add(5);

        // Verificação do encadeamento de todos os nós
        boolean isDuplamenteLigada = verificaDuplamenteLigada(int_list);
        System.out.println("Todos os nós duplamente ligados: " + isDuplamenteLigada);

        // Verificação da ordenação da lista
        boolean isOrdered = verificaOrdenacao(int_list);
        System.out.println("A lista está ordenada:           " + isOrdered);

        DoubleLinkedListOrdered<String> string_list = new DoubleLinkedListOrdered<>();
        string_list.add("Eduardo");
        string_list.add("Carlos");
        string_list.add("Barbara");
        string_list.add("Dunga");
        string_list.add("Arthur");

        DoubleLinkedListOrdered<Character> char_list = new DoubleLinkedListOrdered<>();
        char_list.add('E');
        char_list.add('C');
        char_list.add('B');
        char_list.add('D');
        char_list.add('A');

        DoubleLinkedListOrdered<Float> float_list = new DoubleLinkedListOrdered<>();
        float_list.add(5.0f);
        float_list.add(3.0f);
        float_list.add(4.0f);
        float_list.add(1.0f);
        float_list.add(0.0f);
        float_list.add(2.0f);

        DoubleLinkedListOrdered<Double> double_list = new DoubleLinkedListOrdered<>();
        double_list.add(5.0);
        double_list.add(3.0);
        double_list.add(4.0);
        double_list.add(1.0);
        double_list.add(0.0);
        double_list.add(2.0);

        DoubleLinkedListOrdered<Long> long_list = new DoubleLinkedListOrdered<>();
        long_list.add(5L);
        long_list.add(3L);
        long_list.add(4L);
        long_list.add(1L);
        long_list.add(0L);
        long_list.add(2L);

        DoubleLinkedListOrdered<Short> short_list = new DoubleLinkedListOrdered<>();
        short_list.add((short) 5);
        short_list.add((short) 3);
        short_list.add((short) 4);
        short_list.add((short) 1);
        short_list.add((short) 0);
        short_list.add((short) 2);

        DoubleLinkedListOrdered<Byte> byte_list = new DoubleLinkedListOrdered<>();
        byte_list.add((byte) 5);
        byte_list.add((byte) 3);
        byte_list.add((byte) 4);
        byte_list.add((byte) 1);
        byte_list.add((byte) 0);
        byte_list.add((byte) 2);

        DoubleLinkedListOrdered<Boolean> bool_list = new DoubleLinkedListOrdered<>();
        bool_list.add(true);
        bool_list.add(false);
        bool_list.add(true);
        bool_list.add(false);
        bool_list.add(true);
        bool_list.add(false);

        System.out.println("List_int:    " + int_list);
        System.out.println("List_string: " + string_list);
        System.out.println("List_char:   " + char_list);
        System.out.println("List_float:  " + float_list);
        System.out.println("List_double: " + double_list);
        System.out.println("List_long:   " + long_list);
        System.out.println("List_short:  " + short_list);
        System.out.println("List_byte:   " + byte_list);
        System.out.println("List_bool:   " + bool_list);

        int first_int = int_list.getFirst();
        int last_int = int_list.getLast();

        System.out.println("int_list:  " + int_list);
        System.out.println("First_int: " + first_int);
        System.out.println("Last_int:  " + last_int);
        
        int get_two = int_list.get(2);
        int get_three = int_list.get(3);
        
        System.out.println("int_list:           " + int_list);
        System.out.println("int_list.get(2):    " + get_two);
        System.out.println("int_list.get(3):    " + get_three);

        int_list.removeFirst();
        System.out.println("int_list.removeFirst() " + int_list);
        
        int_list.removeLast();
        System.out.println("int_list.removeLast()  " + int_list);
        
        int_list.removeAt(1);
        System.out.println("int_list.removeAt(1)   " + int_list);
        
        boolean contains_0 = int_list.contains(0);
        boolean contains_3 = int_list.contains(3);
        boolean contains_4 = int_list.contains(4);
        
        System.out.println("int_list:           " + int_list);
        System.out.println("int_list.contains(0): " + contains_3);
        System.out.println("int_list.contains(3): " + contains_3);
        System.out.println("int_list.contains(4): " + contains_4);
        
        int index_0 = int_list.indexOf(0);
        int index_3 = int_list.indexOf(3);
        int index_4 = int_list.indexOf(4);
        
        System.out.println("int_list:           " + int_list);
        System.out.println("int_list.indexOf(0): " + index_0);
        System.out.println("int_list.indexOf(3): " + index_3);
        System.out.println("int_list.indexOf(4): " + index_4);
        
        boolean is_empty = int_list.isEmpty();
        int size = int_list.getTamanho();
        System.out.println("int_list.isEmpty(): " + is_empty);
        System.out.println("int_list.size():    " + size);
        
        int_list.clear();
        System.out.println("int_list.clear():    " + int_list);
        
        is_empty = int_list.isEmpty();
        size = int_list.getTamanho();
        System.out.println("int_list.isEmpty(): " + is_empty);
        System.out.println("int_list.size():    " + size);

        DoubleLinkedListOrdered<Integer> int_list2 = new DoubleLinkedListOrdered<>();
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
