# [1,2,3,4,5,6] or [3,4,5,6,1,2] or [4,5,0,1,2,3]
# they wants O(log n)
# binary search works on montonic. meaning after a certain point its forever increasing or decreasing
# we need to detect the rotation and split in half and only search half for the min element
# if no rotation is detetected min = n[0]

# we detect rotation
# l, r =0,n-1
# while l <=r
# if ele@l > ele@r then we a rotation, therefore we need to look on the small side, the right side. mid +1 to right


class Solution:
    def findMin(self, nums: List[int]) -> int:
        lptr, rptr =0, len(nums)-1

        while lptr <= rptr:
            if nums[lptr] <= nums[rptr]: # we have continous increasing (the equal sign is for when lptr == rptr)
                return nums[lptr]
            
            # ele@l > ele@r, then we have a rotation, use the middle to determine where the rotated placed the smallest element
            mid = (lptr + rptr ) //2
            if( nums[mid] > nums[rptr]):  # the smalleest is somewhere on the right
                lptr = mid +1
            
            else: # else the smallest could be the middle or on the left
                rptr = mid
            
