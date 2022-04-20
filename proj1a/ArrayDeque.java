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
        nextLast = 1;
        load_ratio = 0;
       }
    public void addFirst(T item) {
        if (size == items.length) {
            grow();
        }
        items[nextFirst] = item;
        size++;
        nextFirst = minus_one(nextFirst);
        load_ratio = (float)size / items.length;
    }
    public void addLast(T item) {
        if (size == items.length) {
            grow();
        }
        items[nextLast] = item;
        size++;
        nextLast = plus_one(nextFirst);
        load_ratio = (float)size / items.length;
    }
//    private void resize_array(int capacity) {
//        T[] a = (T[])new Object[capacity];
//        System.arraycopy(items,0,a,0,size);
//        items = a;
//    }
    private int plus_one(int index) {
        if (index == items.length - 1) {
            return 0;
        }
        else {
            return index + 1;
        }
    }

    private int minus_one(int index) {
        if (index == 0) {
            return items.length - 1;
        }
        else {
            return index - 1;
        }
    }
    private void grow() {
        T[] a = (T[])new Object[items.length * 2];
        if (minus_one(nextLast) > plus_one(nextFirst)) {
            System.arraycopy(items,0,a,0,size);
        }
        else {
            System.arraycopy(items,minus_one(nextFirst),a,0,items.length - minus_one(nextFirst));
            System.arraycopy(items,0,a,items.length - minus_one(nextFirst),minus_one(nextLast));
        }
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    private void shrink() {
        T[] a = (T[])new Object[items.length / 2];
        if (minus_one(nextLast) > plus_one(nextFirst)) {
            System.arraycopy(items, 0,  a, 0, size);
        }
        else {
            System.arraycopy(items, minus_one(nextFirst), a, 0, items.length - minus_one(nextFirst));
            System.arraycopy(items,0, a, items.length - minus_one(nextFirst), minus_one(nextLast));
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
        nextFirst = plus_one(nextFirst);
        temp  = get(nextFirst);
        items[nextFirst] = null;
        size--;
        load_ratio = (float)size / items.length;

        if (load_ratio < 0.25) {
           shrink();
        }
        return temp;
    }
    public T removeLast() {
        T temp;
        nextLast = minus_one(nextLast);
        temp = get(nextLast);
        items[nextLast] = null;
        size--;
        load_ratio = (float)size / items.length;
        if (load_ratio < 0.25) {
            shrink();
        }
        return temp;
    }
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        if (minus_one(nextLast) > plus_one(nextFirst)) {  //循环数组未越界情况
            return items[plus_one(nextFirst) + index];
        }
        if (items.length - plus_one(nextFirst) > index) { //循环数组越界情况1
            return items[plus_one(nextFirst) + index];
        }
        //循环数组越界情况2
        return items[plus_one(nextFirst) - items.length + index];
    }
}
