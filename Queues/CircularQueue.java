public class CircularQueue {
    static class Queue{
        static int a[];
        static int size;
        static int rear;
        static int front;

        public Queue(int size){
            Queue.size = size;
            rear = -1;
            front = -1;
            a = new int[size];
        }

        public static boolean isEmpty(){
            return rear == -1 && front == -1;
        }

        public static boolean isFull(){
            return (rear+1)%size == front;
        }

        public static void add(int data){
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            //if adding the first element
            if(front == -1)
                front = 0;
            
            rear = (rear+1)%size;
            a[rear] = data;
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int val = a[front];

            //if removing last element reset both front and rear
            if(rear == front){
                rear = front = -1;
            }else{
                front = (front+1)%size;
            }

            return val;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            return a[front];
        }
        
    }
    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.add(0);
        q.add(1);
        q.add(2);
        System.out.println(q.remove());
        q.add(3);
        System.out.println(q.remove());
        q.add(4);

        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
