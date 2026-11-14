/**
<u>First, try to answer:</u>

- What am I building?
- What choices can I make at each step?
- What makes a choice invalid?
- What information do I need to track?
- When have I completed a valid result?
- (optional) Then draw the indented recursion tree by hand

- combincation of all possible letter combos

- I can choose 1 of 3 char per digit

- it includes a char from each digit

- each combontion

-- edge case: some digit have 4 combinations
*
*/
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
        // when we've added a char for each digit
        if (letter.length() == digits.length()) {
            res.add(new String(letter.toString()));
        }
        for (int i = idx; i < digits.length(); i++) {
            Character digit = digits.charAt(i);
            String chars = map.get(digit);

            for (int j = 0; j < chars.length(); j++) {
                letter.append(chars.charAt(j)); // choose
                combinations(letter, i + 1); // explore
                letter.deleteCharAt(letter.length() - 1); // Undo
            }
        }
    }
}

/* the reason for ["dg","dh","di","eh","ei","fi"]
on the second pass
i = 0,
j =1

"e"
on the second digit we have =1-> 'h' ==> "eh"

j should always start at j =0
*/
