// "BAABABB" k =2
// "BAAB". at this substring out of replacement
// "BAABA". B:2, A:3
// "BAABAB". B:3, A:3. no more replacemtn therefore slide. I think lptr++ until our window is valid again


// I need a map or set of the elements ive seen. -> I'll use that when deciding which ele to replace
// "replace" the lease frequent element. meaning if count of not majority char >= k, out of replacements. therefore slide(to where tho)
// 

// Windowlength - mostFreq <= k -> valid

class Solution {
    int[] counter = new int[26]; //index = A-charAt(i);

    public int characterReplacement(String s, int k) {

        int lptr = 0;
        int longestSubStr=0;
        int mostFreq = 0;
        int windowLength =0;
        
        for (int rptr =0; rptr < s.length(); rptr++){
            // System.out.println(s.charAt(rptr));
            counter[s.charAt(rptr) - 'A']++;
            // System.out.println(counter[s.charAt(rptr) - 'A']);

            mostFreq = mostFreq(); // get the current max freq ele
            windowLength = rptr - lptr + 1;

            //check window - remove element still window is valid
            // windowLength - mostFreq, is its not 0, then we no that there are other elements and therefore we need to replace them.
            if(windowLength - mostFreq > k){
              // slide window end forward
              counter[s.charAt(lptr) - 'A']--;
              lptr++;
              windowLength = rptr - lptr + 1;
              mostFreq = mostFreq();
            }

            longestSubStr = Math.max(longestSubStr, windowLength);
        }

        return longestSubStr;
    }

    public int mostFreq(){
        int res =0;
        for (int count : counter){
            res = Math.max(res, count);
        }
        return res;
    }
}
