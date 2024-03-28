package LinkedList.Tests.Ordered.LinkedListCircularOrdered;

import LinkedList.Ordered.LinkedListCircularOrdered;

public class TestLinkedListCircularOrdered {
    public static void main(String[] args) {

        LinkedListCircularOrdered<Integer> list = new LinkedListCircularOrdered<>();

        list.add(2);
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(0);

        System.out.println(list);


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
