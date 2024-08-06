
public class InsertionSort {
    public static void insertionSort(int a[]){
        for(int i = 1; i < a.length; i++){
            int key = a[i];
            int j = i-1;

            while(j>=0 && key < a[j]){
                a[j+1] = a[j]; //shift a[j] to rightside and make space for key to insert (here a[j+1] is a[i] which is the position for key)
                j--;
            }
            a[j+1] = key; //dont forget to again increment j
        }
    }

    public static void print(int a[]){
        int i = 0;
        while(i<a.length){
            System.out.print(a[i]+" ");
            i++;
        }
    }
    public static void main(String[] args) {
        int a[] = { 0 ,3, 21, 5, 9, 3, 30, 14};
        insertionSort(a);
        print(a);
    }
}
