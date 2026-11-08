/**
what tells us for that using a Map is not possible is: "word may contain dots '.' where dots can be
matched with any letter." We need to use a trie

One dot to 1 char '.' - it can be anything.
I think when we see a dot it means true. meaning we explore all [a-z] possiblities. as long as its
not null at most 2 dots - which is a constraint we can expect.

*/

class TrieNode {
    TrieNode[] arr = new TrieNode[26];
    boolean endOfWord = false;
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for (Character ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.arr[idx] == null) {
                curr.arr[idx] = new TrieNode();
            }
            curr = curr.arr[idx];
        }
        curr.endOfWord = true;
    }

    /**
    the word can contain '.' at any postion. if we see a dot, we check if all spots that are not
    null.

    and when we get to the last char, same thing as before, we return evenOfWord bool.

    Hmmm, acc what if last char is '.', and in the possible words one of them is not evenOfWord
    bool? word = "ba." | "banhim" , "bap".

        I think we keep searching. when we iterate we see "banhim" first. but 'n' is not a
    evenOfWord = true. But we know "bap" the last char, the 3 char is evenOfWord. return true;

        and if "bap" wasnt there and we see "banhim", we return false cause 'n' evenOfWord is false;

    */

    // Im so tempted to try recursion
    public boolean search(String word) {
        return dfsSearch(root, word, 0);
    }

    // when we have a '.' we use this to see if anything gives us a true.
    // so if the orignal word was ".ay", subWord is "ay" from curr Node and we look till we find
    // endOfWord = true.
    public boolean dfsSearch(TrieNode root, String word, int index) {
        TrieNode curr = root;

        for (int i = index; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch == '.') {
                // we have to search all the places and see if we find an answer.
                for (TrieNode child : curr.arr) {
                    // we pass i+1 as the index of the next character we are looking for
                    while (child != null && dfsSearch(child, word, i + 1)) {
                        // we find 1 path that matches -> one path where endOfWord = true
                        // we stop
                        return true;
                    }
                }
                return false; // if we never find a path we return false.
                // mean either no match exist or what exist the last char is not a endOfWord
            } else {
                int idx = ch - 'a';
                if (curr.arr[idx] == null) {
                    return false;
                }
                curr = curr.arr[idx];
            }
        }

        return curr.endOfWord;
    }
}
