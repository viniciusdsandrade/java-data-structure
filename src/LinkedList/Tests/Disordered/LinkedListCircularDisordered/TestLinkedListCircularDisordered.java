package LinkedList.Tests.Disordered.LinkedListCircularDisordered;

import LinkedList.Disordered.LinkedListCircularDisordered;

public class TestLinkedListCircularDisordered {
    public static void main(String[] args) {
        LinkedListCircularDisordered<Integer> list = new LinkedListCircularDisordered<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        System.out.println("list: " + list);

        boolean isCircular = false;
        LinkedListCircularDisordered<Integer>.Node temp = list.getPrimeiro();
        if (temp != null) {
            LinkedListCircularDisordered<Integer>.Node ultimo = list.getUltimo();
            do {
                if (temp == ultimo) {
                    if (temp.proximo == list.getPrimeiro()) {
                        isCircular = true;
                    }
                    break;
                }
                temp = temp.proximo;
            } while (temp != list.getPrimeiro());
        }

        if (isCircular)
            System.out.println("A lista é circular.");
        else
            System.out.println("A lista não é circular.");

        int primeiro = list.primeiro.elemento;
        int ultimo = list.ultimo.elemento;

        int proximoDoPrimeiro = list.primeiro.proximo.elemento;
        int proximoDoUltimo = list.ultimo.proximo.elemento;

        int proximoDoProximoDoPrimeiro = list.primeiro.proximo.proximo.elemento;
        int proximoDoProximoDoUltimo = list.ultimo.proximo.proximo.elemento;

        int proximoDoProximoDoProximoDoPrimeiro = list.primeiro.proximo.proximo.proximo.elemento;
        int proximoDoProximoDoProximoDoUltimo = list.ultimo.proximo.proximo.proximo.elemento;

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