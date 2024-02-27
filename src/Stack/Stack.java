package Stack;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

/*
 * 1- boolean empty(): Verifica se a pilha está vazia.
 * 2- E peek(): Retorna o elemento do topo da pilha sem removê-lo.
 * 3- E pop(): Desempilha e retorna o elemento do topo da pilha.
 * 4- E push(E item): Empilha um elemento no topo da pilha.
 * 5- int search(Object o): Retorna a posição baseada em 1 do elemento especificado na pilha.
 * 6- void clear(): Remove todos os elementos da pilha.
 * 7- int size(): Retorna o número de elementos na pilha.
 * 8- boolean contains(Object o): Verifica se a pilha contém o elemento especificado.
 * 9- Object[] toArray(): Retorna um array contendo todos os elementos da pilha.
 * 10- Enumeration<E> elements(): Retorna um iterador sobre os elementos da pilha.
 * 11- boolean remove(Object o): Remove a primeira ocorrência do elemento especificado da pilha, se presente.
 * 12- boolean removeAll(Collection<?> c): Remove todos os elementos da pilha que estão contidos na coleção especificada.
 * 13- boolean retainAll(Collection<?> c): Remove todos os elementos da pilha que não estão contidos na coleção especificada.
 * 14- Iterator<E> iterator(): Retorna um iterador sobre os elementos da pilha.
 * 15- ListIterator<E> listIterator(): Retorna um iterador de lista sobre os elementos da pilha.
 * 16- void add(int index, E element): Adiciona um elemento em uma posição específica da pilha.
 * 17- boolean addAll(Collection<? extends E> c): Adiciona todos os elementos da coleção especificada ao final da pilha.
 * 19- boolean removeAllElements(): Remove todos os elementos da pilha.
 * 20- E elementAt(int index): Retorna o elemento na posição especificada da pilha.
 * 21- E firstElement(): Retorna o primeiro elemento da pilha.
 * 22- E lastElement(): Retorna o último elemento da pilha. void insertElementAt(E obj, int index): Insere um elemento em uma posição específica da pilha.
 * 23- E remove(int index): Remove o elemento na posição especificada da pilha.
 * 24- boolean removeElement(Object obj): Remove a primeira ocorrência do elemento
 * 25- especificado da pilha, se presente.
 * 26- void removeAllElements(): Remove todos os elementos da pilha.
 * 27- void setSize(int newSize): Define o tamanho da pilha.
 * 28- String toString(): Retorna uma representação em string da pilha.
 */


public class Stack<X> implements Cloneable {


    // LIFO - Last in First Out
    private X[] data;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public Stack(int capInicial) throws IllegalArgumentException {

        if (capInicial < 1) throw new IllegalArgumentException();

        this.capacity = capInicial;
        this.data = (X[]) new Object[capInicial];
        this.size = 0;
    }

    // Empilha um elemento no topo da pilha.
    public void push(X x) throws Exception {

        if (x == null) throw new Exception("Falta o que guardar");

        if (this.isFull()) reziseUp();

        if (x instanceof Cloneable)
            this.data[size++] = meuCloneDeX(x);
        else
            this.data[size++] = x;

        while (this.size() < this.capacity)
            reziseDown();
    }

    // Retorna o elemento do topo da pilha sem removê-lo.
    public X peek() {

        if (isEmpty()) throw new EmptyStackException();

        X ret;
        if (this.data[size - 1] instanceof Cloneable)
            ret = meuCloneDeX(this.data[size - 1]);
        else
            ret = this.data[size - 1];

        return ret;
    }

    // Remove o elemento do topo da pilha.
    public X pop() {
        if (isEmpty())
            throw new NoSuchElementException();
        else {
            X ret;
            if (this.data[size - 1] instanceof Cloneable)
                ret = meuCloneDeX(this.data[size - 1]);
            else
                ret = this.data[size - 1];
            this.data[size - 1] = null;
            this.size--;
            return ret;
        }
    }

    @SuppressWarnings("unchecked")
    private void expand(float porct) {

        int newCapacity = (int) (capacity * Math.ceil(this.data.length * porct));

        X[] newStack = (X[]) new Object[newCapacity];

        if (this.size() >= 0) System.arraycopy(this.data, 0, newStack, 0, this.size());

        this.data = newStack;
        this.capacity = newCapacity;
    }

    @SuppressWarnings("unchecked")
    public void reziseUp() {
        int newCapacity = this.data.length + 1;

        X[] newStack = (X[]) new Object[newCapacity];

        if (this.size() >= 0) System.arraycopy(this.data, 0, newStack, 0, this.size());

        this.data = newStack;
        this.capacity = newCapacity;

    }

    @SuppressWarnings("unchecked")
    public void reziseDown() {
        int newCapacity = this.data.length - 1;

        X[] newStack = (X[]) new Object[newCapacity];

        if (this.size() >= 0) System.arraycopy(this.data, 0, newStack, 0, this.size());

        this.data = newStack;
        this.capacity = newCapacity;

    }

    public int size() {
        return this.size;
    }

    private boolean isFull() {
        return this.size == this.data.length;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public String popAll() {

        if (isEmpty()) {
            return "";
        }

        StringJoiner removidos = new StringJoiner(", ");
        while (!isEmpty()) {
            X data = pop();
            removidos.add(data.toString());
        }

        return removidos.toString();
    }

    @SuppressWarnings("unchecked")
    public Stack(Stack<X> pilha) throws Exception {

        if (pilha == null) {
            throw new NullPointerException("Não é possível copiar stack Nula.");
        }

        this.capacity = pilha.capacity;
        this.data = (X[]) new Object[capacity];
        this.size = 0;

        for (int i = 0; i < pilha.size; i++) {
            push(pilha.data[i]);
        }
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

    @SuppressWarnings("unchecked")
    public X meuCloneDeX(X x) {

        X ret = null;

        try {
            Class<?> classe = x.getClass();
            Class<?>[] tipoDosParms = null;
            Method metodo = classe.getMethod("clone", (Class<?>) null);
            Object[] parms = null;
            ret = (X) metodo.invoke(x, (Object[]) null);
        } catch (Exception ignored) {
        }
        return ret;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        Stack<?> other = (Stack<?>) obj;

        if (this.size != other.size)
            return false;

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

        hash = hash * prime + Integer.valueOf(this.size).hashCode();
        hash = prime * hash + Arrays.hashCode(Arrays.asList(this.data)
                .subList(0, this.size)
                .toArray());

        return hash;
    }


    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        try {
            return "[" + this.peek() + "]";
        } catch (Exception e) {
            return "[]";
        }
    }

    public String toArray() {
        if (isEmpty()) {
            return "[]";
        }
        return Arrays.toString(this.data);
    }

    // Remove todos os elementos da pilha.
    public void clear() {
        while (!isEmpty()) {
            this.pop();
        }
    }

    @SuppressWarnings("unchecked")
    // Remove todos os elementos da pilha.
    public void clear2() {
        this.data = (X[]) new Object[this.capacity];
    }

    // Retorna o primeiro elemento da pilha.
    public X firstElement() {
        // Retorna o primeiro elemento da pilha.
        if (this.isEmpty()) {
            throw new EmptyStackException();
        } else {
            return this.data[0];
        }
    }

    // Retorna o último elemento da pilha.
    public X lastElement() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        } else {
            return this.data[this.size - 1];
        }
    }

    // Retorna o elemento na posição especificada da pilha.
    public X elementAt(int index) {

        if (data[index] == null) {
            return null;
        } else {
            return data[index];
        }
    }

    // Retorna a posição baseada em 1 do elemento especificado na pilha.
    public int search(Object o) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(o)) {
                return i + 1;
            }
        }
        return -1;
    }

    // Retorna a posição baseada em 1 do elemento especificado na pilha.
    public boolean contains(Object o) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(o)) {
                return true;
            }
        }
        return false;
    }
}