import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // [a, b] means b must come before a => b -> a
        for (int[] p : prerequisites) {
            int course = p[0];
            int pre = p[1];

            graph.get(pre).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;

        while (!q.isEmpty()) {
            int current = q.poll();
            order[index++] = current;

            for (int next : graph.get(current)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        if (index == numCourses) {
            return order;
        }

        return new int[0];
    }
}