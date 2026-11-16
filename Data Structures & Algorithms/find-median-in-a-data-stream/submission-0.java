/**
classic 2 heaps question - lower half (max heap), upper half (min heap).
if odd number, then median = lowerhalf.poll()
if even, get 2 the root values of heaps

lowerHalf(max Heap)
[3,2,1]
 ^

upperHalf(min Heap) -> []
[6,8, 11]
 ^

[2,1, -5]
 ^

[3,6,8, 11]

*
*/
class MedianFinder {
    PriorityQueue<Integer> lowerHalf; // the largest values we seen from the small side
    PriorityQueue<Integer> upperHalf; // the smallest values we seen from the big side

    public MedianFinder() {
        lowerHalf = new PriorityQueue<>(Collections.reverseOrder()); //max heap
        upperHalf = new PriorityQueue<>(); // min heap
    }

    public void addNum(int num) {
        // add to the lower Half
        lowerHalf.add(num);

        upperHalf.add(lowerHalf.poll()); // add the bigger of the lowerHalf to the upper

        // the lower half should always equal to or 1 bigger the upperHalf
        if (upperHalf.size() > lowerHalf.size()){
            lowerHalf.add(upperHalf.poll());
        }
    }

    public double findMedian() {
        // if we have a odd values, the median is the root of the lowerHalf
        if (lowerHalf.size() > upperHalf.size()){
            return lowerHalf.peek();
        }

        // else, we have even values and median is the avg of the 2 roots
        return (lowerHalf.peek() + upperHalf.peek())/2.0;
    }
}
