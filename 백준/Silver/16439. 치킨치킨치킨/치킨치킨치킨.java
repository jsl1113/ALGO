import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, satisfaction; // 고리 회원 수, 치킨 종류 수
    static int[][] arr;
    static int[] chicken;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        satisfaction = Integer.MIN_VALUE;

        arr = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        chicken = new int[3];
        dfs(0, 1);
        System.out.println(satisfaction);
    }

    public static void dfs(int cnt, int start) {
        if (cnt == 3) {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                int max = 0;
                for (int j = 0; j < 3; j++) {
                    int tmp = arr[i][chicken[j]];
                    if(tmp > max) max = tmp;
                }
                sum += max;
            }
            if(sum > satisfaction) satisfaction = sum;
            return;
        }

        for (int i = start; i <= m; i++) {
            chicken[cnt] = i;
            dfs(cnt + 1, i + 1);
        }
    }
}
