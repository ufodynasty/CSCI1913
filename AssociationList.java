//Benjamin Maymir
//maymi001
class AssociationList<Key,Value> {
    private class Node{
        private Key key;
        private Value value;
        private Node next;
        private Node(Key key, Value value, Node next){
            this.key=key;
            this.value=value;
            this.next=next;
        }
    }
    private Node head;
    public AssociationList(){
        head = new Node(null,null,null);
    }
    public void delete(Key key){
        Node temp = head;
        while(temp.next!=null){
            if(isEqual(temp.next.key,key)){
                temp.next=temp.next.next;
                break;
            }
            temp=temp.next;
        }
    }
    public Value get(Key key){
        Node temp = head;
        while(temp.next!=null){
            if(isEqual(temp.next.key,key)){
                return(temp.next.value);
            }
            temp=temp.next;
        }
        throw new IllegalArgumentException(key + " is not in the list");
    }
    private boolean isEqual(Key leftKey, Key rightKey) {
		if(leftKey == null)
			return(leftKey == rightKey);
		return(leftKey.equals(rightKey));
    }
    public boolean isIn(Key key){
        Node temp = head;
        while(temp.next!=null){
            if(isEqual(temp.next.key,key)){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
    public void put(Key key,Value value){
        Node temp = head;
        while(temp.next!=null){
            if(isEqual(temp.next.key,key)){
                temp.next.value=value;
            }
            temp=temp.next;
        }
        Node node = new Node(key,value,head.next);
        head.next=node;

    }
}
// Test results
// false
// No null
// true   
// false  
// true   
// true
// true
// false
// Lavender
// Ginny
// null
// Wormtail
// No Joanne
// false
// true
// null
// Ginny
// Ginny
// Hermione
// No Dean