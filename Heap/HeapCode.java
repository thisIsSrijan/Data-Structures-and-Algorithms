
import java.util.ArrayList;


public class HeapCode {
    static class MinHeap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            arr.add(data);
            int x = arr.size()-1;
            int parent = (arr.size() - 2)/2;

            while(arr.get(x) < arr.get(parent) && x > 0 && parent >= 0){
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);
                x = parent;
                parent = (x-1)/2;
            }
        }

        public int getMin(){
            return arr.get(0);
        }

        //remove the min element from the min heap
        public void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;

            if(left < arr.size() && arr.get(minIdx) > arr.get(left))
                minIdx = left;
            if(right < arr.size() && arr.get(minIdx) > arr.get(right))
                minIdx = right;
            
            if(minIdx != i){
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }
        
        public int remove(){
            //swap first and last element and remove the last element
            int temp = arr.remove(arr.size()-1);
            int removeVal = arr.remove(0);
            arr.set(0,temp);
            heapify(0);

            return removeVal;
        }

        //heapsort 
        //using maxHeap
        //here we are using size in heapify function because everytime we ignore the last element
        public void heapify(ArrayList<Integer> arr,int i, int size){
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;
            //note that we are creating maxHeap
            if(left < size && arr.get(minIdx) < arr.get(left))
                minIdx = left;
            if(right < size && arr.get(minIdx) < arr.get(right))
                minIdx = right;
            
            if(minIdx != i){
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(arr,minIdx, size);
            }
        }

        public ArrayList<Integer> heapSort(ArrayList<Integer> list){
            int n = list.size();
            for(int i = n/2; i >= 0; i--){
                heapify(list, i, n);
            }

            for(int i = n-1; i >= 0; i--){
                int temp = list.get(0);
                list.set(0, list.get(i));
                list.set(i, temp);

                heapify(list, 0, i);
            }

            return list;
        }
    }
    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        heap.add(10);
        heap.add(7);
        heap.add(15);
        heap.add(11);
        heap.add(4);
        heap.add(9);
        heap.add(5);
        for(int i = 0; i < heap.arr.size(); i++){
            System.out.print(heap.arr.get(i) + " ");
        }
        System.out.println();
        System.out.println(heap.remove());
        for(int i = 0; i < heap.arr.size(); i++){
            System.out.print(heap.arr.get(i) + " ");
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(7);
        list.add(15);
        list.add(11);
        list.add(4);
       list =  heap.heapSort(list);
        System.out.println();
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }

    }
}
