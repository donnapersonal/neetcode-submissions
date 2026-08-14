// class Solution {
//     List<List<String>> res = new LinkedList<>();
//     List<String> track = new LinkedList<>();

//     public List<List<String>> partition(String s) {
//         dfs(s, 0);
//         return res;
//     }

//     private void dfs(String s, int start) {
//         if (start == s.length()) {
//             res.add(new ArrayList<>(track));
//             return;
//         }

//         for (int end = start; end < s.length(); end ++) {
//             if (!isPalindrome(s, start, end)) continue;
//             track.add(s.substring(start, end+1));
//             dfs(s, end+1);
//             track.remove(track.size() - 1);
//         }
//     }
//     private boolean isPalindrome(String s, int l, int r) {
//         while (l < r) {
//             if (s.charAt(l) != s.charAt(r)) {
//                 return false;
//             }

//             l ++;
//             r --;
//         }

//         return true;
//     }
// }


class Solution {
    List<List<String>> res = new LinkedList<>();
    List<String> track = new LinkedList<>();
    boolean[][] pal;

    public List<List<String>> partition(String s) {
        int n = s.length();
        pal = new boolean[n][n];

        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || pal[i+1][j-1])) {
                    pal[i][j] = true;
                }
            }
        }

        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int end = start; end < s.length(); end ++) {
            if (!pal[start][end]) continue;
            track.add(s.substring(start, end+1));
            dfs(s, end+1);
            track.remove(track.size() - 1);
        }
    }
}
