# What the total amount of water cna be trapped

# This problem is asking for total water, not max area. That's the confusion.
# Container with most water → find the single largest area between two walls
# Trapping rain water → find the total volume of water across every bar(width always 1)

# water at i = min(maxLeft, maxRight) - height[i]
# total = sum of water at every i

# max left and right so far as we iterate and update when you see a new max
# lptr moves right, we check the maxLeft seen so far.
# rptr moves left, we check the maxRight seen so far on the right side.

#Prefix & suffix arrays

class Solution:
    def trap(self, height: List[int]) -> int:
        length = len(height)

        maxLeft = [0] * length
        maxRight = [0] * length

        #populate Prefix array(left to right)
        for i in range(1, length):
            maxLeft[i] = max(height[i-1], maxLeft[i-1])
        
        #populate sufix array(right to left)
        for i in range(length - 2, -1, -1):
            maxRight[i] = max(height[i+1], maxRight[i+1])

        
        # next calcuate how much whater can be trapped at each point and add to a sum
        res=0
        for i in range(length):
            minHeight = min(maxLeft[i], maxRight[i])
            if(minHeight > height[i]): # then we know we can trap water at index i
                res += minHeight - height[i]
        
        return res



        