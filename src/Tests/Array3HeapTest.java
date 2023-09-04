import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class Array3HeapTest {
    private final Comparator<Integer> comparator = Comparator.naturalOrder();
    private Array3Heap<Integer> heap = new Array3Heap<>(comparator, 10, 4);

    @Before
    public void setUp() {
        Comparator<Integer> comparator = Comparator.naturalOrder();
        heap = new Array3Heap<>(comparator, 10, 4);
    }

    @Test
    public void testIsEmpty() {
        Assertions.assertTrue(heap.isEmpty());
        heap.add(5);
        Assertions.assertFalse(heap.isEmpty());
        heap.clear();
        Assertions.assertTrue(heap.isEmpty());
    }

    @Test
    public void testSize() {
        Assertions.assertEquals(0, heap.size());
        heap.add(5);
        heap.add(10);
        Assertions.assertEquals(2, heap.size());
        heap.maximum();
        Assertions.assertEquals(1, heap.size());
        heap.clear();
        Assertions.assertEquals(0, heap.size());
    }

    @Test
    public void testMaximum() {
        heap.add(10);
        heap.add(8);
        heap.add(15);
        heap.add(20);
        heap.add(5);
        heap.add(23);
        Assertions.assertEquals(23, (int) heap.maximum());
        Assertions.assertEquals(20, (int) heap.maximum());
        Assertions.assertEquals(15, (int) heap.maximum());
        Assertions.assertEquals(10, (int) heap.maximum());
        Assertions.assertEquals(8, (int) heap.maximum());
        Assertions.assertEquals(5, (int) heap.maximum());
        Assertions.assertTrue(heap.isEmpty());
    }

    @Test
    public void testMinimum() {
        heap.add(10);
        heap.add(8);
        heap.add(15);
        heap.add(20);
        heap.add(5);
        heap.add(23);
        Assertions.assertEquals(5, (int) heap.minimum());
        Assertions.assertEquals(8, (int) heap.minimum());
        Assertions.assertEquals(10, (int) heap.minimum());
        Assertions.assertEquals(15, (int) heap.minimum());
        Assertions.assertEquals(20, (int) heap.minimum());
        Assertions.assertEquals(23, (int) heap.minimum());
        Assertions.assertTrue(heap.isEmpty());
    }

    @Test
    public void testClear() {
        heap.add(10);
        heap.add(5);
        heap.add(15);
        Assertions.assertFalse(heap.isEmpty());
        heap.clear();
        Assertions.assertTrue(heap.isEmpty());
    }

    @Test
    public void testShow() {
        heap.add(10);
        heap.add(8);
        heap.add(15);
        heap.add(20);
        heap.add(5);
        heap.add(23);
        heap.show();
        // Wyświetla elementy w kolejności: 23, 20, 10, 15, 5, 8
    }
}
