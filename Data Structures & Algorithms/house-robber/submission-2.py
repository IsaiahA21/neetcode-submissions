# Greedy question. at each point we can either run that house or the house to its right
# we want to rob the house that gives us the highest sum so far.

# top down.- we go down both path and see which led to the highest amount.
# @ i, max(ele+rob(i+2), rob(i+1))
# when we get to i+2(for ex), say questiom: we can rob it to the house to its right. if we rob it we do +2
# base case
# if(i >= n) return 0 ( no more houses)
class Solution:
    def rob(self, nums: List[int]) -> int:
        
    #     return self.robbing(0,nums, {})
    
    # def robbing(self, i, nums, memo):
        
    #     if i > len(nums)-1:
    #         return 0
        
    #     if i in memo:
    #         return memo[i]
        
    #     memo[i] = max(nums[i] + self.robbing(i+2,nums,memo), self.robbing(i+1,nums,memo)) # rob this house of the adjecent
        
    #     return memo[i]

        # Bottom top instead. no recusrion just using array.
        # we go through the houses and calcuate what the max money at index between our choices(choices are: robbing that house + money from robbing(i-2) or money from (i-1))
        # so we know our base case is rubbing i =0 or i=1
        # money = [2, 9, 10, 11,12,16]
        # so the max we can rob is the answer at n-1
        
        n = len(nums)
        if n < 2:
            return nums[0]
        
        max_money = [0] * n
        
        max_money[0] = nums[0]
        max_money[1] = max(nums[0], nums[1])

        for i in range(2,n,1):
            max_money[i] = max(nums[i] + max_money[i-2], max_money[i-1])
        
        return max_money[n-1]