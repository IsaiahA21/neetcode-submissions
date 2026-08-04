#["Hello","World"]
#"He lloWorld"

#my encode/decode algo is including the length of the string first
# 5#Hello10#Reallylong


class Solution:

    # encode with the word length plced in front
    def encode(self, strs: List[str]) -> str:
        if not strs:
            return ""
        res =[]
        for word in strs:
            length = str(len(word))
            res.append(length)
            res.append('#')
            res.append(word)

        print("".join(res))
        return "".join(res)

    # look for the word length as the first char, 
    # then the chars after it belongs to one string
    def decode(self, s: str) -> List[str]:
        if not s:
            return []
        res = []
        index = 0

        while index < len(s):
            
            #exrtract the length of that word
            char = s[index]
            
            j = index
            while(s[j] != '#'):
                j+=1
            
            lenword = int(s[index:j])

            startpoint=j+1 # character right after '#'
            endpoint=startpoint+lenword
            res.append(s[startpoint:endpoint])

            index= endpoint
        return res
