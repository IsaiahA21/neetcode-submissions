class Solution {
    int n = -1;
    int m = -1;
    int[][] heights = null;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;
        this.heights= heights;
        boolean[][] canReachPacific = new boolean[n][m];
        boolean[][] canReachAtlantic = new boolean[n][m];
        List<List<Integer>> res = new ArrayList<>();

        // DFS on pacific ocean (left col) and atlantic ocean (right col)
        for (int i = 0; i < n; i++) {
            dfs(i, 0, canReachPacific, heights[i][0]); // add left col (pacific)
            dfs(i, m - 1, canReachAtlantic, heights[i][m - 1]); // add right col (atlantic)
        }

        // DFS on pacific ocean (top col) and atlantic ocean (bottom col)
        for (int j = 0; j < m; j++) {
            dfs(0, j, canReachPacific, heights[0][j]); // add top col (pacific)
            dfs(n - 1, j, canReachAtlantic, heights[n - 1][j]); // add bottom col (atlantic)
        }

        // the cells that are true in both are reachable
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (canReachPacific[i][j] && canReachAtlantic[i][j]) {
                    res.add(new ArrayList<>(List.of(i, j)));
                }
            }
        }
        return res;
    }

    /**
    From each ocean side, check which clean can reach it.
    we start from the ocean and we if height at cell is greater than or equal to  prev cell height.
    If yes, mark as true that we can each ocean


*/
    public void dfs(int row, int col, boolean[][] ocean, int prevHeight) {
        if (col < 0 || col >= m || row < 0 || row >= n) {
            return;
        }

        if (ocean[row][col]){ // if we can already reach the ocean from this cell return to avoid infinite loop
            return;
        }

        if (heights[row][col] < prevHeight) {// meaning that the water wouldnt be able to flow downhill to the ocean from here
            return;
        }

        // its possible to reach this ocean from the side that's calling the DFS
        ocean[row][col] = true; 
        dfs(row - 1, col, ocean, heights[row][col]);
        dfs(row + 1, col, ocean, heights[row][col]);
        dfs(row, col - 1, ocean, heights[row][col]);
        dfs(row, col + 1, ocean, heights[row][col]);
    }
}
