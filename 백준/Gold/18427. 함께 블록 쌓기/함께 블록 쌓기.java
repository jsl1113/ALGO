import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken()); 
        int[][] dp = new int[n + 1][h + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            dp[i - 1][0] = 1;
            
            int cnt = st.countTokens();
            for (int j = 0; j < cnt; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                
                for (int k = tmp; k <= h; k++) {
                    dp[i][k] = (dp[i][k] + dp[i - 1][k - tmp]) % 10007;
                }
            }
            
            for (int k = 1; k <= h; k++) {
                dp[i][k] = (dp[i][k] + dp[i - 1][k]) % 10007;
            }

        }

        System.out.println(dp[n][h]);
    }
}