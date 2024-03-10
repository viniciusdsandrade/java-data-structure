package LinkedList.tests.LinkedListDisordered;

import LinkedList.LinkedListDisordered;

public class TestLinkedListDisordered {
    public static void main(String[] args) {
        LinkedListDisordered<Object> linked_name = new LinkedListDisordered<>();
        System.out.println(linked_name);
        linked_name.add("dos");
        linked_name.add("Santos");
        System.out.println(linked_name);
        System.out.println(linked_name.get(0));

        //quero testar o método reverse
        linked_name.reverse();
        System.out.println(linked_name);
        linked_name.reverse();
        System.out.println(linked_name);

        //Quero testar o método rotate
        System.out.println("before rotacio: " + linked_name);
        linked_name.rotate(0);
        System.out.println("Rotacionando 0: " + linked_name);
        linked_name.rotate(1);
        System.out.println("Rotacionando 1: " + linked_name);
        linked_name.rotate(2);
        System.out.println("Rotacionando 2: " + linked_name);
        linked_name.rotate(3);
        System.out.println("Rotacionando 3: " + linked_name);
        linked_name.rotate(4);
        System.out.println("Rotacionando 4: " + linked_name);
        linked_name.rotate(5);
        System.out.println("Rotacionando 5: " + linked_name);
        System.out.println();

        linked_name.addFirst("Vinícius");
        linked_name.addLast("Andrade");
        System.out.println(linked_name);

        linked_name.removeFirst();
        System.out.println("removendo first" + linked_name);
        linked_name.removeLast();
        System.out.println("removendo last" + linked_name);

        boolean contemDos = linked_name.contains("dos");
        System.out.println("contém ´dos´: " + contemDos);

        boolean contemVinicius = linked_name.contains("Vinícius");
        System.out.println("contém ´Vinícius´: " + contemVinicius);

        boolean contemAndrade = linked_name.contains("Andrade");
        System.out.println("contém ´Andrade´: " + contemAndrade);

        int tamanho = linked_name.getSize();
        System.out.println("Tamanho: " + tamanho);

        boolean estaVazio = linked_name.isEmpty();
        System.out.println("Está vazio: " + estaVazio);

        linked_name.clear();

        tamanho = linked_name.getSize();
        System.out.println("Tamanho: " + tamanho);

        estaVazio = linked_name.isEmpty();
        System.out.println("Está vazio: " + estaVazio);

        linked_name.add("First");
        System.out.println(linked_name);
        linked_name.add("Second");
        System.out.println(linked_name);
        linked_name.add("Last");
        System.out.println(linked_name);

        Object primeiro = linked_name.getFirst();
        System.out.println("Primeiro: " + primeiro);

        Object ultimo = linked_name.getLast();
        System.out.println("Último: " + ultimo);

        linked_name.clear();
        linked_name.add(1);
        linked_name.add(2);
        linked_name.add(3);
        linked_name.add(4);
        linked_name.add(5);
        linked_name.add(6);
        linked_name.add(7);
        linked_name.add(8);
        linked_name.add(9);

        System.out.println(linked_name);

        for (int i = 0; i < linked_name.getSize(); i++) {
            System.out.println(linked_name.get(i));
        }

        for (int i = 1; i < 10; i++) {
            linked_name.remove(i);
            System.out.println(linked_name);
        }
    }
}