import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k, answer;
    static int[][] quests;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        quests = new int[m][k];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                quests[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
        }

        dfs(0, 0, new boolean[2 * n]);
        System.out.println(answer);
    }

    static void dfs(int c, int t, boolean[] visited) {
        if (c == n) {
            int tmp = 0;
            for (int[] quest : quests) {
                boolean flag = true;

                for (int q : quest) {
                    if (!visited[q]) {
                        flag = false;
                        break;
                    }
                }
                tmp += flag ? 1 : 0;
            }
            answer = Math.max(answer, tmp);
            return;
        }

        for (int i = t; i < 2 * n; i++) {
            visited[i] = true;
            dfs(c + 1, i + 1, visited);
            visited[i] = false;
        }
    }
}
