import java.util.*;

public class PairSum{
    public static void addElements(ArrayList<Integer> list){
        boolean enter = true;
        Scanner sc = new Scanner(System.in);
        while(enter){
            System.out.println("Enter element:(-1 to end) ");
            int n = sc.nextInt();
            if(n == -1){
                enter = false;
                continue;
            }
            list.add(n);
        }
    }

    //2 pointers approach
    public static boolean findPairSum(ArrayList<Integer> list, int target){
        int lp = 0;
        int rp = list.size() - 1;
        //this approach works on sorted list
        Collections.sort(list);
        while(lp < rp){
            int x = list.get(lp) + list.get(rp);
            if(x == target){
                return true;
            }
            else if(x < target){
                lp++;
            }
            else if(x > target){
                rp--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList <Integer> list = new ArrayList<>();
        addElements(list);
        System.out.println("Enter target: ");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        System.out.println(findPairSum(list, target));

    }
}