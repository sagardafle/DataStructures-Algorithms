class Node{
      int data;
      Node next;
      Node(int data){
            this.data = data;
            this.next = null;
      }
}
      
      public class LinkedListImplementation{
            static Node head, front, rear = null;
            public static void main(String[] args){
                  LinkedListImplementation queueusingll = new LinkedListImplementation();
                  queueusingll.enqueue(100);
                  queueusingll.enqueue(200);
                  queueusingll.enqueue(300);
                  queueusingll.enqueue(400);
                  
                  for(int i=0; i<4;i++){
                        System.out.println("Queue Dequeue "+queueusingll.dequeue());
                  }
                  
                  // System.out.println("Peek "+queueusingll.peek());
                  
                  System.out.println("IsEmpty "+queueusingll.isEmpty());
                  
                  System.out.println("Size "+queueusingll.size());
            }
            
            /*1. EnQueue*/
            /* Add the value on the end(rear) side, unlike the front side*/
            public void enqueue(int data){
                  Node node = null;
                  if(head == null) {
                        head = new Node(data);
                        front = head;
                        rear = front;
                  } else {
                        node = new Node(data);
                        rear.next = node;
                        rear = node;
                  }
            }
            
            /*2. DeQueue*/
            public int dequeue(){
                  if(front == null) System.out.println(" Linked List is empty ");
                  int val = front.data;
                  front = front.next; //push front forward.
                  return val;
            }
            
            /*3. Peek */
            public int peek(){
                  if(front == null) System.out.println(" Linked List is empty ");
                  return front.data;
            }
            
            /*4. IsEmpty */
            public boolean isEmpty(){
                  return (front == null && rear == null);
            }
                  
            /*5. Size  */  
            public int size(){
                  if(front == null) return 0;
                  int size = 1;
                  Node temp = front;
                  while(temp!=rear){
                        temp = temp.next;
                        ++size;
                  }
                  return size;
            }
            
      }