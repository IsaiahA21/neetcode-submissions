class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        
        s_dict = dict()
        t_dict = dict()

        s_dict = self._addToMap(s_dict, s)
        t_dict = self._addToMap(t_dict, t)

        return s_dict == t_dict

    

    def _addToMap(self,word_map: dict, word: str):
        char_word = list(word)
        for ele in char_word:
            word_map[ele] = word_map.get(ele,0)+1

        return word_map
