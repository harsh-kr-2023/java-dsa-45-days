import java.util.*;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead = reverseList(head);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }

    // Iterative Approach
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null; // Reversed List
        ListNode curr = head; // Current Node
        
        while (curr != null) {
            ListNode next = curr.next; // Save Next Node
            curr.next = prev; // Reverse the pointer
            prev = curr; // Move prev to current
            curr = next; // Move current to next
        }
        return prev;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}