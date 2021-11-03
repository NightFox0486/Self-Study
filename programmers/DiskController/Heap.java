package DiskController;

public class Heap<T> {
    private Node<T> root = null;
    private int size = 0;

    public void push(T value) {
        Node<T> node = new Node<T>(value);
        if (this.isEmpty()) {
            this.root = node;
        } else {

        }
        this.size++;

    }

    public T pop() {
        T value = null;
        if (size == 1) {
            value = root.getValue();
            this.root = null;
        }

        return value;
    }

    public boolean isEmpty() {
        if (this.size == 0)
            return true;
        else
            return false;
    }
}

class Node<E> {
    private E value;
    private Node<E> left;
    private Node<E> right;

    Node(E value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Node<E> getLeft() {
        return this.left;
    }

    public Node<E> getRight() {
        return this.right;
    }

    public void setLeft(Node<E> node) {
        this.left = node;
    }

    public void setRight(Node<E> node) {
        this.right = node;
    }

    public E getValue() {
        return this.value;
    }
}