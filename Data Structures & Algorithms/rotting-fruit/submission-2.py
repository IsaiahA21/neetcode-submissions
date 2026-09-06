class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])

        queue = deque()
        fresh = 0
        time = 0
        directions = [[1,0],[-1,0], [0,1], [0,-1]]

        for x in range(m):
            for y in range(n):
                if grid[x][y] == 1:
                    fresh +=1
                if grid[x][y] == 2:
                    queue.append((x,y))
        if fresh == 0:
            return 0
        
        while queue and fresh > 0:
            q_size = len(queue)
            
            for _ in range (q_size):
                x, y = queue.popleft()

                for r,c in directions:
                    x_new = x + r
                    y_new = y + c

                    if x_new < 0 or x_new >= m or y_new < 0 or y_new >= n:
                        continue

                    if grid[x_new][y_new] == 1:
                        grid[x_new][y_new] = 2
                        fresh -=1
                        queue.append((x_new,y_new))
            

            time +=1
        
        if fresh > 0:
            return -1
        return time

        
            