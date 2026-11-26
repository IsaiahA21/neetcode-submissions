class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] distance = new int[n + 1]; // lowest time from start node to each point node

        Arrays.fill(distance, Integer.MAX_VALUE);

        // build adj list. {key : [target node. time]}
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] edge : times) {
            adjList.get(edge[0]).add(new int[] {edge[1], edge[2]});
        }

        // Dijkstra -> (BFS)
        // {node, weight} min-heap sorted by weight
        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        Set<Integer> visited = new HashSet<>(); // node
        int maxTime = 0;

        distance[k] = 0; // starting node. the time to get the signal is 0.
        que.add(new int[] {k, 0});

        while (!que.isEmpty()) {
            int[] curr = que.poll();
            int node = curr[0];
            int cost = curr[1];

            // 1. Skip if we already finalized the shortest path to this node
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            maxTime = Math.max(maxTime, cost); // First time popping `node` guarantees `cost` is
                                                  // its finalized shortest path

            for (int[] nei : adjList.get(node)) {
                int newCost = cost + nei[1];
                // 2. Only update and push if we found a strictly shorter path
                if (!visited.contains(nei[0]) && newCost < distance[nei[0]]) {
                    distance[nei[0]] = newCost;
                    que.add(new int[] {nei[0], newCost});
                }
            }
        }
        return (visited.size() != n) ? -1 : maxTime;
    }
}
