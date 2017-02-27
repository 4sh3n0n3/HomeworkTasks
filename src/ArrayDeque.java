/**
 * Created by User on 26.02.2017.
 */
public class ArrayDeque extends Node implements Deque{
    private Node head;
    private Node tail;
    private long size;

    private void newDequeCreation(Node node) {
        head = tail = node;
        size = 0;
    }

    public void pushInHead(Object object){
        Node node = new Node();
        node.setValue(object);
        if (head == null) {
            newDequeCreation(node);
        } else {
            head.setNext(node);
            node.setPrev(head);
            head = node;
            size++;
        }
    }
    public void pushInTail(Object object) {
        Node node = new Node();
        node.setValue(object);
        if (head == null) {
            newDequeCreation(node);
        } else {
            tail.setPrev(node);
            node.setNext(tail);
            tail = node;
            size++;
        }
    }
    public Object showHead() {
        return head.getValue();
    }
    public Object showTail() {
        return tail.getValue();
    }
    public Object popHead() {
        Node node = head;
        head = node.getPrev();
        head.setNext(null);
        size--;
        return node.getValue();
    }
    public Object popTail() {
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
