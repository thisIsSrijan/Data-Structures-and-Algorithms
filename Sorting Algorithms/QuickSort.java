public class QuickSort {

    public static void quick_sort(int a[], int start, int end){
        if(start < end){
            int pivot = a[end];
            int i = start - 1;
            for(int j=start; j<end; j++){
                if(a[j] < pivot){
                    i++;
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
            i++;
            a[end] = a[i];
            a[i] = pivot;

            quick_sort(a, start, i-1);
            quick_sort(a, i+1, end);
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
        int a[] = {6, 3, 9, 8, 2, 5};
        quick_sort(a, 0, a.length-1);
        print(a);
    }
}
