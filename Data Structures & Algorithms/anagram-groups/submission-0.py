#
# [1, 2]
# [[1,2], [2, 3]]
# [['sds', '233']]


# {
#     "act" -> ['act', 'cat']
#     "stop" -> ['']
#     "aht" -> ['hat']
# }
# ret:
# iterate over map, and add the values to a list of list
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams_map = dict()

        for ele in strs:
            ele_sorted = "".join(sorted(ele))

            anagrams_map.setdefault(ele_sorted,[]).append(ele)
        
        return list(anagrams_map.values())