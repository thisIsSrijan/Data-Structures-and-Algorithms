
public class QueueFromArray{
    public static class Queue{
        static int queue[];
        static int size;
        static int rear;

        public Queue(int size){
            Queue.size = size;
            queue = new int[size];
            rear = -1;
        }

        public static boolean isEmpty(){
            return rear == -1;
        }

        public static void add(int data){
            if(rear == size - 1){
                System.out.println("queue is full");
                return;
            }
            rear++;
            queue[rear] = data;
        }

        public static int remove(){
            if(isEmpty())
                return -1;
            
            int front = queue[0];

            for(int i = 0; i < rear; i++){
                queue[i] = queue[i+1];
            }
            rear--;
            return front;
        }

        public static int peek(){
            return queue[0];
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(0);
        q.add(1);
        q.add(2);
        q.add(3);
        //jis order mei daale the ussi order mei wapas niklega as FIFO
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}