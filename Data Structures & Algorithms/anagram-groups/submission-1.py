class Solution:
    # def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
    #     anagrams_map = dict()

    #     for ele in strs:
    #         ele_sorted = "".join(sorted(ele))

    #         anagrams_map.setdefault(ele_sorted,[]).append(ele)
        
    #     return list(anagrams_map.values())


# {
#     [1,0,...1,..,0] -> ["act", "cat"],

# }
# why this way?
# Memory.
# tuple that represents a sorted string uses less memory than a string key.

    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams_map = dict()

        for ele in strs:
            char_frequency = [0] * 26 

            for ch in ele:
                char_frequency[ord(ch) - ord("a")] +=1
            
            ele_tuple_key= tuple(char_frequency)
            anagrams_map.setdefault(ele_tuple_key,[]).append(ele)
        
        return list(anagrams_map.values())