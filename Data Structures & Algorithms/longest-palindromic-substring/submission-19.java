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

// class Solution {
//     public String longestPalindrome(String s) {
//         if (s == null || s.isEmpty()) {
//             return "";
//         }
//         int start = 0, end = 0;
//         for (int i = 0; i < s.length(); i++) {
//             int[] odd = expand(s, i, i);
//             int[] even = expand(s, i, i+1);
//             int oddL = odd[0], oddR = odd[1];
//             int evenL = even[0], evenR = even[1];

//             if (oddR - oddL > end - start) {
//                 start = oddL;
//                 end = oddR;
//             }

//             if (evenR - evenL > end - start) {
//                 start = evenL;
//                 end = evenR;
//             }
//         }
//         return s.substring(start, end+1);
//     }

//     private int[] expand(String s, int left, int right) {
//         // Continue expanding outward while:
//         // 1. left remains inside the string,
//         // 2. right remains inside the string,
//         // 3. the characters on both sides are equal.
//         while (
//                 left >= 0
//                 && right < s.length()
//                 && s.charAt(left) == s.charAt(right)
//         ) {
//             left--;
//             right++;
//         }

//         // When the loop stops, both pointers have already
//         // moved one position beyond the valid palindrome.
//         //
//         // Therefore, the actual palindrome boundaries are:
//         // left + 1 and right - 1.
//         return new int[]{left + 1, right - 1};
//     }
// }

class Solution {
    public String longestPalindrome(String s) {
        // Handle null or empty input immediately.
        if (s == null || s.isEmpty()) {
            return "";
        }

        // Insert '#' between every character and at both boundaries.
        // This allows odd-length and even-length palindromes
        // to be processed in the same way.
        //
        // Example:
        // "abba" becomes "#a#b#b#a#".
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            builder.append('#');
            builder.append(s.charAt(i));
        }

        builder.append('#');

        String transformed = builder.toString();

        // Length of the transformed string.
        int n = transformed.length();

        // radius[i] stores the palindrome radius centered at index i
        // in the transformed string.
        int[] radius = new int[n];

        // center is the center of the palindrome that currently
        // reaches farthest to the right.
        int center = 0;

        // right is the rightmost boundary reached by that palindrome.
        int right = 0;

        // Track the longest palindrome found so far.
        int maxLength = 0;
        int maxCenter = 0;

        // Try every position as a palindrome center.
        for (int i = 0; i < n; i++) {
            // If i is inside the current rightmost palindrome,
            // use the palindrome radius of its mirrored position.
            //
            // mirror = 2 * center - i
            if (i < right) {
                int mirror = 2 * center - i;

               radius[i] = Math.min(right - i, radius[mirror]);
            }

            // Expand outward while:
            // 1. The right pointer remains inside the string.
            // 2. The left pointer remains inside the string.
            // 3. The characters on both sides are equal.
            while (
                    i + radius[i] + 1 < n
                    && i - radius[i] - 1 >= 0
                    && transformed.charAt(i + radius[i] + 1)
                    == transformed.charAt(i - radius[i] - 1)
            ) {
                radius[i]++;
            }

            // If the palindrome centered at i extends beyond
            // the current right boundary, update center and right.
            if (i + radius[i] > right) {
                center = i;
                right = i + radius[i];
            }

            // Update the longest palindrome found so far.
            if (radius[i] > maxLength) {
                maxLength = radius[i];
                maxCenter = i;
            }
        }

        // Convert the transformed-string position back to
        // the original string index.
        int start = (maxCenter - maxLength) / 2;

        // maxLength in the transformed string is equal to
        // the palindrome length in the original string.
        return s.substring(start, start + maxLength);
    }
}