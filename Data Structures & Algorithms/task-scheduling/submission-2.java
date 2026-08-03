class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCount = new int[26];
        for (char task : tasks) {
            taskCount[task - 'A']++;
        }

        int maxCount = 0;
        for (int freq : taskCount) {
            maxCount = Math.max(maxCount, freq);
        }

        int maxCountTask = 0;
        for (int freq : taskCount) {
            if (freq == maxCount) {
                maxCountTask++;
            }
        }
        int minTime = (maxCount - 1) * (n+1) + maxCountTask;
        return Math.max(minTime, tasks.length);
    }
}
