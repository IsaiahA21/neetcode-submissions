/**
Because we can reuse a number its n! ( i dont know acc)

sub problems.

my appraoch is similar to my subset neetcode solution
we iterate:
 - we take a ele, run dfs on it.
 - if add up to solution, add to res
 - if no, we iterate on the list again and take next element.
 - if always check if sum > than solution. if so we stop and return (we backtrack)

the interesting thing here is the unique combination.
Input:


nums=[2,5,6,9]
target=9

Your Output:
[[2,2,5],[2,5,2],[5,2,2],[9]]

Expected output:
[[2,2,5],[9]]

I can solve this by sorting and memo?
 - I think so. I sort the array before backtracking.
 - then I have a cache were I append the solution and check if we start recursion.
 - hmm? but isnt memo for no repeating invalid things?

Key is distinct: - tells that once we a solution and we keep moving forward we wouldnt see that
solution again.
 - no sorting needed
 - and once we get a solution move idx to the next element to avoid seeing same solution again.
 - [2,2,5]. after we get this move pointer to idx + 1 meaning go to idx = 1,  5. We dont want to use
2 ever again in any solution.
  - cause we would have already tried 2,2, 2,2, 2 and that would fail.
  - so no more adding twos.

  then once we move on from indx =0, we move to 5 and we dont go back to idx 0. because we would see
solution combinations we already found.


We can sort and stop early. max n is 20 so sorting is cheaper than recursion.

*/
class Solution {
    List<List<Integer>> res;
    int target;
    int[] nums;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        this.target = target;
        this.nums = nums;

        Arrays.sort(this.nums);
        Set<List<Integer>> memo = new HashSet<>();

        backtrack(new ArrayList<>(), 0, 0); // path , and running sum  and index;

        return res;
    }
    public void backtrack(List<Integer> path, int runningSum, int idx) {
        if (runningSum > target) {
            return;
        }
        if (runningSum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            int num = nums[i];

            if (runningSum + num > target){
                // end this recursion cause nothing else will work.
                return;
            }
            
            path.add(num);
            backtrack(path, runningSum + num, i); // start backtrack
            path.remove(path.size() - 1);
        }
    }
}
