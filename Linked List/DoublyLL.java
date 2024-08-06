public class DoublyLL {
    public class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    //addfirst
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
             head = tail = newNode;
             return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    //add Last
    public void addLast(int data){
        Node n = new Node(data);
        size++;
        if(head == null){
            head = tail = n;
            return;
        }
        tail.next = n;
        n.prev = tail;
        tail = n;
    }

    //remove first
    public int removeFirst(){
        if(head == null){
            System.out.println("Doubly Linked List is empty");
            return -1;
        }
        if(size == 1){
            int val = head.data;
            head = tail = null;
            return val;
        }
        int val = head.data;
        size--;
        head = head.next;
        head.prev = null;

        return val;
    }

    //remove last
    public int removeLast(){
        if(head == null){
            System.out.println("Doubly Linked List is empty");
            return -1;
        }
        if(size == 1){
            int val = head.data;
            head = tail = null;
            return val;
        }
        int val = tail.data;
        size--;
        tail = tail.prev;
        tail.next = null;

        return val;
    }

    //printer
    public void printLL(){
        if(head == null){
            System.out.println("DOubly Linked List is empty!");
            return;
        }
        System.out.print("null<->");
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    //reverse a doubly linked list
    public void reverseLL(){
        Node curr = head;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;

            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }

        head = prev; //do not forget this step
    }

    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addFirst(0);
        dll.addLast(4);
        dll.printLL();
        System.out.println();
        // System.out.println(dll.removeLast());
        // dll.printLL();
        dll.reverseLL();
        dll.printLL();
    }
}
