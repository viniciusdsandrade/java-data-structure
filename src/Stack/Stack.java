package Stack;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

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
 * 24 - boolean removeElement(Object obj): Remove a primeira ocorrência do elemento
 * 25 - especificado da pilha, se presente.
 * 26 - void removeAllElements(): Remove todos os elementos da pilha.
 * 27 - void setSize(int newSize): Define o tamanho da pilha.
 * 28 - String toString(): Retorna uma representação em string da pilha.
 */

// LIFO - last-in-first-out
public class Stack<X> implements Cloneable {

    private X[] data;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public Stack() {
        this.capacity = 10;
        this.data = (X[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public Stack(int capInicial) throws IllegalArgumentException {

        if (capInicial < 1) throw new IllegalArgumentException();

        this.capacity = capInicial;
        this.data = (X[]) new Object[capInicial];
        this.size = 0;
    }

    public void push(X x) {
        if (x == null) throw new IllegalArgumentException("Não é possível adicionar elemento nulo.");

        if (isFull()) resizeUp();

        this.data[this.size++] = x;

        while (this.size < this.capacity)
            resizeDown();
    }

    @SuppressWarnings("unchecked")
    public X peek() {

        if (isEmpty()) throw new EmptyStackException();

        X ret;
        ret = (X) verifyAndCopy(this.data[this.size - 1]);

        return ret;
    }

    @SuppressWarnings("unchecked")
    public X pop() {

        if (isEmpty()) throw new EmptyStackException();

        X ret;
        ret = (X) verifyAndCopy(this.data[this.size - 1]);

        this.data[this.size - 1] = null;
        this.size--;

        while (this.size < this.capacity) resizeDown();

        return ret;
    }

    @SuppressWarnings("unchecked")
    public void resizeUp() {
        int newCapacity = this.data.length + 1;
        X[] newData = (X[]) new Object[newCapacity];

        for (int i = 0; i < this.size; i++)
            newData[i] = (X) verifyAndCopy(this.data[i]);

        this.data = newData;
        this.capacity = newCapacity;
    }

    @SuppressWarnings("unchecked")
    public void resizeDown() {
        int newCapacity = this.data.length - 1;
        X[] newData = (X[]) new Object[newCapacity];

        for (int i = 0; i < this.size; i++)
            newData[i] = (X) verifyAndCopy(this.data[i]);

        this.data = newData;
        this.capacity = newCapacity;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    private boolean isFull() {
        return this.size == this.data.length;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        for (int i = 0; i < this.size; i++)
            this.data[i] = null;

        this.size = 0;
    }

    public X firstElement() {

        if (isEmpty()) throw new EmptyStackException();

        return this.data[0];
    }

    public X lastElement() {

        if (isEmpty()) throw new EmptyStackException();

        return this.data[this.size - 1];
    }

    public X elementAt(int index) {

        if (data[index] == null) throw new NoSuchElementException();

        return this.data[index];
    }

    public int search(Object o) {

        if (o == null) throw new NullPointerException();

        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(o))
                return i + 1;
        }

        return -1;
    }

    public boolean contains(Object o) {

        if (o == null) throw new NullPointerException();

        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(o))
                return true;
        }

        return false;
    }

    public boolean remove(Object o) {

        if (o == null) throw new NullPointerException();

        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(o)) {
                this.data[i] = null;
                this.size--;
                return true;
            }
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    public Stack(Stack<X> pilha) {

        if (pilha == null) throw new NullPointerException("Não é possível copiar stack Nula.");

        this.capacity = (int) verifyAndCopy(pilha.capacity);
        this.data = (X[]) new Object[capacity];
        this.size = 0;

        for (int i = 0; i < pilha.size; i++)
            push((X) verifyAndCopy(pilha.data[i]));
    }

    @Override
    public Object clone() {

        Stack<X> clone = null;

        try {
            clone = new Stack<X>(this);
        } catch (Exception ignored) {
        }

        return clone;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Stack<?> other = (Stack<?>) obj;

        if (this.size != other.size) return false;

        for (int i = 0; i < this.size; i++) {
            if (!this.data[i].equals(other.data[i]))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 13;
        int hash = 1;

        hash *= prime + Integer.valueOf(this.size).hashCode();
        for (int i = 0; i < this.size; i++)
            hash *= prime + this.data[i].hashCode();

        return hash;
    }

    public Object[] toArrayObject() {
        return Arrays.copyOf(this.data, this.size);
    }

    public String toArray() {
        if (isEmpty()) return "[]";

        return Arrays.toString(this.data);
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";

        try {
            return "[" + this.peek() + "]";
        } catch (Exception e) {
            return "[]";
        }
    }
}