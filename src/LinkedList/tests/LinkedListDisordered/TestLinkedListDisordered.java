package LinkedList.tests.LinkedListDisordered;

import LinkedList.LinkedListDisordered;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestLinkedListDisordered {
    public static void main(String[] args) {

        LinkedListDisordered<Integer> numbers = new LinkedListDisordered<>();
        numbers.add(9);
        numbers.add(8);
        numbers.add(7);
        numbers.add(6);
        numbers.add(5);
        numbers.add(4);
        numbers.add(3);
        numbers.add(2);
        numbers.add(1);
        numbers.add(0);

        System.out.println("antes de ordenar:     " + numbers);
        numbers.sort();
        System.out.println("depois de ordenar:    " + numbers);
        numbers.shuffle();
        System.out.println("depois de embaralhar: " + numbers);

        LinkedListDisordered<Character> characters = new LinkedListDisordered<>();
        characters.add('g');
        characters.add('f');
        characters.add('e');
        characters.add('d');
        characters.add('c');
        characters.add('b');
        characters.add('a');

        System.out.println("antes de ordenar:  " + characters);
        characters.sort();
        System.out.println("depois de ordenar: " + characters);

        LinkedListDisordered<String> strings = new LinkedListDisordered<>();
        strings.add("Vinícius");
        strings.add("Silvana");
        strings.add("Siloede");
        strings.add("Arthur");

        System.out.println("antes de ordenar:  " + strings);
        strings.sort();
        System.out.println("depois de ordenar: " + strings);

        LinkedListDisordered<Float> floats = new LinkedListDisordered<>();
        floats.add(9.0f);
        floats.add(8.0f);
        floats.add(7.0f);
        floats.add(6.0f);
        floats.add(5.0f);
        floats.add(4.0f);
        floats.add(3.0f);
        floats.add(2.0f);
        floats.add(1.0f);

        System.out.println("antes de ordenar:  " + floats);
        floats.sort();
        System.out.println("depois de ordenar: " + floats);

        LinkedListDisordered<Double> doubles = new LinkedListDisordered<>();
        doubles.add(9.0);
        doubles.add(8.0);
        doubles.add(7.0);
        doubles.add(6.0);
        doubles.add(5.0);
        doubles.add(4.0);
        doubles.add(3.0);
        doubles.add(2.0);
        doubles.add(1.0);

        System.out.println("antes de ordenar:  " + doubles);
        doubles.sort();
        System.out.println("depois de ordenar: " + doubles);


        LinkedListDisordered<List<Integer>> list = new LinkedListDisordered<>();

        List<Integer> lista1 = new ArrayList<>();
        lista1.add(1);
        lista1.add(2);
        lista1.add(3);

        List<Integer> lista2 = new ArrayList<>();
        lista2.add(3);
        lista2.add(2);
        lista2.add(1);

        List<Integer> lista3 = new ArrayList<>();
        lista3.add(2);
        lista3.add(3);
        lista3.add(1);

        List<Integer> lista4 = new ArrayList<>();
        lista4.add(2);
        lista4.add(1);
        lista4.add(3);

        List<Integer> lista5 = new ArrayList<>();
        lista5.add(1);
        lista5.add(3);
        lista5.add(2);

        list.add(lista3);
        list.add(lista2);
        list.add(lista4);
        list.add(lista1);
        list.add(lista5);

        System.out.println("antes de ordenar:  " + list);
        list.sort(Comparator.comparing(Object::toString)); // Ordena com base na representação de string dos objetos
        System.out.println("depois de ordenar: " + list);
        list.shuffle(); // Embaralha com base na representação de string dos objetos
        System.out.println("depois de embaralhar: " + list);

        for (int i = 0; i < numbers.getSize(); i++) {
            System.out.println(numbers.get(i));
        }

        for (int i = 1; i < 10; i++) {
            numbers.remove(i);
            System.out.println(numbers);
        }

        LinkedListDisordered<String> name = new LinkedListDisordered<>();
        System.out.println(name);
        name.add("dos");
        name.add("Santos");
        System.out.println(name);

        //quero testar o método reverse
        name.reverse();
        System.out.println(name);
        name.reverse();
        System.out.println(name);

        //Quero testar o método rotate
        System.out.println("before rotacio: " + name);
        name.rotate(0);
        System.out.println("Rotacionando 0: " + name);
        name.rotate(1);
        System.out.println("Rotacionando 1: " + name);
        name.rotate(2);
        System.out.println("Rotacionando 2: " + name);
        name.rotate(3);
        System.out.println("Rotacionando 3: " + name);
        name.rotate(4);
        System.out.println("Rotacionando 4: " + name);
        name.rotate(5);
        System.out.println("Rotacionando 5: " + name);
        System.out.println();

        System.out.println("adicionando no inicio: Vinícius");
        name.addFirst("Vinícius");
        System.out.println(name);
        System.out.println("adicionando no final: Andrade");
        name.addLast("Andrade");
        System.out.println(name);

        name.removeFirst();
        System.out.println("removendo first: " + name);
        name.removeLast();
        System.out.println("removendo last:  " + name);

        boolean contemDos = name.contains("dos");
        System.out.println("contém ´dos´: " + contemDos);

        boolean contemVinicius = name.contains("Vinícius");
        System.out.println("contém ´Vinícius´: " + contemVinicius);

        boolean contemAndrade = name.contains("Andrade");
        System.out.println("contém ´Andrade´: " + contemAndrade);

        int tamanho = name.getSize();
        System.out.println("Tamanho: " + tamanho);

        boolean estaVazio = name.isEmpty();
        System.out.println("Está vazio: " + estaVazio);

        name.clear();

        tamanho = name.getSize();
        System.out.println("Tamanho: " + tamanho);

        estaVazio = name.isEmpty();
        System.out.println("Está vazio: " + estaVazio);

        System.out.println("adicionando no inicio: First");
        name.addFirst("First");
        System.out.println(name);

        System.out.println("adicionando no inicio: Second");
        name.add("Second");
        System.out.println(name);

        System.out.println("adicionando no final: Last");
        name.addLast("Last");
        System.out.println(name);

        Object primeiro = name.getFirst();
        System.out.println("Primeiro: " + primeiro);

        Object ultimo = name.getLast();
        System.out.println("Último: " + ultimo);

        name.clear();

    }
}