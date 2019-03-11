/**
 * ArrayStacks that have methods from Stack class
 * @author Justine Huynh
 */
public class ArrayStack implements Stack<T> {

    Object[] tempArray = new Object[SIZE];
    T[] array = (T[]) tempArray;
    private int top;
    private int SIZE = 10;

    /**
     * Constructs an object of type ArrayStack
     */
    public ArrayStack() {

        top = -1;
    }

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
        if (empty())
        {
            throw new IllegalArgumentException("Sorry! ArrayStack is empty!");
        }
        return array[top];
    }

    /**
     * Checks if the ArrayStack is empty
     * @return true if the ArrayStack is empty; false otherwise
     */
    public boolean empty() {
        return top == -1;

    }

    /**
     * Grows the array to twice its size
     */
    protected void grow_array() {
        T[] temp = new T[array.length *2];
        for (int index = 0; index < array.length; index ++)
        {
            temp[index] = array[index];
        }
        array = temp;
    }
}
