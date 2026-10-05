class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int lptr = 0;
        int rptr = n-1;

        while (lptr <= rptr){
            int mid = (rptr + lptr) / 2;

            if(nums[mid] == target){
                return mid;
            }
            else if (nums[mid] < target) {
                lptr = mid + 1;
            }
            else if (nums[mid] > target) {
                rptr = mid - 1;
            }
        }

        return -1;
    }
}
