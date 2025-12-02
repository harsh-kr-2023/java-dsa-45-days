class Node {
    int data;
    Node back;
    Node next;

    Node(int data) {
        this.data = data;
    }

    Node(int data, Node back, Node next) {
        this.data = data;
        this.back = back;
        this.next = next;
    }
}

public class DLinkedList {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        Node head = convertArrayToDoublyLinkedList(arr);
        printDoublyLinkedList(head);
        printDoublyLinkedListReversed(head);
    }

    static void printDoublyLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    static void printDoublyLinkedListReversed(Node head) {
        if (head == null)
            return;

        Node tail = head;
        while (tail.next != null) { // reach end
            tail = tail.next;
        }

        while (tail != null) {
            System.out.print(tail.data + " ");
            tail = tail.back;
        }
        System.out.println();
    }

    static Node convertArrayToDoublyLinkedList(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;

        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], prev, null);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
}