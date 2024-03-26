package LinkedList.Disordered;

public class DoubleLinkedListDisordered<X> implements Cloneable {

    public class Node implements Cloneable {
        public X elemento;
        public Node proximo;
        public Node anterior;

        public Node() {
        }

        public Node(X elemento) {
            this.elemento = elemento;
            this.proximo = null;
            this.anterior = null;
        }

        public Node(X elemento, Node proximo, Node anterior) {
            this.elemento = elemento;
            this.proximo = proximo;
            this.anterior = anterior;
        }

        @Override
        public Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }
    }

    public Node primeiro;
    public Node ultimo;

    public DoubleLinkedListDisordered() {
        primeiro = null;
        ultimo = null;
    }

    public Node getPrimeiro() {
        return primeiro;
    }

    public Node getUltimo() {
        return ultimo;
    }

    public void add(X elemento) {
        Node novo = new Node(elemento);

        if (primeiro == null) {
            primeiro = novo;
        } else {
            ultimo.proximo = novo;
            novo.anterior = ultimo;
        }
        ultimo = novo;
    }

    @Override
    public Object clone() {

        DoubleLinkedListDisordered<X> clone = null;

        try {
            clone = new DoubleLinkedListDisordered<>(this);
        } catch (Exception ignored) {
        }

        return clone;
    }

    public DoubleLinkedListDisordered(DoubleLinkedListDisordered<X> modelo) {
        if (modelo == null) throw new IllegalArgumentException("Modelo ausente");

        Node atual = modelo.primeiro;
        Node novo;

        while (atual != null) {
            novo = new Node();
            novo.elemento = atual.elemento;
            novo.anterior = ultimo;
            if (ultimo != null) {
                ultimo.proximo = novo;
            } else {
                primeiro = novo;
            }
            ultimo = novo;
            atual = atual.proximo;
        }
    }

    @Override
    public String toString() {
        if (primeiro == null) {
            return "[]";
        }

        StringBuilder result = new StringBuilder("[");
        Node temp = primeiro;
        boolean primeiroElemento = true;

        while (temp != null) {
            if (!primeiroElemento) {
                result.append(" <-> ");
            } else {
                primeiroElemento = false;
            }
            result.append(temp.elemento);
            temp = temp.proximo;
        }

        result.append("]");
        return result.toString();
    }
}