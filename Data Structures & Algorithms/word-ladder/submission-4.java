// class Solution {
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         if (wordList == null || !wordList.contains(endWord)) return 0;
//         Set<String> wordSet = new HashSet<>(wordList);
//         if (wordSet.contains(beginWord)) {
//             wordSet.remove(beginWord);
//         }

//         Queue<Pair> que = new LinkedList<>();
//         que.offer(new Pair(beginWord, 1));
//         while (!que.isEmpty()) {
//             Pair cur = que.poll();
//             String word = cur.word;
//             int level = cur.level;

//             if (word.equals(endWord)) return level;
//             for (int i = 0; i < word.length(); i++) {
//                 for (char c = 'a'; c <= 'z'; c++) {
//                     String newWord = word.substring(0, i) + c + word.substring(i+1);
//                     if (wordSet.contains(newWord)) {
//                         wordSet.remove(newWord);
//                         que.offer(new Pair(newWord, level + 1));
//                     }
//                 }
//             }
//         }
//         return 0;
//     }
// }

// class Pair {
//     String word;
//     int level;

//     Pair(String word, int level) {
//         this.word = word;
//         this.level = level;
//     }
// }

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) return 0;
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int level = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() < endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }

            Set<String> nextLevelSet = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char origin = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (endSet.contains(newWord)) {
                            return level + 1;
                        }
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            visited.add(newWord);
                            nextLevelSet.add(newWord);
                        }
                    }
                    chars[i] = origin;
                }
            }
            beginSet = nextLevelSet;
            level++;
        }
        return 0;
    }
}
