public class MyList<Type> {
//    The first item (if it exists) is at sentinel.next.
    private StuffNode sentinel;
    private int size;
    private StuffNode last;

    private class StuffNode {
        Type item;
        StuffNode prev;
        StuffNode next;
        public StuffNode(Type item, StuffNode next) {
            this.item = item;
            this.next = next;
    }
}
    public MyList() {
        sentinel = new StuffNode((Type) "132",null);
        size = 0;
        last = this.sentinel.next;
    }

    public MyList(Type x) {
        sentinel = new StuffNode((Type)"21",null);
        sentinel.next = new StuffNode(x, null);
        size = 1;
        last = sentinel.next;
    }

//    public static void main(String[] args) {
//        MyList L = new MyList();
//    }

        public void addFirst(Type x) {
            sentinel.next = new StuffNode(x, sentinel.next);
            size += 1;
        }

        public Type getFirst() {
            return sentinel.next.item;
        }

        public void addLast(Type x) {    //递归方式怎么写？？
            last.next = new StuffNode(x,null);
            size += 1;
            last = last.next;
        }
        public Type getLast() {
            return last.item;
        }

        public int size() {
            return size;
    }
}

