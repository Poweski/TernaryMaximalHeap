import java.util.Comparator;

public class Array3Heap<T> {

    private final Comparator<T> comparator;
    private T[] list;
    private int size = 0;
    private final int d;

    @SuppressWarnings("unchecked")
    public Array3Heap (Comparator<T> comparator, int length, int d) {
        if (length <= 0 || d <= 0)
            throw new IllegalArgumentException();
        this.comparator = comparator;
        this.d = d;
        list = (T[]) new Object[length];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        list = (T[]) new Object[list.length];
        size = 0;
    }

    public int size() {
        return size;
    }

    public void show() {
        for (int i = 0; i < size; i++)
            System.out.println(list[i]);
    }

    public void add(T element) {
        if (element == null)
            throw new IllegalArgumentException();
        if (size == list.length)
            list = copyList(list,size*2);
        list[size++] = element;
        swim(size-1);
    }

    public T minimum() {
        if (size == 0)
            throw new EmptyHeapException();
        T min = list[0];
        int minIndex = 0;
        for (int i = 0; i < size; i++) {
            if (comparator.compare(list[i],min) < 0) {
                min = list[i];
                minIndex = i;
            }
        }
        list[minIndex] = list[size-1];
        list[--size] = null;
        sink(0);
        return min;
    }

    public T maximum() {
        if (isEmpty())
            throw new EmptyHeapException();
        T element = list[0];
        list[0] = list[size-1];
        list[--size] = null;
        sink(0);
        return element;
    }

    private void swap(int firstIndex, int secondIndex) {
        T temp = list[firstIndex];
        list[firstIndex] = list[secondIndex];
        list[secondIndex] = temp;
    }

    private void swim(int index) {
        while (index != 0 && comparator.compare(list[index],list[(index-1)/d]) > 0) {
            swap((index-1)/d, index);
            index = (index-1)/d;
        }
    }

    private void sink(int index) {
        int leftChildIndex = d * index + 1;
        if (leftChildIndex >= size)
            return;
        int maxChildIndex = leftChildIndex;

        for (int i = 1; i < d; i++)
            if (leftChildIndex + i < size && comparator.compare(list[leftChildIndex + i], list[maxChildIndex]) > 0)
                maxChildIndex = leftChildIndex + i;

        if (comparator.compare(list[maxChildIndex], list[index]) > 0) {
            swap(maxChildIndex, index);
            sink(maxChildIndex);
        }
    }

    @SuppressWarnings("unchecked")
    private T[] copyList(T[] list, int length) {
        if (list.length > length)
            throw new FullListException();
        T[] newList = (T[]) new Object[length];
        System.arraycopy(list, 0, newList, 0, list.length);
        return newList;
    }
}