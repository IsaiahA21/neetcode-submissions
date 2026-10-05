/**
How can i make it log(n *m)
treat it like 1 log array: I know the start and end
m(row) = 3
n(col) = 4;

lptr = 0;
rptr = (m * n) -1;

to search row
int mid = (rptr + mid )/2 = 11/2 = 5


which row, then which col??

we know 0-3 is row 1 -> cause index / 4 = 0
for row index = 5 -> 5/ n = 1
for index = 7 -> 7/n = 1


okay how do we know the col??
well for col 1(0-3), remainder index % n = col
row index 5, the col in row 1 is  5 % n(4) = 1

*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int lptr = 0;
        int rptr = (rows * cols) - 1; // the very last index in the array

        while (lptr <= rptr) {
            int mid = (rptr + lptr) / 2;

            int row = mid/cols;
            int col = mid % cols;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                lptr = mid + 1;
            } else if (matrix[row][col] > target) {
                rptr = mid - 1;
            }
        }

        return false;
    }
}
