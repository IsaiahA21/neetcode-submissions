class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> occurenceMap = new HashMap<>(); // key: index

        int lptr = 0;
        int rptr = 0;
        int res = 0;

        while (rptr < s.length()){
            char ch = s.charAt(rptr);
            
            if (occurenceMap.containsKey(ch)){
                //move lptr to pass the prev occurence of the char was. take the max of the current spot of left or the position of the char 
                lptr = Math.max(occurenceMap.get(ch) + 1, lptr);
                // System.out.println("lptr moved to "+ lptr);
            }

            occurenceMap.put(ch, rptr);
            // compute the current size of the the window
            int currSize = (rptr - lptr) + 1;
            res = Math.max(res, currSize);
            // System.out.println("CurrSize is "+ currSize);
            // System.out.println("res is "+ res);

            rptr++;
        }

        return res;
    }
}
