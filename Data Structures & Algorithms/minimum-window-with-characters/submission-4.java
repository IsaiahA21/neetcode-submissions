// 2 ptrs. dynamic
// when we see an ele in string t, we start sliding window
// we then check if we can find all the eles of str

// OUZODYAXZV
// OYUZODAXZV

/**
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
*/
class Solution {
    public String minWindow(String s, String t) {
        int k = t.length();
        Map<Character, Integer> t_counter = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (int i =0; i < k; i++){
            t_counter.put(t.charAt(i), t_counter.getOrDefault(t.charAt(i), 0) + 1);
        }

        int need = t_counter.size(); // need is the number of unique characters whose required frequency has been satisfied (i.e. AABBC = 3)
        int have = 0; // the amount of unique char we have satified
        int[] resPtrs = {0,0}; // left and rptr of the result substring
        int resLen = Integer.MAX_VALUE;


        // sliding window: go over the array, check if we have all the elements we need to meet the condition to have string t
        int lptr = 0;
        for (int rptr = 0; rptr < s.length(); rptr++){
            char ch = s.charAt(rptr);
            
            if (t_counter.containsKey(ch)){// the char is something that is in string t
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                
                if (window.get(ch).intValue() == t_counter.get(ch).intValue() ){
                    // if we have the exact amount we need for this char
                    have++;// have meeting we met this expectation
                }
            }

            // check if we have all the things we need
            while (need == have){
                // System.out.println("We have all the chars we need " + window.toString());
                // System.out.println("Need is " + need + ". And we have "+ have);
                int len = rptr - lptr + 1;
                // resLen = Math.min(resLen, len);
                if (len < resLen){
                    resPtrs[0] = lptr;
                    resPtrs[1] = rptr;
                    resLen = len;
                }

                // remove the lptr and check if we are still valid
                char ch_lptr = s.charAt(lptr);
                // System.out.println("lptr is " + lptr + ". char lptr is "+ lptr + "char rptr is " + rptr );
    
                if (window.containsKey(ch_lptr)){
                    window.put(ch_lptr, window.get(ch_lptr) - 1);
                }
                // System.out.println("value of ch " + ch_lptr + ", is " + window.get(ch_lptr));


                if (t_counter.containsKey(ch_lptr) && window.get(ch_lptr).intValue() < t_counter.get(ch_lptr).intValue() ){
                    // if we dont have the exact amount we need for this char anymore
                    have--;// we no longer meet the expectation
                }
                lptr++;
            }

        }
        
        if (resLen == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(resPtrs[0], resPtrs[1]+1);
    }
}
