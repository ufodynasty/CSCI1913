//Benjamin Maymir
//maymi001@umn.edu
class IntySortyList
{

//  NODE. A node in a singly linked linear list of INT's.

  private class Node
  {
    private int  key;   //  The key at this NODE, duh.
    private Node next;  //  The next NODE in the list, or NULL.

//  Constructor. Initialize a new NODE with KEY and NEXT.

    private Node(int key, Node next)
    {
      this.key  = key;
      this.next = next;
    }
  }

  private Node first;  //  Head node.

//  Constructor. Let FIRST be a singly linked linear list of the INT's in KEYS,
//  with a head node.

  public IntySortyList(int ... keys)
  {
     first = new Node(0, null);
     Node last = first;
     for (int key: keys)
     {
       last.next = new Node(key, null);
       last = last.next;
     }
  }

//  SORT. Sort FIRST using Selection Sort.

  public void sort()
  {
      Node newFirst = new Node(0,null);
      Node newLast = newFirst;
      Node iterator;
      int tempMin;
      while(first.next != null) {
          iterator = first;
          tempMin = first.next.key;
          while(iterator.next!=null) {
              if(iterator.next.key < tempMin) {
                  tempMin = iterator.next.key;
              }
            iterator = iterator.next;
          }
          iterator = first;
          while(iterator.next.key != tempMin) {
              iterator = iterator.next;
          }
          iterator.next = iterator.next.next;
          newLast.next = new Node(tempMin,null);
          newLast = newLast.next;
      }
      first = newFirst;
  }

//  TO STRING. Convert FIRST to a STRING, for printing.

  public String toString()
  {
    StringBuilder builder = new StringBuilder();
    builder.append('[');
    Node temp = first.next;
    if (temp != null)
    {
      builder.append(temp.key);
      temp = temp.next;
      while (temp != null)
      {
        builder.append(',');
        builder.append(' ');
        builder.append(temp.key);
        temp = temp.next;
      }
    }
    builder.append(']');
    return builder.toString();
  }
}
