class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = [] # min heap. smallest is at the root. heap is a tree

        # top ->[4,5]. at the end we know that 5 is the largest and 4 is the second largest(which is the current top)

        for num in nums:
            heapq.heappush(heap,num)

            if len(heap) > k: # remove the smallest element which will be the top
                heapq.heappop(heap)
        
        return heap[0]



# top-> [4,5,5]