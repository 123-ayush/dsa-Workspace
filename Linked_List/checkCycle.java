public class checkCycle {
    public static class Node{
        int data;
        Node next;
        public Node(int val){
            this.data = val;
            this.next = null;
        }
    }

    public static boolean check(Node head){
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }

        return false;
    }

    public static void removeCycle(Node head){
        Node fast = head;
        Node slow = head;
        Node prev = head;

        while(fast != null && fast.next != null){
            prev = fast;
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }

        slow = head;
        prev = prev.next;

        while(fast != slow){
            prev = fast;
            fast = fast.next;
            slow = slow.next;
        }

        prev.next = null;
    } 

    public static void print(Node head){
        while(head!=null){
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node temp = new Node(1);
        head.next = temp;
        temp.next = new Node(2);
        temp.next.next = new Node(3);
        temp.next.next.next = new Node(4);
        temp.next.next.next.next = temp;

        if(check(head)){
            removeCycle(head);
        }
        print(head);
        return;
    }
}
