/**
DFS Graphs: iterate over 2d, when we find a '1', increment count, then we begin dfs to find all land
part of this island.

dfs (): exhustive search for all land.

when we find a island, we turn it into water so we cant find it again

*/

class Solution {
    int n;
    int m;

    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        m = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid); // find all the land connected
                }
            }
        }

        return count;
    }

    private void dfs(int r, int c, char[][] grid) {
        /* base cases */

        // boundary
        if (r < 0 || r >= n || c < 0 || c >= m) {
            return;
        }

        // water
        if (grid[r][c] != '1')
            return;

        // else we have

        grid[r][c] = '#'; // mark as visited.

        // explore its neighbors
        dfs(r + 1, c, grid); // down
        dfs(r - 1, c, grid); // up
        dfs(r, c + 1, grid); // right
        dfs(r, c - 1, grid); // left
    }
}
