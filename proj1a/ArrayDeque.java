public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int front;
    private int nextLast;
    private float load_ratio;
    private int contain;
    public ArrayDeque() {
        items = (T[])new Object[8];
        size = 0;
        front = 0;
        nextLast = 0;
        load_ratio = 0;
        contain = 8;
       }
    public void addFirst(T item) {
        front = minus_one(front);     //addFirst指针指向头部，addLast指针指向末尾右移一位。
        items[front] = item;
        size++;
        if (size == items.length) {
            grow();
        }
        load_ratio = (float)size / items.length;


    }
    public void addLast(T item) {
        items[nextLast] = item;
        nextLast = plus_one(nextLast);
        size++;
        if (size == items.length) {
            grow();
        }
        load_ratio = (float)size / items.length;
    }
//    private void resize_array(int capacity) {
//        T[] a = (T[])new Object[capacity];
//        System.arraycopy(items,0,a,0,size);
//        items = a;
//    }
    private int plus_one(int index) {
      /*  if (index == items.length - 1) {
            return 0;
        }
        else {
            return index + 1;
        }*/
        //这方法太tm机智了！
        return (index + contain + 1) % contain;
    }

    private int minus_one(int index) {
    /*  if (index == 0) {
            return items.length - 1;
        }
        else {
            return index - 1;
        }*/
        return (index + contain - 1) % contain;
    }
    private void grow() {
        T[] a = (T[])new Object[items.length * 2];
        items = transform(a);
    }

    private void shrink() {
        T[] a = (T[])new Object[items.length / 2];
        items = transform(a);
    }
    private T[] transform(T[] a) {
        if (nextLast > front) {
            System.arraycopy(items, front,  a, 0, size);
        }
        else {
            System.arraycopy(items, front, a, 0, contain - front);
            System.arraycopy(items,0, a, contain - front, nextLast);
        }
        items = a;
        contain /= 2;
        front = 0;
        nextLast = size;
        return a;
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
        temp  = get(0);
        items[front] = null;
        front = plus_one(front);
        size--;
        load_ratio = (float)size / items.length;
        if (load_ratio < 0.25) {
           shrink();
        }
        return temp;
    }
    public T removeLast() {
        T temp;
        temp  = get(size - 1);
        nextLast = minus_one(nextLast);
        items[nextLast] = null;
        size--;
        load_ratio = (float)size / items.length;
        if (load_ratio < 0.25) {
            shrink();
        }
        return temp;
    }
    public T get(int index) {
        if (index >= size || index < 0 || isEmpty()) {
            return null;
        }
//        if (nextLast > front) {  //循环数组未越界情况   该情况被下方循环数组越界情况1包含
//            return items[front + index];
//        }
//        if (items.length - front > index) { //循环数组越界情况1
//            return items[front + index];
//        }
        if (front + index < contain) {     //等效替代了上述两种情况
            return items[front + index];
        }
        //循环数组越界情况2
        return items[front - items.length + index];
    }
}
