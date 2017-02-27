/**
 * Created by User on 26.02.2017.
 */
public interface Deque {
    void pushInHead(Object o);
    void pushInTail(Object o);
    Object popHead();
    Object popTail();
    Object showHead();
    Object showTail();
    long size();
}
