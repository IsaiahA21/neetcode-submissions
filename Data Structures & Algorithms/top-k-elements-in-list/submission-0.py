class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        #freq: List[int, int] = [] # [{freq, value}, {freq, val}]
        freq = defaultdict(int) #val -> frequency

        for ele in nums:
            freq[ele] +=1 

        # next we sort the map based freq.
        # the value in the list will be the element not the frequency
        sorted_by_freq : [] = sorted(freq, key=freq.get, reverse=True)

        # since its sorted desc, ele with the highest freq will be first
        return sorted_by_freq[0:k]         


            

