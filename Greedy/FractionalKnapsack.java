
import java.util.Arrays;
import java.util.Comparator;


public class FractionalKnapsack {
    public static void main(String[] args) {
        //knapsack size = 50
        int knapsack = 50;
        int items[][] = {{60,10},
                         {100,20},
                         {120,30}};
        Arrays.sort(items, Comparator.comparingDouble(o -> o[0]/o[1]));


        for(int i = 0; i < items.length; i++)
            System.out.println(items[i][0]+" "+items[i][1]);
        int profit = 0;
        for(int i = items.length - 1; i >= 0; i--){
            if(knapsack == 0)
                break;
            if(items[i][1] <= knapsack){
                knapsack -= items[i][1];
                profit += items[i][0];
            }else{
                profit += knapsack*items[i][0]/items[i][1];
                knapsack = 0;
            }
            System.out.println(profit+" "+knapsack);
        }

        System.out.println(profit);
        
    }
}
