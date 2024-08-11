
public class AVL {
    static class Node{
        int val, height;
        Node left, right;

        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }

    public static Node root;

    public static int getHeight(Node root){
        if(root == null)
            return 0;
        return root.height;
    }

    public static int getBalance(Node root){
        if(root == null)
            return 0;
        return (getHeight(root.left) - getHeight(root.right));
    }

    public static Node leftRotate(Node x){
        Node y = x.right;
        Node yL = y.left;

        y.left = x;
        x.right = yL;
        //note: first calculate height of x and then y as x is child of y
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    public static Node rightRotate(Node x){
        Node y = x.left;
        Node yR = y.right;

        y.right = x;
        x.left = yR;
        //note: first calculate height of y and then x as x is child of y
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;  
    }

    public static Node insert(Node root, int key){
        if(root == null){
            return new Node(key);
        }
        if(key > root.val)
            root.right = insert(root.right, key);
        else if(key < root.val)
            root.left = insert(root.left, key);
        else
            return root; //duplicate key case
        
        //height update
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;

        //balance factor
        int bf = getBalance(root);

        //LL
        if(bf > 1 && key < root.left.val)
            return rightRotate(root);
        //RR
        if(bf < -1 && key > root.right.val)
            return leftRotate(root);
        //LR
        if(bf > 1 && key > root.left.val){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        //RL
        if(bf < -1 && key < root.right.val){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public static void preOrderTrav(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        preOrderTrav(root.left);
        preOrderTrav(root.right);
    }
    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        preOrderTrav(root);
    }
}
