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
 It’s asking you to rearrange the nodes so you alternate between the beginning and the end of the linked list.
 [2 -> 4 -> 6 -> 8 -> null]
[ 2 -> 8 -> 4 -> 6 -> null]
 */

class Solution {
    public void reorderList(ListNode head) {
        // steps: split in half, reverse 2nd half, merge the 2 list back together 

        // split in half: slow faster ptrs
        ListNode slow = head;// end up in the middle
        ListNode fast = head; // ends up at the end at null

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }




        // reverse the 2nd half: reverse a list. need 2 ptrs at a tmp that points to next
        ListNode curr = slow.next;
        slow.next = null;         // disconnect the 2 halfs
        ListNode prev = null;

        while (curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // prev will point to the old tail of the list, which will now be the new head of the reversed list, call it list2

        // merge the 2 list back in the required order
        ListNode list1 = head;
        ListNode list2 = prev;

        ListNode tmp1 = null;
        ListNode tmp2 = null;

        while (list1 != null && list2 != null){
            System.out.println("list1 " + list1.val + " list2 " + list2.val);

            tmp1 = list1.next; // preverse ptrs to the list
            tmp2 = list2.next;

            list1.next = list2;
            list2.next = tmp1;

            list1 = tmp1;
            list2 = tmp2;


        }
        
    }
}
