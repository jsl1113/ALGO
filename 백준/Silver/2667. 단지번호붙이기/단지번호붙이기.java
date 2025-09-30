import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] strArray = st.nextToken().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(strArray[j]);
            }
        }

        boolean[][] visited = new boolean[n][n];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int number = 2;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    arr[i][j] = number;
                    while (!queue.isEmpty()) {
                        int[] point = queue.poll();
                        for (int p = 0; p < 4; p++) {
                            int nx = point[0] + dx[p];
                            int ny = point[1] + dy[p];

                            if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && arr[nx][ny] == 1) {
                                visited[nx][ny] = true;
                                queue.add(new int[]{nx, ny});
                                arr[nx][ny] = number;
                            }
                        }
                    }
                    number++;
                }
            }
        }

        int[] answer = new int[number - 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0) {
                    answer[arr[i][j] - 2]++;
                }
            }
        }

        System.out.println(number - 2);
        Arrays.sort(answer);
        for (int ans : answer) {
            System.out.println(ans);
        }
    }
}