import java.util.*;

public class StockSpan {
    public static void calculateSpan(int prices[], int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        int i = 1;
        while(i < prices.length){
            if(s.isEmpty()){
                span[i] = i+1;
                i++;
                continue;
            }
            if(prices[s.peek()] < prices[i]){
                s.pop();
            }else{
                span[i] = i - s.peek();
                s.push(i++);
            }
        }
    }
    public static void main(String[] args) {
        int prices[] = {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int[prices.length];
        calculateSpan(prices, span);
        for(int i = 0; i < span.length; i++){
            System.out.print(span[i]+" ");
        }
    }
}
