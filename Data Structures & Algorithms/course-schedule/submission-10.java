// class Solution {
//     private int[] visited;
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         List<List<Integer>> graph = new ArrayList<>();
//         for (int i = 0; i < numCourses; i++) {
//             graph.add(new ArrayList<>());
//         }

//         for (int[] pair : prerequisites) {
//             int course = pair[0];
//             int pre = pair[1];
//             graph.get(course).add(pre);
//         }

//         visited = new int[numCourses];
//         for (int course = 0; course < numCourses; course++) {
//             if (!dfs(graph, course)) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     private boolean dfs(List<List<Integer>> graph, int course) {
//         if (visited[course] == 1) return false;
//         if (visited[course] == 2) return true;

//         visited[course] = 1;
//         for (int pre : graph.get(course)) {
//             if (!dfs(graph, pre)) {
//                 return false;
//             }
//         }
//         visited[course] = 2;
//         return true;
//     }
// }

class Solution {
    private int[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int pre = pair[1];
            graph.get(pre).add(course);
            indegree[course]++;
        }

        Queue<Integer> que = new LinkedList<>();
        for (int course = 0; course < numCourses; course++) {
            if (indegree[course] == 0) {
                que.offer(course);
            }
        }

        int processed = 0;
        while (!que.isEmpty()) {
            int course = que.poll();
            processed++;
            for (int nextCourse : graph.get(course)) {
                indegree[nextCourse]--;

                if (indegree[nextCourse] == 0) {
                    que.offer(nextCourse);
                }
            }
        }
        return processed == numCourses;
    }
}
