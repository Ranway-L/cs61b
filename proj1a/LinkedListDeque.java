public class LinkedListDeque<T> {
    private int size = 0;
    private Node forWard;
    private Node backWard;
    private class Node {
        T item;
        Node next;
        Node prev;
        private Node(T item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
    public LinkedListDeque() {
        forWard = new Node(null, null, null);
        backWard = new Node(null, null, null);
        forWard.next = backWard;
        backWard.prev = forWard;
        size = 0;
    }
//    public LinkedListDeque(LinkedListDeque other) {
//
//    }
    public void addFirst(T item) {
        forWard.next = new Node(item, forWard.next, forWard);
        forWard.next.next.prev = forWard.next;
        size += 1;
    }
    public void addLast(T item) {
        backWard.prev = new Node(item, backWard, backWard.prev);
        backWard.prev.prev.next = backWard.prev;
        size += 1;
    }
    public boolean isEmpty() {
        return forWard.next == backWard;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        Node p = forWard;
        while (p.next != null) {
            p = p.next;
            System.out.print(p.item + " ");
        }

    }
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        Node temp = forWard.next;
        forWard.next = forWard.next.next;
        forWard.next.prev = forWard.next;
        return temp.item;
    }
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        Node temp = backWard.prev;
        backWard.prev = backWard.prev.prev;
        backWard.prev.next = backWard;
        return temp.item;
    }
    public T get(int index) {
        Node p = forWard.next;
        for (int i = 0; i < index; i += 1) {
            p = p.next;
        }
        return p.item;
    }
    public T getRecursive(int index) {
        if (index == 0) {
            return forWard.next.item;
        }
        Node p = forWard.next;
        return getRecursiveHelper(index, p); //Help函数可以用于保存递归函数中的计数变量
    }
    private T getRecursiveHelper(int index, Node p) {
        if (index == 0) {
            return p.item;
        }
        p = p.next;
        return getRecursiveHelper(index - 1, p);
    }
}
