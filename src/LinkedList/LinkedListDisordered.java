package LinkedList;
/*
extends LinkedList
1 - void add (int index, E element) Inserts the specified element at the specified position in this list.
2 - boolean add(E e) Appends the specified element to the end of this list.
3 - boolean addAll(int index, Collection<? extends E> c) Inserts all the elements in the specified collection into this list, starting at the specified position.
4 - boolean addAll(Collection<? extends E> c) Appends all the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator.
5 - void addFirst(E e) Inserts the specified element at the beginning of this list.
6 - void addLast(E e) Appends the specified element to the end of this list.
7 - void clear() Removes all of the elements from this list.
8 - Object clone() Returns a shallow copy of this LinkedList.
9 - boolean contains(Object o) Returns true if this list contains the specified element.
10 - Iterator<E> descendingIterator() Returns an iterator over the elements in this deque in reverse sequential order.
11 - E element() Retrieves, but does not remove, the head (first element) of this list.
12 - E get(int index) Returns the element at the specified position in this list.
13 - E getFirst() Returns the first element in this list.
14 - E getLast() Returns the last element in this list.
15 - int indexOf(Object o) Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
16 - int lastIndexOf(Object o) Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
17 - ListIterator<E> listIterator(int index) Returns a list-iterator of the elements in this list (in the proper sequence), starting at the specified position in the list.
18 - boolean offer(E e) Adds the specified element as the tail (last element) of this list.
19 - boolean offerFirst(E e) Inserts the specified element at the front of this list.
20 - boolean offerLast(E e) Inserts the specified element at the end of this list.
21 - E peek() Retrieves, but does not remove, the head (first element) of this list.
22 - E peekFirst() Retrieves, but does not remove the first element of this list, or returns null if this list is empty.
23 - E peekLast() Retrieves, but does not remove the last element of this list, or returns null if this list is empty.
24 - E poll() Retrieves and removes the head (first element) of this list.
25 - E pollFirst() Retrieves and removes the first element of this list, or returns null if this list is empty.
26 - E pollLast() Retrieves and removes the last element of this list, or returns null if this list is empty.
27 - E pop() Pops an element from the stack represented by this list.
28 - void push(E e) Pushes an element onto the stack represented by this list.
29 - E remove() Retrieves and removes the head (first element) of this list.
30 - E remove(int index) Removes the element at the specified position in this list.
31 - boolean remove(Object o) Removes the first occurrence of the specified element from this list, if it is present.
32 - E removeFirst() Removes and returns the first element from this list.
33 - boolean removeFirstOccurrence(Object o) Removes the first occurrence of the specified element in this list (when traversing the list from head to tail).
34 - E removeLast() Removes and returns the last element from this list.
35 - boolean removeLastOccurrence(Object o) Removes the last occurrence of the specified element in this list (when traversing the list from head to tail).
36 - LinkedList<E> reversed() Returns a reverse-ordered view of this collection.
37 - E set (int index, E element) Replaces the element at the specified position in this list with the specified element.
38 - int size() Returns the number of elements in this list.
39 - Spliterator<E> spliterator() Creates a late-binding and fail-fast Spliterator over the elements in this list.
40 - Object[] toArray() Returns an array containing all the elements in this list in the proper sequence (from first to a last element).
41 - <T> T[] toArray(T[] a) Returns an array containing all the elements in this list in proper sequences (from first to a last element); the runtime type of the returned array is that of the specified array.
 */

import java.util.Comparator;
import java.util.Objects;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class LinkedListDisordered<X> implements Cloneable {

    public class Node implements Cloneable {

        public X elemento;
        public Node proximo;

        public Node() {
        }

        public Node(X valor) {
            this.elemento = valor;
            this.proximo = null;
        }

        public Node(X valor, Node proximo) {
            this.elemento = valor;
            this.proximo = proximo;
        }

        public X getElemento() {
            return elemento;
        }

        public Node getProximo() {
            return proximo;
        }

        @SuppressWarnings("unchecked")
        public Node(Node modelo) throws Exception {
            if (modelo == null) throw new Exception("Nó não pode ser nulo");

            this.elemento = (X) verifyAndCopy(modelo.elemento);
            this.proximo = (Node) verifyAndCopy(modelo.proximo);
        }

        @Override
        public Object clone() {
            Node clone = null;

            try {
                clone = new Node(this);
            } catch (Exception ignored) {
            }

            return clone;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int hash = 1;

            hash *= prime + ((this.elemento == null) ? 0 : this.elemento.hashCode());

            if (hash < 0) hash = -hash;

            return hash;
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean equals(Object obj) {

            if (this == obj) return true;
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;

            Node other = (Node) obj;

            return Objects.equals(this.elemento, other.elemento);
        }

        @Override
        public String toString() {
            if (this.proximo != null)
                return "Node{data=" + this.elemento + ", next=" + this.proximo.elemento + "}";
            else
                return "Node{data=" + this.elemento + ", next=null}";
        }
    }

    private Node primeiro;
    private int tamanho;

    public LinkedListDisordered() {
    }

    public void addFirst(X elemento) {
        if (elemento == null) throw new IllegalArgumentException("Valor não pode ser nulo");

        // Cria um novo nó com o elemento fornecido
        Node novo = new Node(elemento);

        novo.proximo = primeiro;  // Define o próximo nó do novo nó como o atual primeiro nó da lista
        primeiro = novo;// Atualiza o primeiro nó da lista para ser o novo nó

        tamanho++;
    }

    public void addLast(X elemento) {
        if (elemento == null) throw new IllegalArgumentException("Valor não pode ser nulo");

        Node novo = new Node(elemento);

        // Se a lista estiver vazia, define o novo nó como o primeiro nó da lista
        if (primeiro == null) {
            primeiro = novo;
        } else {
            Node aux = primeiro; // Se a lista não estiver vazia, encontra o último nó e adiciona o novo nó após ele
            while (aux.proximo != null)
                aux = aux.proximo;
            aux.proximo = novo;
        }
        tamanho++;
    }

    public void remove(X elemento) {
        if (primeiro == null) throw new IllegalStateException("Lista vazia");

        // Verifica se o elemento a ser removido está no primeiro nó da lista
        if (primeiro.elemento.equals(elemento)) {
            primeiro = primeiro.proximo; // Se sim, atualiza o primeiro nó para ser o próximo nó da lista
            tamanho--;
            return;
        }

        // Caso contrário, percorre a lista para encontrar o nó a ser removido
        Node aux = primeiro;
        while (aux.proximo != null) {
            // Verifica se o próximo nó contém o elemento a ser removido
            if (aux.proximo.elemento.equals(elemento)) {
                aux.proximo = aux.proximo.proximo; // Se sim, atualiza o próximo nó para apontar para o nó seguinte
                tamanho--; // Decrementa o tamanho da lista
                return;
            }
            aux = aux.proximo; // Move para o próximo nó na lista
        }
    }

    public void removeFirst() {
        if (primeiro == null) throw new IllegalStateException("Lista vazia");

        // Atualiza o primeiro nó para ser o próximo nó da lista
        primeiro = primeiro.proximo;

        tamanho--;
    }

    public void removeLast() {
        if (primeiro == null) throw new IllegalStateException("Lista vazia");

        // Verifica se há apenas um nó na lista
        if (primeiro.proximo == null) {
            primeiro = null; // Se sim, define o primeiro nó como nulo
        } else {
            // Se houver mais de um nó na lista, encontra o penúltimo nó
            Node aux = primeiro;
            while (aux.proximo.proximo != null) {
                aux = aux.proximo;
            }
            aux.proximo = null; // Define o próximo nó do penúltimo como nulo, removendo o último nó
        }

        tamanho--;
    }


    public boolean contains(X valor) {
        Node aux = primeiro;

        // Percorre a lista enquanto houver nós
        while (aux != null) {
            // Verifica se o elemento do nó atual é igual ao valor procurado
            if (aux.elemento.equals(valor))
                return true; // Se sim, retorna verdadeiro

            aux = aux.proximo; // Move para o próximo nó na lista
        }

        return false;
    }

    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    public X get(int index) {
        if (index < 0 || index >= this.tamanho) throw new IndexOutOfBoundsException("Index out of bounds");

        // Inicia a busca a partir do primeiro nó
        Node aux = primeiro;

        // Percorre a lista até o índice especificado
        for (int i = 0; i < index; i++)
            aux = aux.proximo;

        return aux.elemento; // Retorna o elemento do nó encontrado
    }

    public X getFirst() {
        if (primeiro == null) throw new IllegalStateException("Lista vazia");

        return primeiro.elemento; // Retorna o elemento do primeiro nó da lista
    }

    public X getLast() {
        if (primeiro == null)
            throw new IllegalStateException("Lista vazia");

        Node aux = primeiro; // Inicia a busca pelo último nó a partir do primeiro nó

        // Percorre a lista até encontrar o último nó
        while (aux.proximo != null)
            aux = aux.proximo;

        return aux.elemento; // Retorna o elemento do último nó encontrado
    }

    public void clear() {
        primeiro = null;
        tamanho = 0;
    }

    public void reverse() {
        if (primeiro == null || primeiro.proximo == null) return;

        // Inicializa os nós para a reversão
        Node anterior = null; // Nó anterior é inicializado como nulo
        Node atual = primeiro; // O nó atual é inicializado com o primeiro nó da lista
        Node proximoNo; // Variável temporária para armazenar o próximo nó

        // Percorre a lista, invertendo os ponteiros dos nós
        while (atual != null) {
            proximoNo = atual.proximo; // Salva o próximo nó
            atual.proximo = anterior;  // Inverte o ponteiro para o nó anterior
            anterior = atual;       // Atualiza o nó anterior para o nó atual
            atual = proximoNo;      // Atualiza o nó atual para o próximo nó
        }

        primeiro = anterior; // Atualiza o ponteiro da cabeça para o último nó (que era o primeiro nó)
    }

    public void rotate(int passos) {

        if (primeiro == null || primeiro.proximo == null)
            return;// Verifica se a lista está vazia ou contém apenas um elemento, se sim, não há necessidade de fazer rotação

        passos = passos % tamanho; // Calcula o número de passos necessários com base no tamanho da lista
        if (passos < 0)
            passos = tamanho + passos; // Se o número de passos for negativo, calcula o número de passos no sentido inverso
        if (passos == 0) return; // Se o número de passos for 0, não há necessidade de fazer rotação

        Node aux = primeiro; // Inicializa um nó auxiliar para percorrer a lista até a posição antes dos nós a serem rotacionados
        for (int i = 0; i < tamanho - passos - 1; i++)
            aux = aux.proximo;

        Node novoHead = aux.proximo; // Salva o novo nó de cabeça (novoHead) após os passos especificados
        aux.proximo = null; // Remove a conexão entre os nós antigos e o novoHead para criar duas listas independentes
        aux = novoHead; // Move aux para o último nó da segunda parte da lista original

        while (aux.proximo != null)
            aux = aux.proximo;

        aux.proximo = primeiro; // Conecta o último nó da segunda parte da lista original ao primeiro nó da primeira parte
        primeiro = novoHead; // Atualiza o primeiro nó da lista para ser o novoHead, realizando assim a rotação
    }

    public void sort(Comparator<X> comparador) {
        if (primeiro == null || primeiro.proximo == null) return;

        Node current = primeiro; // Inicializa o nó atual como o primeiro nó da lista
        Node index; // Nó para percorrer a lista a partir do nó atual
        X temp; // Variável temporária para trocar elementos durante a ordenação

        // Percorre a lista para realizar a ordenação
        while (current != null) {
            index = current.proximo; // Define o nó índice para começar a busca pelo próximo nó

            // Percorre a lista a partir do próximo nó do nó atual
            while (index != null) {
                // Compara os elementos dos nós atual e índice usando o comparador fornecido
                if (comparador.compare(current.elemento, index.elemento) > 0) {
                    // Se o elemento do nó atual for maior do que o elemento do nó índice, troca os elementos
                    temp = current.elemento;
                    current.elemento = index.elemento;
                    index.elemento = temp;
                }
                index = index.proximo; // Move para o próximo nó na lista
            }
            current = current.proximo; // Move para o próximo nó na lista
        }
    }

    @SuppressWarnings("unchecked")
    public void sort() {
        // Verifica se a lista está vazia ou contém apenas um elemento, se sim, não há necessidade de ordenação
        if (primeiro == null || primeiro.proximo == null) return;

        Node atual = primeiro; // Inicializa o nó atual como o primeiro nó da lista
        Node indice; // Nó para percorrer a lista a partir do nó atual
        X temp; // Variável temporária para trocar elementos durante a ordenação

        // Percorre a lista para realizar a ordenação
        while (atual != null) {
            indice = atual.proximo; // Define o nó índice para começar a busca pelo próximo nó

            // Percorre a lista a partir do próximo nó do nó atual
            while (indice != null) {
                // Compara os elementos dos nós atual e índice usando compareTo
                if (((Comparable<X>) atual.elemento).compareTo(indice.elemento) > 0) {
                    // Se o elemento do nó atual for maior do que o elemento do nó índice, troca os elementos
                    temp = atual.elemento;
                    atual.elemento = indice.elemento;
                    indice.elemento = temp;
                }
                indice = indice.proximo; // Move para o próximo nó na lista
            }
            atual = atual.proximo; // Move para o próximo nó na lista
        }
    }

    public void shuffle() {
        if (primeiro == null || primeiro.proximo == null) return;

        Node atual = primeiro; // Inicializa o nó atual como o primeiro nó da lista
        Node indice;// Nó para percorrer a lista a partir do nó atual
        X temp; // Variável temporária para trocar elementos durante o embaralhamento

        int indiceAleatorio; // Variável para armazenar um índice aleatório (0 ou 1)

        // Percorre a lista para realizar o embaralhamento
        while (atual != null) {
            indice = atual.proximo;// Define o nó índice para começar a busca pelo próximo nó

            // Percorre a lista a partir do próximo nó do nó atual
            while (indice != null) {
                indiceAleatorio = (int) (Math.random() * 1000) % 2; // Gera um índice aleatório (0 ou 1)

                // Se o índice aleatório for 0, troca os elementos entre o nó atual e o nó índice
                if (indiceAleatorio == 0) {
                    temp = atual.elemento;
                    atual.elemento = indice.elemento;
                    indice.elemento = temp;
                }

                indice = indice.proximo; // Move para o próximo nó na lista
            }
            atual = atual.proximo; // Move para o próximo nó na lista
        }
    }

    public Node getPrimeiro() {
        return primeiro;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    @SuppressWarnings("unchecked")
    public LinkedListDisordered(LinkedListDisordered<X> other) {
        if (other == null) throw new IllegalArgumentException("Lista não pode ser nula");

        if (other.primeiro == null) {
            this.primeiro = null;
            this.tamanho = 0;
            return;
        }

        Node aux = other.primeiro;
        Node copy = new Node((X) verifyAndCopy(aux.elemento));
        primeiro = copy;

        while (aux.proximo != null) {
            aux = aux.proximo;
            copy.proximo = new Node((X) verifyAndCopy(aux.elemento));
            copy = copy.proximo;
        }

        tamanho = other.tamanho;
    }

    @Override
    public Object clone() {
        LinkedListDisordered<X> clone = null;

        try {
            clone = new LinkedListDisordered<>(this);
        } catch (Exception ignored) {
        }

        return clone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        Node aux = this.primeiro;

        while (aux != null) {
            hash *= prime + ((aux.elemento == null) ? 0 : aux.elemento.hashCode());
            aux = aux.proximo;
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

        LinkedListDisordered<X> that = (LinkedListDisordered<X>) obj;

        if (this.tamanho != that.tamanho) return false;

        Node thisNode = this.primeiro;
        Node thatNode = that.primeiro;

        while (thisNode != null && thatNode != null) {
            if (!Objects.equals(thisNode.elemento, thatNode.elemento)) return false;
            thisNode = thisNode.proximo;
            thatNode = thatNode.proximo;
        }

        return thisNode == null &&
                thatNode == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node aux = primeiro;
        while (aux != null) {
            sb.append(aux.elemento);
            if (aux.proximo != null)
                sb.append(" -> ");
            aux = aux.proximo;
        }
        sb.append("]");
        return sb.toString();
    }
}