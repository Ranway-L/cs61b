public class LinkedListDeque<T> {
    private int size = 0;
    private Node Forward;
    private Node Backward;
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
        Forward = new Node(null,null,null);
        Backward = new Node(null,null,null);
        Forward.next = Backward;
        Backward.prev = Forward;
        size = 0;
    }
//    public LinkedListDeque(LinkedListDeque other) {
//
//    }
    public void addFirst(T item) {
        Forward.next = new Node(item,Forward.next,Forward);
        size += 1;
    }
    public void addLast(T item) {
        Backward.prev = new Node(item,Backward,Backward.prev);
        size += 1;
    }
    public boolean isEmpty() {
        if (Forward.next == Backward) {
            return true;
        }
        return false;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        Node p = Forward;
        while (p.next != null) {
            p = p.next;
            System.out.print(p.item + " ");
        }

    }
    public T removeFirst() {
        Node temp = Forward.next;
        Forward.next = Forward.next.next;
        Forward.next.prev = Forward.next;
        return temp.item;
    }
    public T removeLast() {
        Node temp = Backward.prev;
        Backward.prev = Backward.prev.prev;
        Backward.prev.next = Backward;
        return temp.item;
    }
    public T get(int index) {
        Node p = Forward;
        for (int i = 0; i < index;i += 1) {
            p = p.next;
        }
        return p.item;
    }
    public T getRecursive(int index) {
        if (index == 0) {
            return null;
        }
        Node p = Forward;
        return getRecursiveHelper(index, p); //Help函数可以用于保存递归函数中的计数变量
    }
    private T getRecursiveHelper(int index, Node p) {
        if (index == 0) {
            return p.item;
        }
        p = p.next;
        return getRecursiveHelper(index-1, p);
    }
}
