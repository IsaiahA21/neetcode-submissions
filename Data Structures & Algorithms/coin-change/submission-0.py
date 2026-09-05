# for each coin what do I need to get ammount?
# for coin =1 , I need 12  = 12
# for coin = 5 , I need 2 $5 coin and 2 $1 = 4
# for coin = 10, I need $10 and $2 = 2

# the coinmax length is 10. small meaning we need something 2^n recursion or bottom up

# we recrusive and try each coin and see if we get the bottom. 
# the goal is to get to amount =0 and return step. if amount < 0, we know that coin doesnt work
# for coin in coins: dfs(amount, coins)
# how do we memo? we know the result of combinations we have seen before. we know that, for ex, 5 $1 and 1 $10 is not going to work.
# how do we get the min count. when amount is 0 we compare it against a previous solution we saw.
# dfs(amount-coin, coins, )
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0
        memo = {}

        def dfs(amount: int):
            if amount == 0: # its a solution so we return
                return 0
            
            if amount in memo:
                return memo[amount]
            res = math.inf

            for coin in coins:
                if (amount - coin) >= 0:
                    res = min(res,  dfs(amount - coin) + 1)
                
            memo[amount] = res
            return memo[amount]
        
        # memo map (coin -> amount)
        minAmount = dfs(amount)

        return -1 if  minAmount == math.inf else minAmount
            
            