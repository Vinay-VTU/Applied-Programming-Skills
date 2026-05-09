import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
            if (source == destination) {
                        return true;
                                }

                                        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

                                                for (int i = 0; i < n; i++) {
                                                            graph.add(new ArrayList<>());
                                                                    }

                                                                            for (int[] edge : edges) {
                                                                                        int u = edge[0];
                                                                                                    int v = edge[1];

                                                                                                                graph.get(u).add(v);
                                                                                                                            graph.get(v).add(u);
                                                                                                                                    }

                                                                                                                                            boolean[] visited = new boolean[n];
                                                                                                                                                    Queue<Integer> queue = new LinkedList<>();

                                                                                                                                                            queue.add(source);
                                                                                                                                                                    visited[source] = true;

                                                                                                                                                                            while (!queue.isEmpty()) {
                                                                                                                                                                                        int node = queue.poll();

                                                                                                                                                                                                    for (int next : graph.get(node)) {
                                                                                                                                                                                                                    if (next == destination) {
                                                                                                                                                                                                                                        return true;
                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                        if (!visited[next]) {
                                                                                                                                                                                                                                                                                            visited[next] = true;
                                                                                                                                                                                                                                                                                                                queue.add(next);
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                                                                                            return false;
                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                }