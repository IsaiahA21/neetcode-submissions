class Solution {
    Map<Character, String> map = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno",
        '7', "pqrs", '8', "tuv", '9', "wxyz");

    List<String> res;
    String digits;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }

        this.digits = digits;

        combinations(new StringBuilder(), 0); // the combination, index in digit

        return res;
    }

    public void combinations(StringBuilder letter, int idx) {
        if (letter.length() == digits.length()) {
            res.add(new String(letter.toString()));
            return;
        }

        Character digit = digits.charAt(idx);
        String chars = map.get(digit);

        for (int j = 0; j < chars.length(); j++) {
            letter.append(chars.charAt(j)); // choose
            combinations(letter, idx + 1); // explore
            letter.deleteCharAt(letter.length() - 1); // Undo
        }
    }
}