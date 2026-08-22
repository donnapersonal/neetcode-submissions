// class Solution {
//     public List<String> findItinerary(List<List<String>> tickets) {
//         Map<String, Deque<String>> graph = new HashMap<>();
//         tickets.sort((a, b) -> {
//             int sourceCompare = a.get(0).compareTo(b.get(0));
//             if (sourceCompare != 0) return sourceCompare;
//             return a.get(1).compareTo(b.get(1));
//         });

//         for (List<String> ticket : tickets) {
//             String from = ticket.get(0);
//             String to = ticket.get(1);
//             graph.computeIfAbsent(from, key -> new ArrayDeque<>()).addLast(to);
//         }

//         List<String> path = new ArrayList<>();
//         dfs("JFK", graph, path);
//         Collections.reverse(path);
//         return path;
//     }

//     private void dfs(String airport, Map<String, Deque<String>> graph, List<String> path) {
//         Deque<String> dest = graph.getOrDefault(airport, new ArrayDeque<>());
//         while (!dest.isEmpty()) {
//             String next = dest.pollFirst();
//             dfs(next, graph, path);
//         }

//         path.add(airport);
//     }
// }

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, key -> new PriorityQueue<>()).offer(to);
        }

        List<String> path = new ArrayList<>();
        dfs("JFK", graph, path);
        Collections.reverse(path);
        return path;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, List<String> path) {
        PriorityQueue<String> dest = graph.getOrDefault(airport, new PriorityQueue<>());
        while (!dest.isEmpty()) {
            String next = dest.poll();
            dfs(next, graph, path);
        }

        path.add(airport);
    }
}

