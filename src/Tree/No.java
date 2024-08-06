package Tree;

import java.util.Objects;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

/**
 * A classe No representa um nó em uma árvore binária de busca.
 * Cada nó contém um valor do tipo X que implementa a interface Comparable,
 * e referências para os seus filhos esquerdo e direito.
 *
 * @param <X> O tipo de dado armazenado no nó, deve implementar a interface Comparable.
 */
public class No<X extends Comparable<X>> implements Cloneable, Comparable<No<X>> {

    private No<X> esq;
    private X info;
    private No<X> dir;

    /**
     * Construtor padrão que cria um nó vazio.
     */
    public No() {
    }

    /**
     * Construtor que cria um nó com o valor especificado.
     *
     * @param info O valor a ser armazenado no nó, não pode ser nulo.
     * @throws IllegalArgumentException Se o valor fornecido for nulo.
     */
    public No(X info) {
        if (info == null) throw new IllegalArgumentException("Valor nulo");
        this.esq = null;
        this.info = info;
        this.dir = null;
    }

    /**
     * Construtor que cria um nó com uma referência para o filho esquerdo e o valor especificado.
     *
     * @param esq A referência para o filho esquerdo do nó.
     * @param info O valor a ser armazenado no nó, não pode ser nulo.
     * @throws IllegalArgumentException Se o valor fornecido for nulo.
     */
    public No(No<X> esq, X info) {
        if (info == null) throw new IllegalArgumentException("Valor nulo");
        this.esq = esq;
        this.info = info;
        this.dir = null;
    }

    /**
     * Construtor que cria um nó com o valor especificado e uma referência para o filho direito.
     *
     * @param info O valor a ser armazenado no nó, não pode ser nulo.
     * @param dir A referência para o filho direito do nó.
     * @throws IllegalArgumentException Se o valor fornecido for nulo.
     */
    public No(X info, No<X> dir) {
        if (info == null) throw new IllegalArgumentException("Valor nulo");
        this.esq = null;
        this.info = info;
        this.dir = dir;
    }

    /**
     * Construtor que cria um nó com o valor especificado e referências para os filhos esquerdo e direito.
     *
     * @param esq A referência para o filho esquerdo do nó.
     * @param info O valor a ser armazenado no nó.
     * @param dir A referência para o filho direito do nó.
     */
    public No(No<X> esq, X info, No<X> dir) {
        this.esq = esq;
        this.info = info;
        this.dir = dir;
    }

    /**
     * Retorna o valor armazenado no nó, garantindo que seja retornado uma cópia ou o valor original dependendo da configuração de cópia.
     *
     * @return O valor armazenado no nó.
     */
    @SuppressWarnings("unchecked")
    public X getValor() {
        return (X) verifyAndCopy(info);
    }

    /**
     * Retorna a referência para o filho esquerdo do nó.
     *
     * @return A referência para o filho esquerdo do nó.
     */
    public No<X> getEsquerda() {
        return esq;
    }

    /**
     * Retorna a referência para o filho direito do nó.
     *
     * @return A referência para o filho direito do nó.
     */
    public No<X> getDireita() {
        return dir;
    }

    /**
     * Define o valor armazenado no nó.
     *
     * @param valor O novo valor a ser armazenado no nó, não pode ser nulo.
     * @throws IllegalArgumentException Se o valor fornecido for nulo.
     */
    public void setValor(X valor) {
        if (valor == null) throw new IllegalArgumentException("Valor nulo");
        this.info = valor;
    }

    /**
     * Define a referência para o filho esquerdo do nó.
     *
     * @param esquerda A nova referência para o filho esquerdo do nó.
     */
    public void setEsquerda(No<X> esquerda) {
        this.esq = esquerda;
    }

    /**
     * Define a referência para o filho direito do nó.
     *
     * @param direita A nova referência para o filho direito do nó.
     */
    public void setDireita(No<X> direita) {
        this.dir = direita;
    }

    /**
     * Busca um nó na subárvore com raiz neste nó que contém o valor especificado.
     *
     * @param valor O valor a ser buscado.
     * @return O nó que contém o valor, ou nulo se o valor não for encontrado.
     */
    public No<X> buscarNo(X valor) {
        if (valor == null) return null;
        int comparacao = valor.compareTo(this.info);
        if (comparacao == 0) return this;
        if (comparacao < 0 && this.esq != null) return this.esq.buscarNo(valor);
        if (comparacao > 0 && this.dir != null) return this.dir.buscarNo(valor);
        return null;
    }

    /**
     * Busca o valor mínimo na subárvore com raiz neste nó.
     *
     * @return O valor mínimo na subárvore.
     */
    public X buscarMinimo() {
        if (this.esq == null)
            return this.info;
        else
            return this.esq.buscarMinimo();
    }

    /**
     * Busca o valor máximo na subárvore com raiz neste nó.
     *
     * @return O valor máximo na subárvore.
     */
    public X buscarMaximo() {
        if (this.dir == null)
            return this.info;
        else
            return this.dir.buscarMaximo();
    }

    /**
     * Verifica se o nó é uma folha, ou seja, se não possui filhos.
     *
     * @return True se o nó for uma folha, False caso contrário.
     */
    public boolean isFolha() {
        return esq == null && dir == null;
    }

    /**
     * Verifica se o nó possui ambos os filhos.
     *
     * @return True se o nó possuir ambos os filhos, False caso contrário.
     */
    public boolean temAmbosFilhos() {
        return esq != null && dir != null;
    }

    /**
     * Verifica se o nó possui apenas um filho.
     *
     * @return True se o nó possuir apenas um filho, False caso contrário.
     */
    public boolean temUmFilho() {
        return (esq != null && dir == null) || (esq == null && dir != null);
    }

    /**
     * Construtor de cópia que cria um novo nó com base em um nó modelo, realizando uma cópia profunda dos valores.
     *
     * @param modelo O nó modelo a ser copiado, não pode ser nulo.
     * @throws IllegalArgumentException Se o nó modelo fornecido for nulo.
     */
    @SuppressWarnings("unchecked")
    public No(No<X> modelo) {
        if (modelo == null) throw new IllegalArgumentException("Modelo nulo");

        this.info = (X) verifyAndCopy(modelo.getValor());

        if (modelo.esq != null)
            this.esq = new No<>(modelo.esq);
        else
            this.esq = null;

        if (modelo.dir != null)
            this.dir = new No<>(modelo.dir);
        else
            this.dir = null;
    }

    /**
     * Cria e retorna um clone deste nó, realizando uma cópia profunda dos valores.
     *
     * @return Um clone deste nó.
     */
    @Override
    public Object clone() {
        No<X> clone = null;
        try {
            clone = new No<>(this);
        } catch (Exception ignored) {
        }
        return clone;
    }

    /**
     * Verifica se este nó é igual a outro objeto.
     *
     * @param o O objeto a ser comparado.
     * @return True se os objetos forem iguais, False caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        No<?> that = (No<?>) o;
        return Objects.equals(this.info, that.info) &&
                equals(this.esq, that.esq) &&
                equals(this.dir, that.dir);
    }

    /**
     * Método auxiliar para verificar a igualdade entre dois nós, recursivamente.
     *
     * @param no1 O primeiro nó a ser comparado.
     * @param no2 O segundo nó a ser comparado.
     * @return True se os nós forem iguais, False caso contrário.
     */
    private boolean equals(No<X> no1, No<?> no2) {
        if (no1 == no2) return true;
        if (no1 == null || no2 == null) return false;
        if (!no1.info.equals(no2.info)) return false;
        return equals(no1.esq, no2.esq) &&
                equals(no1.dir, no2.dir);
    }

    /**
     * Retorna o código hash para este nó.
     *
     * @return O código hash para este nó.
     */
    @Override
    public int hashCode() {
        return hashCode(this);
    }

    /**
     * Método auxiliar para calcular o código hash de um nó, recursivamente.
     *
     * @param no O nó para o qual o código hash deve ser calculado.
     * @return O código hash do nó.
     */
    private int hashCode(No<X> no) {
        final int prime = 31;
        int hash = 1;
        if (no == null) return 0;
        hash *= prime + ((no.info == null) ? 0 : no.info.hashCode());
        hash *= prime + hashCode(no.esq);
        hash *= prime + hashCode(no.dir);
        if (hash < 0) hash = -hash;
        return hash;
    }

    /**
     * Retorna uma representação em string deste nó, com uma visualização hierárquica da árvore.
     *
     * @return Uma representação em string deste nó.
     */
    @Override
    public String toString() {
        return toString(0);
    }

    /**
     * Método auxiliar recursivo para construir a representação em string da árvore.
     *
     * @param nivel O nível atual na árvore (usado para gerar a indentação).
     * @return A representação em string da subárvore com raiz neste nó.
     */
    private String toString(int nivel) {
        StringBuilder sb = new StringBuilder();
        sb.append("  ".repeat(Math.max(0, nivel))); // Indentação para representar a hierarquia

        sb.append("|- ");
        sb.append(info);
        sb.append("\n");

        if (esq != null)
            sb.append(esq.toString(nivel + 1));
        else
            sb.append(gerarStringFilhoNulo(nivel + 1, "Esq"));

        if (dir != null)
            sb.append(dir.toString(nivel + 1));
        else
            sb.append(gerarStringFilhoNulo(nivel + 1, "Dir"));

        return sb.toString();
    }

    /**
     * Gera a representação em string para um filho nulo.
     *
     * @param nivel O nível do filho nulo.
     * @param tipo  O tipo do filho ("Esq" para esquerdo ou "Dir" para direito).
     * @return A representação em string do filho nulo.
     */
    private String gerarStringFilhoNulo(int nivel, String tipo) {
        StringBuilder sb = new StringBuilder();
        sb.append("  ".repeat(Math.max(0, nivel)));
        sb.append("|- ");
        sb.append(tipo);
        sb.append(": Nulo\n");
        return sb.toString();
    }

    /**
     * Compara este nó com outro nó.
     *
     * @param other O nó a ser comparado.
     * @return Um valor negativo se este nó for menor que o outro nó, zero se forem iguais,
     * ou um valor positivo se este nó for maior que o outro nó.
     * @throws NullPointerException Se o outro nó for nulo.
     */
    @Override
    public int compareTo(No<X> other) {
        if (other == null) throw new NullPointerException("Cannot compare with null node");
        return this.info.compareTo(other.info);
    }
}