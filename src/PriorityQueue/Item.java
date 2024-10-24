package PriorityQueue;

import java.util.Objects;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;
import static java.lang.Long.compare;

/**
 * A classe Item representa um elemento na fila de prioridade, contendo o valor e sua prioridade.
 *
 * @param <X> O tipo de dado armazenado no item.
 */
public class Item<X extends Comparable<X>> implements Comparable<Item<X>>, Cloneable {

    private X elemento;
    private int prioridade;

    public X getElemento() {
        return elemento;
    }
    public int getPrioridade() {
        return prioridade;
    }
    public void setElemento(X elemento) {
        if (elemento == null) throw new IllegalArgumentException("Elemento não pode ser nulo");
        this.elemento = elemento;
    }
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    /**
     * Construtor para criar um novo Item com valor e prioridade.
     *
     * @param elemento   O valor do item.
     * @param prioridade A prioridade do item.
     */
    public Item(X elemento, int prioridade) {
        if (elemento == null) throw new IllegalArgumentException("Elemento não pode ser nulo");
        this.elemento = elemento;
        this.prioridade = prioridade;
    }

    @SuppressWarnings("unchecked")
    public Item(Item<X> item) {
        if (item == null) throw new IllegalArgumentException("Item não pode ser nulo");
        this.elemento = (X) verifyAndCopy(item.elemento);
        this.prioridade = item.prioridade;
    }

    /**
     * Cria e retorna um clone deste item.
     *
     * @return Um clone deste item.
     */
    @Override
    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public Object clone() {
        Item<X> clone = null;
        try {
            clone = new Item<X>(this);
        } catch (Exception ignored) {}
        return clone;
    }

    /**
     * Verifica se este item é igual a outro objeto.
     *
     * @param o O objeto a ser comparado.
     * @return true se os objetos forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        Item<?> item = (Item<?>) o;

        return prioridade == item.prioridade &&
               Objects.equals(elemento, item.elemento);
    }

    /**
     * Retorna o código hash para este item.
     *
     * @return O código hash.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + elemento.hashCode();
        hash *= prime + Integer.hashCode(prioridade);

        if (hash < 0) hash = -hash;

        return hash;
    }

    /**
     * Retorna uma representação em string deste item.
     *
     * @return A representação em string.
     */
    @Override
    public String toString() {
        return "(" + elemento + ", " + prioridade + ")";
    }

    /**
     * Compara este item com outro com base na prioridade.
     *
     * @param other O outro item a ser comparado.
     * @return Um valor negativo, zero ou positivo conforme a prioridade deste item é menor, igual ou maior que a do outro.
     */
    @Override
    public int compareTo(Item<X> other) {
        // Ordena em ordem decrescente de prioridade (maior prioridade primeiro)
        return compare(other.prioridade, this.prioridade);
    }
}
