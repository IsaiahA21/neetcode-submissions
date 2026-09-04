# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        # Tell Python to compare nodes based entirely on their first value
    def __lt__(self, other):
        return self.val < other.val

class Solution:    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        # min-Heap , add to the tree the head of each LinkedList
        # this woudl then give us the smallest current value
        # pop the head of heap, add it to the res array, 
        # move the popped node to next and add that to list
        
        heap = [ head for head in lists if head is not None] # add everythiogn to the heap
        heapq.heapify(heap)
        # print(heap[0].val)
        head = ListNode()
        curr = head

        while heap:
            popped_node = heapq.heappop(heap)
            curr.next = popped_node
            curr = curr.next

            if popped_node and popped_node.next:
                heapq.heappush(heap,popped_node.next)

        return head.next