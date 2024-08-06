import java.util.*;

public class Deques {

    //Stack using Deque
    public static class Stack{
        public static Deque<Integer> s = new LinkedList<>();

        public static boolean isEmpty(){
            return s.isEmpty();
        }

        public static void push(int x){
            s.addLast(x);
        }
        public static int pop(){
            if(s.isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }

            return s.removeLast();
        }
        public static int peek(){
            if(s.isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }

            return s.getLast();
        }
    }

    //Queue using Deque
    public static class Queue{
        public static Deque<Integer> q = new LinkedList<>();

        public static boolean isEmpty(){
            return q.isEmpty();
        }

        public static void add(int x){
            q.addLast(x);
        }

        public static int remove(){
            if(q.isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return q.removeFirst();
        }

        public static int peek(){
            if(q.isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            return q.getFirst();
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        Queue q = new Queue();

        System.out.println("Stack operations:");
        s.push(0);
        s.push(1);
        s.push(2);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }

        System.out.println("Queue operations: ");
        q.add(0);
        q.add(1);
        q.add(2);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
