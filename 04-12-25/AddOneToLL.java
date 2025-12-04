public class AddOneToLL {
    public static void main(String[] args) {
        Node head = new Node(9);
        head.next = new Node(9);
        head = addOne(head);
        printList(head);
    }

    static Node addOne(Node head) {
        if (head == null) {
            return new Node(1);
        }
        
        head = reverseLL(head);
        Node current = head;
        while(current != null) {
            if (current.val < 9) {
                current.val += 1;
                break;
            } else {
                current.val = 0;
                if (current.next == null) {
                    current.next = new Node(1);
                    break;
                }
                current = current.next;
            }
        }
        head = reverseLL(head);
        return head;
    }

    static Node reverseLL(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}