package HashMap;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class MyHashMap {
    /*
    HashMap:
        HashMap é uma implementação da interface Map.
        Ele armazena os elementos na forma de pares chave-valor.
        As chaves não são duplicadas, mas os valores podem ser.
        Não é sincronizado, o que significa que não é thread-safe. Se várias threads acessarem um HashMap simultaneamente e pelo menos uma delas modificar o mapa estruturalmente, ela deve ser sincronizada externamente.
        Permite valores nulos tanto para chaves quanto para valores.
        Não mantém a ordem dos elementos inseridos.
        É mais eficiente em termos de desempenho do que HashTable.
     */
    public static void main(String[] args) {
        Map<Integer, String> hm1 = new HashMap<>();
        Map<Integer, String> hm3 = new TreeMap<>();
        Map<Integer, String> hm2 = new IdentityHashMap<>();
        Map<Integer, String> hm4 = new LinkedHashMap<>();
        Map<Integer, String> hm5 = new WeakHashMap<>();
        Map<Integer, String> hm6 = new Hashtable<>();
        Map<Integer, String> hm7 = new ConcurrentHashMap<>();
        Map<Integer, String> hm8 = new ConcurrentSkipListMap<>();
    }
}
