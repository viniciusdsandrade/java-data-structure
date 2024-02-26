package BinarySearch.src.tests;

import LinkedList.src.ListaEncadeadaSimplesDesordenada;

public class TestLinkedList {
    public static void main(String[] args) {

        ListaEncadeadaSimplesDesordenada<Integer> lista_1, lista_2;
        lista_1 = new ListaEncadeadaSimplesDesordenada<>();
        lista_2 = new ListaEncadeadaSimplesDesordenada<>();

        lista_1.add(1);
        lista_1.add(2);
        lista_1.add(3);

        lista_2.add(1);
        lista_2.add(2);
        lista_2.add(3);

        System.out.println("lista_1: " + lista_1);
        System.out.println("lista_2: " + lista_2);
        System.out.println("lista_1.contains(3): " + lista_1.contains(3));
        System.out.println("lista_1.contains(4): " + lista_1.contains(4));

        System.out.println("lista_1.hashCode() = " + lista_1.hashCode());
        System.out.println("lista_2.hashCode() = " + lista_2.hashCode());
        System.out.println("lista_1.equals(lista_2) = " + lista_1.equals(lista_2));
    }
}
