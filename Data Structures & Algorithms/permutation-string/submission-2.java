// to be a subtstr, s1 can exist in any contingious iteration in s2.
// s1 = "abc". perm -> "cab", bac, "cba"
// s2 = "lecabee"

// wait sliding window of. window size is s1.length.
// fix window sliding.
// remove and re-add char. then turn to a string, store and compare 
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();

        if (s2.length() < s1.length()){
            return false;
        }
        // char[] s1charArray = s1.toCharArray();
        // Arrays.sort(s1charArray);
        // String s1Sorted = new String (s1charArray);

        Map<Character,Integer> s1Counter = new HashMap<>();
        for (Character ch : s1.toCharArray()){
            s1Counter.put(ch, s1Counter.getOrDefault(ch,0) +1);
        }
        // System.out.println(s1Counter.toString());

        // first window
        // char[] window = s2.substring(k).toCharArray();
        Map<Character,Integer> s2Counter = new HashMap<>();
        for (int i =0; i < k; i++){
            Character ch = s2.charAt(i);
            s2Counter.put(ch, s2Counter.getOrDefault(ch,0) +1);
        }
        if (s1Counter.equals(s2Counter)){
            return true;
        }

        for (int rptr = k; rptr < s2.length(); rptr++){
            // remove the left value
            Character prev_ch = s2.charAt(rptr - k);
            int newValue = s2Counter.get(prev_ch) - 1;
            if (newValue <= 0){
                s2Counter.remove(prev_ch);
            }
            else {
                s2Counter.put(prev_ch, newValue);
            }

            // add the right value
            Character ch = s2.charAt(rptr);
            s2Counter.put(ch, s2Counter.getOrDefault(ch,0) +1);
            // System.out.println(s2Counter.toString());
            
            if (s1Counter.equals(s2Counter)){
                return true;
            }
        }

        return false;

    }
}
