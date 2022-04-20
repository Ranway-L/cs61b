public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private float load_ratio;
    public ArrayDeque() {
        items = (T[])new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 0;
        load_ratio = 0;
       }
    public void addFirst(T item) {
        if (size == items.length) {
            grow();
        }
        items[nextFirst] = item;
        size++;
        nextFirst = backward_one(nextFirst);
        load_ratio = size / items.length;
    }
    public void addLast(T item) {
        if (size == items.length) {
            grow();
        }
        items[nextLast] = item;
        size++;
        nextLast = forward_one(nextFirst);
        load_ratio = size / items.length;
    }
//    private void resize_array(int capacity) {
//        T[] a = (T[])new Object[capacity];
//        System.arraycopy(items,0,a,0,size);
//        items = a;
//    }
    private int forward_one(int index) {
        if (index == items.length - 1) {
            return 0;
        }
        else {
            return index + 1;
        }
    }

    private int backward_one(int index) {
        if (index == 0) {
            return items.length - 1;
        }
        else {
            return index - 1;
        }
    }
    private void grow() {
        T[] a = (T[])new Object[items.length * 2];
        if (backward_one(nextLast) > forward_one(nextFirst)) {
            System.arraycopy(items,0,a,0,size);
        }
        else {
            System.arraycopy(items,backward_one(nextFirst),a,0,items.length - backward_one(nextFirst));
            System.arraycopy(items,0,a,items.length - backward_one(nextFirst),backward_one(nextLast));
        }
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    private void shrink() {
        T[] a = (T[])new Object[items.length / 2];
        if (backward_one(nextLast) > forward_one(nextFirst)) {
            System.arraycopy(items, 0,  a, 0, size);
        }
        else {
            System.arraycopy(items, backward_one(nextFirst), a, 0, items.length - backward_one(nextFirst));
            System.arraycopy(items,0, a, items.length - backward_one(nextFirst), backward_one(nextLast));
        }
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        for(int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
         }
    }
    public T removeFirst() {
        T temp;
        nextFirst = forward_one(nextFirst);
        temp  = get(nextFirst);
        items[nextFirst] = null;
        size--;
        load_ratio = size / items.length;

        if (load_ratio < 0.25) {
           shrink();
        }
        return temp;
    }
    public T removeLast() {
        T temp;
        nextLast = backward_one(nextLast);
        temp = get(nextLast);
        items[nextLast] = null;
        size--;
        load_ratio = size / items.length;
        if (load_ratio < 0.25) {
            shrink();
        }
        return temp;
    }
    public T get(int index) {
        return items[index];
    }
}
