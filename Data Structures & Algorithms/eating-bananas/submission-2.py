# we have a piles[] of banana. we eat k bananas from a pile. we can a pile is less k then, we eat that file and cant eat from the other piles
# we want to eat all the bananas. 
# what the min about of banana to eat per hour?
#  piles = [1,4,3,2], h = 9
# total banasa =10
# k=1, can we eat all bananas? no cause we would excdeed 9hours? 1 hr to finish first pile. 4 to finish second
# k=2, 2 bananas per hr ...? 


# I know its Binary search. why?
# binary search works on sorted/montic arrays

# I think there are 2 parts, can we eat all bananas and the min banana to eat per hour

# we can eat any pile but we can only eat k from that pile in that hour. and if k is greater the about pile[i] we finish it but cant go to anither file

# if k is 4 we can if it in 4 hours
# if k is 2, takes us 6hrs. 1hr for pile 1, 2hr for pile 2, 2 for pile 3, 1 for pile 4

# it an array so can sorrting and bST help?
# [1,2,3,4] h=9. n =4. p = 10/4 =>2

class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        # brute force. we have h hours to eat the pile.we can try k =1 to k=max of pile. , because Koko can only eat from one pile per hour anyway.
        # currtime += math.ceiling(pile[i]/k)
        # currtime > h, gtry next.
        # timeout on O(N) if max(pile[i]) is high. 10^9.
        # O(max(pile)) * O(N)

        # k =0
        
        # for k in range(1, max(piles)+1):
        #     curr_time =0
        #     for i in range(len(piles)):
        #         curr_time += math.ceil(piles[i]/k)
        #         if curr_time > h:
        #             # we cant eat all the piles at the speed
        #             # clear and try new k 
        #             break

        #     if curr_time <= h:
        #         # we we reach here: we were ale to eat the pile in h hours there return k
        #         return k

        
        # optimize: Binary Search on Answer
        # we know the answer is between k=1 to k=max(pile) -> k=[1,...,max(pile)]
        # the smallest value we get that allows us to eat all the bananas is the output
        l, r = 1, max(piles)
        res = r

        while l <= r:
            m = (l  + r)//2

            hours =0
            # check if we can eat all the bananas if we eat `m` in an hr
            for p in piles:
                hours += math.ceil(p/m)

            if hours > h: # curr m exceed limit - takes too long, need a bigger value
                l = m + 1
            else: # we can eat all the nbas in this time, is there a smaller about of time?
                res = min(m, res)
                r = m - 1

        return res




        