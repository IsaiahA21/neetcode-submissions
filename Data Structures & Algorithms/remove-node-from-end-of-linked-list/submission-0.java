/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
[1 -> 2 -> 3 -> 4] n = 2
[1 -> 2 -> 4]

[5 -> null], n = 1
[]

[1 -> 2 -> null] n = 2
[2-> null]
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // two pass: count the size, then dtermine the index to remove from the front (front remove
        // = Size - n) (0 base index)

        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            size++;
        }

        // next get the node to remove from front
        int n_prime = size - n;

        if (n_prime == 0) { // we are removing the first
            return head.next;
        }

        int i = 0;
        curr = head;
        ListNode prev = null;
        ListNode nextNode = null;
        while (curr != null && i != n_prime) {
            prev = curr;
            curr = curr.next;
            nextNode = curr.next;

            i++;
        }
        // once we find the node to delete update the pointer

        prev.next = nextNode;

        return head;
    }
}
