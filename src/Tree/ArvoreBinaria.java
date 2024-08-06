package Tree;

import LinkedList.Ordered.LinkedListOrdered;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

/**
 * A classe 'ArvoreBinaria’ representa uma árvore binária de busca genérica, onde o tipo de dado armazenado nos nós
 * deve implementar a interface ’Comparable’.
 *
 * @param <T> O tipo de dado armazenado na árvore, que deve implementar a interface `Comparable`.
 */
public class ArvoreBinaria<T extends Comparable<T>> implements Cloneable {

    private No<T> raiz;

    /**
     * Construtor padrão que inicializa uma árvore binária vazia.
     */
    public ArvoreBinaria() {
        raiz = null;
    }

    /**
     * Construtor que cria uma nova árvore binária a partir de um nó raiz.
     *
     * @param raiz O nó raiz da nova árvore binária.
     * @throws IllegalArgumentException Se a raiz fornecida for nula.
     */
    public ArvoreBinaria(No<T> raiz) {
        if (raiz == null) throw new IllegalArgumentException("Raiz nula");
        this.raiz = new No<>(raiz);
    }

    /**
     * Retorna o nó raiz da árvore binária.
     *
     * @return O nó raiz da árvore binária.
     */
    public No<T> getRaiz() {
        return raiz;
    }

    /**
     * Insere um novo valor na árvore binária.
     *
     * @param valor O valor a ser inserido.
     * @throws IllegalArgumentException Se o valor fornecido for nulo ou repetido.
     */
    @SuppressWarnings("unchecked")
    public void inserir(T valor) {
        if (valor == null) throw new IllegalArgumentException("Valor nulo");
        if (contem(valor)) throw new IllegalArgumentException("Valor repetido"); // Verifica se já existe
        No<T> novoNo = (No<T>) verifyAndCopy(new No<>(valor));
        raiz = inserir(raiz, novoNo);
    }

    /**
     * Método recursivo privado para inserir um valor em um nó da árvore.
     * Se o nó atual for nulo, um novo nó é criado com o valor fornecido.
     * Caso contrário, o valor é comparado com o valor do nó atual:
     * - Se o valor for menor, ele é inserido na subárvore esquerda.
     * - Se o valor for maior, ele é inserido na subárvore direita.
     *
     * @param noAtual O nó atual da recursão.
     * @param novoNo  O novo nó a ser inserido.
     * @return O nó atual, potencialmente modificado após a inserção.
     */
    private No<T> inserir(No<T> noAtual, No<T> novoNo) {
        if (noAtual == null) return novoNo; // Se árvore vazia, retorna o novo nó
        if (novoNo.getValor().compareTo(noAtual.getValor()) < 0)
            noAtual.setEsquerda(inserir(noAtual.getEsquerda(), novoNo));
        else if (novoNo.getValor().compareTo(noAtual.getValor()) > 0)
            noAtual.setDireita(inserir(noAtual.getDireita(), novoNo));
        return noAtual; // Se valor é igual, não faz nada (evita duplicatas)
    }

    /**
     * Remove um valor da árvore binária.
     *
     * @param valor O valor a ser removido.
     * @throws Exception Se o valor não for encontrado na árvore.
     */
    public void remova(T valor) throws Exception {
        if (valor == null) throw new Exception("Informação ausente");
        raiz = remova(raiz, valor);
    }

    /**
     * Método recursivo privado para remover um valor da árvore.
     * Este método implementa a lógica de remoção de um nó de uma árvore binária de busca,
     * considerando os diferentes casos:
     * <p>- Caso 1: Nó folha (sem filhos).</p>
     * <p>- Caso 2: Nó com apenas um filho.</p>
     * <p>- Caso 3: Nó com dois filhos.</p>
     *
     * @param noAtual O nó atual a ser verificado.
     * @param valor   O valor a ser removido.
     * @return O nó atual após a remoção do valor.
     * @throws Exception Se o valor não for encontrado na árvore.
     */
    private No<T> remova(No<T> noAtual, T valor) throws Exception {
        if (noAtual == null) throw new Exception("Valor não encontrado na árvore.");

        if (valor.compareTo(noAtual.getValor()) < 0) {
            // Caso 1: Valor menor que o nó atual - pesquisa na subárvore esquerda
            noAtual.setEsquerda(remova(noAtual.getEsquerda(), valor));
        } else if (valor.compareTo(noAtual.getValor()) > 0) {
            // Caso 2: Valor maior que o nó atual - pesquisa na subárvore direita
            noAtual.setDireita(remova(noAtual.getDireita(), valor));
            return noAtual; // Retorna o nó atual - o valor a ser removido não está na subárvore esquerda
        }
        // Caso 3: Valor encontrado no nó atual
        // Caso 3.1: Nó folha (sem filhos) - remove o nó
        if (noAtual.getEsquerda() == null && noAtual.getDireita() == null) return null;
            // Caso 3.2: Nó com apenas um filho - substitui o nó pelo seu único filho
        else if (noAtual.getEsquerda() == null) return noAtual.getDireita();
        else if (noAtual.getDireita() == null) return noAtual.getEsquerda();
        else {
            // Caso 3.3: Nó com dois filhos - encontra o sucessor (menor valor na subárvore direita)
            T sucessor = getMenor(noAtual.getDireita()); // Substitui o valor do nó atual pelo sucessor
            noAtual.setValor(sucessor);// Remove o sucessor da subárvore direita
            noAtual.setDireita(remova(noAtual.getDireita(), sucessor));
        }

        // Retorna o nó atual - o nó foi removido ou atualizado
        return noAtual;
    }

    /**
     * Inicia a travessia in-order na árvore binária.
     *
     * @return Uma string contendo os valores da travessia in-order.
     */
    public String inOrderTraverse() {
        StringBuilder resultado = new StringBuilder();
        inOrderTraverse(raiz, resultado);
        return resultado.toString().trim();
    }

    /**
     * Realiza a travessia in-order na árvore binária.
     * Nesta travessia, os 'nós' são visitados na seguinte ordem: esquerda, raiz, direita.
     *
     * @param no        O nó atual da recursão.
     * @param resultado O StringBuilder onde o resultado da travessia será armazenado.
     */
    private void inOrderTraverse(No<T> no, StringBuilder resultado) {
        if (no != null) {
            inOrderTraverse(no.getEsquerda(), resultado);
            resultado.append(no.getValor()).append(" ");
            inOrderTraverse(no.getDireita(), resultado);
        }
    }

    /**
     * Inicia a travessia pre-order na árvore binária.
     *
     * @return Uma string contendo os valores da travessia pre-order.
     */
    public String preOrderTraverse() {
        StringBuilder resultado = new StringBuilder();
        preOrderTraverse(raiz, resultado);
        return resultado.toString().trim();
    }

    /**
     * Realiza a travessia pre-order na árvore binária.
     * Nesta travessia, os 'nós' são visitados na seguinte ordem: raiz, esquerda, direita.
     *
     * @param no        O nó atual da recursão.
     * @param resultado O StringBuilder onde o resultado da travessia será armazenado.
     */
    private void preOrderTraverse(No<T> no, StringBuilder resultado) {
        if (no != null) {
            resultado.append(no.getValor()).append(" ");
            preOrderTraverse(no.getEsquerda(), resultado);
            preOrderTraverse(no.getDireita(), resultado);
        }
    }

    /**
     * Inicia a travessia post-order na árvore binária.
     *
     * @return Uma string contendo os valores da travessia post-order.
     */
    public String postOrderTraverse() {
        StringBuilder resultado = new StringBuilder();
        postOrderTraverse(raiz, resultado);
        return resultado.toString().trim();
    }

    /**
     * Realiza a travessia post-order na árvore binária.
     * Nesta travessia, os 'nós' são visitados na seguinte ordem: esquerda, direita, raiz.
     *
     * @param no        O nó atual da recursão.
     * @param resultado O StringBuilder onde o resultado da travessia será armazenado.
     */
    private void postOrderTraverse(No<T> no, StringBuilder resultado) {
        if (no != null) {
            postOrderTraverse(no.getEsquerda(), resultado);
            postOrderTraverse(no.getDireita(), resultado);
            resultado.append(no.getValor()).append(" ");
        }
    }
//-------------------------------------------------------------------------

    /**
     * Inicia a travessia in-order na árvore binária e retorna o resultado como uma LinkedList.
     *
     * @return Uma LinkedList contendo os valores da travessia in-order.
     */
    public LinkedList<T> inOrderToList() {
        LinkedList<T> lista = new LinkedList<>();
        inOrderToList(raiz, lista);
        return lista;
    }

    /**
     * Realiza a travessia in-order na árvore binária e armazena o resultado em uma LinkedList.
     *
     * @param no    O nó atual da recursão.
     * @param lista A LinkedList onde o resultado da travessia será armazenado.
     */
    private void inOrderToList(No<T> no, LinkedList<T> lista) {
        if (no != null) {
            inOrderToList(no.getEsquerda(), lista);
            lista.add(no.getValor());
            inOrderToList(no.getDireita(), lista);
        }
    }

    /**
     * Inicia a travessia pre-order na árvore binária e retorna o resultado como uma LinkedList.
     *
     * @return Uma LinkedList contendo os valores da travessia pre-order.
     */
    public LinkedList<T> preOrderToList() {
        LinkedList<T> lista = new LinkedList<>();
        preOrderToList(raiz, lista);
        return lista;
    }

    /**
     * Realiza a travessia pre-order na árvore binária e armazena o resultado em uma LinkedList.
     *
     * @param no    O nó atual da recursão.
     * @param lista A LinkedList onde o resultado da travessia será armazenado.
     */
    private void preOrderToList(No<T> no, LinkedList<T> lista) {
        if (no != null) {
            lista.add(no.getValor());
            preOrderToList(no.getEsquerda(), lista);
            preOrderToList(no.getDireita(), lista);
        }
    }

    /**
     * Inicia a travessia post-order na árvore binária e retorna o resultado como uma LinkedList.
     *
     * @return Uma LinkedList contendo os valores da travessia post-order.
     */
    public LinkedList<T> postOrderToList() {
        LinkedList<T> lista = new LinkedList<>();
        postOrderToList(raiz, lista);
        return lista;
    }

    /**
     * Realiza a travessia post-order na árvore binária e armazena o resultado em uma LinkedList.
     *
     * @param no    O nó atual da recursão.
     * @param lista A LinkedList onde o resultado da travessia será armazenado.
     */
    private void postOrderToList(No<T> no, LinkedList<T> lista) {
        if (no != null) {
            postOrderToList(no.getEsquerda(), lista);
            postOrderToList(no.getDireita(), lista);
            lista.add(no.getValor());
        }
    }

//------------------------------------------------------------------------------------

    /**
     * Inicia a travessia in-order na árvore binária e retorna o resultado como um array.
     *
     * @return Um array contendo os valores da travessia in-order.
     */
    @SuppressWarnings("unchecked")
    public T[] inOrderToArray() {
        ArrayList<T> lista = new ArrayList<>();
        inOrderToArray(raiz, lista);
        return lista.toArray((T[]) Array.newInstance(lista.getFirst().getClass(), lista.size()));
    }

    /**
     * Realiza a travessia in-order na árvore binária e armazena o resultado em um ArrayList.
     *
     * @param no    O nó atual da recursão.
     * @param lista O ArrayList onde o resultado da travessia será armazenado.
     */
    private void inOrderToArray(No<T> no, ArrayList<T> lista) {
        if (no != null) {
            inOrderToArray(no.getEsquerda(), lista);
            lista.add(no.getValor());
            inOrderToArray(no.getDireita(), lista);
        }
    }

    /**
     * Inicia a travessia pre-order na árvore binária e retorna o resultado como um array.
     *
     * @return Um array contendo os valores da travessia pre-order.
     */
    @SuppressWarnings("unchecked")
    public T[] preOrderToArray() {
        ArrayList<T> lista = new ArrayList<>();
        preOrderToArray(raiz, lista);
        return lista.toArray((T[]) Array.newInstance(lista.getFirst().getClass(), lista.size()));
    }

    /**
     * Realiza a travessia pre-order na árvore binária e armazena o resultado em um ArrayList.
     *
     * @param no    O nó atual da recursão.
     * @param lista O ArrayList onde o resultado da travessia será armazenado.
     */
    private void preOrderToArray(No<T> no, ArrayList<T> lista) {
        if (no != null) {
            lista.add(no.getValor());
            preOrderToArray(no.getEsquerda(), lista);
            preOrderToArray(no.getDireita(), lista);
        }
    }

    /**
     * Inicia a travessia post-order na árvore binária e retorna o resultado como um array.
     *
     * @return Um array contendo os valores da travessia post-order.
     */
    @SuppressWarnings("unchecked")
    public T[] postOrderToArray() {
        ArrayList<T> lista = new ArrayList<>();
        postOrderToArray(raiz, lista);
        return lista.toArray((T[]) Array.newInstance(lista.getFirst().getClass(), lista.size()));
    }

    /**
     * Realiza a travessia post-order na árvore binária e armazena o resultado em um ArrayList.
     *
     * @param no    O nó atual da recursão.
     * @param lista O ArrayList onde o resultado da travessia será armazenado.
     */
    private void postOrderToArray(No<T> no, ArrayList<T> lista) {
        if (no != null) {
            postOrderToArray(no.getEsquerda(), lista);
            postOrderToArray(no.getDireita(), lista);
            lista.add(no.getValor());
        }
    }

    /**
     * Verifica se a árvore contém um determinado valor.
     *
     * @param valor O valor a ser procurado.
     * @return true se o valor estiver presente na árvore, false caso contrário.
     */
    public boolean contem(T valor) {
        return contem(raiz, valor);
    }

    /**
     * Método recursivo privado para verificar se um valor está presente em um nó da árvore.
     *
     * @param noAtual O nó atual da recursão.
     * @param valor   O valor a ser procurado.
     * @return true se o valor estiver presente na árvore, false caso contrário.
     */
    private boolean contem(No<T> noAtual, T valor) {
        if (noAtual == null) return false;
        if (valor.compareTo(noAtual.getValor()) == 0) return true;
        if (valor.compareTo(noAtual.getValor()) < 0) return contem(noAtual.getEsquerda(), valor);
        else return contem(noAtual.getDireita(), valor);
    }

    /**
     * Retorna o menor valor presente na árvore.
     *
     * @return O menor valor presente na árvore.
     * @throws Exception Se a árvore estiver vazia.
     */
    public T getMenor() throws Exception {
        if (raiz == null) throw new Exception("A árvore está vazia.");
        return getMenor(raiz);
    }

    /**
     * Método recursivo privado para encontrar o menor valor na subárvore a partir de um determinado nó.
     *
     * @param no O nó atual da recursão.
     * @return O menor valor presente na subárvore.
     */
    @SuppressWarnings("unchecked")
    private T getMenor(No<T> no) {
        if (no.getEsquerda() == null)
            return (T) verifyAndCopy(no.getValor());
        return getMenor(no.getEsquerda());
    }

    /**
     * Retorna o maior valor presente na árvore.
     *
     * @return O maior valor presente na árvore.
     * @throws Exception Se a árvore estiver vazia.
     */
    public T getMaior() throws Exception {
        if (raiz == null) throw new Exception("A árvore está vazia.");
        return getMaior(raiz);
    }

    /**
     * Método recursivo privado para encontrar o maior valor na subárvore a partir de um determinado nó.
     *
     * @param no O nó atual da recursão.
     * @return O maior valor presente na subárvore.
     */
    @SuppressWarnings("unchecked")
    private T getMaior(No<T> no) {
        if (no.getDireita() == null)
            return (T) verifyAndCopy(no.getValor());
        return getMaior(no.getDireita());
    }

    /**
     * Verifica se a árvore está balanceada, ou seja, se a diferença de altura entre as subárvores esquerda e direita
     * de cada nó é no máximo 1.
     *
     * @return `true` se a árvore estiver balanceada, `false` caso contrário.
     */
    public boolean estaBalanceada() {
        return estaBalanceada(raiz); // Inicia a verificação a partir da raiz da árvore.
    }

    /**
     * Metodo recursivo privado para verificar se um nó está balanceado.
     * Este metodo calcula a altura das subárvores esquerda e direita e verifica se a diferença
     * entre elas é menor ou igual a 1. A verificação é realizada recursivamente para todos os nós da árvore.
     *
     * @param no O nó a ser verificado.
     * @return `true` se o nó estiver balanceado, `false` caso contrário.
     */
    private boolean estaBalanceada(No<T> no) {
        if (no == null) return true;

        int alturaEsquerda = altura(no.getEsquerda());
        int alturaDireita = altura(no.getDireita());

        return Math.abs(alturaEsquerda - alturaDireita) <= 1 &&
                estaBalanceada(no.getEsquerda()) &&
                estaBalanceada(no.getDireita());
    }

    /**
     * Realiza uma rotação à esquerda em um determinado nó.
     * A rotação à esquerda é uma operação que muda a estrutura da árvore
     * movendo o filho direito do nó para cima e o nó atual para baixo e para a esquerda.
     *
     * @param no O nó a ser rotacionado.
     * @return O novo nó raiz após a rotação.
     */
    private No<T> rotacaoEsquerda(No<T> no) {
        No<T> novaRaiz = no.getDireita();       // 1. O filho direito do nó se torna a nova raiz da subárvore.
        no.setDireita(novaRaiz.getEsquerda());  // 2. O filho esquerdo da nova raiz se torna o filho direito do nó antigo.
        novaRaiz.setEsquerda(no);               // 3. O nó antigo se torna o filho esquerdo da nova raiz.
        return novaRaiz;
    }

    /**
     * Realiza uma rotação à direita em um determinado nó.
     * A rotação à direita é uma operação que muda a estrutura da árvore
     * movendo o filho esquerdo do nó para cima e o nó atual para baixo e para a direita.
     *
     * @param no O nó a ser rotacionado.
     * @return O novo nó raiz após a rotação.
     */
    private No<T> rotacaoDireita(No<T> no) {
        No<T> novaRaiz = no.getEsquerda();      // 1. O filho esquerdo do nó se torna a nova raiz da subárvore.
        no.setEsquerda(novaRaiz.getDireita());  // 2. O filho direito da nova raiz se torna o filho esquerdo do nó antigo.
        novaRaiz.setDireita(no);                // 3. O nó antigo se torna o filho direito da nova raiz.
        return novaRaiz;
    }

    /**
     * Balanceia a árvore binária utilizando o metodo ’balancear’.
     * Este metodo percorre a árvore recursivamente e realiza rotações
     * para garantir que a árvore esteja balanceada, ou seja, que a diferença
     * de altura entre as subárvores esquerda e direita de cada nó seja no máximo 1.
     */
    public void balancear() {
        raiz = balancear(raiz);
    }

    /**
     * Balanceia a subárvore a partir de um determinado nó usando rotações.
     * Este metodo utiliza as rotações à esquerda e à direita para balancear a árvore.
     * Ele verifica a diferença de altura entre as subárvores esquerda e direita e
     * realiza as rotações necessárias para garantir o balanceamento.
     *
     * @param no O nó a partir do qual a subárvore será balanceada.
     * @return O novo nó raiz da subárvore balanceada.
     */
    private No<T> balancear(No<T> no) {
        if (no == null) return null;

        // Balanceia as subárvores esquerda e direita.
        no.setEsquerda(balancear(no.getEsquerda()));
        no.setDireita(balancear(no.getDireita()));

        // Calcula o fator de balanceamento do nó atual.
        int fatorBalanceamento = altura(no.getEsquerda()) - altura(no.getDireita());

        // Se a subárvore esquerda é mais alta que a direita por mais de 1 nível.
        if (fatorBalanceamento > 1) {
            // Verifica se é necessária uma rotação dupla à direita (LR).
            if (altura(no.getEsquerda().getDireita()) > altura(no.getEsquerda().getEsquerda())) {
                no.setEsquerda(rotacaoEsquerda(no.getEsquerda()));
            }
            // Realiza a rotação à direita.
            no = rotacaoDireita(no);
        }
        // Se a subárvore direita é mais alta que a esquerda por mais de 1 nível.
        else if (fatorBalanceamento < -1) {
            // Verifica se é necessária uma rotação dupla à esquerda (RL).
            if (altura(no.getDireita().getEsquerda()) > altura(no.getDireita().getDireita())) {
                no.setDireita(rotacaoDireita(no.getDireita()));
            }
            // Realiza a rotação à esquerda.
            no = rotacaoEsquerda(no);
        }

        return no; // Retorna o nó balanceado.
    }

    /**
     * Transforma a árvore binária em um LinkedList usando um percurso em ordem.
     *
     * @return O LinkedList contendo os valores da árvore em ordem.
     */
    public LinkedListOrdered<T> toLinkedList() {
        LinkedListOrdered<T> lista = new LinkedListOrdered<>();
        toLinkedList(raiz, lista);
        return lista;
    }

    /**
     * Método recursivo privado para realizar o percurso em ordem e adicionar os valores ao LinkedList.
     *
     * @param no    O nó atual da recursão.
     * @param lista O LinkedList que irá armazenar os valores da árvore.
     */
    private void toLinkedList(No<T> no, LinkedListOrdered<T> lista) {
        if (no != null) {
            toLinkedList(no.getEsquerda(), lista);
            lista.add(no.getValor());
            toLinkedList(no.getDireita(), lista);
        }
    }

    public boolean estaEspelhado(ArvoreBinaria<T> arvore) {
        return estaEspelhado(raiz, arvore.raiz);
    }

    private boolean estaEspelhado(No<T> no1, No<T> no2) {
        if (no1 == null && no2 == null) return true;
        if (no1 == null || no2 == null) return false;
        return no1.getValor().equals(no2.getValor()) &&
                estaEspelhado(no1.getEsquerda(), no2.getDireita()) &&
                estaEspelhado(no1.getDireita(), no2.getEsquerda());
    }

    /**
     * Espelha a árvore binária, trocando as subárvores esquerda e direita de cada nó recursivamente.
     */
    public void espelhar() {
        espelhar(raiz);
    }

    /**
     * Método recursivo privado para espelhar a subárvore a partir de um determinado nó.
     *
     * @param no O nó a partir do qual a subárvore será espelhada.
     */
    private void espelhar(No<T> no) {
        if (no == null) return;

        No<T> temp = no.getEsquerda();

        no.setEsquerda(no.getDireita());
        no.setDireita(temp);

        espelhar(no.getEsquerda());
        espelhar(no.getDireita());
    }

    /**
     * Encontra o nó que contém um determinado valor.
     *
     * @param valor O valor a ser procurado.
     * @return O nó que contém o valor, ou ’null’ se o valor não estiver presente na árvore.
     * @throws IllegalArgumentException Se o valor fornecido for nulo.
     */
    public No<T> achar(T valor) {
        if (valor == null) throw new IllegalArgumentException("Valor nulo");
        return achar(raiz, valor);
    }

    /**
     * Método recursivo privado para encontrar o nó que contém um valor na subárvore a partir de um determinado nó.
     *
     * @param noAtual O nó atual da recursão.
     * @param valor   O valor a ser procurado.
     * @return O nó que contém o valor, ou ’null` se o valor não estiver presente na subárvore.
     */
    private No<T> achar(No<T> noAtual, T valor) {
        if (noAtual == null) return null;
        if (valor.compareTo(noAtual.getValor()) == 0) return noAtual;
        if (valor.compareTo(noAtual.getValor()) < 0) return achar(noAtual.getEsquerda(), valor);
        else return achar(noAtual.getDireita(), valor);
    }

    /**
     * Conta o número de elementos em comum entre esta árvore binária e outra árvore binária
     * fornecida como parâmetro, utilizando os métodos `contem` e `compareTo`.
     *
     * @param arvore A árvore binária a ser comparada com esta árvore.
     * @return O número de elementos em comum entre as duas árvores binárias.
     */
    public int elementosEmComum(ArvoreBinaria<T> arvore) {
        return contarElementosEmComum(arvore, this.raiz);
    }

    /**
     * Método recursivo auxiliar que percorre os nós da árvore e verifica se os valores estão
     * contidos na outra árvore.
     *
     * @param no     O nó atual da árvore que está sendo percorrida.
     * @param arvore A árvore na qual os valores serão procurados.
     * @return O número de elementos em comum encontrados.
     */
    private int contarElementosEmComum(ArvoreBinaria<T> arvore, No<T> no) {
        if (no == null) return 0;

        int emComum = 0;

        // Verifica se o valor do nó atual está contido na outra árvore
        if (arvore.contem(no.getValor())) emComum++;

        // Recursão para os filhos esquerdo e direito
        emComum += contarElementosEmComum(arvore, no.getEsquerda());
        emComum += contarElementosEmComum(arvore, no.getDireita());

        return emComum;
    }

    /**
     * Retorna a altura da árvore, o número de nós no caminho mais longo da raiz até uma folha.
     *
     * @return A altura da árvore.
     */
    public int altura() {
        return altura(raiz);
    }

    /**
     * Método recursivo privado para calcular a altura da subárvore a partir de um determinado nó.
     *
     * @param no O nó a partir do qual a altura será calculada.
     * @return A altura da subárvore.
     */
    private int altura(No<T> no) {
        if (no == null) return -1;

        int alturaEsquerda = altura(no.getEsquerda());
        int alturaDireita = altura(no.getDireita());

        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }

    /**
     * Retorna a profundidade de um determinado nó na árvore, o qual é o número de nós no caminho da raiz até o nó.
     *
     * @param no O nó cuja profundidade será calculada.
     * @return A profundidade do nó, ou -1 se o nó não estiver presente na árvore.
     */
    public int profundidade(No<T> no) {
        return profundidade(raiz, no, 0);
    }

    /**
     * Método recursivo privado para calcular a profundidade de um nó na subárvore a partir de um determinado nó.
     *
     * @param noAtual           O nó atual da recursão.
     * @param noProcurado       O nó cuja profundidade será calculada.
     * @param profundidadeAtual A profundidade atual da recursão.
     * @return A profundidade do nó, ou -1 se o nó não estiver presente na subárvore.
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
     * @return ’true` se a árvore estiver vazia, `false` caso contrário.
     */
    public boolean estaVazio() {
        return raiz == null;
    }

    /**
     * Remove todos os nós da árvore, tornando-a vazia.
     */
    public void limpar() {
        raiz = null;
    }

    /**
     * Retorna o número de nós na árvore.
     *
     * @return O número de nós na árvore.
     */
    public int tamanho() {
        if (raiz == null) return 0;
        return tamanho(raiz);
    }

    /**
     * Método recursivo privado para calcular o número de nós na subárvore a partir de um determinado nó.
     *
     * @param no O nó a partir do qual o número de nós será calculado.
     * @return O número de nós na subárvore.
     */
    private int tamanho(No<T> no) {
        if (no == null) return 0;
        if (no.getEsquerda() == null && no.getDireita() == null) return 1;
        if (no.getEsquerda() == null && no.getDireita() != null) return 1 + tamanho(no.getDireita());
        if (no.getEsquerda() != null && no.getDireita() == null) return 1 + tamanho(no.getEsquerda());
        return 1 + tamanho(no.getEsquerda()) + tamanho(no.getDireita());
    }

    /**
     * Construtor de cópia que cria uma nova árvore binária como uma cópia profunda de outra árvore.
     *
     * @param modelo A árvore binária a ser copiada.
     * @throws IllegalArgumentException Se a árvore fornecida for nula.
     */
    @SuppressWarnings("unchecked")
    public ArvoreBinaria(ArvoreBinaria<T> modelo) {
        if (modelo == null) throw new IllegalArgumentException("Modelo nulo");
        this.raiz = (No<T>) verifyAndCopy(modelo.raiz);
    }

    /**
     * Cria e retorna uma cópia profunda da árvore binária.
     *
     * @return Uma cópia profunda da árvore binária.
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
     * Verifica se a árvore binária é igual a outro objeto.
     * Duas árvores binárias são consideradas iguais se possuem a mesma estrutura e os mesmos valores em cada nó.
     *
     * @param obj O objeto a ser comparado.
     * @return ’true’ se os objetos forem iguais, ‘false’ caso contrário.
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
     * Método recursivo privado para verificar se dois nós somos iguais, incluindo suas subárvores.
     *
     * @param no1 O primeiro nó a ser comparado.
     * @param no2 O segundo nó a ser comparado.
     * @return ’true’ se os nós forem iguais, ’false` caso contrário.
     */
    private boolean equals(No<?> no1, No<?> no2) {
        if (no1 == no2) return true;
        if (no1 == null || no2 == null) return false;

        if (!no1.getValor().equals(no2.getValor())) return false;

        return equals(no1.getEsquerda(), no2.getEsquerda()) &&
                equals(no1.getDireita(), no2.getDireita());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        return hashCode(raiz, prime);
    }

    private int hashCode(No<T> raiz, int prime) {
        if (raiz == null) return 0;

        int result = raiz.getValor().hashCode();
        result *= prime + hashCode(raiz.getEsquerda(), prime);
        result *= prime + hashCode(raiz.getDireita(), prime);
        return result;
    }

    @Override
    public String toString() {
        if (raiz == null) return "{ }";
        return "\n" + toString(0, raiz, "", true, new StringBuilder());
    }

    /**
     * Método recursivo privado para construir a representação textual da subárvore a partir de um determinado nó.
     *
     * @param level         O nível atual da recursão, representando a profundidade do nó.
     * @param no            O nó atual da recursão.
     * @param prefixo       O prefixo a ser adicionado à representação do nó.
     * @param isUltimoFilho `true` se o nó for o último filho de seu pai, `false` caso contrário.
     * @param sb            O StringBuilder usado para construir a representação textual.
     * @return A representação textual da subárvore.
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