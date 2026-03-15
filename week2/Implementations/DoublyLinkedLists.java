public class DoublyLinkedList {

    static class Node {
        int val;
        Node prev;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    Node head;

    // Insert at head
    public void insertAtHead(int val) {
        Node newNode = new Node(val);

        if (head != null) {
            head.prev = newNode;
            newNode.next = head;
        }

        head = newNode;
    }

    // Insert at tail
    public void insertAtTail(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            return;
        }

        Node curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = newNode;
        newNode.prev = curr;
    }

    // Delete node
    public void delete(int key) {

        Node curr = head;

        while (curr != null && curr.val != key) {
            curr = curr.next;
        }

        if (curr == null) return;

        if (curr.prev != null) {
            curr.prev.next = curr.next;
        } else {
            head = curr.next;
        }

        if (curr.next != null) {
            curr.next.prev = curr.prev;
        }
    }

    // Print list
    public void printList() {
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.val + " <-> ");
            curr = curr.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtHead(2);
        list.insertAtHead(1);
        list.insertAtTail(3);
        list.insertAtTail(4);

        list.printList();

        list.delete(3);

        list.printList();
    }
}
