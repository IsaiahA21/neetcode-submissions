/**
backtracking is dfs with pruning
dfs is all about bracking things down into subproblems - how can I use this to help me? can I think
of each element as a subproblem?

Choose, explore, undo is the backtracking process.
Pruning is when you stop exploring a branch because it can't produce a valid result.
*/

/**
what if I recursively iterate remove from the list.
*/
class Solution {
    List<List<Integer>> res;
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        this.nums = nums;

        backtrack(new ArrayList<>(), 0);

        return res;
    }

    // path is to track the subset im currently building
    public void backtrack(List<Integer> path, int j) {

        res.add(new ArrayList<>(path));

        // recursion
        for (int i = j; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(path,i+1);
            path.remove(path.size() - 1);
        }
    }
}
