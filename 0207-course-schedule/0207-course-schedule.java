import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
                    int[] indegree = new int[numCourses];

                            for (int i = 0; i < numCourses; i++) {
                                        graph.add(new ArrayList<>());
                                                }

                                                        for (int[] pre : prerequisites) {
                                                                    int course = pre[0];
                                                                                int prereq = pre[1];

                                                                                            graph.get(prereq).add(course);
                                                                                                        indegree[course]++;
                                                                                                                }

                                                                                                                        Queue<Integer> queue = new LinkedList<>();

                                                                                                                                for (int i = 0; i < numCourses; i++) {
                                                                                                                                            if (indegree[i] == 0) {
                                                                                                                                                            queue.add(i);
                                                                                                                                                                        }
                                                                                                                                                                                }

                                                                                                                                                                                        int count = 0;

                                                                                                                                                                                                while (!queue.isEmpty()) {
                                                                                                                                                                                                            int current = queue.poll();
                                                                                                                                                                                                                        count++;

                                                                                                                                                                                                                                    for (int next : graph.get(current)) {
                                                                                                                                                                                                                                                    indegree[next]--;

                                                                                                                                                                                                                                                                    if (indegree[next] == 0) {
                                                                                                                                                                                                                                                                                        queue.add(next);
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                                                                                                    return count == numCourses;
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                        }