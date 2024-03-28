package LinkedList.Tests.Disordered.DoubleLinkedListDisordered;

import LinkedList.Disordered.DoubleLinkedListDisordered;

public class TestDoubleLinkedListDisordered {
    public static void main(String[] args) {
        DoubleLinkedListDisordered<Integer> list = new DoubleLinkedListDisordered<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        // Teste 1: Verificar se a lista é duplamente ligada: cada nó deve ter uma referência para o próximo e para o anterior
        // Exemplo: dado um determinado nó que não seja o último nem o primeiro:
        // o seu anterior do proximo deve ser igual ao proximo do anterior
        // o seu proximo do anterior deve ser igual ao anterior do proximo
        boolean isDoublyLinked = true;
        DoubleLinkedListDisordered<Integer>.Node temp = list.getPrimeiro();
        if (temp != null) {
            do {
                // Verificar se o nó atual é consistente
                if ((temp.anterior == null && temp != list.getPrimeiro()) ||
                        (temp.proximo == null && temp != list.getUltimo()) ||
                        (temp.anterior != null && temp.anterior.proximo != temp) ||
                        (temp.proximo != null && temp.proximo.anterior != temp)) {
                    isDoublyLinked = false;
                    break;
                }
                temp = temp.proximo;
            } while (temp != null);
        } else {
            isDoublyLinked = false;
        }

        if (isDoublyLinked)
            System.out.println("A lista é duplamente ligada.");
        else
            System.out.println("A lista não é duplamente ligada.");

        // Teste 2: Verificar se a lista é circular
        if (list.getUltimo() != null && list.getUltimo().proximo == list.getPrimeiro())
            System.out.println("A lista é circular.");
        else
            System.out.println("A lista não é circular.");

        // Teste 3: Verificar se os elementos estão corretamente ligados
        System.out.println("list:                                     " + list);
        System.out.println("Primeiro elemento:                        " + list.getPrimeiro().elemento); // Deve imprimir 1
        System.out.println("proximo do primeiro elemento:             " + list.getPrimeiro().proximo.elemento); // Deve imprimir 2
        System.out.println("proximo do anterior do primeiro elemento: " + list.getPrimeiro().proximo.anterior.elemento); // Deve imprimir 1
        System.out.println("Próximo do proximo do primeiro elemento:  " + list.getPrimeiro().proximo.proximo); // Deve imprimir null
        System.out.println("Anterior do primeiro elemento:            " + list.getPrimeiro().anterior); // Deve imprimir null
    }
}