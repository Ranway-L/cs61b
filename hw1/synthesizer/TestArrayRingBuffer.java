package synthesizer;
import org.junit.Assert;
import org.junit.Test;


/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void Test_Null() {
        ArrayRingBuffer<Integer> arb= new ArrayRingBuffer<>(10);
        Integer a = arb.dequeue();
    }
    @Test
    public void Test_Full() {
        ArrayRingBuffer<Integer> arb= new ArrayRingBuffer<>(3);
        Assert.assertTrue(arb.isEmpty());
        for(int i = 0 ; i < 3 ; i++) {
            arb.enqueue(i);
        }
        Assert.assertTrue(arb.isFull());
    }
    @Test
    public void Test_pop() {
        ArrayRingBuffer<Integer> arb= new ArrayRingBuffer<>(10);
        for(int i = 0 ; i < 5 ; i++) {
            arb.enqueue(i);
        }
        Assert.assertEquals((Integer) 0,arb.dequeue());
        arb.enqueue(55);
        arb.dequeue();
        arb.dequeue();
        arb.dequeue();
        arb.dequeue();
        Assert.assertEquals((Integer) 55,arb.dequeue());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
