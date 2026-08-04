class Solution:
    # def twoSum(self, nums: List[int], target: int) -> List[int]:
    #     dic = dict() # {required second pair -> index of first_pair}

    #     for i in range(len(nums)):
    #         if nums[i] in dic:
    #             return [dic.get(nums[i]), i]

    #         req_secod_pair = target - nums[i]
    #         dic[req_secod_pair] = i

    #     return []

    # two pointer sliding windows
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nums_with_og_index = [(ele, i) for i,ele in enumerate(nums)] # [(value, original_index), ..]
        nums_with_og_index.sort() # ensure its sorted
        
        lptr, rptr = 0, len(nums) -1

        while(lptr < rptr):
            two_sum = nums_with_og_index[lptr][0] + nums_with_og_index[rptr][0]
            print('lptr is ', lptr)
            print('rptr is ', rptr)
            print('two sum is ', two_sum)

            if two_sum == target:
                return [
                    min(nums_with_og_index[lptr][1], nums_with_og_index[rptr][1]),
                    max(nums_with_og_index[lptr][1], nums_with_og_index[rptr][1])
                    ]
            
            elif two_sum < target:
                lptr+=1
            
            else: # two_sum > target
                rptr-=1

        return []