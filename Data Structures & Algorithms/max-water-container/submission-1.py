# my approach: lpte=0, rptr=len(heights)
# calcua area: max(lptr,rptr) * rptr-lptr
# height[lptr] <= height[rptr], lptr , else rptr

class Solution:
    def maxArea(self, heights: List[int]) -> int:
        lptr,rptr = 0, len(heights) - 1
        max_area =0

        while lptr < rptr:
            height = min(heights[lptr],heights[rptr])
            width = rptr - lptr
            area = height * width
            max_area = max(area, max_area)
        
            if heights[lptr] <= heights[rptr]:
                lptr+=1
            else:
                rptr-=1

        return max_area