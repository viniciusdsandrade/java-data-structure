package Stack;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.StringJoiner;

public class Stack<X> implements Comparable<Stack<X>>, Cloneable {

    // LIFO - Last in First Out
    private X[] elemento;
    private int tamanho;
    private int capacidade;

    @SuppressWarnings("unchecked")
    public Stack(int capInicial) throws IllegalArgumentException {

        if (capInicial < 1) {
            throw new IllegalArgumentException();
        }
        this.capacidade = capInicial;
        this.elemento = (X[]) new Object[capInicial];
        this.tamanho = 0;
    }

    public void push(X x) throws Exception {

        if (x == null)
            throw new Exception("Falta o que guardar");

        if (this.estaCheio()) {
            this.expandirPilha(2.0f);
        }
        if (x instanceof Cloneable)
            this.elemento[tamanho++] = (X) meuCloneDeX(x);
        else
            this.elemento[tamanho++] = (X) x;

    }

    public X peek() throws Exception {

        if (estaVazio())
            throw new EmptyStackException();

        X ret = null;
        if (this.elemento[tamanho - 1] instanceof Cloneable)
            ret = (X) meuCloneDeX((X) this.elemento[tamanho - 1]);
        else
            ret = (X) this.elemento[tamanho - 1];

        return (X) ret;
    }

    public X pop() {
        if (estaVazio()) {
            throw new EmptyStackException();
        }
        X data = (X) elemento[tamanho - 1];
        this.elemento[tamanho - 1] = null;
        this.tamanho--;
        return data;
    }

    @SuppressWarnings("unchecked")
    private void expandirPilha(float porct) {

        int novaCapacidade = (int) (capacidade * Math.ceil(this.elemento.length * porct));

        X[] novaPilha = (X[]) new Object[novaCapacidade];

        for (int i = 0; i < this.getTamanho(); i++) {
            novaPilha[i] = (X) this.elemento[i];
        }

        this.elemento = (X[]) novaPilha;
        this.capacidade = novaCapacidade;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    private boolean estaCheio() {
        if (this.tamanho == this.elemento.length)
            return true;

        return false;
    }

    public boolean estaVazio() {
        if (this.tamanho == 0)
            return true;

        return false;
    }

    public String popAll() throws Exception {

        if (estaVazio()) {
            return "";
        }

        StringJoiner removidos = new StringJoiner(", ");
        while (!estaVazio()) {
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
        this.elemento = (X[]) new Object[capacidade];
        this.tamanho = 0;

        for (int i = 0; i < pilha.tamanho; i++) {
            push((X) pilha.elemento[i]);
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
            if (!this.elemento[i].equals(other.elemento[i]))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 2;
        int hash = 1;

        hash = hash * prime + Integer.valueOf(this.tamanho).hashCode();
        hash = prime * hash + Arrays.hashCode(Arrays.asList(this.elemento)
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
        if (estaVazio()) {
            return "[]";
        }
        return "[" + this.elemento[this.tamanho - 1] + "]";
    }

    // Método para visualizar todos os elementos das stack
    public String toArray() {

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = this.tamanho - 1; i >= 0; i--) {
            sb.append(this.elemento[i].toString());
            if (i != 0) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }

    // @SuppressWarnings("unchecked")
    // public String toArrayPilhaDeFilha() {

    //     if (this.estaVazio())
    //         return "Pilha<Fila<Coordenada> is null";

    //     else {
    //         StringBuilder sb = new StringBuilder();
    //         sb.append("Pilha de Fila [");
    //         for (int i = this.tamanho; i >= 0; i--) {
    //             sb.append("[");
    //             Fila<Coordenada> filaAtual = (Fila<Coordenada>) this.elemento[i];
    //             for (int j = 0; j < filaAtual.getTamanho(); j++) {
    //                 try {
    //                     Coordenada coordenadaAtual = filaAtual.peek();
    //                     sb.append(coordenadaAtual.toString());
    //                     if (j < filaAtual.getTamanho() - 1) {
    //                         sb.append(", ");
    //                     }
    //                     filaAtual.enqueue(filaAtual.dequeue());
    //                 } catch (Exception e) {
    //                     e.printStackTrace();
    //                 }
    //             }
    //             sb.append("]");
    //             if (i > 0) {
    //                 sb.append(", ");
    //             }
    //         }
    //         sb.append("]");
    //         return sb.toString();
    //     }
    // }
}