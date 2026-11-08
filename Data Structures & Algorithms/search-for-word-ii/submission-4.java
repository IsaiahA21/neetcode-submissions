/**
First idea that popped into my head: for each word go through the board and find the first char.
- from there get neighbors and see if its the next char in the word.
- if no, we restart untill we find something or we iterate every cell in the grid
- time O(n^2) * O(wordLength)
*/

/**
Second idea - use Trie.
first build the prefix Tree that maps the entire board.
Every cell is a possible start. and it maps to every other cell eventually.

if we encounter a char we already have, thats okay, we branch just keep building.

If I do it this way I storing each element at each cell O(n^2) times.

*I think its better if we start using the coordinates aswell - but how.


Input:
board = [
  ["x","o"],
  ["x","o"]
],
words = ["xoxo"]

Output: []

*
*/

/**
kinda like caching.
we look for chars in a word
if its not in the Trie, we find the index in the board.

*/

class TrieNode {
    TrieNode[] arr = new TrieNode[26];
    boolean isEnd = false;
}
class Solution {
    TrieNode root = new TrieNode();
    int row_length = 0;
    int col_length = 0;
    Set<String> res;

    public List<String> findWords(char[][] board, String[] words) {
        row_length = board.length;
        col_length = board[0].length;

        // build Trie with words
        for (String word : words) {
            buildTrie(word, root);
        }

        res = new HashSet<>();

        // to find ones we iterate over board
        for (int r = 0; r < row_length; r++) {
            for (int c = 0; c < col_length; c++) {
                StringBuilder sb = new StringBuilder();
                // we check if can build the words from this char on the board.
                dfs(root, board, r, c, sb);
            }
        }

        return new ArrayList<>(res);
    }

    public void buildTrie(String word, TrieNode root) {
        TrieNode curr = root;

        for (Character ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.arr[idx] == null) {
                curr.arr[idx] = new TrieNode();
            }
            curr = curr.arr[idx];
        }
        curr.isEnd = true;
    }

    public void dfs(TrieNode root, char[][] board, int i, int j, StringBuilder wrd) {
        TrieNode curr = root;

        // backcases
        if (i < 0 || i >= row_length || j < 0 || j >= col_length) {
            return;
        }

        char board_ch = board[i][j];

        if (board_ch == '#' || curr.arr[board_ch - 'a'] == null) {
            // if that char is not in Trie or its already been visted return;
            return;
        }

        /* process this spot */

        // tempoary mark this cell has visted to prevent reuse and  infinte loop
        board[i][j] = '#';
        wrd.append(board_ch); // temp add to String

        curr = curr.arr[board_ch - 'a'];


        if (curr.isEnd == true) {
            res.add(wrd.toString()); // add to result list
                // curr.isEnd = false; // prevent the word from being found again
        }

        // start recursion
        dfs(curr, board, i, j + 1, wrd);
        dfs(curr, board, i, j - 1, wrd);
        dfs(curr, board, i + 1, j, wrd);
        dfs(curr, board, i - 1, j, wrd);

        // add char back
        board[i][j] = board_ch;
        wrd.deleteCharAt(wrd.length() - 1); // backtrack: undo both changes
    }
}
