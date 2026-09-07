// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         if (amount == 0) return 0;
//         Queue<Integer> que = new LinkedList<>();
//         Set<Integer> visited = new HashSet<>();
//         que.offer(amount);
//         visited.add(amount);
//         int step = 0;
//         while (!que.isEmpty()) {
//             step++;
//             int size = que.size();
//             for (int i = 0; i < size; i++) {
//                 int cur = que.poll();
//                 for (int coin : coins) {
//                     if (cur == coin) {
//                         return step;
//                     }

//                     if (cur > coin && !visited.contains(cur - coin)) {
//                         visited.add(cur - coin);
//                         que.offer(cur - coin);
//                     }
//                 }
//             }
//         }
//         return -1;
//     }
// }

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i < amount+1; i++) {
                if (i - coin >= 0 && dp[i-coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         if (amount == 0) return 0;
//         int[] dp = new int[amount+1];
//         Arrays.fill(dp, Integer.MAX_VALUE);
//         dp[0] = 0;
//         for (int i = 1; i < amount+1; i++) {
//             for (int coin : coins) {
//                 if (i - coin >= 0 && dp[i-coin] != Integer.MAX_VALUE) {
//                     dp[i] = Math.min(dp[i], dp[i-coin] + 1);
//                 }
//             }
//         }
//         return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
//     }
// }
