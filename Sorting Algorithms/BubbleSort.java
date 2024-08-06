
public class BubbleSort {
    public static void bubbleSort(int a[]){
        for(int i=0; i<a.length; i++){
            boolean swapped = false;
            for(int j=i; j<a.length; j++){
                if(a[i]>a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    swapped=true;
                }
            }
            if(swapped==false) //check if already sorted
                return;
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
        int a[] = { 7, 6, 5, 8, 9, 23, 0};
        bubbleSort(a);
        print(a);
    }
}
