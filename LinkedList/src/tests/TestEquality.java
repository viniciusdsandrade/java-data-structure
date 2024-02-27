package LinkedList.src.tests;

import LinkedList.src.ListaEncadeadaSimplesDesordenada;

public class TestEquality {

    public static void main(String[] args) {
        ListaEncadeadaSimplesDesordenada<Integer> lista1;
        ListaEncadeadaSimplesDesordenada<Integer> lista2;

        ListaEncadeadaSimplesDesordenada<String> lista3;
        ListaEncadeadaSimplesDesordenada<String> lista4;

        lista1 = new ListaEncadeadaSimplesDesordenada<>();
        lista2 = new ListaEncadeadaSimplesDesordenada<>();

        lista3 = new ListaEncadeadaSimplesDesordenada<>();
        lista4 = new ListaEncadeadaSimplesDesordenada<>();

        for (int i = 0; i < 10; i++) {
            lista1.add(i);
        }
        
        lista1.clear();

        for (int i = 9; i >= 0; i--) {
            lista2.add(i);
        }

        for (int i = 0; i < 10; i++) {
            lista3.add(String.valueOf(i));
            lista4.add(String.valueOf(i));
        }

        System.out.println("lista1: " + lista1);
        System.out.println("lista2: " + lista2);
        System.out.println();
        System.out.println("lista1.hashCode(): " + lista1.hashCode());
        System.out.println("lista2.hashCode(): " + lista2.hashCode());
        System.out.println();
        System.out.println("lista1.equals(lista2): " + lista1.equals(lista2));
        System.out.println("lista3.equals(lista4): " + lista3.equals(lista4));
    }
}
