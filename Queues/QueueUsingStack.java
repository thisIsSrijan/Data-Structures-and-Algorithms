import java.util.Stack;

public class QueueUsingStack{
    public static class Queue{
        public static Stack<Integer> s1 = new Stack<>();
        public static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty(){
            if(s1.isEmpty())
                return true;
            return false;
        }

        //O(n)
        public static void add(int x){
            //empty s1 contents into s2
            //push new element in s1
            //empty s2 contents into s1
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(x);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        //O(1)
        public static int remove(){
            return s1.pop();
        }

        //O(1)
        public static int peek(){
            return s1.peek();
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(0);
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}