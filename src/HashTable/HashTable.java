package HashTable;

import java.util.Hashtable;

public class HashTable {
    /*
    HashTable é uma classe que foi parte da API Java desde as versões iniciais.
        Também armazena elementos na forma de pares chave-valor.
        É sincronizado, o que significa que é thread-safe. Isso implica que é um pouco mais lento do que HashMap, pois as operações de sincronização têm um custo.
        Não permite chaves ou valores nulos. Tentar inserir um valor nulo resultará em uma exceção NullPointerException.
        Mantém a ordem de inserção dos elementos desde o Java 8.
        Em geral, é menos usado do que HashMap, devido ao seu desempenho inferior e restrições em relação a chaves e valores nulos.
     */
    public static void main(String[] args) {
        Hashtable<Integer, String> ht = new Hashtable<>();
    }
}
