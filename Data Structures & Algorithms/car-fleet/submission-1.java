/**
target = 10, position = [1,4], speed = [3,2]

0th car => 10-1 = 9/3 = 3 hrs
1th car => 10 -4 = 6/2 = 3 hrs
1 fleet

Input: target = 10, position = [4,1,0,7], speed = [2,2,1,1]

0th car => 10 -4 = 6/2 = 3
1th car => 10 - 1 = 9/2 = 4.5
2th car => 10 - 0 = 10/1 = 10 hrs
3th car => 10 - 7 = 3/1 = 3


different car fleets that will arrive at the destination??

0th car catches up to 3th car -> res++
1th car and 2th cars never catch up

*/
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pair = new int[n][2];

        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        // Sort by position, closest to target first
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

        int fleets = 1;

        double prevTime = (double) (target - pair[0][0]) / pair[0][1];

        for (int i = 1; i < n; i++) {
            double currTime = (double) (target - pair[i][0]) / pair[i][1];

            if (currTime > prevTime) {
                fleets++;
                prevTime = currTime;
            }
        }

        return fleets;
    }
}
