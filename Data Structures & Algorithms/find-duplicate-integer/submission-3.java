class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]); // use the current val as an index

            // if the value of this index is already negative, we've encouter visited this position
            // therefore duplicate
            if (nums[index] < 0){
                return index;
            }

            // mark this index as visited
            nums[index] *= -1;
        }
        return -1;
    }
}
