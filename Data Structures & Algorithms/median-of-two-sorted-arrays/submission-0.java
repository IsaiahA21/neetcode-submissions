/**
merge the 2 arrays and get the mid index.
if it odd, the mid is the answer
if its even, avg the floor and the ceiling 
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];

        // merge the 2 sorted arrays
        int nums1Index =0;
        int nums2Index =0;
        int i =0;

        while (nums1Index < nums1.length && nums2Index < nums2.length){
            if (nums1[nums1Index] < nums2[nums2Index]){
                nums[i] = nums1[nums1Index];
                nums1Index++;
            }
            else{
                nums[i] = nums2[nums2Index];
                nums2Index++;
            }
            i++;
        }

        // copy the left over of the one array that hasnt finished
        if (nums1Index != nums1.length){
            // nums1 didnt finish
            System.arraycopy(nums1, nums1Index, nums, i, nums1.length-nums1Index);
        }
        else{
            // nums2 didnt finish
            System.arraycopy(nums2, nums2Index, nums, i, nums2.length-nums2Index);
        }

        // System.out.println(nums);
        System.out.println(Arrays.toString(nums));
        int mid = nums.length / 2;

        if (nums.length %2 == 0){
            // even, there avg the middle

            return (nums[mid] + nums[mid-1]) / 2.0;
        }

        return nums[mid];
    }
}
