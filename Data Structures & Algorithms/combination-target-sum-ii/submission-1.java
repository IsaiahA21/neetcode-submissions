/**
In this case, cant use the same number against so each time we do recursion must go i+1.

didnt tell us numbers are unqiue. length of arr is 100 so we can still sort to optimize.

Input:


candidates=[9,2,2,4,6,1,5]
target=8

Your Output:
[[2,2,4],[2,6],[2,1,5],[2,6],[2,1,5]]

Expected output:
[[1,2,5],[2,2,4],[2,6]]

the issue here is that cause the numbers are not unique, I can get the same solution again.
my idea:
- sort, then if we seen the number before skip it. But we can use the identical number tho for
finding the combination.
- what is we move that outside the recursive case and only use the recrusion for combination
finding.
 - that way we can handle moving ahead if ele is the same as prev

 The rule is: skip a duplicate only when you've already considered that same value at the current
recursion level. casue we could have [9,2,2,4,6,6,1,5] then we currently [2,6], [2,6], [2,6], [2,6]
*/
class Solution {
    List<List<Integer>> res;
    int[] candidates;
    int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.res = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;
        Arrays.sort(candidates);

        dfs(new ArrayList<>(), 0, 0); // path, runningSum, index
        return res;
    }

    public void dfs(List<Integer> path, int runningSum, int idx) {
        if (runningSum > target) {
            return;
        }
        if (runningSum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        // backtrack
        for (int i = idx; i < candidates.length; i++) {
            int num = candidates[i];

            if (runningSum + num > target)
                return;

            path.add(num); // choose
            dfs(path, runningSum + num, i + 1);
            path.remove(path.size() - 1); // undo

            // after finishing that combination, we see if there any duplicates
            while (i < candidates.length - 1 && num == candidates[i + 1]) {
                i++; // move to the duplicate. the for loop i++ will handle moving past
            }
        }
    }
}
