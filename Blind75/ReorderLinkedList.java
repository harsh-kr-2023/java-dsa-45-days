public class ReorderLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        reorderList(head);
    }
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // Find the tail then rearrange the list one from beggining and one from end
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null; 

    }
}
