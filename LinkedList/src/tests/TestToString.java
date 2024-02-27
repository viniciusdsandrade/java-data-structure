package LinkedList.src.tests;

import LinkedList.src.ListaEncadeadaSimplesDesordenada;

import static java.lang.System.*;

public class TestToString {
    public static void main(String[] args) {

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

        out.println(lista1);
        out.println(lista2);
        out.println(lista3);
        out.println(lista4);
        out.println(lista5);
        out.println(lista6);
        out.println(lista7);
        out.println(lista8);
        out.println(lista9);
    }
}
