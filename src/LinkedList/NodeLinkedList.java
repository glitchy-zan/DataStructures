package LinkedList;

public class NodeLinkedList {

    private int data;
    private NodeLinkedList nextNode;

    NodeLinkedList(int data) {
        this.data = data;
    }

    public void insertFirst(NodeLinkedList newNode) {
        newNode.nextNode = this;
    }

    public void insertLast(NodeLinkedList newNode) {
        if (this.nextNode == null) this.nextNode = newNode;
        else this.nextNode.insertLast(newNode);
    }

    public boolean search(NodeLinkedList searchedNode) {
        if (this.nextNode == null) return false;
        else if (this.nextNode.data == searchedNode.data) return true;
        else return this.nextNode.search(searchedNode);
    }

    public void deleteLast() {
        if (this.nextNode.nextNode == null) this.nextNode = null;
        else this.nextNode.deleteLast();
    }

    public void delete(NodeLinkedList deleteNode) {
        if (this.nextNode != null) {
            if (this.nextNode.getData() == deleteNode.getData()) this.nextNode = this.nextNode.nextNode;
            else this.nextNode.delete(deleteNode);
        }
    }

    public void showLinkedList() {
        System.out.print(this.data + " ");
        if (this.nextNode != null) this.nextNode.showLinkedList();
    }

    public int getData() {
        return data;
    }

    public NodeLinkedList getNextNode() {
        return nextNode;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNextNode(NodeLinkedList nextNode) {
        this.nextNode = nextNode;
    }
}
