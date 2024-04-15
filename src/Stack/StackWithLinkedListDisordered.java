package Stack;

import LinkedList.Disordered.LinkedListDisordered;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Objects;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class StackWithLinkedListDisordered<X> implements Cloneable {

    // LIFO - Last In First Out
    private LinkedListDisordered<X> elemento;
    private int tamanho;
    private int capacidade;

    public StackWithLinkedListDisordered() {
        this.elemento = new LinkedListDisordered<>();
        this.capacidade = 100;
        this.tamanho = 0;
    }
    public StackWithLinkedListDisordered(int capacidade) {
        if (capacidade <= 0) throw new IllegalArgumentException("Capacidade inválida");

        this.elemento = new LinkedListDisordered<>();
        this.capacidade = capacidade;
        this.tamanho = 0;
    }
    public int getTamanho() {
        return tamanho;
    }
    public int getCapacidade() {
        return capacidade;
    }
    public LinkedListDisordered<X> getElemento() {
        return elemento;
    }

    public X push(X item) {
        if (this.tamanho == this.capacidade) throw new StackOverflowError();

        // Adiciona o item no início da lista(Utilizando o método addFirst da LinkedListDisordered)
        this.elemento.addFirst(item);
        this.tamanho++;

        return item;
    }

    public X peek() {
        if (isEmpty()) throw new EmptyStackException();

        // Retorna o primeiro elemento da lista(Utilizando o método getFirst da LinkedListDisordered)
        return this.elemento.getFirst();
    }

    public X pop() {
        if (isEmpty()) throw new EmptyStackException();

        // Remove o primeiro elemento da lista(Utilizando o método removeFirst da LinkedListDisordered)
        X elemento = this.elemento.getFirst();
        this.elemento.removeFirst();
        this.tamanho--;

        return elemento;
    }

    public X peekLast() {
        if (isEmpty()) throw new EmptyStackException();
        return this.elemento.getLast();
    }

    public int search(X item) {
        if (isEmpty()) throw new EmptyStackException();

        int index = 1;
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elemento.get(i).equals(item)) {
                return index;
            }
            index++;
        }

        return -1;
    }

    public int indexOf(X item) {
        if (isEmpty()) throw new EmptyStackException();

        for (int i = 0; i < this.tamanho; i++) {
            if (this.elemento.get(i).equals(item)) {
                return i;
            }
        }

        return -1;
    }

    public int lastIndexOf(X item) {
        if (isEmpty()) throw new EmptyStackException();

        int lastIndex = -1;
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elemento.get(i).equals(item)) {
                lastIndex = i;
            }
        }

        return lastIndex;
    }

    public int firstIndexOf(X item) {
        return indexOf(item);
    }

    public boolean contains(X item) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elemento.get(i).equals(item)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    public boolean isFull() {
        return this.tamanho == this.capacidade;
    }

    public void clear() {
        this.elemento.clear();
        this.tamanho = 0;
    }

    public String toArray() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.tamanho; i++) {
            sb.append(this.elemento.get(i));
            if (i < this.tamanho - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public List<X> toList() {
        List<X> list = new ArrayList<>(tamanho);
        for (int i = 0; i < this.tamanho; i++)
            list.add(this.elemento.get(i));
        return list;
    }

    public Object[] toArray(Object[] array) {
        if (array == null) throw new IllegalArgumentException("Array ausente");
        if (array.length < this.tamanho) throw new IllegalArgumentException("Array menor que o tamanho da pilha");

        for (int i = 0; i < this.tamanho; i++)
            array[i] = verifyAndCopy(this.elemento.get(i));

        return array;
    }

    @SuppressWarnings("unchecked")
    public StackWithLinkedListDisordered(StackWithLinkedListDisordered<X> modelo) {
        if (modelo == null) throw new IllegalArgumentException("Modelo ausente");

        this.elemento = new LinkedListDisordered<>();
        this.capacidade = (int) verifyAndCopy(modelo.capacidade);

        for (int i = 0; i < modelo.tamanho; i++)
            this.elemento.addLast((X) verifyAndCopy(modelo.elemento.get(i)));

        this.tamanho = (int) verifyAndCopy(modelo.tamanho);
    }

    @Override
    public Object clone() {
        StackWithLinkedListDisordered<X> clone = null;
        try {
            clone = new StackWithLinkedListDisordered<X>(this);
        } catch (Exception ignored) {
        }
        return clone;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        StackWithLinkedListDisordered<?> other = (StackWithLinkedListDisordered<?>) obj;

        if (this.tamanho != other.tamanho) return false;
        if (this.capacidade != other.capacidade) return false;

        for (int i = 0; i < this.tamanho; i++) {
            if (!this.elemento.get(i).equals(other.elemento.get(i)))
                return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + this.tamanho;
        hash *= prime + this.capacidade;

        for (int i = 0; i < this.tamanho; i++)
            hash *= prime + Objects.hashCode(this.elemento.get(i));

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        else return "[" + this.peek() + "]";
    }
}
/*
 * 1 - boolean empty(): Verifica se a pilha está vazia.
 * 2 - E peek(): Retorna o elemento do topo da pilha sem removê-lo.
 * 3 - E pop(): Desempilha e retorna o elemento do topo da pilha.
 * 4 - E push(E item): Empilha um elemento no topo da pilha.
 * 5 - int search(Object o): Retorna a posição baseada em 1 do elemento especificado na pilha.
 * 6 - void clear(): Remove todos os elementos da pilha.
 * 7 - int size(): Retorna o número de elementos na pilha.
 * 8 - boolean contains(Object o): Verifica se a pilha contém o elemento especificado.
 * 9 - Object[] toArray(): Retorna um array contendo todos os elementos da pilha.
 * 10 - Enumeration<E> elements(): Retorna um iterador sobre os elementos da pilha.
 * 11 - boolean remove(Object o): Remove a primeira ocorrência do elemento especificado da pilha, se presente.
 * 12 - boolean removeAll(Collection<?> c): Remove todos os elementos da pilha que estão contidos na coleção especificada.
 * 13 - boolean retainAll(Collection<?> c): Remove todos os elementos da pilha que não estão contidos na coleção especificada.
 * 14 - Iterator<E> iterator(): Retorna um iterador sobre os elementos da pilha.
 * 15 - ListIterator<E> listIterator(): Retorna um iterador de lista sobre os elementos da pilha.
 * 16 - void add(int index, E element): Adiciona um elemento em uma posição específica da pilha.
 * 17 - boolean addAll(Collection<? extends E> c): Adiciona todos os elementos da coleção especificada ao final da pilha.
 * 19 - boolean removeAllElements(): Remove todos os elementos da pilha.
 * 20 - E elementAt(int index): Retorna o elemento na posição especificada da pilha.
 * 21 - E firstElement(): Retorna o primeiro elemento da pilha.
 * 22 - E lastElement(): Retorna o último elemento da pilha. void insertElementAt(E obj, int index): Insere um elemento em uma posição específica da pilha.
 * 23 - E remove(int index): Remove o elemento na posição especificada da pilha.
 * 24 - boolean removeElement(Object obj): Remove a primeira ocorrência do elemento especificado da pilha.
 * 26 - void removeAllElements(): Remove todos os elementos da pilha.
 * 27 - void setSize(int newSize): Define o tamanho da pilha.
 * 28 - String toString(): Retorna uma representação em string da pilha.
 */