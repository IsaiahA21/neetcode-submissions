# {X: 2}
# {Y: 2}
# n =2
# a prority queue(help) help deicde what to do next. we want the max heap becuase we want to choose the most freq task next cause it has to be spaced out.


# can cause we are perforimg task one by one in a order, we needto queue them up and their time.
# We start with a heap, and an empty queue. we loop while the heap or queue are not empty
# increment time
# then pop the max-heap, subtract its count, and calcuate the next time that is can run then place it in the queue.
# we check the queue for which task can possibly run at that current time.
# if we find any we place that into the heap so it can be considered.

# {X: 2}
# {Y: 2}
# n =2

#---
# {X: 1}
# {Y: 2}
# n =2
# time =1
#queue => [[1,X,3]]
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        countFreq = Counter(tasks)
        # print(countFreq)

        heap = [[-freq, ele] for ele, freq in countFreq.items()]
        heapq.heapify(heap)

        queue = deque() # use append and popleft for queue

        time =0
        while heap or queue:
            time +=1
            
            if heap:
                freq, ele = heapq.heappop(heap)
                freq +=1 # because freq is stored as negative number
                
                if freq != 0:# add to queue
                    wake_up = time + n
                    queue.append([freq, ele, wake_up])
            

            # check the queue for things that can be added back to the heap
            if queue and queue[0][2] == time:
                freq, ele, _ = queue.popleft()
                heapq.heappush(heap,[freq,ele])
                


        return time
        
        