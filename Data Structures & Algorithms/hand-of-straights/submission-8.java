class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int card : hand) {
            counts.put(card, counts.getOrDefault(card, 0) + 1);
        }

        List<Integer> starts = new ArrayList<>(counts.keySet());
        Collections.sort(starts);
        for (int start : starts) {
            int groups = counts.get(start);
            if (groups == 0) {
                continue;
            }
            for (int card = start; card < start + groupSize; card++) {
                int available = counts.getOrDefault(card, 0);
                if (available < groups) {
                    return false;
                }
                counts.put(card, available - groups);
            }
        }
        return true;
    }
}
