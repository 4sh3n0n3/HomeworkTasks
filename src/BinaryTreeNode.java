/**
 * Created by User on 07.04.2017.
 */
public class BinaryTreeNode<T> {
    private BinaryTreeNode<T> parent;
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;
    private T value;

    public boolean hasRightChild() {
        return getRightChild() != null;
    }
    public boolean hasLeftChild() {
        return getLeftChild() != null;
    }

    public void setParent(BinaryTreeNode parent) {
        this.parent = parent;
    }
    public BinaryTreeNode getParent() {
        return parent;
    }

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }
    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }
    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public void setValue(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }
}
