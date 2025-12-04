import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, answer = -1;
    static int[][] arr;
    static boolean[] visited = new boolean[10];
    static int[] player = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][10];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[4] = true;
        player[4] = 1;  // 4번은 1번 타자
        dfs(2);
        System.out.println(answer);
    }

    public static void dfs(int cnt) {
        if (cnt == 10) {
            answer = Math.max(answer, game());
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                player[i] = cnt;
                dfs(cnt + 1);
                visited[i] = false;
            }
        }
    }

    private static int game() {
        int start = 1, score = 0;

        for (int i = 0; i < n; i++) {
            int[] point = {0, 0, 0, 0, 0};

            while (point[0] < 3) {
                for (int j = 0; j < arr[i][player[start]]; j++) {
                    point[4] += point[3];
                    point[3] = point[2];
                    point[2] = point[1];
                    point[1] = 0;
                }
                point[arr[i][player[start]]]++;

                if (start == 9) start = 1;
                else start++;
            }
            score += point[4];
        }

        return score;
    }
}