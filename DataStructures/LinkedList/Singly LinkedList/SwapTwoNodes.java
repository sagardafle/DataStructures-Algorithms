/**
 * Swap nodes in a linked list without swapping data
Given a linked list and two keys in it, swap nodes for two given keys. Nodes should be swapped by changing links. Swapping data of nodes may be expensive in many situations when data contains many fields. 

It may be assumed that all keys in linked list are distinct.

Examples:

Input:  10->15->12->13->20->14,  x = 12, y = 20
Output: 10->15->20->13->12->14

Input:  10->15->12->13->20->14,  x = 10, y = 20
Output: 20->15->12->13->10->14

LOGIC: 
1. Traverse through the list till we get the node-x and node-y.
2. Set the positions as required.
*/
 
class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}
 
class SwapTwoNodes
{
    Node head; // head of list
 
    /* Function to swap Nodes x and y in linked list by
       changing links */
    public void swapNodes(int x, int y)
    {
        // Nothing to do if x and y are same
        if (x == y) return;
 
        // Search for x (keep track of prevX and CurrX)
        Node prevX = null, currX = head;
        while (currX != null && currX.data != x)
        {
            prevX = currX;
            currX = currX.next;
        }
 
        // Search for y (keep track of prevY and currY)
        Node prevY = null, currY = head;
        while (currY != null && currY.data != y)
        {
            prevY = currY;
            currY = currY.next;
        }
 
        System.out.println("\nCurrX "+currX.data);
        System.out.println("CurrY "+currY.data);
        // If either x or y is not present, nothing to do
        if (currX == null || currY == null)
            return;
 
        // If x is not head of original linked list
        if (prevX != null)
            prevX.next = currY;
        else //make y the new head
            head = currY;
 
        // If y is not head of original linked list
        if (prevY != null)
            prevY.next = currX;
        else // make x the new head
            head = currX;
 
        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
        
    }
 
    /* Function to add Node at beginning of list. */
    public void push(int new_data)
    {
        /* 1. alloc the Node and put the data */
        Node new_Node = new Node(new_data);
 
        /* 2. Make next of new Node as head */
        new_Node.next = head;
 
        /* 3. Move the head to point to new Node */
        head = new_Node;
    }
 
    /* This function prints contents of linked list starting
       from the given Node */
    public void printList()
    {
        Node tNode = head;
        while (tNode != null)
        {
            System.out.print(tNode.data+" ");
            tNode = tNode.next;
        }
    }
 
    /* Druver program to test above function */
    public static void main(String[] args)
    {
        SwapTwoNodes llist = new SwapTwoNodes();
 
        /* The constructed linked list is:
            1->2->3->4->5->6->7 */
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);
 
        System.out.print("\n Linked list before calling swapNodes() ");
        llist.printList();
 
        llist.swapNodes(2, 7);
 
        System.out.print("\n Linked list afterr calling swapNodes() ");
        llist.printList();
    }
}