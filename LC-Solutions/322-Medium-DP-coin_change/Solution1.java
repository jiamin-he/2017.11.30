/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 08, 2017
 Problem:    Coin Change
 Difficulty: Medium
 Notes:

You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.

*/

// 这个greedy 每次拿value最大的 不合理！！！
// 方法本身有问题！！ 小的数目看不出来 提交的时候就看出来了
// test case: 
// [186,419,83,408] --> 6249 (my: 26 key:20)
// in my solution i will try to get 8*419 and then....
// but in fact test this: [186,419,83,408] --> 4573 (this is the remain after we take 4*419)
// and we can see in my solution it is 22, but actually only needs 16.
// which means we don't need to take so many 419 but actually taking others would work better.
// so this solution does not work.
// we should not avoid the comparing and retrieving the minimum process.
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0]=0;
        Arrays.sort(coins);
        helper(coins,amount,dp);
        return dp[amount];
    }
    
    public int helper(int[] coins, int amount, int[] dp) {
        if(dp[amount] != 0 || amount == 0) return dp[amount];
        for(int i = coins.length-1; i >= 0; i--) {
            if(amount < coins[0]) break;
            if(amount >= coins[i]) {
                if(helper(coins, amount-coins[i], dp) != -1) {
                    dp[amount] = dp[amount-coins[i]] + 1;
                    return dp[amount];
                }
            }
        }
        dp[amount] = -1;
        return -1;
    }
}


// 38ms 22%
// 其实不先 sort 也没关系 不sort 就慢了1ms
// 前面sort是 nlogn 后面是n2 所以后面才是大头
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        Arrays.sort(coins);
        helper(coins,amount,dp);
        return dp[amount];
    }
    
    public int helper(int[] coins, int amount, int[] dp) {
        if(dp[amount] != Integer.MAX_VALUE || amount == 0) return dp[amount];
        for(int i = coins.length-1; i >= 0; i--) {
            if(amount >= coins[i]) {
                if(helper(coins, amount-coins[i], dp) != -1) {
                    dp[amount] = Math.min(dp[amount],dp[amount-coins[i]] + 1);
                }
            }
        }
        if(dp[amount] < Integer.MAX_VALUE) return dp[amount];
        dp[amount] = -1;
        return -1;
    }
}

// 及时break？
// 好像也不行
// 还是很慢 只提升了1ms

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        Arrays.sort(coins);
        helper(coins,amount,dp);
        return dp[amount];
    }
    
    public int helper(int[] coins, int amount, int[] dp) {
        if(dp[amount] != Integer.MAX_VALUE || amount == 0) return dp[amount];
        for(int i = 0; i < coins.length; i++) {
            if(amount >= coins[i]) {
                if(helper(coins, amount-coins[i], dp) != -1) {
                    dp[amount] = Math.min(dp[amount],dp[amount-coins[i]] + 1);
                }
            } else {break;}
        }
        if(dp[amount] < Integer.MAX_VALUE) return dp[amount];
        dp[amount] = -1;
        return -1;
    }
}

// 注意 其实可以不用把整个数组都初始化成max value 拿一个max value 在第一次的时候做比较久可以了
// 这么改了之后 显得清晰了很多！但是超慢！
// 43ms 20%
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount < 0) return -1; 
        int[] dp = new int[amount+1];
        dp[0]=0;
        Arrays.sort(coins);
        helper(coins,amount,dp);
        return dp[amount];
    }
    
    public int helper(int[] coins, int amount, int[] dp) {
        if(dp[amount] != 0 || amount == 0) return dp[amount];
        if(amount < 0) return -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            if(amount >= coins[i]) {
                int temp = helper(coins, amount-coins[i], dp);
                if(temp > -1 && temp < min) {
                    min = temp+1;
                }
            } else {break;}
        }
        dp[amount] = min < Integer.MAX_VALUE? min:-1;
        return dp[amount];
    }
}

// iterative 
// 23ms 63%
// this is much similar to my idea!
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount<1) return 0;
        int[] dp = new int[amount+1];
        int sum = 0;
        while(++sum<=amount) {
            int min = -1;
            for(int coin : coins) {
                if(sum >= coin && dp[sum-coin]!=-1) {
                    int temp = dp[sum-coin]+1;
                    min = min<0 ? temp : (temp < min ? temp : min);
                }
            }
            dp[sum] = min;
        }
        return dp[amount];
    }
}

// 5ms 99%
class Solution {
    int res = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        Arrays.sort(coins);
        dfs(coins, amount, coins.length - 1, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    private void dfs(int[] coins, int amount, int index, int count) {
        if (amount == 0) {
            res = Math.min(res, count);
            return;
        }
        if (index < 0) {
            return;
        }
        int num = amount / coins[index];
        for (int i = num; i >= 0; i--) {
            if (count + i < res) {
                dfs(coins, amount - coins[index] * i, index - 1, count + i);
            } else {
                break;
            }
        }
    }
}



