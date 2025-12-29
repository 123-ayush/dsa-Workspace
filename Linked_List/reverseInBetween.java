public class reverseInBetween {
    class Node{
        int data;
        Node next;

        public Node(int val){
            this.data = val;
            this.next = null;
        }
    }

    public static Node head;

    public void insertAtHead(int val){
        Node newNode = new Node(val);

        if(head == null){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
        return;
    }

    public void reverse(){
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        Node st = head;
        Node end = head;

        while (end.next.next != null) {
            end = end.next;
        }

        Node first = st.next;
        Node last = end.next;
        Node curr = first;
        Node prev = null;

        while (curr != last) {
            Node nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        st.next = prev;
        first.next = last;
    }

    public void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args){
        reverseInBetween ll = new reverseInBetween();

        ll.insertAtHead(6);
        ll.insertAtHead(5);
        ll.insertAtHead(4);
        ll.insertAtHead(3);
        ll.insertAtHead(2);
        ll.insertAtHead(1);
        ll.insertAtHead(0);

        ll.print();

        ll.reverse();

        ll.print();
        
        return;
    }
}
