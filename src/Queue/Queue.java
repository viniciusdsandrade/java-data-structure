package Queue;

import LinkedList.Disordered.LinkedListDisordered;

import java.util.EmptyStackException;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class Queue<X> implements Cloneable {

    // FIFO - First in First Out
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
        return tamanho;
    }
    public int getCapacidade() {
        return capacidade;
    }

    public X enqueue(X item) {
        if (this.tamanho == this.capacidade) throw new StackOverflowError("Fila cheia");

        this.elemento.addLast(item);
        this.tamanho++;
        return item;
    }

    public X dequeue() {
        if (this.isEmpty()) throw new EmptyStackException();

        X item = this.elemento.getFirst();
        this.elemento.removeFirst();
        this.tamanho--;

        return item;
    }

    public X peek() {
        if (isEmpty()) throw new EmptyStackException();

        return this.elemento.getFirst();
    }

    public int search(X item) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elemento.get(i).equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    public void clear() {
        this.elemento.clear();
        this.tamanho = 0;
    }

    public void removeAllElements() {
        for (int i = 0; i < this.tamanho; i++)
            this.elemento.removeFirst();

        this.tamanho = 0;
    }

    public boolean contains(X item) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elemento.get(i).equals(item)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public Queue(Queue<X> queue) {
        if (queue == null) throw new IllegalArgumentException("Fila inválida");

        this.elemento = new LinkedListDisordered<>();
        this.capacidade = (int) verifyAndCopy(queue.capacidade);

        for (int i = 0; i < queue.tamanho; i++)
            this.elemento.addLast((X) verifyAndCopy(queue.elemento.get(i)));

        this.tamanho = (int) verifyAndCopy(queue.tamanho);
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
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;

        Queue<X> queue = (Queue<X>) obj;

        if (this.tamanho != queue.tamanho) return false;
        if (this.capacidade != queue.capacidade) return false;

        for (int i = 0; i < this.tamanho; i++) {
            if (!this.elemento.get(i).equals(queue.elemento.get(i))) {
                return false;
            }
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
            hash *= prime + this.elemento.get(i).hashCode();

        return hash;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        else return "[" + this.peek() + "]";
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
}