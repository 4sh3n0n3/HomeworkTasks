/**
 Created by DoctorZlo on 09.11.2016.
 */
public class Node {
    private Object value;
    private Node next;
    private Node prev;
    void setValue(Object value) {this.value = value;}
    void setNext(Node next) {this.next = next;}
    void setPrev(Node prev) {this.prev = prev;}
    Object getValue() {
        return this.value;
    }
    Node getNext() {
        return this.next;
    }
    Node getPrev() { return this.prev; }
}
