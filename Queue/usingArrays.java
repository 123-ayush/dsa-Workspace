import java.util.Queue;

public class usingArrays {
    public static class Queue{
        int arr[];
        public Queue(int n){
            arr = new int[n];
        }

        int front = 0;
        int rear = -1;

        public void add(int val){
            rear++;
            if(rear == arr.length){
                System.out.println("Capacity is full...");
                return;
            }
            arr[rear] = val;
        }

        public int peek(){
            if(rear == -1){
                return -1;
            }

            return arr[front];
        }

        public int remove(){
            if(rear == -1){
                return -1;
            }

            int top = arr[front];
            for(int i = front; i<rear-1; i++){
                arr[i] = arr[i+1];
            }

            rear--;

            return top;
        }

        public void print(){
            for(int i = 0; i<rear; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Queue q = new Queue(3);

        q.add(0);
        q.add(1);
        q.add(2);
        q.add(3);
        q.print();

        q.remove();
        q.print();

        System.out.println(q.peek());
        return;
    }
}
