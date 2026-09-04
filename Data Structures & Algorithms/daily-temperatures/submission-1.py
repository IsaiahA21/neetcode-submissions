# Stack
# the idea is to have a montonic stack(a montonic decreasing stack).
# we add  0th (ele, ith) to the stack

# we iterate and for each item in the stack we check if ith > top_ith?
# if yes we pop. and for the elemenet we pop, in our result array we calculate the days it took to find a temperature warmer. -> res[popped_ith] = ith - popped_ith
# we add ith to the stack
# we no, we add (ele, ith) to the stack
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = deque() # for stack right is top. dequeue append() and to the right. stack is LIFO. [ele, index]
        res = [0] * len(temperatures)
        # print (res)
        for i in range(len(temperatures)):
            while stack and temperatures[i]  > stack[-1][0]: # i know to pop
                ele, index = stack.pop()
                res[index] = i - index
            
            stack.append([temperatures[i], i])
        return res