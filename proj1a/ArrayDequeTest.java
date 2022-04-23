import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Optional;

import static org.junit.Assert.*;

public class ArrayDequeTest {
//    public static void main(String[] args) {
//        ArrayDeque<Integer> item = new ArrayDeque<>();
//    }

    @Test
    public void addFirstTest() {
        ArrayDeque<Integer> item = new ArrayDeque<>();
        item.addFirst(1);
        item.addFirst(2);
        item.addFirst(3);
        item.addLast(4);
        int excepted1 = 1;
        int a = item.get(2);
        assertTrue(1==item.get(2));
        assertTrue(2==item.get(1));
        assertTrue(3==item.get(0));
    }
    @Test
    public void add_and_get_Test() {
        ArrayDeque<Integer> item = new ArrayDeque<>();
        item.addFirst(1);
        item.addFirst(2);
        item.removeFirst();
        assertTrue(1 == item.get(0));
    }
    @Test
    public void removeTest() {
        ArrayDeque<Integer> item = new ArrayDeque<>();
        item.addFirst(1);
        item.addFirst(2);
        item.addFirst(3);
        item.addFirst(4);
        item.removeFirst();
        item.removeLast();
        assertTrue(3 == item.get(0));
        assertTrue(2 == item.get(item.size() - 1));
        item.addFirst(7);
        assertTrue(7 == item.get(0));
    }
}
