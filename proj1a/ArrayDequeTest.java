import org.junit.Test;

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
        int excepted = 1;
        assertTrue(excepted==item.get(0));
    }
}
