import java.util.*;

public class usingLinkedList {
    public static class Node{
        int data;
        Node next;

        public Node(int val){
            this.data = val;
            this.next = null;
        }
    }

    public static class Stack{
        public Node head;

        public void push(int val){
            Node newNode = new Node(val);

            if(head == null){
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        public boolean empty(){
            return (head == null);
        }

        public int pop(){
            if(head == null){
                return -1;
            }

            int top = head.data;
            head = head.next;
            return top;
        }

        public int peek(){
            return head.data;
        }

        public void print(){
            Node temp = head;
            while(temp!=null){
                System.out.println(temp.data);
                temp = temp.next;
            }
        }

        public void pushAtBottom(int val){
            if(empty()){
                push(val);
                return;
            }

            int top = pop();
            pushAtBottom(val);
            push(top);
        }

        public void reverse(){
            if(empty()){
                return;
            }

            int top = pop();
            reverse();
            pushAtBottom(top);
        }

        public int[] stockSpan(int[] price){
            int n = price.length;
            int[] span = new int[n];

            push(0);
            span[0] = 1;

            for(int i = 1; i<n; i++){
                while(!empty() && price[peek()] <= price[i]){
                    pop();
                }

                if(empty()){
                    span[i] = i+1;
                }else{
                    span[i] = i-peek();
                }

                push(i);
            }

            return span;
        }

        public int[] nextGreater(int[] arr){
            int n = arr.length;

            int num[] = new int[n];
            
            num[n-1] = -1;
            push(arr[n-1]);

            for(int i = n-2; i>=0; i--){
                while(!empty() && peek()<=arr[i]){
                    pop();
                }

                if(empty()){
                    num[i] = -1;
                }else{
                    num[i] = peek();
                }

                push(arr[i]);
            }

            return num;
        }
    }

    public static void main(String[] args) {
        Stack st = new Stack();

        int[] arr = {6, 8, 0, 1, 3};

        int res[] = st.nextGreater(arr);

        for(int i : res){
            System.out.print(i + " ");
        }

        return;
    }
}
