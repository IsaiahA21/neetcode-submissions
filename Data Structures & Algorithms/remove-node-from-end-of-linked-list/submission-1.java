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

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1 pass: 2 ptrs. slow and fast. we move fast to n nodes in front
        // the we check that fast.next != null. when it does it mean that slow is at the node before the nth node
        // thefroe slow.next = slow.next.next


        // now if they want us to delete the last node from the end (the first now), n is the length of list meaning that fast == null
        // therefore we return head.next;

        ListNode slow = head;
        ListNode fast = head;
        
        // create a n gap btwn slop and fast
        for (int i =0; i < n; i++){
            fast = fast.next;
        }

        // check if we are deleting the first node. the first node is the length of the list away from the end
        if (fast == null ) return head.next;

        // now move and maintain that n distance until last node in the list
        // once we do slow will be at the node before the nth node
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        // move past the nth node
        slow.next = slow.next.next;

        return head;
    }
}
