package Queue;

import LinkedList.Disordered.LinkedListDisordered;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Objects;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class Queue<X> implements Cloneable {

    // FIFO - First In First Out
    private LinkedListDisordered<X> elemento;
    private int tamanho;
    private int capacidade;

    public Queue() {
        this.elemento = new LinkedListDisordered<>();
        this.capacidade = 100;
        this.tamanho = 0;
    }
    public Queue(int capacidade) {
        if (capacidade <= 0) throw new IllegalArgumentException("Capacidade inválida");

        this.elemento = new LinkedListDisordered<>();
        this.capacidade = capacidade;
        this.tamanho = 0;
    }
    public int getTamanho() {
        return this.tamanho;
    }
    public int getCapacidade() {
        return this.capacidade;
    }
    public LinkedListDisordered<X> getElemento() {
        return elemento;
    }

    public X enqueue(X item) {
        if (this.tamanho == this.capacidade) throw new StackOverflowError("Fila cheia");

        // Adiciona no final da fila (utilizando o método addLast da LinkedListDisordered)
        this.elemento.addLast(item);
        this.tamanho++;
        return item;
    }

    public X peek() {
        if (isEmpty()) throw new EmptyStackException();

        // Retorna o primeiro elemento da fila (utilizando o método getFirst da LinkedListDisordered)
        return this.elemento.getFirst();
    }

    public X dequeue() {
        if (this.isEmpty()) throw new EmptyStackException();

        // Remove o primeiro elemento da fila (utilizando o método removeFirst da LinkedListDisordered)
        X item = this.elemento.getFirst();
        this.elemento.removeFirst();
        this.tamanho--;

        return item;
    }

    public X peekLast() {
        if (isEmpty()) throw new EmptyStackException();
        return this.elemento.getLast();
    }

    public int search(X item) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elemento.get(i).equals(item))
                return i;
        }
        return -1;
    }

    public int indexOf(X item) {
        return search(item);
    }

    public int lastIndexOf(X item) {
        for (int i = this.tamanho - 1; i >= 0; i--) {
            if (this.elemento.get(i).equals(item))
                return i;
        }
        return -1;
    }

    public int firstIndexOf(X item) {
        return indexOf(item);
    }

    public boolean contains(X item) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elemento.get(i).equals(item))
                return true;
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
            if (i < this.tamanho - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public List<X> toList() {
        List<X> list = new ArrayList<>(tamanho);
        for (int i = 0; i < tamanho; i++)
            list.add(elemento.get(i));
        return list;
    }

    public Object[] toArray(Object[] array) {
        if (array == null) throw new IllegalArgumentException("Array inválido");
        if (array.length < this.tamanho) throw new IllegalArgumentException("Array menor que o tamanho da fila");

        for (int i = 0; i < this.tamanho; i++)
            array[i] = verifyAndCopy(this.elemento.get(i));

        return array;
    }

    @SuppressWarnings("unchecked")
    public Queue(Queue<X> modelo) {
        if (modelo == null) throw new IllegalArgumentException("Fila inválida");

        this.elemento = new LinkedListDisordered<>();
        this.capacidade = (int) verifyAndCopy(modelo.capacidade);

        for (int i = 0; i < modelo.tamanho; i++)
            this.elemento.addLast((X) verifyAndCopy(modelo.elemento.get(i)));

        this.tamanho = (int) verifyAndCopy(modelo.tamanho);
    }

    @Override
    public Object clone() {
        Queue<X> clone = null;
        try {
            clone = new Queue<X>(this);
        } catch (Exception ignored) {
        }
        return clone;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;

        Queue<?> queue = (Queue<?>) obj;

        if (this.tamanho != queue.tamanho) return false;
        if (this.capacidade != queue.capacidade) return false;

        for (int i = 0; i < this.tamanho; i++) {
            if (!this.elemento.get(i).equals(queue.elemento.get(i)))
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