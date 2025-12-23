public class InsertNodeInDLL {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.prev = null;
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;

        printDoublyLinkedList(insertAtHead(head, 5));
    }

    static Node insertAtHead(Node head, int data) {
        if (head == null) {
            return new Node(data);
        } else {
            Node newNode = new Node(data);
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
        }
        return head;
    }

    static void printDoublyLinkedList(Node head) {
        Node temp = head;

        System.out.print("Forward: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            if (temp.next == null)
                break; // reach tail
            temp = temp.next;
        }

        System.out.print("\nBackward: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
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