public class CircularLinkedList {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    Node head;

    // Insert node
    public void insert(int val) {

        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            head.next = head;
            return;
        }

        Node curr = head;

        while (curr.next != head) {
            curr = curr.next;
        }

        curr.next = newNode;
        newNode.next = head;
    }

    // Delete node
    public void delete(int key) {

        if (head == null) return;

        Node curr = head;
        Node prev = null;

        do {
            if (curr.val == key) {

                if (prev != null) {
                    prev.next = curr.next;
                } else {

                    Node temp = head;

                    while (temp.next != head) {
                        temp = temp.next;
                    }

                    head = curr.next;
                    temp.next = head;
                }

                return;
            }

            prev = curr;
            curr = curr.next;

        } while (curr != head);
    }

    // Print list
    public void printList() {

        if (head == null) return;

        Node curr = head;

        do {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        } while (curr != head);

        System.out.println("(back to head)");
    }

    public static void main(String[] args) {

        CircularLinkedList list = new CircularLinkedList();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        list.printList();

        list.delete(3);

        list.printList();
    }
}
