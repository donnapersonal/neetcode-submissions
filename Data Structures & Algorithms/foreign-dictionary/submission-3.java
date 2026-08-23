class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, List<Character>> graph = new HashMap<>();
      Map<Character, Integer> indegree = new HashMap<>();
      for (String word : words) {
        for (char c : word.toCharArray()) {
            indegree.putIfAbsent(c, 0);
            graph.putIfAbsent(c, new ArrayList<>());
        }
      }

      for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i+1];
            int minLen = Math.min(first.length(), second.length());
            if (
                first.length() > second.length() &&
                first.substring(0, minLen).equals(second.substring(0, minLen))
            ) {
                return "";
            }
            for (int j = 0; j < minLen; j++) {
                char c1 = first.charAt(j);
                char c2 = second.charAt(j);
                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    indegree.put(c2, indegree.get(c2) + 1);
                    break;
                }
            }
        }
        Queue<Character> que = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                que.offer(c);
            }
        }

        StringBuilder res = new StringBuilder();
        while (!que.isEmpty()) {
            char ch = que.poll();
            res.append(ch);
            for (char nei : graph.getOrDefault(ch, new ArrayList<>())) {
                indegree.put(nei, indegree.get(nei) - 1);
                if (indegree.get(nei) == 0) {
                    que.offer(nei);
                }
            }
        }

        if (res.length() != indegree.size()) {
            return "";
        }

        return res.toString();
    }
}
