import java.util.*;

public class BuildTreePreOrder {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        public static int idx = -1; //number of nodes
        //O(n)
        public static Node buildTreePreOrder(int nodes[]){
            idx++;
            if(nodes[idx] == -1)
                return null;
            Node newRoot = new Node(nodes[idx]);
            newRoot.left = buildTreePreOrder(nodes);
            newRoot.right = buildTreePreOrder(nodes);
            return newRoot;
        }
        public static void preOrderTrav(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            preOrderTrav(root.left);
            preOrderTrav(root.right);
        }

        public static void inOrderTrav(Node root){
            if(root == null)
                return;
            
            inOrderTrav(root.left);
            System.out.print(root.data+" ");
            inOrderTrav(root.right);
        }

        public static void postOrderTrav(Node root){
            if(root == null)
                return;
            postOrderTrav(root.left);
            postOrderTrav(root.right);
            System.out.print(root.data+" ");
        }

        public static void levelOrderTrav(Node root){
            if(root == null)
                return;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node newNode = q.remove();
                
                if(newNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(newNode.data+" ");
                    if(newNode.left!=null)
                        q.add(newNode.left);
                    if(newNode.right!=null)
                        q.add(newNode.right);
                }
            }
        }

        public static int getHeight(Node root){
            if(root == null)
                return 0;
            int lh = getHeight(root.left);
            int rh = getHeight(root.right);

            return Math.max(lh,rh) + 1;
        }

        public static int getNodeCount(Node root){
            if(root == null)
                return 0;
            int lcount = getNodeCount(root.left);
            int rcount = getNodeCount(root.right);

            return lcount+rcount+1;
        }

        public static int findSum(Node root){
            if(root == null)
                return 0;
            int lsum = findSum(root.left);
            int rsum = findSum(root.right);

            return lsum + rsum + root.data;
        }

        //Inefficient way to calculate diameter
        // public static int getDiameter(Node root){
        //     if(root == null)
        //         return 0;
        //     int lDia = getDiameter(root.left);
        //     int rDia = getDiameter(root.right);
        //     int lHeight = getHeight(root.left);
        //     int rHeight = getHeight(root.right);

        //     return Math.max(Math.max(rDia, lDia), rHeight+lHeight+1);
        // }

        static class TreeInfo{
            int dia;
            int ht;

            public TreeInfo(int d, int h){
                this.dia = d;
                this.ht = h;
            }
        }

        public static TreeInfo getDiameter(Node root){
            if(root == null)
                return new TreeInfo(0,0);
            TreeInfo left = getDiameter(root.left);
            TreeInfo right = getDiameter(root.right);
            int selfHt = Math.max(left.ht, right.ht) + 1;

            return new TreeInfo(Math.max(left.dia, right.dia), selfHt);
        }

        //check if given tree is a subtree of another tree
        public static boolean isIdentical(Node root, Node subRoot){
            if(root == null && subRoot == null)
                return true;
            else if(root == null || subRoot == null || root.data != subRoot.data)
                return false;
            if(!isIdentical(root.left, subRoot.left))
                return false;
            if(!isIdentical(root.right, subRoot.right))
                return false;
            
            return true;
        }

        public static boolean isSubTree(Node root, Node subRoot){
            if(root.data == subRoot.data){
                if(isIdentical(root, subRoot))
                    return true;
            }

            boolean left = isIdentical(root.left, subRoot);
            boolean right = isIdentical(root.right, subRoot);
            return left || right;
        }

        //Top view of a tree
        static class TopViewInfo{
            Node node;
            int hd;

            public TopViewInfo(Node n, int h){
                this.node = n;
                this.hd = h;
            }
        }
        public static void getTopView(Node root){
            Queue<TopViewInfo> q = new LinkedList<>();
            HashMap<Integer, Node> map = new HashMap<>();
            q.add(new TopViewInfo(root, 0));
            q.add(null);
            int min = 0; 
            int max = 0;

            while(!q.isEmpty()){
                TopViewInfo curr = q.remove();

                if(curr == null){
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    if(!map.containsKey(curr.hd)){
                        map.put(curr.hd, curr.node);
                    }
                    if(curr.node.left != null){
                        q.add(new TopViewInfo(curr.node.left, curr.hd - 1));
                        min = Math.min(min, curr.hd - 1);
                    }
                    if(curr.node.right != null){
                        q.add(new TopViewInfo(curr.node.right, curr.hd + 1));
                        max = Math.max(max, curr.hd + 1);
                    }
                }
            }

            for(int i = min; i <= max; i++){
                if(map.containsKey(i))
                    System.out.print(map.get(i).data+" ");
            }
        }

        //kth ancestor of a node
        public static boolean getAncestors(Node root, Node n, ArrayList<Node> list){
            if(root == null)
                return false;
            list.add(root);
            if(root.data == n.data)
                return true;
            boolean left = getAncestors(root.left, n, list);
            boolean right = getAncestors(root.right, n, list);
            if(left || right)
                return true;
            list.remove(list.size()-1);
            return false;
        }
        public static Node kthAncestor(Node root, Node n, int k){
            ArrayList<Node> list = new ArrayList<>();
            getAncestors(root, n, list);

            return list.get(list.size()-k-1);
        }
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        // BinaryTree t1 =new BinaryTree();
        Node root = BinaryTree.buildTreePreOrder(nodes);
        BinaryTree.preOrderTrav(root);
        System.out.println();
        BinaryTree.inOrderTrav(root);
        System.out.println();
        BinaryTree.postOrderTrav(root);
        System.out.println();
        BinaryTree.levelOrderTrav(root);
        System.out.println();
        System.out.println("height: "+BinaryTree.getHeight(root));
        System.out.println("Number of nodes: "+BinaryTree.getNodeCount(root));
        System.out.println("Sum of all node values: "+BinaryTree.findSum(root));
        System.out.println("Diameter of binary tree: "+ BinaryTree.getDiameter(root).dia);

        //Tree 1
        Node rootNode = new Node(1);
        rootNode.left = new Node(2);
        rootNode.right = new Node(3);
        rootNode.left.left = new Node(4);
        rootNode.left.right = new Node(5);
        rootNode.right.right = new Node(6);

        //Tree 2
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println("Tree 2 is subtree of Tree 1: "+ BinaryTree.isSubTree(rootNode, subRoot));
        System.out.println();
        System.out.println("Top view of the root node: ");
        BinaryTree.getTopView(root);
        System.out.println();
        System.out.println("2nd ancestor of node 5: "+ BinaryTree.kthAncestor(rootNode, rootNode.left.right, 1).data);
    }
}
