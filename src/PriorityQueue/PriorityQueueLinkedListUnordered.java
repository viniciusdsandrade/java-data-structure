package PriorityQueue;

import LinkedList.Unordered.LinkedListUnordered;

import java.util.EmptyStackException;
import java.util.Objects;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;
import static java.lang.Integer.MIN_VALUE;

/**
 * Implementação de uma Fila de Prioridade utilizando LinkedListUnordered.
 *
 * @param <X> Tipo de elementos armazenados na fila de prioridade.
 */
public class PriorityQueueLinkedListUnordered<X> implements Cloneable {

    private static class Item<X> implements Cloneable {
        private X value;
        private int priority;

        // Getters e Setters
        public X getValue() {
            return value;
        }
        public int getPriority() {
            return priority;
        }
        public void setValue(X value) {
            if (value == null) throw new IllegalArgumentException("Valor não pode ser nulo");
            this.value = value;
        }
        public void setPriority(int priority) {
            this.priority = priority;
        }

        // Construtor
        public Item(X value, int priority) {
            if (value == null) throw new IllegalArgumentException("Valor não pode ser nulo");
            this.value = value;
            this.priority = priority;
        }

        @SuppressWarnings("unchecked")
        public Item(Item<X> other) {
            if (other == null) throw new IllegalArgumentException("Item a ser copiado é nulo");
            this.value = (X) verifyAndCopy(other.value);
            this.priority = other.priority;
        }

        @Override
        @SuppressWarnings("MethodDoesntCallSuperMethod")
        protected Item<X> clone() {
            Item<X> clone = null;
            try {
                clone = new Item<>(this);
            } catch (Exception ignored) {
            }
            return clone;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;

            Item<?> other = (Item<?>) obj;

            return this.priority == other.priority &&
                   Objects.equals(this.value, other.value);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int hash = 1;

            hash *= prime + this.value.hashCode();
            hash *= prime + Integer.hashCode(this.priority);

            if (hash < 0) hash = -hash;

            return hash;
        }

        @Override
        public String toString() {
            return "(" + value + ", " + priority + ")";
        }
    }

    private final LinkedListUnordered<Item<X>> list;

    public PriorityQueueLinkedListUnordered() {
        this.list = new LinkedListUnordered<>();
    }

    public PriorityQueueLinkedListUnordered(PriorityQueueLinkedListUnordered<X> model) {
        if (model == null) throw new IllegalArgumentException("Modelo não pode ser nulo");
        this.list = new LinkedListUnordered<>(model.list);
    }

    /**
     * Insere um novo elemento na fila de prioridade.
     *
     * @param x        O valor a ser inserido.
     * @param priority A prioridade do elemento.
     */
    public void enqueue(X x, int priority) {
        Item<X> item = new Item<>(x, priority);
        list.addLast(item);
    }

    /**
     * Retorna o elemento com a maior prioridade sem removê-lo.
     *
     * @return O valor do elemento com a maior prioridade.
     * @throws EmptyStackException Se a fila estiver vazia.
     */
    public X peek() {
        if (list.isEmpty()) throw new EmptyStackException();
        Item<X> highest = findHighestPriorityItem();
        return highest.getValue();
    }

    /**
     * Remove e retorna o elemento com a maior prioridade.
     *
     * @return O valor do elemento removido.
     * @throws EmptyStackException Se a fila estiver vazia.
     */
    public X dequeue() {
        if (list.isEmpty()) throw new EmptyStackException();
        Item<X> highest = findHighestPriorityItem();
        removeItem(highest);
        return highest.getValue();
    }

    /**
     * Verifica se a fila de prioridade está vazia.
     *
     * @return True se vazia, caso contrário, false.
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Retorna o número de elementos na fila de prioridade.
     *
     * @return Tamanho da fila.
     */
    public int size() {
        return list.getTamanho();
    }

    /**
     * Remove todos os elementos da fila de prioridade.
     */
    public void clear() {
        list.clear();
    }

    /**
     * Encontra o Item com a maior prioridade.
     * Se múltiplos itens tiverem a mesma prioridade, retorna o primeiro encontrado (FIFO).
     *
     * @return Item com a maior prioridade.
     */
    private Item<X> findHighestPriorityItem() {
        Item<X> highest = null;
        int highestPriority = MIN_VALUE;

        LinkedListUnordered<Item<X>>.Node current = list.getPrimeiro();
        while (current != null) {
            if (current.elemento.getPriority() > highestPriority) {
                highestPriority = current.elemento.getPriority();
                highest = current.elemento;
            }
            current = current.proximo;
        }

        return highest;
    }

    /**
     * Remove o Item especificado da lista.
     *
     * @param item Item a ser removido.
     */
    private void removeItem(Item<X> item) {
        LinkedListUnordered<Item<X>>.Node current = list.getPrimeiro();
        LinkedListUnordered<Item<X>>.Node previous = null;

        while (current != null) {
            if (current.elemento.equals(item)) {
                if (previous == null) {
                    list.removeFirst(); // Remover o primeiro elemento
                } else {
                    previous.proximo = current.proximo; // Remover elemento intermediário ou último
                    list.tamanho--;
                }
                return;
            }
            previous = current;
            current = current.proximo;
        }
    }


    /**
     * Cria uma cópia profunda da fila de prioridade.
     *
     * @return Cópia clonada da fila de prioridade.
     */
    @Override
    @SuppressWarnings({"MethodDoesntCallSuperMethod", "unchecked"})
    public Object clone() {
        PriorityQueueLinkedListUnordered<X> clone = (PriorityQueueLinkedListUnordered<X>) new PriorityQueueLinkedListUnordered<>();
        LinkedListUnordered<Item<X>>.Node current = this.list.getPrimeiro();
        while (current != null) {
            // Supondo que Item<X> tenha um construtor de cópia
            clone.enqueue((X) current.elemento.clone(), current.elemento.getPriority());
            current = current.proximo;
        }
        return clone;
    }

    /**
     * Verifica a igualdade entre duas filas de prioridade.
     *
     * @param obj Objeto a ser comparado.
     * @return True se iguais, caso contrário, false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        PriorityQueueLinkedListUnordered<?> other = (PriorityQueueLinkedListUnordered<?>) obj;

        return Objects.equals(this.list, other.list);
    }

    /**
     * Calcula o hash code da fila de prioridade.
     *
     * @return Hash code.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        LinkedListUnordered<Item<X>>.Node current = list.getPrimeiro();
        while (current != null) {
            hash *= prime + current.elemento.hashCode();
            current = current.proximo;
        }

        if (hash < 0) hash *= -1;

        return hash;
    }

    /**
     * Retorna uma representação em string da fila de prioridade.
     *
     * @return String representando a fila de prioridade.
     */
    @Override
    public String toString() {
        if (list.isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        LinkedListUnordered<Item<X>>.Node current = list.getPrimeiro();
        while (current != null) {
            sb.append(current.elemento.toString());
            if (current.proximo != null) sb.append(", ");
            current = current.proximo;
        }
        sb.append("]");
        return sb.toString();
    }
}