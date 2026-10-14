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
 [<-0 <- 1 <- 2 <- 3  null]
                   p   cn

---first set the 3 points up
prev =null
c = first
nextNode = curr.next 

------
curr.next = p
prev = curr
curr = nextNode
nextNode = nextNode.next -- to avoaid the tail node breaking by loop, im going to move nextNode only inside the while loop checks that curr != null

[null <- 0 <- 1 <- 2 <- 3]
                h
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode nextNode = null; 

        while (curr != null ){
            nextNode = curr.next; // we preserve the link to the list
            curr.next = prev;
            prev = curr;
            curr = nextNode; // move the curr to the point the unreserved part of the list
        }

        // at the end curr will point to null, therefore answer is prev;
        return prev;
    }
}
