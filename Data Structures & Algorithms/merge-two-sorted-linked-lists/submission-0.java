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
comapare the nodes values, advance the smaller node 
if one before null first, "copy" the rest from the second into the output

list1
[1 -> 2 -> 4]
      h
newHead
newHeadCurr 

list2
[3 -> 3 -> 5]
h

if (curr1.val <= curr2.val), then list1 value comes before 2


once we know the first

**/
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // edge cases 
        if (list1 ==  null && list2 == null){
            return list1;
        }
        else if (list1 ==  null){
            return list2;
        }
        else if (list2 ==  null){
            return list1;
        }

        ListNode newHead = null;
        ListNode curr = null;

        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                if (newHead == null){
                    newHead = list1;
                    curr = newHead;
                }
                else {
                curr.next = list1;
                curr = curr.next; // move curr to the new 
            
                }
                list1 = list1.next;
            }
            else {
                if (newHead == null){
                    newHead = list2;
                    curr = newHead;
                }
                else {
                    curr.next = list2;
                    curr = curr.next;
                }
                list2 = list2.next;
            }

            // System.out.println("newHead " + newHead.val + "curr " + curr.val);
        }

        if (list1 == null){
            curr.next = list2;
        }
        else {
            curr.next = list1;
        }
        return newHead;
    }
}