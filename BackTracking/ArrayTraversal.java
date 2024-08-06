
public class ArrayTraversal {
    public static void changeArray(int a[], int i, int val){
        if(i == a.length){ //notice that a.length and not a.length - 1
            print(a);
            return;
        }

        a[i] = val;
        changeArray(a, i+1, val+1); //function call
        a[i] = a[i] - 2; //backtracking step
    }

    public static void print(int a[]){
        int i = 0;
        while(i<a.length){
            System.out.print(a[i]+" ");
            i++;
        }
    }
    public static void main(String[] args) {
        int a[] = new int[5];
        changeArray(a, 0, 0);
        System.out.println();
        print(a);
    }
}
