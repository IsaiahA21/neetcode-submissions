// if you have 2+ zeros the empty array is gonna be 0
// if you have 1 zero then everything other than that 0 will be the product.add()

/**
[1,2,4,6]

leftProd = [1,1,2,8]
rightProd = [48,24,6,1]

res = []

 [-1,0,1,2,3]

 leftPrd=[1,-1,0,0,0]
 rightPrd=[0,6,6,3,1]

 [0,-6,0,0,0]


*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProd = new int[n];
        int[] rightProd = new int[n];
        int[] res = new int[n];

        // fill arrays
        leftProd[0] = 1; // it doesnt have left values
        rightProd[n - 1] = 1; // doesnt have right values

        for (int i = 1; i < n; i++) {
            leftProd[i] = nums[i - 1] * leftProd[i - 1];

            int j = n - 1 - i;
            rightProd[j] = nums[j + 1] * rightProd[j + 1];
        }

        for (int i = 0; i < n; i++) {
            res[i] = leftProd[i] * rightProd[i];
        }

        return res;
    }
}
