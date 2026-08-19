class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) return 0;
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.contains(beginWord)) {
            wordSet.remove(beginWord);
        }

        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(beginWord, 1));
        while (!que.isEmpty()) {
            Pair cur = que.poll();
            String word = cur.word;
            int level = cur.level;

            if (word.equals(endWord)) return level;
            for (int i = 0; i < word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    String newWord = word.substring(0, i) + c + word.substring(i+1);
                    if (wordSet.contains(newWord)) {
                        wordSet.remove(newWord);
                        que.offer(new Pair(newWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}

class Pair {
    String word;
    int level;

    Pair(String word, int level) {
        this.word = word;
        this.level = level;
    }
}
