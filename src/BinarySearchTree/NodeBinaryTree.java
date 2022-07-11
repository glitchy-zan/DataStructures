package BinarySearchTree;

public class NodeBinaryTree {

    private int data;
    private NodeBinaryTree leftChild;
    private NodeBinaryTree rightChild;                              // CODE SIMPLIFIED FOR YOU

    NodeBinaryTree(int data) {
        this.data = data;
    }

    public void insert(NodeBinaryTree newNode) {
        if (isSmaller(newNode)) {
            if (this.leftChild == null) this.leftChild = newNode;
            else this.leftChild.insert(newNode);
        } else {
            if (this.rightChild == null) this.rightChild = newNode;
            else this.rightChild.insert(newNode);
        }
    }

    public boolean search(NodeBinaryTree searchedNode) {
        if (isSmaller(searchedNode)) {
            if (this.leftChild == null) return false;
            else if (this.leftChild.getData() == searchedNode.getData()) return true;
            else return this.leftChild.search(searchedNode);
        } else {
            if (this.rightChild == null) return false;
            else if (this.rightChild.getData() == searchedNode.getData()) return true;
            else return this.rightChild.search(searchedNode);
        }
    }

    public void delete(NodeBinaryTree deleteNode, NodeBinaryTree parent) {
        if (this.data != deleteNode.getData()) {
            if (isSmaller(deleteNode) && this.leftChild != null) this.leftChild.delete(deleteNode, this);
            else if (!isSmaller(deleteNode) && this.rightChild != null) this.rightChild.delete(deleteNode, this);
        } else {
            if (this.rightChild == null && this.leftChild == null) {
                if (isSmaller(parent)) parent.rightChild = null;
                else parent.leftChild = null;
            } else if (this.rightChild == null) {
                if (isSmaller(parent)) parent.rightChild = this.leftChild;
                else parent.leftChild = this.leftChild;
            } else if (this.leftChild == null) {
                if (isSmaller(parent)) parent.rightChild = this.rightChild;
                else parent.leftChild = this.rightChild;
            } else {
                NodeBinaryTree newNode = new NodeBinaryTree(this.rightChild.getMinNode().getData());
                newNode.leftChild = this.leftChild;
                newNode.rightChild = this.rightChild;
                if (this.rightChild.leftChild == null && this.rightChild.rightChild == null) newNode.rightChild = null;
                this.delete(newNode, parent);
                if (isSmaller(parent)) parent.rightChild = newNode;
                else parent.leftChild = newNode;
            }
        }
    }

    public void showTree() {
        System.out.print(this.data + " ");
        if (this.leftChild != null) this.leftChild.showTree();
        if (this.rightChild != null) this.rightChild.showTree();
    }

    public NodeBinaryTree getMinNode() {
        if (this.leftChild != null) return this.leftChild.getMinNode();
        else return this;
    }

    public boolean isSmaller(NodeBinaryTree node) {
        return node.getData() < this.data;
    }

    public int getData() {
        return data;
    }

    public NodeBinaryTree getLeftChild() {
        return leftChild;
    }

    public NodeBinaryTree getRightChild() {
        return rightChild;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeftChild(NodeBinaryTree leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(NodeBinaryTree rightChild) {
        this.rightChild = rightChild;
    }
}
