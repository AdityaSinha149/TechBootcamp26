public class SinglyLinkedList {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node head;

    // Insert at head
    public void insertAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
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
    }

    // Delete by value
    public void delete(int key) {
        if (head == null) return;

        if (head.val == key) {
            head = head.next;
            return;
        }

        Node curr = head;

        while (curr.next != null && curr.next.val != key) {
            curr = curr.next;
        }

        if (curr.next != null) {
            curr.next = curr.next.next;
        }
    }

    // Print list
    public void printList() {
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtHead(3);
        list.insertAtHead(1);
        list.insertAtTail(5);
        list.insertAtTail(7);

        list.printList();

        list.delete(5);

        list.printList();
    }
}
