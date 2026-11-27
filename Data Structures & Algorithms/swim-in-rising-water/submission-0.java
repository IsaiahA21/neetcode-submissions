class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // [maxHeight, row, col]
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // starting point
        minHeap.add(new int[] {grid[0][0], 0, 0});
        visited[0][0] = true;

        while (!minHeap.isEmpty()) {
            int[] node = minHeap.poll();

            if (node[1] == n - 1 && node[2] == m - 1) {
                return node[0];
            }

            for (int[] dir : dirs) {
                int x = node[1] + dir[0];
                int y = node[2] + dir[1];

                if (x < 0 || x >= n || y < 0 || y >= m) {
                    continue;
                }
                if (visited[x][y]) {
                    continue;
                }
                visited[x][y] = true;
                int newT = Math.max(node[0],grid[x][y]);
                minHeap.add(new int[] {newT, x, y});
            }
        }

        return -1;
    }
}
