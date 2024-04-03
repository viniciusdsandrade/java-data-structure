package HashSet;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class MyHashSet {
    /*
    HashSet:
        HashSet é uma implementação da interface Set.
        Armazena elementos únicos, ou seja, não permite elementos duplicados.
        Não mantém a ordem dos elementos inseridos.
        Internamente, ele usa um HashMap para armazenar os elementos, onde as chaves são os elementos do conjunto e os valores são objetos Dummy.
        Não é sincronizado.
        Permite um único elemento nulo.
     */
    public static void main(String[] args) {

        Set<Integer> hs = new HashSet<>();
        Set<Integer> hs2 = new TreeSet<>();
        Set<Integer> hs3 = new ConcurrentSkipListSet<>();
        Set<Integer> hs5 = new CopyOnWriteArraySet<>();
        Set<Integer> hs4 = new LinkedHashSet<>();

    }
}
