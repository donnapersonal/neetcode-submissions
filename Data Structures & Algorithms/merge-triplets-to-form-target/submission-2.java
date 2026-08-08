class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int x = target[0], y = target[1], z = target[2];
        int a = 0, b = 0, c = 0;
        for (int[] triplet : triplets) {
            int ai = triplet[0], bi = triplet[1], ci = triplet[2];
            if (ai <= x && bi <= y && ci <= z) {
                a = Math.max(a, ai);
                b = Math.max(b, bi);
                c = Math.max(c, ci);
            }
        }
        return a == x && b == y && c == z;
    }
}
