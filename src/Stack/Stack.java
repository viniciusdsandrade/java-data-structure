package Stack;

import java.util.EmptyStackException;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class Stack<X> implements Cloneable {

    private Object[] elemento;
    private final int tamanhoInicial;
    private int ultimo = -1;

    public Stack() {
        this.tamanhoInicial = 10;
        this.elemento = new Object[tamanhoInicial];
    }

    public Stack(int tamanhoInicial) {
        if (tamanhoInicial <= 0) throw new IllegalArgumentException("Tamanho inválido");

        this.elemento = new Object[tamanhoInicial];
        this.tamanhoInicial = tamanhoInicial;
    }

    public void push(X x) {
        if (x == null) throw new IllegalArgumentException("Elemento nulo");

        if (this.isFull()) this.redimensionarParaCima();

        this.ultimo++;
        this.elemento[this.ultimo] = verifyAndCopy(x);
    }

    @SuppressWarnings("unchecked")
    public X peek() {
        if (this.isEmpty()) throw new EmptyStackException();

        X ret;

        ret = (X) verifyAndCopy(this.elemento[this.ultimo]); // LIFO: Retorna o último elemento inserido

        return ret;
    }

    @SuppressWarnings("unchecked")
    public X pop() {
        if (this.isEmpty()) throw new EmptyStackException();

        X ret = (X) verifyAndCopy(this.elemento[this.ultimo]);

        this.elemento[this.ultimo] = null;
        this.ultimo--;

        // Preciso garantir que nunca a pilha ficaria com um tamanho menor que o seu tamanho inicial
        if (this.elemento.length > this.tamanhoInicial &&
                this.ultimo + 1 <= Math.round((float) this.elemento.length / 4))
            this.redimensionarParaBaixo();

        return ret;
    }

    private void redimensionarParaBaixo() {

        Object[] novo = new Object[(int) Math.ceil((float) this.elemento.length / 2)];

        for (int i = 0; i < novo.length; i++)
            novo[i] = this.elemento[i];

        this.elemento = novo;
    }

    private void redimensionarParaCima() {
        Object[] novo = new Object[(int) Math.ceil((float) this.elemento.length * 2)];

        for (int i = 0; i < this.elemento.length; i++)
            novo[i] = this.elemento[i];

        this.elemento = novo;
    }

    public boolean isEmpty() {
        return this.ultimo == -1;
    }

    public boolean isFull() {
        return this.ultimo + 1 == this.elemento.length;
    }

    public String toArray() {
        if (this.isEmpty()) return "[]";
        StringBuilder ret = new StringBuilder("[");
        for (int i = this.ultimo; i > 0; i--)
            ret.append(this.elemento[i]).append(", ");
        ret.append(this.elemento[0]).append("]");
        return ret.toString();
    }

    // Construtor de cópia
    public Stack(Stack<X> modelo) {
        if (modelo == null) throw new IllegalArgumentException("Modelo ausente");

        this.tamanhoInicial = modelo.tamanhoInicial;
        this.ultimo = modelo.ultimo;

        this.elemento = new Object[this.tamanhoInicial];

        for (int i = 0; i < this.ultimo; i++)
            this.elemento[i] = modelo.elemento[i];
    }

    @Override
    @SuppressWarnings("MethodDoesntCallSuperMethod")
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

        if (this.tamanhoInicial != other.tamanhoInicial) return false;
        if (this.ultimo != other.ultimo) return false;

        for (int i = 0; i < this.ultimo; i++)
            if (!this.elemento[i].equals(other.elemento[i]))
                return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + Integer.hashCode(this.tamanhoInicial);
        hash *= prime + Integer.hashCode(this.ultimo);

        for (int i = 0; i < this.ultimo; i++)
            hash *= prime + this.elemento[i].hashCode();

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) return "[]";
        return "[" + this.elemento[this.ultimo] + "]";
    }
}
