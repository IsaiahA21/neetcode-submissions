class Solution {


    public int characterReplacement(String s, int k) {
        int[] counter = new int[26]; //index = A-(i);
        int lptr = 0;
        int longestSubStr=0;
        int mostFreq =0;
        int windowLength = 0;
        
        for (int rptr =0; rptr < s.length(); rptr++){
            // System.out.println(s.charAt(rptr));
            counter[s.charAt(rptr) - 'A']++;
            // System.out.println(counter[s.charAt(rptr) - 'A']);

            // matain the max freq. It works without decrementing: The result is only updated if a new maximum frequency is found that allows for a larger valid window size.
            // If max_frequency stays the same or decreases, the overall result will not be improved, so the slightly imprecise (but safe) value is sufficient to maintain correctnes
            mostFreq = Math.max(mostFreq,counter[s.charAt(rptr) - 'A'] ); // get the current max freq ele. the max freq
            windowLength = rptr - lptr + 1;

            //check window - remove element still window is valid
            // windowLength - mostFreq, is its not 0, then we no that there are other elements and therefore we need to replace them.
            while(windowLength - mostFreq > k){
              // slide window end forward
              counter[s.charAt(lptr) - 'A']--;
              lptr++;
              windowLength = rptr - lptr + 1;
            }

            longestSubStr = Math.max(longestSubStr, windowLength);
        }

        return longestSubStr;
    }

}
