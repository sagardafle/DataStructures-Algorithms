public class DynamicCircularArray {
    static int[] queuearr;
    static int size, CAPACITY, front, rear;

    DynamicCircularArray(int CAPACITY) {
        this.CAPACITY = CAPACITY;
        queuearr = new int[CAPACITY];
        size = front = rear = 0;
    }
    public static void main(String[] args) {
        CAPACITY = 6;
        DynamicCircularArray dynamicqueue = new DynamicCircularArray(CAPACITY);

        dynamicqueue.enqueue(100);
        dynamicqueue.enqueue(200);
        dynamicqueue.enqueue(300);
        dynamicqueue.enqueue(400);
        dynamicqueue.enqueue(500);
        dynamicqueue.enqueue(600);
        dynamicqueue.enqueue(700);
        dynamicqueue.enqueue(800);

            dynamicqueue.printqueue();
        for (int i = 0; i < 7; i++) {
            System.out.println("Queue Dequeue " + dynamicqueue.dequeue());
        }
        // System.out.println("Peek "+dynamicqueue.peek());

        System.out.println("IsEmpty " + dynamicqueue.isEmpty());

        System.out.println("Size " + dynamicqueue.size());

    }

    /*1. EnQUEUE*/
    public void enqueue(int data) {
        if (size == CAPACITY)
            expandqueue();
        size++;
        queuearr[rear] = data;
        System.out.println("Inserting "+data+" value at "+rear);
        rear = (rear + 1) % CAPACITY;
    }

    public void expandqueue() {
          System.out.println("Expand Queue called ");
          int len = size();
        // create a new queue of twice the size of the current queue.
        int[] expandedqueue = new int[2*len];

        //copy the elements of old queue into new queue
        for (int i = front; i <= rear; i++) {
            expandedqueue[i - front] = queuearr[i%CAPACITY];
        }
        queuearr = expandedqueue;
        front = 0;
        rear = size-1;
        CAPACITY *= 2;
    }

    /*2. DeQueue */
    public int dequeue() {
        if (size == 0) {
            System.out.println("Queue Underflow");
            return Integer.MIN_VALUE;
        } else {
            size--;
            int val = queuearr[(front % CAPACITY)];
            queuearr[( front % CAPACITY)] = Integer.MIN_VALUE;
            front = (front+1)%CAPACITY;
            System.out.println("New Front " +front);
            return val;
        }
    }

    /*3. Peek */
    public int peek() {
        if (size == 0) {
            System.out.println("Queue Underflow");
            return Integer.MIN_VALUE;
        } else {
            return queuearr[(front % CAPACITY)];
        }
    }

    /*4. IsEmpty */
    public boolean isEmpty() {
        return (size == 0);
    }

    /* 5. Size */
    public int size() {
        return size;
    }
    
    public void printqueue(){
          int i =0;
          while(i<=rear){
                System.out.print(queuearr[i++]+"->");
          }
          System.out.println();
    }
}