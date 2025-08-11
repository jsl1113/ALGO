import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 1; j--) {
                max = Math.max(max, Math.abs(arr[i] - arr[j]) + dp[j - 1]);
            }

            dp[i] = max;
        }

        System.out.println(dp[n]);
    }
}