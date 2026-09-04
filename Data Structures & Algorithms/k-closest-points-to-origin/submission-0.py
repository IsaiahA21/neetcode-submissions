class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        # the cloest k points are the smallest euc_dis.
        # we want max_heap cuz we want to get grid of the farther pointa NS ll kwwp the smallest
        heap = []

        for point in points:
            dis = -1 * (point[0] * point[0] + point[1] * point[1])
            heapq.heappush(heap,[dis,[point[0], point[1]]])
            if len(heap) > k:
                heapq.heappop(heap)
        res = [item[1] for item in heap]
        return res