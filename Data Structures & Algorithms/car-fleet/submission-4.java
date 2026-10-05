class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        int[][] pairs = new int[n][2];// 2 cols
        for (int i = 0; i < n; i++){
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (row1, row2) -> Integer.compare(row2[0], row1[0]));// descending order based on the position

        Deque<Float> stack = new ArrayDeque<>(); // use a stack to keep track of the disnct car fleets

        for (int i = 0; i < n; i++){
            // when will this car reach the target
            float carTime = (target - pairs[i][0]) / (float) pairs[i][1];
            // System.out.println(carTime);

            if (stack.isEmpty() ||  carTime > stack.peek()){
                // the stack is ucrrent emepty or the current car will not catch up to the car in front of it and join the fleet ( if carTime <= the one in the top of the stack we know it will catch it)
                stack.push(carTime);
                // System.out.println("start position" + pairs[i][0]);


            }
        }

        return stack.size();
    }
}
