package Queue;

import java.lang.reflect.Method;
import java.util.EmptyStackException;
import java.util.StringJoiner;

public final class Queue<X> implements Comparable<Queue<X>>, Cloneable {

    // FIFO - First in First Out
    private X[] elemento;
    private int frente;
    private int atras;
    private int tamanho;

    // @SuppressWarnings("unchecked")
    public Queue(int capInicial) throws IllegalArgumentException {
        if (capInicial < 1) {
            throw new IllegalArgumentException();
        }
        this.elemento = (X[]) new Object[capInicial];
        this.frente = 0;
        this.atras = -1;
        this.tamanho = 0;
    }

    public void enqueue(X x) throws Exception {

        if (x == null)
            throw new Exception("Falta o que guardar");

        if (estaCheio()) {
            expandirFila(2.0F);
        }
        this.atras = (atras + 1) % elemento.length;
        this.elemento[atras] = x;
        this.tamanho++;
    }

    @SuppressWarnings("unchecked")
    public X peek() throws Exception {

        if (estaVazio())
            throw new EmptyStackException();

        X ret = null;
        if (this.elemento[frente] instanceof Cloneable)
            ret = meuCloneDeX((X) this.elemento[frente]);
        else
            ret = (X) this.elemento[frente];

        return ret;
    }

    @SuppressWarnings("unchecked")
    public X dequeue() throws Exception {

        if (estaVazio())
            throw new EmptyStackException();

        X data = (X) elemento[frente];
        this.frente = (frente + 1) % tamanho;
        this.tamanho--;
        return data;
    }

    @SuppressWarnings("unchecked")
    public void expandirFila(float porct) {

        int novaCapacidade = (int) (tamanho * Math.ceil(this.elemento.length * porct));

        X[] novoElemento = (X[]) new Object[novaCapacidade];

        for (int i = 0; i < this.getTamanho(); i++) {
            novoElemento[i] = (X) elemento[(frente + i) % this.elemento.length];
        }

        this.elemento = novoElemento;
        this.frente = 0;
        this.atras = tamanho - 1;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public boolean estaCheio() {
        if (this.tamanho == this.elemento.length)
            return true;

        return false;
    }

    public boolean estaVazio() {
        if (this.tamanho == 0)
            return true;

        return false;
    }

    public String dequeueAll() throws Exception {

        if (estaVazio()) {
            return "";
        }

        StringJoiner removidos = new StringJoiner(",");
        while (!estaVazio()) {
            X data = dequeue();
            removidos.add(data.toString());
        }

        return removidos.toString();
    }

    @SuppressWarnings("unchecked")
    public Queue(Queue<X> copia) throws Exception {

        if (copia == null) {
            throw new NullPointerException("Não é possível copiar Queue nula.");
        }

        this.elemento = (X[]) new Object[copia.getTamanho()];
        this.frente = 0;
        this.atras = -1;
        this.tamanho = 0;

        for (int i = 0; i < copia.tamanho; i++) {
            this.enqueue((X) copia.elemento[(copia.frente + i) % copia.elemento.length]);
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

        if (this.tamanho != other.tamanho)
            return false;

        for (int i = 0; i < this.tamanho; i++) {
            if (!this.elemento[(this.frente + i) % this.elemento.length]
                    .equals(other.elemento[(other.frente + i) % other.elemento.length]))
                return false;

        }

        return true;
    }

    @Override
    public int hashCode() {

        final int primo = 31;
        int hash = 19;

        hash = hash * primo + Integer.valueOf(this.tamanho).hashCode();

        for (int i = 0; i < this.tamanho; i++) {
            hash = hash * primo + (this.elemento[((this.frente) + i) % this.elemento.length].hashCode());
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
        if (this.estaVazio()) {
            return "[]";
        }

        return "[" + this.elemento[this.frente] + "]";
    }

    public String toArray() {

        if (estaVazio())
            return "";
        else {

            StringBuilder sb = new StringBuilder();
            sb.append("[");

            for (int i = 0; i < this.getTamanho(); i++) {
                sb.append(this.elemento[(frente + i) % elemento.length]);
                if (i != this.getTamanho() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }
}