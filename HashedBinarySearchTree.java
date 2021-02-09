//maymi001@umn.edu
//Benjamin Maymir
import java.util.Random;
class HBST<Key, Value> {
    private Random generator;
    private TreeNode root;
    private class PairNode{
        Key key;
        Value value;
        PairNode next;
        private PairNode(Key key, Value value){
            this.key=key;
            this.value=value;
        }
    }
    private class TreeNode{
        PairNode head;
        int hash;
        TreeNode left;
        TreeNode right;
        private TreeNode(Key key, Value value){
            this.hash = hash(key);
            head = new PairNode(null,null);
            head.next = new PairNode(key,value);
            left = null;
            right = null;
        }
        private int height(){
            if(left==null&&right==null){
                return 0;
            }else if(left==null){
                return right.height()+1;
            }else if(right==null){
                return left.height()+1;
            } else{
                return((right.height()>left.height()?right.height():left.height())+1);
            }

        }

    }
    public HBST(){
        generator = new Random();
        root = new TreeNode(null,null);
        root.hash = -1;
    }
    public Value get(Key key){
        TreeNode treeIterator = root;
        for(;;){
            if(treeIterator==null){
                throw new IllegalArgumentException("Your key's hash is not in the tree");
            }
            if(treeIterator.hash==hash(key)){
                PairNode listIterator = treeIterator.head;
                for(;;){
                    if(listIterator == null){
                        throw new IllegalArgumentException("Your key is not in the tree");
                    }
                    if(isEqual(listIterator.key,(key))){
                        return(listIterator.value);
                    }
                    listIterator=listIterator.next;
                }
            } else{
                treeIterator = hash(key)>treeIterator.hash?treeIterator.right:treeIterator.left;
            }
        }
    }
    public int height(){
        return root.height();
    }
    private int hash(Key key){
        if(key==null){
            return 0;
        }
        generator.setSeed(key.hashCode());
        return(Math.abs(generator.nextInt()));
    }
    public boolean isEmpty(){
        return(root.right!=null);
    }
    private boolean isEqual(Key left, Key right){
        return(left==null?left==right:left.equals(right));
    }
    public void put(Key key, Value value){
        TreeNode treeIterator = root;
        for(;;){
            if(treeIterator.hash==hash(key)){
                PairNode listIterator = treeIterator.head;
                while(listIterator.next!=null){
                    if(isEqual(listIterator.next.key,key)){
                        listIterator.next.value=value;
                    }
                    listIterator=listIterator.next;
                }
                listIterator.next = new PairNode(key,value);
                break;
            }
            if(hash(key)>treeIterator.hash){
                if(treeIterator.right==null){
                    treeIterator.right=new TreeNode(key,value);
                    break;
                }else{
                    treeIterator=treeIterator.right;
                }
            } else{
                if(treeIterator.left==null){
                    treeIterator.left=new TreeNode(key,value);
                    break;
                }else{
                    treeIterator=treeIterator.left;
                }
            }
        }

    }
}


class CornedBeefHash 
{ 
  private final static String[] reserved = 
   { "abstract",     "assert",       "boolean",     "break", 
     "byte",         "case",         "catch",       "char", 
     "class",        "const",        "continue",    "default", 
     "do",           "double",       "else",        "extends", 
     "false",        "final",        "finally",     "float", 
     "for",          "goto",         "if",          "implements", 
     "import",       "instanceof",   "int",         "interface", 
     "long",         "native",       "new",         "null", 
     "package",      "private",      "protected",   "public", 
     "return",       "short",        "static",      "super", 
     "switch",       "synchronized", "this",        "throw", 
     "throws",       "transient",    "true",        "try", 
     "var",          "void",         "volatile",    "while" }; 
 
  public static void main(String [] args) 
  { 
    HBST<Integer, Integer> intToInt = new HBST<Integer, Integer>();
    for (int key = -10; key <= 10; key += 1) 
    { 
      intToInt.put(key, key * key); 
    } 
    System.out.println(intToInt.height()); 
    for (int key = -10; key <= 10; key += 1) 
    { 
      System.out.format("%3d %3d", key, intToInt.get(key)); 
      System.out.println(); 
    } 
 
    System.out.println(); 
 
    HBST<String, Integer> stringToInt = new HBST<String, Integer>(); 
    for (int index = 0; index < reserved.length; index += 1) 
    { 
      stringToInt.put(reserved[index], index); 
    } 
    System.out.println(stringToInt.height()); 
    for (int index = 0; index < reserved.length; index += 1) 
    { 
      String name = reserved[index]; 
      System.out.format("%02d %s", stringToInt.get(name), name); 
      System.out.println(); 
    } 
  } 
}


//output of the CornedBeefHash driver class

/* 8
-10 100
 -9  81
 -8  64
 -7  49
 -6  36
 -5  25
 -4  16
 -3   9
 -2   4
 -1   1
  0   0
  1   1
  2   4
  3   9
  4  16
  5  25
  6  36
  7  49
  8  64
  9  81
 10 100

11
00 abstract
01 assert
02 boolean
03 break
04 byte
05 case
06 catch
07 char
08 class
09 const
10 continue
11 default
12 do
13 double
14 else
15 extends
16 false
17 final
18 finally
19 float
20 for
21 goto
22 if
23 implements
24 import
25 instanceof
26 int
27 interface
28 long
29 native
30 new
31 null
32 package
33 private
34 protected
35 public
36 return
37 short
38 static
39 super
40 switch
41 synchronized
42 this
43 throw
44 throws
45 transient
46 true
47 try
48 var
49 void
50 volatile
51 while */