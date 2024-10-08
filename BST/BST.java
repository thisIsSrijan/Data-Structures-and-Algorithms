import java.util.ArrayList;

public class BST {
    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }

    static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.val > val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }

        return root;
    }

    static void inOrder(Node root){
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    static boolean searchKey(Node root, int key){
        if(root == null)
            return false;
        if(key == root.val)
            return true;
        if(key > root.val)
            return searchKey(root.right, key);
        else
            return searchKey(root.left, key);
    }

    static Node findInOrderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }

        return root;
    }

    static Node delete(Node root, int val){
        if(val > root.val){
            root.right = delete(root.right, val);
        }else if(val < root.val){
            root.left = delete(root.left, val);
        }else{
            //case 1: leaf node
            if(root.left == null && root.right == null)
                return null; //the node becomes null and it is returned to its parent thus it is deleted
            
            //case 2: one child
            if(root.left == null){
                    return root.right;
            }else if(root.right == null){
                return root.left;
            }

            //case 3: find inOrderSuccessor
            Node temp = findInOrderSuccessor(root.right);
            root.val = temp.val;
            root.right = delete(root.right, temp.val);
        }

        return root;
    }

    static void printInRange(Node root, int k1, int k2){
        if(root == null)
            return;
        if(root.val >= k1 && root.val <= k2){
            printInRange(root.left, k1, k2);
            System.out.println(root.val);
            printInRange(root.right, k1, k2);
        }else if(root.val < k1){
            printInRange(root.right, k1, k2);
        }else if(root.val > k2){
            printInRange(root.left, k1, k2);
        }
    }

    //print all paths from root to leaf nodes

    static void printPath(ArrayList<Node> list){
        for(int i =0; i < list.size(); i++){
            System.out.print(list.get(i).val+" ");
        }
        System.out.println();
    }
    static void printRootToLeaf(Node root, ArrayList<Node> list){
        if(root == null)
            return;

        list.add(root);

        if(root.left == null && root.right == null){
            printPath(list);
        }
        printRootToLeaf(root.left, list);
        printRootToLeaf(root.right, list);
        list.remove(list.size()-1);
    }

    //validate BST
    static boolean isBST(Node root, Node min, Node max){
        //null is a valid BST
        if(root == null)
            return true; 
        
        if(min != null && root.val <= min.val)
            return false;
        if(max!= null && root.val >= max.val)
            return false;

        return isBST(root.left, min, root) && isBST(root.right, root, max);
    }

    //balanced BST from a sorted array
    static Node createBalBST(int arr[], int start, int end){
        if(start > end)
            return null;

        int mid = start + (end - start)/2;
        Node root = new Node(arr[mid]);
        root.left = createBalBST(arr, start, mid-1);
        root.right = createBalBST(arr, mid+1, end);

        return root;
    }

    //largest BST in Binary Tree
    static int MAX_SIZE = Integer.MIN_VALUE;
    static class NodeInfo{
        boolean isBST;
        int size;
        int max;
        int min;

        public NodeInfo(boolean b, int s, int max, int min){
            this.isBST = b;
            this.size = s;
            this.max = max;
            this.min = min;
        }
    }

    public static NodeInfo findLargest(Node root){
        if(root == null)
            return new NodeInfo(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        NodeInfo left = findLargest(root.left);
        NodeInfo right = findLargest(root.right);
        int size = left.size + right.size + 1;
        int min = Math.min(Math.min(left.min, right.min), root.val);
        int max = Math.max(Math.max(left.max, right.max), root.val);

        if(root.val <= left.max|| root.val >= right.min){
            return new NodeInfo(false, size, max, min);
        }
        if(left.isBST && right.isBST){
            MAX_SIZE = Math.max(MAX_SIZE, size);
            return new NodeInfo(true, size, max, min);
        }
        return new NodeInfo(false, size, max, min);
    }

    //merging 2 BSTs
    public static void inorderList(Node root, ArrayList<Integer> list){
        if(root == null)
            return;
        inorderList(root.left, list);
        list.add(root.val);
        inorderList(root.right, list);
    }
    public static ArrayList<Integer> mergeList(ArrayList<Integer> l1, ArrayList<Integer> l2){
        ArrayList<Integer> l = new ArrayList<>();
        int i = 0;
        int j = 0;
        while( i < l1.size() && j < l2.size()){
            if(l1.get(i) < l2.get(j)){
                l.add(l1.get(i++));
            }else if(l1.get(i) > l2.get(j)){
                l.add(l2.get(j++));
            }else{
                l.add(l1.get(i));
                i++;
                j++;
            }
        }
        while(i < l1.size()){
            l.add(l1.get(i++));
        }
        while(j < l2.size()){
            l.add(l2.get(j++));
        }

        return l;
    }

    //overloading
    static Node createBalBST(ArrayList<Integer> list, int start, int end){
        if(start > end)
            return null;

        int mid = start + (end - start)/2;
        Node root = new Node(list.get(mid));
        root.left = createBalBST(list, start, mid-1);
        root.right = createBalBST(list, mid+1, end);

        return root;
    }

    public static Node mergeBSTs(Node root1, Node root2){
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        inorderList(root1, l1);
        inorderList(root2, l2);
        ArrayList<Integer> l = mergeList(l1, l2);
        Node root = createBalBST(l, 0, l.size()-1);
        return root;   
    }
    public static void main(String[] args) {
        //8,5,3,1,4,6,10,11,14
        int [] values = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for(int i = 0; i < values.length; i++){
            root = insert(root, values[i]);
        }
        inOrder(root);
        System.out.println();
        // System.out.println("Is 4 present in BST: "+searchKey(root, 4));
        // root = delete(root, 5);
        // inOrder(root);
        // printInRange(root, 4, 9);
        System.out.println();
        System.out.println("All paths from root to leaf: ");
        printRootToLeaf(root, new ArrayList<Node>());
        System.out.println("Given BST is valid: "+isBST(root, null, null));
        //creating a balanced BST
        int nodes[] = {3,5,6,8,10,11,12};
        Node balBSTRoot = createBalBST(nodes, 0, nodes.length-1);
        // inOrder(balBSTRoot);
        findLargest(balBSTRoot);
        System.out.println();
        System.out.println("Largest BST in the given BT size: "+ MAX_SIZE);
        System.out.println();
        inOrder(mergeBSTs(root, balBSTRoot));
    }
}
