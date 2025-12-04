// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;

public class Leetcode148 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(6);
        head.next.next = new Node(3);
        head.next.next.next = new Node(-1);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(0);
        Node result = sortList(head);
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

    // Approach 1 - convert linked list to array and sort it
    // static Node sortList(Node head) {
    // if (head == null) return null;
    // List<Integer> values = new ArrayList<>();
    // Node current = head;
    // while (current != null) {
    // values.add(current.val);
    // current = current.next;
    // }
    // Collections.sort(values);
    // current = head;
    // int index = 0;
    // while (current != null) {
    // current.val = values.get(index++);
    // current = current.next;
    // }
    // return head;
    // }

    // Approach 2 - Merge Sort
    static Node sortList(Node head) {
        if (head == null || head.next == null)
            return head;

        Node mid = findMiddle(head);
        Node right = mid.next;
        mid.next = null;

        Node leftSorted = sortList(head);
        Node rightSorted = sortList(right);
        
        return mergeLinkedList(leftSorted, rightSorted);
    }

    static Node findMiddle(Node node) {
        if (node == null || node.next == null)
            return node;
        Node slow = node;
        Node fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node mergeLinkedList(Node a, Node b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        Node dummy = new Node(0);
        Node tail = dummy;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if (a != null)
            tail.next = a;
        if (b != null)
            tail.next = b;
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
