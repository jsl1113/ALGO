import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Integer> vip = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            vip.add(Integer.parseInt(br.readLine()));
        }

        if(n <= 2) {
            System.out.println(n);
            return;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1; 
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (vip.contains(i) || vip.contains(i - 1)) dp[i] = dp[i - 1];
            else dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);
    }
}
