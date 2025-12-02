public class DeleteInDLL {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 30, 4, 5 };
        Node head = DLinkedList.convertArrayToDoublyLinkedList(arr);
        // head = deleteHead(head);
        // head = deleteTail(head);
        // head = deleteKthNode(head, 2);
        head = deleteNode(head, 30);

        DLinkedList.printDoublyLinkedList(head);
    }

    static Node deleteHead(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        head = head.next;
        head.back = null;
        temp.next = null;
        return head;
    }

    static Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        Node prev = current.back;
        prev.next = null;
        current.back = null;
        return head;
    }

    static Node deleteKthNode(Node head, int k) {
        if (head == null || k <= 0) {
            return head;
        }
        Node current = head;
        int count = 0;
        while (current != null && count < k) {
            count++;
            if (count == k) {
                break;
            }
            current = current.next;
        }
        if (current == null) {
            return head;
        } else if (current.back == null) {
            return deleteHead(head);
        } else if (current.next == null) {
            return deleteTail(head);
        } else {
            deleteBinding(current);
        }
        return head;
    }

    static Node deleteNode(Node head, int key) {
        if (head == null) {
            return head;
        }
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                break;
            }
            current = current.next;
        }
        if (current == null) {
            return head;
        } else if (current.back == null) {
            return deleteHead(head);
        } else if (current.next == null) {
            return deleteTail(head);
        } else {
            deleteBinding(current);
        }
        return head;
    }

    static void deleteBinding(Node current) {
        Node back = current.back;
        Node next = current.next;
        back.next = next;
        next.back = back;
        current.next = null;
        current.back = null;
    }
}