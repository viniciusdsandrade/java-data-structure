package PriorityQueue;

import Tree.ArvoreBinaria;

import java.util.NoSuchElementException;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;
import static java.lang.Long.compare;

/**
 * A classe PriorityQueueBinarySearchTree implementa uma fila de prioridade utilizando uma árvore binária de busca.
 *
 * @param <X> O tipo de dado armazenado na fila de prioridade.
 */
public class PriorityQueueBinarySearchTree<X extends Comparable<X>> implements Cloneable {

    /**
     * Classe interna Item que representa um elemento com sua prioridade.
     */
    /**
     * Classe interna Item que representa um elemento com sua prioridade.
     */
    private class Item implements Comparable<Item>, Cloneable {
        private X elemento;
        private int prioridade;

        /**
         * Retorna o elemento armazenado no item.
         *
         * @return O elemento.
         */
        public X getElemento() {
            return elemento;
        }

        /**
         * Retorna a prioridade do item.
         *
         * @return A prioridade.
         */
        public int getPrioridade() {
            return prioridade;
        }

        /**
         * Define o elemento do item.
         *
         * @param elemento O novo elemento.
         */
        public void setElemento(X elemento) {
            if (elemento == null) throw new IllegalArgumentException("Elemento não pode ser nulo");
            this.elemento = elemento;
        }

        /**
         * Define a prioridade do item.
         *
         * @param prioridade A nova prioridade.
         */
        public void setPrioridade(int prioridade) {
            this.prioridade = prioridade;
        }

        /**
         * Construtor para criar um novo Item com valor e prioridade.
         *
         * @param elemento   O valor do item.
         * @param prioridade A prioridade do item.
         */
        @SuppressWarnings("unchecked")
        public Item(X elemento, int prioridade) {
            if (elemento == null) throw new IllegalArgumentException("Elemento não pode ser nulo");
            this.elemento = (X) verifyAndCopy(elemento);
            this.prioridade = prioridade;
        }

        @SuppressWarnings("unchecked")
        public Item(Item item) {
            if (item == null) throw new IllegalArgumentException("Item não pode ser nulo");
            this.elemento = (X) verifyAndCopy(item.elemento);
            this.prioridade = item.prioridade;
        }

        /**
         * Cria e retorna um clone deste item.
         *
         * @return Um clone deste item.
         */
        @SuppressWarnings("MethodDoesntCallSuperMethod")
        @Override
        public Object clone() {
            Item clone = null;
            try {
                clone = new Item(this);
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
        @SuppressWarnings("unchecked")
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Item item = (Item) o;

            return prioridade == item.prioridade &&
                   elemento.equals(item.elemento);
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

            hash = prime * hash + elemento.hashCode();
            hash = prime * hash + Integer.hashCode(prioridade);

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
        public int compareTo(Item other) {
            return Integer.compare(other.prioridade, this.prioridade);
        }
    }
    private ArvoreBinaria<Item> arvore;

    /**
     * Construtor padrão que inicializa uma fila de prioridade vazia.
     */
    public PriorityQueueBinarySearchTree() {
        this.arvore = new ArvoreBinaria<>();
    }

    /**
     * Insere um novo elemento com sua prioridade na fila de prioridade.
     *
     * @param elemento   O elemento a ser inserido.
     * @param prioridade A prioridade do elemento.
     * @throws IllegalArgumentException Se o elemento for nulo.
     */
    public void enqueue(X elemento, int prioridade) {
        if (elemento == null) throw new IllegalArgumentException("Elemento não pode ser nulo");
        Item item = new Item(elemento, prioridade);
        arvore.inserir(item);
    }

    /**
     * Remove e retorna o elemento com a maior prioridade da fila.
     *
     * @return O elemento com a maior prioridade.
     * @throws NoSuchElementException Se a fila estiver vazia.
     */
    public X dequeue() {
        if (estaVazio()) throw new NoSuchElementException("A fila está vazia");

        try {
            Item itemMaior = getMaiorPrioridade();
            arvore.remova(itemMaior);
            return itemMaior.getElemento();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover o elemento de maior prioridade", e);
        }
    }

    /**
     * Retorna, mas não remove, o elemento com a maior prioridade da fila.
     *
     * @return O elemento com a maior prioridade.
     * @throws NoSuchElementException Se a fila estiver vazia.
     */
    public X peek() {
        if (estaVazio()) throw new NoSuchElementException("A fila está vazia");

        try {
            Item itemMaior = getMaiorPrioridade();
            return itemMaior.getElemento();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao acessar o elemento de maior prioridade", e);
        }
    }

    /**
     * Retorna a quantidade de elementos na fila de prioridade.
     *
     * @return O tamanho da fila.
     */
    public int size() {
        return arvore.tamanho();
    }

    /**
     * Verifica se a fila de prioridade está vazia.
     *
     * @return true se a fila estiver vazia, false caso contrário.
     */
    public boolean estaVazio() {
        return arvore.estaVazio();
    }

    /**
     * Retorna uma representação em string da fila de prioridade.
     *
     * @return String representando a fila de prioridade.
     */
    @Override
    public String toString() {
        return arvore.inOrderTraverse();
    }

    /**
     * Cria e retorna uma cópia profunda da fila de prioridade.
     *
     * @return Uma cópia profunda da fila de prioridade.
     */
    @Override
    @SuppressWarnings("unchecked")
    public PriorityQueueBinarySearchTree<X> clone() {
        try {
            PriorityQueueBinarySearchTree<X> clone = (PriorityQueueBinarySearchTree<X>) super.clone();
            clone.arvore = (ArvoreBinaria<Item>) this.arvore.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Nunca deve acontecer
        }
    }

    /**
     * Verifica se esta fila de prioridade é igual a outro objeto.
     *
     * @param obj O objeto a ser comparado.
     * @return true se os objetos forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        PriorityQueueBinarySearchTree<?> that = (PriorityQueueBinarySearchTree<?>) obj;

        return this.arvore.equals(that.arvore);
    }

    /**
     * Retorna o elemento com a maior prioridade sem removê-lo.
     *
     * @return O item com a maior prioridade.
     * @throws Exception Se a árvore estiver vazia.
     */
    private Item getMaiorPrioridade() throws Exception {
        return arvore.getMaior(); // Supondo que getMaior retorne o Item com a maior prioridade
    }
}
