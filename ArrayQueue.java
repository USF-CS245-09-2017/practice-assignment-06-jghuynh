/**
 * An ArrayQueue that has methods from Queue class.
 * @author Justine Huynh
 */
public class ArrayQueue<T> implements Queue<T> {

    private int head;
    private int tail; // tail is the empty space the next item will be put into
    private int SIZE = 10;
    private T[] array;

    /**
     * Constructs an object of type ArrayQueue that has an array of type T
     */
    @SuppressWarnings("Unchecked")
    public ArrayQueue()
    {
        // somehow make type T legal
        Object[] tempArray = (T[]) new Object[SIZE];
        array = (T[]) tempArray;

        head = 0;
        tail = 0;
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
        // if enqueue is full
        if ((tail + 1) % array.length == head)
        {
            growArray();
        }
        // put item at tail before updating tail!
        array[tail] = item;
        tail = (tail + 1) % array.length;
        // wrap around
        if (tail == array.length) {
            tail = 0;
        }
        /*
        array[tail ++] = item;
        tail = tail % array.length;
         */
    }

    /**
     * Grows the array to twice its size
     */
    public void growArray() {
        Object[] tempArray = new Object[2*array.length];
        T[] twiceArray = (T[]) tempArray;
        for (int index = 0; index < array.length; index ++)
        {
            // you're copying array's contents, not tempArray's contents.
            twiceArray[index] = array[(head + index) % array.length];
        }
        // array points to twiceArray
        tail = array.length - 1; // do the math. Tail isn't the last item in a partially-filled array.
        // tail = the first index a new item will be put in

        head = 0;
        array = twiceArray;
    }

    /**
     * Checks if the ArrayQueue is empty
     * @return true if the ArrayQueue is empty; false otherwise
     */
    public boolean empty()
    {
        return head == tail;
    }

    public static void main(String[] args) {
        ArrayQueue myAQ = new ArrayQueue();
        myAQ.enqueue("Hi");
        System.out.println();
    }
}
