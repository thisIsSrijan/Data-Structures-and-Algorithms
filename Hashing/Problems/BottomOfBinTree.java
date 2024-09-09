import java.util.*;

public class BottomOfBinTree {
    static class Node {
        int key;
        int height;
        Node left, right;
        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }
    public static void findBottomView(Node root,int ht,int idx, LinkedHashMap<Integer, Node> hm){
        if(root == null)
            return;
        root.height = ht;
        if(hm.containsKey(idx)){
            if(hm.get(idx).height <= root.height)
                hm.put(idx, root);
        }else{
            hm.put(idx, root);
        }
        findBottomView(root.left,ht+1, idx-1, hm);
        findBottomView(root.right,ht+1, idx+1, hm);
    }
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        LinkedHashMap<Integer, Node> hm = new LinkedHashMap<>();
        findBottomView(root,0, 0, hm);
        for(Integer key: hm.keySet()){
            System.out.println(hm.get(key).key);
        }

    }
}
