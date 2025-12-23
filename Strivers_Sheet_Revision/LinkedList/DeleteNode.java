public class DeleteNode {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        head = deleteHead(head);
        printLinkedList(head);

        int node = 2;
        head = deleteNode(head, node);
        printLinkedList(head);
    }

    static Node deleteHead(Node head) {
        if(head == null) {
            return head;
        }
        head = head.next;
        return head;
    }

    static Node deleteNode(Node head, int node) {
        if(head == null) {
            return head;
        }
        // if head is to be deleted
        if (head.data == node) {
            head = head.next;
            return head;
        }
        // if middle element is to be deleted
        Node current = head;
        while (current.next != null) {
            if (current.next.data == node) {
                if (current.next.next != null) {
                    current.next = current.next.next;
                } else {
                    current.next = null;
                }
                break;
            }
            current = current.next;
        }
        return head;

    }

    static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}