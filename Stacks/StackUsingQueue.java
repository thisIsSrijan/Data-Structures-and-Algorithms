import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    public static class Stack{
        public static Queue<Integer> q1 = new LinkedList<>();
        public static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty(){
            if(q1.isEmpty() && q2.isEmpty())
                return true;
            return false;
        }

        public static void push(int x){
            if(q1.isEmpty() && q2.isEmpty()){
                q1.add(x);
                return;
            }

            if(!q1.isEmpty())
                q1.add(x);
            else
                q2.add(x);
        }

        public static int pop(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int top = -1;
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top = q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }
            }else{
                while(!q2.isEmpty()){
                    top = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }
            }

            return top;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int top = -1;
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top = q1.remove();
                    q2.add(top);
                }
            }else{
                while(!q2.isEmpty()){
                    top = q2.remove();
                    q1.add(top);
                }
            }

            return top;
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
