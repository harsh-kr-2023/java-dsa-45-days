public class ReverseDll {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.prev = null;
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;

        printDoublyLinkedList(reverseDLL(head));
    }

    static Node reverseDLL(Node head) {
        if (head == null || head.next == null)
            return head;

        Node current = head;
        Node temp = null;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null)
            head = temp.prev;

        return head;
    }

    static void printDoublyLinkedList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next; // follow whatever next points to
        }

        System.out.println();
    }

}

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}