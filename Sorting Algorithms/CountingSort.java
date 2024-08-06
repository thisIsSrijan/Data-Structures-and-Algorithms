
public class CountingSort {
    //refer gfg's counting sort explanation if not understood
    public static int[] countingSort(int input[]){
        //finding max element of input
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < input.length; i++){
            if(input[i]>max)
                max = input[i];
        }

        int count[] = new int[max+1];
        int output[] = new int[input.length];
        //initializing all values of count to zero
        for(int i = 0; i <= max; i++ ){
            count[i] = 0;
        }
        //finding frequencies of each occuring element of input
        for (int i = 0; i < input.length; i++) {
            count[input[i]] += 1;
        }
        //calculating the cumulative sum at each index of count
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i-1] + count[i];
        }
        //iterating from last element (Preserves order of same valued elements)
        for (int i = input.length - 1; i >= 0; i--) {
            count[input[i]] -= 1;
            output[count[input[i]]] = input[i];
        }

        return output;
    }

    public static void print(int a[]){
        int i = 0;
        while(i<a.length){
            System.out.print(a[i]+" ");
            i++;
        }
    }
    public static void main(String[] args) {
        int a[] = {2, 4, 0, 4, 2, 7, 9, 6, 11, 7, 8};
        a = countingSort(a);
        print(a);
    }
}
