/**
I think this question is simialr to the mutli source question.
There's a finte number of treasource and we are spreading from the source when we count.
So at each treasure we determine how long to reach all cells. if another treasure got there always
we put a small number. When the value is not 0 or -1 we do Math.max(cellValue, count)
*/

class Solution {
    public void islandsAndTreasure(int[][] grid) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int n = grid.length;
        int m = grid[0].length;

        // we start collect all  when we see a treasure
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 0) {
                    queue.addLast(new int[] {r, c});
                }
            }
        }

        int distance = 1;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        // we process them all at the same time using BFS
        while (!queue.isEmpty()) {
            // level order traversal
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // calculate a the spread from the treasure.
                int[] cell = queue.pollFirst();
                int x = cell[0];
                int y = cell[1];

                // add its neighbor to the Queue
                for (int[] dir : dirs) {
                    int r = x + dir[0];
                    int c = y + dir[1];
                    if (r < 0 || r >= n || c < 0 || c >= m || grid[r][c] != Integer.MAX_VALUE) {
                        continue;
                    }
                    queue.addLast(new int[] {r, c});
                    grid[r][c] = distance; // the first place to get there is the fastest and no one
                                           // else should touch it
                }
            }

            distance++; // corresponds to the levels
        }
    }
}
