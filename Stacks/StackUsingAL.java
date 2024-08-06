import java.util.ArrayList;

public class StackUsingAL{
    static class Stack{
        //stack implemented using ArrayList 
        //last indexed element is the top of stack
        static ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty(){
            if(list.size() == 0)
                return true;
            
            return false;
        }

        public void push(int data){
            list.add(data);
        }

        public int pop(){
            if(list.size() == 0)
                return -1;
            
            int val = list.get(list.size() - 1);
            list.removeLast();

            return val;
        }

        public int peek(){
            if(isEmpty())
                return -1;
            
            return list.get(list.size() - 1);
        }

    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.pop();
        // while(!s.isEmpty())
            // System.out.println(s.peek());
        System.out.println(s.peek());
    }
}