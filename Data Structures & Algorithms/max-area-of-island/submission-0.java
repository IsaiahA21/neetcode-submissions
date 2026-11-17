/**
Similar to the island counting question but instead we sum up the area of each island
*/
class Solution {
    int largest = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int size = dfs(r, c, grid);
                    largest = Math.max(largest, size);
                }
            }
        }

        return largest;
    }

    public int dfs(int r, int c, int[][] grid) {
        // base cases
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return 0;
        }

        if (grid[r][c] == 0)
            return 0;

        grid[r][c] = 0; // make it water

        return 1 + dfs(r + 1, c, grid) + dfs(r - 1, c, grid) + dfs(r, c + 1, grid)
            + dfs(r, c - 1, grid);
    }
}
