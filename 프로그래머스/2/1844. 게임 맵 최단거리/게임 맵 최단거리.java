import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    int[][] visit;
    int n, m;

    public int solution(int[][] maps) {
        n = maps.length; m = maps[0].length;
        visit = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visit[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nx = now[0];
            int ny = now[1];

            for (int i = 0; i < 4; i++) {
                int x = nx + dx[i];
                int y = ny + dy[i];

                if (x < 0 || x >= n || y < 0 || y >= m)
                    continue;

                if (visit[x][y] == 0 && maps[x][y] == 1) {
                    queue.add(new int[]{x, y});
                    visit[x][y] = visit[nx][ny] + 1;
                }
            }
        }

        return visit[n - 1][m - 1] > 0 ? visit[n - 1][m - 1] : -1;
    }

}