class Solution {
    // encode it using the length of th str
    // #{word.length}{word}#{word2.length}{word2}
    // #12{word}
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();

        for (String str : strs) {
            res.append('#');
            res.append(Integer.toString(str.length()));
            res.append('#');

            res.append(str);
        }

        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) != '#') {
                i++;
            }

            // check if theres a '#' followed by num
            int start_idx = i + 1;
            int end_idx = start_idx;
            while (end_idx < str.length() && str.charAt(end_idx) != '#') {
                end_idx++;
            }

            int wrd_len = Integer.parseInt(str.substring(start_idx, end_idx));

            end_idx++; // move after "#"

            res.add(str.substring(end_idx, end_idx + wrd_len));
            i = end_idx + wrd_len; // move to the end of the word
        }
        return res;
    }
}
