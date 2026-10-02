class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> deque = new ArrayDeque<>(); // indexs
        List<Integer> res = new ArrayList<>();

        int lptr =0;

        for (int rptr = 0; rptr < n; rptr++){

            // Remove smaller values from the back (the right side)
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[rptr]){
                deque.pollLast();
            }

            //Add current index
            deque.addLast(rptr);

            //Remove indices outside the window
            if (deque.peekFirst() < lptr) {
                deque.pollFirst();
            }

            // window has reached size k
            if (rptr - lptr + 1 == k){
                // Front is the max
                res.add(nums[deque.peekFirst()]);
                
                lptr++;
            }
        }

        return res.stream()
                  .mapToInt(Integer::intValue)
                  .toArray();        
    }
}
