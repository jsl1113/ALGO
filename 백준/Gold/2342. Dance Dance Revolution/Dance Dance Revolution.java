import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr = new int[100001];
    static int[][] dp = new int[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int idx = 0, num;
        while ((num = Integer.parseInt(st.nextToken())) != 0)
            arr[++idx] = num;

        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        dp[0][0] = 0;

        for (int k = 1; k <= idx; k++) {
            int next = arr[k];
            int[][] ndp = new int[5][5];
            for (int[] row : ndp) Arrays.fill(row, Integer.MAX_VALUE);

            for (int i = 0; i < 5; i++)
                for (int j = 0; j < 5; j++) {
                    if (dp[i][j] == Integer.MAX_VALUE) continue;
                    ndp[i][next] = Math.min(ndp[i][next], dp[i][j] + cost(j, next));
                    ndp[next][j] = Math.min(ndp[next][j], dp[i][j] + cost(i, next));
                }

            dp = ndp;
        }

        int next = arr[idx], ans = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            ans = Math.min(ans, dp[i][next]);
            ans = Math.min(ans, dp[next][i]);
        }

        System.out.println(ans);
    }

    static int cost(int a, int b) {
        if (a == b) return 1;
        if (a == 0 || b == 0) return 2;
        if (Math.abs(a - b) == 2) return 4;
        return 3;
    }
}