class Solution {
    List<String> res;
    int n;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        this.n = n;

        dfs(0, 0, new StringBuilder());

        return res;
    }

    public void dfs(int open, int close, StringBuilder str) {
        if (open == n && close == n) {
            res.add(str.toString());
            return;
        }

        if (open < n) {
            str.append("("); // choose
            dfs(open + 1, close, str); // explore
            str.deleteCharAt(str.length() - 1); // undo
        }

        if (close < open) { // we can only add a closing if there are open brackets

            str.append(")");
            dfs(open, ++close, str);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
