public class FenwickTree {
    static class PrefixTree{
        int array[];

        public PrefixTree(int n){
            this.array = new int[n+1];
        }

        public void update(int index, int delta){
            index++;
            while(index<this.array.length){
                this.array[index] += delta;
                index = index + (index & (-index));
            }
        }

        public int query(int start,int end){
            int sum = 0;
            int index = end;

            while(index>=start){
                sum+=this.array[index];
                index = index - (index & (-index));
            }

            return sum;
        }
    }

    public static void main(String[] args) {
        int array[] = {1,2,3,4,5,6};
        PrefixTree prefix = new PrefixTree(array.length);

        for(int i=0; i<array.length; i++){
            prefix.update(i, array[i]);
        }

        System.out.println(prefix.query(1,6));
    }
}
