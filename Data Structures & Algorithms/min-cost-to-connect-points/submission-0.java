class Solution {

    record Point(int x, int y) {}

    public int minCostConnectPoints(int[][] points) {
        int nodes = points.length;
        Map<Point, List<int[]>> adjList =
            new HashMap<>(); //{point, value}. the value is [cost, x, y]

        // build adjecnt List
        for (int i = 0; i < nodes; i++) {
            Point point = new Point(points[i][0], points[i][1]);

            adjList.putIfAbsent(point, new ArrayList<>());

            for (int j = i + 1; j < nodes; j++) {
                Point point2 = new Point(points[j][0], points[j][1]);

                int dist = Math.abs(point.x() - point2.x())
                         + Math.abs(point.y() - point2.y());

                // undirected graph
                adjList.computeIfAbsent(point, k -> new ArrayList<>())
                    .add(new int[] {dist, point2.x(), point2.y()});
                adjList.computeIfAbsent(point2, k -> new ArrayList<>())
                    .add(new int[] {dist, point.x(), point.y()});
            }
        }

        /* Prims Algorithim */

        Set<Point> visited = new HashSet<>();
        int minCost = 0;
        PriorityQueue<int[]> minHeap =
            new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // {[distance, point[]]}

        // we start at the first point
        minHeap.add(new int[]{0, points[0][0], points[0][1]});

        while (visited.size() < nodes) {
            int[] curr = minHeap.poll(); // {[distance, point[]]}
            Point point = new Point(curr[1], curr[2]);

            if (visited.contains(point)) {
                continue;
            }

            minCost += curr[0];
            visited.add(point);

            for (int[] nei : adjList.getOrDefault(point, new ArrayList<>())) {
                minHeap.add(new int[]{nei[0], nei[1], nei[2]});
            }
        }

        return minCost;
    }
}