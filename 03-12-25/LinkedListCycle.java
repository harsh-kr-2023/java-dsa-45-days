public class LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static ListNode hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }
    // public static boolean hasCycle(ListNode head) {
    //     if (head == null || head.next == null) {
    //         return false;
    //     }

    //     ListNode slow = head;
    //     ListNode fast = head;

    //     while (fast != null && fast.next != null) {
    //         slow = slow.next;
    //         fast = fast.next.next;

    //         if (slow == fast) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // Build a linked list & add a cycle for testing
    public static void main(String[] args) {

        // Create nodes manually
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Create a cycle: 5 → 3
        head.next.next.next.next.next = head.next.next;

        // System.out.println(hasCycle(head));

        // print linked list
        ListNode cycleNode = hasCycle(head);
        if (cycleNode != null) {
            System.out.println("Cycle detected at node with value: " + cycleNode.val);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}
