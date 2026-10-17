/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // idea: Map and 2 passes
        // first pas son head: create copy nodes. populate Map {OldNode:CopyNode}
        // sec pass on head: set ptrs of copy nodes. copyNode  = Map.get(oldNode); copyNode.next = Map.get(oldNode.next); copyNode.random = Map.get(oldNode.random);

        HashMap<Node, Node> oldToCopy = new HashMap<>(); // oldNode -> copyNode;
        Node curr = head;
        
        // first pas son head: create copy nodes. populate Map {OldNode:CopyNode}
        while (curr != null) {
            Node copy = new Node(curr.val);
            oldToCopy.put(curr, copy);

            curr = curr.next;
        }


        // sec pass on head: set ptrs of copy nodes. copyNode  = Map.get(oldNode); copyNode.next = Map.get(oldNode.next); copyNode.random = Map.get(oldNode.random);
        curr = head;
        while (curr != null){
            Node copy = oldToCopy.get(curr);
            copy.next = oldToCopy.get(curr.next);
            copy.random = oldToCopy.get(curr.random);

            curr = curr.next;
        }

        return oldToCopy.get(head);
    }
}
