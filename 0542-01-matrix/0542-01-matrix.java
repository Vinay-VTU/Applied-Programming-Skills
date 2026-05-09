import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
            int m = mat.length;
                    int n = mat[0].length;

                            Queue<int[]> queue = new LinkedList<>();
                                    boolean[][] visited = new boolean[m][n];

                                            // Add all 0 cells to queue
                                                    for (int i = 0; i < m; i++) {
                                                                for (int j = 0; j < n; j++) {
                                                                                if (mat[i][j] == 0) {
                                                                                                    queue.add(new int[]{i, j});
                                                                                                                        visited[i][j] = true;
                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                            }

                                                                                                                                                                    int[][] dirs = {
                                                                                                                                                                                {1, 0},
                                                                                                                                                                                            {-1, 0},
                                                                                                                                                                                                        {0, 1},
                                                                                                                                                                                                                    {0, -1}
                                                                                                                                                                                                                            };

                                                                                                                                                                                                                                    while (!queue.isEmpty()) {
                                                                                                                                                                                                                                                int[] cell = queue.poll();
                                                                                                                                                                                                                                                            int row = cell[0];
                                                                                                                                                                                                                                                                        int col = cell[1];

                                                                                                                                                                                                                                                                                    for (int[] d : dirs) {
                                                                                                                                                                                                                                                                                                    int nr = row + d[0];
                                                                                                                                                                                                                                                                                                                    int nc = col + d[1];

                                                                                                                                                                                                                                                                                                                                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                                                                                                                                                                                                                                                                                                                                                        mat[nr][nc] = mat[row][col] + 1;
                                                                                                                                                                                                                                                                                                                                                                            visited[nr][nc] = true;
                                                                                                                                                                                                                                                                                                                                                                                                queue.add(new int[]{nr, nc});
                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                                                                                                                                                                            return mat;
                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                }