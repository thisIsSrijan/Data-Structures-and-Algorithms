import java.util.*;

public class LonelyNumber {
    public static ArrayList<Integer> findLoneNumb(ArrayList<Integer> list){
        Collections.sort(list);
        int i = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while(i < list.size()){
            int cur = list.get(i);

            if(list.size() == 1){
                res.add(0);
                return res;
            }

            if(i == 0){
                int next = list.get(i+1);
                if(cur != next && next != (cur + 1)){
                    res.add(cur);
                }
            }
            if(i == list.size() - 1){
                int prev = list.get(i - 1);
                if(cur != prev && prev != (cur - 1)){
                    res.add(cur);
                }
            }
            if(i!=0 && i!= (list.size()-1)){
                int next = list.get(i+1);
                int prev = list.get(i-1);
                if(cur != prev && cur != next && prev != (cur - 1) && next != (cur + 1)){
                    res.add(cur);
                }
            }
            i++;
        }

        return res;
    }

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
    public static void main(String[] args) {
        ArrayList <Integer> list = new ArrayList<>();
        addElements(list);
        ArrayList<Integer> arr = findLoneNumb(list);
        for(int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
        }
        // System.out.println();
    }
}
