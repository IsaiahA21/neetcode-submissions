class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer>  freqCount = new HashMap<>();
        int n = nums.length;
        int[] res = new int[n];

        for (int ele : nums){
            freqCount.put(ele,freqCount.getOrDefault(ele,0) + 1);
        }
        System.out.println(freqCount);

        // bucket sort based on count.
        // max is an element appears n times and will be in n+1  bucket
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i =0; i <= n; i++){
            buckets.add( new ArrayList());
        }

        freqCount.forEach((key, value) -> {
            buckets.get(value).add(key);
            
        });
        buckets.forEach(bucket -> {
            Collections.sort(bucket, Collections.reverseOrder());
        });

        // add to res
        int index =0;
        for (int i = 1; i <= n; i++) {
            List<Integer> bucket = buckets.get(i);
            for (Integer ele : bucket){
                for (int j =0; j < i; j++){
                    res[index] = ele;
                    index++;
                }
            }
            
        }
        return res;
    }
}