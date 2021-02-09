//Benjamin Maymir
//maymi001@umn.edu
class PriorityQueue<Base>{
    private class Node{
        private Base object;
        private int rank;
        private Node left;
        private Node right;

        private Node(Base object, int rank){
            this.object=object;
            this.rank=rank;
            left=null;
            right=null;
        }
    }
    private Node root;

    public PriorityQueue(){
        root = new Node(null,Integer.MAX_VALUE);
    }
    public Base dequeue(){
        Node iterator = root;
        Base temp;
        if(isEmpty()){
            throw new IllegalStateException("The queue is empty");
        }
        for(;;){
            if(iterator.left.left!=null){
                iterator=iterator.left;
            } else{
                temp=iterator.left.object;
                iterator.left=iterator.left.right;
                return(temp);
            }
        }
    }
    public void enqueue(Base object, int rank){
        if(rank<0){
            throw new IllegalArgumentException("Ranks must be non-negative integers");
        }
        Node iterator = root;
        for(;;){
            if(rank>iterator.rank){
                if(iterator.right!=null){
                    iterator=iterator.right;
                } else{
                    iterator.right=new Node(object,rank);
                    break;
                }
            } else{
                if(iterator.left!=null){
                    iterator=iterator.left;
                }
                else{
                    iterator.left=new Node(object,rank);
                    break;
                }
            }
        }
    }
    public boolean isEmpty(){
        return(root.left==null);
    }

}
