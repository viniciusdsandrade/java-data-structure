package LinkedList.src.tests;

import LinkedList.src.ListaEncadeadaSimplesDesordenada;
import src.Coordinate;
import src.Stack;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestLinkedList {
    public static void main(String[] args) {

        // Instanciando com tipos primitivos
        ListaEncadeadaSimplesDesordenada<Integer> lista1 = new ListaEncadeadaSimplesDesordenada<>();
        ListaEncadeadaSimplesDesordenada<String> lista2 = new ListaEncadeadaSimplesDesordenada<>();
        ListaEncadeadaSimplesDesordenada<Double> lista3 = new ListaEncadeadaSimplesDesordenada<>();
        ListaEncadeadaSimplesDesordenada<Character> lista4 = new ListaEncadeadaSimplesDesordenada<>();
        ListaEncadeadaSimplesDesordenada<Boolean> lista5 = new ListaEncadeadaSimplesDesordenada<>();
        ListaEncadeadaSimplesDesordenada<Float> lista6 = new ListaEncadeadaSimplesDesordenada<>();
        ListaEncadeadaSimplesDesordenada<Long> lista7 = new ListaEncadeadaSimplesDesordenada<>();
        ListaEncadeadaSimplesDesordenada<Short> lista8 = new ListaEncadeadaSimplesDesordenada<>();
        ListaEncadeadaSimplesDesordenada<Byte> lista9 = new ListaEncadeadaSimplesDesordenada<>();
        
        lista1.add(1);
        lista2.add("2");
        lista3.add(3.0);
        lista4.add('4');
        lista5.add(true);
        lista6.add(6.0f);
        lista7.add(7L);
        lista8.add((short) 8);
        lista9.add((byte) 9);

        // Instanciando com tipos não primitivos
        ListaEncadeadaSimplesDesordenada<Object> lista10 = new ListaEncadeadaSimplesDesordenada<>();// Uma lista encadeada que pode conter qualquer tipo de objeto.
        ListaEncadeadaSimplesDesordenada<List<Object>> lista11 = new ListaEncadeadaSimplesDesordenada<>();// Uma lista encadeada que pode conter listas de qualquer tipo de objeto.
        ListaEncadeadaSimplesDesordenada<Coordinate> lista12 = new ListaEncadeadaSimplesDesordenada<>();// Uma lista encadeada que pode conter objetos do tipo Coordinate.
        ListaEncadeadaSimplesDesordenada<Stack<Object>> lista13 = new ListaEncadeadaSimplesDesordenada<>();// Uma lista encadeada que pode conter pilhas (Stack) de qualquer tipo de objeto.
        ListaEncadeadaSimplesDesordenada<List<Stack<Object>>> lista14 = new ListaEncadeadaSimplesDesordenada<>();// Uma lista encadeada que pode conter listas de pilhas (Stack) de qualquer tipo de objeto.
        ListaEncadeadaSimplesDesordenada<Map<String, String>> lista15 = new ListaEncadeadaSimplesDesordenada<>();// Uma lista encadeada que pode conter mapas (Map) com chaves e valores do tipo String.
        ListaEncadeadaSimplesDesordenada<Map<String, List<String>>> lista16 = new ListaEncadeadaSimplesDesordenada<>();// Uma lista encadeada que pode conter mapas (Map) com chaves do tipo String e valores que são listas de Strings.
        ListaEncadeadaSimplesDesordenada<Set<Coordinate>> lista17 = new ListaEncadeadaSimplesDesordenada<>();// Uma lista encadeada que pode conter conjuntos (Set) de objetos do tipo Coordinate.


        lista10.add(lista1);
        lista11.add(List.of(lista1, lista2, lista3, lista4, lista5, lista6, lista7, lista8, lista9));
        lista12.add(new Coordinate(12, 12));
        lista13.add(new Stack<>(10));
        lista14.add(List.of(new Stack<>(10), new Stack<>(20), new Stack<>(30)));
        lista15.add(Map.of("15", "15"));
        lista16.add(Map.of("16", List.of("16")));
        lista17.add(Set.of(new Coordinate(17, 17), new Coordinate(18, 18), new Coordinate(19, 19)));

        System.out.println(lista1);
        System.out.println(lista2);
        System.out.println(lista3);
        System.out.println(lista4);
        System.out.println(lista5);
        System.out.println(lista6);
        System.out.println(lista7);
        System.out.println(lista8);
        System.out.println(lista9);
        System.out.println(lista10);
        System.out.println(lista11);
        System.out.println(lista12);
        System.out.println(lista13);
        System.out.println(lista14);
        System.out.println(lista15);
        System.out.println(lista16);
        System.out.println(lista17);
    }
}