package LinkedList.Tests.Ordered.DoubleLinkedListCircularOrdered;

import LinkedList.Ordered.DoubleLinkedListCircularOrdered;

public class TestDoubleLinkedListCircularOrdered {

    // Método para verificar se todos os nós estão corretamente duplamente ligados
    public static <X extends Comparable<X>> boolean verificaDuplamenteLigada(DoubleLinkedListCircularOrdered<X> lista) {
        // Verifica se a lista está vazia ou contém apenas um elemento
        if (lista.primeiro == null || lista.primeiro == lista.ultimo) return true;

        // Inicia a verificação a partir do primeiro nó
        DoubleLinkedListCircularOrdered<X>.Node atual = lista.primeiro;

        // Verifica se todos os nós estão corretamente encadeados
        while (atual != lista.ultimo) {
            // Verifica se o próximo nó do nó atual aponta corretamente para o próximo nó
            if (atual.proximo.anterior != atual)
                return false;

            // Avança para o próximo nó
            atual = atual.proximo;
        }

        // Verifica se o nó anterior do primeiro nó aponta corretamente para o último nó
        return lista.primeiro.anterior == lista.ultimo;
    }

    // Método para verificar se a lista é circular
    public static <X extends Comparable<X>> boolean verificaCircularidade(DoubleLinkedListCircularOrdered<X> lista) {
        // Verifica se a lista está vazia
        if (lista.primeiro == null || lista.ultimo == null) return false;

        // Verifica se o nó anterior do primeiro nó aponta corretamente para o último nó
        boolean anteriorDoPrimeiroApontaUltimo = lista.primeiro.anterior == lista.ultimo;

        // Verifica se o próximo nó do último nó aponta corretamente para o primeiro nó
        boolean proximoDoUltimoApontaPrimeiro = lista.ultimo.proximo == lista.primeiro;

        // Retorna verdadeiro se a lista for circular, falso caso contrário
        return anteriorDoPrimeiroApontaUltimo && proximoDoUltimoApontaPrimeiro;
    }

    // Método para verificar se a lista duplamente ligada circular está ordenada
    public static <X extends Comparable<X>> boolean verificaOrdenacao(DoubleLinkedListCircularOrdered<X> lista) {
        // Verifica se a lista está vazia ou contém apenas um elemento
        if (lista.primeiro == null || lista.primeiro.proximo == null) return true;

        // Inicia a verificação a partir do primeiro nó
        DoubleLinkedListCircularOrdered<X>.Node atual = lista.primeiro;

        // Verifica se todos os elementos estão em ordem crescente ou igual
        while (atual != lista.ultimo) {
            if (atual.elemento.compareTo(atual.proximo.elemento) > 0) {
                return false;
            }
            atual = atual.proximo;
        }

        // Se chegou aqui, significa que a lista está ordenada
        return true;
    }

    public static void main(String[] args) {
        DoubleLinkedListCircularOrdered<Integer> int_list = new DoubleLinkedListCircularOrdered<>();
        int_list.add(5);
        int_list.add(3);
        int_list.add(4);
        int_list.add(0);
        int_list.add(1);
        int_list.add(2);
        System.out.println("List: " + int_list);
        
        boolean isDuplamenteLigada = verificaDuplamenteLigada(int_list);
        boolean isCircular = verificaCircularidade(int_list);
        boolean isOrdered = verificaOrdenacao(int_list);

        // Impressão dos resultados
        System.out.println("Todos os nós duplamente ligados: " + isDuplamenteLigada);
        System.out.println("A lista é circular:              " + isCircular);
        System.out.println("A lista está ordenada:           " + isOrdered);

        int primeiro = int_list.primeiro.elemento;
        int ultimo = int_list.ultimo.elemento;

        int proximoDoPrimeiro = int_list.primeiro.proximo.elemento;
        int proximoDoUltimo = int_list.ultimo.proximo.elemento;

        int proximoDoProximoDoPrimeiro = int_list.primeiro.proximo.proximo.elemento;
        int proximoDoProximoDoUltimo = int_list.ultimo.proximo.proximo.elemento;

        int proximoDoProximoDoProximoDoPrimeiro = int_list.primeiro.proximo.proximo.proximo.elemento;
        int proximoDoProximoDoProximoDoUltimo = int_list.ultimo.proximo.proximo.proximo.elemento;

        int anteriorDoPrimeiro = int_list.primeiro.anterior.elemento;
        int anteriorDoUltimo = int_list.ultimo.anterior.elemento;

        int anteriorDoAnteriorDoPrimeiro = int_list.primeiro.anterior.anterior.elemento;
        int anteriorDoAnteriorDoUltimo = int_list.ultimo.anterior.anterior.elemento;

        System.out.println("primeiro: " + primeiro);
        System.out.println("ultimo: " + ultimo);
        System.out.println("proximoDoPrimeiro: " + proximoDoPrimeiro);
        System.out.println("proximoDoUltimo:  " + proximoDoUltimo);
        System.out.println("proximoDoProximoDoPrimeiro: " + proximoDoProximoDoPrimeiro);
        System.out.println("proximoDoProximoDoUltimo:  " + proximoDoProximoDoUltimo);
        System.out.println("proximoDoProximoDoProximoDoPrimeiro: " + proximoDoProximoDoProximoDoPrimeiro);
        System.out.println("proximoDoProximoDoProximoDoUltimo:  " + proximoDoProximoDoProximoDoUltimo);
        System.out.println("anteriorDoPrimeiro: " + anteriorDoPrimeiro);
        System.out.println("anteriorDoUltimo:  " + anteriorDoUltimo);
        System.out.println("anteriorDoAnteriorDoPrimeiro: " + anteriorDoAnteriorDoPrimeiro);
        System.out.println("anteriorDoAnteriorDoUltimo:  " + anteriorDoAnteriorDoUltimo);

        DoubleLinkedListCircularOrdered<String> string_list = new DoubleLinkedListCircularOrdered<>();
        string_list.add("Eduardo");
        string_list.add("Carlos");
        string_list.add("Barbara");
        string_list.add("Dunga");
        string_list.add("Arthur");
        System.out.println("List: " + string_list);

        DoubleLinkedListCircularOrdered<Character> char_list = new DoubleLinkedListCircularOrdered<>();
        char_list.add('E');
        char_list.add('C');
        char_list.add('B');
        char_list.add('D');
        char_list.add('A');
        System.out.println("List: " + char_list);

        DoubleLinkedListCircularOrdered<Float> float_list = new DoubleLinkedListCircularOrdered<>();
        float_list.add(5.0f);
        float_list.add(3.0f);
        float_list.add(4.0f);
        float_list.add(1.0f);
        float_list.add(0.0f);
        float_list.add(2.0f);
        System.out.println("List: " + float_list);

        DoubleLinkedListCircularOrdered<Double> double_list = new DoubleLinkedListCircularOrdered<>();
        double_list.add(5.0);
        double_list.add(3.0);
        double_list.add(4.0);
        double_list.add(1.0);
        double_list.add(0.0);
        double_list.add(2.0);
        System.out.println("List: " + double_list);

        DoubleLinkedListCircularOrdered<Long> long_list = new DoubleLinkedListCircularOrdered<>();
        long_list.add(5L);
        long_list.add(3L);
        long_list.add(4L);
        long_list.add(1L);
        long_list.add(0L);
        long_list.add(2L);
        System.out.println("List: " + long_list);

        DoubleLinkedListCircularOrdered<Short> short_list = new DoubleLinkedListCircularOrdered<>();
        short_list.add((short) 5);
        short_list.add((short) 3);
        short_list.add((short) 4);
        short_list.add((short) 1);
        short_list.add((short) 0);
        short_list.add((short) 2);
        System.out.println("List: " + short_list);

        DoubleLinkedListCircularOrdered<Byte> byte_list = new DoubleLinkedListCircularOrdered<>();
        byte_list.add((byte) 5);
        byte_list.add((byte) 3);
        byte_list.add((byte) 4);
        byte_list.add((byte) 1);
        byte_list.add((byte) 0);
        byte_list.add((byte) 2);
        System.out.println("List: " + byte_list);

        DoubleLinkedListCircularOrdered<Boolean> boolean_list = new DoubleLinkedListCircularOrdered<>();
        boolean_list.add(true);
        boolean_list.add(false);
        boolean_list.add(true);
        boolean_list.add(false);
        boolean_list.add(true);
        boolean_list.add(false);
        System.out.println("List: " + boolean_list);

        System.out.println("list: " + int_list);
        System.out.println("int_list.removeFirst()");
        int_list.removeFirst();
        System.out.println("List: " + int_list);

        System.out.println("int_list.removeLast()");
        int_list.removeLast();
        System.out.println("List: " + int_list);

        boolean isEmpty = int_list.isEmpty();
        System.out.println("int_list.isEmpty(): " + isEmpty);

        int size = int_list.getTamanho();
        System.out.println("int_list.getTamanho(): " + size);

        System.out.println("int_list.remove(2)");
        int_list.removeAt(2);
        System.out.println("List: " + int_list);

        System.out.println("int_list.getFirst(): " + int_list.getFirst());
        System.out.println("int_list.getLast(): " + int_list.getLast());
        System.out.println("int_list.get(1): " + int_list.get(1));

        System.out.println("int_list.contains(2): " + int_list.contains(2));
        System.out.println("int_list.contains(10): " + int_list.contains(10));

        System.out.println("int_list.indexOf(2): " + int_list.indexOf(2));
        System.out.println("int_list.indexOf(10): " + int_list.indexOf(10));

        System.out.println("int_list" + int_list);
        System.out.println("int_list.getTamanho(): " + int_list.getTamanho());
        
        System.out.println("int_list.clear()");
        int_list.clear();
        System.out.println("List: " + int_list);

        isEmpty = int_list.isEmpty();
        size = int_list.getTamanho();

        System.out.println("int_list.isEmpty(): " + isEmpty);
        System.out.println("int_list.getTamanho(): " + size);

        DoubleLinkedListCircularOrdered<Integer> int_list2 = new DoubleLinkedListCircularOrdered<>();
        System.out.println("int_list2.size(): " + int_list2.getTamanho());
        int_list2.add(5);
        System.out.println("int_list2.size(): " + int_list2.getTamanho());
        int_list2.add(3);
        System.out.println("int_list2.size(): " + int_list2.getTamanho());
        int_list2.removeAt(0);
        System.out.println("int_list2.size(): " + int_list2.getTamanho());
        int_list2.removeAt(0);
        System.out.println("int_list2.size(): " + int_list2.getTamanho());
        int_list2.removeAt(0);
        System.out.println("int_list2.size(): " + int_list2.getTamanho());
    }
}

