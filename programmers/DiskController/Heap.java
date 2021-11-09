package DiskController;

public class Heap<T> implements Comparable<Heap> {
    private Object[] list;
    private int size;

    Heap(int size) {
        this.list = new Object[size];
        this.size = 0;
    }

    public void push(T value) {
        this.list[size] = value;
        this.size++;

    }

    public Object pop() {

        return this.list[0];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private int getParent(int index) {
        return index / 2;
    }

    private int getLeft(int index) {
        return index * 2;
    }

    private int getRight(int index) {
        return index * 2 + 1;
    }

    @Override
    public int compareTo(Heap o) {
        // TODO Auto-generated method stub
        return 0;
    }

}

// class Node<E> {
// private E value;
// private Node<E> left;
// private Node<E> right;

// Node(E value) {
// this.value = value;
// this.left = null;
// this.right = null;
// }

// public Node<E> getLeft() {
// return this.left;
// }

// public Node<E> getRight() {
// return this.right;
// }

// public void setLeft(Node<E> node) {
// this.left = node;
// }

// public void setRight(Node<E> node) {
// this.right = node;
// }

// public E getValue() {
// return this.value;
// }
// }