package programmers.DiskController;

import java.util.Comparator;

public class Heap<T> implements Comparator<T> {
    private Object[] list;
    private int size;

    Heap(int size) {
        this.list = new Object[size];
        this.size = 0;
    }

    public void push(T value) {
        Comparable<T> comp = (Comparable<T>) value;
        int idx = size + 1;
        while (idx > 1) {
            int parent = getParent(idx);
            Object parentVal = list[parent];
            if (comp.compareTo((T) parentVal) >= 0)
                break;
            list[idx] = parentVal;
            idx = parent;
        }
        list[idx] = comp;
        this.size++;
    }

    public void push(T value, Comparator comp) {
        T comp1 = value;
        int idx = size + 1;
        while (idx > 1) {
            int parent = getParent(idx);
            Object parentVal = list[parent];
            if (comp.compare((T) comp1, (T) parentVal) >= 0)
                break;
            list[idx] = parentVal;
            idx = parent;
        }
        list[idx] = comp1;
        this.size++;
    }

    public T pop() {
        T value = (T) this.list[1];
        this.list[1] = this.list[this.size];
        this.list[this.size] = null;
        Comparable<T> comp = (Comparable<T>) this.list[1];
        int idx = 1;
        this.size--;
        while (idx >= 1) {
            int leftidx = getLeft(idx);
            int rightidx = getRight(idx);
            if (leftidx > size || rightidx > size) {
                break;
            }
            Object leftVal = this.list[leftidx];
            Object rightVal = this.list[rightidx];
            if (((Comparable<T>) leftVal).compareTo((T) rightVal) > 0) {
                if (comp.compareTo((T) rightVal) > 0) {
                    this.list[idx] = rightVal;
                    idx = rightidx;
                    this.list[idx] = comp;
                }
            } else {
                if (comp.compareTo((T) leftVal) > 0) {
                    this.list[idx] = leftVal;
                    idx = leftidx;
                    this.list[idx] = comp;
                }
            }

        }
        return value;
    }

    public T pop(Comparator comp) {
        T value = (T) this.list[1];
        this.list[1] = this.list[this.size];
        T comp1 = (T) this.list[1];
        this.list[this.size] = null;
        // Comparable<E> comp = (Comparable<E>) this.list[1];
        int idx = 1;
        this.size--;
        while (idx >= 1) {
            int leftidx = getLeft(idx);
            int rightidx = getRight(idx);
            if (leftidx > size || rightidx > size) {
                break;
            }
            Object leftVal = this.list[leftidx];
            Object rightVal = this.list[rightidx];
            if (comp.compare((T) leftVal, (T) rightVal) > 0) {
                if (comp.compare(comp1, (T) rightVal) > 0) {
                    this.list[idx] = rightVal;
                    idx = rightidx;
                    this.list[idx] = comp1;
                } else {
                    break;
                }
            } else {
                if (comp.compare(comp1, (T) leftVal) > 0) {
                    this.list[idx] = leftVal;
                    idx = leftidx;
                    this.list[idx] = comp1;
                } else {
                    break;
                }
            }

        }
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

    @Override
    public int compare(T o1, T o2) {
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