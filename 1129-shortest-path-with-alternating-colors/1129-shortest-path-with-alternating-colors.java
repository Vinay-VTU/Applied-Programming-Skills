import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        ArrayList<Integer>[][] graph = new ArrayList[2][n];

        for (int color = 0; color < 2; color++) {
            for (int i = 0; i < n; i++) {
                graph[color][i] = new ArrayList<>();
            }
        }

        // 0 = red, 1 = blue
        for (int[] e : redEdges) {
            graph[0][e[0]].add(e[1]);
        }

        for (int[] e : blueEdges) {
            graph[1][e[0]].add(e[1]);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        boolean[][] visited = new boolean[n][2];
        Queue<int[]> q = new LinkedList<>();

        // Start from node 0 with both possible previous colors
        q.add(new int[]{0, 0});
        q.add(new int[]{0, 1});
        visited[0][0] = true;
        visited[0][1] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int node = curr[0];
                int prevColor = curr[1];

                if (ans[node] == -1) {
                    ans[node] = steps;
                }

                int nextColor = 1 - prevColor;

                for (int next : graph[nextColor][node]) {
                    if (!visited[next][nextColor]) {
                        visited[next][nextColor] = true;
                        q.add(new int[]{next, nextColor});
                    }
                }
            }

            steps++;
        }

        return ans;
    }
}