public class ReverseSLL {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        Node head = MiddleofLL.convertArrayToSinglyLinkedList(arr);
        head = reverseSinglyLinkedList(head);
        printSinglyLinkedList(head);
    }

    static void printSinglyLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    static Node reverseSinglyLinkedList(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node prev = null;
        Node current = head;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
