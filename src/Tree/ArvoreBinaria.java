package Tree;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

/**
 * Representa uma árvore binária.
 *
 * @param <T> O tipo de dado armazenado nos nós da árvore.
 */
public class ArvoreBinaria<T extends Comparable<T>> implements Cloneable {

    private No<T> raiz;

    /**
     * Construtor da classe ArvoreBinaria, inicializando uma árvore vazia.
     */
    public ArvoreBinaria() {
        raiz = null;
    }

    /**
     * Construtor da classe ArvoreBinaria, inicializando a árvore com uma raiz específica.
     * @param raiz O nó a ser definido como raiz da árvore.
     * @throws IllegalArgumentException Se a raiz fornecida for nula.
     */
    public ArvoreBinaria(No<T> raiz) {
        if (raiz == null) throw new IllegalArgumentException("Raiz nula");
        this.raiz = new No<>(raiz);
    }

    /**
     * Insere um valor na árvore.
     *
     * @param valor O valor a ser inserido.
     * @throws IllegalArgumentException Se o valor fornecido for nulo.
     */
    public void inserir(T valor) {
        if (valor == null) throw new IllegalArgumentException("Valor nulo");
        raiz = inserir(raiz, valor);
    }

    /**
     * Método recursivo para inserir um valor na árvore.
     *
     * @param noAtual O nó atual sendo avaliado.
     * @param valor O valor a ser inserido.
     * @return O nó atual após a inserção.
     */
    private No<T> inserir(No<T> noAtual, T valor) {
        if (noAtual == null) return new No<>(valor);
        if (valor.compareTo(noAtual.getValor()) < 0)
            noAtual.setEsquerda(inserir(noAtual.getEsquerda(), valor));
        else if (valor.compareTo(noAtual.getValor()) > 0)
            noAtual.setDireita(inserir(noAtual.getDireita(), valor));
        return noAtual;
    }

    /**
     * Verifica se a árvore contém um determinado valor.
     *
     * @param valor O valor a ser procurado.
     * @return True se o valor estiver presente na árvore, False caso contrário.
     * @throws IllegalArgumentException Se o valor fornecido for nulo.
     */
    public boolean contem(T valor) {
        if (valor == null) throw new IllegalArgumentException("Valor nulo");
        return contem(raiz, valor);
    }

    /**
     * Método recursivo para verificar se um valor está presente na árvore.
     *
     * @param noAtual O nó atual sendo avaliado.
     * @param valor O valor a ser procurado.
     * @return True se o valor estiver presente na árvore, False caso contrário.
     */
    private boolean contem(No<T> noAtual, T valor) {
        if (noAtual == null) return false;
        if (valor.compareTo(noAtual.getValor()) == 0) return true;
        if (valor.compareTo(noAtual.getValor()) < 0)
            return contem(noAtual.getEsquerda(), valor);
        else
            return contem(noAtual.getDireita(), valor);
    }

    /**
     * Encontra e retorna o nó que contém um determinado valor.
     *
     * @param valor O valor a ser procurado.
     * @return O nó que contém o valor, ou null se o valor não estiver presente na árvore.
     * @throws IllegalArgumentException Se o valor fornecido for nulo.
     */
    public No<T> achar(T valor) {
        if (valor == null) throw new IllegalArgumentException("Valor nulo");
        return achar(raiz, valor);
    }

    /**
     * Método recursivo para encontrar o nó que contém um determinado valor.
     *
     * @param noAtual O nó atual sendo avaliado.
     * @param valor O valor a ser procurado.
     * @return O nó que contém o valor, ou null se o valor não estiver presente na árvore.
     */
    private No<T> achar(No<T> noAtual, T valor) {
        if (noAtual == null) return null;
        if (valor.compareTo(noAtual.getValor()) == 0) return noAtual;
        if (valor.compareTo(noAtual.getValor()) < 0)
            return achar(noAtual.getEsquerda(), valor);
        else
            return achar(noAtual.getDireita(), valor);
    }

    /**
     * Retorna a altura da árvore.
     *
     * @return A altura da árvore.
     */
    public int altura() {
        return altura(raiz);
    }

    /**
     * Método recursivo para calcular a altura da árvore.
     *
     * @param no O nó atual sendo avaliado.
     * @return A altura da subárvore com raiz no nó fornecido.
     */
    private int altura(No<T> no) {
        if (no == null) return -1;
        return 1 + Math.max(altura(no.getEsquerda()), altura(no.getDireita()));
    }

    /**
     * Calcula a profundidade de um determinado nó na árvore.
     *
     * @param no O nó cuja profundidade se deseja calcular.
     * @return A profundidade do nó fornecido.
     */
    public int profundidade(No<T> no) {
        return profundidade(raiz, no, 0);
    }

    /**
     * Método recursivo para calcular a profundidade de um nó na árvore.
     *
     * @param noAtual O nó atual sendo avaliado.
     * @param noProcurado O nó cuja profundidade se deseja calcular.
     * @param profundidadeAtual A profundidade atual na recursão.
     * @return A profundidade do nó procurado.
     */
    private int profundidade(No<T> noAtual, No<T> noProcurado, int profundidadeAtual) {
        if (noAtual == null || noAtual == noProcurado) return profundidadeAtual;
        int profundidadeEsquerda = profundidade(noAtual.getEsquerda(), noProcurado, profundidadeAtual + 1);
        if (profundidadeEsquerda != -1) return profundidadeEsquerda;
        return profundidade(noAtual.getDireita(), noProcurado, profundidadeAtual + 1);
    }

    /**
     * Verifica se a árvore está vazia.
     *
     * @return True se a árvore estiver vazia, False caso contrário.
     */
    public boolean estaVazio() {
        return raiz == null;
    }

    /**
     * Limpa a árvore, removendo todos os seus nós.
     */
    public void limpar() {
        raiz = null;
    }

    /**
     * Calcula o tamanho da árvore, ou seja, o número de nós presentes.
     *
     * @return O tamanho da árvore.
     */
    public int tamanho() {
        if (raiz == null) return 0;
        return tamanho(raiz);
    }

    /**
     * Método recursivo para calcular o tamanho da árvore.
     *
     * @param no O nó atual sendo avaliado.
     * @return O tamanho da subárvore com raiz no nó fornecido.
     */
    private int tamanho(No<T> no) {
        if (no == null) return 0;
        if (no.getEsquerda() == null && no.getDireita() == null) return 1;
        if (no.getEsquerda() == null && no.getDireita() != null) return 1 + tamanho(no.getDireita());
        if (no.getEsquerda() != null && no.getDireita() == null) return 1 + tamanho(no.getEsquerda());
        return 1 + tamanho(no.getEsquerda()) + tamanho(no.getDireita());
    }

    /**
     * Construtor de cópia da classe ArvoreBinaria, criando uma cópia profunda da árvore fornecida.
     *
     * @param modelo A árvore a ser copiada.
     * @throws IllegalArgumentException Se o modelo fornecido for nulo.
     */
    @SuppressWarnings("unchecked")
    public ArvoreBinaria(ArvoreBinaria<T> modelo) {
        if (modelo == null) throw new IllegalArgumentException("Modelo nulo");
        this.raiz = (No<T>) verifyAndCopy(modelo.raiz);
    }

    /**
     * Cria e retorna uma cópia profunda da árvore.
     *
     * @return Uma cópia profunda da árvore.
     */
    @Override
    public Object clone() {
        ArvoreBinaria<T> clone = null;
        try {
            clone = new ArvoreBinaria<>(this);
        } catch (Exception ignored) {
        }
        return clone;
    }

    /**
     * Verifica se a árvore atual é igual a outro objeto.
     *
     * @param obj O objeto a ser comparado.
     * @return True se os objetos forem iguais, False caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        ArvoreBinaria<?> that = (ArvoreBinaria<?>) obj;
        return equals(this.raiz, that.raiz);
    }

    /**
     * Método recursivo para comparar a igualdade de dois nós.
     *
     * @param no1 O primeiro nó a ser comparado.
     * @param no2 O segundo nó a ser comparado.
     * @return True se os nós forem iguais, False caso contrário.
     */
    private boolean equals(No<T> no1, No<?> no2) {
        if (no1 == no2) return true;
        if (no1 == null || no2 == null) return false;
        if (!no1.getValor().equals(no2.getValor())) return false;
        return equals(no1.getEsquerda(), no2.getEsquerda()) &&
                equals(no1.getDireita(), no2.getDireita());
    }

    /**
     * Calcula o código hash da árvore.
     *
     * @return O código hash da árvore.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash *= prime + hashCode(raiz, prime);
        if (hash < 0) hash = -hash;
        return hash;
    }

    /**
     * Método recursivo para calcular o código hash da árvore.
     *
     * @param raiz O nó raiz da árvore.
     * @param prime Um valor primo usado no cálculo do hash.
     * @return O código hash da árvore.
     */
    private int hashCode(No<T> raiz, int prime) {
        if (raiz == null) return 0;
        if (raiz.getEsquerda() == null && raiz.getDireita() == null) return prime * raiz.getValor().hashCode();
        if (raiz.getEsquerda() == null && raiz.getDireita() != null)
            return prime * raiz.getValor().hashCode() + hashCode(raiz.getDireita(), prime);
        if (raiz.getEsquerda() != null && raiz.getDireita() == null)
            return prime * raiz.getValor().hashCode() + hashCode(raiz.getEsquerda(), prime);
        return prime * raiz.getValor().hashCode() + hashCode(raiz.getEsquerda(), prime) + hashCode(raiz.getDireita(), prime);
    }

    /**
     * Retorna uma representação em string da árvore.
     *
     * @return Uma representação em string da árvore.
     */
    @Override
    public String toString() {
        if (raiz == null) return "{ }";
        return "\n" + toString(0, raiz, "", true, new StringBuilder());
    }

    /**
     * Método recursivo para construir a representação em string da árvore.
     *
     * @param level O nível atual na recursão.
     * @param no O nó atual sendo avaliado.
     * @param prefixo O prefixo a ser adicionado à linha atual.
     * @param isUltimoFilho Indica se o nó atual é o último filho do seu pai.
     * @param sb O StringBuilder usado para construir a string.
     * @return A representação em string da árvore.
     */
    private String toString(int level, No<T> no, String prefixo, boolean isUltimoFilho, StringBuilder sb) {
        sb.append(prefixo);
        if (level == 0) // Condição para a raiz
            sb.append("[");
        else
            sb.append(isUltimoFilho ? "└─" : "├─").append("[");
        sb.append(no.getValor()).append("]").append("\n");
        String prefixoFilho = prefixo + (isUltimoFilho ? "  " : "│   ");
        if (no.getEsquerda() != null)
            toString(level + 1, no.getEsquerda(), prefixoFilho, false, sb);
        if (no.getDireita() != null)
            toString(level + 1, no.getDireita(), prefixoFilho, true, sb);
        return sb.toString();
    }
}