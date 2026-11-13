/**
classic backtracking
CHoose, Explore, Undo

First, try to answer:
- What am I building? im looking for the next char in the word
- What choices can I make at each step? I can make 4 choices
- What makes a choice invalid? if the char != the word im looking for or if I already used it.
- What information do I need to track? boolean of if I found the word, else false.
- When have I completed a valid result? if there a path to all the chars in the word.

*/

class Solution {
    char[][] board;
    String word;
        int N = -1;
        int M = -1;
        int len = -1;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.N = board.length;
        this.M = board[0].length;
        this.len = word.length();

        // iterate till we find first char
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (board[r][c] == word.charAt(0) &&  dfs(r, c, 0)) {
                   return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int r, int c, int idx) {
        if (r < 0 || r >= N || c < 0 || c >= M) {
            return false;
        }

        if (idx >= len){
            return false;
        }

        if (board[r][c] != word.charAt(idx)) {
            return false;
        }

        // if we get here we found the char

        // we found the last char word 
        if (idx == len -1) {
            return true;
        }

        char ch = board[r][c];
        board[r][c] = '#'; // choose

        // explore
        ++idx;
        if (dfs(r + 1, c, idx) || dfs(r - 1, c, idx) || dfs(r, c + 1, idx) || dfs(r, c - 1, idx)){
            return true;
        }

        // else we dint find a solution, so undo using that char and try somewhere else
        board[r][c] = ch; // undo

        return false;
    }
}
