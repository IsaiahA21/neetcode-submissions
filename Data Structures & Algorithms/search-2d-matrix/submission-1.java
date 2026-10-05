/**

two ptrs binary search on reg int[]
 - there we check if see it in the list

- I think here we search if we can see it in the

-------
check if the target can exist in that row if yes, binary search on row,
else return false
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (target >= matrix[i][0] && matrix[i][cols - 1] >= target) {
                int lptr = 0;
                int rptr = cols;
                while (lptr <= rptr) {
                    int mid = (rptr + lptr) / 2;

                    if (matrix[i][mid] == target) {
                        return true;
                    } else if (matrix[i][mid]  < target) {
                        lptr = mid + 1;
                    } else if (matrix[i][mid]  > target) {
                        rptr = mid - 1;
                    }
                }
            }
        }
        return false;
    }
}
