package LinkedList.src.tests;

import LinkedList.src.ListaEncadeadaSimplesDesordenada;

public class TestCloneAndCopyConstructor {
    public static void main(String[] args) {
        
        ListaEncadeadaSimplesDesordenada<Integer> lista1 = new ListaEncadeadaSimplesDesordenada<>();
        
        for (int i = 0; i < 10; i++) {
            lista1.add(i);
        }
        
        // Teste do construtor de cópia
        ListaEncadeadaSimplesDesordenada<Integer> lista2 = new ListaEncadeadaSimplesDesordenada<>(lista1);
        
        System.out.println("lista1: " + lista1);
        System.out.println("lista2: " + lista2);
        
        System.out.println();

        // Teste do método clone
        @SuppressWarnings("unchecked")
        ListaEncadeadaSimplesDesordenada<Integer> lista3 = (ListaEncadeadaSimplesDesordenada<Integer>) lista1.clone();
        
        System.out.println("lista1: " + lista1);
        System.out.println("lista3: " + lista3);
        System.out.println();
        
        System.out.println("lista1.hashCode(): " + lista1.hashCode());
        System.out.println("lista2.hashCode(): " + lista2.hashCode());
        System.out.println("lista3.hashCode(): " + lista3.hashCode());
    }
}
