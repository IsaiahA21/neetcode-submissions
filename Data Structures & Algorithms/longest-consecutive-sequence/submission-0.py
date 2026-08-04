# [2,20,4,10,3,4,5]
# [2,20,4,10,4,5] --> ans =2 ([4,5])

# initial idea:
# store each element in a map
# set {2,20,10,4,5,3}
# iterate over the set, calcaute what the next con... seq would be.
# keep track of current longest seq, and max seq

class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        maxseq = 0
        numsSet = set(nums)

        for ele in numsSet:
            currentLongest = 1

            while True:
                conEle = ele + 1
                if conEle not in numsSet:
                    maxseq = max(maxseq, currentLongest)
                    break
                # else
                currentLongest += 1
                ele = conEle
            

        return maxseq