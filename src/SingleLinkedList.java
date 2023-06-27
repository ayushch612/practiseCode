
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class SingleLinkedList {
    public static class Node{
        int data;
        Node next = null;

        public Node (int d){
            this.data = d;
        }
    }

    public static SingleLinkedList mergeLL(Node head1,Node head2) {
        SingleLinkedList mergeSLL = new SingleLinkedList();
        if (head1 == null && head2 == null){
            return null;
        }else{
            Node ptr1 = head1 ,ptr2 = head2;
            while(ptr1 != null && ptr2 != null){
            if(ptr1.data >= ptr2.data){
                mergeSLL.enqueue(ptr2.data);
                ptr2 = ptr2.next;
            }else {
                mergeSLL.enqueue(ptr1.data);
                ptr1 = ptr1.next;
            }
        }
            if(ptr1 == null) {
                while(ptr2 != null){
                    mergeSLL.enqueue(ptr2.data);
                    ptr2 = ptr2.next;
                }
            } else {
                while(ptr1 != null){
                    mergeSLL.enqueue(ptr1.data);
                    ptr1 = ptr1.next;
                }
            }
        }
        return mergeSLL;
    }

    Node head = null;
    Node tail = null;

    public void enqueue(int d){
        Node newNode = new Node(d);
        if(head == null){
            head = newNode;
        }else{
            tail.next=newNode;
        }
        tail = newNode;
    }

    public int dequeue(){
        if (head == null){
            return -1;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        if(head == null){
            tail.next = null;
        }
        return temp.data;
    }

    public int midPoint(){
        Node ptr1 = head, ptr2 = head;
        while (ptr2.next!=null && ptr2.next.next!=null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
        }
        return ptr1.data;
    }

    public void push(int d){
        Node newNode = new Node(d);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
    }

    public void insertCll(int d){
        Node newNode = new Node(d);
        if(head==null) {
            newNode.next = newNode;
            head = newNode;
        } else{
            Node temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            newNode.next = head;
            temp.next = newNode;
        }
    }

    public void deleteWithoutHead(Node ptr) {
        Node temp = ptr.next;
        ptr.data = temp.data;
        ptr.next = temp.next;
        temp.next = null;
    }

    public int isCircularLL(){
        Node temp = head;
        while(temp.next!=head && temp.next!=null){
            temp = temp.next;
        }
        if(temp.next == head){
            return 1;
        }
        return 0;
    }

    public int pop(){
        if (head == null){
            return -1;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        return temp.data;
    }

    public void printLL(){
        Node ptr = head;
        while(ptr!= null){
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public void reverseSLL() {
        Node prev = null, curr = head, fut = head.next;
        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = fut;
            if (fut != null) {
                fut = fut.next;
            }
        }
        head = prev;
    }

    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        SingleLinkedList sll = new SingleLinkedList();
        //sll.push(1);
        //sll.push(2);
        //sll.push(3);
        //sll.push(4);

//        sll.enqueue(1);
//        sll.enqueue(2);
//        sll.enqueue(3);
//        sll.enqueue(4);
//        sll.enqueue(5);
//        sll.printLL();

        //SingleLinkedList sll2 = new SingleLinkedList();
        sll.push(1);
        sll.push(2);
        sll.push(3);
        sll.push(4);
        sll.printLL();
        Node temp = sll.head.next;

        sll.deleteWithoutHead(temp);
        sll.printLL();
//        sll2.enqueue(2);
//        sll2.enqueue(4);
//        sll2.enqueue(6);
//        sll2.enqueue(8);
//        sll2.enqueue(10);
//        sll2.printLL();

//        sll.insertCll(2);
//        sll.insertCll(4);
//        sll.insertCll(6);
//        sll.insertCll(8);
//        sll.insertCll(10);

        System.out.println(sll.isCircularLL());


        //sll.printLL();

//        SingleLinkedList sll3 = mergeLL(sll.head,sll2.head);
//        sll3.printLL();
//        System.out.println(sll2.dequeue() + " is dequeued");
//        System.out.println(sll2.dequeue() + " is dequeued");
//        System.out.println(sll2.dequeue() + " is dequeued");
//        System.out.println(sll2.dequeue() + " is dequeued");
//        //System.out.println(sll.dequeue() + " is dequeued");
//        sll3.printLL();


        //sll.reverseSLL();
//        sll.printLL();
//        System.out.println(sll.midPoint() + " is midpoint");


        //System.out.println(sll.pop() + " is popped out");
        //System.out.println(sll.dequeue() + " is dequeued");
        //System.out.println(sll.dequeue() + " is dequeued");
        //System.out.println(sll.dequeue() + " is dequeued");
        //System.out.println(sll.dequeue() + " is dequeued");
        //System.out.println(sll.dequeue() + " is dequeued");

//        sll.printLL();
    }
}