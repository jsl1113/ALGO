import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][n / 2 + 1];

        if(n == 1){
            System.out.println(1);
            return;
        } else if(n == 2){
            System.out.println(2);
            return;
        } else if(n == 3){
            System.out.println(3);
            return;
        }

        dp[1][0] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[3][0] = 1;
        dp[3][1] = 2;

        for (int i = 4; i <= n; i++) {
            dp[i][0] = 1;
            dp[i][1] = i - 1;
            for (int j = 2; j <= i / 2; j++) {
                if (i % 2 == 0 && j == i / 2) dp[i][j] = 1;
                dp[i][j] = (dp[i - 2][j - 1] + dp[i - 1][j]) % 10007;
            }
        }

        System.out.println((Arrays.stream(dp[n]).sum()) % 10007);
    }
}