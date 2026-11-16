/**
"At each step we choose the two heaviest stones" - we need to have the 2 largest always avaiable.
Therefore, max heap

Input: stones = [2,3,6,2,4]
Output: 1

sim 1:
[6,4,3,2,2]
{6 -4 } = 2 ==> [3,2,2,2]

sim 2:
[3,2,2,2]
{3 -2} = 1 ==> [2,2,1]

sim 2:
[2,2,1]
{2 -2 } = 0 ==> [1] (our heap only has 1 element) therefore return element.  IF, heap was empty
return 0.

*
*/
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (!maxHeap.isEmpty() && maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            int remainder = Math.abs(stone1 - stone2);
            if (remainder != 0) {
                maxHeap.add(remainder);
            }
        }

        return (maxHeap.size() == 0) ? 0 : maxHeap.poll();
    }
}
