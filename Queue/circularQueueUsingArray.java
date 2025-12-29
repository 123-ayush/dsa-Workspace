public class circularQueueUsingArray {
    public static class circularQueue{
        int arr[];
        int size;
        public circularQueue(int n){
            arr = new int[n];
            size = n;
        }

        int front = -1;
        int rear = -1;

        public void add(int val){
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            if(isEmpty()){
                front = 0;
                rear = 0;
                arr[rear] = val;
                return;
            }
            rear = (rear+1)%size;
            arr[rear] = val;
        }

        public boolean isEmpty(){
            return (front == -1 && rear == -1);
        }

        public boolean isFull(){
            return ((rear+1)%size == front);
        }

        public int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int val = arr[front];
            if(front == rear){
                front = -1;
                rear = -1;
            } else {
                front = (front+1)%size;
            }
            return val;
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }

        public void print(){
            if(isEmpty()){
                System.out.println();
                return;
            }
            int i = front;
            while(true){
                System.out.print(arr[i] + " ");
                if(i == rear) break;
                i = (i+1)%size;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        circularQueue cq = new circularQueue(4);

        cq.add(0);
        cq.add(1);
        cq.add(2);
        cq.add(3);

        cq.print();

        return;
    }
}
