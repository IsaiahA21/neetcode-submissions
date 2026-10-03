class Node<T> {
    int val;
    int min;
    Node next;

    public Node(int val, int min){
        this.val = val;
        this.min = min; // allwats stop the min ele seen so far
        this.next = null;
    }
}
/*
The trick is to store the minimum at each node.
add to top and remove from the top
5 -> 6 -> 1 ->8 -> null
head
*/

// last in first out
class MinStack {
    Node head; // will always point to the top of the stack


    public MinStack() {
    }
    
    public void push(int val) {
        if(head == null){
            head = new Node(val, val);
        }
        else {
            Node newNode;
            int min = Math.min(val, head.min);
            newNode = new Node(val, min);

            newNode.next = head;
            head = newNode;
        }

    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}
