import java.util.Objects;
/**
 * Created by User on 07.04.2017.
 */
public class BinarySearchTree {
    private BinaryTreeNode<Integer> root;

    public void add(Integer value) {
        if (root == null) {
            root = new BinaryTreeNode<>();
            root.setValue(value);
        }

        BinaryTreeNode<Integer> currentNode = treeIterationToNode(value, root);
        switch (niceComparator(currentNode.getValue(), value)) {
            case 1: currentNode.setRightChild(new BinaryTreeNode());
                    currentNode.getRightChild().setParent(currentNode);
                    currentNode.getRightChild().setValue(value);
                    break;
            case -1:currentNode.setLeftChild(new BinaryTreeNode());
                    currentNode.getLeftChild().setParent(currentNode);
                    currentNode.getLeftChild().setValue(value);
                    break;
            case 0: break;  //Случай когда элемент существует.
        }
    }

    public boolean isContainValue(Integer value) {
        BinaryTreeNode<Integer> currentNode = treeIterationToNode(value, root);
        if (Objects.equals(currentNode.getValue(), value)) {
            return true;
        }
        return false;
    }

    public void remove(Integer value) {
        BinaryTreeNode<Integer> currentNode = treeIterationToNode(value, root);
        if (currentNode == root) {
            currentNode = currentNode.getRightChild();
            while (currentNode.hasLeftChild()) {
                currentNode = currentNode.getLeftChild();
            }
            currentNode.setLeftChild(root.getLeftChild());
            root = root.getRightChild();
        }
        if (currentNode.getValue() == value) {
            BinaryTreeNode<Integer> parentNode = currentNode.getParent();
            if (parentNode.getValue() > currentNode.getValue()) {
                BinaryTreeNode<Integer> tempNode = currentNode.getRightChild();
                parentNode.setLeftChild(currentNode.getRightChild());
                while (tempNode.hasLeftChild()) {
                    tempNode = tempNode.getLeftChild();
                }
                tempNode.setLeftChild(currentNode.getLeftChild());
            }
            if (parentNode.getValue() < currentNode.getValue()) {
                BinaryTreeNode<Integer> tempNode = currentNode.getLeftChild();
                parentNode.setRightChild(currentNode.getLeftChild());
                while (tempNode.hasLeftChild()) {
                    tempNode = tempNode.getRightChild();
                }
                tempNode.setRightChild(currentNode.getRightChild());
            }
        }
        return;
    }


    //пробегаемся по дереву до интересующего нас узла
    private BinaryTreeNode treeIterationToNode(Integer value, BinaryTreeNode<Integer> node) {
        switch (niceComparator(node.getValue(), value)) {
            case 1 : if (node.hasRightChild()) {
                treeIterationToNode(value, node.getRightChild());
            } else return node.getRightChild();
            break;
            case -1: if (node.hasLeftChild()) {
                treeIterationToNode(value, node.getLeftChild());
            } else return node.getLeftChild();
            break;
            case 0: return node;
        }
        return null;
    }

    // для удобного и приятного свитчера
    private byte niceComparator(Integer firstValue, Integer secondValue) {
        if (firstValue > secondValue) {
            return 1;
        } else if (firstValue < secondValue) {
            return -1;
        }
        return 0;
    }
}
