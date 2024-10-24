package PriorityQueue;

import java.util.EmptyStackException;
import java.util.Objects;

import static ShallowOrDeepCopy.ShallowOrDeepCopy.verifyAndCopy;
import static java.lang.Math.round;
import static java.lang.System.arraycopy;

public class PriorityQueue<X> implements Cloneable {

    // Classe interna para representar um elemento com sua prioridade
    private static class Item<X> implements Cloneable {
        private X value;
        private int priority;

        public X getValue() {
            return value;
        }
        public int getPriority() {
            return priority;
        }
        public void setPriority(int priority) {
            this.priority = priority;
        }
        public void setValue(X value) {
            this.value = value;
        }

        Item(X value, int priority) {
            this.value = value;
            this.priority = priority;
        }

        @SuppressWarnings("unchecked")
        Item(Item<X> other) {
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

    private Item<X>[] elements;
    private final int initialSize;
    private int last = -1;

    // Default constructor with initial size 10
    @SuppressWarnings("unchecked")
    public PriorityQueue() {
        this.initialSize = 10;
        this.elements = new Item[initialSize];
    }

    // Constructor with custom initial size
    @SuppressWarnings("unchecked")
    public PriorityQueue(int initialSize) {
        if (initialSize <= 0) throw new IllegalArgumentException("Invalid size");

        this.elements = (Item<X>[]) verifyAndCopy(new Item[initialSize]);
        this.initialSize = initialSize;
    }

    /**
     * Inserts a new element into the priority queue.
     *
     * @param x        The value to be inserted.
     * @param priority The priority of the element.
     */
    @SuppressWarnings("unchecked")
    public void enqueue(X x, int priority) {
        if (x == null) throw new IllegalArgumentException("Null element");

        if (this.isFull()) this.resizeUp();

        this.last++;
        this.elements[this.last] = (Item<X>) new Item<>(verifyAndCopy(x), priority);
    }

    /**
     * Retrieves the element with the highest priority without removing it.
     *
     * @return The value of the element with the highest priority.
     */
    public X peek() {
        if (this.isEmpty()) throw new EmptyStackException();

        int highestPriorityIndex = findHighestPriorityIndex();
        return this.elements[highestPriorityIndex].value;
    }

    /**
     * Removes and returns the element with the highest priority.
     *
     * @return The value of the removed element.
     */
    public X dequeue() {
        if (this.isEmpty()) throw new EmptyStackException();

        int highestPriorityIndex = findHighestPriorityIndex();
        X value = this.elements[highestPriorityIndex].value;

        // Shift elements to fill the gap
        for (int i = highestPriorityIndex; i < this.last; i++) {
            this.elements[i] = this.elements[i + 1];
        }

        this.elements[this.last] = null;
        this.last--;

        if (this.elements.length > this.initialSize &&
            this.last + 1 <= round((float) this.elements.length / 4))
            this.resizeDown();

        return value;
    }

    /**
     * Finds the index of the element with the highest priority.
     * If multiple elements have the same priority, the one inserted earliest is chosen.
     *
     * @return The index of the highest priority element.
     */
    private int findHighestPriorityIndex() {
        int highestPriority = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i <= this.last; i++) {
            if (this.elements[i].priority > highestPriority) {
                highestPriority = this.elements[i].priority;
                index = i;
            }
        }

        return index;
    }

    // Resizes the internal array to double its current size
    @SuppressWarnings("unchecked")
    private void resizeUp() {
        Item<X>[] newElements = new Item[this.elements.length * 2];
        arraycopy(this.elements, 0, newElements, 0, this.elements.length);
        this.elements = newElements;
    }

    // Resizes the internal array to half its current size
    @SuppressWarnings("unchecked")
    private void resizeDown() {
        Item<X>[] newElements = new Item[(int) Math.ceil((float) this.elements.length / 2)];
        arraycopy(this.elements, 0, newElements, 0, newElements.length);
        this.elements = newElements;
    }

    /**
     * Checks if the priority queue is empty.
     *
     * @return True if empty, otherwise false.
     */
    public boolean isEmpty() {
        return this.last == -1;
    }

    /**
     * Checks if the priority queue is full.
     *
     * @return True if full, otherwise false.
     */
    public boolean isFull() {
        return this.last + 1 == this.elements.length;
    }

    /**
     * Returns a string representation of the priority queue.
     *
     * @return A string representing the elements in the queue.
     */
    public String toArray() {
        if (this.isEmpty()) return "[]";
        StringBuilder ret = new StringBuilder("[");
        for (int i = 0; i < this.last; i++)
            ret.append(this.elements[i].value).append(", ");
        ret.append(this.elements[this.last].value).append("]");
        return ret.toString();
    }

    // Copy constructor
    @SuppressWarnings("unchecked")
    public PriorityQueue(PriorityQueue<X> model) {
        if (model == null) throw new IllegalArgumentException("Model is missing");

        this.initialSize = model.initialSize;
        this.last = model.last;
        this.elements = (Item<X>[]) verifyAndCopy(new Item[model.elements.length]);

        for (int i = 0; i <= this.last; i++)
            this.elements[i] = model.elements[i].clone();
    }

    @Override
    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public Object clone() {
        PriorityQueue<X> clone = null;
        try {
            clone = new PriorityQueue<X>(this);
        } catch (Exception ignored) {
        }
        return clone;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        PriorityQueue<?> other = (PriorityQueue<?>) obj;

        if (this.initialSize != other.initialSize) return false;
        if (this.last != other.last) return false;

        for (int i = 0; i <= this.last; i++)
            if (!this.elements[i].value.equals(other.elements[i].value) ||
                this.elements[i].priority != other.elements[i].priority)
                return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + Integer.hashCode(this.initialSize);
        hash *= prime + Integer.hashCode(this.last);

        for (int i = 0; i <= this.last; i++) {
            hash *= prime + this.elements[i].value.hashCode();
            hash *= prime + Integer.hashCode(this.elements[i].priority);
        }

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= this.last; i++) {
            sb.append("(").append(this.elements[i].value).append(", ")
                    .append(this.elements[i].priority).append(")");
            if (i != this.last) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}