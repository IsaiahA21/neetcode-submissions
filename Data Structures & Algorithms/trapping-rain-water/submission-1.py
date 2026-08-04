# What the total amount of water cna be trapped

# This problem is asking for total water, not max area. That's the confusion.
# Container with most water → find the single largest area between two walls
# Trapping rain water → find the total volume of water across every bar(width always 1)

# water at i = min(maxLeft, maxRight) - height[i]
# total = sum of water at every i

# max left and right so far as we iterate and update when you see a new max
# lptr moves right, we check the maxLeft seen so far.
# rptr moves left, we check the maxRight seen so far on the right side.

#Two ptrs plus MaxLeft and maxRight variables
# rmbr the max amount of what that be trapped is set by the min left or right because water will fall off

class Solution:
    def trap(self, height: List[int]) -> int:
        length = len(height)
        
        
        maxLeft = height[0] #set to boundary 
        maxRight = height[length -1]
        
        res=0
        lptr, rptr = 1, length - 2
        while lptr <= rptr:
            if maxLeft <= maxRight: # the left is the boundary of how much water can be trapped at i(i=lptr). because no matter how tall the height on the right, the rest of the water will fall off
                if maxLeft > height[lptr]: # then we know water can be trapped here
                    res += (maxLeft - height[lptr])
                
                maxLeft=max(height[lptr],maxLeft)
                lptr+=1
            
            # else maxRight > maxLeft -> meaning the right is the boundary of how much water can be trapped at i(i=rptr).
            else:
                if maxRight > height[rptr]:
                    res += (maxRight - height[rptr])
                
                maxRight=max(height[rptr],maxRight)
                rptr-=1

        return res