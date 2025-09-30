import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static long MOD = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];
        long[] arr = new long[n + 1];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            long sum = dp[i - 1][0];
            for (int j = 1; j < 10; j++) {
                sum += dp[i - 1][j] % MOD;
            }
            arr[i - 1] = sum % MOD;

            dp[i][9] = 1;
            for (int j = 8; j >= 0; j--) {
                dp[i][j] = dp[i][j+1] % MOD + dp[i-1][j] % MOD;
                dp[i][j] %= MOD;
            }
        }

        long sum = dp[n][0];
        for (int j = 1; j < 10; j++) {
            sum += dp[n][j] % MOD;
        }
        arr[n] = sum % MOD;

//        for (int i = 1; i <= n; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
//
//        System.out.println();
//        System.out.println(Arrays.toString(arr));
        System.out.println(arr[n]);
    }
}