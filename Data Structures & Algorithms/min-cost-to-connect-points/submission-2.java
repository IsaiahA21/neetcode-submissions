class Solution {
    public int minCostConnectPoints(int[][] points) {
        int nodes = points.length;
        Map<Integer, List<int[]>> adjList =
            new HashMap<>(); //{node, value}. the value is [cost, next node]

        // build adjecnt List
        for (int i = 0; i < nodes; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];

            adjList.putIfAbsent(i, new ArrayList<>());

            for (int j = i + 1; j < nodes; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                // undirected graph
                adjList.computeIfAbsent(i, k -> new ArrayList<>())
                    .add(new int[] {dist, j}); // [dist, node]
                adjList.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[] {dist, i});
            }
        }

        /* Prims Algorithim */

        Set<Integer> visited = new HashSet<>();
        int minCost = 0;
        PriorityQueue<int[]> minHeap =
            new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // {[distance, node]}

        // we start at the first point
        minHeap.add(new int[] {0, 0});

        while (visited.size() < nodes) {
            int[] curr = minHeap.poll(); // {[distance, node]}

            int node = curr[1];

            if (visited.contains(node)) {
                continue;
            }
            
            minCost += curr[0];
            visited.add(node);

            for (int[] nei : adjList.get(node)) {
                minHeap.add(new int[] {nei[0], nei[1]});
            }
        }

        return minCost;
    }
}