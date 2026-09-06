# the issue with this is 0's. when there are more than 1 zeros how do we get the products 0s?

# assumuing no zeros
# iteract once and get the prodcut. then for each i, divide

#nums = [1,2_,4,6]
#pre  = [1,1,2,8] -> formula: curr_prod =1. then pre[i] = pre[i-1] *nums[i-1]
#suf  = [48,24,6,1] -> formula: go right to left. curr_prod =1. suff[i] = suff[i+1] * nums[i+1]
#res = [48,24,12,8] -> res[i] = pre[i] * suff[i]
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        prefix = n * [0]
        suffix = n * [0]
        res = n * [0]

        # fill the prefix array
        curr_prefix = 1
        for i in range(n):
            prefix[i] = curr_prefix
            curr_prefix *= nums[i] # compute the next ith value

        # fill the suffix array
        curr_suffix = 1
        for i in range(n-1, -1, -1):
            suffix[i] = curr_suffix
            curr_suffix *= nums[i] # compute the next ith value
        
        for i in range(n):
            res[i] = prefix[i] * suffix[i]

        return res 