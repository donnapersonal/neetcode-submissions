// class Solution {
//     public String longestPalindrome(String s) {
//         String res = new String();
//         int n = s.length();
//         for (int i = 0; i < n; i++) {
//             String s1 = palindrome(s, i, i);
//             String s2 = palindrome(s, i, i+1);
//             if (s1.length() > res.length()) {
//                 res = s1;
//             }

//             if (s2.length() > res.length()) {
//                 res = s2;
//             }
//         }
//         return res;
//     }

//     private String palindrome(String s, int l, int r) {
//         while (
//             l >= 0 &&
//             r < s.length() &&
//             s.charAt(l) == s.charAt(r)
//         ) {
//             l--;
//             r++;
//         }
//         return s.substring(l+1, r);
//     }
// }

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] odd = expand(s, i, i);
            int[] even = expand(s, i, i+1);
            int oddL = odd[0], oddR = odd[1];
            int evenL = even[0], evenR = even[1];

            if (oddR - oddL > end - start) {
                start = oddL;
                end = oddR;
            }

            if (evenR - evenL > end - start) {
                start = evenL;
                end = evenR;
            }
        }
        return s.substring(start, end+1);
    }

    private int[] expand(String s, int left, int right) {
        // Continue expanding outward while:
        // 1. left remains inside the string,
        // 2. right remains inside the string,
        // 3. the characters on both sides are equal.
        while (
                left >= 0
                && right < s.length()
                && s.charAt(left) == s.charAt(right)
        ) {
            left--;
            right++;
        }

        // When the loop stops, both pointers have already
        // moved one position beyond the valid palindrome.
        //
        // Therefore, the actual palindrome boundaries are:
        // left + 1 and right - 1.
        return new int[]{left + 1, right - 1};
    }
}