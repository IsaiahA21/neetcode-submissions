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

 /*
[1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null]

first reverse first half
[null <- 1 <- 2 <- 3 | 4 -> 5 -> 6 -> null]
        [fH]     [nH]
                 [p]  [c] 

reverse second half
[null <- 1 <- 2 <- 3 | null <- 4 <- 5 <- 6]
        [fH]     [nH]        [nLN]     [sH]    

fH.next = sH or fH.next = curr
return nH



[1 -> 2 -> 3 -> 4 -> 5 -> null]

[null <- 1 <- 2 <- 3 |  4 -> 5 -> null]
        [fH]      [nH] 
                  [p] [c]
    secondhalf length < k
    fH.next = curr
    return nH

----- I was partly right but I need to do K groups reverse ------
head=[1,2,3,4,5,6,7,8,9]
k=3

[3,2,1|,6,5,4|,9,8,7]
length/k = 3 groups

[1 -> 2 -> 3 | -> 4 -> 5 -> 6 | -> 7 -> 8 -> 9 |-> null]

[3,2,1|,6,5,4|,9,8,7]
- the grouptail when then point to the rest of the list
i.e = 1 after point to curr. tail.next = curr

 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int length = 0;
        while (curr != null){
            curr = curr.next;
            length++;
        }
        // System.out.println(length);

        ListNode newHead = null;
        ListNode firstHalf = head; // the last node of the reversed firstHalf 

        curr = head;
        ListNode previousGroupTail  = null;
        int groups = length / k;

        for (int gCount = 0; gCount < groups; gCount++){
            int i = 0;
            ListNode prev = null;

            ListNode groupTail = curr;

            // reverse the group
            while (i < k){
                i++;
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
                            
            }
            if(gCount == 0){
                newHead = prev;
                previousGroupTail = groupTail;
            }
            //Join the two reversed groups

            // point the prev group tail to the current group head
            previousGroupTail.next = prev;

            // then prev group tail is set to the new group tail
            previousGroupTail = groupTail;

            //Join the current group to what's left of the ListedList
            groupTail.next = curr;



        }


        return newHead;

    }
}
