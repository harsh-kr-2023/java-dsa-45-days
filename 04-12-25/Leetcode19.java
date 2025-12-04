public class Leetcode19 {
    public static void main(String[] args) {
        System.out.println(
                "Given the head of a linked list, remove the nth node from the end of the list and return its head.");
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        int n = 2;
        Node result = removeNthFromEnd(head, n);
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

    // Approach 1 - Find length of linked list and remove nth node from end
    // static Node removeNthFromEnd(Node head, int n) {
    //     if (head == null || head.next == null) {
    //         return null;
    //     }
    //     if(n <= 0){
    //         return head;
    //     }
    //     int count = 0;
    //     Node temp = head;
    //     while (temp != null) { 
    //         count++;
    //         temp = temp.next;
    //     }
    //     if (n == count) {
    //         return head.next;
    //     }
    //     Node current = head;
    //     for (int i = 0; i < count - n - 1; i++) {
    //         current = current.next;
    //     }
    //     current.next = current.next.next;
    //     return head;
    // }

    // Approach 2 - Two pointer approach
    static Node removeNthFromEnd(Node head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        if(n <= 0){
            return head;
        }
        Node dummy = new Node(0);
        dummy.next = head;
        Node fast = dummy;
        Node slow = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}