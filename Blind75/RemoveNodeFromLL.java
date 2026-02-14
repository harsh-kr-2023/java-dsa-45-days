import java.util.List;

public class RemoveNodeFromLL {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int n = 5;
        ListNode newHead = removeNthFromEnd(head, n);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // find the length of the linked list, use a loop to reach the node previous to the node to be removed and node.next = node.next.next
        if (head == null || head.next == null  || n <= 0) {
            return null;
        }
        int count = 0;
        ListNode temp = head;
        while (temp != null) { 
            count++;
            temp = temp.next;
        }
        if(n == count){
            return head.next;
        }
        int k = count - n;
        ListNode current = head;
        for (int i = 0; i < k - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        return head;
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