package LinkedList;

public class LinkedList {

    private NodeLinkedList head;

    public void insertFirst(int newData) {
        NodeLinkedList node = new NodeLinkedList(newData);
        if (this.head == null) this.head = node;
        else {
            this.head.insertFirst(node);
            this.head = node;
        }
    }

    public void insertLast(int newData) {
        NodeLinkedList node = new NodeLinkedList(newData);
        if (head == null) this.head = node;
        else this.head.insertLast(node);
    }

    public boolean search(int searchedData) {
        NodeLinkedList node = new NodeLinkedList(searchedData);
        if (this.head == null) return false;
        else if (node.getData() == head.getData()) return true;
        else return head.search(node);
    }

    public void deleteFirst() {
        this.head = this.head.getNextNode();
    }

    public void deleteLast() {
        if (this.head != null) {
            if (this.head.getNextNode() == null) this.head = null;
            else this.head.deleteLast();
        }
    }

    public void delete(int deleteData) {
        NodeLinkedList node = new NodeLinkedList(deleteData);
        if (this.head != null) {
            if (this.head.getData() == node.getData()) this.head = this.head.getNextNode();
            else this.head.delete(node);
        }
    }

    public void showLinkedList() {
        if (head == null) System.out.println("list is empty");
        else head.showLinkedList();
    }
}
