
public class SelectionSort {
    public static void selectionSort(int a[]){
        for(int i = 0; i < a.length; i++){
            int minVal = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int j = i; j < a.length; j++){
                if(a[j]<minVal){
                    minIndex = j;
                    minVal = a[j];
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
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
        int a[] = { 1, 3, 90, 45, 0, 11, 2, 67};
        selectionSort(a);
        print(a);
    }
}
