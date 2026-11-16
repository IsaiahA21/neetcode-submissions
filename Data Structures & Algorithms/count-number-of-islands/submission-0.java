/**
DFS Graphs: iterate over 2d, when we find a '1', increment count, then we begin dfs to find all land
part of this island.

dfs (): exhustive search for all land.

when we find a island, we turn it into water so we cant find it again

*/

class Solution {
    char[][] grid;
    int n;
    int m;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        int count = 0;
        n = grid.length;
        m = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j); // find all the land connected
                }
            }
        }

        return count;
    }

    private void dfs(int r, int c) {
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
        dfs(r + 1, c); // down
        dfs(r - 1, c); // up
        dfs(r, c + 1); // right
        dfs(r, c - 1); // left
    }
}
