package Stack;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.StringJoiner;


public class Stack<X> implements Comparable<Stack<X>>, Cloneable {

    /*
     * boolean empty(): Verifica se a pilha está vazia.
     * E peek(): Retorna o elemento do topo da pilha sem removê-lo.
     * E pop(): Desempilha e retorna o elemento do topo da pilha.
     * E push(E item): Empilha um elemento no topo da pilha.
     * int search(Object o): Retorna a posição baseada em 1 do elemento especificado
     * na pilha.
     * void clear(): Remove todos os elementos da pilha.
     * int size(): Retorna o número de elementos na pilha.
     * boolean contains(Object o): Verifica se a pilha contém o elemento
     * especificado.
     * Object[] toArray(): Retorna um array contendo todos os elementos da pilha.
     * Enumeration<E> elements(): Retorna um iterador sobre os elementos da pilha.
     * boolean remove(Object o): Remove a primeira ocorrência do elemento
     * especificado da pilha, se presente.
     * boolean removeAll(Collection<?> c): Remove todos os elementos da pilha que
     * estão contidos na coleção especificada.
     * boolean retainAll(Collection<?> c): Remove todos os elementos da pilha que
     * não estão contidos na coleção especificada.
     * Iterator<E> iterator(): Retorna um iterador sobre os elementos da pilha.
     * ListIterator<E> listIterator(): Retorna um iterador de lista sobre os
     * elementos da pilha.
     * void add(int index, E element): Adiciona um elemento em uma posição
     * específica da pilha.
     * boolean addAll(Collection<? extends E> c): Adiciona todos os elementos da
     * coleção especificada ao final da pilha.
     * boolean removeAllElements(): Remove todos os elementos da pilha.
     * E elementAt(int index): Retorna o elemento na posição especificada da pilha.
     * E firstElement(): Retorna o primeiro elemento da pilha.
     * E lastElement(): Retorna o último elemento da pilha.
     * void insertElementAt(E obj, int index): Insere um elemento em uma posição
     * específica da pilha.
     * E remove(int index): Remove o elemento na posição especificada da pilha.
     * boolean removeElement(Object obj): Remove a primeira ocorrência do elemento
     * especificado da pilha, se presente.
     * void removeAllElements(): Remove todos os elementos da pilha.
     * void setSize(int newSize): Define o tamanho da pilha.
     * String toString(): Retorna uma representação em string da pilha.
     */

    // LIFO - Last in First Out
    private X[] data;
    private int tamanho;
    private int capacidade;

    @SuppressWarnings("unchecked")
    public Stack(int capInicial) throws IllegalArgumentException {

        if (capInicial < 1) {
            throw new IllegalArgumentException();
        }
        this.capacidade = capInicial;
        this.data = (X[]) new Object[capInicial];
        this.tamanho = 0;
    }

    public void push(X x) throws Exception {

        if (x == null)
            throw new Exception("Falta o que guardar");

        if (this.isFull()) {
            this.expandirPilha(2.0f);
        }
        if (x instanceof Cloneable)
            this.data[tamanho++] = (X) meuCloneDeX(x);
        else
            this.data[tamanho++] = (X) x;

    }

    public X peek() throws Exception {

        if (isEmpty())
            throw new EmptyStackException();

        X ret = null;
        if (this.data[tamanho - 1] instanceof Cloneable)
            ret = (X) meuCloneDeX((X) this.data[tamanho - 1]);
        else
            ret = (X) this.data[tamanho - 1];

        return (X) ret;
    }

    public X pop() {
        if (isEmpty())
            throw new EmptyStackException();
        else {
            X ret = null;
            if (this.data[tamanho - 1] instanceof Cloneable)
                ret = (X) meuCloneDeX((X) this.data[tamanho - 1]);
            else
                ret = (X) this.data[tamanho - 1];
            this.data[tamanho - 1] = null;
            this.tamanho--;
            return ret;
        }
    }

    @SuppressWarnings("unchecked")
    private void expandirPilha(float porct) {

        int novaCapacidade = (int) (capacidade * Math.ceil(this.data.length * porct));

        X[] novaPilha = (X[]) new Object[novaCapacidade];

        for (int i = 0; i < this.length(); i++) {
            novaPilha[i] = (X) this.data[i];
        }

        this.data = (X[]) novaPilha;
        this.capacidade = novaCapacidade;
    }

    public int length() {
        return this.tamanho;
    }

    private boolean isFull() {
        if (this.tamanho == this.data.length)
            return true;

        return false;
    }

    public boolean isEmpty() {
        if (this.tamanho == 0)
            return true;

        return false;
    }

    public String popAll() throws Exception {

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

        this.capacidade = pilha.capacidade;
        this.data = (X[]) new Object[capacidade];
        this.tamanho = 0;

        for (int i = 0; i < pilha.tamanho; i++) {
            push((X) pilha.data[i]);
        }
    }

    @Override
    public Object clone() {

        Stack<X> clone = null;

        try {
            clone = new Stack<>(this);
        } catch (Exception erro) {
        }

        return clone;
    }

    @SuppressWarnings("unchecked")
    public X meuCloneDeX(X x) {

        X ret = null;

        try {
            Class<?> classe = x.getClass();
            Class<?>[] tipoDosParms = null;
            Method metodo = classe.getMethod("clone", tipoDosParms);
            Object[] parms = null;
            ret = (X) metodo.invoke(x, parms);
        } catch (Exception erro) {
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

        if (this.tamanho != other.tamanho)
            return false;

        for (int i = 0; i < this.tamanho; i++) {
            if (!this.data[i].equals(other.data[i]))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 13;
        int hash = 666;

        hash = hash * prime + Integer.valueOf(this.tamanho).hashCode();
        hash = prime * hash + Arrays.hashCode(Arrays.asList(this.data)
                .subList(0, this.tamanho)
                .toArray());

        return hash;
    }

    @Override
    public int compareTo(Stack<X> other) throws ClassCastException {

        if (!(other instanceof Stack)) {
            throw new ClassCastException("A outra pilha não é uma instância de PilhaArray");
        }

        if (this == other) {
            return 0;
        }

        if (this.tamanho < other.tamanho) {
            return -1;
        }

        if (this.tamanho > other.tamanho) {
            return 1;
        }

        return 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        try {
            return "[" + peek() + "]";
        } catch (Exception e) {
            return "[]";
        }
    }

    // Retorna o elemento na posição especificada da pilha.
    public Object elementAt(int index) {

        if (data[index] == null) {
            return null;
        } else {
            return data[index];
        }
    }

    // Retorna a posição baseada em 1 do elemento especificado na pilha.
    public int search(Object o) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.data[i].equals(o)) {
                return i + 1;
            }
        }
        return -1;
    }
<<<<<<< HEAD

    // Retorna a posição baseada em 1 do elemento especificado na pilha.
    public boolean contains(Object o) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.data[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    // Retorna um array contendo todos os elementos da pilha
    public Object[] toArray() {
        Object[] array = new Object[this.tamanho];
        for (int i = 0; i < this.tamanho; i++) {
            array[i] = this.data[i];
        }
        return array;
    }

=======
>>>>>>> 59f3a5784772377f4ce8f2a0c48f5b521b99d293
}