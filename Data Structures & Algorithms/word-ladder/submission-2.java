/**Implict Graph */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        int wordLen = beginWord.length();
        Set<String> words = new HashSet<>(wordList); // set of the words that we can move to
        Deque<String> que = new ArrayDeque<>();
        int res = 0;
        
        words.remove(beginWord);
        que.addLast(beginWord); // incase the begin word is in the list of words

        while (!que.isEmpty()){
            int size = que.size();
            res++;

            //level by level traversal
            for (int i =0;  i < size; i++){
                String word = que.pollFirst();

                if (endWord.equals(word)){
                    return res;
                }
                // for each position in the word, generate all a to z char
                char[] wordChar = word.toCharArray();

                for (int x = 0; x < wordLen; x++){
                    char orignalChar = wordChar[x];

                    for (char ch = 'a'; ch <= 'z'; ch++){
                        if (ch == orignalChar){
                            continue;
                        }
                        wordChar[x] = ch;
                        String nextWord = new String(wordChar);

                        if (words.contains(nextWord)){
                            words.remove(nextWord);
                            que.addLast(nextWord);
                        }
                    }

                    wordChar[x] = orignalChar; //restore the orignal char
                }
            }
        }
        return 0;
    }
}
