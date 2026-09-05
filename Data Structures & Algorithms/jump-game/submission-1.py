# My way of approaching it. I started at n-2 and I asked can I reach the end from that spot
# if yes, record true.
# if no, record no. 
# this means that if any other of the solution lands here we do the answer

# nums = [1,2,0,1,0]
# res(size n-1) = [T,T,F,T]
# at i =1, we know we reach end cause we jump to i=3 and we know theres a solution, we can also jump to i=2, we can no soluton
# so we compute the possiblity at each point.
# at i=0, we can reach the end cause at i, cause at i=1 we can reach the end.

# DP top down approach - recursion
# base case: if i > n-1 (we jump too far). if we land at n -1 return true
# recursion(perfom all possible jumps 1 to k): memo[i] = for j in range(1, ele): jump(i + j) 


#[1,2,0,1,0]
# i =0
# -> i = 1
#    -> i=2 or i=3
#       (i=2) return false (why? no jump and we are not at the end) store this solution
#       (i=3)
#       -> i=4 return true (why? because we at the end. i=n-1) store this
# -> i=1 therefore answer is true because its recursion calls one of them returns true
# i=0 return true
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        # # bottom up search
        # n = len(nums)
        # res = (n) * [False]
        # res[n-1] = True

        # for i in range(n-2,-1, -1):
        #     # we see if any of the possible jump leds to the end or a index where we can reach the end from
        #     jumps = nums[i]
            
        #     if jumps == 0: #from here we can jump. we stuck
        #         res[i] = False

        #     # from i we jump to any of the possinle is there a solution. we just need 1 of them to say yes then we know for i there a way.
        #     for jump in range (1,jumps+1):
        #         new_spot = i + jump
        #         if res[new_spot] == True:
        #             res[i] = True
        #             break
        
        # return res[0]

        # top down recurision with memo cause if we know theres no solution from an index no point in checking again    
        
        return self.jumping(0,nums,{})
        
    def jumping(self, spot, nums: List[int], memo) -> bool:
        jumps = nums[spot]
        
        # base cases
        if spot == len(nums)-1:
            return True # we can jump to the end
        
        if spot >= len(nums):
            return False # jumped too far
        
        if jumps == 0: # we cant jump
            return False



# [5, 0,0,0]
        # Check the memo FIRST before doing any work
        if spot in memo:
            return memo[spot]

        for jump in range(1,jumps+1):


            memo[spot] = self.jumping(spot+jump,nums, memo)
            if memo[spot] == True: # we know a jump was successful to the very end. we only need the first true. we make it return right away.
                return memo[spot]

            # else we check if another jump works
        memo[spot] =False
        return memo[spot] # we tried all the jumps and nothing reaches the end
