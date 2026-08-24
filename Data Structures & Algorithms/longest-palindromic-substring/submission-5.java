class Solution {
    public String longestPalindrome(String s) {
        String res = new String();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i+1);
            if (s1.length() > res.length()) {
                res = s1;
            }

            if (s2.length() > res.length()) {
                res = s2;
            }
        }
        return res;
    }

    private String palindrome(String s, int l, int r) {
        while (
            l >= 0 &&
            r < s.length() &&
            s.charAt(l) == s.charAt(r)
        ) {
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }
}
