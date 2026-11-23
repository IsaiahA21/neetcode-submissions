/**
we have to find the cycle - a tree doesnt have cycles
1. draw the adj List
2. cycle detection
3.
n=4
edges=[[0,1],[2,3]]
- if 2 trees, then not valid
all the notes need to be in the same tree
*/
class Solution {
    boolean[] visited;
    Map<Integer, List<Integer>> adjList;

    public boolean validTree(int n, int[][] edges) {
        this.visited = new boolean[n];

        // 1, build adj List
        this.adjList = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (int edge[] : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        // detect cycle in undirected graph

        // node, parent. we send the parent to know where we came from so we differeniate from a
        // cycle - if return true then cycle
        if (hasCycle(0, -1)) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if(visited[i] == false) {// of any node is still unvisted
                return false;
            }
        }
        return true;
    }

    public boolean hasCycle(int node, int parentNode) {
        if (visited[node]) {
            return true;
        }

        visited[node] = true;

        for (int nei : adjList.get(node)) {
            if (nei == parentNode) {
                continue;
            }
            if (hasCycle(nei, node)) {
                return true;
            }
        }
        // visited[node] = false;

        return false;
    }
}
