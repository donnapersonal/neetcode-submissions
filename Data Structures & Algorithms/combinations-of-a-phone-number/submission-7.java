// class Solution {
//     private final String[] MAP = {
//         "",     // 0
//         "",     // 1
//         "abc",  // 2
//         "def",  // 3
//         "ghi",  // 4
//         "jkl",  // 5
//         "mno",  // 6
//         "pqrs", // 7
//         "tuv",  // 8
//         "wxyz"  // 9
//     };
//     private List<String> res = new ArrayList<>();
//     private StringBuilder path = new StringBuilder();
//     private int n;

//     public List<String> letterCombinations(String digits) {
//         if (digits == null || digits.length() == 0) {
//             return res;
//         }
//         n = digits.length();

//         backtrack(digits, 0);
//         return res;
//     }

//     private void backtrack(String digits, int index) {
//         if (index == n) {
//             res.add(path.toString());
//             return;
//         }

//         int digit = digits.charAt(index) - '0';
//         String letters = MAP[digit];
//         for (char letter : letters.toCharArray()) {
//             path.append(letter);
//             backtrack(digits, index+1);
//             path.deleteCharAt(path.length() - 1);
//         }
//     }
// }

class Solution {
    private final String[] MAP = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };
    private List<String> res = new ArrayList<>();
    private int n;

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        n = digits.length();

        backtrack(digits, 0, "");
        return res;
    }

    private void backtrack(String digits, int index, String s) {
        if (index == n) {
            res.add(s);
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = MAP[digit];
        for (char letter : letters.toCharArray()) {
            backtrack(digits, index+1, s+letter);
        }
    }
}

