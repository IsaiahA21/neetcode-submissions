/**
you can drop the distance[] array completely and rely solely on visited and the min-heap.
Because a min-heap always processes the smallest cost first, the very first time any node pops out
of the queue is guaranteed to be its shortest path. Every subsequent pop of that same node is simply
ignored by visited.
*/
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] edge : times) {
            adjList.get(edge[0]).add(new int[] {edge[1], edge[2]});
        }

        // {node, cost} min-heap sorted by cost
        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Set<Integer> visited = new HashSet<>();
        int maxTime = 0;

        que.add(new int[] {k, 0});

        while (!que.isEmpty()) {
            int[] curr = que.poll();
            int node = curr[0];
            int cost = curr[1];

            // Skip if we already found the shortest path to this node
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            // Min-heap pops in non-decreasing cost order, so the n-th node popped has the max time
            maxTime = cost;

            for (int[] nei : adjList.get(node)) {
                if (!visited.contains(nei[0])) {
                    que.add(new int[] {nei[0], cost + nei[1]});
                }
            }
        }

        return (visited.size() != n) ? -1 : maxTime;
    }
}
