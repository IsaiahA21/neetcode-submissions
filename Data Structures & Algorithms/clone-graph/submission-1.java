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
1 pass
*/
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        ArrayDeque<Node> que = new ArrayDeque<>(); // what to prcoess
        Map<Node, Node> oldNewMap =
            new HashMap<>(); // {oldnode : newNode}. to help build the relationships. so when we

        que.addLast(node);
        oldNewMap.put(node, new Node(node.val));

        while (!que.isEmpty()) {
            Node old = que.pollFirst();
            Node cloned = oldNewMap.get(old); // also marks it has visited

            // process old node neigbors
            for (Node neighbor : old.neighbors) {
                // if we havent vistied it/ it doesnt exist
                if (!oldNewMap.containsKey(neighbor)) {
                    oldNewMap.put(neighbor, new Node(neighbor.val));
                    que.addLast(neighbor);
                }
                // build edge
                cloned.neighbors.add(oldNewMap.get(neighbor));
            }
        }
        return oldNewMap.get(node);
    }
}