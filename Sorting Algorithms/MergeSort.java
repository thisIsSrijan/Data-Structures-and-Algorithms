public class MergeSort{
    public static void merge(int a[], int start, int mid, int end){
        //merge 2 subarrays a[start, mid] and a[mid+1, end] in sorted order
        int l = 0, r = 0;
        int k = start;
        int l_size = mid - start + 1;
        int r_size = end - mid;
        int left[] = new int[l_size];
        int right[] = new int[r_size];

        for(int i = 0; i < left.length ; i++){
            left[i] = a[start + i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = a[mid + 1 + i];
        }

        while(l<l_size && r<r_size){
            if(left[l] <= right[r])
                a[k++] = left[l++];
            else
                a[k++] = right[r++];
        }

        while(l<l_size){
            a[k++] = left[l++];
        }

        while(r<r_size){
            a[k++] = right[r++];
        }

    }

    public static void merge_sort(int a[], int start, int end){
        if(start < end){
            int mid = start + (end - start)/2;
            merge_sort(a, start, mid);
            merge_sort(a, mid+1, end);
            merge(a, start, mid, end);
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
        int a[] = {2};
        merge_sort(a, 0, a.length-1);
        print(a);
    }
}