# Greedy question. at each point we can either run that house or the house to its right
# we want to rob the house that gives us the highest sum so far.

# top down.- we go down both path and see which led to the highest amount.
# @ i, max(ele+rob(i+2), rob(i+1))
# when we get to i+2(for ex), say questiom: we can rob it to the house to its right. if we rob it we do +2
# base case
# if(i >= n) return 0 ( no more houses)
class Solution:
    def rob(self, nums: List[int]) -> int:
        
        return self.robbing(0,nums, {})
    
    def robbing(self, i, nums, memo):
        
        if i > len(nums)-1:
            return 0
        
        if i in memo:
            return memo[i]
        
        memo[i] = max(nums[i] + self.robbing(i+2,nums,memo), self.robbing(i+1,nums,memo)) # rob this house of the adjecent
        
        return memo[i]