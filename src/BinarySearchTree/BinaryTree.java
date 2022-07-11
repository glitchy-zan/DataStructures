package BinarySearchTree;

public class BinaryTree {

    private NodeBinaryTree head;

    public void insert(int newData) {
        NodeBinaryTree node = new NodeBinaryTree(newData);
        if (head == null) head = node;
        else head.insert(node);
    }

    public boolean search(int searchedData) {
        NodeBinaryTree node = new NodeBinaryTree(searchedData);
        if (head == null) return false;
        else if (head.getData() == node.getData()) return true;
        else return head.search(node);
    }

    public void delete(int deleteData) {
        NodeBinaryTree node = new NodeBinaryTree(deleteData);
        if (head != null) {
            if (head.getData() == deleteData) {
                if (head.getLeftChild() == null && head.getRightChild() == null) head = null;
                else if (head.getRightChild() == null) head = head.getLeftChild();
                else if (head.getLeftChild() == null) head = head.getRightChild();
                else {
                    NodeBinaryTree newHead = new NodeBinaryTree(head.getRightChild().getMinNode().getData());
                    newHead.setLeftChild(head.getLeftChild());
                    newHead.setRightChild(head.getRightChild());
                    head.delete(newHead, head);
                    head = newHead;
                }
            } else {
                head.delete(node, head);
            }
        }
    }

    public void showTree(){
        if (head == null) System.out.println("this tree is empty");
        else head.showTree();
    }

}
