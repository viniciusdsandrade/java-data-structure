package LinkedList.Tests.Disordered.LinkedListCircularDisordered;

import LinkedList.Disordered.LinkedListCircularDisordered;

public class TestLinkedListCircularDisordered {
    public static void main(String[] args) {

        LinkedListCircularDisordered<Integer> list = new LinkedListCircularDisordered<>();

        list.add(1);
        list.add(2);

        int primeiro = list.primeiro.elemento;
        int ultimo = list.ultimo.elemento;

        int proximoDoPrimeiro = list.primeiro.proximo.elemento;
        int proximoDoUltimo = list.ultimo.proximo.elemento;

        int proximoDoProximoDoPrimeiro = list.primeiro.proximo.proximo.elemento;
        int proximoDoProximoDoUltimo = list.ultimo.proximo.proximo.elemento;


        System.out.println("primeiro: " + primeiro);
        System.out.println("ultimo: " + ultimo);
        System.out.println("proximoDoPrimeiro: " + proximoDoPrimeiro);
        System.out.println("proximoDoUltimo:  " + proximoDoUltimo);
        System.out.println("proximoDoProximoDoPrimeiro: " + proximoDoProximoDoPrimeiro);
        System.out.println("proximoDoProximoDoUltimo:  " + proximoDoProximoDoUltimo);

        System.out.println(list);
    }
}
