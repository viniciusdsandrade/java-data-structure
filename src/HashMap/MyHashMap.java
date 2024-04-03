package HashMap;

import java.util.HashMap;
import java.util.Map;

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
        Map<Integer, String> hm = new HashMap<>();
        System.out.println(hm);
    }
}
