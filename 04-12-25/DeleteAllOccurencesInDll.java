public class DeleteAllOccurencesInDll {
    public static void main(String[] args) {
        // You can add test cases here to test the deleteAllOccurrences method
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(2);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.prev = head.next.next.next;

        int key = 2;
        head = deleteAllOccurrences(head, key);

        // Print the modified list
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    static Node deleteAllOccurrences(Node head, int key) {
        if (head == null) {
            return null;
        }

        Node current = head;
        while (current != null) {
            if (current.data == key) {
                if (current == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else {
                    current.prev.next = current.next;
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    }
                }
            }
            current = current.next;
        }

        return head;
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
}