import java.util.*;

public class Hash{
    //<K,V> as we do not know what datatypes the user might enter
    static class HashMap<K,V>{
        private class Node{
            K key; //key has type K
            V value;

            public Node(K key, V val){
                this.key = key;
                this.value = val;
            }
        }
        
        private int size; //counts the CURRENT number of nodes
        private int N; //size of bucket
        private LinkedList<Node>[] bucket; //N size

        //constructor for HashMap to intialize bucket and for each index of bucket intialize an empty
        //linked list
        //supressing unchecked type warnings because for initializing each index of bucket with new LL
        //we are not providing the type of LinkedList
        @SuppressWarnings("unchecked")
        public HashMap(){
            this.size = 0; //initially no node present
            this.bucket = new LinkedList[4]; //initial size of bucket N = 4
            this.N = bucket.length;
            for (int i = 0; i < 4; i++) {
                bucket[i] = new LinkedList<>(); //initialize empty ll for each index
            }
        }

        //put
        private int hashFunction(K key){
            int bi = key.hashCode();
            bi = bi % N; //to keep bi in range of 0 to N - 1
            return bi;
        }

        private int searchLL(K key, int bi){
            int di = 0;
            LinkedList<Node> list = bucket[bi];
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).key == key)
                    return di;
                di++;
            }

            return -1;
        }

        @SuppressWarnings("unchecked")
        private void reHash(){
            LinkedList<Node> oldBucket[] = bucket;
            bucket = new LinkedList[N*2]; //expand the array size
            N = N*2; //also expand N
            //Empty the original bucket content
            for(int i = 0; i < N; i++){
                bucket[i] = new LinkedList<Node>();
            }
            //add all older values to the new bucket
            for(int i = 0; i < oldBucket.length; i++){
                LinkedList<Node> ll = oldBucket[i];
                for(int j = 0; j < ll.size(); j++){
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V val){
            int bi = hashFunction(key); //bucket index
            int di = searchLL(key, bi); //data index of the particular liked list

            if(di != -1){ //key already exits,just update the value
                Node node = bucket[bi].get(di);
                node.value = val;
            }else{
                bucket[bi].add(new Node(key, val));
                size++;
            }

            //rehashing
            double lambda = (double) size/N;
            if(lambda > 2.0){ //Threshold value is 2
                reHash();
            }
        }

        //contains key
        public boolean containsKey(K key){
            int bi = hashFunction(key); //bucket index
            int di = searchLL(key, bi); //data index of the particular liked list
        
            if(di !=- 1)
                return true;
            else
                return false;
        }

        public V get(K key){
            if(!containsKey(key))
                return null;
            int bi = hashFunction(key);
            int di = searchLL(key, bi);

            Node node = bucket[bi].get(di);
            return node.value;
        }

        public V remove(K key){
            int bi = hashFunction(key);
            int di = searchLL(key, bi);
            
            if(di != -1){
                Node node = bucket[bi].remove(di);
                size--;
                return node.value;
            }else
                return null;
        }
        
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i = 0; i < bucket.length; i++){
                for(int j = 0; j < bucket[i].size(); j++)
                    keys.add(bucket[i].get(j).key);
            }

            return keys;
        }
    }
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 150);
        hm.put("Brazil", 234);
        hm.put("Italy", 50);
        hm.put("USA", 4);
        hm.put("India", 100);
        System.out.println(hm.get("USA"));
        System.out.println(hm.remove("USA"));
        System.out.println(hm.get("USA"));
        System.out.println(hm.containsKey("Italy"));
        ArrayList<String> keys = hm.keySet();
        for(int i = 0; i < keys.size(); i++){
            System.out.println(hm.get(keys.get(i)));
        }
    }
}