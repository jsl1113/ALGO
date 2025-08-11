import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[][] dp = new long[65][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(solution(dp, n)).append("\n");
        }

        System.out.println(sb);
    }

    public static long solution(long[][] dp, int n) {
        if (dp[n][0] == 0) {
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j <= 9; j++) {
                    if (j == 0) dp[i][j] = 1;
                    else dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }

        long sum = 0L;
        for (int i = 0; i <= 9; i++) {
            sum += dp[n][i];
        }
        return sum;
    }
}
