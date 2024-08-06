import java.util.*;

public class NextGreaterElement {
    public static void findNG(int a[], int ng[]){
        Stack<Integer> s = new Stack<>();
        
        for(int i = a.length - 1; i >= 0; i--){
            while(!s.isEmpty() && a[s.peek()] <= a[i]){
                s.pop();
            }
            if(s.isEmpty()){
                ng[i] = -1;
            }else{
                ng[i] = a[s.peek()];
            }
            s.push(i);
        }
    }
    public static void main(String[] args) {
        int a[] = {6, 8, 0, 1, 3};
        int b[] = new int[a.length];

        findNG(a, b);

        for (int i : b) {
            System.out.print(i+" ");
        }
    }
}
