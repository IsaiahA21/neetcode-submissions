/**First, try to answer:

- What am I building? subtrings of palindrome
- What choices can I make at each step? to add a char
- What makes a choice invalid? when not a palindrome
- What information do I need to track?
- When have I completed a valid result? when we have a palindrome. each character is the same as the
last
- (optional) Then draw the indented recursion tree by hand

*/
class Solution {
    List<List<String>> res;
    String str;

    public List<List<String>> partition(String s) {
        str = s;
        res = new ArrayList<>();

        dfs(new ArrayList<>(), 0);

        return res;
    }

    public void dfs(List<String> path, int idx) {


        if (idx == str.length()){
            res.add(new ArrayList<>(path));
        }

        for (int i = idx; i < str.length(); i++) {
            // char ch = str.charAt(i);
            String subStr = str.substring(idx, i+1);// choose
            
            if (!isValid(subStr)) {
                continue;
            }
            path.add(subStr);

            dfs(path, i+1); // explore

            path.remove(path.size() - 1); //undo
        }
    }

    private boolean isValid(String subStr) {
        int l = 0;
        int r = subStr.length() - 1;
        
        while (l < r){
            if(subStr.charAt(l) != subStr.charAt(r))
                return false;

            l++;
            r--;
        }
        return true;
    }
}
