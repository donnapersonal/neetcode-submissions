class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Queue<Integer> que = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        que.offer(amount);
        visited.add(amount);
        int step = 0;
        while (!que.isEmpty()) {
            step++;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int cur = que.poll();
                for (int coin : coins) {
                    if (cur == coin) {
                        return step;
                    }

                    if (cur > coin && !visited.contains(cur - coin)) {
                        visited.add(cur - coin);
                        que.offer(cur - coin);
                    }
                }
            }
        }
        return -1;
    }
}
