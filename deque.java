//Benjamin Maymir
//maymi001
class Deque<Base> {
    public class Node{
        private Base object;
        private Node left,right;
        private Node(Base object,Node left,Node right){
            this.object = object;
            this.left=left;
            this.right=right;
        }
    }
    private Node head;
    public Deque(){
        head = new Node(null,null,null);
        head.left=head;
        head.right=head;
    }
    public void enqueueFront(Base object){
        Node node = new Node(object,head,head.right);
        head.right.left=node;
        head.right=node;
    }
    public void enqueueRear(Base object){
        Node node = new Node(object,head.left,head);
        head.left.right=node;
        head.left=node;
    }
    public Base dequeueFront(){
        if(isEmpty()){
            throw new IllegalStateException("The deque is empty");
        }
        Base object = head.right.object;
        head.right.right.left=head;
        head.right=head.right.right;
        return(object);
    }
    public Base dequeueRear(){
        if(isEmpty()){
            throw new IllegalStateException("The deque is empty");
        }
        Base object = head.left.object;
        head.left.left.right=head;
        head.left=head.left.left;
        return(object);
    }
    public boolean isEmpty(){
        return(head.left==head&&head.right==head);
    }
    
}
//Test results
// true
// No dequeueFront.
// No dequeueRear. 
// false
// C
// B
// A
// true
// A
// B
// C
// true
// C
// B
// A
// true
// A
// B
// C
// true

