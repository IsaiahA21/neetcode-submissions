class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dic = dict() # {required second pair -> index of first_pair}

        for i in range(len(nums)):
            if nums[i] in dic:
                return [dic.get(nums[i]), i]

            req_secod_pair = target - nums[i]
            dic[req_secod_pair] = i

        return []