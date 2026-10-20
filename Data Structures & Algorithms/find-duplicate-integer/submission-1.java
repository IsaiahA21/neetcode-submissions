
/**
 integer in nums is in the range [1, n] inclusive.
 nums = [1,2,3,2,2]

 Is the array sorted?
 Also if we have 1 to n elements, can we then just check if the length exceed n?
 but to get n 
*/
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        // Find where the two pointers meet inside the cycle
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                break;
            }
        }

        // Find the start of the cycle
        slow = 0;

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}