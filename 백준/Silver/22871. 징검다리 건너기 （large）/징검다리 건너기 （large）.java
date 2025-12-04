import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt).mapToInt(Integer::intValue).toArray();

        long[] dp = new long[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                long tmp = (long) (i - j) * (1 + Math.abs(arr[i] - arr[j]));
                dp[i] = Math.min(dp[i], Math.max(dp[j], tmp));
            }
        }

        System.out.println(dp[n - 1]);
    }
}