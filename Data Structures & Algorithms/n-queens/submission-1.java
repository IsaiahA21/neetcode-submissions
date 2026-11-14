
/**
 all distinct solutions -> backtracking (Choose, explore, Undo).
 place a queen, explore and undo if it doesnt lead to a solution
Instead of having a nested for loop and trying every cell using two nested loops,
consider we need to place exactly n queens on n rows.
Think:
    Im placing a queen in row r. Which column should row choose?
then the recursion become :
dfs(0) → place a queen in row 0.
dfs(1) → place a queen in row 1.
dfs(2) → place a queen in row 2.
...
dfs(n) → all queens have been placed. We found a solution.

And since we place 1 queen in 1 row, then all we have to do is:
Same column: We need to check whether a previous queen occupies that column.
Diagonals: We need to check whether a previous queen attacks our candidate diagonally.

We dont necessarily need to mark every attacked cell with #.
And we can keep the queens on the board and check whether a candidate position is safe before
placing one.


What happens if we place the first queen and we reliase no solution?
n = 4 to visualize.
Suppose we start with a queen at (0, 0):
* dfs(3) returns because no column in row 3 is valid.
* We return to dfs(2), which undoes its previous queen and tries another column.
* If row 2 has no more valid columns, it returns to dfs(1).
* Eventually, if all possibilities under (0, 0) fail, we return to dfs(0).
* We undo (0, 0) and try (0, 1).
*/

class Solution {
    List<List<String>> res;
    char[][] board;
    int n;
    boolean[] col; // if true, Q already there
    Set<Integer> posDiag; // r + c // Q on that axis
    Set<Integer> negDiag; // r -c // Q on that axis

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        board = new char[n][n]; // '\u0000'

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        this.n = n;
        col = new boolean[n];
        posDiag = new HashSet<>();
        negDiag = new HashSet<>();

        dfs(0); // we place the first queen on row 0

        return res;
    }

    // we place
    public void dfs(int row) {
        if (row == n) {
            // add the board
            List<String> copy = new ArrayList<>();


            for (char[] r : board) {
                copy.add(new String(r));
            }
            res.add(copy);

            return;
        }

        for (int c = 0; c < n; c++) {
            // check if placement is safe

            // is Q already on that column or diagonal
            if (col[c]) {
                continue;
            }
            
            if (posDiag.contains(row+c)) {
                continue;
            }
            if (negDiag.contains(row - c)) {
                continue;
            }

            // choose
            board[row][c] = 'Q';
            col[c] = true;
            posDiag.add(row+c);
            negDiag.add(row - c);

            dfs(row + 1); // explore

            // undo
            board[row][c] = '.';
            col[c] = false;
            posDiag.remove(row+c);
            negDiag.remove(row - c);
        }
    }
}
