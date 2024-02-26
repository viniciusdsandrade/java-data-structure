package src;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ArrayList<X> implements Cloneable {

    /*
     * 1 - void add(int index, E element): Insere o elemento especificado na posição
     * index na lista.
     * 2 - boolean add(E e): Adiciona o elemento especificado ao final da lista.
     * 3 - boolean addAll(Collection<? extends E> c): Adiciona todos os elementos na
     * coleção especificada ao final da lista.
     * 4 - boolean addAll(int index, Collection<? extends E> c): Adiciona todos os
     * elementos na coleção especificada na posição index da lista.
     * 5 - void clear(): Remove todos os elementos da lista.
     * 6 - Object clone(): Retorna uma cópia superficial da lista.
     * 7 - boolean contains(Object o): Retorna true se a lista contém o elemento
     * especificado.
     * 8 - void ensureCapacity(int minCapacity): Aumenta a capacidade interna da
     * lista para garantir um número mínimo de elementos.
     * 9 - E get(int index): Retorna o elemento na posição index da lista.
     * 10 - int indexOf(Object o): Retorna o índice da primeira ocorrência do
     * elemento especificado na lista, ou -1 se o elemento não estiver presente.
     * 11 - boolean isEmpty(): Retorna true se a lista estiver vazia.
     * 12 - Iterator<E> iterator(): Retorna um iterador sobre os elementos da lista.
     * 13 - int lastIndexOf(Object o): Retorna o índice da última ocorrência do
     * elemento especificado na lista, ou -1 se o elemento não estiver presente.
     * 14 - ListIterator<E> listIterator(): Retorna um iterador de lista sobre os
     * elementos da lista.
     * 15 - ListIterator<E> listIterator(int index): Retorna um iterador de lista
     * sobre os elementos da lista, começando na posição index.
     * 16 - E remove(int index): Remove o elemento na posição index da lista e o
     * retorna.
     * 17 - boolean remove(Object o): Remove a primeira ocorrência do elemento
     * especificado na lista, se estiver presente.
     * 18 - boolean removeAll(Collection<?> c): Remove todos os elementos da lista
     * que estão presentes na coleção especificada.
     * 19 - boolean retainAll(Collection<?> c): Remove todos os elementos da lista
     * que não estão presentes na coleção especificada.
     * 20 - E set(int index, E element): Substitui o elemento na posição index da
     * lista pelo elemento especificado.
     * 21 - int size(): Retorna o número de elementos na lista.
     * 22 - List<E> subList(int fromIndex, int toIndex): Retorna uma sublista dos
     * elementos entre os índices fromIndex e toIndex.
     * 23 - Object[] toArray(): Retorna um array contendo todos os elementos da
     * lista.
     * 24 - <T> T[] toArray(T[] a): Retorna um array contendo todos os elementos da
     * lista, na ordem correta.
     */



    private Object[] data;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayList(int capInicial) throws IllegalArgumentException {

        if (capInicial < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + capInicial);

        this.capacity = capInicial;
        this.data = (X[]) new Object[capacity];
        this.size = 0;
    }

    public ArrayList() {
        super();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(X x) {

        if (x == null)
            throw new NullPointerException("Cannot add null object");

        if (this.size == this.capacity) {
            reziseUp();
        }

        if (x instanceof Cloneable)
            this.data[size++] = (X) meuCloneDeX(x);
        else
            this.data[size++] = (X) x;

        while (this.size() < this.capacity)
            this.reziseDown();
    }

    @SuppressWarnings("unchecked")
    public void reziseDown() {
        int newCapacity = (int) this.data.length - 1;

        X[] newArrayList = (X[]) new Object[newCapacity];

        for (int i = 0; i < this.size; i++) {
            newArrayList[i] = (X) this.data[i];
        }

        this.data = (X[]) newArrayList;
        this.capacity = newCapacity;
    }

    @SuppressWarnings("unchecked")
    public void reziseUp() {
        int newCapacity = (int) this.data.length + 1;

        X[] newArrayList = (X[]) new Object[newCapacity];

        for (int i = 0; i < this.size; i++) {
            newArrayList[i] = (X) this.data[i];
        }

        this.data = (X[]) newArrayList;
        this.capacity = newCapacity;
    }

    @SuppressWarnings("unchecked")
    public X get(int index) {

        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);

        return (X) this.data[index];
    }

    @Override
    public int hashCode() {

        final int PRIME = 31;
        int hash = 1;

        hash *= PRIME + Integer.valueOf(this.size).hashCode();
        hash *= PRIME + Arrays.hashCode(this.data);

        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        ArrayList<?> other = (ArrayList<?>) obj;

        if (this.size != other.size)
            return false;

        for (int i = 0; i < this.size; i++) {
            if (!this.data[i].equals(other.data[i]))
                return false;
        }

        return true;

    }

    @Override
    public String toString() {

        if (this.size == 0)
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < this.size - 1; i++) {
            sb.append(this.data[i] + ", ");
        }

        sb.append(this.data[this.size - 1] + "]");

        return sb.toString();

    }

    // copy constructor
    public ArrayList(ArrayList<X> arrayList) {
        if (arrayList == null)
            throw new NullPointerException("src.ArrayList cannot be null");

        // Agora preciso passar todos os elementos do src.ArrayList para a sua nova copia

        this.size = arrayList.size();
        this.data = new Object[size];

        for (int i = 0; i < size; i++) {
            this.data[i] = arrayList.get(i);
        }

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
    public ArrayList<X> clone() {

        ArrayList<X> clone = null;

        try {
            clone = new ArrayList<>(this.capacity);
            clone.data = Arrays.copyOf(data, size);
            clone.size = size;
        } catch (Exception e) {
            e.fillInStackTrace();
        }

        return clone;
    }
}
