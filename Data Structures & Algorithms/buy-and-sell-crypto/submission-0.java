// buy low, sell high
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        // iterate over the area and look for the max profit 
        int buyprice = prices[0];
        for (int i = 1;i < prices.length; i++){
            if (prices[i] < buyprice){
                // buy this day instead
                buyprice = prices[i];
                // System.out.println("new buy price is " + buyprice);
            }
            else{
                // price[i] >= buyprice
                // sell and see if we can make money
                int currProfit = prices[i] - buyprice;
                res = Math.max(res, currProfit);
            }
        }

        return res;
    }
}
