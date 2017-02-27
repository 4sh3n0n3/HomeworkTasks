/**
 * Created by User on 26.02.2017.
 */
public class ArrayQueue extends Node implements Queue {
    private Node head;
    private Node tail;
    private long size;

    public void push(Object object) {
        Node node = new Node();
        node.setValue(object);
        if (head == null) {
            head = tail = node;
            size = 0;
        } else {
            head.setNext(node);
            node.setPrev(head);
            head = node;
            size++;
        }
    }
    public Object first() {
        return head.getValue();
    }
    public Object pop() {
        Node node = tail;
        tail = node.getNext();
        tail.setPrev(null);
        size--;
        return node.getValue();
    }
    public long size() {
        return size;
    }
}
