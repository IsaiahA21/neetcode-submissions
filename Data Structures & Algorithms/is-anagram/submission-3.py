class Solution:
    # def isAnagram(self, s: str, t: str) -> bool:
    #     if len(s) != len(t):
    #         return False
        
    #     s_dict = dict()
    #     t_dict = dict()

    #     s_dict = self._addToMap(s_dict, s)
    #     t_dict = self._addToMap(t_dict, t)

    #     return s_dict == t_dict

    

    # def _addToMap(self,word_map: dict, word: str):
    #     char_word = list(word)
    #     for ele in char_word:
    #         word_map[ele] = word_map.get(ele,0)+1

    #     return word_map

    # def isAnagram(self, s: str, t: str) -> bool:
    #     if len(s) != len(t):
    #         return False
        
    #     return sorted(s) == sorted(t)

    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        
        frequency = [0] * 26

        for i in range(len(s)):
            s_char = s[i] # b. b-a -> 98 - 97
            t_char = t[i]

            frequency[ord(s_char) - ord("a")] +=1 # for string s, increment the freq array
            frequency[ord(t_char) - ord("a")] -=1 # for string t, decrement the freq array

        for i in range(26):
            print(frequency[i])
            if frequency[i] != 0:
                return False
        
        return True
