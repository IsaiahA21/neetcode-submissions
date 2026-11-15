class KthLargest {
    // is it min or maxheap
    // min. biggest at the bottom, so we can easily remove the smallest when size is bigger than k.
    PriorityQueue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>();

        // discard other values
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            heap.add(num);

            while (heap.size() > k) {
                heap.poll(); // remove smallest
            }
        }

        this.k = k;
    }

    // returns the k largest
    public int add(int val) {
        heap.add(val);
        while (heap.size() > k) {
            heap.poll();
        }

        return heap.peek();
    }

}
