
// create edge list. for each word get the pattern by replacing 1 char each time with "*"
/**
{*at: [cat, bat]
 c*t: [cat]
 ba*: [dag, bag, sag]
}
*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /* build edge List
         build adj List
         bfs */

        if (!wordList.contains(endWord)) {
            return 0;
        }

        HashMap<String, List<String>> adjList = new HashMap<>(); // pattern-to-words map
        wordList.add(beginWord);

        int wordLen = beginWord.length();

        // for each word in the word, generae the variations by replacing 1 char each time and
        // checking if other words match.
        for (String word : wordList) {
            for (int j = 0; j < wordLen; j++) {
                String variation = word.substring(0, j) + "*" + word.substring(j + 1);
                // System.out.println(variation);
                adjList.computeIfAbsent(variation, k -> new ArrayList<>()).add(word);
            }
        }

        Set<String> visited = new HashSet<>();
        Deque<String> que = new ArrayDeque<>();

        visited.add(beginWord);
        que.addLast(beginWord);
        int res = 0; // the begining word

        while (!que.isEmpty()) {
            // level by level traversal to get shortest path
            int size = que.size();
            res++; // everything we enter a new level we increment

            for (int i = 0; i < size; i++) {
                String word = que.pollFirst();

                if (endWord.equals(word)) {
                    return res;
                }

                for (int j = 0; j < wordLen; j++){
                    // we look at the varoiatoon for this word and check if see if it has any neigbors that we can process
                     String variation = word.substring(0, j) + "*" + word.substring(j + 1);

                     for (String neighbor : adjList.get(variation)){
                        if (word.equals(neighbor)) {
                            continue;
                        }
                        if (!visited.contains(neighbor)){
                            visited.add(neighbor);
                            que.addLast(neighbor);
                        }
                     }
                }
            }
        }

        return 0;
    }
}
