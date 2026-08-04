# nums[i] + nums[j] + nums[k] == 0
# First we sort: [-4,-1,-1,0,1,2]
# next, we have a outer for loop on int i
## nums[j] + nums[k] == -nums[i]
## we need two nums that sum to equal -num[i](target)
# now its we can do a 2 ptr solution: nums[lptr] + nums[lptr] == target.
# innerloop is 2ptr
## lptr = i+1, rptr = end
## if nums[lptr] + nums[lptr] > target, rptr--, while lptr < rptr, else break
## if nums[lptr] + nums[lptr] < target, lptr++, while lptr < rptr, else break
## if nums[lptr] + nums[lptr] == target, store in list of list.
## what about duplicates? we get duplicate result if we dont skip duplicate nums[i's]

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result : list[list[int]] = []

        nums.sort()
        length = len(nums)

        for i in range(length):
            if i > 0 and nums[i] == nums[i-1]:
                continue; #skip duplicate nums[i's] to avoid duplicate results
            target = -1 * nums[i]
            lptr = i+1
            rptr = length-1

            # now classic 2ptr
            while lptr < rptr:
                if nums[lptr] + nums[rptr] == target:
                    result.append([nums[i],nums[lptr],nums[rptr]])
                    lptr+=1
                    rptr-=1

                    # to avoid duplicate solutions we need to slide lptr and rptr while they are same values
                    while lptr < rptr and nums[lptr] == nums[lptr - 1]:
                        lptr+=1
                    while lptr < rptr and nums[rptr] == nums[rptr + 1]:
                        rptr-=1

                elif nums[lptr] + nums[rptr] > target:
                    rptr-=1
                elif nums[lptr] + nums[rptr] < target:
                    lptr+=1

        return result
