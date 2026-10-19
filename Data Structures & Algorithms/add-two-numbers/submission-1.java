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
321 + 654 = 975

 321
+ 654
------
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            // when any of them are 0 we are done
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            int sum = val1 + val2 + carry;
            int nodeValue = sum % 10; // modulos gives us the remainder
            carry = sum / 10; // int division gives us the carry

            curr.next = new ListNode(nodeValue);

            curr = curr.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;;
        }

        return head.next;
    }
}
