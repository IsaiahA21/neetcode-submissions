/**
The "reverse thinking" approach involves rephrasing the problem to make it easier to solve. Instead
of trying to directly identify and capture all regions surrounded by X's, you focus on identifying
the regions that are not surrounded (those connected to the border) and capturing everything else.

We do this cause its easier condition.
*/
class Solution {
    int n;
    int m;
    char[][] board;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    List<int[]> region;
    boolean[][] visited;
    public void solve(char[][] board) {
        this.n = board.length;
        this.m = board[0].length;
        this.board = board;
        // so first look for the 'O' that are not regions by looking at the border
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && (i == 0 || i == n - 1 || j == 0 || j == m - 1)) {
                    dfs(i, j);
                }
            }
        }

        // then we mark the remain 'O' as 1 because they will be a region
        // we also mark 'T' back to 'O'.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    /**
    We capture all the cells that are not regions, by marking it to 'T'
    */
    public void dfs(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return;
        }

        if (board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'T';

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            dfs(x, y);
        }
    }
}
