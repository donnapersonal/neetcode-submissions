// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> res = new ArrayList<>();
//         StringBuilder path = new StringBuilder();
//         backtrack(n, 0, 0, path, res);
//         return res;
//     }

//     private void backtrack(int n, int left, int right, StringBuilder path, List<String> res) {
//         if (path.length() == 2 * n) {
//             res.add(path.toString());
//             return;
//         }

//         if (left < n) {
//             path.append("(");
//             backtrack(n, left + 1, right, path, res);
//             path.deleteCharAt(path.length() - 1);
//         }

//         if (right < left) {
//             path.append(")");
//             backtrack(n, left, right+1, path, res);
//             path.deleteCharAt(path.length() - 1);
//         }
//     }
// }

class Solution {
    private List<String> res;
    private StringBuilder path;
    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>();

        res = new ArrayList<>();
        path = new StringBuilder();
        backtrack(n, n);
        return res;
    }

    private void backtrack(int left, int right) {
        if (right < left) return;
        if (left < 0 || right < 0) return;
        if (left == 0 && right == 0) {
            res.add(path.toString());
            return;
        }
        path.append('(');
        backtrack(left-1, right);
        path.deleteCharAt(path.length() - 1);

        path.append(')');
        backtrack(left, right-1);
        path.deleteCharAt(path.length() - 1);
    }
}
