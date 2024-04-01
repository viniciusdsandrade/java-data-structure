package LinkedList.Tests.Disordered.DoubleLinkedListDisordered;

import LinkedList.Disordered.DoubleLinkedListDisordered;

public class TestDoubleLinkedListDisordered {

    public static <X> boolean verificaDuplamenteLigada(DoubleLinkedListDisordered<Integer> lista) {
        // Se a lista estiver vazia ou tiver apenas um elemento, ela é considerada duplamente ligada
        if (lista.primeiro == null || lista.tamanho <= 1) return true;

        // Começamos a verificação a partir do primeiro nó
        DoubleLinkedListDisordered<Integer>.Node temp = lista.primeiro;

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

    public static <X> boolean verificaCircular(DoubleLinkedListDisordered<Integer> lista) {
        // Se a lista estiver vazia, ela não é circular
        if (lista.primeiro == null) return false;

        // Começamos a verificação a partir do primeiro nó
        DoubleLinkedListDisordered<Integer>.Node temp = lista.primeiro;

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
        DoubleLinkedListDisordered<Integer> int_list = new DoubleLinkedListDisordered<>();
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
        System.out.println("A lista é circular: " + isCircular);

        // Teste 3: Verificar se os elementos estão corretamente ligados
        System.out.println("int_list:                                 " + int_list);
        System.out.println("Primeiro elemento:                        " + int_list.getPrimeiro().elemento); // Deve imprimir 1
        System.out.println("proximo do primeiro elemento:             " + int_list.getPrimeiro().proximo.elemento); // Deve imprimir 2
        System.out.println("proximo do anterior do primeiro elemento: " + int_list.getPrimeiro().proximo.anterior.elemento); // Deve imprimir 1
        System.out.println("Próximo do proximo do primeiro elemento:  " + int_list.getPrimeiro().proximo.proximo); // Deve imprimir null
        System.out.println("Anterior do primeiro elemento:            " + int_list.getPrimeiro().anterior); // Deve imprimir null
    }
}