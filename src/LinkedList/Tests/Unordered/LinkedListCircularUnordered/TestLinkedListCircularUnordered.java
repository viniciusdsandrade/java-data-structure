package LinkedList.Tests.Unordered.LinkedListCircularUnordered;

import LinkedList.Unordered.LinkedListCircularUnordered;

public class TestLinkedListCircularUnordered {

    // Método para verificar se a lista é circular
    public static <X> boolean verificaCircular(LinkedListCircularUnordered<X> lista) {
        // Se a lista estiver vazia, ela não é circular
        if (lista.primeiro == null) return false;

        // Começamos a verificação a partir do primeiro nó
        LinkedListCircularUnordered<X>.Node temp = lista.primeiro;

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

    // Método para verificar se a lista circular está ordenada
    public static <X> boolean verificaSimplesmenteEncadeada(LinkedListCircularUnordered<X> lista) {
        // Se a lista estiver vazia ou contiver apenas um nó, ela é simplesmente encadeada
        if (lista.primeiro == null || lista.primeiro.proximo == null) return true;

        // Inicia a verificação a partir do primeiro nó
        LinkedListCircularUnordered<X>.Node current = lista.primeiro;

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
        LinkedListCircularUnordered<Integer> int_list = new LinkedListCircularUnordered<>();
        int_list.addLast(1);
        int_list.addLast(2);
        int_list.addLast(3);

        // Verificando se a lista é circular
        boolean isCircular = verificaCircular(int_list);
        System.out.println("A lista é circular:               " + isCircular);

        // Verificando se a lista é simplesmente encadeada
        boolean isSimplesmenteEncadeada = verificaSimplesmenteEncadeada(int_list);
        System.out.println("A lista é simplesmente encadeada: " + isSimplesmenteEncadeada);

        int primeiro = int_list.primeiro.elemento;
        int ultimo = int_list.ultimo.elemento;

        int proximoDoPrimeiro = int_list.primeiro.proximo.elemento;
        int proximoDoUltimo = int_list.ultimo.proximo.elemento;

        int proximoDoProximoDoPrimeiro = int_list.primeiro.proximo.proximo.elemento;
        int proximoDoProximoDoUltimo = int_list.ultimo.proximo.proximo.elemento;

        int proximoDoProximoDoProximoDoPrimeiro = int_list.primeiro.proximo.proximo.proximo.elemento;
        int proximoDoProximoDoProximoDoUltimo = int_list.ultimo.proximo.proximo.proximo.elemento;

        System.out.println("Lista:    " + int_list);
        System.out.println("primeiro: " + primeiro);
        System.out.println("ultimo:   " + ultimo);
        System.out.println("proximoDoPrimeiro: " + proximoDoPrimeiro);
        System.out.println("proximoDoUltimo:   " + proximoDoUltimo);
        System.out.println("proximoDoProximoDoPrimeiro: " + proximoDoProximoDoPrimeiro);
        System.out.println("proximoDoProximoDoUltimo:   " + proximoDoProximoDoUltimo);
        System.out.println("proximoDoProximoDoProximoDoPrimeiro: " + proximoDoProximoDoProximoDoPrimeiro);
        System.out.println("proximoDoProximoDoProximoDoUltimo:   " + proximoDoProximoDoProximoDoUltimo);

        int_list.addFirst(0);
        System.out.println("int_list.addFirst(0): " + int_list);

        int_list.addLast(4);
        System.out.println("int_list.addLast(4):  " + int_list);

        int_list.addAt(2, 2);
        System.out.println("int_list.addAt(2, 2): " + int_list);

        int_list.removeFirst();
        System.out.println("int_list.removeFirst(): " + int_list);

        int_list.removeLast();
        System.out.println("int_list.removeLast():  " + int_list);

        int_list.removeAt(2);
        System.out.println("int_list.removeAt(2):   " + int_list);

        int getFirst = int_list.getFirst();
        int getLast = int_list.getLast();
        int getAtTwo = int_list.get(1);

        System.out.println("int_list.getFirst(): " + getFirst);
        System.out.println("int_list.getLast():  " + getLast);
        System.out.println("int_list.get(1):     " + getAtTwo);

        boolean containsTwo = int_list.contains(2);
        boolean containsFive = int_list.contains(5);

        System.out.println("int_list.contains(2): " + containsTwo);
        System.out.println("int_list.contains(5): " + containsFive);

        int indexOfTwo = int_list.indexOf(2);
        int indexOfFive = int_list.indexOf(5);

        System.out.println("int_list.indexOf(2): " + indexOfTwo);
        System.out.println("int_list.indexOf(5): " + indexOfFive);

        boolean isEmpty = int_list.isEmpty();
        int size = int_list.getTamanho();
        System.out.println("int_list.isEmpty(): " + isEmpty);
        System.out.println("int_list.getTamanho(): " + size);

        int_list.rotate(0);
        System.out.println("int_list.rotate(0): " + int_list);

        int_list.rotate(1);
        System.out.println("int_list.rotate(1): " + int_list);

        int_list.rotate(1);
        System.out.println("int_list.rotate(1): " + int_list);

        int_list.rotate(1);
        System.out.println("int_list.rotate(1): " + int_list);

        int_list.rotate(3);
        System.out.println("int_list.rotate(3): " + int_list);

        int_list.clear();
        System.out.println("int_list.clear(): " + int_list);

        isEmpty = int_list.isEmpty();
        size = int_list.getTamanho();
        System.out.println("int_list.isEmpty() após clear: " + isEmpty);
        System.out.println("int_list.getTamanho() após clear: " + size);

        LinkedListCircularUnordered<Integer> int_list2 = new LinkedListCircularUnordered<>();
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