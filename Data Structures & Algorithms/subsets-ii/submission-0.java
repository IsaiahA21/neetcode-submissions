class Solution {
    List<List<Integer>> res;
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        Arrays.sort(this.nums);

        res = new ArrayList<>();

        dfs(new ArrayList<>(), 0);

        return res;
    }

    public void dfs(List<Integer> path, int idx) {
        res.add(new ArrayList<>(path));

        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(path, i + 1);
            path.remove(path.size() - 1);

            // once we process all the subset for this index, we check if the next index is the same
            // value and we skip
            while (i < nums.length-1 && nums[i] == nums[i + 1]) {
                i++; // the for loop i++ will move us past it
            }
        }
    }
}
