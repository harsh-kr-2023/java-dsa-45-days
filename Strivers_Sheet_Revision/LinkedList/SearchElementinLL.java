public class SearchElementinLL {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(12);
        head.next.next = new Node(31);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int data = 12;
        System.out.println(searchElement(head, data));
    }

    static boolean searchElement(Node head, int data) {
    
        while (head != null) {
            if (head.data == data) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}