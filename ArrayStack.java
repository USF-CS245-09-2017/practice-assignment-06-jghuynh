/**
 * ArrayStacks that have methods from Stack class
 * @author Justine Huynh
 */
public class ArrayStack<T> implements Stack<T> {

    private int top;
    private int START_SIZE = 10;
    private Object[] tempArray = new Object[START_SIZE];
    private T[] array;

    /**
     * Constructs an object of type ArrayStack
     */
    public ArrayStack()
    {
        top = -1;
        array = (T[]) tempArray;
    }

//    public static <T> T[] createArray(Class<T> type, int size)
//    {
//        return (T[])ArrayStack.newInstance(type, size);
//    }

    /**
     * Adds an item to the stop of the ArrayStack
     * @param item the value to be added
     */
    public void push(T item) {
        if (top == array.length - 1)
        {
            grow_array();
        }
        array[ ++ top] = item; //= array[top + 1]

    }

    /**
     * Removes an item from the top of the ArrayStack
     * @return the item to be removed
     */
    public T pop() {
        if (empty())
        {
            throw new IllegalArgumentException("Sorry! ArrayStack is empty!");
        }
        return array[top --];
        // returns the top of array, then decreases top index
    }

    /**
     * Sees the top item of the ArrayStack
     * @return the top item
     */
    public T peek() {
        if (empty()) {
            try {
                throw new Exception("Sorry! ArrayStack is empty!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return array[top];
    }

    /**
     * Checks if the ArrayStack is empty
     * @return true if the ArrayStack is empty; false otherwise
     */
    public boolean empty()
    {
        return top == -1;
    }

    /**
     * Grows the array to twice its size
     */
    protected void grow_array() {
        Object[] tempArray = new Object[array.length * 2];
        T[] twiceArray = (T[]) tempArray;
        for (int index = 0; index < array.length; index ++)
        {
            twiceArray[index] = array[index];
        }
        array = twiceArray;
    }
}
