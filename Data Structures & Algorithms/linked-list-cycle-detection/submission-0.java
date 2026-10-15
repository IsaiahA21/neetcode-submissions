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
 [1 -> 2 -> 3 -> 4]
 S          F  

if fast catches up to slow(fast == slow), then we have a cycle.

we have no cycle if fast is null or fast.next is null or  fast.next.next is null
*/

class Solution {
    public boolean hasCycle(ListNode head) {
        // 2 ptrs: slow and fast

        if (head == null || head.next == null){
            return false; // no cycle
        }

        ListNode slow = head;
        ListNode fast = head; // moves twice as fast

        while (fast != null && fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            if (slow == fast){// if they point to the same place in memeory
                return true;
            }
            slow = slow.next;
        }

        return false;

    }
}
