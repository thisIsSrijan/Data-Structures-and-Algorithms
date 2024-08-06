public class QueueFromLL {
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class Queue{
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty(){
            return head == null && tail == null;
        }

        public static void add(int data){
            if(isEmpty()){
                Node newNode = new Node(data);
                head = tail = newNode;
                return;
            }
            Node newNode = new Node(data);
            tail.next = newNode;
            tail = tail.next;
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int val = head.data;
            if(head == tail){
                head = tail = null;
            }else{
                head = head.next;
            }

            return val;
        }

        public static int peek(){
            return head.data;
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(0);
        q.add(1);
        q.add(2);

        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
