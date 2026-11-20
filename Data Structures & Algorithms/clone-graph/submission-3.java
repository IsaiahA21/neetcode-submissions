/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

/**
DFS attempt
*/
class Solution {
    Map<Node, Node> oldToNewMap;

    public Node cloneGraph(Node node) {
        oldToNewMap = new HashMap<>();

        return dfs(node);
    }

    /**
    Run this and create a copy of a node
    and if the copy of a neighbor doesnt exist, create it and store it in the map
    we recursively create the copy by going down a negibhors.
    */
    private Node dfs(Node node) {
        if (node == null)
            return null;

        if (oldToNewMap.containsKey(node)) {
            return oldToNewMap.get(node);
        }

        // Create and store clone before exploring neighbors.
        Node newNode = new Node(node.val);
        oldToNewMap.put(node, newNode);

        // copy the neighbors
        for (Node nei : node.neighbors) {
            Node copy = dfs(nei); // use DFS to create the new node if it doesnt exist

            // add the neighbor to the new node
            newNode.neighbors.add(copy);
        }

        return newNode;
    }
}