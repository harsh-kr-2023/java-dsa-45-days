public class Leetcode234 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        // head.next.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(4);
        boolean result = isPalindrome(head);
        System.out.println("Is palindrome: " + result);
    }

    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node slow = head, fast = head;

        // Find middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Odd length → skip middle node
        if (fast != null) {
            slow = slow.next;
        }

        // Reverse second half
        Node secondHalf = reverseLL(slow);
        Node firstHalf = head;

        // Compare halves
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
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
}

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}