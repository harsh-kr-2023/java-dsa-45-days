public class LengthOfLL {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println(lengthOfLL(head));
    }
    static int lengthOfLL(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
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