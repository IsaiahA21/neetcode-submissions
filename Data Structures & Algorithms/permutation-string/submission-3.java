class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();

        if (s2.length() < s1.length()) {
            return false;
        }

        char[] s1Chars = new char[26];
        char[] s2Chars = new char[26];

        for (int i = 0; i < k; i++) {
            Character ch1 = s1.charAt(i);
            s1Chars[ch1 - 'a']++;
            
            Character ch2 = s2.charAt(i);
            s2Chars[ch2 - 'a']++;
        }
        if (Arrays.equals(s1Chars,s2Chars)) {
            return true;
        }

        // iterate over s2
        for (int rptr = k; rptr < s2.length(); rptr++) {
            // remove the left value
            Character left_ch = s2.charAt(rptr - k);
            s2Chars[left_ch - 'a']--;

            // add the right value
            Character right_ch = s2.charAt(rptr);
            s2Chars[right_ch - 'a']++;

            if (Arrays.equals(s1Chars,s2Chars)) {
                return true;
            }
        }

        return false;
    }
}
