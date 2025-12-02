public class InsertinDLL {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        Node head = DLinkedList.convertArrayToDoublyLinkedList(arr);
        head = insertAtHead(head, 100);
        head = insertAtTail(head, 200);
        head = insertAtKthPosition(head, 2, 150);
        DLinkedList.printDoublyLinkedList(head);
    }
    static Node insertAtHead(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        newNode.next = head;
        head.back = newNode;
        head = newNode;
        return head;
    }
    static Node insertAtTail(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.back = current;
        return head;
    }
    static Node insertAtKthPosition(Node head, int k, int data) {
        Node newNode = new Node(data);
        if (k <= 0) {
            return head;
        }
        if (k == 1) {
            return insertAtHead(head, data);
        }
        Node current = head;
        int count = 1;
        while (current != null && count < k - 1) {
            count++;
            current = current.next;
        }
        if (current == null) {
            return insertAtTail(head, data);
        }
        Node nextNode = current.next;
        current.next = newNode;
        newNode.back = current;
        newNode.next = nextNode;
        if (nextNode != null) {
            nextNode.back = newNode;
        }
        return head;
    }
}