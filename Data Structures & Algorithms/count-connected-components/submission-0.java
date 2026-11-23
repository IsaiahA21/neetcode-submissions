/**
1. adjList
2. we explore each egde and we count the number of times we explore

*/
class Solution {
    boolean[] visited;
    Map<Integer, List<Integer>> adjList;

    public int countComponents(int n, int[][] edges) {
        this.adjList = new HashMap<>();
        this.visited = new boolean[n];
        int count = 0;

        // adj List
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        // step 2, iterate over the graph.
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, -1);
            }
        }

        return count;
    }

    /**
    explore each component
    */
    public void dfs(int node, int parent) {
        if (visited[node]){
            return;
        }

        visited[node] = true;
        for (int nei : adjList.get(node)){
            if (nei == parent) continue;

            dfs(nei, node);
        }
    }
}
