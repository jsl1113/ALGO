import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n + 10];
        int[] p = new int[n + 10];
        int[] dp = new int[n + 10];
        
        for (int i = 1; i <= n; i++) {
            String[] strArray = br.readLine().split(" ");
            t[i] = Integer.parseInt(strArray[0]);
            p[i] = Integer.parseInt(strArray[1]);
        }

        for (int i = 1; i <= n + 1; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            dp[t[i] + i] = Math.max(dp[t[i] + i], dp[i] + p[i]);
        }

        System.out.println(dp[n + 1]);
    }
}