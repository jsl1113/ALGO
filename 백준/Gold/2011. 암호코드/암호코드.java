import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int MOD = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        if (str.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        long[] dp = new long[str.length() + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= str.length(); i++) {
            int now = str.charAt(i - 1) - '0';
            int prev = str.charAt(i - 2) - '0';

            if (now == 0) {
                if (1 <= prev && prev <= 2) dp[i] = dp[i - 2] % MOD;
                else break;
            } else {
                if (prev == 0) dp[i] = dp[i - 1] % MOD;
                else {
                    int n = prev * 10 + now;
                    dp[i] = ((1 <= n && n <= 26) ? (dp[i - 1] + dp[i - 2]) : dp[i - 1]) % MOD;
                }
            }
        }
        System.out.println(dp[str.length()]);
    }
}