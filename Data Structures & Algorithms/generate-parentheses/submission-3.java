class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        backtrack(n, 0, 0, path, res);
        return res;
    }

    private void backtrack(int n, int left, int right, StringBuilder path, List<String> res) {
        if (path.length() == 2 * n) {
            res.add(path.toString());
            return;
        }

        if (left < n) {
            path.append("(");
            backtrack(n, left + 1, right, path, res);
            path.deleteCharAt(path.length() - 1);
        }

        if (right < left) {
            path.append(")");
            backtrack(n, left, right+1, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
