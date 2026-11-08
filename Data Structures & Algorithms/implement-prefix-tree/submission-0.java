
/**
I was able to seee that when searching we need to look for isEnd
we dont have to do that for startsWith

Trie is like a hashmap, but if also us to look of "app", even though we have "apple" stored.
when storing have a end character - would this be its own node?
- the trie include only lowcase english words (1-26)
We aren't storing the character itself inside the Node. The position in the parent's array tells us
which character that Node represents.

create a node for each char ptrs. And at each char there is 1-26 arr options for the next char
- '-1' to signal a end of word

root, contains 1-26 arr. for the start of a word when searching.


*/
class Node {
    Node[] arr = new Node[26];
    boolean isEnd = false;
}

class PrefixTree {
    Node root;

    public PrefixTree() {
        root = new Node();
    }

    // when inserting we check if we have that ch alredy in our tree.
    // if yes we reuse it
    // if no we create it.
    // if the word is not one we seen before we need to create a node to mark that this is  word ->
    // we need a end node (-1)
    public void insert(String word) {
        Node curr = root;

        for (Character ch : word.toCharArray()) {
            int idx = ch - 'a';

            // for ch in the curr node array.
            // if the node exist move there (that means we have seen this before)
            // else create it, then move there

            if (curr.arr[idx] == null) {
                curr.arr[idx] = new Node();
            }
            curr = curr.arr[idx];
        }
        curr.isEnd = true; //mark the last node as end of word
    }

    // when searching, we see if that spot has been intialized.
    // if no, we return false
    // if yes we move there.
    // then at the last string of the word, we check is isEnd is true.
    // if yes return true. else return false

    public boolean search(String word) {
        Node curr = root;

        for (Character ch : word.toCharArray()) {
            int idx = ch - 'a';

            // for ch in the curr node array.
            // if the node exist move there (that means we have seen this before)
            // else create it, then move there

            if (curr.arr[idx] == null) {
                return false;
            }
            curr = curr.arr[idx];
        }

        return curr.isEnd;
    }

    // when looking for the prefix, we want to see if that prefix is stored (like auto complete)
    // we check if that spot has been intialized.
    // if no, we return false
    // if yes, we move there.
    // return true if we found all the chars
    public boolean startsWith(String prefix) {
        Node curr = root;

        for (Character ch : prefix.toCharArray()) {
            int idx = ch - 'a';

            // for ch in the curr node array.
            // if the node exist move there (that means we have seen this before)
            // else create it, then move there

            if (curr.arr[idx] == null) {
                return false;
            }
            curr = curr.arr[idx];
        }

        return true;
    }
}
