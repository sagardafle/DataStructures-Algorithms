/**
 * https://leetcode.com/problems/lru-cache/
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. 
When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * /
 * 
SOLUTION:
/**
 * The LRU cache is a hash map of keys and double linked nodes. 
 * The hash table makes the time of get() to be O(1). 
 * The list of double linked nodes make the nodes adding/removal operations O(1).
 */
 
 class Node{
    int key;
    int value;
    Node pre;
    Node next;
 
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class 146_LRUCache{
    int capacity;
    HashMap<Integer,Node> map = new HashMap<Integer,Node>();
    Node head=null;
    Node tail=null;
    
    public 146_LRUCache(int capacity) {  //paramterized constructor
        this.capacity = capacity;
    }
    
    public int get(int key){ //returns a node value against the given key.
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n); //removes n from its actual position
            setHead(n); //places n in the front(head).
            return n.value;
        }
         return -1; //return -1 as the key is not found in the hashmap.
    }
    
     /**
      * removes the node from its actual position.
      */ 
    public void remove(Node n){                                                     // 10 <-> 20 <-> 30  ; let n=20.
        if(n.pre!=null){                                                            
             n.pre.next = n.next; //removing n from the list                        // 10 <- 20 <-> 30  // set 10.next = 30.
        } else {
            // n is the head
            head = n.next; //remove n and set the next to n.next.
        }
        
        if(n.next!=null){   
            n.next.pre = n.pre;                                                     // 10  20 <-> 30  // set 30.pre = 10.                                                    
        } else {
            // n is the tail
            tail = n.pre;
        }
    }
    
    /**
     * Moves the required node in the front.                                       //20 <-> 10 <-> 30   // Move 20 at the topmost position(set it to head).
     * */
    public void setHead(Node n){
       n.next = head;
       n.pre = null;
       if(head!=null){
           head.pre = n;  //bring n to the front
       }
       head = n; //set n as the new head(so it will be on the front)
       
       if(tail ==null)  //incase there's only 1 element.
            tail = head;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key){
            Node old = map.get(key);
            remove(old);
            setHead(old);
        } else {
            Node newNode = new Node(key,value); //create a new node.
            //check the capacity before adding.
            if(map.size()>=capacity){
                map.remove(tail.key); //remove the last key (as it was least recently used.)
                remove(tail);
            }
            // add the node to the front
            setHead(newNode);
            map.put(key, newNode); //add an entry to hashmap
        }
    }
}

