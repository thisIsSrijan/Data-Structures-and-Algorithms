//check if array is sorted or not using recursion

public class ArraySorting {
    public static boolean sorting_check(int a[], int i){
        if(i == 0){
            return true;
        }
        if(a[i-1]>a[i]){
            return false;
        }
        return sorting_check(a, i-1);
    }
    public static void main(String[] args) {
        int a[] = {1,2,6,4,5};
        System.out.println(sorting_check(a, a.length-1));
    }
}
