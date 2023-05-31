package Queue;

import java.lang.reflect.Method;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;
import java.util.Collection;

public final class Queue<X> implements Comparable<Queue<X>>, Cloneable {

    /*
     * boolean add(E elemento): Adiciona um elemento à fila. Se a fila estiver
     * cheia, uma exceção será lançada.
     * boolean offer(E elemento): Adiciona um elemento à fila. Retorna true se a
     * operação for bem-sucedida e false se a fila estiver cheia.
     * E remove(): Remove e retorna o elemento da frente da fila. Se a fila estiver
     * vazia, uma exceção será lançada.
     * E poll(): Remove e retorna o elemento da frente da fila. Retorna null se a
     * fila estiver vazia.
     * E element(): Retorna o elemento da frente da fila, sem removê-lo. Se a fila
     * estiver vazia, uma exceção será lançada.
     * E peek(): Retorna o elemento da frente da fila, sem removê-lo. Retorna null
     * se a fila estiver vazia.
     * boolean isEmpty(): Verifica se a fila está vazia. Retorna true se a fila
     * estiver vazia e false caso contrário.
     * int size(): Retorna o número de elementos na fila.
     * void clear(): Remove todos os elementos da fila.
     * boolean contains(Object elemento): Verifica se a fila contém o elemento
     * especificado. Retorna true se a fila contiver o elemento e false caso
     * contrário.
     * Iterator<E> iterator(): Retorna um iterador sobre os elementos da fila.
     * Object[] toArray(): Retorna um array contendo todos os elementos da fila.
     * E[] toArray(E[] array): Retorna um array contendo todos os elementos da fila,
     * sendo o tipo do array especificado.
     * boolean containsAll(Collection<?> colecao): Verifica se a fila contém todos
     * os elementos da coleção especificada.
     * boolean addAll(Collection<? extends E> colecao): Adiciona todos os elementos
     * da coleção especificada à fila.
     * boolean removeAll(Collection<?> colecao): Remove todos os elementos da fila
     * que também estão presentes na coleção especificada.
     * boolean retainAll(Collection<?> colecao): Remove da fila todos os elementos
     * que não estão presentes na coleção especificada.
     * boolean equals(Object objeto): Verifica se a fila é igual a outro objeto
     * especificado.
     * int hashCode(): Retorna o código hash da fila.
     * String toString(): Retorna uma representação em forma de string da fila.
     */

    // FIFO - First in First Out
    private X[] data;
    private int front;
    private int rear;
    private int size;

    @SuppressWarnings("unchecked")
    public Queue(int capInicial) throws IllegalArgumentException {
        if (capInicial < 1) {
            throw new IllegalArgumentException();
        }
        this.data = (X[]) new Object[capInicial];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // método para adicionar um elemento na fila
    public void enqueue(X x) throws Exception {

        if (x == null)
            throw new EmptyStackException();

        if (isFull())
            resizeUp();

        this.rear = (rear + 1) % this.data.length; // rear = rear + 1
        this.data[rear] = (X) meuCloneDeX(x);
        this.size++;

        while (this.size() < this.data.length) {
            resizeDown();
        }

    }

    public X peek() throws Exception {

        if (isEmpty())
            throw new EmptyStackException();

        X ret = null;
        if (this.data[front] instanceof Cloneable)
            ret = meuCloneDeX((X) this.data[front]);
        else
            ret = (X) this.data[front];

        return ret;
    }

    public X dequeue() throws Exception {

        if (isEmpty())
            throw new NoSuchElementException();

        X element = (X) data[front];
        this.front = (front + 1) % size;
        this.size--;

        return element;
    }

    @SuppressWarnings("unchecked")
    public void expand(float porct) {

        int newCapacity = (int) (size * Math.ceil(this.data.length * porct));

        X[] newElement = (X[]) new Object[newCapacity];

        for (int i = 0; i < this.size(); i++) {
            newElement[i] = (X) data[(front + i) % this.data.length];
        }

        this.data = newElement;
        this.front = 0;
        this.rear = size - 1;
    }

    @SuppressWarnings("unchecked")
    public void resizeUp() {
        int newCapacity = (int) this.data.length + 1;

        X[] newElement = (X[]) new Object[newCapacity];

        for (int i = 0; i < this.size(); i++) {
            newElement[i] = (X) data[(front + i) % this.data.length];
        }

        this.data = (X[]) newElement;
        this.front = 0;
        this.rear = size - 1;
    }

    @SuppressWarnings("unchecked")
    public void resizeDown() {
        int newCapacity = (int) (this.data.length - 1);

        X[] newElement = (X[]) new Object[newCapacity];

        for (int i = 0; i < this.size(); i++) {
            newElement[i] = (X) data[(front + i) % this.data.length];
        }

        this.data = newElement;
        this.front = 0;
        this.rear = size - 1;
    }

    public int size() {
        return this.size;
    }

    public boolean isFull() {
        if (this.size == this.data.length)
            return true;

        return false;
    }

    public boolean isEmpty() {
        if (this.size == 0)
            return true;

        return false;
    }

    public Object dequeueAll() throws Exception {

        if (isEmpty())
            throw new EmptyStackException();

        X element = (X) data[front];
        this.front = (front + 1) % size;
        this.size--;
        return element;
    }

    @SuppressWarnings("unchecked")
    public Queue(Queue<X> copia) throws Exception {

        if (copia == null) {
            throw new NullPointerException("Não é possível copiar Queue nula.");
        }

        this.data = (X[]) new Object[copia.size()];
        this.front = 0;
        this.rear = -1;
        this.size = 0;

        for (int i = 0; i < copia.size; i++) {
            this.enqueue((X) copia.data[(copia.front + i) % copia.data.length]);
        }
    }

    @Override
    public Object clone() {

        Queue<X> clone = null;

        try {
            clone = new Queue<>(this);
        } catch (Exception e) {
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

        Queue<?> other = (Queue<?>) obj;

        if (this.size != other.size)
            return false;

        for (int i = 0; i < this.size; i++) {
            if (!this.data[(this.front + i) % this.data.length]
                    .equals(other.data[(other.front + i) % other.data.length]))
                return false;

        }

        return true;
    }

    @Override
    public int hashCode() {

        final int primo = 31;
        int hash = 19;

        hash = hash * primo + Integer.valueOf(this.size).hashCode();

        for (int i = 0; i < this.size; i++) {
            hash = hash * primo + (this.data[((this.front) + i) % this.data.length].hashCode());
        }

        if (hash < 0)
            hash = -hash;

        return hash;
    }

    @Override
    public int compareTo(Queue<X> other) {

        if (!(other instanceof Queue)) {
            throw new ClassCastException("A outra pilha não é uma instância de PilhaArray");
        }
        if (this == other) {
            return 0;
        }

        if (this.size < other.size) {
            return -1;
        }

        if (this.size > other.size) {
            return 1;
        }

        return 0;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "[]";
        }
        try {
            return "[" + this.peek() + "]";
        } catch (Exception e) {
            return "[]";
        }
    }

    public void clear() {
        this.data = (X[]) new Object[1];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void clear2() {
        while (!isEmpty()) {
            this.dequeue();
        }
    }

    // retorna uma representada de String em formato de Array da fila
    public String toArray() {

        if (isEmpty())
            return "[]";
        else {
            return Arrays.toString(this.data);
        }
    }

    // Retorna um iterador sobre os elementos da fila.
    public Iterator<X> iterator() {

        return new Iterator<X>() {

            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public X next() {
                if (hasNext()) {
                    X element = (X) data[(front + count) % data.length];
                    count++;
                    return element;
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }

    // Retorna um Object de Array contendo todos os elementos da fila.
    public Object[] toArray2() {
        if (isEmpty())
            return new Object[0];

        Object[] data = new Object[this.size];

        for (int i = 0; i < this.size; i++) {
            data[i] = this.data[(this.front + i) % this.data.length];
        }

        return data;
    }

    // Retonar um array do tipo X contendo todos os elementos da fila.
    @SuppressWarnings("unchecked")
    public X[] toArray3(X[] array) {
        // E[] toArray(E[] array): Retorna um array contendo todos os elementos da fila,
        // sendo o tipo do array especificado.

        if (array == null)
            throw new NullPointerException("Array nulo.");

        if (array.length < this.size)
            array = (X[]) new Object[this.size];

        for (int i = 0; i < this.size; i++) {
            array[i] = (X) data[(front + i) % data.length];
        }

        return array;

    }

    // Adiciona todos os elementos da coleção especificada à fila.
    public boolean addAll(Collection<? extends X> collection) throws Exception {
        // boolean addAll(Collection<? extends E> colecao): Adiciona todos os
        // elementos da coleção especificada à fila

        if (collection == null)
            throw new NullPointerException("Coleção nula.");

        if (collection.isEmpty())
            throw new IllegalArgumentException("Coleção vazia.");

        if (this.isEmpty())
            throw new EmptyStackException();

        boolean modified = false;

        for (X element : collection) {
            enqueue(element);
            modified = true;
        }

        return modified;
    }

    // Remove todos os elementos da fila que também estão presentes na coleção
    public boolean removeAll(Collection<?> collection) throws Exception {
        // Remove todos os elementos da fila que também estão presentes na coleção
        // especificada.

        if (collection == null)
            throw new NullPointerException("Coleção nula.");

        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Coleção vazia.");
        }

        if (this.isEmpty())
            throw new EmptyStackException();

        boolean modified = false;
        int initialSize = size();
        int index = front;
        int count = 0;

        while (count < size()) {
            X element = this.elementAt(index);
            if (collection.contains(element)) {
                dequeueAt(index);
                this.resizeDown();
                modified = true;
            } else {
                index = (index + 1) % data.length;
                count++;
            }
        }

        return modified && size() < initialSize;
    }

    public X elementAt(int index) {
        return data[index];
    }

    // remote o elemento da fila no index especificado
    private void dequeueAt(int index) {
        int currentIndex = index;

        while (currentIndex != rear) {
            int nextIndex = (currentIndex + 1) % data.length;
            data[currentIndex] = data[nextIndex];
            currentIndex = nextIndex;
        }

        data[rear] = null;
        rear = (rear - 1 + data.length) % data.length;
        size--;
    }

    // Remove da fila todos os elementos que não estão presentes na coleção
    // especificada.
    public boolean retainAll(Collection<?> colecao) throws Exception {

        if (colecao == null)
            throw new NullPointerException("Coleção nula.");

        if (colecao.isEmpty())
            throw new IllegalArgumentException("Coleção vazia.");

        if (this.isEmpty())
            throw new EmptyStackException();

        boolean modificado = false;
        int i = 0;
        while (i < this.size) {
            if (!colecao.contains(this.data[(this.front + i) % this.data.length])) {
                this.dequeue();
                modificado = true;
            } else {
                i++;
            }
        }
        return modificado;
    }

    // Verifica se determinado elemento Object está contido na fila
    public boolean contains(Object elemento) {
        // Verifica se a fila contém o elemento especificado. Retorna true se a fila
        // conter o elemento e false caso contrário.

        if (elemento == null)
            throw new NullPointerException("Elemento nulo.");

        //
        for (int i = 0; i < this.size; i++) {
            if (data[(front + i) % data.length].equals(elemento))
                return true;
        }

        return false;
    }

    // Remove todos os elementos da fila que também estão presentes na coleção
    public boolean containsAll(Collection<?> colecao) {

        // verifica se a coleção é nula
        if (colecao == null)
            throw new NullPointerException("Coleção nula.");

        // verifica se a coleção está vazia
        if (colecao.isEmpty())
            throw new IllegalArgumentException("Coleção vazia.");

        // verifica se a fila está vazia
        if (this.isEmpty())
            throw new EmptyStackException();
        // verifica se a fila contém todos os elementos da coleção
        for (Object object : colecao) {
            if (!colecao.contains(object))
                return false;
        }

        return true;
    }
}