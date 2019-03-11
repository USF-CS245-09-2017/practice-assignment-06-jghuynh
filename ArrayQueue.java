/**
 * An ArrayQueue that has methods from Queue class.
 * @author Justine Huynh
 */
public class ArrayQueue implements Queue<T> {

    private int head;
    private int tail;
    private int SIZE = 10;

    /**
     * Constructs an object of type ArrayQueue that has an array of type T
     */
    public ArrayQueue()
    {
        // somehow make type T legal
        Object[] tempArray = new Object[SIZE];
        T[] array = (T[]) tempArray;
    }

    /**
     * Removes the head, or the first part of queue
     * @return the head
     */
    public T dequeue()
    {
        // trying to remove an item from an empty queue
        if (empty()) {
            throw new IllegalArgumentException("Sorry! Queue is empty!");
        }

        T temp = array[head];
        head = (head + 1) % array.length;
        return temp;
    }

    /**
     * Adds an item to the ArrayQueue, to the end
     * @param item the value to be added to the ArrayQueue
     */
    public void enqueue(T item) {
        if ((head + 1) % array.length == tail) {
            // if array is full, double size
            T [] temp = new T[array.length *2];
            for (int index = 0; index < array.length; index ++)
            {
                temp[index] = array[index];
            }
            array = temp;
        }
        tail = (tail + 1) % array.length;
        array[tail] = item;
        /*
        array[tail ++] = item;
        tail = tail % array.length;
         */

    }

    /**
     * Checks if the ArrayQueue is empty
     * @return true if the ArrayQueue is empty; false otherwise
     */
    public boolean empty() {
        return head == tail;
    }
}
