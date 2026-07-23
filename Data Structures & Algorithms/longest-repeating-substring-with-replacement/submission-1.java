class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int[] maxFreq = new int[26];
        int freq = 0;
        int res = 0;
        while (right < s.length()) {
            int c = s.charAt(right) - 'A';
            maxFreq[c]++;
            freq = Math.max(freq, maxFreq[c]);
            right++;
            if (right - left > freq + k) {
                int d = s.charAt(left) - 'A';
                maxFreq[d]--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
