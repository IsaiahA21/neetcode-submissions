class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> occurenceMap = new HashSet<>(); // key: index

        int lptr = 0;
        int rptr = 0;
        int res = 0;

        while (rptr < s.length()){
            char ch = s.charAt(rptr);
            
            if (occurenceMap.contains(ch)){
                
                // move until we remove that element we've seen
                while (occurenceMap.contains(ch)){
                    occurenceMap.remove(s.charAt(lptr));
                    lptr++;
                }
                // System.out.println("lptr moved to "+ lptr);
            }

            occurenceMap.add(ch);
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
