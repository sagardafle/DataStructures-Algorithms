class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
public class SumListsReverse {
    
    static Node l1, l2;
    public static void main(String[] args) {
        l1 = new Node(7);
        l1.next = new Node(1);
        l1.next.next = new Node(6);

        l2 = new Node(5);
        l2.next = new Node(9);
        l2.next.next = new Node(2);
        SumListsReverse sumreverse = new SumListsReverse();

        Node newList = sumreverse.sumLists(l1, l2);
        sumreverse.printList(newList);
    }

    public Node sumLists(Node l1, Node l2) {
        return sumListsHelper(l1, l2, 0);
    }

    public Node sumListsHelper(Node l1, Node l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) return null;

        Node result = null;
        int value = carry;
        if (l1 != null) {
            value += l1.data;
        }
        if (l2 != null) {
            value += l2.data;
        }

        //create new node
        result =  new Node(value%10); //we will only take the 1st digit of the value

        /* Recurse */
        if (l1 != null || l2 != null) {
            Node more = sumListsHelper(l1 == null ? null : l1.next,
                    l2 == null ? null : l2.next,
                    value >= 10 ? 1 : 0); //carry
            result.next = more;
        }
        return result;
    }
    
    void printList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"-> ");
            temp = temp.next;
        }
        System.out.println();
    }
}