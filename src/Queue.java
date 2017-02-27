/**
 * Created by User on 26.02.2017.
 */
public interface Queue {
    void push(Object object);
    Object first();
    Object pop();
    long size();
}
