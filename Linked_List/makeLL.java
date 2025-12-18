public class makeLL {
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

    public void insertAtIdx(int val, int idx) {
        if (idx == 0) {
            insertAtHead(val);
        }

        Node temp = new Node(val);

        int i = 0;
        Node iter = head;
        while (iter.next != null && i < idx - 1) {
            iter = iter.next;
            i++;
        }

        if (iter.next == null && i < idx - 1) {
            System.out.println("Error: Index " + idx + " is out of bound.");
            return;
        }

        temp.next = iter.next;
        iter.next = temp;

        if (temp.next == null) {
            tail = temp;
        }
    }

    public void deleteAtHead() {
        if (head == null) {
            System.out.println("Error: List is empty.");
            return;
        }

        head = head.next;
    }

    public void deleteAtTail() {
        if (head == null) {
            System.out.println("Error: List is empty.");
            return;
        }

        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }

        temp.next = tail.next;
    }

    public void deleteAtIdx(int idx) {
        if (head == null) {
            System.out.println("Error: List is empty.");
            return;
        }

        int i = 0;
        Node temp = head;

        while (temp.next != null && i < idx - 1) {
            temp = temp.next;
            i++;
        }

        if (temp.next == null && i < idx - 1) {
            System.out.println("Error: Index " + idx + " is out of bound.");
            return;
        }

        temp.next = temp.next.next;

        if (temp.next == null) {
            tail = temp;
        }
    }

    public boolean linearSearch(int val) {
        if (head == null) {
            return false;
        }

        Node temp = head;

        while (temp != null) {
            if (temp.data == val) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    public int recursiveSearch(Node temp, int val) {
        if (temp == null) {
            return -1;
        }

        if (temp.data == val) {
            return 0;
        }

        int idx = recursiveSearch(temp.next, val);

        if (idx == -1) {
            return -1;
        }

        return idx + 1;
    }

    public void reverse(){
        if(head == null || head.next == null){
            return;
        }

        Node prev = null;
        Node curr = head;
        
        while(curr != null){
            Node nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        tail = head;
        head = prev;
    }

    public void findMid(){
        if(head == null){
            return;
        }

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        mid = slow;
    }

    public static void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("Null");
        return;
    }

    public static void main(String[] args) {
        makeLL ll = new makeLL();
        ll.insertAtHead(0);
        ll.insertAtEnd(1);
        ll.insertAtEnd(3);
        ll.insertAtEnd(4);
        ll.insertAtIdx(2, 2);
        printLL();

        ll.deleteAtIdx(2);
        printLL();

        // System.out.println(ll.recursiveSearch(head, 4));

        // ll.reverse();

        ll.findMid();
        System.out.println(mid.data);
        printLL();
        return;
    }
}