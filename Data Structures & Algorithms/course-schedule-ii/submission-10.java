// class Solution {
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         int[] res = new int[numCourses];
//         List<List<Integer>> graph = new ArrayList<>();
//         int[] indegree = new int[numCourses];

//         for (int i = 0; i < numCourses; i++) {
//             graph.add(new ArrayList<>());
//         }

//         for (int[] pair : prerequisites) {
//             int course = pair[0];
//             int pre = pair[1];
//             graph.get(pre).add(course);
//             indegree[course]++;
//         }

//         Queue<Integer> que = new LinkedList<>();
//         for (int i = 0; i < numCourses; i++) {
//             if (indegree[i] == 0) {
//                 que.offer(i);
//             }
//         } 

//         int index = 0;
//         while (!que.isEmpty()) {
//             int course = que.poll();
//             res[index++] = course;
//             for (int nxt : graph.get(course)) {
//                 indegree[nxt]--;
//                 if (indegree[nxt] == 0) {
//                     que.offer(nxt);
//                 }
//             }
//         }

//         return index == numCourses ? res : new int[0];
//     }
// }


class Solution {
    private int[] res;
    private List<List<Integer>> graph;
    private int[] visited;
    private int index = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        res = new int[numCourses];
        graph = new ArrayList<>();
        visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int pre = pair[1];
            graph.get(course).add(pre);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return new int[0];
            }
        }
        return res;
    }

    private boolean dfs(int course) {
        if (visited[course] == 1) {
            return false;
        }

        if (visited[course] == 2) {
            return true;
        }

        visited[course] = 1;
        for (int pre : graph.get(course)) {
            if (!dfs(pre)) {
                return false;
            }
        }
        visited[course] = 2;
        res[index++] = course;
        return true; 
    }
}
