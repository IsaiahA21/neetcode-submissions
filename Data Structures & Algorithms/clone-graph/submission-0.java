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
Input: adjList = [[2],[1,3],[2]]
                   1    2    3

Output: [[2],[1,3],[2]]

Im thinking BFS to take advantage of the level traversal (or the 1 level at a time)

so root node, will give use its neigbors, we add them to the queue, then process each one
On the orginal nodes, we need a visited set to deal with the undirected connections


*/
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        ArrayDeque<Node> que = new ArrayDeque<>(); // what to prcoess
        Map<Node, Node> oldNewMap =
            new HashMap<>(); // {oldnode : newNode}. to help build the relationships. so when we
                             // see. Also functions as visited

        que.addLast(node);

        while (!que.isEmpty()) {
            Node old = que.pollFirst();
            Node newNode = new Node(old.val); // hmm but it doesnt exist yet.
            oldNewMap.put(old, newNode); // also marks it has visited

            // process old node neigbors
            for (Node neighbor : old.neighbors) {
                if (!oldNewMap.containsKey(neighbor)) {
                    que.addLast(neighbor);
                }
            }
        }

        // okay now all the new Nodes exist now lets map relationships
        que = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();
        que.addLast(node);
        visited.add(node);

        while (!que.isEmpty()) {
            Node old = que.pollFirst();
            Node newNode = oldNewMap.get(old);

            // process old node neigbors
            for (Node neighbor : old.neighbors) {
                // map the neighbors relationships (bidirectional)
                newNode.neighbors.add(oldNewMap.get(neighbor));

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    que.addLast(neighbor);
                }
            }
        }

        return oldNewMap.get(node);
    }
}