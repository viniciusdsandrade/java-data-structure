package LinkedList.Tests.Disordered.DoubleLinkedListCircularDisordered;

import LinkedList.Disordered.DoubleLinkedListCircularDisordered;

public class TestDoubleLinkedListCircularDisordered {
    public static void main(String[] args) {
        DoubleLinkedListCircularDisordered<Integer> list = new DoubleLinkedListCircularDisordered<>();

        // Adicionando elementos
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        // Imprimindo a lista
        System.out.println("Lista: " + list);

        // Verificando se é circular
        if (list.getPrimeiro().anterior == list.getUltimo() && list.getUltimo().proximo == list.getPrimeiro())
            System.out.println("A lista é circular.");
        else
            System.out.println("A lista não é circular.");

        // Verificando se é duplamente ligada
        boolean isDoublyLinked = true;
        DoubleLinkedListCircularDisordered<Integer>.Node temp = list.getPrimeiro();
        do {
            if (temp.proximo.anterior != temp || temp.anterior.proximo != temp) {
                isDoublyLinked = false;
                break;
            }
            temp = temp.proximo;
        } while (temp != list.getPrimeiro());

        if (isDoublyLinked) {
            System.out.println("A lista é duplamente ligada.");
        } else {
            System.out.println("A lista não é duplamente ligada.");
        }
    }
}
