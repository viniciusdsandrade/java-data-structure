package Queue.src;

import java.lang.reflect.Method;
import java.util.EmptyStackException;
import java.util.StringJoiner;

public final class Queue<X> implements Cloneable {

    // FIFO - First in First Out
    private X[] elemento;
    private int frente;
    private int atras;
    private int tamanho;

    @SuppressWarnings("unchecked")
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

    public X peek() {

        if (estaVazio())
            throw new EmptyStackException();

        X ret;
        if (this.elemento[frente] instanceof Cloneable)
            ret = meuCloneDeX(this.elemento[frente]);
        else
            ret = this.elemento[frente];

        return ret;
    }

    public X dequeue() {

        if (estaVazio())
            throw new EmptyStackException();

        X data = elemento[frente];
        this.frente = (frente + 1) % tamanho;
        this.tamanho--;
        return data;
    }

    @SuppressWarnings("unchecked")
    public void expandirFila(float porct) {

        int novaCapacidade = (int) (tamanho * Math.ceil(this.elemento.length * porct));

        X[] novoElemento = (X[]) new Object[novaCapacidade];

        for (int i = 0; i < this.getTamanho(); i++) {
            novoElemento[i] = elemento[(frente + i) % this.elemento.length];
        }

        this.elemento = novoElemento;
        this.frente = 0;
        this.atras = tamanho - 1;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public boolean estaCheio() {
        return this.tamanho == this.elemento.length;
    }

    public boolean estaVazio() {
        return this.tamanho == 0;
    }

    public String dequeueAll() {

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
            this.enqueue(copia.elemento[(copia.frente + i) % copia.elemento.length]);
        }
    }

    @Override
    public Object clone() {

        Queue<X> clone = null;

        try {
            clone = new Queue<>(this);
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

        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

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

        final int prime = 31;
        int hash = 19;

        hash *= hash + Integer.valueOf(this.tamanho).hashCode();

        for (int i = 0; i < this.tamanho; i++) {
            hash *= prime + (this.elemento[((this.frente) + i) % this.elemento.length].hashCode());
        }

        if (hash < 0)
            hash = -hash;

        return hash;
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