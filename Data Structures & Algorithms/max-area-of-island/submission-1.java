class Solution {
    int[][] coors = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int largest = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int size = bfs(r, c, grid);
                    largest = Math.max(largest, size);
                }
            }
        }

        return largest;
    }

    // explore a cell, mark it as visited, then push its neigbhors into the queue
    public int bfs(int r, int c, int[][] grid) {
                int size = 0;

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        grid[r][c] = 0; // mark as visited

        queue.offerLast(new int[] {r, c});

        while (!queue.isEmpty()) {
            int[] land = queue.pollFirst();
            size++;

            // grab neighbors
            for (int[] dir : coors) {
                int nr = dir[0] + land[0];
                int nc = dir[1] + land[1];

                if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length) {
                    continue;
                }
                if (grid[nr][nc] == 0) {
                    continue;
                }

                // mark visited then add to queue
                grid[nr][nc] = 0;
                queue.addLast(new int[]{nr, nc});

            }
        }

        return size;
    }
}
