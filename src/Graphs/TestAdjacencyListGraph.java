package Graphs;

public class TestAdjacencyListGraph {
    public static void main(String[] args) {
        // Criar um grafo de strings
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();

        System.out.println("=== Adicionando Vértices ===");
        System.out.println("Adicionar 'A': " + graph.addVertex("A")); // true
        System.out.println("Adicionar 'B': " + graph.addVertex("B")); // true
        System.out.println("Adicionar 'C': " + graph.addVertex("C")); // true
        System.out.println("Adicionar 'A' novamente: " + graph.addVertex("A")); // false
        System.out.println("Tamanho do grafo: " + graph.size()); // 3
        System.out.println();

        System.out.println("=== Adicionando Arestas ===");
        System.out.println("Adicionar aresta A -> B: " + graph.addEdge("A", "B")); // true
        System.out.println("Adicionar aresta A -> C: " + graph.addEdge("A", "C")); // true
        System.out.println("Adicionar aresta B -> C: " + graph.addEdge("B", "C")); // true
        System.out.println("Adicionar aresta A -> B novamente: " + graph.addEdge("A", "B")); // false
        System.out.println("Tamanho do grafo: " + graph.size()); // 3
        System.out.println();

        System.out.println("=== Estado Atual do Grafo ===");
        System.out.println(graph);
        System.out.println();

        System.out.println("=== Verificando Existência de Vértices ===");
        System.out.println("Contém 'A'? " + graph.containsVertex("A")); // true
        System.out.println("Contém 'D'? " + graph.containsVertex("D")); // false
        System.out.println();

        System.out.println("=== Removendo Aresta A -> B ===");
        System.out.println("Remover aresta A -> B: " + graph.removeEdge("A", "B")); // true
        System.out.println("Remover aresta A -> B novamente: " + graph.removeEdge("A", "B")); // false
        System.out.println("Estado do grafo após remoção:");
        System.out.println(graph);
        System.out.println();

        System.out.println("=== Removendo Vértice 'C' ===");
        System.out.println("Remover vértice 'C': " + graph.removeVertex("C")); // true
        System.out.println("Remover vértice 'C' novamente: " + graph.removeVertex("C")); // false
        System.out.println("Estado do grafo após remoção:");
        System.out.println(graph);
        System.out.println();

        System.out.println("=== Clonando o Grafo ===");
        AdjacencyListGraph<String> clonedGraph = graph.clone();
        System.out.println("Grafo Clonado:");
        System.out.println(clonedGraph.toString());
        System.out.println("São iguais? " + graph.equals(clonedGraph)); // true
        System.out.println();

        System.out.println("=== Modificando o Grafo Clonado ===");
        clonedGraph.addVertex("D");
        clonedGraph.addEdge("D", "A");
        System.out.println("Grafo Clonado após adições:");
        System.out.println(clonedGraph);
        System.out.println("São iguais? " + graph.equals(clonedGraph)); // false
        System.out.println();

        System.out.println("=== Revertendo o Grafo Original ===");
        AdjacencyListGraph<String> reversedGraph = graph.reversed();
        System.out.println("Grafo Revertido:");
        System.out.println(reversedGraph.toString());
        System.out.println();

        System.out.println("=== Substituindo Vértice 'B' por 'E' ===");
        System.out.println("Substituir 'B' por 'E': " + graph.setVertex("B", "E")); // true
        System.out.println("Substituir 'B' por 'E' novamente: " + graph.setVertex("B", "E")); // false (B não existe mais)
        System.out.println("Estado do grafo após substituição:");
        System.out.println(graph);
        System.out.println();

        System.out.println("=== Limpando o Grafo ===");
        graph.clear();
        System.out.println("Grafo após limpar:");
        System.out.println(graph); // Deve estar vazio
        System.out.println("Tamanho do grafo: " + graph.size()); // 0
    }
}
