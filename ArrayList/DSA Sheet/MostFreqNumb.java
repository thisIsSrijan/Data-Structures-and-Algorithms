import java.util.*;

public class MostFreqNumb {
    public static void findTargetOccurence(ArrayList<Integer> nums, int key){
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 1;
        while(i < nums.size() - 1){
            if(key == nums.get(i))
                list.add(nums.get(i+1));
            i++;
        }
        Collections.sort(list);
        int aux[] = new int[list.get(list.size() - 1) + 1];
        for(int k = 0 ; k < aux.length; k++){
            aux[k] = 0;
        }
        while(j < list.size()){
            aux[list.get(j++)] += 1;
        }
        int max = -1;
        for(int k = 0; k < aux.length; k++){
            if(aux[k] > max)
                max = k;
        }

        System.out.println(max);
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
        ArrayList<Integer> nums = new ArrayList<>();
        addElements(nums);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter key: ");
        int key = sc.nextInt();
        findTargetOccurence(nums, key);
    }
}
