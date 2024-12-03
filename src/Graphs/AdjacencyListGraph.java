package Graphs;

import LinkedList.Unordered.LinkedListUnordered;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;

/**
 * Implementação de um grafo utilizando lista de adjacência com listas encadeadas não ordenadas.
 *
 * @param <E> Tipo dos dados armazenados nos vértices, que devem ser comparáveis.
 */
public class AdjacencyListGraph<E extends Comparable<E>> implements Cloneable {

    /**
     * Classe interna que representa um vértice do grafo.
     */
    private class Vertex implements Cloneable {
        E data;
        LinkedListUnordered<Vertex> adjacentVertices;

        public Vertex(E data) {
            this.data = data;
            adjacentVertices = new LinkedListUnordered<>();
        }

        /**
         * Adiciona um vértice adjacente a este vértice.
         *
         * @param vertex Vértice a ser adicionado.
         * @return {@code true} se o vértice foi adicionado com sucesso, {@code false} se já existia.
         */
        public boolean addAdjacentVertex(Vertex vertex) {
            for (int i = 0; i < adjacentVertices.getTamanho(); i++) {
                Vertex v = adjacentVertices.get(i);
                if (v.data.compareTo(vertex.data) == 0) {
                    return false;
                }
            }
            adjacentVertices.addLast(vertex);
            return true;
        }

        /**
         * Remove um vértice adjacente a este vértice.
         *
         * @param to Dados do vértice a ser removido.
         * @return {@code true} se o vértice foi removido com sucesso, {@code false} caso contrário.
         */
        public boolean removeAdjacentVertex(E to) {
            for (int i = 0; i < adjacentVertices.getTamanho(); i++) {
                Vertex v = adjacentVertices.get(i);
                if (v.data.compareTo(to) == 0) {
                    adjacentVertices.removeAt(i);
                    return true;
                }
            }
            return false;
        }

        /**
         * Construtor de cópia para criar um novo vértice a partir de outro, realizando cópia profunda.
         *
         * @param other          Vértice a ser copiado.
         * @param clonedVertices Mapa para rastrear vértices já clonados e evitar ciclos.
         */
        @SuppressWarnings("unchecked")
        public Vertex(Vertex other, Map<Vertex, Vertex> clonedVertices) {
            // Clonar o campo 'data' utilizando verifyAndCopy
            this.data = (E) verifyAndCopy(other.data);

            // Inicializar a lista de adjacências
            this.adjacentVertices = new LinkedListUnordered<>();

            // Registrar este vértice no mapa de clonagem
            clonedVertices.put(other, this);

            // Clonar cada vértice adjacente
            for (int i = 0; i < other.adjacentVertices.getTamanho(); i++) {
                Vertex adj = other.adjacentVertices.get(i);
                Vertex clonedAdj;

                // Verificar se o vértice adjacente já foi clonado
                if (clonedVertices.containsKey(adj)) {
                    clonedAdj = clonedVertices.get(adj);
                } else {
                    // Clonar o vértice adjacente recursivamente
                    clonedAdj = new Vertex(adj, clonedVertices);
                }

                // Adicionar o vértice adjacente clonado à lista
                this.adjacentVertices.addLast(clonedAdj);
            }
        }

        /**
         * Cria uma cópia profunda do vértice.
         *
         * @param clonedVertices Mapa para rastrear vértices já clonados e evitar ciclos.
         * @return Clonagem profunda do vértice.
         */
        protected Vertex clone(Map<Vertex, Vertex> clonedVertices) {
            if (clonedVertices.containsKey(this))
                return clonedVertices.get(this);
            return new Vertex(this, clonedVertices);
        }

        /**
         * Clona o vértice utilizando o construtor de cópia.
         *
         * @return Clonagem profunda do vértice.
         */
        @Override
        @SuppressWarnings("MethodDoesntCallSuperMethod")
        protected Vertex clone() {
            Map<Vertex, Vertex> clonedVerticesMap = new HashMap<>();
            return clone(clonedVerticesMap);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Vertex: ").append(data).append("\n");
            sb.append("Adjacent vertices: ");
            for (int i = 0; i < adjacentVertices.getTamanho(); i++) {
                Vertex adj = adjacentVertices.get(i);
                sb.append(adj.data).append(" ");
            }
            sb.append("\n");
            return sb.toString();
        }
    }

    private LinkedListUnordered<Vertex> vertices;

    /**
     * Construtor padrão que inicializa o grafo vazio.
     */
    public AdjacencyListGraph() {
        vertices = new LinkedListUnordered<>();
    }

    /**
     * Adiciona um vértice ao grafo.
     *
     * @param data Dados do vértice a ser adicionado.
     * @return {@code true} se o vértice foi adicionado com sucesso, {@code false} se já existia.
     */
    public boolean addVertex(E data) {
        for (int i = 0; i < vertices.getTamanho(); i++) {
            Vertex v = vertices.get(i);
            if (v.data.compareTo(data) == 0) {
                return false;
            }
        }
        vertices.addLast(new Vertex(data));
        return true;
    }

    /**
     * Remove um vértice do grafo e todas as arestas associadas a ele.
     *
     * @param data Dados do vértice a ser removido.
     * @return {@code true} se o vértice foi removido com sucesso, {@code false} se não existia.
     */
    public boolean removeVertex(E data) {
        int vertexIndex = -1;

        // Encontrar o índice do vértice a ser removido
        for (int i = 0; i < vertices.getTamanho(); i++) {
            Vertex v = vertices.get(i);
            if (v.data.compareTo(data) == 0) {
                vertexIndex = i;
                break;
            }
        }

        // Vértice não encontrado
        if (vertexIndex == -1) return false;

        // Remover todas as arestas que apontam para este vértice
        for (int i = 0; i < vertices.getTamanho(); i++) {
            Vertex v = vertices.get(i);
            if (!v.data.equals(data)) {
                v.removeAdjacentVertex(data);
            }
        }

        // Remover o vértice da lista de vértices
        vertices.removeAt(vertexIndex);
        return true;
    }

    /**
     * Verifica se o grafo contém um vértice com os dados especificados.
     *
     * @param data Dados do vértice a ser verificado.
     * @return {@code true} se o vértice existir, {@code false} caso contrário.
     */
    public boolean containsVertex(E data) {
        for (int i = 0; i < vertices.getTamanho(); i++) {
            Vertex v = vertices.get(i);
            if (v.data.compareTo(data) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna o número de vértices no grafo.
     *
     * @return Número de vértices.
     */
    public int size() {
        return vertices.getTamanho();
    }

    /**
     * Remove todos os vértices e arestas do grafo.
     */
    public void clear() {
        vertices.clear();
    }

    /**
     * Retorna um array contendo todos os vértices do grafo.
     *
     * @return Array de vértices.
     */
    public Object[] toArray() {
        Object[] array = new Object[vertices.getTamanho()];
        for (int i = 0; i < vertices.getTamanho(); i++) {
            array[i] = vertices.get(i).data;
        }
        return array;
    }

    /**
     * Retorna uma lista contendo todos os vértices do grafo.
     *
     * @return Lista de vértices.
     */
    public List<E> toList() {
        List<E> list = new ArrayList<>(vertices.getTamanho());
        for (int i = 0; i < vertices.getTamanho(); i++) {
            list.add(vertices.get(i).data);
        }
        return list;
    }

    /**
     * Remove uma aresta entre dois vértices especificados.
     *
     * @param from Dados do vértice de origem.
     * @param to   Dados do vértice de destino.
     * @return {@code true} se a aresta foi removida, {@code false} se não existia.
     */
    public boolean removeEdge(E from, E to) {
        Vertex fromV = getVertex(from);
        if (fromV == null) return false;
        return fromV.removeAdjacentVertex(to);
    }

    /**
     * Adiciona uma aresta entre dois vértices especificados.
     *
     * @param from Dados do vértice de origem.
     * @param to   Dados do vértice de destino.
     * @return {@code true} se a aresta foi adicionada, {@code false} se já existia.
     */
    public boolean addEdge(E from, E to) {
        Vertex fromV = getVertex(from);
        Vertex toV = getVertex(to);

        if (fromV == null) {
            fromV = new Vertex(from);
            vertices.addLast(fromV);
        }

        if (toV == null) {
            toV = new Vertex(to);
            vertices.addLast(toV);
        }

        return fromV.addAdjacentVertex(toV);
    }

    /**
     * Retorna uma representação em string do grafo, listando cada vértice e seus adjacentes.
     *
     * @return String representando o grafo.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vertices.getTamanho(); i++) {
            Vertex v = vertices.get(i);
            sb.append("Vertex: ").append(v.data).append("\n");
            sb.append("Adjacent vertices: ");
            for (int j = 0; j < v.adjacentVertices.getTamanho(); j++) {
                Vertex adj = v.adjacentVertices.get(j);
                sb.append(adj.data).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Verifica se dois grafos são iguais, comparando seus vértices e adjacências.
     *
     * @param obj Objeto a ser comparado.
     * @return {@code true} se os grafos forem iguais, {@code false} caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof AdjacencyListGraph<?> other)) return false;

        if (this.size() != other.size()) return false;

        for (int i = 0; i < this.size(); i++) {
            Vertex thisVertex = this.vertices.get(i);
            AdjacencyListGraph<?>.Vertex otherVertex = other.vertices.get(i);

            if (!thisVertex.data.equals(otherVertex.data))
                return false;

            if (thisVertex.adjacentVertices.getTamanho() != otherVertex.adjacentVertices.getTamanho())
                return false;

            for (int j = 0; j < thisVertex.adjacentVertices.getTamanho(); j++) {
                Vertex thisAdj = thisVertex.adjacentVertices.get(j);
                AdjacencyListGraph<?>.Vertex otherAdj = otherVertex.adjacentVertices.get(j);

                if (!thisAdj.data.equals(otherAdj.data))
                    return false;
            }
        }

        return true;
    }

    /**
     * Calcula o código hash do grafo com base em seus vértices e adjacências.
     *
     * @return Código hash do grafo.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + vertices.hashCode();
        return hash;
    }

    /**
     * Cria uma cópia profunda do grafo.
     *
     * @return Cópia clonada do grafo.
     */
    @Override
    @SuppressWarnings("unchecked")
    public AdjacencyListGraph<E> clone() {
        try {
            AdjacencyListGraph<E> cloned = (AdjacencyListGraph<E>) super.clone();
            cloned.vertices = new LinkedListUnordered<>();

            // Mapeia os vértices originais para os clonados para preservar as referências
            Map<Vertex, Vertex> vertexMap = new HashMap<>();

            // Clonar todos os vértices
            for (int i = 0; i < this.vertices.getTamanho(); i++) {
                Vertex original = this.vertices.get(i);
                Vertex cloneVertex = new Vertex(original.data);
                cloned.vertices.addLast(cloneVertex);
                vertexMap.put(original, cloneVertex);
            }

            // Clonar as adjacências
            for (int i = 0; i < this.vertices.getTamanho(); i++) {
                Vertex original = this.vertices.get(i);
                Vertex cloneVertex = vertexMap.get(original);

                for (int j = 0; j < original.adjacentVertices.getTamanho(); j++) {
                    Vertex originalAdj = original.adjacentVertices.get(j);
                    Vertex cloneAdj = vertexMap.get(originalAdj);
                    if (cloneAdj != null) {
                        cloneVertex.adjacentVertices.addLast(cloneAdj);
                    }
                }
            }

            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Nunca deve acontecer
        }
    }

    /**
     * Retorna uma representação reversa do grafo.
     * OBS: Este metodo inverte as listas de adjacência de cada vértice.
     *
     * @return Novo grafo com adjacências invertidas.
     */
    public AdjacencyListGraph<E> reversed() {
        AdjacencyListGraph<E> reversedGraph = new AdjacencyListGraph<>();

        // Adicionar todos os vértices sem adjacências
        for (int i = 0; i < this.vertices.getTamanho(); i++) {
            Vertex v = this.vertices.get(i);
            reversedGraph.addVertex(v.data);
        }

        // Inverter as adjacências
        for (int i = 0; i < this.vertices.getTamanho(); i++) {
            Vertex v = this.vertices.get(i);
            for (int j = 0; j < v.adjacentVertices.getTamanho(); j++) {
                Vertex adj = v.adjacentVertices.get(j);
                reversedGraph.addEdge(adj.data, v.data);
            }
        }

        return reversedGraph;
    }

    /**
     * Retorna o vértice com os dados especificados.
     *
     * @param data Dados do vértice a ser retornado.
     * @return Vértice encontrado ou {@code null} se não encontrado.
     */
    private Vertex getVertex(E data) {
        for (int i = 0; i < vertices.getTamanho(); i++) {
            Vertex v = vertices.get(i);
            if (v.data.compareTo(data) == 0) {
                return v;
            }
        }
        return null;
    }

    /**
     * Substitui os dados de um vértice por novos dados.
     *
     * @param oldData Dados atuais do vértice.
     * @param newData Novos dados a serem atribuídos.
     * @return {@code true} se a substituição foi realizada, {@code false} se o vértice não foi encontrado ou o novo dado já existe.
     */
    public boolean setVertex(E oldData, E newData) {
        Vertex vertex = getVertex(oldData);
        if (vertex == null) {
            return false;
        }

        // Verificar se o novo dado já existe
        if (containsVertex(newData)) {
            return false;
        }

        vertex.data = newData;

        // Atualizar todas as adjacências que apontam para o antigo dado
        for (int i = 0; i < vertices.getTamanho(); i++) {
            Vertex v = vertices.get(i);
            for (int j = 0; j < v.adjacentVertices.getTamanho(); j++) {
                Vertex adj = v.adjacentVertices.get(j);
                if (adj.data.compareTo(oldData) == 0) {
                    v.adjacentVertices.get(j).data = newData;
                }
            }
        }

        return true;
    }
}
