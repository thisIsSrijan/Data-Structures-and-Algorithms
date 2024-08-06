public class LinkedList {
    public static class Node {
        //data and next
        int data;
        Node next;
    
        //constructor
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    //head node and tail nodes
    public static Node head;
    public static Node tail;
    public static int size;

    //add nodes
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int data){
        size++;
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void addMiddle(int index, int data){
        if(index == 0){
            addFirst(data);
            return;
        }
        size++;
        Node newNode = new Node(data);
        Node tempNode = head;
        int i = 0;
        while(i < (index - 1)){
            if(tempNode == null){
                addLast(data);
                return;
            }
            tempNode = tempNode.next;
            i++;
        }
        newNode.next = tempNode.next;
        tempNode.next = newNode;
    }

    //removing nodes (returns the value that is removed)
    public int removeFirst(){
        if(size == 0){
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1){
            int val = head.data;
            head = head.next;
            tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        return val;
    }

    public int removeLast(){
        if(size == 0){
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1){
            int val = head.data;
            head = head.next;
            tail = null;
            size = 0;
            return val;
        }
        int val = tail.data;
        int i = 0;
        Node temp = head;
        while(i < (size - 2)){
            temp = temp.next;
            i++;
        }
        temp.next = null;
        tail = temp;
        size--;

        return val;
    }

    public int removeMiddle(int index){
        if(size == 0){
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1){
            int val = head.data;
            head = head.next;
            tail = null;
            size = 0;
            return val;
        }

        if(index == 0){
            return removeFirst();
        }
        if(index == size - 1){
            return removeLast();
        }

        Node temp = head;
        Node curr= head.next;
        int i = 0;
        while(i < (index - 1)){
            temp = temp.next;
            curr = curr.next;
            i++;
        }
        int val = curr.data;
        temp.next = curr.next;
        curr.next = null;
        size--;
        return val;
    }

    public void removeNthFromLast(int idx){
        int iFromStart = size - idx;
        this.removeMiddle(iFromStart);
    }

    //print nodes
    public void printList(){
        if(head == null){
            System.out.println("Linked list is empty");
            return;
        }
        Node tempHead = head;
        while(tempHead != null){
            System.out.print(tempHead.data + "->");
            tempHead = tempHead.next;
        }
        System.out.print("null");
        System.out.println();
    }

    //search in linked list
    //iterative search
    public int searchList(int val){
        Node temp = head;
        int i = 0;
        while(i < size){
            if(val == temp.data)
                return i;
            temp = temp.next;
            i++;
        }

        return -1;
    }

    //recursive search
    public int helper(int val, Node head){
        if(head == null)
            return -1;
        if(head.data == val)
            return 0; // for current level the index is 0 
        
        int indx = helper(val, head.next);

        if(indx == -1){
            return -1;
        }

        return indx + 1; //for lower levels , index of val is whatever index came from above (0) + 1 for current level
    }
    public int searchListRec(int val){
        return helper(val, head);
    }

    //reverse a linked list
    public void reverseLl(){
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    //finding middlemost node of linked list
    public Node findMiddle(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    //check if linked list is palindrome
    public boolean checkPalindrome(){
        if(head == null || head.next == null)
            return true;
        //find middle
        Node middle = findMiddle();
        //reverse 2nd half
        Node prev = null;
        Node curr = middle;
        Node next;
        while(curr!= null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //prev is the start node of the reversed part as curr is null now
        Node right = prev;
        Node left = head;
        while(right != null){
            if(left.data != right.data)
                return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }

    //detect cycles in linked list
    public static boolean detect_cycle(LinkedList ll){
        Node slow = ll.head;
        Node fast = ll.head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }

        return false;
    }
    
    //remove cycle in linked list
    //works only for cycles in middle and not at head
    public static void remove_cycle(LinkedList ll){
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isCycle = true;
                break;
            }
        }
        if(!isCycle)
            return;
        
        Node prev = null;
        slow = head;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = null;
    }

    //merge sort on Linked List
    public Node merge_sort(Node headNode){
        //base condition
        if((headNode == null) || (headNode.next == null)){
            return headNode;
        }
        //find middle
        Node mid = getMid(headNode);

        //perform sort on left and right
        Node right = mid.next;
        mid.next = null;
        Node leftHead = merge_sort(headNode);
        Node rightHead = merge_sort(right);

        //merge and return
        return merge(leftHead, rightHead);
    }
    //helper function to find last node of the left part
    private Node getMid(Node h){
        Node slow = h;
        Node fast = h.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    //helper function to merge 2 lls
    private Node merge(Node l, Node r){
        //either left ll will be equal to right ll size or left ll will have one extra node
        Node temp = new Node(-1);
        Node mergedListHead = temp;
        while(l!=null && r!= null){
            if(l.data <= r.data){
                temp.next = l;
                l = l.next;
            }
            else{
                temp.next = r;
                r = r.next;
            }
            temp = temp.next;
        }

        while(l!= null){
            temp.next = l;
            l = l.next;
            temp = temp.next;
        }

        while(r!= null){
            temp.next = r;
            r = r.next;
            temp = temp.next;
        }

        return mergedListHead.next;
    }

    //DSA sheet questions

    //Q2) DELETE N NODES AFTER EVERY M NODES
    public void solution2(int n, int m){
        if(head == null || size <= m)
            return;
        
        Node temp = head;
        Node prev = null;

        while(temp != null){
            int i = 0;
            int j = 0;
            while(i != m){
                if(temp == null || temp.next == null)
                    return;
                prev = temp;
                temp = temp.next;
                i++;
            }
            temp = prev;
            while(j != n){
                if(temp == null || temp.next == null)
                    return;
                temp.next = temp.next.next;
                j++;
            }
            if(temp != null && temp.next != null)
                temp = temp.next;
        }
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addFirst(0);
        // ll.addLast(-1);
        // ll.addMiddle(0, 10);
        // ll.printList();
        // ll.removeNthFromLast(2);
        // ll.printList();
        // System.out.println(LinkedList.size);
        // System.out.println(LinkedList.size);
        // System.out.println(ll.searchListRec(2));
        // System.out.println(LinkedList.head.data);
        // ll.reverseLl();
        ll.addFirst(10);
        ll.addFirst(9);
        ll.addFirst(8);
        ll.addFirst(7);
        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        
        // tail.next = head.next.next;
        // // ll.printList();
        // // System.out.println(ll.checkPalindrome());
        // System.out.println(detect_cycle(ll));
        // remove_cycle(ll);
        // System.out.println(detect_cycle(ll));
        ll.printList();
        // ll.head = ll.merge_sort(ll.head);
        ll.solution2(2, 3);
        ll.printList();
    }
}
