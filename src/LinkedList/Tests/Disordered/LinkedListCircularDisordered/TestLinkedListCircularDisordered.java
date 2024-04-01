package LinkedList.Tests.Disordered.LinkedListCircularDisordered;

import LinkedList.Disordered.LinkedListCircularDisordered;

public class TestLinkedListCircularDisordered {

    public static <X> boolean verificaCircular(LinkedListCircularDisordered<X> lista) {
        // Se a lista estiver vazia, ela não é circular
        if (lista.primeiro == null) return false;

        // Começamos a verificação a partir do primeiro nó
        LinkedListCircularDisordered<X>.Node temp = lista.primeiro;

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
        LinkedListCircularDisordered<Integer> int_list = new LinkedListCircularDisordered<>();
        int_list.addLast(1);
        int_list.addLast(2);
        int_list.addLast(3);

        // Verificando se a lista é circular
        boolean isCircular = verificaCircular(int_list);
        System.out.println("A lista é circular: " + isCircular);

        int primeiro = int_list.primeiro.elemento;
        int ultimo = int_list.ultimo.elemento;

        int proximoDoPrimeiro = int_list.primeiro.proximo.elemento;
        int proximoDoUltimo = int_list.ultimo.proximo.elemento;

        int proximoDoProximoDoPrimeiro = int_list.primeiro.proximo.proximo.elemento;
        int proximoDoProximoDoUltimo = int_list.ultimo.proximo.proximo.elemento;

        int proximoDoProximoDoProximoDoPrimeiro = int_list.primeiro.proximo.proximo.proximo.elemento;
        int proximoDoProximoDoProximoDoUltimo = int_list.ultimo.proximo.proximo.proximo.elemento;

        System.out.println("primeiro: " + primeiro);
        System.out.println("ultimo:   " + ultimo);
        System.out.println("proximoDoPrimeiro: " + proximoDoPrimeiro);
        System.out.println("proximoDoUltimo:   " + proximoDoUltimo);
        System.out.println("proximoDoProximoDoPrimeiro: " + proximoDoProximoDoPrimeiro);
        System.out.println("proximoDoProximoDoUltimo:   " + proximoDoProximoDoUltimo);
        System.out.println("proximoDoProximoDoProximoDoPrimeiro: " + proximoDoProximoDoProximoDoPrimeiro);
        System.out.println("proximoDoProximoDoProximoDoUltimo:   " + proximoDoProximoDoProximoDoUltimo);
    }
}