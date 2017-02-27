/**
 * Created by User on 26.02.2017.
 */
public class ArrayStack implements Stack{
    private Object[] data;
    private int size;

    public ArrayStack(int capacity) {
        data = new Object[capacity];
        size = 0;
    }

    public void push(Object object) {
        data[size++] = object;
    }
    public Object top() {
        return data[size-1];
    }
    public Object pop() {
        return data[--size];
    }
    public int size() {
        return size;
    }
}
