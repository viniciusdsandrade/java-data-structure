package LinkedList.Tests.Disordered.LinkedListDisordered;

import LinkedList.Disordered.LinkedListDisordered;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestLinkedListDisordered {

    // Método para verificar se a lista é simplesmente encadeada
    public static <X> boolean verificaSimplesmenteEncadeada(LinkedListDisordered<X> lista) {
        // Verifica se a lista está vazia ou contém apenas um elemento
        if (lista.primeiro == null || lista.primeiro.proximo == null) return true;

        // Verifica se há algum nó com mais de uma referência para o próximo nó
        LinkedListDisordered<X>.Node current = lista.primeiro;
        while (current != null) {
            // Se um nó tem mais de uma referência para o próximo nó, a lista não é simplesmente encadeada
            if (countReferencesToNext(current) > 1) return false;

            // Avança para o próximo nó
            current = current.proximo;
        }

        // Se chegamos ao final da lista sem encontrar problemas, a lista é simplesmente encadeada
        return true;
    }

    // Método auxiliar para contar as referências para o próximo nó de um determinado nó
    private static <X> int countReferencesToNext(LinkedListDisordered<X>.Node node) {
        int count = 0;
        LinkedListDisordered<X>.Node current = node;
        while (current != null) {
            // Se o próximo nó do nó atual é o nó que estamos verificando, incrementa o contador
            if (current.proximo == node) count++;

            // Avança para o próximo nó
            current = current.proximo;
        }

        // Retorna a quantidade de referências para o próximo nó do nó que estamos verificando
        return count;
    }

    public static void main(String[] args) {
        LinkedListDisordered<Integer> int_list = new LinkedListDisordered<>();

        // Adicionando elementos à int_list
        int_list.addLast(1);
        int_list.addLast(2);
        int_list.addLast(3);
        int_list.addLast(4);
        int_list.addLast(5);

        // Verificando se a int_list é simplesmente encadeada
        boolean isSinglyLinked = verificaSimplesmenteEncadeada(int_list);
        System.out.println("int_list: " + int_list);
        System.out.println("A int_list é encadeada: " + isSinglyLinked);
        
        LinkedListDisordered<String> meuNome = new LinkedListDisordered<>();
        meuNome.addLast("i");
        meuNome.addLast("n");
        meuNome.addLast("í");
        meuNome.addLast("c");
        meuNome.addLast("i");
        meuNome.addLast("u");
        
        meuNome.addAt("V", 0);
        // meuNome.addFirst("V");
        
        meuNome.addAt("s", 6);
        // meuNome.addLast("s");
        
        System.out.println("meuNome: " + meuNome);
        meuNome.removeAt(7);
        System.out.println("meuNome: " + meuNome);
        
        LinkedListDisordered<Object> coisas = new LinkedListDisordered<>();
        coisas.addAt(1, 0);
        coisas.addAt(2, 1);
        coisas.addAt(3, 2);

        System.out.println("coisas:   " + coisas);

        coisas.addAt(0, 0);
        System.out.println("depois de adicionar no início: " + coisas);
        System.out.println("tamanho:  " + coisas.getTamanho());

        coisas.addAt(4, 4);
        System.out.println("depois de adicionar no final:   " + coisas);
        System.out.println("tamanho:  " + coisas.getTamanho());

        Integer last = (Integer) coisas.getLast();
        System.out.println("coisas.getLast():   " + last);

        Integer algum = (Integer) coisas.get(1);
        System.out.println("coisas.get(1):     " + algum);

        coisas.removeFirst();
        System.out.println("depois de remover o primeiro: " + coisas);

        coisas.removeLast();
        System.out.println("depois de remover o último:   " + coisas);

        coisas.removeAt(0);
        System.out.println("depois de remover o algum:    " + coisas);

        LinkedListDisordered<Integer> numbers = new LinkedListDisordered<>();
        numbers.addLast(9);
        numbers.addLast(8);
        numbers.addLast(7);
        numbers.addLast(6);
        numbers.addLast(5);
        numbers.addLast(4);
        numbers.addLast(3);
        numbers.addLast(2);
        numbers.addLast(1);
        numbers.addLast(0);

        System.out.println("antes de ordenar:     " + numbers);
        numbers.sort();
        System.out.println("depois de ordenar:    " + numbers);
        numbers.shuffle();
        System.out.println("depois de embaralhar: " + numbers);

        LinkedListDisordered<Character> characters = new LinkedListDisordered<>();
        characters.addLast('g');
        characters.addLast('f');
        characters.addLast('e');
        characters.addLast('d');
        characters.addLast('c');
        characters.addLast('b');
        characters.addLast('a');

        System.out.println("antes de ordenar:  " + characters);
        characters.sort();
        System.out.println("depois de ordenar: " + characters);

        LinkedListDisordered<String> strings = new LinkedListDisordered<>();
        strings.addLast("Vinícius");
        strings.addLast("Silvana");
        strings.addLast("Siloede");
        strings.addLast("Arthur");

        System.out.println("antes de ordenar:  " + strings);
        strings.sort();
        System.out.println("depois de ordenar: " + strings);

        LinkedListDisordered<Float> floats = new LinkedListDisordered<>();
        floats.addLast(9.0f);
        floats.addLast(8.0f);
        floats.addLast(7.0f);
        floats.addLast(6.0f);
        floats.addLast(5.0f);
        floats.addLast(4.0f);
        floats.addLast(3.0f);
        floats.addLast(2.0f);
        floats.addLast(1.0f);

        System.out.println("antes de ordenar:  " + floats);
        floats.sort();
        System.out.println("depois de ordenar: " + floats);

        LinkedListDisordered<Double> doubles = new LinkedListDisordered<>();
        doubles.addLast(9.0);
        doubles.addLast(8.0);
        doubles.addLast(7.0);
        doubles.addLast(6.0);
        doubles.addLast(5.0);
        doubles.addLast(4.0);
        doubles.addLast(3.0);
        doubles.addLast(2.0);
        doubles.addLast(1.0);

        System.out.println("antes de ordenar:  " + doubles);
        doubles.sort();
        System.out.println("depois de ordenar: " + doubles);


        LinkedListDisordered<List<Integer>> list = new LinkedListDisordered<>();

        List<Integer> lista1 = new ArrayList<>();
        lista1.addLast(1);
        lista1.addLast(2);
        lista1.addLast(3);

        List<Integer> lista2 = new ArrayList<>();
        lista2.addLast(3);
        lista2.addLast(2);
        lista2.addLast(1);

        List<Integer> lista3 = new ArrayList<>();
        lista3.addLast(2);
        lista3.addLast(3);
        lista3.addLast(1);

        List<Integer> lista4 = new ArrayList<>();
        lista4.addLast(2);
        lista4.addLast(1);
        lista4.addLast(3);

        List<Integer> lista5 = new ArrayList<>();
        lista5.addLast(1);
        lista5.addLast(3);
        lista5.addLast(2);

        list.addLast(lista3);
        list.addLast(lista2);
        list.addLast(lista4);
        list.addLast(lista1);
        list.addLast(lista5);

        System.out.println("antes de ordenar:  " + list);
        list.sort(Comparator.comparing(Object::toString)); // Ordena com base na representação de string dos objetos
        System.out.println("depois de ordenar: " + list);
        list.shuffle(); // Embaralha com base na representação de string dos objetos
        System.out.println("depois de embaralhar: " + list);

        for (int i = 0; i < numbers.getTamanho(); i++)
            System.out.println(numbers.get(i));


        LinkedListDisordered<String> name = new LinkedListDisordered<>();
        System.out.println(name);
        name.addLast("dos");
        name.addLast("Santos");
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

        int size = name.getTamanho();
        System.out.println("Tamanho: " + size);

        boolean estaVazio = name.isEmpty();
        System.out.println("Está vazio: " + estaVazio);

        name.clear();

        size = name.getTamanho();
        System.out.println("Tamanho: " + size);

        estaVazio = name.isEmpty();
        System.out.println("Está vazio: " + estaVazio);

        System.out.println("adicionando no inicio: First");
        name.addFirst("First");
        System.out.println(name);

        System.out.println("adicionando no inicio: Second");
        name.addLast("Second");
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