package HashMap;

import LinkedList.Unordered.LinkedListUnordered;

import java.util.Objects;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;
import static java.lang.Math.abs;

/*
Trata-se de uma técnica conhecida em português como "espalhamento", que possui a ambiciosa pretensão de recuperar, em tempo instantâneo, informações armazenadas em estruturas implementadas com essa técnica.
Diversas estruturas de dados podem ser implementadas com essa abordagem e, na aula de hoje, focaremos em uma chamada HashMap.
O HashMap baseia-se em duas informações: chave e valor. Ele armazena valores associados a chaves, e a chave é usada tanto para recuperar o valor armazenado quanto para remover um valor específico.
Podemos conceber a implementação de um HashMap como uma classe genérica com dois parâmetros, digamos, K e V, que representam, respectivamente, o tipo das chaves e o tipo dos valores. Para o armazenamento, poderíamos utilizar um vetor cujas posições contêm listas ligadas simples e desordenadas.
Para essa classe, podemos conceber um metodo chamado guardeUmItem, com dois parâmetros: um do tipo K (chave) e um do tipo V (valor).Esse metodo invocaria o hashCode da chave e calcularia o resto da divisão inteira do resultado do hashCode pelo tamanho do vetor.
Na posição indicada pelo resto da divisão, o valor seria armazenado juntamente com a chave. Vale ressaltar que a lista em uma posição qualquer do vetor só seria instanciada quando, de fato, desejássemos armazenar um item.
Também poderíamos implementar o metodo recupereUmItem, que recebe como parâmetro um objeto do tipo K, aplica o hashCode à chave, calcula o resto da divisão inteira do hashCode pelo tamanho do vetor e localiza, na lista contida na posição indicada pelo resto, a chave procurada, retornando o valor associado a ela.
Além disso, podemos conceber para essa classe um metodo chamado removaUmItem, que realiza as mesmas operações descritas para o metodo recupereUmItem, mas, em vez de retornar o valor associado à chave, remove o valor e a chave da lista.
Inclusões de chaves repetidas devem resultar em uma exceção. A tentativa de recuperar ou remover chaves inexistentes também deve lançar uma exceção. Deveria existir um atributo que informe quantos valores estão armazenados. Além disso, deveria haver um atributo que indique a taxa de desperdício aceitável (inicializado pelo construtor) e um atributo que informe a taxa máxima de desperdício aceitável (também inicializado pelo construtor).
Os metodos guardeUmItem e removaUmItem devem se responsabilizar por ajustar o tamanho do vetor conforme as taxas de desperdício descritas acima. Deverá existir ainda um atributo que represente a capacidade inicial com a qual o vetor foi dimensionado. Essa capacidade deve ser fornecida ao construtor para realizar o dimensionamento inicial. Em caso de redimensionamento do vetor para um tamanho menor (decorrente de remoção), deve-se garantir que o tamanho nunca fique abaixo da capacidade inicial.
Obviamente, clonagens devem ser feitas ao armazenar e ao recuperar um valor. Além disso, é natural supor a implementação de todos os metodos obrigatórios.
Pode ser uma boa ideia ter um segundo construtor que não exija que o usuário forneça as taxas mínimas e máximas, inicializando-as com valores padrão (sugestão: mínimo 0,7 e máximo 0,9).
Ao realizar o redimensionamento, tanto para aumentar quanto para diminuir o vetor, todos os elementos que já estavam armazenados e devem ser mantidos precisam ter suas posições recalculadas e ser armazenados novamente.
 */
public class HashMapLinkedListUnordered<K, V> implements Cloneable {

    public class Node implements Cloneable {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        // Getters e setters opcionais
        public K getKey() {
            return key;
        }

        @SuppressWarnings("unchecked")
        public V getValue() {
            return (V) verifyAndCopy(value); // Retorna uma cópia profunda do valor
        }

        @SuppressWarnings("unchecked")
        public void setValue(V value) {
            this.value = (V) verifyAndCopy(value); // Armazena uma cópia profunda do valor
        }

        /**
         * Construtor de cópia para a classe Node.
         *
         * @param original O Node original a ser copiado.
         */
        @SuppressWarnings("unchecked")
        public Node(Node original) {
            if (original == null) throw new IllegalArgumentException("Node original não pode ser nulo");
            this.key = (K) verifyAndCopy(original.key);
            this.value = (V) verifyAndCopy(original.value);
        }

        /**
         * Metodo clone para criar uma cópia profunda do Node.
         *
         * @return Uma nova instância de Node clonada.
         */
        @Override
        public Node clone() {
            Node clone = null;
            try {
                clone = new Node(this);
            } catch (Exception ignored) {
            }
            return clone;
        }

        /**
         * Verifica a igualdade entre este Node e outro objeto.
         *
         * @param obj Objeto a ser comparado.
         * @return {@code true} se os objetos forem iguais, {@code false} caso contrário.
         */
        @Override
        @SuppressWarnings("unchecked")
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;

            Node other = (Node) obj;

            return Objects.equals(this.key, other.key) &&
                   Objects.equals(this.value, other.value);
        }

        /**
         * Calcula o hashCode para este Node.
         *
         * @return Hash code do Node.
         */
        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

        /**
         * Retorna uma representação em string deste Node.
         *
         * @return Representação em string no formato "key=value".
         */
        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    private LinkedListUnordered<Node>[] table;
    private int capacity;
    private int length;
    private final float minLoadFactor;
    private final float maxLoadFactor;

    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_MIN_LOAD_FACTOR = 0.7f;
    private static final float DEFAULT_MAX_LOAD_FACTOR = 0.9f;

    @SuppressWarnings("unchecked")
    public HashMapLinkedListUnordered() {
        this.capacity = DEFAULT_CAPACITY;
        this.table = new LinkedListUnordered[capacity];

        for (int i = 0; i < capacity; i++) table[i] = new LinkedListUnordered<>();

        this.length = 0;
        this.minLoadFactor = DEFAULT_MIN_LOAD_FACTOR;
        this.maxLoadFactor = DEFAULT_MAX_LOAD_FACTOR;
    }

    /**
     * Construtor com capacidade e fatores de carga customizados.
     *
     * @param capacidadeInicial Capacidade inicial da tabela.
     * @param minLoadFactor     Fator de carga mínimo.
     * @param maxLoadFactor     Fator de carga máximo.
     */
    @SuppressWarnings("unchecked")
    public HashMapLinkedListUnordered(int capacidadeInicial, float minLoadFactor, float maxLoadFactor) {
        this.capacity = capacidadeInicial;
        this.table = new LinkedListUnordered[capacity];
        for (int i = 0; i < capacity; i++)
            table[i] = new LinkedListUnordered<>();
        this.length = 0;
        this.minLoadFactor = minLoadFactor;
        this.maxLoadFactor = maxLoadFactor;
    }

    /**
     * Metodo auxiliar para calcular o índice do bucket com base na chave.
     *
     * @param key Chave para calcular o índice.
     * @return Índice correspondente na tabela hash.
     */
    private int getIndiceBucket(K key) {
        return abs(Objects.hashCode(key)) % capacity;
    }

    /**
     * Insere ou atualiza um par chave-valor no mapa.
     *
     * @param key   Chave a ser inserida ou atualizada.
     * @param value Valor associado à chave.
     */
    @SuppressWarnings("unchecked")
    public void put(K key, V value) {
        // Cria cópias profundas das chaves e valores, se possível
        K keyCopy = (K) verifyAndCopy(key);
        V valueCopy = (V) verifyAndCopy(value);

        int indice = getIndiceBucket(keyCopy);
        LinkedListUnordered<Node> bucket = table[indice];

        // Percorre a lista manualmente para encontrar se a chave já existe
        LinkedListUnordered<Node>.Node current = bucket.getPrimeiro();
        while (current != null) {
            Node entry = current.elemento;
            if (entry.key.equals(keyCopy)) {
                entry.setValue(valueCopy); // Atualiza o valor existente com cópia profunda
                return;
            }
            current = current.proximo;
        }

        // Se a chave não existir, adiciona um novo nó com cópias profundas
        bucket.addLast(new Node(keyCopy, valueCopy));
        length++;

        // Verifica se é necessário redimensionar (aumentar)
        if ((float) length / capacity > maxLoadFactor) redimensionar(capacity * 2);
    }


    /**
     * Recupera o valor associado a uma chave específica.
     *
     * @param key Chave cujo valor será recuperado.
     * @return Cópia profunda do valor associado à chave, ou {@code null} se a chave não existir.
     */
    public V get(K key) {
        int indice = getIndiceBucket(key);
        LinkedListUnordered<Node> bucket = table[indice];

        // Percorre a lista manualmente para encontrar a chave
        LinkedListUnordered<Node>.Node current = bucket.getPrimeiro();
        while (current != null) {
            Node entry = current.elemento;
            if (entry.key.equals(key))
                return entry.getValue(); // Retorna uma cópia profunda do valor
            current = current.proximo;
        }

        return null; // Chave não encontrada
    }

    /**
     * Remove um par chave-valor do mapa.
     *
     * @param key Chave a ser removida.
     * @return Cópia profunda do valor removido, ou {@code null} se a chave não existir.
     */
    public V remove(K key) {
        int indice = getIndiceBucket(key);
        LinkedListUnordered<Node> bucket = table[indice];

        LinkedListUnordered<Node>.Node current = bucket.getPrimeiro();
        LinkedListUnordered<Node>.Node anterior = null;

        while (current != null) {
            Node entry = current.elemento;
            if (entry.key.equals(key)) {
                V valorRemovido = entry.getValue(); // Retorna uma cópia profunda do valor

                if (anterior == null) {
                    // Remover o primeiro nó
                    bucket.primeiro = current.proximo;
                } else {
                    // Remover nó intermediário ou último
                    anterior.proximo = current.proximo;
                }

                bucket.tamanho--;// Atualiza o tamanho da lista encadeada
                length--;

                // Verifica se é necessário redimensionar (diminuir)
                if (capacity > DEFAULT_CAPACITY && (float) length / capacity < minLoadFactor) {
                    redimensionar(capacity / 2);
                }

                return valorRemovido;
            }
            anterior = current;
            current = current.proximo;
        }

        return null; // Chave não encontrada
    }

    /**
     * Retorna o número de pares chave-valor no mapa.
     *
     * @return Tamanho do mapa.
     */
    public int size() {
        return length;
    }

    /**
     * Verifica se o mapa está vazio.
     *
     * @return {@code true} se o mapa estiver vazio, {@code false} caso contrário.
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * Redimensiona a tabela hash para uma nova capacidade.
     *
     * @param novaCapacidade Nova capacidade da tabela.
     */
    @SuppressWarnings("unchecked")
    private void redimensionar(int novaCapacidade) {
        LinkedListUnordered<Node>[] tabelaAntiga = table;
        table = new LinkedListUnordered[novaCapacidade];
        capacity = novaCapacidade;
        length = 0;

        for (int i = 0; i < capacity; i++) table[i] = new LinkedListUnordered<>();

        for (LinkedListUnordered<Node> bucket : tabelaAntiga) {
            LinkedListUnordered<Node>.Node current = bucket.getPrimeiro();
            while (current != null) {
                Node entry = current.elemento;
                put(entry.key, entry.value); // Reinsere com cópias profundas
                current = current.proximo;
            }
        }
    }

    /**
     * Verifica se o mapa contém uma chave específica.
     *
     * @param key Chave a ser verificada.
     * @return {@code true} se a chave existir no mapa, {@code false} caso contrário.
     */
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    /**
     * Remove todos os pares chave-valor do mapa.
     */
    public void clear() {
        for (int i = 0; i < capacity; i++)
            table[i].clear();
        length = 0;
    }

    /**
     * Construtor de cópia para a classe HashMapLinkedListUnordered.
     *
     * @param original O HashMap original a ser copiado.
     */
    @SuppressWarnings("unchecked")
    public HashMapLinkedListUnordered(HashMapLinkedListUnordered<K, V> original) {
        if (original == null) throw new IllegalArgumentException("HashMap original não pode ser nulo");
        this.capacity = original.capacity;
        this.minLoadFactor = original.minLoadFactor;
        this.maxLoadFactor = original.maxLoadFactor;
        this.length = original.length;
        this.table = new LinkedListUnordered[capacity];
        for (int i = 0; i < capacity; i++) {
            LinkedListUnordered<Node> originalBucket = original.table[i];
            LinkedListUnordered<Node> newBucket = new LinkedListUnordered<>();
            LinkedListUnordered<Node>.Node current = originalBucket.getPrimeiro();
            while (current != null) {
                Node clonedNode = current.elemento.clone(); // Clona cada Node
                newBucket.addLast(clonedNode);
                current = current.proximo;
            }
            this.table[i] = newBucket;
        }
    }

    /**
     * Metodo clone para criar uma cópia profunda do HashMap.
     *
     * @return Uma nova instância de HashMapLinkedListUnordered clonada.
     */
    @Override
    public Object clone() {
        HashMapLinkedListUnordered<K, V> clone = null;
        try {
            clone = new HashMapLinkedListUnordered<>(this);
        } catch (Exception ignored) {}
        return clone;
    }
}
