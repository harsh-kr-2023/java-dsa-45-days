public class Leetcode2095 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        Node result = removeMiddleNode(head);
        printList(result);
    }

    static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    static Node removeMiddleNode(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            System.out.println("Slow: " + slow.val + ", Fast: " + (fast != null ? fast.val : "null"));
        }
        slow.next = slow.next.next;
        return head;
    }
}

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}
