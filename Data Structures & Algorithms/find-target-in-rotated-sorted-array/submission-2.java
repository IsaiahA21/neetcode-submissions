/**
A sorted array that has been rotated so we know that we can do binary search a bit
[1,2,3,7]

// if mid > right then we know ts roated. therefore is target < mid, then its on th
*/
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int lptr = 0;
        int rptr = nums.length - 1;

        while(lptr <= rptr){
            int mid = (rptr + lptr) / 2;

            if (nums[mid] == target){
                return mid;
            }

            // the left side is sorted for sure
            if (nums[mid] > nums[rptr] ){

                if (target >= nums[lptr] && target < nums[mid]){
                    // its on the left side of the array
                    rptr = mid - 1;
                }
                else {
                    lptr = mid + 1;
                }
            }
            // System.out.println("lptr is " + lptr + " rptr is " + rptr);
            else {// right side is sorted
                if (target > nums[mid] && target <= nums[rptr]){
                    // its on the right side
                    lptr = mid + 1;
                }
                else {
                    rptr = mid - 1;
                }
            }

        }
        return -1;
    }
}
