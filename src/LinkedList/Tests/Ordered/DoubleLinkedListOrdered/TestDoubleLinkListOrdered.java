package LinkedList.Tests.Ordered.DoubleLinkedListOrdered;

import LinkedList.Ordered.DoubleLinkedListOrdered;

public class TestDoubleLinkListOrdered {

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
        while (current != null && current.proximo != null) {
            if (current.elemento.compareTo(current.proximo.elemento) > 0) {
                return false;
            }
            current = current.proximo;
        }
        return true;
    }

    public static void main(String[] args) {
        DoubleLinkedListOrdered<Integer> int_list = new DoubleLinkedListOrdered<>();
        int_list.add(5);
        int_list.add(3);
        int_list.add(4);
        int_list.add(0);
        int_list.add(1);
        int_list.add(2);
        System.out.println("List1: " + int_list);

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
        System.out.println("List2: " + string_list);

        DoubleLinkedListOrdered<Character> char_list = new DoubleLinkedListOrdered<>();
        char_list.add('E');
        char_list.add('C');
        char_list.add('B');
        char_list.add('D');
        char_list.add('A');
        System.out.println("List3: " + char_list);

        DoubleLinkedListOrdered<Float> float_list = new DoubleLinkedListOrdered<>();
        float_list.add(5.0f);
        float_list.add(3.0f);
        float_list.add(4.0f);
        float_list.add(1.0f);
        float_list.add(0.0f);
        float_list.add(2.0f);
        System.out.println("List4: " + float_list);

        DoubleLinkedListOrdered<Double> double_list = new DoubleLinkedListOrdered<>();
        double_list.add(5.0);
        double_list.add(3.0);
        double_list.add(4.0);
        double_list.add(1.0);
        double_list.add(0.0);
        double_list.add(2.0);
        System.out.println("List5: " + double_list);

        DoubleLinkedListOrdered<Long> long_list = new DoubleLinkedListOrdered<>();
        long_list.add(5L);
        long_list.add(3L);
        long_list.add(4L);
        long_list.add(1L);
        long_list.add(0L);
        long_list.add(2L);
        System.out.println("List6: " + long_list);

        DoubleLinkedListOrdered<Short> short_list = new DoubleLinkedListOrdered<>();
        short_list.add((short) 5);
        short_list.add((short) 3);
        short_list.add((short) 4);
        short_list.add((short) 1);
        short_list.add((short) 0);
        short_list.add((short) 2);
        System.out.println("List7: " + short_list);

        DoubleLinkedListOrdered<Byte> byte_list = new DoubleLinkedListOrdered<>();
        byte_list.add((byte) 5);
        byte_list.add((byte) 3);
        byte_list.add((byte) 4);
        byte_list.add((byte) 1);
        byte_list.add((byte) 0);
        byte_list.add((byte) 2);
        System.out.println("List8: " + byte_list);

        DoubleLinkedListOrdered<Boolean> bool_list = new DoubleLinkedListOrdered<>();
        bool_list.add(true);
        bool_list.add(false);
        bool_list.add(true);
        bool_list.add(false);
        bool_list.add(true);
        bool_list.add(false);
        System.out.println("List9: " + bool_list);
    }
}
