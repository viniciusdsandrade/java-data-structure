package LinkedList.Tests.Disordered.DoubleLinkedListCircularDisordered;

import LinkedList.Disordered.DoubleLinkedListCircularDisordered;

public class TestDoubleLinkedListCircularDisordered {
    public static void main(String[] args) {


        DoubleLinkedListCircularDisordered<Integer> numeros = new DoubleLinkedListCircularDisordered<>();
        numeros.addFirst(1);
        numeros.addFirst(2);
        numeros.addFirst(3);
        numeros.addFirst(4);
        numeros.addFirst(5);

        System.out.println("Lista:          " + numeros);
        System.out.println("Lista ordenada: " + numeros);

        DoubleLinkedListCircularDisordered<Character> chars = new DoubleLinkedListCircularDisordered<>();

        chars.addLast('n');
        chars.addLast('i');
        chars.addLast('c');
        chars.addLast('i');
        chars.addLast('u');
        chars.addLast('s');
        //System.out.println(chars);
        chars.addFirst('v');
        System.out.println(chars);
        chars.addAt('i', 1);
        System.out.println(chars);

        chars.rotate(3);
        System.out.println("rotate(3):  " + chars);

        chars.rotate(-3);
        System.out.println("rotate(-3): " + chars);

        chars.reverse();
        System.out.println("reverse():  " + chars);


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
