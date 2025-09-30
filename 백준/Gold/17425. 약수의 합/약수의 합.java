import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long dp[] = new long[1_000_001];
        Arrays.fill(dp, 1L);
        
        for (int i = 2; i < 1_000_001; i++) {
            dp[i] += dp[i - 1];

            for (int j = 1; i * j < 1_000_001; j++) {
                dp[i * j] += i;
            }
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
