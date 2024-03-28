package LinkedList.Tests.Disordered.LinkedListCircularDisordered;

import LinkedList.Disordered.LinkedListCircularDisordered;

public class TestLinkedListCircularDisordered {
    public static void main(String[] args) {

        LinkedListCircularDisordered<Integer> list = new LinkedListCircularDisordered<>();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        int primeiro = list.primeiro.elemento;
        int ultimo = list.ultimo.elemento;

        int proximoDoPrimeiro = list.primeiro.proximo.elemento;
        int proximoDoUltimo = list.ultimo.proximo.elemento;

        int proximoDoProximoDoPrimeiro = list.primeiro.proximo.proximo.elemento;
        int proximoDoProximoDoUltimo = list.ultimo.proximo.proximo.elemento;

        int proximoDoProximoDoProximoDoPrimeiro = list.primeiro.proximo.proximo.proximo.elemento;
        int proximoDoProximoDoProximoDoUltimo = list.ultimo.proximo.proximo.proximo.elemento;


        System.out.println("primeiro: " + primeiro);
        System.out.println("ultimo: " + ultimo);
        System.out.println("proximoDoPrimeiro: " + proximoDoPrimeiro);
        System.out.println("proximoDoUltimo:  " + proximoDoUltimo);
        System.out.println("proximoDoProximoDoPrimeiro: " + proximoDoProximoDoPrimeiro);
        System.out.println("proximoDoProximoDoUltimo:  " + proximoDoProximoDoUltimo);
        System.out.println("proximoDoProximoDoProximoDoPrimeiro: " + proximoDoProximoDoProximoDoPrimeiro);
        System.out.println("proximoDoProximoDoProximoDoUltimo:  " + proximoDoProximoDoProximoDoUltimo);

        System.out.println(list);
    }
}
