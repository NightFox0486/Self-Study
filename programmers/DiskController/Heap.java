package DiskController;

public class Heap<E> {
    private Object[] list;
    private int size;

    Heap(int size) {
        this.list = new Object[size];
        this.size = 0;
    }

    public void push(E value) {
        Comparable<E> comp = (Comparable<E>) value;
        int idx = size + 1;
        while (idx > 1) {
            int parent = getParent(idx);
            Object parentVal = list[parent];
            if (comp.compareTo((E) parentVal) >= 0)
                break;
            list[idx] = parentVal;
            idx = parent;
        }
        list[idx] = comp;
        this.size++;
    }

    public E pop() {
        E value = (E)this.list[1];
        this.list[1]=this.list[this.size];
        Comparable<E> comp = (Comparable<E>)this.list[this.getLeft(1)];
        while()
        if(comp.compareTo((E)this.list[this.getRight(1)])>=0){

        }
        this.size--;
        return value;
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