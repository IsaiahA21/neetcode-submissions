# two ptrs: left and right
# when the sum of num[lptr] + num[rptr] > target, then I need to decremnet rptr
# when the sum of num[lptr] + num[rptr] < target, then I need to incremnet lptr
# loop condition: while left < right. not <= because were told that index1 < index2 and index1 < index2 cant be equal

class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        lptr, rptr = 0, len(numbers)-1

        while lptr < rptr:
            rolling_sum = numbers[lptr] + numbers[rptr]
            print(rolling_sum, lptr, rptr)

            if  rolling_sum == target:
                return [lptr+1,rptr+1]

            if rolling_sum > target:
                rptr-=1
            
            if rolling_sum < target:
                lptr+=1
        
        return []
