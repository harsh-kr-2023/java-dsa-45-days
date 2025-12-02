public class ReverseDLL {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        Node head = DLinkedList.convertArrayToDoublyLinkedList(arr);
        head = reverseDoublyLinkedList(head);
        DLinkedList.printDoublyLinkedList(head);
    }

    static Node reverseDoublyLinkedList(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node current = head;
        while(current != null) {
            Node temp = current.next;
            current.next = current.back;
            current.back = temp;
            head = current;
            current = temp;
        }
        return head;
    }
}
