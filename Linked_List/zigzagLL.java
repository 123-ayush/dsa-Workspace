public class zigzagLL {
    public static class Node {
        int data;
        Node next;

        public Node(int val) {
            this.data = val;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static Node mid;

    public void insertAtHead(int val) {
        Node temp = new Node(val);

        if (head == null) {
            head = new Node(val);
            tail = head;
            return;
        }

        temp.next = head;
        head = temp;
    }

    public void insertAtEnd(int val) {
        Node temp = new Node(val);

        if (tail == null) {
            tail = new Node(val);
            head = tail;
            return;
        }

        temp.next = tail.next;
        tail.next = temp;
        tail = temp;
    }

    public Node reverse(Node node) {
        Node prev = null;
        Node curr = node;

        while (curr != null) {
            Node fast = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fast;
        }

        return prev;
    }

    public void zigzag() {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        mid = slow;

        mid.next = reverse(mid.next);
        Node mHelp = mid;
        mid = mid.next;

        Node temp = head;
        Node tHelp = temp.next;

        while (mid != null) {
            mHelp.next = mid.next;
            mid.next = tHelp;
            temp.next = mid;

            temp = tHelp;
            tHelp = tHelp.next;
            mid = mHelp.next;
        }
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("Null");
        return;
    }

    public static void main(String[] args) {
        zigzagLL ll = new zigzagLL();

        ll.insertAtHead(0);
        ll.insertAtEnd(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
        ll.insertAtEnd(4);
        ll.insertAtEnd(5);
        // ll.insertAtEnd(6);

        ll.zigzag();
        ll.print();

        return;
    }
}
