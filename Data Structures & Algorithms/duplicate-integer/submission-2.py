class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        my_set = set()
        for i in range(len(nums)):
            if nums[i] in my_set:
                return True
            my_set.add(nums[i])
        
        return False

    # def hasDuplicate(self, nums: List[int]) -> bool:
    #     if (len(nums) <= 1):
    #         return False
        
    #     nums.sort()

    #     rptr = 0

    #     for lptr in range(len(nums)-1):
    #         rptr= rptr+1
    #         if(nums[lptr] == nums[rptr]):
    #             return True
    #     return False
