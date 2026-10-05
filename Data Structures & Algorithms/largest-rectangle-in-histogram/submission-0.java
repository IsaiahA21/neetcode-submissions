class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            int start = i;

            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] pair = stack.pop();

                int height = pair[1];
                int startIndex = pair[0];

                int width = i - startIndex;

                maxArea = Math.max(maxArea, height * width);

                start = startIndex;
            }

            stack.push(new int[]{start, heights[i]});
        }

        while (!stack.isEmpty()) {
            int[] pair = stack.pop();

            int height = pair[1];
            int startIndex = pair[0];

            int width = heights.length - startIndex;

            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}