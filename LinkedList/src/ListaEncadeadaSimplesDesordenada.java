/*
 * add(E element): Adiciona um elemento ao final da lista.
 * add(int index, E element): Adiciona um elemento em uma posição específica da lista.
 * addAll(Collection<? extends E> collection): Adiciona todos os elementos de uma coleção ao final da lista.
 * addAll(int index, Collection<? extends E> collection): Adiciona todos os
 * elementos de uma coleção em uma posição específica da lista.
 * addFirst(E element): Adiciona um elemento no início da lista.
 * addLast(E element): Adiciona um elemento no final da lista.
 * clear(): Remove todos os elementos da lista.
 * clone(): Cria uma cópia superficial da lista.
 * contains(Object element): Verifica se a lista contém o elemento especificado.
 * descendingIterator(): Retorna um iterador sobre os elementos da lista em ordem descendente.
 * element(): Retorna o primeiro elemento da lista.
 * get(int index): Retorna o elemento na posição especificada na lista.
 * getFirst(): Retorna o primeiro elemento da lista.
 * getLast(): Retorna o último elemento da lista.
 * indexOf(Object element): Retorna o índice da primeira ocorrência do elemento especificado na lista.
 * lastIndexOf(Object element): Retorna o índice da última ocorrência do
 * elemento especificado na lista.
 * listIterator(): Retorna um iterador sobre os elementos da lista (em ordem crescente).
 * offer(E element): Adiciona um elemento ao final da lista.
 * offerFirst(E element): Adiciona um elemento no início da lista.
 * offerLast(E element): Adiciona um elemento no final da lista.
 * peek(): Retorna o primeiro elemento da lista sem removê-lo.
 * peekFirst(): Retorna o primeiro elemento da lista sem removê-lo.
 * peekLast(): Retorna o último elemento da lista sem removê-lo.
 * poll(): Retorna e remove o primeiro elemento da lista.
 * pollFirst(): Retorna e remove o primeiro elemento da lista.
 * pollLast(): Retorna e remove o último elemento da lista.
 * pop(): Remove e retorna o primeiro elemento da lista.
 * push(E element): Insere um elemento no início da lista.
 * remove(Object element): Remove a primeira ocorrência do elemento especificado da lista, se presente.
 * remove(int index): Remove o elemento na posição especificada na lista.
 * removeFirst(): Remove o primeiro elemento da lista.
 * removeFirstOccurrence(Object element): Remove a primeira ocorrência do elemento especificado da lista, se presente.
 * removeLast(): Remove o último elemento da lista.
 * removeLastOccurrence(Object element): Remove a última ocorrência do elemento especificado da lista, se presente.
 * size(): Retorna o número de elementos na lista.
 * toArray(): Retorna um array contendo todos os elementos da lista.
 * toArray(T[] array): Retorna um array contendo todos os elementos da lista, com o tipo especificado.
 */
package LinkedList.src;

import java.util.Objects;

public class ListaEncadeadaSimplesDesordenada<X> implements Cloneable {

    public class Node implements Cloneable {

        public X data;
        public Node next;

        public Node(X valor) {
            this.data = valor;
            this.next = null;
        }

        public Node(X valor, Node next) {
            this.data = valor;
            this.next = next;
        }

        public X getData() {
            return data;
        }
        public void setData(X data) {
            this.data = data;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }

        public Node(Node other) {
            this.data = other.data;
            this.next = other.next;
        }
        
        @Override
        public final int hashCode() {
            final int prime = 31;
            int hash = 1;

            hash = prime * hash + ((this.data == null) ? 0 : this.data.hashCode());

            if (hash < 0) hash = -hash;

            return hash;
        }

        @Override
        @SuppressWarnings("unchecked")
        public final boolean equals(Object obj) {

            if (this == obj) return true;
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;

            Node other = (Node) obj;

            return Objects.equals(this.data, other.data);
        }

        
        @Override
        public final Object clone() {
            Node clone = null;

            try {
                clone = new Node(this);
            } catch (Exception ignored) {
            }

            return clone;
        }

        @Override
        public final String toString() {
            if (this.next != null)
                return "Node{data=" + this.data + ", next=" + this.next.data + "}";
            else
                return "Node{data=" + this.data + ", next=null}";
        }

    }

    private Node head;
    private final int size;

    public ListaEncadeadaSimplesDesordenada() {
        this.head = null;
        this.size = 0;
    }

    public void addFirst(X data) {
        if (data == null) throw new IllegalArgumentException("Valor não pode ser nulo");

        Node novo = new Node(data);
        novo.next = head;
        head = novo;
    }

    public void removeFirst() {
        if (head == null) 
            throw new IllegalStateException("Lista vazia");
        
        head = head.next;
    }

    public void addLast(X valor) {
        if (valor == null) throw new IllegalArgumentException("Valor não pode ser nulo");

        Node novo = new Node(valor);
        Node aux = head;
        if (aux == null) {
            head = novo;
        } else {
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = novo;
        }
    }

    public void removeLast() {
        if (head == null)
            throw new IllegalStateException("Lista vazia");

        if (head.next == null) {
            head = null;
        } else {
            Node aux = head;
            while (aux.next.next != null) {
                aux = aux.next;
            }
            aux.next = null;
        }
    }

    public void add(X valor) {
        Node novo = new Node(valor);
        Node aux = head;
        if (aux == null) {
            head = novo;
        } else {
            while (aux.next != null) {
                aux = aux.getNext();
            }
            aux.next = novo;
        }
    }

    public boolean contains(X valor) {
        Node aux = head;
        while (aux != null) {
            if (aux.data.equals(valor)) {
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    public X getFirst() {
        if (head == null)
            throw new IllegalStateException("Lista vazia");

        return head.data;
    }

    public X getLast() {
        if (head == null)
            throw new IllegalStateException("Lista vazia");

        Node aux = head;
        while (aux.next != null) {
            aux = aux.next;
        }

        return aux.data;
    }

    public X get(int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException("Index out of bounds");

        Node aux = head;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }

        return aux.data;
    }

    public void clear() {
        head = null;
    }

    public ListaEncadeadaSimplesDesordenada(ListaEncadeadaSimplesDesordenada<X> other) {
        this.head = other.head;
        this.size = other.size;
    }

    @Override
    public Object clone() {
        ListaEncadeadaSimplesDesordenada<X> clone = null;

        try {
            clone = new ListaEncadeadaSimplesDesordenada<>(this);
        } catch (Exception ignored) {
        }

        return clone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        Node aux = head;
        while (aux != null) {
            hash *= prime + ((aux.data == null) ? 0 : aux.data.hashCode());
            aux = aux.next;
        }

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        ListaEncadeadaSimplesDesordenada<X> other = (ListaEncadeadaSimplesDesordenada<X>) obj;

        if (this.size != other.size) return false;

        Node aux1 = this.head;
        Node aux2 = other.head;

        while (aux1 != null) {
            if (!aux1.equals(aux2)) return false;
            aux1 = aux1.next;
            aux2 = aux2.next;
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node aux = head;
        while (aux != null) {
            sb.append(aux.data);
            if (aux.next != null) {
                sb.append(" -> ");
            }
            aux = aux.next;
        }
        sb.append("]");
        return sb.toString();
    }
}