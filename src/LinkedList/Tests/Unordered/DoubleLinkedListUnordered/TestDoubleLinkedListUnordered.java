package LinkedList.Tests.Unordered.DoubleLinkedListUnordered;

import LinkedList.Unordered.DoubleLinkedListUnordered;

public class TestDoubleLinkedListUnordered {

    // Método para verificar se a lista está duplamente ligada
    public static <X> boolean verificaDuplamenteLigada(DoubleLinkedListUnordered<X> lista) {
        // Se a lista estiver vazia ou tiver apenas um elemento, ela é considerada duplamente ligada
        if (lista.primeiro == null || lista.tamanho <= 1) return true;

        // Começamos a verificação a partir do primeiro nó
        DoubleLinkedListUnordered<X>.Node temp = lista.primeiro;

        // Percorremos a lista até o último nó
        while (temp.proximo != null) {
            // Se o nó anterior ao próximo não for o nó atual, a lista não está duplamente ligada
            if (temp.proximo.anterior != temp) return false;

            // Avançamos para o próximo nó
            temp = temp.proximo;
        }

        // Se chegamos ao final da lista sem encontrar problemas, a lista está duplamente ligada
        return true;
    }

    // Método para verificar se a lista é circular
    public static <X> boolean verificaCircular(DoubleLinkedListUnordered<X> lista) {
        // Se a lista estiver vazia, ela não é circular
        if (lista.primeiro == null) return false;

        // Começamos a verificação a partir do primeiro nó
        DoubleLinkedListUnordered<X>.Node temp = lista.primeiro;

        // Percorremos a lista até o último nó
        while (temp.proximo != null) {
            // Avançamos para o próximo nó
            temp = temp.proximo;

            // Se o próximo nó for o primeiro, a lista é circular
            if (temp == lista.primeiro) return true;
        }

        // Se chegamos ao final da lista sem encontrar o primeiro nó novamente, a lista não é circular
        return false;
    }

    public static void main(String[] args) {
        DoubleLinkedListUnordered<Integer> int_list = new DoubleLinkedListUnordered<>();
        int_list.addLast(1);
        int_list.addLast(2);
        int_list.addLast(3);
        int_list.addLast(4);
        int_list.addLast(5);

        // Teste 1: Verificar se a lista está corretamente ligada
        boolean isDuplamenteLigada = verificaDuplamenteLigada(int_list);
        System.out.println("A lista é duplamente ligada: " + isDuplamenteLigada);

        // Teste 2: Verificar se a lista é circular
        boolean isCircular = verificaCircular(int_list);
        System.out.println("A lista é circular:          " + isCircular);

        // Teste 3: Verificar se os elementos estão corretamente ligados
        System.out.println("int_list:                                 " + int_list);
        System.out.println("Primeiro elemento:                        " + int_list.primeiro.elemento); // Deve imprimir 1
        System.out.println("proximo do primeiro elemento:             " + int_list.primeiro.proximo.elemento); // Deve imprimir 2
        System.out.println("proximo do anterior do primeiro elemento: " + int_list.primeiro.proximo.anterior.elemento); // Deve imprimir 1
        System.out.println("Próximo do proximo do primeiro elemento:  " + int_list.primeiro.proximo.proximo); // Deve imprimir null
        System.out.println("Anterior do primeiro elemento:            " + int_list.primeiro.anterior); // Deve imprimir null

        // Adicionando um elemento no início da lista
        System.out.println("int_list:                   " + int_list);
        int_list.addFirst(0);
        System.out.println("int_list.addFirst(0):       " + int_list);

        // Adicionando um elemento no final da lista
        int_list.addLast(6);
        System.out.println("int_list.addFirst(6):       " + int_list);

        // Adicionando um 3 no indice 2(3 posicao)
        int_list.addAt(3, 2);
        System.out.println("int_list.addAt(3, 2):       " + int_list);

        int_list.removeFirst();
        System.out.println("int_list.removeFirst():     " + int_list);

        int_list.removeLast();
        System.out.println("int_list.removeLast():      " + int_list);

        int_list.removeAt(2);
        System.out.println("int_list.removeAt(2):       " + int_list);

        int getFirst = int_list.getFirst();
        System.out.println("int_list.getFirst():        " + getFirst);

        int getLast = int_list.getLast();
        System.out.println("int_list.getLast():         " + getLast);

        int getAt = int_list.get(2);
        System.out.println("int_list.get(2):            " + getAt);

        System.out.println("int_list:                   " + int_list);
        boolean containsThree = int_list.contains(3);
        System.out.println("int_list.contains(3):       " + containsThree);

        int indexOfThree = int_list.indexOf(3);
        System.out.println("int_list.indexOf(3):        " + indexOfThree);

        boolean isEmpty = int_list.isEmpty();
        System.out.println("int_list.isEmpty():         " + isEmpty);

        int_list.clear();
        System.out.println("int_list.clear():           " + int_list);

        boolean isEmptyAfterClear = int_list.isEmpty();
        System.out.println("int_list.isEmpty() após clear: " + isEmptyAfterClear);

        DoubleLinkedListUnordered<Integer> int_list2 = new DoubleLinkedListUnordered<>();
        System.out.println("int_list2.getTamanho(): " + int_list2.getTamanho());
        int_list2.addLast(1);
        System.out.println("int_list2.getTamanho(): " + int_list2.getTamanho());
        int_list2.addLast(2);
        System.out.println("int_list2.getTamanho(): " + int_list2.getTamanho());
        int_list2.removeAt(0);
        System.out.println("int_list2.getTamanho(): " + int_list2.getTamanho());
        int_list2.removeAt(0);
        System.out.println("int_list2.getTamanho(): " + int_list2.getTamanho());
    }
}