class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
    #     # process: 
    #     #   get the product of all the elements in the array
    #     #   then divide nums[i] out of it and store the result at output[i]
    #     #   edge case: is if there is any 0 in the list, take the product without it.
    #     #   then the product at any nums[i] =/= 0 will be 0
    #     #   edage case 2: all eles are 0, then return the list

    #     if all( x == 0 for x in nums):
    #         return nums

    #     # product = math.prod(ele for ele in nums if ele != 0)
        
    #     product = 1
    #     zeroflag: bool = False

    #     for ele in nums:
    #         if ele == 0:
    #             zeroflag = True
    #             continue
    #         product *= ele
        
    #     for index, ele in enumerate(nums):
    #         if zeroflag and ele !=0:
    #             nums[index] = 0
    #             continue
            
    #         #else the zero flag is false and (ele is zero or not zero)
    #         if ele == 0:
    #              nums[index] = product
    #              continue
            
    #         nums[index] = product // ele
        
    #     return nums

        #[1,2,4,5,6]
        # left and right slidng window. we add(index-1) to the left sliding window, remove(index) from the right and then multiple the 2 windows.
        # at the start our answer is just the right sliding window (or leftwin =1 * rightwin).
        # at the last index, anser is just the left sliding window

        if all( x == 0 for x in nums):
            return nums

        length =  len(nums)

        output: [int] = [0 for _ in nums]
        output[0] = math.prod(nums[1:]) #base case of the first index
        output[-1] = math.prod(nums[0:length-1]) #base case of the last index

        leftWindowProd =1
        rightWindowProd = output[0] 
        for i in range ( 1, length -1):
            leftWindowProd *= nums[i-1] # add the left element to the left window sliding product 
            
            if nums[i] == 0:
                rightWindowProd = math.prod(nums[i+1:]) # recompute the prod, cause the previous prod would be 0
            else:
                rightWindowProd //= nums[i]  # remove index from the right window product
               
            
            output[i] = leftWindowProd * rightWindowProd
        return output



